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
name = "getgamelobbydata",
urlPatterns = {"/GetGameLobbyData"}
)
public class GetGameLobbyData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String userName=request.getParameter("userName");
	
		//Here should be Kholoud Active user list request and updating my own list
		String gameLobby=MainLobby.getInstance().getGameLobbyfromUsername(userName).ToJSon();
	
		 PrintWriter out = response.getWriter();
	     out.print(gameLobby);
	}


}