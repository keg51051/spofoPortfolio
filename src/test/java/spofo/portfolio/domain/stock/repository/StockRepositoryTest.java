package spofo.portfolio.domain.stock.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StockRepositoryTest {

  @Autowired
  StockRepository stockRepository;

  @Test
  void showAll() {
    stockRepository.findAll().forEach(System.out::println);
  }
}