package com.neuro.response.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = { "id", "name", "productType", "description" })
public class ProductDTO {

	private Long id;
	private String name;
	private String productType;
	private String description;
}
