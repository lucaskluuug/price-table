package model;

/**
 * Classe que implementa um mouse, extensão de um produto.
 *
 * @author Lucas
 * @version 30/11/2022
 */

public class mouse extends product{
	
	protected int dpi; //quantidade de dpi do mouse
	
	/**
	 * Construtor que inicializa um Produto do tipo Mouse com um código, preço, descrição e dpi
	 *
	 * @param Code Código do produto
	 * @param Price Preço do produto
	 * @param Description Descrição do produto
	 * @param DPI Quantidade de dpis do mouse
	 */
	public mouse(int code, double price, String description, int dpi) {
		super(code, price, description);
		this.dpi = dpi;
	}

	/**
	 * Método que retorna o preço final do mouse com base na quantidade de dpis 
	 */
	@Override
	public double finalPrice() {
		if(dpi<=400) {
			return this.price *1.3;
		} else if(dpi>400 & dpi<=2000) {
			return this.price *1.4;
		} else if(dpi>2000 & dpi<=4000)	{
			return this.price *1.5;
		} else {
			return this.price *1.7;
		}
	}

}
