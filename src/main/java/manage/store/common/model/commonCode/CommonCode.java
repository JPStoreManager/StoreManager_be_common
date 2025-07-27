package manage.store.common.model.commonCode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import manage.store.common.consts.SortOrder;
import manage.store.common.consts.UseYn;
import manage.store.common.model.commonCode.prop.CommonCd;
import manage.store.common.model.commonCode.prop.CommonGrpCd;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonCode {

    private CommonGrpCd grpCd;
    private String grpCdDesc;
    private CommonCd cd;
    private String cdVal;
    private String cdDesc;
    private UseYn useYn;
    private SortOrder sortOrder;
    private String createdBy;
    private String createdDate;
    private String lastUpdatedBy;
    private String lastUpdatedDate;

}
