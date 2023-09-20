package spofo.portfolio.domain.stock.dto;

import java.time.LocalDateTime;
import lombok.Data;
import spofo.portfolio.domain.stock.entity.StockClose;

@Data
public class StockCloseDto {

    private LocalDateTime createdAt;
    private String stockCode;
    private int closePrice;

    public StockCloseDto(StockClose sc) {
        createdAt = sc.getCreatedAt();
        stockCode = sc.getStockCode();
        closePrice = sc.getClosePrice();
    }

}
