package com.kinsha.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateEmp")
public class UpdateEmp extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String eid = req.getParameter("eid");
		String ename = req.getParameter("ename");
		String email = req.getParameter("email");
		EmpDto dto = new EmpDto();
		int id1 = Integer.parseInt(id);
		dto.setEid(Integer.parseInt(eid));
		dto.setEname(ename);
		dto.setEmail(email);
		if (new EmpDao().updateEmp(dto, id1)) {
			resp.sendRedirect("manageEmployee.jsp");
		} else {
			System.out.println("Failed");
		}
	}
}
