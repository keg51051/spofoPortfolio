package spofo.stock.service;

import java.math.BigDecimal;
import java.util.List;
import javax.sound.sampled.Port;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spofo.portfolio.entity.Portfolio;
import spofo.stock.dto.response.StockHaveResponse;
import spofo.stock.entity.StockHave;
import spofo.stock.repository.StockHaveRepository;
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
                                getAvgPrice(), getCurrentPrice(),
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
    // From CurrentPrice
    private BigDecimal getStockAsset() {
        return null;
    }

    // TODO : 보유 종목의 수익금
    // From CurrentPrice
    private BigDecimal getGain() {
        return null;
    }

    // TODO : 보유 종목의 수익률
    // From CurrentPrice
    private BigDecimal getGainRate() {
        return null;
    }

    // TODO : 보유 종목의 평균 단가(매수가)
    // From TradeLog
    private BigDecimal getAvgPrice() {
        return null;
    }

    // TODO : 보유 종목의 현재가
    // From Stock
    private BigDecimal getCurrentPrice() {
        return null;
    }

    // TODO : 보유 종목의 수량
    // From TradeLog
    private BigDecimal getQuantity(Long stockId) {
        BigDecimal total = BigDecimal.ZERO;
        tradeLogRepository.findByStockId(stockId)
                .forEach(tradeLog -> total.add(tradeLog.getQuantity()));
        return total;
    }

    // TODO : 아이콘 이미지 URL
    // From Stock
    private String getImageUrl() {
        return "";
    }


}
