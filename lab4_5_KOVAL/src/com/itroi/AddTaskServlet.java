package com.itroi;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import webservice.TaskManager;
import webservice.TaskManagerImp;

/**
 * Servlet implementation class AddTaskServlet
 */
@WebServlet("/AddTaskServlet")
public class AddTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddTaskServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("greeting", "Hi!At this page you can add task to DataBase");
		request.getRequestDispatcher("/jspPages/addTask.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		URL url = new URL("http://localhost:1986/taskmanager?wsdl");
		QName qname = new QName("http://itroi.com/" ,"TaskManagerImpService");
		Service service = Service.create(url, qname);
		QName port_name = new QName("http://itroi.com/","taskmanager");
		TaskManager manager = service.getPort(port_name,TaskManager.class);
		String title = request.getParameter("title");
		String userName = request.getParameter("userName");
		String startDate = request.getParameter("startDate");
		String finishDate = request.getParameter("finishDate");
		String desc = request.getParameter("description");
		try{
		request.setAttribute("result", manager.addTask(userName, title, desc, startDate, finishDate));
		}catch(Exception e) {
			request.setAttribute("result","<h3>Возникла ошибка</h3>");
		}
		doGet(request,response);
	}

}
