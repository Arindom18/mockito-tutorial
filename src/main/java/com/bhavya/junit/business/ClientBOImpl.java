package com.bhavya.junit.business;

import java.math.BigDecimal;
import java.util.List;

import com.bhavya.junit.business.exception.DifferentCurrenciesException;
import com.bhavya.junit.model.Amount;
import com.bhavya.junit.model.AmountImpl;
import com.bhavya.junit.model.Currency;
import com.bhavya.junit.model.Product;

public class ClientBOImpl implements ClientBO {

	public Amount getClientProductsSum(List<Product> products)
			throws DifferentCurrenciesException {

		if (products.size() == 0)
			return new AmountImpl(BigDecimal.ZERO, Currency.EURO);

		if (!isCurrencySameForAllProducts(products)) {
			throw new DifferentCurrenciesException();
		}

		BigDecimal productSum = calculateProductSum(products);

		Currency firstProductCurrency = products.get(0).getAmount()
				.getCurrency();

		return new AmountImpl(productSum, firstProductCurrency);
	}

	private BigDecimal calculateProductSum(List<Product> products) {
		BigDecimal sum = BigDecimal.ZERO;
		// Calculate Sum of Products
		for (Product product : products) {
			sum = sum.add(product.getAmount().getValue());
		}
		return sum;
	}

	private boolean isCurrencySameForAllProducts(List<Product> products)
			throws DifferentCurrenciesException {

		Currency firstProductCurrency = products.get(0).getAmount()
				.getCurrency();

		for (Product product : products) {
			boolean currencySameAsFirstProduct = product.getAmount()
					.getCurrency().equals(firstProductCurrency);
			if (!currencySameAsFirstProduct) {
				return false;
			}
		}

		return true;
	}
}