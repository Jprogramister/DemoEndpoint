package demo.tykendpoing.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BankServiceMock {
    private long applicationsCounter = 0;

    public long sendLoanApplication(Map<String, Object> application) {
        return applicationsCounter++;
    }
}
