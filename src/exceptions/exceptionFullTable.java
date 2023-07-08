package exceptions;

/**
 * Classe que implementa uma exceção de tabela de preços cheia
 *
 * @author Lucas
 * @version 30/11/2022
 */

public class exceptionFullTable extends Exception{
	
	@Override
	public String getMessage() {
		return "Add failed because the table is full!";
	}
}
