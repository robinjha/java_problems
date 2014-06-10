package com.java.log4jjdbcappender;

import java.sql.Connection;
import org.apache.log4j.spi.LoggingEvent;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import org.apache.log4j.spi.ErrorCode;
import org.apache.log4j.PatternLayout;
import common.sql.MyDB;
import common.sql.GeneralDb;

public class JDBCPoolAppender extends org.apache.log4j.jdbc.JDBCAppender {

	private MyDB mydb = null;
	protected String sqlname=""; 

	protected Connection connection = null;
	protected String sqlStatement = "";
	/**
	 * size of LoggingEvent buffer before writting to the database.
	 * Default is 1.
	 */
	protected int bufferSize = 1;

	public JDBCPoolAppender() {
		super();
	}

	/**
	 * ArrayList holding the buffer of Logging Events.
	 */
	public void append(LoggingEvent event) {
		buffer.add(event);
		if (buffer.size() >= bufferSize)
			flushBuffer();
	}

	/**
	 * By default getLogStatement sends the event to the required Layout object.
	 * The layout will format the given pattern into a workable SQL string.
	 *
	 * Overriding this provides direct access to the LoggingEvent
	 * when constructing the logging statement.
	 *
	 */
	protected String getLogStatement(LoggingEvent event) {
		return getLayout().format(event);
	}

	/**
	 *
	 * Override this to provide an alertnate method of getting
	 * connections (such as caching).　One method to fix this is to open
	 * connections at the start of flushBuffer() and close them at the
	 * end.　I use a connection pool outside of JDBCAppender which is
	 * accessed in an override of this method.
	 * */
	protected void execute(String sql) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		try {
			con = getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			if (stmt != null)
				stmt.close();
			throw e;
		}
		stmt.close();
		closeConnection(con);
		//System.out.println("Execute: " + sql);
	}

	/**
	 * Override this to return the connection to a pool, or to clean up the
	 * resource.
	 *
	 * The default behavior holds a single connection open until the appender
	 * is closed (typically when garbage collected).
	 */
	protected void closeConnection(Connection con) {
		mydb=null;
		try {
			if (connection != null && !connection.isClosed())
				connection.close();
		} catch (SQLException e) {
			errorHandler.error("Error closing connection", e,
					ErrorCode.GENERIC_FAILURE);
		}

	}

	/**
	 * Override 此函数来利用连接池返回一个Connetion对象
	 *
	 */
	protected Connection getConnection() throws SQLException {
		try {
			mydb = GeneralDb.getInstance(sqlname);
			connection = mydb.getConnection();
		} catch (Exception e) {
			errorHandler.error("Error opening connection", e, ErrorCode.GENERIC_FAILURE);
		}
		return connection;
	}

	/**
	 * Closes the appender, flushing the buffer first then closing the default
	 * connection if it is open.
	 */
	public void close() {
		flushBuffer();

		try {
			if (connection != null && !connection.isClosed())
				connection.close();
		} catch (SQLException e) {
			errorHandler.error("Error closing connection", e,
					ErrorCode.GENERIC_FAILURE);
		}
		this.closed = true;
	}

	/**
	 * loops through the buffer of LoggingEvents, gets a
	 * sql string from getLogStatement() and sends it to execute().
	 * Errors are sent to the errorHandler.
	 *
	 * If a statement fails the LoggingEvent stays in the buffer!
	 */
	public void flushBuffer() {
		//Do the actual logging
		removes.ensureCapacity(buffer.size());
		for (Iterator i = buffer.iterator(); i.hasNext(); ) {
			try {
				LoggingEvent logEvent = (LoggingEvent) i.next();
				String sql = getLogStatement(logEvent);
				execute(sql);
				removes.add(logEvent);
			} catch (SQLException e) {
				errorHandler.error("Failed to excute sql", e,
						ErrorCode.FLUSH_FAILURE);
			}
		}

		// remove from the buffer any events that were reported
		buffer.removeAll(removes);

		// clear the buffer of reported events
		removes.clear();
	}

	/** closes the appender before disposal */
	public void finalize() {
		close();
	}

	/**
	 * JDBCAppender requires a layout.
	 * */
	public boolean requiresLayout() {
		return true;
	}

	/**
	 *
	 */
	public void setSql(String s) {
		sqlStatement = s;
		if (getLayout() == null) {
			this.setLayout(new PatternLayout(s));
		} else {
			((PatternLayout) getLayout()).setConversionPattern(s);
		}
	}

	/**
	 * Returns pre-formated statement eg: insert into LogTable (msg) values ("%m")
	 */
	public String getSql() {
		return sqlStatement;
	}

	public void setSqlname(String sqlname){
		sqlname=sqlname;
	}

	public String getSqlname(){
		return sqlname;
	}

	public void setBufferSize(int newBufferSize) {
		bufferSize = newBufferSize;
		buffer.ensureCapacity(bufferSize);
		removes.ensureCapacity(bufferSize);
	}

	public int getBufferSize() {
		return bufferSize;
	}
}