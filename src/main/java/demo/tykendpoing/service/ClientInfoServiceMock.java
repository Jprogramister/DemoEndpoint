package demo.tykendpoing.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ClientInfoServiceMock {
    public void enrichWithClientInfo(Map<String, Object> loanApplication) {
        loanApplication.put("isClient", isClient(loanApplication));
    }

    public boolean isClient(Map<String, Object> loanApplication) {
        return true;
    }
}
