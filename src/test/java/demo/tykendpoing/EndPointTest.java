package demo.tykendpoing;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

public class EndPointTest {
    // private static final String URL = "http://localhost:8080";
    // private static final String URL = "http://52.91.5.34:8080";
    private static final String URL = "http://tremendous-perfume-mgw.aws-euc1.cloud-ara.tyk.io/consumer-loan/v1";

    @Ignore
    @Test
    public void testResponses() {
        final var res = WebClient.builder()
                .baseUrl(URL + "/applications")
                .build()
                .post()
                .body(BodyInserters.fromValue(Map.of("TestField", "TestValue")))
                .exchangeToMono(resp -> Mono.just(resp.statusCode().equals(HttpStatus.OK)))
                .block();

        Assert.assertTrue("Must be success", res);

//        WebClient cl = WebClient.builder()
//                .baseUrl("http://localhost:8080/users")
//                .build();
//
//        Mono<String> res = cl.get().exchangeToMono(
//                clientResponse -> clientResponse.bodyToMono(String.class)
//        );
//
//        System.out.println(res.block());
    }
}
