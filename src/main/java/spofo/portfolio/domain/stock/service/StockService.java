package spofo.portfolio.domain.stock.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spofo.portfolio.domain.stock.dto.response.StockResponse;
import spofo.portfolio.domain.stock.repository.StockRepository;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    public List<StockResponse> getAllStocks() {
        return stockRepository.findAll()
                .stream()
                .map(StockResponse::from)
                .collect(Collectors.toList());
    }
}
