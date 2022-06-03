package com.arch.api.template.entrypoint.api.payloads;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTORequest {

    private String id;

    @NotBlank
    private String name;

}
