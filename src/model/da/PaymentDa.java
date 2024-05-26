package model.da;

import model.entity.Payment;
import model.entity.Timing;
import model.enums.Vtype;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PaymentDa implements AutoCloseable {
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    public PaymentDa() throws SQLException {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }

    public void save(Payment payment) throws SQLException {
        payment.setPaymentId(ConnectionProvider.getConnectionProvider().getNextId("PAYMENT_SEQ"));

        preparedStatement = connection.prepareStatement(
                "INSERT INTO PAYMENT (paymentId, paymentTime, paymentStatus, paymentType) VALUES ( ?, ?, ?, ?)"
        );
        preparedStatement.setInt(1, payment.getPaymentId());
        preparedStatement.setDate(2, Date.valueOf(String.valueOf(payment.getPaymentTime())));
        preparedStatement.setString(3, payment.getPaymentStatus().toString());
        preparedStatement.setString(4, payment.getPaymentType().toString());

    }

    public void edit(Payment payment) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "UPDATE PAYMENT SET paymentTime = ?, paymentStatus = ?, paymentType = ?  WHERE paymentId = ?"
        );

        preparedStatement.setDate(1, Date.valueOf(payment.getPaymentTime().toString()));
        preparedStatement.setString(2, (payment.getPaymentStatus().toString()));
        preparedStatement.setString(3, payment.getPaymentType().toString());
        preparedStatement.setInt(4, payment.getPaymentId());
        preparedStatement.execute();
    }

    public void remove(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "DELETE FROM PAYMENT WHERE paymentId = ?"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }


    public static List<Payment> findAll() throws SQLException {
        List<Payment> paymentList = new ArrayList<>();
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM PAYMENT ORDER BY PAYMENT.PAYMENT_ID"
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Payment payment = Payment.builder()
                    .paymentId(resultSet.getInt("paymentId"))
                    // localTime????
                    .paymentTime(resultSet.getTimestamp("paymenttime").toLocalDateTime())
                    .paymentStatus(resultSet.getString("paymentStatus"))
                    .paymentType(Vtype.valueOf(resultSet.getString("PaymentType")))
                    .build();
        }
        return paymentList;
    }

    public Payment findById(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "select * from PAYMENT where paymentId = ?"
        );
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        Payment peyment = null;

        if (resultSet.next()) {
            Payment payment = Payment.builder()
                    .paymentId(resultSet.getInt("paymentId"))
                    .paymentTime(resultSet.getTimestamp("paymenttime").toLocalDateTime())
                    .paymentStatus(resultSet.getString("paymentStatus"))
                    .paymentType(Vtype.valueOf(resultSet.getString("PaymentType")))
                    .build();
        }


        return null;
    }


    public Payment findByDate(String startDate, String endDate) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "select * from PAYMENT where paymenttime between ? and ?"
        );
        preparedStatement.setInt(1, Integer.parseInt(startDate));
        preparedStatement.setInt(2, Integer.parseInt(endDate));
        ResultSet resultSet = preparedStatement.executeQuery();

        Payment peyment = null;

        if (resultSet.next()) {
            Payment payment = Payment.builder()
                    .paymentId(resultSet.getInt("paymentId"))
                    .paymentTime(resultSet.getTimestamp("paymenttime").toLocalDateTime())
                    .paymentStatus(resultSet.getString("paymentStatus"))
                    .paymentType(Vtype.valueOf(resultSet.getString("PaymentType")))
                    .build();
        }


        return peyment;
    }


    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
