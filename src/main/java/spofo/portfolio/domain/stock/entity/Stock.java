package spofo.portfolio.domain.stock.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigInteger;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stock_have")
public class Stock {

  @Id
  @GeneratedValue
  private BigInteger id;

  private BigInteger portfolio_id;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private String stock_code;
}
