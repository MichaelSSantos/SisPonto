package main;

import java.util.Scanner;

import service.OpcaoMenuFactory;
import service.SisPontoService;

/**
 * SisPonto - Trabalho de conclus�o de m�dulo - Tecnologia Java - Infnet
 * https://github.com/MichaelSSantos/SisPonto
 * 
 * @author Michael Santos
 *
 */
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
			System.out.print("Op��o: ");
			opcaoMenu = in.nextLine();

			try {
				SisPontoService service = OpcaoMenuFactory.getInstance(opcaoMenu);
				service.execute();

			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
				System.out.println("\nOp��o inv�lida.");
			}

		} while (!"0".equals(opcaoMenu));

		in.close();

	}

}
