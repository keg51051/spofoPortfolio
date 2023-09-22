package spofo.portfolio.domain.portfolio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import spofo.portfolio.domain.portfolio.service.PortfolioService;

@RestController
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    String getStatus() {
        return "포트폴리오 서버입니다.";
    }

    @GetMapping("/test/callStock")
    @ResponseStatus(HttpStatus.OK)
    String getStock() {
        return portfolioService.getStock();
    }

    @GetMapping("/test/callAuth")
    @ResponseStatus(HttpStatus.OK)
    String getAuth() {
        return portfolioService.getAuth();
    }


}
