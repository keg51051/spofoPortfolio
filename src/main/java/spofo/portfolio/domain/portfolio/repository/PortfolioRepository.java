package spofo.portfolio.domain.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spofo.portfolio.domain.portfolio.entity.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {

}
