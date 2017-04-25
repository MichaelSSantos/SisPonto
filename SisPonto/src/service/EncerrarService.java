package service;

public class EncerrarService implements SisPontoService {

	@Override
	public void execute() {
		System.out.println("Sistema encerrado com sucesso.");
		System.exit(0);
	}

}
