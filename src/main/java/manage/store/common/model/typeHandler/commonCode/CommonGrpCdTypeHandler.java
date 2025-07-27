package manage.store.common.model.typeHandler.commonCode;

import lombok.NoArgsConstructor;
import manage.store.common.model.commonCode.prop.CommonGrpCd;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@NoArgsConstructor
@MappedTypes(CommonGrpCd.class)
public class CommonGrpCdTypeHandler extends BaseTypeHandler<CommonGrpCd> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, CommonGrpCd parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getValue());
    }

    @Override
    public CommonGrpCd getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return value != null ? new CommonGrpCd(value) : null;
    }

    @Override
    public CommonGrpCd getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return value != null ? new CommonGrpCd(value) : null;
    }

    @Override
    public CommonGrpCd getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return value != null ? new CommonGrpCd(value) : null;
    }
}