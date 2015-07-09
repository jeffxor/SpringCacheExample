package SpringCacheExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SizeUnitsRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SizeUnitsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Cacheable(value = "sizeUnits", key = "#root.methodName")
    public List<SizeUnit> getSizeUnits(){
        return jdbcTemplate.query("SELECT * FROM fe_size_units",
                new RowMapper<SizeUnit>() {
                    public SizeUnit mapRow(ResultSet rs, int rowNum) throws SQLException {
                        SizeUnit c = new SizeUnit(
                        rs.getInt("size_unit_id"),
                        rs.getString("size_unit"),
                        rs.getString("type"));
                        return c;
                    }
                });
    }

    @Cacheable(value = "sizeUnits")
    public SizeUnit getSizeUnit(Integer id){
        return jdbcTemplate.queryForObject("SELECT * FROM fe_size_units WHERE size_unit_id =?",
                new RowMapper<SizeUnit>() {
                    public SizeUnit mapRow(ResultSet rs, int rowNum) throws SQLException {
                        SizeUnit c = new SizeUnit(
                                rs.getInt("size_unit_id"),
                                rs.getString("size_unit"),
                                rs.getString("type"));
                        return c;
                    }
                },
                id);
    }


}
