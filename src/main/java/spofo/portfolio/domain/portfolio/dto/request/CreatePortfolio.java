package spofo.portfolio.domain.portfolio.dto.request;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spofo.portfolio.domain.portfolio.entity.Portfolio;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePortfolio {

    private int id;
    private int member_id;
    private String name;
    private String description;
    private String currency;
    private String include_yn;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public Portfolio toEntity() {
        return Portfolio.builder()
                .id(id)
                .member_id(member_id)
                .name(name)
                .description(description)
                .currency(currency)
                .include_yn(include_yn)
                .createdAt(createdAt)
                .modifiedAt(modifiedAt)
                .build();
    }
}
