package model.da;

import model.entity.Person;
import model.entity.Services;
import model.entity.Timing;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimingDa implements AutoCloseable{
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    public TimingDa() throws SQLException {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }


    public void save(Timing timing) throws SQLException {

        timing.setTimeId(ConnectionProvider.getConnectionProvider().getNextId("TIMING_SEQ"));

        preparedStatement = connection.prepareStatement(
                "INSERT INTO SERVICES (TIMEID, STARTTIME, ENDTIME, DOCTOR_ID) VALUES (?, ?, ?, ?)"
        );
        preparedStatement.setInt(1, timing.getTimeId());
        preparedStatement.setDate(2, Date.valueOf(String.valueOf(timing.getStartTime())));
        preparedStatement.setDate(3, Date.valueOf(String.valueOf(timing.getEndTime())));
        preparedStatement.setInt(4, Integer.parseInt(String.valueOf(timing.getDoctor().getId())));
    }


    public void edit(Timing timing) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "UPDATE SERVICES SET STARTTIME = ?, ENDTIME = ?, DOCTOR_ID = ? WHERE TIMEID = ?"
        );

        preparedStatement.setDate(1, Date.valueOf(String.valueOf(timing.getStartTime())));
        preparedStatement.setDate(2, Date.valueOf(String.valueOf(timing.getEndTime())));
        preparedStatement.setInt(3, Integer.parseInt(String.valueOf(timing.getDoctor().getId())));
        preparedStatement.setInt(4, Integer.parseInt(String.valueOf(timing.getTimeId())));
        preparedStatement.execute();
    }

    public void remove(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "DELETE FROM TIMIN WHERE TIMEID = ?"
        );

        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public Timing findById(int id) throws SQLException {

        preparedStatement = connection.prepareStatement("SELECT * FROM PERSON WHERE ID = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        Timing timing = null;
        if (resultSet.next()) {
            timing = Timing
                    .builder()
                    .timeId(resultSet.getInt("TIMEID"))
                    .startTime(LocalDateTime.from(resultSet.getDate("STARTTIME").toLocalDate()))
                    .endTime(LocalDateTime.from(resultSet.getDate("ENDTIME").toLocalDate()))
                    .doctor(Person.builder().id(resultSet.getInt("DOCTOR_ID")).build())
                    .build();
        }
        return timing;
    }

@Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
