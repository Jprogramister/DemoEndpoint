package demo.tykendpoing;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Random;

@RestController
public class Controller {
    @PostMapping("/applications")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> postApplications(@RequestBody Map<String, Object> body,
                                  @RequestHeader(value = "X-Global-Transaction-ID", required = false) Long transactionId) {
        if (transactionId == null) {
            transactionId = Math.max(0, new Random().nextLong());
        }
        final long id = Math.max(0, new Random().nextLong());
        return ResponseEntity.ok()
                .header("X-Global-Transaction-ID", String.valueOf(transactionId))
                .body(Map.of("id", id));
    }
}
