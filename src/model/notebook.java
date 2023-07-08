package model;

/**
 * Classe que implementa um notebook, extensão de um produto.
 *
 * @author Lucas
 * @version 30/11/2022
 */

public class notebook extends product{
	
	protected int inches; //tamanho da tela (polegadas)
	
	/**
	 * Construtor que inicializa um Produto do tipo Notebook com um código, preço, descrição e tamanho da tela
	 *
	 * @param Code Código do produto
	 * @param Price Preço do produto
	 * @param Description Descrição do produto
	 * @param Inches Tamanho da tela do notebook, em polegadas
	 */
	public notebook(int code, double price, String description, int inches) {
		super(code, price, description);
		this.inches = inches;
	}

	
	/**
	 * Método que retorna o preço final do notebook com base no tamanho da tela 
	 */
	@Override
	public double finalPrice() {
		if(inches<11) {
			return this.price *1.3;
		} else if(inches>=11 & inches<=14) {
			return this.price *1.4;
		} else {
			return this.price *1.5;
		}
	}

}
