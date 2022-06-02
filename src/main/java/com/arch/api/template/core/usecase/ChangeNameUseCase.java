package com.arch.api.template.core.usecase;

import com.arch.api.template.core.gateway.PersonGateway;
import com.arch.api.template.core.mapper.PersonDomainMapper;
import com.arch.api.template.entrypoint.dto.PersonDTORequest;
import com.arch.api.template.entrypoint.dto.PersonDTOResponse;

public record ChangeNameUseCase(PersonGateway personGateway) {

    public PersonDTOResponse execute(String id, PersonDTORequest personDTORequest) {
        personDTORequest.setId(id);

        return PersonDomainMapper.domainToResponseDTO(
            personGateway.changeName(
            personDTORequest.getId(),
            personDTORequest.getName()));
    }

}