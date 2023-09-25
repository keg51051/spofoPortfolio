package spofo.portfolio.domain.portfolio.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import spofo.portfolio.domain.portfolio.dto.request.CreatePortfolioRequest;
import spofo.portfolio.domain.portfolio.dto.response.PortfolioResponse;
import spofo.portfolio.domain.portfolio.service.PortfolioService;

@RestController
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @GetMapping("/portfolios/total")
    public void porfoliosTotal() {
        // void -> List<TotalPortfolioResponse> 변경할 예정 (로직 완성이 안되서 void로 해놓음)
        Long memberId = Long.parseLong(portfolioService.getMemberId());
        // return portfolioService.getTotalPortfolio(memberId);
    }

    @GetMapping("/portfolios")
    public String PortfoliosGet() {
        return ""; // Todo : 포트폴리오 목록 조회
    }

    @PostMapping("/portfolios")
    public String PortfoliosPost(CreatePortfolioRequest createDto) {
        return ""; // Todo : 포트폴리오 추가
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


    @GetMapping("/portfolios/{portfolioId}/total")
    public PortfolioResponse getPortfolio(@PathVariable String portfolioId) {
        return portfolioService.getPortfolio(Long.valueOf(portfolioId));
    }
}
