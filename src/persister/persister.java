package persister;

import model.priceTable;

/**
 * Interface que implementa o mecanismo de salvamento e recuperação de informações da tabela de preços
 *
 * @author Lucas
 * @version 30/11/2022
 */
public interface persister {
	public void savePriceTable(priceTable pTable);
	public priceTable recoverPriceTable();
}
