package view;

import persister.serializerPersister;

/**
 * Classe que implementa uma a main do projeto, responsável por inicializar o mesmo
 *
 * @author Lucas
 * @version 30/11/2022
 */
public class main {

	public static void main(String[] args) {
		new userInterface(new serializerPersister()).showMainMenu();;

	}
}