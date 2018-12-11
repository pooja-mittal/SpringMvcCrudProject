package com.practice.SpringMvcCrudProject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpCrudController {
		EmployeeService empService=new EmployeeService();
		
		@RequestMapping("/empSave")
		public ModelAndView addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String address=request.getParameter("address");
			System.out.println("name "+ name+ " email "+ email + " address "+ address);
			int count=empService.createEmployee(name,email,address);
			ModelAndView modelAndView=null;
			if(count!=0) {
				modelAndView=new ModelAndView();
				modelAndView.setViewName("success.jsp");
			} else {
				modelAndView=new ModelAndView("failure");
			}
			
			
			return modelAndView;
		}
	
	}

	


