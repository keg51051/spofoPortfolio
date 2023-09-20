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
    private Long id;
    private Long member_id;
    private String name;
    private String description;
    private String currency;
    private String include_yn;
    private String type;
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
                .type(type)
                .createdAt(createdAt)
                .modifiedAt(modifiedAt)
                .build();
    }
}
