package org.test.project.dao;

import org.test.project.model.Virus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VirusDaoImpl implements VirusDao {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Virus findByName(String name) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);

        String sql = "SELECT * FROM Viruses WHERE name=:name";

        Virus result = namedParameterJdbcTemplate.queryForObject(
                sql,
                params,
                new UserMapper());

        //new BeanPropertyRowMapper(Customer.class));

        return result;

    }

    @Override
    public List<Virus> findAll() {

        Map<String, Object> params = new HashMap<String, Object>();

        String sql = "SELECT * FROM Viruses";

        List<Virus> result = namedParameterJdbcTemplate.query(sql, params, new UserMapper());

        return result;

    }

    private static final class UserMapper implements RowMapper<Virus> {

        public Virus mapRow(ResultSet rs, int rowNum) throws SQLException {
            Virus virus = new Virus();
            virus.setId(rs.getInt("id"));
            virus.setName(rs.getString("name"));
            virus.setResult(rs.getString("email"));
            return virus;
        }
    }

}