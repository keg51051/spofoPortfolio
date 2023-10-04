package spofo.stock.service;

import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spofo.stock.dto.response.StockHaveResponse;
import spofo.stock.repository.StockHaveRepository;
import spofo.tradelog.entity.TradeLog;
import spofo.tradelog.repository.TradeLogRepository;
import spofo.tradelog.service.TradeLogService;

@Service
@RequiredArgsConstructor
public class StockHaveService {

    private final StockHaveRepository stockHaveRepository;
    private final TradeLogRepository tradeLogRepository;
    private final TradeLogService tradeLogService;

    public List<StockHaveResponse> getStocks(Long portfolioId) {
        return stockHaveRepository
                .findByPortfolioId(portfolioId)
                .stream()
                .map(stock -> StockHaveResponse
                        .from(stock, getStockName(), getSector(),
                                getStockAsset(), getGain(), getGainRate(),
                                getAvgPrice(stock.getId()), getCurrentPrice(),
                                getQuantity(stock.getId()), getImageUrl()))
                .toList();
    }

    // TODO : 종목명 불러오기
    // From Stock
    private String getStockName() {
        return "";
    }

    // TODO : 섹터 (산업명) 불러오기
    // From Stock
    private String getSector() {
        return "";
    }

    // TODO : 보유 종목의 자산 가치
    // 현재가 * 수량
    // From CurrentPrice
    private BigDecimal getStockAsset() {
        return null;
    }

    // TODO : 보유 종목의 수익금
    // (현재가 - 평균 단가) * 수량
    // From CurrentPrice
    private BigDecimal getGain() {
        return null;
    }

    // TODO : 보유 종목의 수익률
    // ??
    // From CurrentPrice
    private BigDecimal getGainRate() {
        return null;
    }

    // TODO : 보유 종목의 평균 단가(매수가)
    // TradeLog 매수가의 합 / 수량의 합
    // From TradeLog
    private BigDecimal getAvgPrice(Long stockId) {
        BigDecimal totalPrice;
        BigDecimal totalQuantity = getQuantity(stockId);
        totalPrice = tradeLogRepository.findByStockId(stockId)
                .stream()
                .map(TradeLog::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2);

        return totalPrice.divide(totalQuantity);
    }

    // TODO : 보유 종목의 현재가
    // From Stock
    private BigDecimal getCurrentPrice() {
        return null;
    }

    // TODO : 보유 종목의 수량
    // From TradeLog
    private BigDecimal getQuantity(Long stockId) {

        return tradeLogRepository.findByStockId(stockId)
                .stream()
                .map(TradeLog::getQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2);
    }

    // TODO : 아이콘 이미지 URL
    // From Stock
    private String getImageUrl() {
        return "";
    }


}
