package com.sofrecom.operation.customer.config;


//@Configuration
public class OAuthFeignConfig {


   /* public static final String CLIENT_REGISTRATION_ID = "keycloak";

    private final OAuth2AuthorizedClientService oAuth2AuthorizedClientService;
    private final ClientRegistrationRepository clientRegistrationRepository;
    private final OAuth2AuthorizedClientRepository authorizedClientRepository;

    public OAuthFeignConfig(OAuth2AuthorizedClientService oAuth2AuthorizedClientService,
                            ClientRegistrationRepository clientRegistrationRepository,
                            OAuth2AuthorizedClientRepository authorizedClientRepository) {
        this.oAuth2AuthorizedClientService = oAuth2AuthorizedClientService;
        this.clientRegistrationRepository = clientRegistrationRepository;
        this.authorizedClientRepository = authorizedClientRepository;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        ClientRegistration clientRegistration = clientRegistrationRepository.findByRegistrationId(CLIENT_REGISTRATION_ID);
        OAuthClientCredentialsFeignManager clientCredentialsFeignManager =
                new OAuthClientCredentialsFeignManager(authorizedClientManager(), clientRegistration);
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Bearer " + clientCredentialsFeignManager.getAccessToken());
        };
    }

    @Bean
    public OAuth2AuthorizedClientManager authorizedClientManager() {
        return new DefaultOAuth2AuthorizedClientManager(
                clientRegistrationRepository, authorizedClientRepository);
    }*/

  /*  public static RestTemplate restTemplate = new RestTemplate();

    public static final String USERNAME = "emna";

    public static final String PASSWORD = "ben taher";


    public static String getToken() {

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8088/token"; // Remplacez l'URL par celle de votre premier microservice

        String username = "emna";

        String password = "emna123";

        String authHeader = "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", authHeader);

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        return response.getBody(); // Renvoie le corps de la réponse, qui devrait contenir le token JWT

    }

    @Bean
    public static RequestInterceptor requestInterceptor () {

        return template -> {

            String token=OAuthFeignConfig.getToken();

            template.header("Authorization", "Bearer " + token);

        };

    }
*/

}
