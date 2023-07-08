package exceptions;

/**
 * Classe que implementa uma exceção de tabela de código já existente na tabela de preços
 *
 * @author Lucas
 * @version 30/11/2022
 */

public class exceptionCodeAlreadyExists extends Exception{
	
	@Override
	public String getMessage() {
		return "Add failed because the code already exists on table!";
	}
}