package spofo.portfolio.domain.stock.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spofo.portfolio.domain.stock.entity.StockHave;

@Repository
public interface StockHaveRepository extends JpaRepository<StockHave, Long> {
    @Query(value = "SELECT sh FROM stock_have sh WHERE sh.portfolio_id = :portfolioId", nativeQuery = true)
    List<StockHave> findByPortfolioId(@Param("portfolioId") Long portfolioId);

}