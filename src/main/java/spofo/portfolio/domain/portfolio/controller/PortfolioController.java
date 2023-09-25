package spofo.portfolio.domain.portfolio.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import spofo.portfolio.domain.portfolio.dto.request.CreatePortfolioRequest;
import spofo.portfolio.domain.portfolio.dto.response.CreatePortfolioResponse;
import spofo.portfolio.domain.portfolio.dto.response.ListPortfolioResponse;
import spofo.portfolio.domain.portfolio.dto.response.PortfolioResponse;
import spofo.portfolio.domain.portfolio.dto.response.TotalPortfolioResponse;
import spofo.portfolio.domain.portfolio.service.PortfolioService;

@RestController
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @GetMapping("/portfolios/total")
    public TotalPortfolioResponse getTotalPortfolio() {
        return portfolioService.getTotalPortfolio(Long.valueOf(portfolioService.getMemberId()));
    }

    @GetMapping("/portfolios")
    public List<ListPortfolioResponse> getListPortfolio() {
        return portfolioService.getListPortfolio(Long.valueOf(portfolioService.getMemberId()));
    }

    @PostMapping("/portfolios")
    @ResponseStatus(HttpStatus.OK)
    public CreatePortfolioResponse createPortfolio(
            @RequestBody CreatePortfolioRequest createPortfolioRequest) {
        return portfolioService.createPortfolio(createPortfolioRequest);
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
