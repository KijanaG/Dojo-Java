package com.codingdojo.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class guess
 */
@WebServlet("/guess")
public class guess extends HttpServlet {
	private int mathRando = 0;
	public int guess = 0;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public guess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(mathRando == 0) {
			System.out.println("In the Getter if statement");
			mathRando = (int) Math.floor(Math.random()*100);
			HttpSession session = request.getSession();
			session.setAttribute("random", mathRando);
			session.setAttribute("guess", 0);
			System.out.println("Random is "+session.getAttribute("random"));
			System.out.println("Guess is "+session.getAttribute("guess"));
		}
		System.out.println("Math Random "+mathRando);
		HttpSession session = request.getSession();
		int guess = (int) session.getAttribute("guess");
		System.out.println("Getter Guess "+ guess);
		if(guess == 0) {
			mathRando = (int) Math.floor(Math.random()*100);
			session.setAttribute("random", mathRando);
		}
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/greatNumberGame.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int number = Integer.parseInt(request.getParameter("number"));
		System.out.println("Post Guess "+number);
		HttpSession session = request.getSession();
		session.setAttribute("guess", number);
		response.sendRedirect("/Number_Game/guess");
	}

}
