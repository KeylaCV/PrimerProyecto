package Keyla;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class AppGestion {

	public static void main(String[] args) {
			
		ArrayList<Facturas> lista= new ArrayList<Facturas>();
		Scanner ent= new Scanner(System.in);
		Facturas fact=null;
		DateTimeFormatter df= DateTimeFormatter.ofPattern("dd-M-yyy");
		
		for(int i=0; i<5; i++) {
			try {
				fact=new Facturas();
				System.out.println("Introduce el númmero de la factura");
				fact.setCodfactura(Integer.parseInt(ent.nextLine()));
				System.out.println("Nombre del cliente");
				fact.setNombrecli(ent.nextLine());
				System.out.println("Importe de la factura");
				fact.setImporte(Float.parseFloat(ent.nextLine().replace(',', '.')));
				System.out.println("Introduce la fecha de la factura en formato dd-mm-aaaa");
				fact.setFechafactura(LocalDate.parse(ent.nextLine(), df));
				
			}catch(NumberFormatException ex) {
				System.out.println("Valor no númerico");
				i--;
			}catch(DateTimeParseException ex) {
				System.out.println("Fecha incorrecta");
				i--;
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				i--;
			}
		}

	}
}
