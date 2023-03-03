package programa;

import java.util.Scanner;

import entidade.CalcTriangulo;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		CalcTriangulo x; 
		
		x = new CalcTriangulo(); 
	
		System.out.println("digite as medidas do triângulo x?");
		x.a = sc.nextDouble();
		x.b = sc.nextDouble();
		x.c = sc.nextDouble();
		
		double AreaX = x.area();
		
		System.out.printf("Área do triangulo x: %.4f%n", AreaX);
		 
		sc.close();

	}

}
