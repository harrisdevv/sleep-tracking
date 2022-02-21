package com.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.model.SleepEntry;

public interface SleepEntryDao {

	void insert(SleepEntry sleepEntry) throws SQLException;

	SleepEntry select(long sleepEntryId);

	List<SleepEntry> selectAllSleepEntries();

	boolean deleteSleepEntry(int sleepEntryId) throws SQLException;

	boolean updateSleepEntry(SleepEntry sleepEntry) throws SQLException;

}