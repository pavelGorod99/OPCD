package com.vallerry.opcd.data;

import com.vallerry.opcd.model.WelcomePoster;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WelcomePosterRepository extends CrudRepository<WelcomePoster, Long> {
}
