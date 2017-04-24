package main;

import java.util.Scanner;

import exceptions.SalarioInvalidoException;

public class Teste {

	public static void main(String[] args) {
		
		System.out.println("Salário informado: " + inserirSalario());
		
	}
	
	public static Double inserirSalario(){
		Double salario = null;
		try {
			System.out.print("-Informe o salário: ");
			Scanner in = new Scanner(System.in);
			salario = Double.valueOf(in.nextLine());

			if(salario <= 0.0){
				throw new SalarioInvalidoException("O salário não pode ser um valor negativo.");
			}
		} catch (NumberFormatException e) {
			System.out.println("O salário deve ser um valor numérico.");
			inserirSalario();
			
		} catch (SalarioInvalidoException e){
			System.out.println(e.getMessage());
			inserirSalario();
		}
		return salario;
	};

}
