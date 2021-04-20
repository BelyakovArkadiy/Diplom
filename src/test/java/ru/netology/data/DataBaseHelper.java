package ru.netology.data;

import lombok.val;

import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class DataBaseHelper {
    private static final String url = System.getProperty("url");
    private static final String user = "user";
    private static final String password = "pass";
    private DataBaseHelper() {
    }

    public static String getStatusPaymentWithoutCredit() {
        val statusSql = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";

        try (
                val connection = getConnection(url, user, password);
//                val connection = getConnection("jdbc:postgresql://localhost:5432/app", "user", "pass");
                val statusStmt = connection.createStatement();
        ) {
            try (val rs = statusStmt.executeQuery(statusSql)) {
                if (rs.next()) {
                    val status = rs.getString(1);

                    return status;
                }
                return null;
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static String getStatusPaymentWithCredit() {
        val statusSql = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";

        try (
                val connection = getConnection(url, user, password);
//                val connection = getConnection("jdbc:postgresql://localhost:5432/app", "user", "pass");
                val statusStmt = connection.createStatement();
        ) {
            try (val rs = statusStmt.executeQuery(statusSql)) {
                if (rs.next()) {
                    val status = rs.getString(1);

                    return status;
                }
                return null;
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void cleanDataBase() {

        val pays = "DELETE FROM payment_entity";
        val credits = "DELETE FROM credit_request_entity";
        val orders = "DELETE FROM order_entity";

        try (
                val connection = getConnection(url, user, password);
//                val connection = getConnection("jdbc:postgresql://localhost:5432/app", "user", "pass");

                val prepareStatPay = connection.createStatement();
                val prepareStatCredit = connection.createStatement();
                val prepareStatOrder = connection.createStatement();

        ) {
            prepareStatPay.executeUpdate(pays);
            prepareStatCredit.executeUpdate(credits);
            prepareStatOrder.executeUpdate(orders);

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}