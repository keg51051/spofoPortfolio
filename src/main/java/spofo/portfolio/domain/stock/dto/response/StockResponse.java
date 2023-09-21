package spofo.portfolio.domain.stock.dto.response;

import org.jetbrains.annotations.NotNull;
import spofo.portfolio.domain.stock.entity.Stock;

public class StockResponse {
    private final String stockCode;
    private final String stockName;
    private final String imageUrl;
    private final String stockMarket;

    public StockResponse(@NotNull Stock s) {
        stockCode = s.getStockCode();
        stockName = s.getStockName();
        imageUrl = s.getImageUrl();
        stockMarket = s.getStockMarket();
    }
}
