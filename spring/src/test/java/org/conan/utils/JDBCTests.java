package org.conan.utils;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;

@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class JDBCTests{
    @Setter(onMethod_ = {@Autowired})
    private DataSource ds;

    @Test
    public void testConnection(){
        try(Connection conn = ds.getConnection()){
            log.info(conn);
        }
        catch(Exception e){
        }
    }
}