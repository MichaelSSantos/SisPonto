package service;

public enum OpcaoMenu {

	SAIR{
		@Override
		public SisPontoService getService() {
			return new EncerrarService();
		}
	},
	CONSULTARDADOS {
		@Override
		public SisPontoService getService() {
			return new ConsultaPessoaService();
		}
	},
	CADASTRARALUNO {
		@Override
		public SisPontoService getService() {
			return new CadastroAlunoService();
		}
	},
	CADASTRARPROFESSOR {
		@Override
		public SisPontoService getService() {
			return new CadastroProfessorService();
		}
	},
	CADASTRARADMINISTRATIVO {
		@Override
		public SisPontoService getService() {
			return new CadastroAdministrativoService();
		}
	};

	public abstract SisPontoService getService();

}
