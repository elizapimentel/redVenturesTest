package com.redventures.elizaTest.services;

import com.redventures.elizaTest.model.Broth;
import com.redventures.elizaTest.model.Protein;
import com.redventures.elizaTest.repositories.BrothRepository;
import com.redventures.elizaTest.repositories.ProteinRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RamenItemsServiceImpl implements RamenItemsService {

    private final BrothRepository brothRepo;
    private final ProteinRepository proteinRepo;


    @Override
    public List<Broth> getAllBroths() {
        return brothRepo.findAll();
    }

    @Override
    public List<Protein> getAllProteins() {
        return proteinRepo.findAll();
    }

    @Transactional
    @Override
    public Broth postNewBroth(Broth broth) {
        return brothRepo.save(broth);
    }

    @Transactional
    @Override
    public Protein postNewProtein(Protein protein) {
        return proteinRepo.save(protein);
    }


}
