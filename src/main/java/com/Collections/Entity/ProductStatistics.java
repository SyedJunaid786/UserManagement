package com.Collections.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductStatistics 
{
	private Long totalNoOfProducts;
	private Long totalDistnctNoOfProducts;
	
	private Double maxPriceOfProduct;
	private Double avgPriceOfProduct;
	private Double sumOfPriceOfProduct;
}
