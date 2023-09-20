package spofo.portfolio.domain.stock.dto;

import java.time.LocalDateTime;
import lombok.Data;
import spofo.portfolio.domain.stock.entity.Stock;

@Data
public class StockDto {
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private String stock_code;

  public StockDto(Stock stock) {
    createdAt = stock.getCreatedAt();
    modifiedAt = stock.getModifiedAt();
    stock_code = stock.getStock_code();
  }

}
