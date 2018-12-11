package com.practice.SpringMvcCrudProject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


public class EmpCrudController extends  MultiActionController  {
		EmployeeService empService=new EmployeeService();
		
		public ModelAndView empsave(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String address=request.getParameter("address");
			System.out.println("name "+ name+ " email "+ email + " address "+ address);
			int count=empService.createEmployee(name,email,address);
			ModelAndView modelAndView=null;
			if(count!=0) {
				modelAndView=new ModelAndView("success");
			} else {
				modelAndView=new ModelAndView("failure");
			}
			
			
			return modelAndView;
		}
	
	}

	


