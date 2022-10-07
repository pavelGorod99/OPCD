package com.vallerry.opcd.data;

import com.vallerry.opcd.model.CompartmentPost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CompartmentPostRepository extends CrudRepository<CompartmentPost, Long> {
    @Query(value = "SELECT id, post_title, post_description, post_image_url FROM `compartment_post` WHERE compartment_id = ?1", nativeQuery = true)
    Iterable<CompartmentPost> findAllWhereCompartmentId(Long id);
}
