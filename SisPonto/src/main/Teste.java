package main;

import java.util.Scanner;

import exceptions.SalarioInvalidoException;

public class Teste {

	public static void main(String[] args) {
		
		System.out.println("Sal�rio informado: " + inserirSalario());
		
	}
	
	public static Double inserirSalario(){
		Double salario = null;
		try {
			System.out.print("-Informe o sal�rio: ");
			Scanner in = new Scanner(System.in);
			salario = Double.valueOf(in.nextLine());

			if(salario <= 0.0){
				throw new SalarioInvalidoException("O sal�rio n�o pode ser um valor negativo.");
			}
		} catch (NumberFormatException e) {
			System.out.println("O sal�rio deve ser um valor num�rico.");
			inserirSalario();
			
		} catch (SalarioInvalidoException e){
			System.out.println(e.getMessage());
			inserirSalario();
		}
		return salario;
	};

}
