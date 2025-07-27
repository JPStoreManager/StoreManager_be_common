package manage.store.common.model.commonCode.prop;


import lombok.Getter;
import lombok.Setter;
import manage.store.common.exception.InvalidParameterException;
import org.springframework.util.StringUtils;

@Getter
@Setter
public class CommonCd {

    public static final String UI_FORMAT = "UI_FORMAT";

    private String value;

    public CommonCd(String cd) {
        if(!isValidCd(cd)) throw new InvalidParameterException("Cd is not valid. cd: " + cd);

        this.value = cd;
    }

    @Override
    public String toString() {
        return value;
    }

    private boolean isValidCd(String cd) {
        return StringUtils.hasText(cd);
    }

}
