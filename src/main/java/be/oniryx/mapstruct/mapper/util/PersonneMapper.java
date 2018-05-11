package be.oniryx.mapstruct.mapper.util;


import be.oniryx.mapstruct.dto.Adresse;
import be.oniryx.mapstruct.dto.Personne;
import be.oniryx.mapstruct.model.AdresseModel;
import be.oniryx.mapstruct.model.PersonneModel;
import org.mapstruct.*;

@Mapper(uses = {DateHelper.class})
public abstract class PersonneMapper {


    @Mappings({
            @Mapping(source ="adresse", target = "adresseModel")
    })
    abstract PersonneModel toDto(Personne personne);


    @Mappings({
            @Mapping(source ="adresseModel", target = "adresse")
    })
    abstract Personne toModel(PersonneModel personne);

    @AfterMapping
     void afterpersonneModel(Personne dto, @MappingTarget PersonneModel mode){
        mode.getAdresseModel().setPersonne(mode);
    }


    abstract AdresseModel toDto(Adresse adresse);
}
