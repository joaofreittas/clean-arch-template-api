package com.arch.api.template.dataprovider.database.gateway;

import com.arch.api.template.dataprovider.database.mapper.PersonPresentationMapper;
import com.arch.api.template.dataprovider.database.repository.PersonMongoDBRepository;
import com.arch.api.template.dataprovider.database.presentation.PersonPresentation;
import com.arch.api.template.core.domain.Person;
import com.arch.api.template.core.gateway.PersonGateway;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public record PersonGatewayImpl(PersonMongoDBRepository personMongoDBRepository) implements PersonGateway {

    @Override
    public List<Person> findAll() {
        return personMongoDBRepository
            .findAll()
            .stream()
            .map(PersonPresentationMapper::presentationToDomain)
            .collect(Collectors.toList());
    }

    @Override
    public Person save(final Person person) {
        final PersonPresentation personPresentation = PersonPresentationMapper.domainToPresentation(person);
        return PersonPresentationMapper.presentationToDomain(personMongoDBRepository.save(personPresentation));
    }

    @Override
    public Person changeName(final String id, final String newName) {
        final Optional<PersonPresentation> presentationOptional = personMongoDBRepository.findById(id);

        if (presentationOptional.isPresent()) {
            final PersonPresentation presentation = presentationOptional.get();
            presentation.setName(newName);
            return PersonPresentationMapper.presentationToDomain(personMongoDBRepository.save(presentation));
        }

        throw new RuntimeException("No has Person with this id: " + id);
    }

}
