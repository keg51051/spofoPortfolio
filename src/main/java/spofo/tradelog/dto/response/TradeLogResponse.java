package spofo.tradelog.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spofo.tradelog.entity.TradeLog;
import spofo.tradelog.enums.TradeType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TradeLogResponse {

    private Long id;
    private LocalDateTime tradeDate; // 날짜
    private TradeType type; // 종류
    private BigDecimal price; // 매매가
    private BigDecimal quantity; // 수량
    private BigDecimal profit; // 실현 수익
    private BigDecimal totalPrice; // 금액

    public static TradeLogResponse from(TradeLog tradeLog, BigDecimal profit,
            BigDecimal totalPrice) {
        return TradeLogResponse.builder()
                .id(tradeLog.getId())
                .tradeDate(tradeLog.getTradeDate())
                .type(tradeLog.getType())
                .price(tradeLog.getPrice())
                .quantity(tradeLog.getQuantity())
                .profit(profit)
                .totalPrice(totalPrice)
                .build();
    }
}
