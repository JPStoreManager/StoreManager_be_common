package manage.store.common.model.commonCode.prop;


import lombok.Getter;
import lombok.Setter;
import manage.store.common.exception.InvalidParameterException;
import org.springframework.util.StringUtils;

@Getter
@Setter
public class CommonGrpCd {

    public static final String UI_FORMAT = "UI_FORMAT";

    private String value;

    public CommonGrpCd(String grpCd) {
        if(!isValidGrpCd(grpCd)) throw new InvalidParameterException("GrpCd is not valid. grpCd: " + grpCd);

        this.value = grpCd;
    }

    @Override
    public String toString() {
        return value;
    }

    private boolean isValidGrpCd(String grpCd) {
        return StringUtils.hasText(grpCd);
    }

}
