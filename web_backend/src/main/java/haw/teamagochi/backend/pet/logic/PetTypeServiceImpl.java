package haw.teamagochi.backend.pet.logic;

import haw.teamagochi.backend.pet.dataaccess.model.PetTypeEntity;
import haw.teamagochi.backend.pet.dataaccess.repository.PetTypeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PetTypeServiceImpl implements PetTypeService {

  @Inject
  PetTypeRepository petTypeRepository;

  public PetTypeEntity createPetType(String name) {
    PetTypeEntity petType = new PetTypeEntity(name);
    petTypeRepository.persist(petType);
    return petType;
  }
}
