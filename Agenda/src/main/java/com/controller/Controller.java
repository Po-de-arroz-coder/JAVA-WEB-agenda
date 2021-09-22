package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.model.Contato;
import com.model.DAO;


// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = {"/Controller","/main","/insert","/select","/update","/delete","/report"})
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The contato. */
	Contato contato = new Contato();
	
	/** The dao. */
	DAO dao = new DAO();
	
    /**
     * Instantiates a new controller.
     */
    public Controller() {
        super();
        
    }

	
	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if(action.equals("/main")) {
			Listar(request, response);
		}else if(action.equals("/insert")) {
			adicionarContato(request,response);
		}else if(action.equals("/select")) {
			listarContato(request,response);
		}
		else if(action.equals("/update")) {
			atualizarContato(request,response);
		}
		else if(action.equals("/delete")) {
			deletarContato(request,response);
		}
		else if(action.equals("/report")) {
			gerarRelatorio(request,response);
		}
		else {
			response.sendRedirect("main");
		}
	}

	/**
	 * Listar.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void Listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Contato> lista = dao.lerContatos();
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request,response);;
		
	}
	
	

	/**
	 * Adicionar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void adicionarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contato.setNome(request.getParameter("Nome"));
		contato.setTelefone(request.getParameter("Telefone"));
		contato.setEmail(request.getParameter("Email"));

		dao.inserirContato(contato);
		response.sendRedirect("main");
	}
	
	
	/**
	 * Listar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void listarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		contato.setId(id);
		dao.selecionarContato(contato);
		 request.setAttribute("id",contato.getId());
		 request.setAttribute("nome",contato.getNome());
		 request.setAttribute("email",contato.getEmail());
		 request.setAttribute("telefone",contato.getTelefone());
		 RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		 rd.forward(request,response);
	}
	
	
	/**
	 * Atualizar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void atualizarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("Id");
		contato.setId(id);
		contato.setNome(request.getParameter("Nome"));
		contato.setTelefone(request.getParameter("Telefone"));
		contato.setEmail(request.getParameter("Email"));
		
		dao.atualizarContatos(contato);
		response.sendRedirect("main");
	
	}
	
	/**
	 * Deletar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void deletarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		contato.setId(id);
		dao.removerContato(contato);
	}
	
	
	/**
	 * Gerar relatorio.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Document documento = new Document();
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition","inline; filename="+"contatos.pdf");
			PdfWriter.getInstance(documento,response.getOutputStream());
			documento.open();
			documento.add(new Paragraph("Lista de contatos: "));
			documento.add(new Paragraph(" "));
			
			PdfPTable tabela = new PdfPTable(3);
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Telefone"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Email"));
			
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			ArrayList<Contato> lista = dao.lerContatos();
			for(int i=0; i<lista.size(); i++) {
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(lista.get(i).getTelefone());
				tabela.addCell(lista.get(i).getEmail());
			}
			documento.add(tabela);
			documento.close();	
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}
	
}



