package com.vallerry.opcd.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileStorageService {
    void init();
    void save(MultipartFile file, String parentFolder);
    Stream<Path> loadAll();
    Resource load(String filename);
    void deleteAll();
}
