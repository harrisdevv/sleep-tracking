package com.app.model;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Objects;

public class SleepEntry {

	private Long id;
	private LocalDate date;
	private Time sleepTime;
	private Time wakeUpTime;
	private int sleepDuration; // in minutes

	public SleepEntry(Long id, LocalDate date, Time sleepTime, Time wakeUpTime, int sleepDuration) {
		this.id = id;
		this.date = date;
		this.sleepTime = sleepTime;
		this.wakeUpTime = wakeUpTime;
		this.sleepDuration = sleepDuration;
	}

	public SleepEntry(LocalDate date, Time sleepTime, Time wakeUpTime, int sleepDuration) {
		this.date = date;
		this.sleepTime = sleepTime;
		this.wakeUpTime = wakeUpTime;
		this.sleepDuration = sleepDuration;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Time getSleepTime() {
		return this.sleepTime;
	}

	public void setSleepTime(Time sleepTime) {
		this.sleepTime = sleepTime;
	}

	public Time getWakeUpTime() {
		return this.wakeUpTime;
	}

	public void setWakeUpTime(Time wakeUpTime) {
		this.wakeUpTime = wakeUpTime;
	}

	public int getSleepDuration() {
		return this.sleepDuration;
	}

	public void setSleepDuration(int sleepDuration) {
		this.sleepDuration = sleepDuration;
	}

	public SleepEntry id(Long id) {
		setId(id);
		return this;
	}

	public SleepEntry date(LocalDate date) {
		setDate(date);
		return this;
	}

	public SleepEntry sleepTime(Time sleepTime) {
		setSleepTime(sleepTime);
		return this;
	}

	public SleepEntry wakeUpTime(Time wakeUpTime) {
		setWakeUpTime(wakeUpTime);
		return this;
	}

	public SleepEntry sleepDuration(int sleepDuration) {
		setSleepDuration(sleepDuration);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof SleepEntry)) {
			return false;
		}
		SleepEntry sleepEntry = (SleepEntry) o;
		return Objects.equals(id, sleepEntry.id) && Objects.equals(date, sleepEntry.date) && Objects.equals(sleepTime, sleepEntry.sleepTime) && Objects.equals(wakeUpTime, sleepEntry.wakeUpTime) && sleepDuration == sleepEntry.sleepDuration;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, date, sleepTime, wakeUpTime, sleepDuration);
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", date='" + getDate() + "'" +
			", sleepTime='" + getSleepTime() + "'" +
			", wakeUpTime='" + getWakeUpTime() + "'" +
			", sleepDuration='" + getSleepDuration() + "'" +
			"}";
	}
	
	public SleepEntry() {
	}

}
