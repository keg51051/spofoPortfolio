package spofo.stock.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spofo.stock.entity.StockHave;

@Repository
public interface StockHaveRepository extends JpaRepository<StockHave, Long> {

    @Query(value = "SELECT * FROM stock_have sh WHERE sh.portfolio_id = :portfolioId", nativeQuery = true)
    List<StockHave> findByPortfolioId(@Param("portfolioId") Long portfolioId);

    @Query(value = "DELETE FROM stock_have sh WHERE sh.portfolio_id = :portfolioId AND sh.id = :stockId", nativeQuery = true)
    void deleteByStockId(@Param("portfolioId") Long portfolioId, @Param("stockId") Long stockId);

}