package com.vallerry.opcd.data;

import com.vallerry.opcd.model.MissionPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends CrudRepository<MissionPost, Long> {}
