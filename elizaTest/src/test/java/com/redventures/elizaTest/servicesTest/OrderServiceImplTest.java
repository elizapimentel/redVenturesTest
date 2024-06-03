package com.redventures.elizaTest.servicesTest;

import com.redventures.elizaTest.dto.OrderRequestDTO;
import com.redventures.elizaTest.dto.OrderResponseDTO;
import com.redventures.elizaTest.model.Broth;
import com.redventures.elizaTest.model.Protein;
import com.redventures.elizaTest.repositories.BrothRepository;
import com.redventures.elizaTest.repositories.ProteinRepository;
import com.redventures.elizaTest.services.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class OrderServiceImplTest {

    public static final Long BROTH_ID                   = 1L;
    public static final Long PROTEIN_ID                 = 2L;
    public static final String BROTH_NAME               = "Salt";
    public static final String PROTEIN_NAME             = "Pork";
    public static final String IMAGE_1                  = "https://tech.redventures.com.br/icons/ramen/https://tech.redventures.com.br/icons/pork/active.svg";


    @InjectMocks
    private OrderServiceImpl service;
    @Mock
    private BrothRepository brothRepo;
    @Mock
    private ProteinRepository proteinRepo;

    private OrderRequestDTO reqDTO;

    private Broth broth;
    private Protein protein;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        generateRamen();
    }

    @Test
    void mustCreateNewOrderOk() {

        broth.setId(BROTH_ID);
        broth.setName(BROTH_NAME);

        protein.setId(PROTEIN_ID);
        protein.setName(PROTEIN_NAME);

        when(brothRepo.findById(BROTH_ID)).thenReturn(Optional.of(broth));
        when(proteinRepo.findById(PROTEIN_ID)).thenReturn(Optional.of(protein));

        String description = BROTH_NAME + " and " + PROTEIN_NAME + " Ramen";
        String image = "https://tech.redventures.com.br/icons/ramen/" + IMAGE_1;

        OrderResponseDTO res =service.createOrder(reqDTO);

        assertNotNull(res);
        assertNotNull(res.getId());
        assertTrue(res.getId().matches("\\d{5}")); // Check if the ID is a 5-digit number
        assertNotNull(res.getDescription());
        assertNotNull(res.getImage());

    }

    private void generateRamen() {
        reqDTO = new OrderRequestDTO();
        broth = new Broth();
        protein = new Protein();
        reqDTO.setBrothId(BROTH_ID);
        reqDTO.setProteinId(PROTEIN_ID);
    }

}
