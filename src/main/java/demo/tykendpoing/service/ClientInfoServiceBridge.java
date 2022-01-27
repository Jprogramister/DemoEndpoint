package demo.tykendpoing.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ClientInfoServiceBridge {
    public boolean isClient(Map<String, Object> participant) {
        return true;
    }
}
