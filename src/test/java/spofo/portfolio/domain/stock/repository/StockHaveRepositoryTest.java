package spofo.portfolio.domain.stock.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StockHaveRepositoryTest {

  @Autowired
  StockHaveRepository stockHaveRepository;

  @Test
  void showAll() {
    stockHaveRepository.findAll().forEach(System.out::println);
  }
}