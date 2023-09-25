package spofo.tradelog.service;

import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spofo.tradelog.dto.response.TradeLogResponse;
import spofo.tradelog.entity.TradeLog;
import spofo.tradelog.enums.TradeType;
import spofo.tradelog.repository.TradeLogRepository;

@Service
@RequiredArgsConstructor
public class TradeLogService {

    private final TradeLogRepository tradeLogRepository;

    // TODO : 아직 잘.. 모르겠음
    public Long createTradeLog(Long stockId) {
        return 0L;
    }

    /**
     * ㅌ 종목 이력 목록 리스트 전달
     **/
    public List<TradeLogResponse> getTradeLogs(Long stockId) {
        List<TradeLog> tradeLogs = tradeLogRepository.findByStockId(stockId);
        return tradeLogs.stream()
                .map(tradeLog -> TradeLogResponse.from(tradeLog, getProfit(tradeLog),
                        getTotalPrice(tradeLog)))
                .toList();
    }

    /**
     * 금액 계산
     **/
    private BigDecimal getTotalPrice(TradeLog tradeLog) {
        return tradeLog.getPrice().multiply(tradeLog.getQuantity());
    }

    /**
     * 실현 수익 계산
     **/
    private BigDecimal getProfit(TradeLog tradeLog) {
        if (tradeLog.getType().equals(TradeType.B)) {
            return BigDecimal.valueOf(0);
        }
        // TODO : 매도 시 계산 로직 작성했지만 불확실함
        return getTotalPrice(tradeLog).subtract(
                (tradeLog.getMarketPrice().multiply(tradeLog.getQuantity())));
    }
}
