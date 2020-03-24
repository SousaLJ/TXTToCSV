/**
 * 
 */
package CSVModel;

import java.io.Serializable;

/**
 * @author Leandro Jesus Sousa
 *
 */
public class Deploy implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4340968387366053575L;
	
	private String versao;
	private String data;
	private String tipo;
	private String modulo;
	private String descricao;
	
	
	public Deploy(String data, String tipo, String modulo, String descricao) {
		super();
		this.data = data;
		this.tipo = tipo;
		this.modulo = modulo;
		this.descricao = descricao;
	}
	
	
	public Deploy() {
		
	}


	//Getters and Setters
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
