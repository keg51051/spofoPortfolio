package spofo.tradelog.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import spofo.portfolio.entity.Portfolio;
import spofo.portfolio.enums.IncludeType;
import spofo.portfolio.enums.PortfolioType;
import spofo.stock.entity.StockHave;
import spofo.stock.repository.StockHaveRepository;
import spofo.tradelog.dto.response.TradeLogResponse;
import spofo.tradelog.entity.TradeLog;
import spofo.tradelog.enums.TradeType;
import spofo.tradelog.repository.TradeLogRepository;

@SpringBootTest(classes = {TradeLogService.class})
@MockBean(JpaMetamodelMappingContext.class)
@DisplayName("종목 이력 서비스")
class TradeLogServiceTest {

    @Autowired
    private TradeLogService tradeLogService;

    @MockBean
    private TradeLogRepository tradeLogRepository;

    @MockBean
    private StockHaveRepository stockHaveRepository;

    private static Long STOCK_ID = 1L;
    private static Long PORTFOLIO_ID = 1L;

    @Test
    @DisplayName("보유 종목에 대한 이력을 조회한다.")
    void getTradeLogs() {

        // given
        Portfolio mockPortfolio = getMockPortfolio();
        StockHave mockStockHave = getMockStockHave(mockPortfolio);
        TradeLog mockTradeLog = getMockTradeLog(mockStockHave);

        List<TradeLog> mockTradeLogList = new ArrayList<>();
        mockTradeLogList.add(mockTradeLog);

        given(stockHaveRepository.getReferenceById(STOCK_ID)).willReturn(mockStockHave);
        given(tradeLogRepository.findByStockHave(mockStockHave)).willReturn(mockTradeLogList);
        TradeLogResponse tradeLogResponse = TradeLogResponse.from(mockTradeLog, BigDecimal.ZERO,
                BigDecimal.valueOf(2000));

        // when
        List<TradeLogResponse> findTradeLogsList = tradeLogService.getTradeLogs(STOCK_ID);

        // then
        assertThat(findTradeLogsList.get(0)).isEqualTo(tradeLogResponse);
    }

    private Portfolio getMockPortfolio() {
        return Portfolio.builder()
                .id(1L)
                .memberId(1L)
                .name("name-test")
                .description("detail-test")
                .currency("한국")
                .includeYn(IncludeType.Y)
                .type(PortfolioType.FAKE)
                .build();
    }

    private StockHave getMockStockHave(Portfolio portfolio) {
        return StockHave.builder()
                .id(1L)
                .stockCode("test")
                .portfolio(portfolio)
                .build();
    }

    private TradeLog getMockTradeLog(StockHave stockHave) {
        return TradeLog.builder()
                .id(1L)
                .stockHave(stockHave)
                .tradeType(TradeType.B)
                .price(BigDecimal.valueOf(1000))
                .tradeDate(LocalDateTime.now())
                .quantity(BigDecimal.valueOf(2))
                .marketPrice(BigDecimal.valueOf(1000))
                .createdAt(LocalDateTime.now())
                .build();
    }
}