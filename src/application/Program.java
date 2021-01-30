package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> listaProdutos = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int numberProducts = sc.nextInt();
		
		for (int i = 1; i <= numberProducts; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Commom, used, imported (c/u/i)? ");
			char typeProduct = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			switch (typeProduct) {
				
				case 'i':
					System.out.print("Customs fee: ");
					double customsFee = sc.nextDouble();
					listaProdutos.add(new ImportedProduct(name, price, customsFee));
					break;
				case 'u':
					System.out.print("Manufacture date (DD/MM/YYYY): ");
					Date manufactureDate = sdf.parse(sc.next());
					listaProdutos.add(new UsedProduct(name, price, manufactureDate));
					break;
				default:
					listaProdutos.add(new Product(name, price));
					break;
			}
						
		}
		System.out.println("");
		System.out.println("PRICE TAGS: ");
		
		for (Product product : listaProdutos) {
			System.out.println(product.priceTag());	
		}
		
		sc.close();


	}

}
