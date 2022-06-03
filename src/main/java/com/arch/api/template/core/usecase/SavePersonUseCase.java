package com.arch.api.template.core.usecase;

import com.arch.api.template.core.domain.Person;
import com.arch.api.template.core.gateway.PersonGateway;
import com.arch.api.template.core.mapper.PersonDomainMapper;
import com.arch.api.template.entrypoint.api.payloads.PersonDTORequest;
import com.arch.api.template.entrypoint.api.payloads.PersonDTOResponse;

public record SavePersonUseCase(PersonGateway personGateway) {

    public PersonDTOResponse execute(PersonDTORequest requestDTO) {
        Person person = PersonDomainMapper.requestToDomain(requestDTO);
        return PersonDomainMapper.domainToResponseDTO(personGateway.save(person));
    }

}