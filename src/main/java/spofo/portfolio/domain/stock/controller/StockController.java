package spofo.portfolio.domain.stock.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import spofo.portfolio.domain.stock.dto.request.StockRequest;
import spofo.portfolio.domain.stock.dto.response.StockResponse;
import spofo.portfolio.domain.stock.service.StockService;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping("/portfolios/{portfolioId}/stocks")
    @ResponseStatus(HttpStatus.OK)
    public List<StockResponse> getStocks(
            @RequestParam String keyword,
            @RequestParam String order,
            @PathVariable Long portfolioId) {
        // TODO : 전체 보유 종목 조회
        return stockService.getAllStocks();
    }

}
