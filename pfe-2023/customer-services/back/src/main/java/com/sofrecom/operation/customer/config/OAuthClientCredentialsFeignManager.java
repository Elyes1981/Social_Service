package com.sofrecom.operation.customer.config;

public class OAuthClientCredentialsFeignManager {
/*
    private final OAuth2AuthorizedClientManager manager;
    private final ClientRegistration clientRegistration;

    private final Logger logger = LoggerFactory.getLogger(OAuthClientCredentialsFeignManager.class);


    public OAuthClientCredentialsFeignManager(OAuth2AuthorizedClientManager manager, ClientRegistration clientRegistration) {
        this.manager = manager;
        this.clientRegistration = clientRegistration;
    }


    public String getAccessToken() {
        try {
            OAuth2AuthorizeRequest oAuth2AuthorizeRequest = OAuth2AuthorizeRequest
                    .withClientRegistrationId(clientRegistration.getRegistrationId())
                    .build();
            OAuth2AuthorizedClient client = manager.authorize(oAuth2AuthorizeRequest);
            if (client==null) {
                throw new IllegalStateException("client credentials flow on " + clientRegistration.getRegistrationId() + " failed, client is null");
            }
            return client.getAccessToken().getTokenValue();
        } catch (Exception exp) {
            logger.error("client credentials error " + exp.getMessage());
        }
        return null;
    }*/
}
