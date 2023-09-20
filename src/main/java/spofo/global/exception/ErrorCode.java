package spofo.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    /*
    오류 코드 예시입니다
    DUPLICATED_ID(HttpStatus.BAD_REQUEST, "중복된 회원 아이디 입니다.");
     */
    ;
    private final HttpStatus status;
    private final String message;
}
