package com.example.vaultapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

import java.util.HashMap;
import java.util.Map;

@Service
public class VaultService {

    @Autowired
    private VaultTemplate vaultTemplate;

    // Method to write a secret to Vault
    public String writeSecret(String secretPath, String key, String value) {
        Map<String, Object> secretData = new HashMap<>();
        secretData.put(key, value);

        // Write the secret to Vault at the specified path
        VaultResponse response = vaultTemplate.write(secretPath, secretData);
        return response != null ? "Secret written successfully!" : "Failed to write secret.";
    }
}
