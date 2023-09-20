package spofo.portfolio.domain.tradelog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spofo.portfolio.domain.tradelog.entity.TradeLog;

public interface TradeLogRepository extends JpaRepository<TradeLog, Long> {

}
