package model.da;

import model.entity.Person;
import model.entity.Timing;
import model.tools.CRUD;
import model.tools.ConnectionProvider;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class TimingDa implements AutoCloseable, CRUD<Timing> {
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    public TimingDa() throws SQLException {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }



    @Override
    public Timing save(Timing timing) throws Exception {
        timing.setTimeId(ConnectionProvider.getConnectionProvider().getNextId("TIMING_SEQ"));

        preparedStatement = connection.prepareStatement(
                "INSERT INTO TIMING (ID, START_TIME, END_TIME, DOCTOR_ID, LOCATION, ROOM_NUMBER) VALUES (?, ?, ?, ?, ?, ?)"
        );
        preparedStatement.setInt(1, timing.getTimeId());
        preparedStatement.setDate(2, Date.valueOf(String.valueOf(timing.getStartTime())));
        preparedStatement.setDate(3, Date.valueOf(String.valueOf(timing.getEndTime())));
        preparedStatement.setInt(4, Integer.parseInt(String.valueOf(timing.getDoctor().getId())));
        preparedStatement.setString(5, timing.getLocation());
        preparedStatement.setInt(6, Integer.parseInt(String.valueOf(timing.getRoomNumber())));
        return timing;
    }

    @Override
    public Timing edit(Timing timing) throws Exception {
        return null;
    }

    @Override
    public Timing remove(int id) throws Exception {
        return null;
    }

    @Override
    public List<Timing> findAll() throws Exception {
        return Collections.emptyList();
    }

    @Override
    public Timing findById(int id) throws Exception {
        return null;
    }




    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
