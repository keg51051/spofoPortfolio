package spofo.stock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import spofo.stock.dto.response.StockHaveResponse;
import spofo.stock.service.StockHaveService;

@RestController
public class StockController {

    @Autowired
    StockHaveService stockHaveService;

//    @GetMapping("/portfolios/{portfolioId}/stocks")
//    public ResponseEntity<Map<String, List<StockHaveResponse>>> getStocks(@PathVariable("portfolioId") Long portfolioId) {
//
//        Map<String, List<StockHaveResponse>> result = new HashMap<>();
//        result.put("data", stockHaveService.getStocks(portfolioId));
//        return ResponseEntity.ok().body(result);
//    }
    @GetMapping("/portfolios/{portfolioId}/stocks")
    public ResponseEntity<List<StockHaveResponse>> getStocks(@PathVariable("portfolioId") Long portfolioId) {
        // TODO : 전체 보유 종목 조회
        List<StockHaveResponse> result = stockHaveService.getStocks(portfolioId);
        return ResponseEntity.ok().body(result);
    }

}
