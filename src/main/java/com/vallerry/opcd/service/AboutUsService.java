package com.vallerry.opcd.service;

import com.vallerry.opcd.data.CompartmentPostRepository;
import com.vallerry.opcd.data.CompartmentRepository;
import com.vallerry.opcd.data.MissionRepository;
import com.vallerry.opcd.data.PartnerRepository;
import com.vallerry.opcd.model.Compartment;
import com.vallerry.opcd.model.CompartmentPost;
import com.vallerry.opcd.model.MissionPost;
import com.vallerry.opcd.model.Partner;
import org.springframework.stereotype.Service;

@Service
public class AboutUsService {

    private final MissionRepository missionRepository;
    private final CompartmentRepository compartmentRepository;
    private final CompartmentPostRepository compartmentPostRepository;
    private final PartnerRepository partnerRepository;

    public AboutUsService(MissionRepository missionRepository, CompartmentRepository compartmentRepository, CompartmentPostRepository compartmentPostRepository, PartnerRepository partnerRepository) {
        this.missionRepository = missionRepository;
        this.compartmentRepository = compartmentRepository;
        this.compartmentPostRepository = compartmentPostRepository;
        this.partnerRepository = partnerRepository;
    }

    public Iterable<MissionPost> findAllMissionPosts() {
        return missionRepository.findAll();
    }

    public Iterable<Compartment> findAllCompartments() {
        return compartmentRepository.findAll();
    }

    public Iterable<CompartmentPost> findAllCompartmentPostsByCompartmentId(Long id) {
        return compartmentPostRepository.findAllWhereCompartmentId(id);
    }

    public Iterable<Partner> findAllPartners() {
        return partnerRepository.findAll();
    }
}
