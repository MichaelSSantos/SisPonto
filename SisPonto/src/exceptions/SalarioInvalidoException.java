package exceptions;

public class SalarioInvalidoException extends Exception {

	private static final long serialVersionUID = 6122516569671794695L;
	
	private String mensagem;
	
	public SalarioInvalidoException() {

	}
	
	public SalarioInvalidoException(String mensagem) {
		super(mensagem);
		this.mensagem = mensagem;
	}



	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	

}
