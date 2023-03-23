package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pessoa;
import repository.PessoaRepository;

/**
 * Servlet implementation class pessoaServlet
 */
@WebServlet("/novaEmpresa")
public class pessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pessoaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ex01
		/*
		String name = request.getParameter("nome");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Empresa</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>");
		out.println(name);
		out.println("<h1>");
		out.println("</body>");
		out.println("</html>");
		System.out.print(name);
		response.getWriter().append("Served at: ").append(request.getContextPath());*/
		
		ArrayList<Pessoa> pessoas = PessoaRepository.getPessoas();

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Empresa</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<ul>");
 		for(Pessoa pessoa : pessoas) {
			out.println("<li>"+"Nome empresa: " +pessoa.getNome()+ " | CNPJ:" + String.valueOf(pessoa.getId())+ "</li>");
		};
		out.println("</ul>");
		out.println("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		Pessoa pessoa = new Pessoa(Long.valueOf(id), nome);
		PessoaRepository.addPessoa(pessoa);
		PessoaRepository.getPessoas().forEach(e -> System.out.println(e.getNome()));
		doGet(request, response);
	
	}

}
