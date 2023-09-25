package spofo.portfolio.domain.stock.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import spofo.portfolio.domain.stock.dto.response.StockHaveResponse;
import spofo.portfolio.domain.stock.service.StockHaveService;

@RestController
public class StockController {

    @Autowired
    StockHaveService stockHaveService;

    @GetMapping("/portfolios/{portfolioId}/stocks")
    @ResponseStatus(HttpStatus.OK)
    public List<StockHaveResponse> getStocks(
            @RequestParam String keyword,
            @RequestParam String order,
            @PathVariable String portfolioId) {
        // TODO : 전체 보유 종목 조회
        return stockHaveService.getStocks(Long.valueOf(portfolioId));
    }

}
