package com.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Contato.
 */
public class Contato {
	
	/** The id. */
	String id;
	
	/** The nome. */
	String nome;
	
	/** The email. */
	String email;
	
	/** The telefone. */
	String telefone;
	
	
	/**
	 * Instantiates a new contato.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @param email the email
	 * @param telefone the telefone
	 */
	public Contato(String id, String nome, String email, String telefone) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the telefone.
	 *
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Sets the telefone.
	 *
	 * @param telefone the new telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	/**
	 * Instantiates a new contato.
	 */
	public Contato() {
		super();
	}
	
	

}


