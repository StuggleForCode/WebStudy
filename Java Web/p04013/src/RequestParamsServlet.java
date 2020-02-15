import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestParamsServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		//1.接收用户输入的参数值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String[] hobby = request.getParameterValues("hobby");
		//2.显示用户输入的参数值
		System.out.println("username = " + username);
		System.out.println("password = " + password);
		for(int i = 0; i < hobby.length; i++){
//			System.out.println("jj");
			System.out.println(hobby[i] + ',');
		}
	}
}
