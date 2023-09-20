package spofo.portfolio.domain.trade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spofo.portfolio.domain.trade.entity.TradeLog;

public interface TradeRepository extends JpaRepository<TradeLog, Long> {

}
