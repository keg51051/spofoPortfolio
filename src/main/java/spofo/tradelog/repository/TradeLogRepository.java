package spofo.tradelog.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spofo.stock.entity.StockHave;
import spofo.tradelog.entity.TradeLog;

public interface TradeLogRepository extends JpaRepository<TradeLog, Long> {

//    @Query("select t from TradeLog t where t.stockHave.id = :stockId")
//    List<TradeLog> findByStockId(@Param("stockId") Long stockId);

    List<TradeLog> findByStockHave(StockHave stock);
}
