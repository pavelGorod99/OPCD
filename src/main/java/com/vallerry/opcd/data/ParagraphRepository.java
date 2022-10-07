package com.vallerry.opcd.data;

import com.vallerry.opcd.model.Paragraph;
import com.vallerry.opcd.model.Pattern;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParagraphRepository extends PagingAndSortingRepository<Paragraph, Long> {
    Page<Paragraph> findAllByPattern(Pattern pattern, Pageable pageable);
    Iterable<Paragraph> findAllByPattern(Pattern pattern);
    Page<Paragraph> findAllByPatternAndTitleContains(Pattern pattern, String title, Pageable pageable);
}
