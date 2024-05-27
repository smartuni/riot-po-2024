package haw.teamagochi.backend.pet;

import haw.teamagochi.backend.pet.dataaccess.model.PetEntity;
import haw.teamagochi.backend.pet.dataaccess.model.PetTypeEntity;
import haw.teamagochi.backend.pet.dataaccess.repository.PetRepository;
import haw.teamagochi.backend.pet.dataaccess.repository.PetTypeRepository;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import io.quarkus.test.h2.H2DatabaseTestResource;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)

public class PetRepositoryTest {

  @Inject
  PetRepository petRepository;

  @Inject
  PetTypeRepository petTypeRepository;

  private static PetEntity defaultPet;
  private static PetTypeEntity defaultPetType;

  @BeforeAll
  public static void beforeAll() {
    defaultPetType = new PetTypeEntity();
    defaultPet = new PetEntity(
        "petname",
        //"fakecolor",
        defaultPetType
    );
  }


  @BeforeEach
  @Transactional
  public void beforeEach() {

    // Deletion order important?
    petRepository.deleteAll();
    petTypeRepository.deleteAll();


  }


  /*
  @Test
  public void testColorRegex() {
    Assertions.assertThrows(Exception.class, ()-> defaultPet.setColor("wrong_color_syntax"));
  }
   */


  @Test
  @Transactional
  public void testHibernatePersistence() {

    petTypeRepository.persist(defaultPetType);
    petRepository.persist(defaultPet);

    String oldName = defaultPet.getName();
    String newName = "new pet name";

    defaultPet.setName(newName);
    PetEntity persistedPet = petRepository.findById(defaultPet.getId());

    Assertions.assertEquals(newName, persistedPet.getName());
  }





}