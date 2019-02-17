package elsys;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, String> mp = new HashMap<String, String>();
    private String Key_ = "null";
    private String Value_ = "null";
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    public Servlet() {
    	mp.put("1", "Elon Musk");
        mp.put("2", "Tesla");
        mp.put("3", "SpaceX");
        mp.put("4", "Falcon");
        mp.put("5", "NASA");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().write("<html>\n" +
												"	<style>" +
												"input[type=text], select {" +
											    "width: 100%;" +
											    "padding: 12px 20px;" +
											    "margin: 8px 0;" +
											    "display: inline-block;" +
											    "border: 1px solid #ccc;" +
											    "border-radius: 4px;" +
											    "box-sizing: border-box;" +
											"}" +
									
											"input[type=submit] {" +
											    "width: 100%;" +
											    "background-color: #4CAF50;" +
											    "color: white;" +
											    "padding: 14px 20px;" +
											    "margin: 8px 0;" +
											    "border: none;" +
											    "border-radius: 4px;" +
											    "cursor: pointer;" +
											"}" +
									
											"input[type=submit]:hover {" +
											 "   background-color: #45a049;" +
											"}" +
									
											"div {" +
											   "border-radius: 5px;" +
											   "background-color: #f2f2f2;" +
											   "padding: 20px;" +
											   "width: 50%;" + 
											"}" +
											"</style>" +
				
					                "  <head>\n" +
					                
					                "    <title>Servlet</title>\n" +
					                "	 <meta charset=\"utf-8\"> " +
					                " <meta name=\"viewport\" content=\" width=device-width, initial-scale=1> " +
					                " <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"> " +
					                " <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>" +
					                "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>" +
					                
					                "  </head>\n" +
					                "  <body>\n" +
					                
									"<div class=\"container\">" +
					                "<h2>Form control: input</h2>" + "<br>" +
					                "    <form method=\"post\">\n" +
					                "      Key:<br>\n" +
					                "      <input type=\"text\" name=\"key\"><br>\n" +
					                "      Value:<br>\n" +
					                "      <input type=\"text\" name=\"value\"><br>\n" +
					                "      <input type=\"submit\">\n" +
					                "    </form>\n" +
					                "<p>" +
					                
					                "Collection content:<br>\n" + mp.get(Key_) + "<br><br>"+"\n" +
					                "Your key:<br>\n" + Key_ + "<br><br>" + "\n" +
					                "Your value:<br>\n" + Value_ + "<br>" + "\n" +
					                "</p>" +
					                "</div>" +
					                
					                "  </body>\n" +
					"</html>\n");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// curl http://localhost:8080/DemoApp/Servlet -d "key=2&value=Tesla"
		Key_ = request.getParameter("key");
		Value_ = request.getParameter("value");
		
		doGet(request, response);
	}

}
