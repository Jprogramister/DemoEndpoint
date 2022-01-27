package demo.tykendpoing.service;

import demo.tykendpoing.ApplicationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class LoanService {
    private final BankServiceMock bankService;
    private final ClientInfoService clientInfoService;

    public ApplicationResponse submitApplication(Map<String, Object> app) {
        clientInfoService.enrichWithClientInfo((Map<String, Object>) app.get("participant"));
        final long applicationId = bankService.sendLoanApplication(app);
        return new ApplicationResponse(applicationId);
    }
}
