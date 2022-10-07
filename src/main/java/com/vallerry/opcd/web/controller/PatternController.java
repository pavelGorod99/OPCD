package com.vallerry.opcd.web.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vallerry.opcd.model.Paragraph;
import com.vallerry.opcd.model.Pattern;
import com.vallerry.opcd.service.ParagraphService;
import com.vallerry.opcd.service.PatternService;
import com.vallerry.opcd.service.StorageService;
import com.vallerry.opcd.utils.FileUploadUtil;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

@CrossOrigin
@RestController
public class PatternController {

    private PatternService patternService;
    private ParagraphService paragraphService;
    private StorageService storageService;

//    private String FOLDER_STORAGE = "src/main/resources/images/pattern";
    private String FOLDER_STORAGE = "images/pattern/";

    public PatternController(PatternService patternService,
                             ParagraphService paragraphService,
                             StorageService storageService) {
        this.patternService = patternService;
        this.paragraphService = paragraphService;
        this.storageService = storageService;
    }

    @ResponseBody
    @GetMapping("/paragraphs")
    public Iterable<Paragraph> getParagraphs(@RequestParam int page, @RequestParam int paragraphCount) {
        return paragraphService.findAllOnPage(page, paragraphCount);
    }

    @ResponseBody
    @GetMapping(value = "/paragraphs_by_pattern_id_pageable")
    public Optional<Iterable<Paragraph>> getParagraphsByPatternIdPageable(@RequestParam Long patternId,
                                                                  @RequestParam int page,
                                                                  @RequestParam int paragraphCount) {
        Pattern pattern = patternService.findById(patternId).get();
        return paragraphService.findAllByPattern(pattern, page, paragraphCount);
    }

    @ResponseBody
    @GetMapping(value = "/paragraphs_by_pattern_id_and_title_pageable")
    public Optional<Iterable<Paragraph>> getParagraphsByPatternIdAndNamePageable(@RequestParam Long patternId,
                                                                          @RequestParam int page,
                                                                          @RequestParam int paragraphCount,
                                                                          @RequestParam String title) {
        Pattern pattern = patternService.findById(patternId).get();
        return paragraphService.findAllByPatternAndTitleContains(pattern, page, paragraphCount, title);
    }

    @ResponseBody
    @GetMapping(value = "/paragraphs_by_pattern_id")
    public Optional<Iterable<Paragraph>> getParagraphsByPatternId(@RequestParam Long patternId) {
        Pattern pattern = patternService.findById(patternId).get();
        return paragraphService.findAllByPattern(pattern);
    }

    @ResponseBody
    @GetMapping(value = "/paragraph_by_id")
    public Optional<Paragraph> getParagraphById(@RequestParam Long paragraphId) {
        return paragraphService.findById(paragraphId);
    }


    @PutMapping(value = "/update_paragraph")
    public void updateParagraph(@RequestParam(value = "file", required = false) MultipartFile file,
                                @RequestParam("oldImage") String oldImage,
                                @RequestParam("paragraph") String stringPar) throws IOException {

        System.out.println(file);
        System.out.println(oldImage);

        JsonObject jsonObject = new JsonParser().parse(stringPar).getAsJsonObject();

        Paragraph paragraph = paragraphService.findById(jsonObject.get("id").getAsLong()).get();
        paragraph.setTitle(jsonObject.get("title").getAsString());
        paragraph.setDescription(jsonObject.get("description").getAsString());

        System.out.println("PARAGRAPH ID: " + paragraph.getId());

        FOLDER_STORAGE = FOLDER_STORAGE + paragraph.getId();

        System.out.println("FOLDER STORAGE: " + FOLDER_STORAGE);

        if (file != null) {
            System.out.println(file.getOriginalFilename());
            System.out.println("FOLDER TO DELETE: " + oldImage);
            File fileForDelete = new File(oldImage);
            if (fileForDelete.exists()) {
                fileForDelete.delete();
            }
            FileUploadUtil.saveFile(FOLDER_STORAGE, file.getOriginalFilename(), file);
            System.out.println("PATH WHERE TO SAVE THE FILE: " + FOLDER_STORAGE + "/" + file.getOriginalFilename());
            paragraph.setImagePath(FOLDER_STORAGE + "/" + file.getOriginalFilename());
        }
        paragraphService.update(paragraph);

        FOLDER_STORAGE = "images/pattern/";
    }

    @PostMapping(value = "/create_paragraph")
    public void createParagraph(@RequestParam(value = "file") MultipartFile file,
                                @RequestParam("paragraph") String stringPar) throws IOException {

        System.out.println(stringPar);

        JsonObject jsonObject = new JsonParser().parse(stringPar).getAsJsonObject();

        Paragraph paragraph = new Paragraph();

        paragraph.setTitle(jsonObject.get("title").getAsString());
        paragraph.setDescription(jsonObject.get("description").getAsString());
        paragraph.setImagePath("tmp");

        JsonObject patternToFind = jsonObject.get("pattern").getAsJsonObject();
        Pattern pattern = patternService.findById(patternToFind.get("id").getAsLong()).get();
        paragraph.setPattern(pattern);

        Paragraph newParagraph = paragraphService.save(paragraph);

        FOLDER_STORAGE = FOLDER_STORAGE + newParagraph.getId();
        FileUploadUtil.saveFile(FOLDER_STORAGE, file.getOriginalFilename(), file);

        newParagraph.setImagePath(FOLDER_STORAGE + "/" + file.getOriginalFilename());
        paragraphService.save(newParagraph);

        FOLDER_STORAGE = "images/pattern/";
    }

    @CrossOrigin
    @DeleteMapping(value = "delete_paragraph")
    public void deleteParagraph(@RequestParam Long paragraphId) throws IOException {

        FileUploadUtil.deleteFolder(FOLDER_STORAGE + "/" + paragraphId);
        paragraphService.deleteById(paragraphId);
    }

    @PutMapping(value = "/upload_file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            storageService.save(file, String.valueOf(4));
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    @PostMapping("/test_media")
    public void testMedia(@RequestParam("imageFile") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
    }

    @ResponseBody
    @GetMapping("/patterns")
    public Iterable<Pattern> getPatterns() {
        return patternService.findAll();
    }
}
