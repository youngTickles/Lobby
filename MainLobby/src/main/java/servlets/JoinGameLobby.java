package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Game.MainLobby;



@WebServlet(
name = "joingamelobby",
urlPatterns = {"/JoinGameLobby"}
)
public class JoinGameLobby extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		
		String gameID=request.getParameter("gameID");
		String userName=request.getParameter("userName");
		//Here should be Kholoud Active user list request and updating my own list
		
		int gameId=Integer.parseInt(gameID);
		
		MainLobby.getInstance().JoinGameLobby(userName, gameId);
		
		//printing
		String mainlobby =MainLobby.getInstance().toJson();
		
		 PrintWriter out = response.getWriter();
	     out.print(mainlobby);

	}


}