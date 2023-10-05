package spofo.tradelog.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import spofo.stock.entity.StockHave;
import spofo.tradelog.entity.TradeLog;
import spofo.tradelog.enums.TradeType;

@Data
@Builder
public class CreateTradeLogRequest {

    private StockHave stockHave;
    private TradeType type;
    private BigDecimal price;
    private LocalDateTime tradeDate;
    private BigDecimal quantity;
    private BigDecimal marketPrice;

    public TradeLog toEntity() {
        return TradeLog.builder()
                .stockHave(stockHave)
                .tradeType(type)
                .price(price)
                .tradeDate(tradeDate)
                .quantity(quantity)
                .marketPrice(marketPrice)
                .build();
    }
}
