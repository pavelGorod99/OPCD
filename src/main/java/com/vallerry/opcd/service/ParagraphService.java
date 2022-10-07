package com.vallerry.opcd.service;

import com.vallerry.opcd.data.ParagraphRepository;
import com.vallerry.opcd.model.Paragraph;
import com.vallerry.opcd.model.Pattern;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParagraphService {

    private final ParagraphRepository paragraphRepository;

    public ParagraphService(ParagraphRepository paragraphRepository) {
        this.paragraphRepository = paragraphRepository;
    }

    public Optional<Iterable<Paragraph>> findAllByPattern(Pattern pattern,
                                                          int page,
                                                          int paragraphCount) {
        Pageable onPage = PageRequest.of(page, paragraphCount);
        return Optional.ofNullable(paragraphRepository.findAllByPattern(pattern, onPage));
    }

    public Optional<Iterable<Paragraph>> findAllByPatternAndTitleContains(Pattern pattern,
                                                          int page,
                                                          int paragraphCount, String title) {
        Pageable onPage = PageRequest.of(page, paragraphCount);
        System.out.println(title);
        return Optional.ofNullable(paragraphRepository.findAllByPatternAndTitleContains(pattern, title, onPage));
    }

    public Optional<Iterable<Paragraph>> findAllByPattern(Pattern pattern) {
        return Optional.ofNullable(paragraphRepository.findAllByPattern(pattern));
    }

    public Iterable<Paragraph> findAllOnPage(int page, int paragraphCount) {
        Pageable onPage = PageRequest.of(page, paragraphCount);
        return paragraphRepository.findAll(onPage);
    }

    public Optional<Paragraph> findById(Long id) {
        return paragraphRepository.findById(id);
    }

    public void update(Paragraph paragraph) {
        paragraphRepository.save(paragraph);
    }

    public Paragraph save(Paragraph paragraph) {
        return paragraphRepository.save(paragraph);
    }

    public void deleteById(Long paragraphId) {
        paragraphRepository.deleteById(paragraphId);
    }
}
