package spofo.portfolio.domain.stock.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spofo.portfolio.domain.stock.dto.response.StockResponse;
import spofo.portfolio.domain.stock.entity.Stock;
import spofo.portfolio.domain.stock.repository.StockRepository;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<StockResponse> getAllStocks() {
        return stockRepository.findAll()
                .stream()
                .map(StockResponse::new)
                .collect(Collectors.toList());
    }
}
