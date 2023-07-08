package model;

import exceptions.exceptionCodeAlreadyExists;
import exceptions.exceptionCodeNotFound;
import exceptions.exceptionFullTable;

import java.io.Serializable;

/**
 * Classe que implementa uma tabela de preços de produtos.
 *
 * @author Lucas
 * @version 30/11/2022
 */

public class priceTable implements Serializable{

	protected product[] products; //array de produtos
	protected int len = 0;     // quantidade de produtos na tabela
	protected int capacity;  // número máximo de produtos (capacidade do array)
	
	/**
	 * Construtor que inicializa uma TabelaDePrecos com uma capacidade específica 
	 *
	 * @param capacity A capacidade máxima da tabela
	 */
	public priceTable(int capacity)
	{
		this.capacity = capacity;
		products = new product[capacity];
	}

	/**
	 * Método que retorna o preço de um produto dado seu código. 
	 *
	 * @param code O código do produto do qual se quer o preço
	 * @return O preço do produto com o código informado
	 * @exception exceptionCodeNotFound Exceção para casos onde nenhum produto possui o código informado
	 */
	public double getProductPrice(int code) throws exceptionCodeNotFound
	{
		for(int i=0; i<len; i++) {
			if(products[i].getcode()==code) {
				return products[i].finalPrice();
			}
		}
		throw new exceptionCodeNotFound();
	}
	
	/**
	 * Método que insere um produto na tabela
	 *
	 * @param produto O objeto Produto que será incluído na tabela
	 * @exception exceptionFullTable Exceção que para casos onde a tabela de preços já está cheia
	 * @exception exceptionCodeAlreadyExists Exceção para casos onde o código já existe na tabela de preços
	 */
	public void insertProdut(product prod) 
			throws exceptionCodeAlreadyExists, exceptionFullTable
										
	{
		if(len == capacity) {
			throw new exceptionFullTable();
		}
		for(int i=0 ; i<len ; i++) {
			if(prod.getcode()==products[i].getcode()){
				throw new exceptionCodeAlreadyExists();
			}
		}
		products[len++] = prod;
	}

	public int getLen() {
		return len;
	}
	
	public product[] getProducts() {
		return products;
	}
}
