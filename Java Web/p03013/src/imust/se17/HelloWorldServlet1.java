package imust.se17;


import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;


public class HelloWorldServlet1 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HelloWorldServlet1() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
		System.out.println("destroy method is called!");
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		System.out.println("init method is called!");
	}

	
	public void service (ServletRequest request, ServletResponse response){
		System.out.println(" service method is called!");
	}
	
}
