package be.onitys.mapstruct;

import be.oniryx.mapstruct.dto.Personne;
import be.oniryx.mapstruct.mapper.PersonneMapper;
import be.oniryx.mapstruct.model.PersonneModel;

import javax.inject.Inject;

public class UseJava {


    private PersonneMapper personneMapper;// = PersonneMapper.mapper;

    public void testMapping(){
        PersonneModel personneModel = new PersonneModel();
        Personne personne = personneMapper.toDto(personneModel);
    }
}
