package com.arch.api.template.core.mapper;

import com.arch.api.template.core.domain.Person;
import com.arch.api.template.entrypoint.dto.PersonDTORequest;
import com.arch.api.template.entrypoint.dto.PersonDTOResponse;

public class PersonDomainMapper {

    public static PersonDTOResponse domainToResponseDTO(Person person) {
        return PersonDTOResponse.builder().name(person.getName()).build();
    }

    public static Person requestToDomain(PersonDTORequest dto) {
        return Person.builder().name(dto.getName()).build();
    }

}
