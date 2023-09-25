package spofo.stock.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spofo.stock.dto.response.StockHaveResponse;
import spofo.stock.entity.StockHave;
import spofo.stock.repository.StockHaveRepository;

@Service
@RequiredArgsConstructor
public class StockHaveService {

    private final StockHaveRepository stockHaveRepository;

    public List<StockHaveResponse> getStocks(Long portfolioId) {
        List<StockHave> stocks = stockHaveRepository.findByPortfolioId(portfolioId);
        return stocks
                .stream()
                .map(StockHaveResponse::from)
                .toList();
    }
}
