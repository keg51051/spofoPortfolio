package spofo.portfolio.domain.portfolio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spofo.portfolio.domain.portfolio.dto.request.CreatePortfolio;

public class PortfolioController {

    @GetMapping("/portfolios/total")
    public String PorfoliosTotal(){
        return ""; // Todo : 전체 포트폴리오 자산 조회
    }
    @GetMapping("/portfolios")
    public String PortfoliosGet(){
        return ""; // Todo : 포트폴리오 목록 조회
    }

    @PostMapping("/portfolios")
    public String PortfoliosPost(CreatePortfolio createDto){
        return ""; // Todo : 포트폴리오 추가
    }
}
