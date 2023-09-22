package spofo.portfolio.domain.stock.dto.response;

import java.math.BigDecimal;
import lombok.Builder;
import org.jetbrains.annotations.NotNull;
import spofo.portfolio.domain.stock.entity.Stock;

@Builder
public class StockResponse {

    private final String stockCode;
    private final String stockName;
    private final String imageUrl;
    private final String stockMarket;

    public static StockResponse from(@NotNull Stock s) {
        return StockResponse.builder()
                .stockCode(s.getStockCode())
                .stockName(s.getStockName())
                .imageUrl(s.getImageUrl())
                .stockMarket(s.getStockMarket())
                .build();
    }
}
