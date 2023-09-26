package spofo.portfolio.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import spofo.portfolio.dto.request.CreatePortfolioRequest;
import spofo.portfolio.dto.response.CreatePortfolioResponse;
import spofo.portfolio.dto.response.PortfolioResponse;
import spofo.portfolio.dto.response.PortfolioSimpleResponse;
import spofo.portfolio.dto.response.TotalPortfolioResponse;
import spofo.portfolio.service.PortfolioService;

@RestController
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @GetMapping("/portfolios/total")
    public ResponseEntity<TotalPortfolioResponse> getTotalPortfolio() {
        TotalPortfolioResponse totalPortfolioResponse = portfolioService.getTotalPortfolio(
                portfolioService.getMemberId());
        return ok(totalPortfolioResponse);
    }

    @GetMapping("/portfolios")
    public ResponseEntity<List<PortfolioSimpleResponse>> getListPortfolio() {
        List<PortfolioSimpleResponse> portfolioSimpleResponse = portfolioService.getListPortfolio(
                portfolioService.getMemberId());
        return ok(portfolioSimpleResponse);
    }

    @PostMapping("/portfolios")
    public ResponseEntity<CreatePortfolioResponse> createPortfolio(
            @RequestBody CreatePortfolioRequest createPortfolioRequest) {
        CreatePortfolioResponse createPortfolioResponse = portfolioService.createPortfolio(
                createPortfolioRequest);
        return ok(createPortfolioResponse);
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
