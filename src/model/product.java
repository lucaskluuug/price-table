package model;

import java.io.Serializable;

/**
 * Classe que implementa um produto.
 *
 * @author Lucas
 * @version 30/11/2022
 */

public abstract class product implements Serializable{
	protected int code; //código do produto
	protected double price; // preço do produto
	protected String description; //descrição do produto
	
	/**
	 * Construtor que inicializa uma Produto com um código, preço e descrição
	 *
	 * @param Code Código do produto
	 * @param Price Preço do produto
	 * @param Description Descrição do produto
	 */
	public product(int code, double price, String description) {
		super();
		this.code = code;
		this.price = price;
		this.description = description;
	}
	
	public abstract double finalPrice();
	
	public int getcode() {
		return code;
	}
	public void setcode(int code) {
		this.code = code;
	}
	public double getprice() {
		return price;
	}
	public void setprice(double price) {
		this.price = price;
	}
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
}
