package br.caelum.cadastro.modelo;

<<<<<<< HEAD
import java.io.Serializable;

public class Aluno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
=======
public class Aluno {

	//Comentario teste commit
	
>>>>>>> bf08452c5312b2f17b416e5f2659b96583d88ef8
	private String nome;
	private String site;
	private String endereco;
	private String telefone;
	private String foto;
	private double nota;
	private Long id;
	
	@Override
	public String toString() {
		return id +" "+nome;		
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
