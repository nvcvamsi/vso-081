package com.example.vaultapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.LdapAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;
import org.springframework.web.client.RestTemplate;

@Configuration
public class VaultConfig {

    @Bean
    public VaultTemplate vaultTemplate(LdapAuthentication ldapAuthentication, VaultEndpoint vaultEndpoint) {
        return new VaultTemplate(vaultEndpoint, ldapAuthentication);
    }
}
