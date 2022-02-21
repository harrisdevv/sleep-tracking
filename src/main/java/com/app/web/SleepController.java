package com.app.web;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.SleepEntryDao;
import com.app.dao.SleepEntryDaoImpl;
import com.app.dao.UserDao;
import com.app.model.SleepEntry;
import com.app.model.User;

public class SleepController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SleepEntryDao sleepDAO;
	private UserDao userDao;

	public void init() {
		sleepDAO = new SleepEntryDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertSleep(request, response);
				break;
			case "/delete":
				deleteSleep(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateSleep(request, response);
				break;
			case "/list":
				listSleep(request, response);
				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listSleep(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> users = userDao.selectAllUsers();
		request.setAttribute("listUser", users);

		List<SleepEntry> listSleep = sleepDAO.selectAllSleepEntries();
		request.setAttribute("listSleep", listSleep);
		RequestDispatcher dispatcher = request.getRequestDispatcher("sleep/sleep-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("sleep/sleep-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		SleepEntry existingSleep = sleepDAO.select(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("sleep/sleep-form.jsp");
		request.setAttribute("sleep", existingSleep);
		dispatcher.forward(request, response);

	}

	private void insertSleep(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String date = request.getParameter("date");
		//String sleeptime = Time.valueOf(request.getTime("sleeptime"));
		String wakeuptime = request.getParameter("wakeuptime");
		//Int sleepDuration = request.getParameter("sleepdur");
		/*DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"),df);*/
		boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
		//sleepDAO.insert(newSleep);
		response.sendRedirect("list");
	}

	private void updateSleep(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
	}

	private void deleteSleep(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
	}
}
