package exceptions;

/**
 * Classe que implementa uma exceção de código não encontrado na tabela de preços
 *
 * @author Lucas
 * @version 30/11/2022
 */

public class exceptionCodeNotFound extends Exception{
	@Override
	public String getMessage() {
		return "Code was not found on price table!";
	}
}