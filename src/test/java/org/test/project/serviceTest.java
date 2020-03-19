package org.test.project;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.test.project.dao.VirusDaoImpl;
import org.test.project.model.Virus;

@SpringBootTest
public class serviceTest {
    private EmbeddedDatabase db;

    @Before
    public void dataSource() {
        db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("db/sql/create-db.sql")
                .addScript("db/sql/insert-data.sql")
                .build();
    }


    @Test
    public void testGetVirus() {
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
        VirusDaoImpl userDao = new VirusDaoImpl();
        userDao.setNamedParameterJdbcTemplate(template);

        Virus virus = userDao.findByName("corona");

        Assert.assertNotNull(virus);
        Assert.assertEquals(2, virus.getId().intValue());
        Assert.assertEquals("corona", virus.getName());
        Assert.assertEquals("pandemic", virus.getResult());
    }

    @After
    public void tearDown() {
        db.shutdown();
    }
}