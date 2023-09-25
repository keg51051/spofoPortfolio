package spofo.sad.domain.stock.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spofo.stock.repository.StockHaveRepository;

@SpringBootTest
class StockHaveRepositoryTest {

    @Autowired
    StockHaveRepository stockHaveRepository;

    @Test
    void showAll() {
        stockHaveRepository.findAll().forEach(System.out::println);
    }
}