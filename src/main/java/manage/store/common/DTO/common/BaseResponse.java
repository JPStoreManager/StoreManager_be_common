package manage.store.common.DTO.common;

import lombok.Getter;
import lombok.ToString;
import manage.store.common.consts.SuccessFlag;
import manage.store.common.exception.InvalidParameterException;
import org.springframework.util.StringUtils;

@Getter
@ToString
public class BaseResponse {
    protected final SuccessFlag result;
    protected final String msg;

    public BaseResponse(SuccessFlag isSuccess, String msg) {
        if(isSuccess == null || !StringUtils.hasText(msg))
            throw new InvalidParameterException("The parameter is invalid." + isSuccess + ", " + msg);

        this.result = isSuccess;
        this.msg = msg;
    }
}
