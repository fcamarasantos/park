package br.com.hackathonfc.park;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@WebServlet("file:///D:/projetos/cadastro.html?")
@SpringBootApplication
public class ParkApplication extends HttpServlet {
	public static void main(String[] args) {
		SpringApplication.run(ParkApplication.class, args);
	}
    private static final long serialVersionUID = 1L;
 

    private void processarRequisicao(HttpServletRequest request,
            HttpServletResponse response) throws ServletException {
 
        String action = request.getParameter("action");
 
        if (action == null) {
            throw new ServletException("No action specified.");
        } else if (action.equals("contratar")) {
            criarConta(request, response);
        }
    }
 
    private void criarConta(HttpServletRequest request,
            HttpServletResponse response) {
 
        String nome = request.getParameter("inputNome");
        String cnpj = request.getParameter("inputCPF");
        String endereco = request.getParameter("inputEndereco");
        String telefone = request.getParameter("inputTelefone");
        String email = request.getParameter("loginEmail");
        String senha = request.getParameter("loginSenha");
        String cidade = request.getParameter("inputCidades");
        
        
        
        Usuario user = new Usuario ();
		user.setNome(nome);
        user.setCNPJ(cnpj);
        user.setEndereco(endereco);
        user.setTelefone(telefone);
        user.setEmail(email);
        user.setSenha(senha);
        user.setCidade(cidade);
        
        System.out.println(nome);
        
    }
 
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processarRequisicao(request, response);
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processarRequisicao(request, response);
    }
}