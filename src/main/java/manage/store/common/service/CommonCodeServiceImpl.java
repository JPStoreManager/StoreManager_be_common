package manage.store.common.service;

import lombok.RequiredArgsConstructor;
import manage.store.common.consts.UseYn;
import manage.store.common.exception.InvalidParameterException;
import manage.store.common.model.commonCode.CommonCode;
import manage.store.common.model.commonCode.prop.CommonCd;
import manage.store.common.model.commonCode.prop.CommonGrpCd;
import manage.store.common.repository.mapper.CommonCodeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonCodeServiceImpl implements CommonCodeService {

    private final CommonCodeMapper commonCodeMapper;

    @Override
    public List<CommonCode> getCommonCodes(CommonGrpCd commonGrpCd) {
        return getCommonCodes(commonGrpCd, UseYn.Y);
    }

    @Override
    public List<CommonCode> getCommonCodes(CommonGrpCd commonGrpCd, UseYn useYn) {
        if(commonGrpCd == null || useYn == null) throw new InvalidParameterException("CommonGrpCd and UseYn must not be null");

        return commonCodeMapper.selectCommonCds(commonGrpCd.getValue(), useYn);
    }

    @Override
    public CommonCode getCommonCode(CommonGrpCd commonGrpCd, CommonCd cd) {
        return getCommonCode(commonGrpCd, cd, UseYn.Y);
    }

    @Override
    public CommonCode getCommonCode(CommonGrpCd commonGrpCd, CommonCd cd, UseYn useYn) {
        if(commonGrpCd == null || cd == null || useYn == null) {
            throw new InvalidParameterException("CommonGrpCd, cd and UseYn must not be null");
        }

        return commonCodeMapper.selectCommonCd(commonGrpCd.getValue(), cd.getValue(), useYn);
    }
}
