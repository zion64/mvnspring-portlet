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

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

/**
 * Controller Class for 'firstportlet' portlet
 * 
 * If you want to use Spring Web MVC Porlet then follow the instructions
 * contained in this article <a href=
 * 'http://www.opensource-techblog.com/2012/09/spring-mvc-portlet-in-liferay.html'>Spri
 * n g MVC Portlet in Liferay</a>. Here you will use the Annotated Classes for
 * Spring Framework 2.5.x, in this portlet Spring Framework 3.2.3.RELEASE is
 * used. You can also follow the documentation contained in the official Spring
 * Framework doc site. http://static.springsource.org/spring/docs
 * /3.2.x/spring-framework-reference/html/portlet.html
 * 
 * A reference also is: <a href=
 * 'http://portalhub.wordpress.com/2012/05/12/spring-mvc-portlet-hello-world-based-on-annotations'>Spri
 * n g MVC Portlet Hello World with annotations</a>
 * 
 * @since 1.5(JDK), Jul.16/2013
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Jul.16/2013
 */

@RequestMapping("VIEW")
@Controller("firstPortletController")
public class FirstPortletController {
	private static Logger	_log	= Logger.getLogger(FirstPortletController.class);

	@ExceptionHandler({ Exception.class })
	public String handleException() {
		return "errorPage";
	}

	@RenderMapping
	public String showHomePage(RenderRequest request, RenderResponse response, Model model) {
		_log.info("Inside FirstPortletController -> showHomePage");
		return "first/show";

	}

	@ResourceMapping
	public void serveResource(ResourceRequest request, ResourceResponse response)
	{
		System.out.println("method called");
		try {
			response.getWriter().write("<h1>Hello</h1>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
