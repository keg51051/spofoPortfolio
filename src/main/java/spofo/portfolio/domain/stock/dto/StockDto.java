package spofo.portfolio.domain.stock.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import spofo.portfolio.domain.stock.entity.Stock;

@Data
public class StockDto {

    private String stockCode;
    private String stockName;
    private String imageUrl;
    private String stockMarket;

    public StockDto(Stock s) {
        stockCode = s.getStockCode();
        stockName = s.getStockName();
        imageUrl = s.getImageUrl();
        stockMarket = s.getStockMarket();
    }
}
