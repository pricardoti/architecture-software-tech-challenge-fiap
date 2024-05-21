package br.com.delivery.delivery.application.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

public final class Constants {

    private Constants() {
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class SwaggerApi {

        public static final String SWAGGER_TITLE = "API REST Delivery";
        public static final String SWAGGER_DESCRIPTION = "API responsável por gerenciar um delivery de uma lanchonete";
        public static final String SWAGGER_VERSION = "1.0.0";

    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class SwaggerApiContact {

        public static final String SWAGGER_CONTACT_NAME = "Grupo 15: Nicholas Mateus / Paulo Ricardo / Tarcisio Dantas";
        public static final String SWAGGER_CONTACT_URL = "https://github.com/pricardoti/architecture-software-tech-challenge-fiap";

    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class SwaggerApiMetaInfo {

        public static final String SWAGGER_META_INFO_LICENSE = "MIT";
        public static final String SWAGGER_META_INFO_LICENSE_URL = "https://opensource.org/license/MIT";

    }
}
