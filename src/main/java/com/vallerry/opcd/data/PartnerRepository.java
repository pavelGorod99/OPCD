package com.vallerry.opcd.data;

import com.vallerry.opcd.model.Partner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends CrudRepository<Partner, Long> {
}
