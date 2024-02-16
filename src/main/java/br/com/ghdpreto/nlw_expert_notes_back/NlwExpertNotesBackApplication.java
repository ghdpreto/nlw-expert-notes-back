package br.com.ghdpreto.nlw_expert_notes_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "NLW Expert notas", description = "API para registro de notas e lembretes.")

)
public class NlwExpertNotesBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(NlwExpertNotesBackApplication.class, args);
	}

}
