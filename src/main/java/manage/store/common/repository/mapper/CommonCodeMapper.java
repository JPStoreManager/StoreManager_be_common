package manage.store.common.repository.mapper;

import manage.store.common.consts.UseYn;
import manage.store.common.model.commonCode.CommonCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommonCodeMapper {

    List<CommonCode> selectCommonCds(@Param(value = "grpCd") String grpCd,
                                     @Param(value = "useYn") UseYn useYn);

    CommonCode selectCommonCd(@Param(value = "grpCd") String grpCd,
                              @Param(value = "cd")    String cd,
                              @Param(value = "useYn") UseYn useYn);

}
