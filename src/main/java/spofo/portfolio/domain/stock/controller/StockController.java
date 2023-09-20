package spofo.portfolio.domain.stock.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spofo.portfolio.domain.stock.dto.StockDto;
import spofo.portfolio.domain.stock.entity.Stock;
import spofo.portfolio.domain.stock.service.StockService;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping("/")
    public List<StockDto> getStocks() {
        return stockService.getAllStocks();
    }

}
