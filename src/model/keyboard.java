package model;

/**
 * Classe que implementa um teclado, extensão de um produto.
 *
 * @author Lucas
 * @version 30/11/2022
 */

public class keyboard extends product{
	
	protected boolean gamer; //modelo do teclado é gamer?
	protected boolean led; //teclado possui led? 
	
	/**
	 * Construtor que inicializa um Produto do tipo Keyboard com um código, preço, descrição e se ele é gamer e se tem led
	 *
	 * @param Code Código do produto
	 * @param Price Preço do produto
	 * @param Description Descrição do produto
	 * @param Gamer Atribuito boleano que indica se o modelo do teclado é gamer ou não
	 * @param led Atribuito boleano que indica se o modelo do teclado tem led ou não
	 */
	public keyboard(int code, double price, String description, boolean gamer, boolean led) {
		super(code, price, description);
		this.gamer = gamer;
		this.led = led;
	}
	
	/**
	 * Método que retorna o preço final do teclado com base nas possíveis combinações boleanas dos atributos 'gamer' e 'led'
	 */
	@Override
	public double finalPrice() {
		if(led & !gamer) {
			return this.price * 1.2;
		} else if(!led & gamer) {
			return this.price * 1.3;
		} else if(led & gamer) {
			return this.price * 1.5;
		} else {
			return this.price * 1.1;
		}
	}
}