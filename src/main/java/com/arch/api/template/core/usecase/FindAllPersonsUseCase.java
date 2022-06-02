package com.arch.api.template.core.usecase;

import com.arch.api.template.core.gateway.PersonGateway;
import com.arch.api.template.core.mapper.PersonDomainMapper;
import com.arch.api.template.entrypoint.dto.PersonDTOResponse;

import java.util.List;
import java.util.stream.Collectors;

public record FindAllPersonsUseCase(PersonGateway personGateway) {

    public List<PersonDTOResponse> execute() {
        return personGateway
            .findAll()
            .stream()
            .map(PersonDomainMapper::domainToResponseDTO)
            .collect(Collectors.toList());
    }

}
