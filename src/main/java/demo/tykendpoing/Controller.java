package demo.tykendpoing;

import demo.tykendpoing.service.GlobalTransactionIdProvider;
import demo.tykendpoing.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
public class Controller {
    private final LoanService loanService;
    private final GlobalTransactionIdProvider globalTransactionIdProvider;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> onError() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping("/applications")
    @ResponseBody
    public ResponseEntity<ApplicationResponse> postApplications(@RequestBody Map<String, Object> body,
                                  @RequestHeader(value = "X-Global-Transaction-ID", required = false) String transactionId) {
        if (transactionId == null) {
            transactionId = globalTransactionIdProvider.newId().toString();
        }
        return ResponseEntity.ok()
                .header("X-Global-Transaction-ID", String.valueOf(transactionId))
                .body(loanService.submitApplication(body));
    }
}
