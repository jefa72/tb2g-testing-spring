package org.springframework.samples.petclinic.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.samples.petclinic.repository.VisitRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class ClinicServiceImplTest {
    @Mock
    PetRepository petRepository;

    @Mock
    VetRepository vetRepository;

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    ClinicServiceImpl clinicService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findPetTypes() {
        //given
        List<PetType> petTypeList = new ArrayList<>();
        PetType petTypeA = new PetType();
        petTypeList.add(petTypeA);
        given(petRepository.findPetTypes()).willReturn(petTypeList);

        //when
        List<PetType> actualPetTypeList = (List<PetType>) clinicService.findPetTypes();

        //then
        then(petRepository).should().findPetTypes();
        assertThat(actualPetTypeList.size()).isEqualTo(1);
        assertThat(actualPetTypeList.get(0)).isEqualTo(petTypeA);
    }
}