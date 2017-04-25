package main;

import java.util.Scanner;

import service.OpcaoMenu;
import service.SisPontoService;

public class SisPonto {

	public static void main(String[] args) {

		System.out.println("--SISPONTO--");

		Scanner in = new Scanner(System.in);
		String opcaoMenu;

		do {
			System.out.println("\n--MENU--");
			System.out.println("[1] Consultar dados de uma pessoa");
			System.out.println("[2] Cadastrar novo aluno");
			System.out.println("[3] Cadastrar novo professor");
			System.out.println("[4] Cadastrar novo administrativo");
			System.out.println("[0] Sair");

			System.out.print("Opção: ");
			opcaoMenu = in.nextLine();

			try {
				OpcaoMenu opcaoSelecionada = OpcaoMenu.values()[Integer.valueOf(opcaoMenu)];
				SisPontoService service = opcaoSelecionada.getService();
				service.execute();

			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
				System.out.println("\nOpção inválida.");
			}

		} while (!"0".equals(opcaoMenu));

		in.close();

	}

}
