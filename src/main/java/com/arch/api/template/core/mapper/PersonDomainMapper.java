package com.arch.api.template.core.mapper;

import com.arch.api.template.core.domain.Person;
import com.arch.api.template.entrypoint.api.payloads.PersonDTORequest;
import com.arch.api.template.entrypoint.api.payloads.PersonDTOResponse;

public class PersonDomainMapper {

    public static PersonDTOResponse domainToResponseDTO(Person person) {
        return PersonDTOResponse.builder().name(person.getName()).build();
    }

    public static Person requestToDomain(PersonDTORequest dto) {
        return Person.builder().name(dto.getName()).build();
    }

}
