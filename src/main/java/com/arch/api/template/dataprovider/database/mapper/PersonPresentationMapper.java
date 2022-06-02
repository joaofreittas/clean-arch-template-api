package com.arch.api.template.dataprovider.database.mapper;

import com.arch.api.template.core.domain.Person;
import com.arch.api.template.dataprovider.database.presentation.PersonPresentation;

public class PersonPresentationMapper {

    public static Person presentationToDomain(PersonPresentation presentation) {
        return Person.builder()
            .name(presentation.getName())
            .build();
    }

    public static PersonPresentation domainToPresentation(Person domain) {
        return PersonPresentation.builder()
            .name(domain.getName())
            .build();
    }

}
