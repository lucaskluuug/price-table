package persister;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import exceptions.exceptionCodeNotFound;
import model.priceTable;

/**
 * Classe que implementa os métodos de save e recover 
 *
 * @author Lucas
 * @version 30/11/2022
 */
public class serializerPersister implements persister{

	/**
	 * Método que salva a tabela de preços em um arquivo de objetos
	 *
	 * @param pTable Tabela de preços onde foram salvas as informações dos produtos
	 **/
	@Override
	public void savePriceTable(priceTable pTable) {
		try {
			FileOutputStream fs = new FileOutputStream("price-table-file");
			ObjectOutputStream write = new ObjectOutputStream(fs);
			write.writeObject(pTable); //erro aqui
			write.flush();
			write.close();
			
		} catch(IOException e) {
			System.out.println("IO Error! "+e);
		}
	}

	/**
	 * Método que recupera a tabela de preços já salva em um arquivo de objetos
	 *
	 * @return tempPriceTable Retorna a rabela de preços recuperada do arquivo
	 **/
	@Override
	public priceTable recoverPriceTable() {
		priceTable tempPriceTable = new priceTable(100);
		try {
			FileInputStream fs = new FileInputStream("price-table-file");
			ObjectInputStream reader = new ObjectInputStream(fs);
			tempPriceTable = (priceTable) reader.readObject();
			reader.close();
			
		} catch(IOException e) {
			System.out.println("IO Error!");
		} catch(ClassNotFoundException e) {
			System.out.println("Class Error!");
		}
		return tempPriceTable;
	}
}
