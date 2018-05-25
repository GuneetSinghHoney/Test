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
			//getting the instanciated object and getting the values
		
			Lottery lot = Lottery.getInstance();
			System.out.println(lot.getPot()+"  "+lot.getSoldTickets());
			//Setting the request variables for GUI
		
			request.setAttribute("pot", Math.round(lot.getPot()));
			request.setAttribute("list", lot.getSoldTickets());
			
			//Forwarding the request to jsp page
			RequestDispatcher disp = request.getRequestDispatcher("GUI/Index.jsp");
			disp.forward(request, response);
		}
		else if(action.equals("buySecure"))
		{
			System.out.println("buy ticket");
			//Buying the Ticket
			//getting the first name ang using the function to buy a ticket
			String name = request.getParameter("first");
			Lottery lot = Lottery.getInstance();
			int num = lot.buyTicket(name);
			if(num == -1)
			{
				//if all tickets are sold
				response.getWriter().println("<h1>ALL TICKETS ARE SOLD</h1>");
			}
			else {
				//All tickets purchased
			request.setAttribute("num", num);
			request.setAttribute("name", name);
			RequestDispatcher disp = request.getRequestDispatcher("GUI/ticket.jsp");
			disp.forward(request, response);
			}
		}
		else if(action.equals("buy"))
		{
			//Requesting the buy jsp
			System.out.println("buy");
			RequestDispatcher disp = request.getRequestDispatcher("GUI/buy.jsp");
			disp.forward(request, response);
		}
		else if(action.equals("draw"))
		{
			System.out.println("draw");
			//Calling the draw function and getting 3 tickets prizes
			Lottery lot = Lottery.getInstance();
			Ticket[] t = lot.draw();
			
			//Setting request variables
			request.setAttribute("win",t);
			request.setAttribute("pot", lot.getPot());
		
			//Dispathing the request
			RequestDispatcher disp = request.getRequestDispatcher("GUI/draw.jsp");
			disp.forward(request, response);
		}
		else if(action.equals("win"))
		{
			//Checking the Winners of draw
			Lottery lot = Lottery.getInstance();
			Ticket[] t = lot.getWinners();
			if(t==null)
			{
				//If no draw is declared. 
				RequestDispatcher disp = request.getRequestDispatcher("GUI/error.jsp");
				disp.forward(request, response);
			}
			else {
				//declare the result
			request.setAttribute("win",t);
			request.setAttribute("pot", lot.getPot());
			
			RequestDispatcher disp = request.getRequestDispatcher("GUI/win.jsp");
			disp.forward(request, response);
			}
		}
		else if(action.equals("next"))
		{
			//Next will start the lottery again clearing the list for sold tickets.
			Lottery.getInstance().resetTickets();
			RequestDispatcher disp = request.getRequestDispatcher("Control?Action=admin");
			disp.forward(request, response);
		}
		else if(action.equals("reset"))
		{
			//Reset
			Lottery lot = Lottery.getInstance();
			lot.reset();
			RequestDispatcher disp = request.getRequestDispatcher("Control?Action=admin");
			disp.forward(request, response);
		}
		else if(action.equals("quit"))
		{
			//Quit
			Lottery.getInstance().reset();
			RequestDispatcher disp = request.getRequestDispatcher("GUI/quit.jsp");
			disp.forward(request, response);
		}
		else if(action.equals("error"))
		{
			//Error redirection
			RequestDispatcher disp = request.getRequestDispatcher("GUI/error.jsp");
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
