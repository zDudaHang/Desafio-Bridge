package controller;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CalculatorService;

@WebServlet("/Calculate")
public class CalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CalculatorService calculatorService = null;
	
    public CalculateServlet() {
        super();
        this.calculatorService = new CalculatorService();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parameter = request.getParameter("number");
		
		if (parameter != "") {
			int number = Integer.parseInt(parameter);
			BigInteger result = calculatorService.calculate(number);
			request.setAttribute("result", CalculatorService.formatResult(result));
		}
		
		request.setAttribute("history", calculatorService.getHistory());
		RequestDispatcher rd = request.getRequestDispatcher("calculator.jsp");
		rd.forward(request, response);
	}

}
