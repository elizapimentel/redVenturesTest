package com.redventures.elizaTest.servicesTest;

import com.redventures.elizaTest.model.Broth;
import com.redventures.elizaTest.model.Protein;
import com.redventures.elizaTest.repositories.BrothRepository;
import com.redventures.elizaTest.repositories.ProteinRepository;
import com.redventures.elizaTest.services.RamenItemsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class RamenItemsServiceImplTest {

    public static final Long BROTH_ID                   = 1L;
    public static final Long PROTEIN_ID                 = 2L;
    public static final String BROTH_NAME               = "Salt";
    public static final String PROTEIN_NAME             = "Pork";
    public static final String DESCRIPTION              = "Simple like the seawater, nothing more";
    public static final Number PRICE                    = 10;

    public static final String IMAGE_1                  = "https://tech.redventures.com.br/icons/salt/inactive.svg";
    public static final String IMAGE_2                  = "https://tech.redventures.com.br/icons/salt/active.svg";


    @InjectMocks
    private RamenItemsServiceImpl service;

    @Mock
    private BrothRepository brothRepo;

    @Mock
    private ProteinRepository proteinRepo;

    private Broth broth;
    private Protein protein;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        generateRamen();
    }

    @Test
    void mustGetAllBrothsOk() {

        when(brothRepo.findAll()).thenReturn(List.of(broth));

        List<Broth> res = service.getAllBroths();

        assertNotNull(res);

    }

    @Test
    void mustGetAllProteinsOk() {

        when(proteinRepo.findAll()).thenReturn(List.of(protein));

        List<Protein> res = service.getAllProteins();

        assertNotNull(res);
    }

    private void generateRamen() {
        broth = new Broth(BROTH_ID, IMAGE_1, IMAGE_2, BROTH_NAME, DESCRIPTION, PRICE);
        protein = new Protein(PROTEIN_ID, IMAGE_1, IMAGE_2, BROTH_NAME, DESCRIPTION, PRICE);
    }

}
