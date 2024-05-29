package com.redventures.elizaTest.services;

import com.redventures.elizaTest.model.Broth;
import com.redventures.elizaTest.model.Protein;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RamenItemsService {
    List<Broth> getAllBroths();
    List<Protein> getAllProteins();
    Broth postNewBroth(Broth broth);
    Protein postNewProtein(Protein protein);


}
