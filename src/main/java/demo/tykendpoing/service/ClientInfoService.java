package demo.tykendpoing.service;

import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class ClientInfoService {
    private final ClientInfoServiceBridge clientInfoServiceBridge;

    public void enrichWithClientInfo(Map<String, Object> participant) {
        participant.put("isClient", clientInfoServiceBridge.isClient(participant));
    }

    @Cacheable(value = "isClientMarksCache", key = "#participant.get(\"snils\")")
    public boolean isClient(Map<String, Object> participant) {
        return clientInfoServiceBridge.isClient(participant);
    }
}
