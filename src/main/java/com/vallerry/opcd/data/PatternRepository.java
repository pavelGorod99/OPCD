package com.vallerry.opcd.data;

import com.vallerry.opcd.model.Pattern;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatternRepository extends CrudRepository<Pattern, Long> {}
