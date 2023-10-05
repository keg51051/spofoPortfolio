package spofo.portfolio.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spofo.portfolio.entity.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

    @Query("select p from Portfolio p where p.memberId = :memberId")
    List<Portfolio> findByMemberId(@Param("memberId") Long memberId);

    @Query(value = "select id from member2 m where m.id = 3", nativeQuery = true)
    Long findmemberId();


}
