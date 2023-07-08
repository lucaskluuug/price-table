package view;

import java.util.Scanner;

import exceptions.exceptionCodeAlreadyExists;
import exceptions.exceptionCodeNotFound;
import exceptions.exceptionFullTable;
import model.keyboard;
import model.mouse;
import model.notebook;
import model.priceTable;
import model.product;
import persister.persister;

/**
 * Classe que implementa a interface de usuário
 *
 * @author Lucas
 * @version 30/11/2022
 */
public class userInterface {

	private priceTable pTable;
	private Scanner read = new Scanner(System.in);
	private persister persist;
	
	public userInterface(persister persist) {
		this.persist = persist;
	}
	
	/**
	 * Método que mostra o menu principal do projeto
	 */
	public void showMainMenu() {
		
		int len, dpi, inches, code;
		boolean gamer = false, led = false;
		double price, valueA, valueB;
		String description, temp;
		product[] products;
		
		pTable = persist.recoverPriceTable();
		
		System.out.println("\n0. Exit\n"
				+ "1. Register product.\n"
				+ "2. Show products.\n"
				+ "3. Show product price.\n"
				+ "4. Show all products with price between two values.\n");
		
		int option = read.nextInt();
		read.nextLine();
		
		
		while(option!=0) {
			switch(option) {
			default: 
				System.out.println("Invalid option!\n");
				break;
			case 1:
				try {
					System.out.println("Code:\n");
					code = read.nextInt();
					System.out.println("Price:\n");
					price = read.nextDouble();
					read.nextLine();
					System.out.println("Desciption:\n");
					description = read.nextLine();
					
					System.out.println("1. Keyboard.\n"
							+ "2. Mouse\n"
							+ "3. Notebook\n");
					option = read.nextInt();
					
					switch(option) {
					default: 
						System.out.println("Invalid option!\n");
						break;
					case 1:
						read.nextLine();
						System.out.println("Is a gamer keyboard? S/N");
						temp = read.nextLine();
						if(temp.equalsIgnoreCase("s")) {
							gamer = true;
						}
						System.out.println("Does the keyboard has leds? S/N");
						temp = read.nextLine();
						if(temp.equalsIgnoreCase("s")) {
							led = true;
						}
						pTable.insertProdut(new keyboard(code, price, description, gamer, led));				
						break;
					case 2:
						System.out.println("Mouse dpi:\n");
						dpi = read.nextInt();
						pTable.insertProdut(new mouse(code, price, description, dpi));
						break;
					case 3:
						System.out.println("Screen size:\n");
						inches = read.nextInt();
						pTable.insertProdut(new notebook(code, price, description, inches));
						break;
					}
				}
				catch(exceptionCodeAlreadyExists e) {
					System.out.println(e.getMessage());
				}
				catch(exceptionFullTable e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				products = pTable.getProducts();
				len = pTable.getLen();
				if(len<1) {
					System.out.println("There is no product yet!\n");
				} else {
					System.out.println("Products:\n\n");
					for(int i=0; i<len; i++) {
						System.out.println("Code: "+products[i].getcode()+"\n"
										+ "Final price: "+products[i].finalPrice()+"\n"
										+ "Description: "+products[i].getdescription()+"\n\n");
					}
				}
				break;
			case 3:
				try {
					System.out.println("Indicate product code:\n");
					code = read.nextInt();
					System.out.println("Product price - "+pTable.getProductPrice(code)+"\n");
				}
				catch(exceptionCodeNotFound e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("Indicate value A:\n");
				valueA = read.nextDouble();
				System.out.println("Indicate value B:\n");
				valueB = read.nextDouble();
				
				products = pTable.getProducts();
				len = pTable.getLen();
				if(len<1) {
					System.out.println("There is no product.\n");
				} else {
					for(int i=0; i<len; i++) {
						if(products[i].finalPrice()>=valueA && products[i].finalPrice()<=valueB) {
							System.out.println("Code: "+products[i].getcode()+"\n"
									+ "Final price: "+products[i].finalPrice()+"\n"
									+ "Description: "+products[i].getdescription()+"\n\n");
						}		
					}
				}
				break;
			}
			
			System.out.println("\n0. Exit.\n"
					+ "1. Register product.\n"
					+ "2. Show products.\n"
					+ "3. Show product price.\n"
					+ "4. Show all products with price between two values.\n");
			
			option = read.nextInt();
			read.nextLine();		
		}
		persist.savePriceTable(pTable);
	}
}