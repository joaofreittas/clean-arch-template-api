package com.arch.api.template.core.usecase;

import com.arch.api.template.core.domain.Person;
import com.arch.api.template.core.gateway.PersonGateway;
import com.arch.api.template.entrypoint.dto.PersonDTORequest;
import com.arch.api.template.entrypoint.dto.PersonDTOResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ChangeNameUseCaseTest {

    @InjectMocks
    private ChangeNameUseCase changeNameUseCase;

    @Mock
    private PersonGateway personGateway;

    @Test
    public void should_change_name_with_success_when_name_is_valid() {
        String id = "1";
        String expectedName = "Lucas";
        PersonDTORequest personDTORequest = PersonDTORequest.builder()
            .name(expectedName)
            .build();
        Person personResult = Person.builder()
            .name("Lucas")
            .build();
        when(personGateway.changeName(id, personDTORequest.getName())).thenReturn(personResult);

        PersonDTOResponse response = changeNameUseCase.execute(id, personDTORequest);

        assertEquals(expectedName, response.getName());
        verify(personGateway, times(1)).changeName(id, personDTORequest.getName());
    }
}