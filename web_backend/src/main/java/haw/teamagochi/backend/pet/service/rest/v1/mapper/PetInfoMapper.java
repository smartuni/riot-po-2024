package haw.teamagochi.backend.pet.service.rest.v1.mapper;

import haw.teamagochi.backend.pet.dataaccess.model.PetEntity;
import haw.teamagochi.backend.pet.service.rest.v1.model.PetInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel="cdi")
public interface PetInfoMapper {

  //PetInfoDTO toResource(PetEntity pet);
}