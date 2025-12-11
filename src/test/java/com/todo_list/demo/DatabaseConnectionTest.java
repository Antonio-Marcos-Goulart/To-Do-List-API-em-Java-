package com.todo_list.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DatabaseConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Test
    void testDattabaseConnection() throws Exception {
        Connection connection  = dataSource.getConnection();
        assertNotNull(connection);
        System.out.println("Conectado com o baanco de dados");
        connection.close();
    }

}
