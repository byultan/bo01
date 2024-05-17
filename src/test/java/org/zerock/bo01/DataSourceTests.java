package org.zerock.bo01;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
@Log4j2
public class DataSourceTests {

    @Autowired
    private DataSource datasource;

    @Test
//  test경우 public void
    public void testConnection() throws Exception {
        @Cleanup Connection con = datasource.getConnection();
        System.out.println("testSuc");
        log.info(con);
        Assertions.assertNotNull(con);
    }
}