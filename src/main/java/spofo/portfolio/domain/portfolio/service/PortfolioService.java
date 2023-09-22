package spofo.portfolio.domain.portfolio.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class PortfolioService {

    private final RestClient restClient;

    public PortfolioService() {
        restClient = RestClient.builder()
                .build();
    }

    public String getStock() {
        return restClient.get()
                .uri("stock.spofo.net/1")
                .retrieve()
                .body(String.class);
    }

    public String getAuth() {
        return restClient.get()
                .uri("auth.spofo.net")
                .retrieve()
                .body(String.class);
    }


}
