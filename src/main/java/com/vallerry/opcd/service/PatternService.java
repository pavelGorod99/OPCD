package com.vallerry.opcd.service;

import com.vallerry.opcd.data.PatternRepository;
import com.vallerry.opcd.model.Pattern;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatternService {

    private final PatternRepository patternRepository;

    public PatternService(PatternRepository patternRepository) {
        this.patternRepository = patternRepository;
    }

    public Iterable<Pattern> findAll() {
        return patternRepository.findAll();
    }

    public Optional<Pattern> findById(Long id) {
        return patternRepository.findById(id);
    }
}
