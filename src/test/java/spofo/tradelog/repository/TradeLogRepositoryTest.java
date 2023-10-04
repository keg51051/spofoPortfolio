package spofo.tradelog.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import spofo.tradelog.entity.TradeLog;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DisplayName("종목 이력 JPA 테스트")
class TradeLogRepositoryTest {

    @Autowired
    private TradeLogRepository tradeLogRepository;

//    @Test
//    @DisplayName("보유 종목 ID로 종목 이력을 조회할 수 있다.")
//    void findByStockId() {
//
//        // given
//        Long STOCK_ID = 1L;
//        Long TRADE_LOG_ID = 1L;
//
//        // when
//        List<TradeLog> tradeLogList = tradeLogRepository.findByStockId(STOCK_ID);
//        TradeLog findTradeLog = tradeLogRepository.findById(TRADE_LOG_ID)
//                .orElseThrow();
//
//        // then
//        assertThat(tradeLogList.get(0)).isEqualTo(findTradeLog);
//    }
}