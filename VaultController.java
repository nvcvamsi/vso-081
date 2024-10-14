package com.example.vaultapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VaultController {

    @Autowired
    private VaultService vaultService;

    // Endpoint to write a secret to Vault
    @PostMapping("/write-secret")
    public String writeSecret(
            @RequestParam String secretPath,
            @RequestParam String key,
            @RequestParam String value) {
        return vaultService.writeSecret(secretPath, key, value);
    }
}
