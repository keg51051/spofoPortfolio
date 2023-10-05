package spofo.portfolio.controller;

import static org.springframework.http.ResponseEntity.ok;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spofo.portfolio.dto.request.CreatePortfolioRequest;
import spofo.portfolio.dto.request.UpdatePortfolioRequest;
import spofo.portfolio.dto.response.CreatePortfolioResponse;
import spofo.portfolio.dto.response.OnePortfolioResponse;
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
            @RequestBody @Validated CreatePortfolioRequest createPortfolioRequest) {
        CreatePortfolioResponse createPortfolioResponse =
                portfolioService.createPortfolio(createPortfolioRequest.toEntity());
        return ok(createPortfolioResponse);
    }

    @GetMapping("/portolios/{portfolioId}")
    public ResponseEntity<OnePortfolioResponse> getOnePortfolio(
            @PathVariable(name = "portfolioId") Long portfolioId) {
        OnePortfolioResponse onePortfolioResponse = portfolioService.getOnePortfolio(portfolioId);
        return ok(onePortfolioResponse);
    }

    @GetMapping("/portfolios/{portfolioId}/total")
    public ResponseEntity<PortfolioResponse> getPortfolio(
            @PathVariable(name = "portfolioId") Long portfolioId) {
        PortfolioResponse portfolioResponse = portfolioService.getPortfolio(portfolioId);
        return ok().body(portfolioResponse);
    }

    @PutMapping("/portfolios/{portfolioId}")
    public ResponseEntity<Void> updatePortfolio(
            @PathVariable(name = "portfolioId") Long portfolioId,
            @RequestBody @Valid UpdatePortfolioRequest updatePortfolioRequest) {
        portfolioService.updatePortfolio(portfolioId, updatePortfolioRequest);
        return ok().body(null);
    }

    @DeleteMapping("/portfolios/{portfolioId}")
    public ResponseEntity<Void> deletePortfolio(
            @PathVariable(name = "portfolioId") Long portfolioId) {
        portfolioService.deletePortfolio(portfolioId);
        return ok().body(null);
    }
}
