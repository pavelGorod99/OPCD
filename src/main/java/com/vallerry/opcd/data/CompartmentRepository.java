package com.vallerry.opcd.data;

import com.vallerry.opcd.model.Compartment;
import com.vallerry.opcd.model.CompartmentWithIdTitleAndImage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompartmentRepository extends CrudRepository<Compartment, Long> {
    @Query(value = "SELECT id, title, image_url AS imageUrl FROM `compartments`", nativeQuery = true)
    Iterable<CompartmentWithIdTitleAndImage> findAllWithIdTitleAndImage();
}
