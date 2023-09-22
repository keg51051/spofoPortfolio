package spofo.portfolio.domain.portfolio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioController {

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String getStatus() {
        return "포트폴리오 서버입니다.";
    }

}
