package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.app.model.SleepEntry;
import com.app.utils.JDBCConnection;

public class SleepEntryDaoImpl implements SleepEntryDao {

	private static final String INSERT_SLEEPS_QUERY = "INSERT INTO sleeps"
			+ "  (date,sleep_time,wakeup_time,total_sleep_duration,user_id) VALUES " + " (?, ?, ?, ?, ?);";
	private static final String SELECT_SLEEP_BY_ID = "select id,date,sleep_time,wakeup_time,total_sleep_duration,user_id from sleeps where id =?";
	private static final String SELECT_ALL_SLEEPS = "select * from sleeps";
	private static final String DELETE_SLEEP_BY_ID = "delete from sleeps where id = ?;";
	private static final String UPDATE_SLEEP = "update sleeps set date = ?, sleep_time = ?, wakeup_time =?, total_sleep_duration = ?, user_id = ? where id = ?;";

	public SleepEntryDaoImpl() {
	}

	@Override
	public void insert(SleepEntry sleep) throws SQLException {
		System.out.println(INSERT_SLEEPS_QUERY);
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SLEEPS_QUERY)) {
			preparedStatement.setDate(1, JDBCConnection.getSQLDate(sleep.getDate()));
			preparedStatement.setTime(3, sleep.getSleepTime());
			preparedStatement.setTime(2, sleep.getWakeUpTime());
			preparedStatement.setInt(4, sleep.getSleepDuration());
			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			JDBCConnection.printSQLException(exception);
		}
	}

	@Override
	public SleepEntry select(long sleepId) {
		SleepEntry sleep = null;
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SLEEP_BY_ID);) {
			preparedStatement.setLong(1, sleepId);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				LocalDate date = rs.getDate("date").toLocalDate();
				Time sleepTime = rs.getTime("sleep_time");
				Time wakeTime = rs.getTime("wakeup_time");
				int sleepDuration = rs.getInt("total_sleep_duration");
				sleep = new SleepEntry(id, date, sleepTime, wakeTime, sleepDuration);
			}
		} catch (SQLException exception) {
			JDBCConnection.printSQLException(exception);
		}
		return sleep;
	}

	@Override
	public List<SleepEntry> selectAllSleepEntries() {
		List<SleepEntry> sleeps = new ArrayList<>();
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SLEEPS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				LocalDate date = rs.getDate("date").toLocalDate();
				Time sleepTime = rs.getTime("sleep_time");
				Time wakeTime = rs.getTime("wakeup_time");
				int sleepDuration = rs.getInt("total_sleep_duration");
				SleepEntry sleep = new SleepEntry(id, date, sleepTime, wakeTime, sleepDuration);
				sleeps.add(sleep);
			}
		} catch (SQLException exception) {
			JDBCConnection.printSQLException(exception);
		}
		return sleeps;
	}

	@Override
	public boolean deleteSleepEntry(int id) throws SQLException {
		boolean deletedRow;
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_SLEEP_BY_ID);) {
			statement.setInt(1, id);
			deletedRow = statement.executeUpdate() > 0;
		}
		return deletedRow;
	}

	@Override
	public boolean updateSleepEntry(SleepEntry sleep) throws SQLException {
		boolean updatedRow;
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_SLEEP);) {
			statement.setDate(1, JDBCConnection.getSQLDate(sleep.getDate()));
			statement.setTime(3, sleep.getSleepTime());
			statement.setTime(2, sleep.getWakeUpTime());
			statement.setInt(4, sleep.getSleepDuration());
			updatedRow = statement.executeUpdate() > 0;
		}
		return updatedRow;
	}
}
