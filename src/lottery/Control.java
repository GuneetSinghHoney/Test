package lottery;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Control
 */
@WebServlet("/Control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Control() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("Action");
		
		if(action.equals("admin"))
		{
			System.out.println("admin");
			
			Lottery lot = Lottery.getInstance();
			System.out.println(lot.getPot()+"  "+lot.getSoldTickets());
			request.setAttribute("pot", Math.round(lot.getPot()));
			request.setAttribute("list", lot.getSoldTickets());
			
			RequestDispatcher disp = request.getRequestDispatcher("GUI/Index.jsp");
			disp.forward(request, response);
		}
		else if(action.equals("buySecure"))
		{
			System.out.println("buy ticket");
			String name = request.getParameter("first");
			Lottery lot = Lottery.getInstance();
			int num = lot.buyTicket(name);
			if(num == -1)
			{
				//All tickets purchased
				response.getWriter().println("<h1>ALL TICKETS ARE SOLD</h1>");
			}
			else {
			request.setAttribute("num", num);
			request.setAttribute("name", name);
			RequestDispatcher disp = request.getRequestDispatcher("GUI/ticket.jsp");
			disp.forward(request, response);
			}
		}
		else if(action.equals("buy"))
		{
			System.out.println("buy");
			RequestDispatcher disp = request.getRequestDispatcher("GUI/buy.jsp");
			disp.forward(request, response);
		}
		else if(action.equals("draw"))
		{
			System.out.println("draw");
			Lottery lot = Lottery.getInstance();
			Ticket[] t = lot.draw();
			request.setAttribute("win",t);
			request.setAttribute("pot", lot.getPot());
			lot.reset();
			RequestDispatcher disp = request.getRequestDispatcher("GUI/draw.jsp");
			disp.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
