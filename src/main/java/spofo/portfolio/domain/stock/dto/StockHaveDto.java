package spofo.portfolio.domain.stock.dto;

import java.time.LocalDateTime;
import lombok.Data;
import spofo.portfolio.domain.stock.entity.StockHave;

@Data
public class StockHaveDto {

    private int id;
    private int portfolioId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String stockCode;

    public StockHaveDto(StockHave sh) {
        id = sh.getId();
        portfolioId = sh.getPortfolioId();
        createdAt = sh.getCreatedAt();
        modifiedAt = sh.getModifiedAt();
        stockCode = sh.getStockCode();
    }

}
