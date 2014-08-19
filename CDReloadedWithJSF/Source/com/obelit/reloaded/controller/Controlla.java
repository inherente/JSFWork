package com.obelit.reloaded.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inherente.pool.db.SimpleConnectionPool;// import com.inherente.reloaded.bean.ReportHeader;
import com.inherente.reloaded.core.ServletHandler;
import com.obelit.cc.model.WorkingDocument;
import com.obelit.db.pool.Reusable;
import com.obelit.db.pool.ReusablePool;
import com.obelit.reloaded.util.Helper;
import com.sun.istack.internal.logging.Logger;


/**
 * Servlet implementation class Controlla
 */
@WebServlet(description = "Controlla Servlet", urlPatterns = { "/Controlla" })
public class Controlla extends HttpServlet {

	ReusablePool pool;
	Reusable conn;// private ReportHeader reportHeader;
	WorkingDocument docDAO;
	ServletHandler handler ;
	private static Logger log =Logger.getLogger(CDController.class);
	private static final String WELCOME_PAGE = "grid.jsp";
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlla() {
        super();
		pool = new SimpleConnectionPool(1, "connection.properties");// pool = new SimpleConnectionPool().createInstance(SimpleConnectionPool.DEFAULT_IMPLEMENTATION, "\\connection.properties");
		conn= pool.acquireReusable();
		handler = new ServletHandler(conn);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response) ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response) ;
	}

	private void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String,Object> map = null;
		log.info("init");
        map= handler.handleRequest(request, getServletContext());
        Helper.setAttibutes(request, map);

		request.getRequestDispatcher(WELCOME_PAGE).forward(request, response);
	}

}
