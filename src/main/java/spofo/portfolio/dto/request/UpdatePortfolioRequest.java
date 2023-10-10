package spofo.portfolio.dto.request;

import lombok.Getter;
import spofo.portfolio.enums.IncludeType;

@Getter
public class UpdatePortfolioRequest {

    private String name;
    private String detail;
    private IncludeType includeYn;
}
