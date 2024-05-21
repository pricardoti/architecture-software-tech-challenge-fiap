package br.com.delivery.delivery;

import br.com.delivery.delivery.application.constants.Constants;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = Constants.SwaggerApi.SWAGGER_TITLE,
                description = Constants.SwaggerApi.SWAGGER_DESCRIPTION,
                version = Constants.SwaggerApi.SWAGGER_VERSION,
                license = @License(
                        name = Constants.SwaggerApiMetaInfo.SWAGGER_META_INFO_LICENSE,
                        url = Constants.SwaggerApiMetaInfo.SWAGGER_META_INFO_LICENSE_URL
                ),
                contact = @Contact(
                        name = Constants.SwaggerApiContact.SWAGGER_CONTACT_NAME,
                        url = Constants.SwaggerApiContact.SWAGGER_CONTACT_URL
                )
        )
)
public class DeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeliveryApplication.class, args);
    }

}
