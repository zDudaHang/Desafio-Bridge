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
import util.Formatting;


/** The servlet class for the calculator
 *  Purpose: Calculates the factorial of a number, which is obtained through a request from cadastro.jsp, and
 *  returns the result to the same .jsp
 * @author Maria Eduarda de Melo Hang
*/
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
		
		// Testing if the number is a empty string
		if (parameter != "") {
			int number = Integer.parseInt(parameter);
			BigInteger result = calculatorService.calculate(number);
			
			// Testing if the result was -1, indicating a invalid entry
			if (result.compareTo(BigInteger.valueOf(-1)) == 0) {
				request.setAttribute("result", "Opa ! Voce enviou um numero negativo");
			} else {
				request.setAttribute("result", Formatting.formatResult(result));
			}
		}
		
		request.setAttribute("history", calculatorService.getHistory());
		RequestDispatcher rd = request.getRequestDispatcher("calculator.jsp");
		rd.forward(request, response);
	}

}
