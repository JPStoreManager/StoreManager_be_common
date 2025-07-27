package manage.store.common.model.typeHandler;

import manage.store.common.consts.SortOrder;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(SortOrder.class)
public class SortOrderTypeHandler extends BaseTypeHandler<SortOrder> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, SortOrder parameter, JdbcType jdbcType) throws SQLException {
        ps.setLong(i, parameter.getSortOrder());
    }

    @Override
    public SortOrder getNullableResult(ResultSet rs, String columnName) throws SQLException {
        long value = rs.getLong(columnName);
        return rs.wasNull() ? null : new SortOrder(value);
    }

    @Override
    public SortOrder getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        long value = rs.getLong(columnIndex);
        return rs.wasNull() ? null : new SortOrder(value);
    }

    @Override
    public SortOrder getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        long value = cs.getLong(columnIndex);
        return cs.wasNull() ? null : new SortOrder(value);
    }
}