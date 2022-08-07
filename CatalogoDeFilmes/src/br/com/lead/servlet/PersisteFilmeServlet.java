package br.com.lead.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.com.lead.modelo.Autor;
import br.com.lead.modelo.Filme;
import br.com.lead.util.JPAUtil;

@SuppressWarnings("serial")
@WebServlet("/persistir-filme")
public class PersisteFilmeServlet extends HttpServlet {
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String genero = req.getParameter("genero");
		Integer ano = Integer.valueOf(req.getParameter("ano"));
		
		String nomeAutor = req.getParameter("nomeAutor");
		LocalDate dataNascmentoAutor = LocalDate.parse(req.getParameter("dataNascimentoAutor"));
		
		Autor autor = new Autor();
		autor.setNome(nomeAutor);
		autor.setDataNascimento(dataNascmentoAutor);
		
		Filme filme = new Filme(nome, genero, ano);
		filme.setAutor(autor);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(autor);
		em.persist(filme);
		
		em.getTransaction().commit();
		
		em.close();
	}

}
