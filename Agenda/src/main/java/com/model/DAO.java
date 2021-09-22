package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/** The Constant DRIVER. */
	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	/** The Constant URL. */
	private final static String URL = "jdbc:mysql://localhost:3306/agenda";
	
	/** The Constant USER. */
	private final static String USER = "root";
	
	/** The Constant PASS. */
	private final static String PASS = "";
	
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public static Connection getConnection(){
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("ERRO na Conexão: "+ e);
		}
	}
	
	/**
	 * Close connection.
	 *
	 * @param con the connection
	 */
	public static void closeConnection(Connection con) {
		
		try {
			if(con != null) {
			con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Inserir contato.
	 *
	 * @param ct the contato
	 */
	public void inserirContato(Contato ct) {
		Connection con = getConnection();
		PreparedStatement stnt = null;
		
		try {
			stnt = con.prepareStatement("INSERT INTO contatos (nome, email, telefone) VALUES(?,?,?)");
			stnt.setString(1, ct.getNome());
			stnt.setString(2, ct.getEmail());
			stnt.setString(3, ct.getTelefone());
			
			stnt.executeUpdate();
			System.out.println("Salvo com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro na execução: "+e+"\n");
			e.printStackTrace();
		}finally{
			closeConnection(con);
		}
	}
		
		
		/**
		 * Ler contatos.
		 *
		 * @return the array list
		 */
		public ArrayList<Contato> lerContatos(){
			Connection con = getConnection();
			PreparedStatement pst = null;
			ResultSet rs = null;
			
			ArrayList<Contato> lista = new ArrayList<>();
			
			try {
				pst = con.prepareStatement("SELECT * FROM contatos order by id");
				rs = pst.executeQuery();
				while(rs.next()) {
					String id = rs.getString(1);
					String nome = rs.getString(2);
					String email = rs.getString(3);
					String telefone = rs.getString(4);
					lista.add(new Contato(id,nome,email,telefone));
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				closeConnection(con);
			}
			return lista;
		}
		
		/**
		 * Selecionar contato.
		 *
		 * @param contato the contato
		 */
		public void selecionarContato(Contato contato) {
			Connection con = getConnection();
			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
				pst = con.prepareStatement("SELECT * FROM contatos WHERE id = ?");
				pst.setString(1, contato.getId());
				rs = pst.executeQuery();
				while(rs.next()) {
					
					contato.setId(rs.getString(1));
					contato.setNome(rs.getString(2));
					contato.setEmail(rs.getString(3));
					contato.setTelefone(rs.getString(4));
					
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally{
				closeConnection(con);
			}
		}
		
		/**
		 * Atualizar contatos.
		 *
		 * @param ct the contato
		 */
		public void atualizarContatos(Contato ct) {
			Connection con = getConnection();
			PreparedStatement stnt = null;
			
			try {
				stnt = con.prepareStatement("UPDATE contatos SET nome = ?, email = ?, telefone = ? WHERE id = ?");
				stnt.setString(1, ct.getNome());
				stnt.setString(2, ct.getEmail());
				stnt.setString(3, ct.getTelefone());
				stnt.setString(4, ct.getId());
				
				stnt.executeUpdate();
				System.out.println("Atualizado com sucesso!");
			} catch (SQLException e) {
				System.out.println("Erro na execução: "+e+"\n");
				e.printStackTrace();
			}finally{
				closeConnection(con);
			}
		}
		
		/**
		 * Remover contato.
		 *
		 * @param ct the contato
		 */
		public void removerContato(Contato ct) {
			Connection con = getConnection();
			PreparedStatement stnt = null;
			
			try {
				stnt = con.prepareStatement("DELETE FROM contatos WHERE id = ?");
				stnt.setString(1, ct.getId());
				stnt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Erro na execução: "+e+"\n");
				e.printStackTrace();
			}finally{
				closeConnection(con);
			}
		}
			
	}

	
	

