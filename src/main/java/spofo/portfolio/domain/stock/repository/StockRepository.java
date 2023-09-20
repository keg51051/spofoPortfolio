package spofo.portfolio.domain.stock.repository;

import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spofo.portfolio.domain.stock.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, BigInteger> {

}