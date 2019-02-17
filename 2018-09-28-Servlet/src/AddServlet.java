import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class AddServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletRequest res )
	{
		int i = Integer.parseInt(req.getParameter("num"));
		
		System.out.println(i);
	}
}
