package manage.store.common.repository.mapper;

import manage.store.common.config.DBConfiguration;
import manage.store.common.consts.Profiles;
import manage.store.common.consts.Tags;
import manage.store.common.consts.UseYn;
import manage.store.common.model.commonCode.CommonCode;
import manage.store.common.testUtils.CommonCodeTestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Tag(Tags.Test.UNIT)
@MybatisTest
@ActiveProfiles(Profiles.TEST)
@ContextConfiguration(classes = DBConfiguration.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CommonCodeMapperTest {

    @Autowired
    private CommonCodeMapper commonCodeMapper;

    @Test
    @DisplayName("공통 코드 목록 조회 성공 - 사용중인 공통 코드")
    void selectCommonCdsByGrpCd_success() {
        // Given
        final String grpCd = CommonCodeTestUtils.TEST_GRP_CD.getValue();
        final int expectedSize = CommonCodeTestUtils.USE_COMMON_CODES.length;
        // When
        List<CommonCode> actual = commonCodeMapper.selectCommonCds(grpCd, UseYn.Y);

        // Then
        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(expectedSize);
        validateCommonCode(CommonCodeTestUtils.USE_COMMON_CODES[0], actual.get(0));
        validateCommonCode(CommonCodeTestUtils.USE_COMMON_CODES[1], actual.get(1));
        validateCommonCode(CommonCodeTestUtils.USE_COMMON_CODES[2], actual.get(2));
    }

    @Test
    @DisplayName("공통 코드 목록 조회 성공 - 사용중이지 않은 공통 코드")
    void selectCommonCdsByGrpCd_success_notUsed() {
        // Given
        final String grpCd = CommonCodeTestUtils.TEST_GRP_CD.getValue();
        final int expectedSize = CommonCodeTestUtils.NOT_USE_COMMON_CODES.length; // Assuming no codes are not used

        // When
        List<CommonCode> actual = commonCodeMapper.selectCommonCds(grpCd, UseYn.N);

        // Then
        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(expectedSize);
        validateCommonCode(CommonCodeTestUtils.NOT_USE_COMMON_CODES[0], actual.get(0));
        validateCommonCode(CommonCodeTestUtils.NOT_USE_COMMON_CODES[1], actual.get(1));
    }

    @Test
    @DisplayName("그룹 코드로 공통 코드 목록 조회 성공 - 존재하지 않는 그룹 코드")
    void selectCommonCdsByGrpCd_fail_noGrpCd() {
        // Given
        final String grpCd = "NO_GRP_CD";

        // When
        List<CommonCode> actual = commonCodeMapper.selectCommonCds(grpCd, UseYn.Y);

        // Then
        assertThat(actual).isNotNull();
        assertThat(actual).isEmpty();
    }

    @Test
    @DisplayName("특정 공통 코드 조회 성공 - 사용중인 공통 코드")
    void selectCommonCd_success() {
        // Given
        final String grpCd = CommonCodeTestUtils.COMMON_CODE1.getGrpCd().getValue();
        final String cd = CommonCodeTestUtils.COMMON_CODE1.getCd().getValue();

        // When
        CommonCode actual = commonCodeMapper.selectCommonCd(grpCd, cd, UseYn.Y);

        // Then
        assertThat(actual).isNotNull();
        validateCommonCode(CommonCodeTestUtils.COMMON_CODE1, actual);
    }

    @Test
    @DisplayName("특정 공통 코드 조회 성공 - 사용중이지 않은 공통 코드")
    void selectCommonCd_success_notUsed() {
        // Given
        final String grpCd = CommonCodeTestUtils.COMMON_CODE4.getGrpCd().getValue();
        final String cd = CommonCodeTestUtils.COMMON_CODE4.getCd().getValue();

        // When
        CommonCode actual = commonCodeMapper.selectCommonCd(grpCd, cd, UseYn.N);

        // Then
        assertThat(actual).isNotNull();
        validateCommonCode(CommonCodeTestUtils.COMMON_CODE4, actual);
    }

    @Test
    @DisplayName("특정 공통 코드 조회 성공 - 존재하지 않는 공통 코드")
    void selectCommonCd_fail_noGrpCd() {
        // Given
        final String[][] testCases = {
                {CommonCodeTestUtils.TEST_GRP_CD.getValue(), "NO_CD"},
                {"NO_GRP_CD", CommonCodeTestUtils.COMMON_CODE1.getCd().getValue()},
                {"NO_GRP_CD", "NO_CD"}
        };

        // When
        for (String[] testCase : testCases) {
            String grpCd = testCase[0];
            String cd = testCase[1];
            CommonCode actual = commonCodeMapper.selectCommonCd(grpCd, cd, UseYn.Y);

            // Then
            assertThat(actual).isNull();
        }
    }

    private void validateCommonCode(CommonCode expected, CommonCode actual) {
        assertThat(actual).isNotNull();
        assertThat(actual.getGrpCd().getValue()).isEqualTo(expected.getGrpCd().getValue());
        assertThat(actual.getGrpCdDesc()).isEqualTo(expected.getGrpCdDesc());
        assertThat(actual.getCd().getValue()).isEqualTo(expected.getCd().getValue());
        assertThat(actual.getCdVal()).isEqualTo(expected.getCdVal());
        assertThat(actual.getCdDesc()).isEqualTo(expected.getCdDesc());
        assertThat(actual.getUseYn()).isEqualTo(expected.getUseYn());
        assertThat(actual.getSortOrder().getSortOrder()).isEqualTo(expected.getSortOrder().getSortOrder());
        assertThat(actual.getCreatedBy()).isEqualTo(expected.getCreatedBy());
        assertThat(actual.getLastUpdatedBy()).isEqualTo(expected.getLastUpdatedBy());
    }
}