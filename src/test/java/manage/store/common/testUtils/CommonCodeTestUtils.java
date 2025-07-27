package manage.store.common.testUtils;

import manage.store.common.consts.SortOrder;
import manage.store.common.consts.UseYn;
import manage.store.common.model.commonCode.prop.CommonCd;
import manage.store.common.model.commonCode.CommonCode;
import manage.store.common.model.commonCode.prop.CommonGrpCd;

public interface CommonCodeTestUtils {

    CommonGrpCd TEST_GRP_CD = new CommonGrpCd("TEST_GRP_CD");

    CommonCode COMMON_CODE1 = CommonCode.builder()
            .grpCd(TEST_GRP_CD)
            .grpCdDesc("test group code")
            .cd(new CommonCd("CD1"))
            .cdVal("CDVAL1")
            .cdDesc("code value desc")
            .useYn(UseYn.Y)
            .sortOrder(new SortOrder(1L))
            .createdBy("system")
            .createdDate("2025-07-26 00:00:00.000")
            .lastUpdatedBy("system")
            .lastUpdatedDate("2025-07-26 00:00:00.000")
            .build();

    CommonCode COMMON_CODE2 = CommonCode.builder()
            .grpCd(TEST_GRP_CD)
            .grpCdDesc("test group code")
            .cd(new CommonCd("CD2"))
            .cdVal("CDVAL2")
            .cdDesc("code value desc")
            .useYn(UseYn.Y)
            .sortOrder(new SortOrder(2L))
            .createdBy("system")
            .createdDate("2025-07-26 00:00:00.000")
            .lastUpdatedBy("system")
            .lastUpdatedDate("2025-07-26 00:00:00.000")
            .build();

    CommonCode COMMON_CODE3 = CommonCode.builder()
            .grpCd(TEST_GRP_CD)
            .grpCdDesc("test group code")
            .cd(new CommonCd("CD3"))
            .cdVal("CDVAL3")
            .cdDesc("code value desc")
            .useYn(UseYn.Y)
            .sortOrder(new SortOrder(3L))
            .createdBy("system")
            .createdDate("2025-07-26 00:00:00.000")
            .lastUpdatedBy("system")
            .lastUpdatedDate("2025-07-26 00:00:00.000")
            .build();

    CommonCode COMMON_CODE4 = CommonCode.builder()
            .grpCd(TEST_GRP_CD)
            .grpCdDesc("test group code")
            .cd(new CommonCd("CD4"))
            .cdVal("CDVAL4")
            .cdDesc("code value desc")
            .useYn(UseYn.N)
            .sortOrder(new SortOrder(4L))
            .createdBy("system")
            .createdDate("2025-07-26 00:00:00.000")
            .lastUpdatedBy("system")
            .lastUpdatedDate("2025-07-26 00:00:00.000")
            .build();

    CommonCode COMMON_CODE5 = CommonCode.builder()
            .grpCd(TEST_GRP_CD)
            .grpCdDesc("test group code")
            .cd(new CommonCd("CD5"))
            .cdVal("CDVAL5")
            .cdDesc("code value desc")
            .useYn(UseYn.N)
            .sortOrder(new SortOrder(5L))
            .createdBy("system")
            .createdDate("2025-07-26 00:00:00.000")
            .lastUpdatedBy("system")
            .lastUpdatedDate("2025-07-26 00:00:00.000")
            .build();

    CommonCode[] USE_COMMON_CODES = {COMMON_CODE1, COMMON_CODE2, COMMON_CODE3};
    CommonCode[] NOT_USE_COMMON_CODES = {COMMON_CODE4, COMMON_CODE5};
}