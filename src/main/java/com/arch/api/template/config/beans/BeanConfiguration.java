package com.arch.api.template.config.beans;

import com.arch.api.template.core.gateway.PersonGateway;
import com.arch.api.template.core.usecase.ChangeNameUseCase;
import com.arch.api.template.core.usecase.FindAllPersonsUseCase;
import com.arch.api.template.core.usecase.SavePersonUseCase;
import com.arch.api.template.dataprovider.database.gateway.PersonGatewayImpl;
import com.arch.api.template.dataprovider.database.repository.PersonMongoDBRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public PersonGateway personGateway(PersonMongoDBRepository personMongoDBRepository) {
        return new PersonGatewayImpl(personMongoDBRepository);
    }

    @Bean
    public ChangeNameUseCase changeNameUseCase(PersonGateway personGateway) {
        return new ChangeNameUseCase(personGateway);
    }

    @Bean
    public FindAllPersonsUseCase findAllPersonsUseCase(PersonGateway personGateway) {
        return new FindAllPersonsUseCase(personGateway);
    }

    @Bean
    public SavePersonUseCase savePersonUseCase(PersonGateway personGateway) {
        return new SavePersonUseCase(personGateway);
    }

}
