package br.com.delivery.delivery;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static br.com.delivery.delivery.application.constants.SwaggerConstants.*;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = SWAGGER_TITLE,
                description = SWAGGER_DESCRIPTION,
                version = SWAGGER_VERSION,
                license = @License(
                        name = SWAGGER_META_INFO_LICENSE,
                        url = SWAGGER_META_INFO_LICENSE_URL
                ),
                contact = @Contact(
                        name = SWAGGER_CONTACT_NAME,
                        url = SWAGGER_CONTACT_URL
                )
        )
)
public class DeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeliveryApplication.class, args);
    }

}
