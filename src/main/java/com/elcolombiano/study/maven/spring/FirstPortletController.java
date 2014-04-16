/*----------------------------------------------------------------------------*/
/* Source File: FIRSTPORTLETCONTROLLER.JAVA */
/* Description: Controller Class for 'firstportlet' portlet. */
/* Author: Carlos Adolfo Ortiz Quirós (COQ) */
/* Date: Jul.16/2013 */
/* Last Modified: Jul.16/2013 */
/* Version: 1.1 */
/* Copyright (c), 2013 CSoftZ */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jul.16/2013 COQ  File created.
 -----------------------------------------------------------------------------*/

/*
 * Jul.16/2013 If you want to use Spring Web MVC Porlet then follow the
 * instructions contained in this article Here you will use the Annotated
 * Classes for Spring Framework 2.5.x, in this portlet Spring Framework
 * 3.2.3.RELEASE is used. You can also follow the documentation contained in the
 * official Spring Framework doc site.
 * http://static.springsource.org/spring/docs
 * /3.2.x/spring-framework-reference/html/portlet.html
 * 
 * A reference also is:
 * http://portalhub.wordpress.com/2012/05/12/spring-mvc-portlet
 * -hello-world-based-on-annotations
 */
package com.elcolombiano.study.maven.spring;

import java.io.IOException;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.ktds.isc.repo.RequestofdeletingsmartsheetHome;

/**
 * Controller Class for 'firstportlet' portlet
 * 
 * If you want to use Spring Web MVC Porlet then follow the instructions
 * contained in this article <a href=
 * 'http://www.opensource-techblog.com/2012/09/spring-mvc-portlet-in-liferay.html'>Sp
 * r i n g MVC Portlet in Liferay</a>. Here you will use the Annotated Classes
 * for Spring Framework 2.5.x, in this portlet Spring Framework 3.2.3.RELEASE is
 * used. You can also follow the documentation contained in the official Spring
 * Framework doc site. http://static.springsource.org/spring/docs
 * /3.2.x/spring-framework-reference/html/portlet.html
 * 
 * A reference also is: <a href=
 * 'http://portalhub.wordpress.com/2012/05/12/spring-mvc-portlet-hello-world-based-on-annotations'>Sp
 * r i n g MVC Portlet Hello World with annotations</a>
 * 
 * @since 1.5(JDK), Jul.16/2013
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Jul.16/2013
 */

@RequestMapping("VIEW")
@Controller("firstPortletController")
public class FirstPortletController {
	private static Logger					_log	= LoggerFactory.getLogger(FirstPortletController.class);

	@Autowired(required = false)
	private RequestofdeletingsmartsheetHome requestofdeletingsmartsheetHome;

//	@ExceptionHandler(Exception.class)
//	public ModelAndView handleIOException(Exception ex) {
//		_log.info("handleException - Catching: " + ex.getClass().getSimpleName());
//		return errorModelAndView(ex);
//	}
//
//	private ModelAndView errorModelAndView(Exception ex) {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("general-error");
//		modelAndView.addObject("name", ex.getClass().getSimpleName());
//		modelAndView.addObject("message", ex.getMessage());
//		return modelAndView;
//	}
//
//	@ExceptionHandler({ NullPointerException.class, NoSuchRequestHandlingMethodException.class })
//	public ModelAndView handleExceptionArray(Exception ex) {
//
//		_log.info("handleExceptionArray - Catching: " + ex.getClass().getSimpleName());
//		return errorModelAndView(ex);
//	}

	@RenderMapping
	public String showHomePage(RenderRequest request, RenderResponse response, Model model) {
		_log.info("Inside FirstPortletController -> showHomePage");
		model.addAttribute("smartsheets", requestofdeletingsmartsheetHome.findAllSortedDesc());
		return "first/show";

	}

	// @ResourceMapping
	// public void serveResource(ResourceRequest request, ResourceResponse
	// response)
	// {
	// System.out.println("method called");
	// try {
	// response.getWriter().write("<h1>Hello</h1>");
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
}
