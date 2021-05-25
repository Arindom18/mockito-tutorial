package com.bhavya.junit.business;

import java.util.List;

import com.bhavya.junit.business.exception.DifferentCurrenciesException;
import com.bhavya.junit.model.Amount;
import com.bhavya.junit.model.Product;

public interface ClientBO {

	Amount getClientProductsSum(List<Product> products)
			throws DifferentCurrenciesException;

}