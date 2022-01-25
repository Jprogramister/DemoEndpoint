package demo.tykendpoing.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GlobalTransactionIdProvider {
    public UUID newId() {
        return UUID.randomUUID();
    }
}
