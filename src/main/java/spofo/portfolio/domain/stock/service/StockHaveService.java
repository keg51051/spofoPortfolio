package spofo.portfolio.domain.stock.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spofo.portfolio.domain.stock.dto.response.StockHaveResponse;
import spofo.portfolio.domain.stock.entity.StockHave;
import spofo.portfolio.domain.stock.repository.StockHaveRepository;

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
