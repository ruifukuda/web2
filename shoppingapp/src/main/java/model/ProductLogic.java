package model;

import java.util.List;

public class ProductLogic {
	public void execute(Product product, List<Product> productList) {
		productList.add(0, product);
	}

}
