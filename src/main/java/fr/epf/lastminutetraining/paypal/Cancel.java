package fr.epf.lastminutetraining.paypal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cancel extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
response.setContentType("text/html");

		response.getWriter().println("<script>");
		response.getWriter().println("alert(\"Payment Failed\");");
		response.getWriter()
				.println("// add relevant message above or remove the line if not required");
		response.getWriter().println("window.onload = function(){");
		response.getWriter().println("if(window.opener){");
		response.getWriter().println("window.close();");
		response.getWriter().println("	}");
		response.getWriter().println("else{");
		response.getWriter().println("if(top.dg.isOpen() == true){");
		response.getWriter().println("top.dg.closeFlow();");
		response.getWriter().println("return true;");
		response.getWriter().println("}");
		response.getWriter().println("}");
		response.getWriter().println("	};");

		response.getWriter().println("</script>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}