package com.arch.api.template.entrypoint.api;

import com.arch.api.template.core.usecase.ChangeNameUseCase;
import com.arch.api.template.core.usecase.FindAllPersonsUseCase;
import com.arch.api.template.core.usecase.SavePersonUseCase;
import com.arch.api.template.entrypoint.api.payloads.PersonDTORequest;
import com.arch.api.template.entrypoint.api.payloads.PersonDTOResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
public record PersonController(ChangeNameUseCase changeNameUseCase,
                               FindAllPersonsUseCase findAllPersonsUseCase,
                               SavePersonUseCase savePersonUseCase) {

    @GetMapping
    public ResponseEntity<List<PersonDTOResponse>> findAll() {
        return ResponseEntity.ok(findAllPersonsUseCase.execute());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDTOResponse> changeName(@PathVariable String id, @Valid @RequestBody PersonDTORequest personDTORequest) {
        return ResponseEntity.ok(changeNameUseCase.execute(id, personDTORequest));
    }

    @PostMapping
    public ResponseEntity<PersonDTOResponse> save(@RequestBody @Valid PersonDTORequest requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body((savePersonUseCase.execute(requestDTO)));
    }

}
