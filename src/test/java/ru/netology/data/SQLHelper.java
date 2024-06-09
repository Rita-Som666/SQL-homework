package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {
    private static final QueryRunner QUERY_RUNNER = new QueryRunner();

    private SQLHelper() {
    }

    private static Connection getConn() throws SQLException {
        return DriverManager.getConnection(System.getProperty("db.url"), "user", "password");
    }

    @SneakyThrows
    public static String getVerCode() {
        var sqlCode = "SELECT code FROM auth_codes ORDER BY created DESC LIMIT 1";
        var conn = getConn();

        return QUERY_RUNNER.query(conn, sqlCode, new ScalarHandler<>());

    }

    @SneakyThrows
    public static void cleaner() {
        var conn = getConn();

        QUERY_RUNNER.update(conn, "DELETE FROM card_transactions");
        QUERY_RUNNER.update(conn, "DELETE FROM cards");
        QUERY_RUNNER.update(conn, "DELETE FROM auth_codes");
        QUERY_RUNNER.update(conn, "DELETE FROM users");


    }

    @SneakyThrows
    public static void cleanCodes() {
        var conn = getConn();

        QUERY_RUNNER.update(conn, "DELETE FROM auth_codes");


    }
}
