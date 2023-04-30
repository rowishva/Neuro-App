package com.neuro.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.neuro.entity.Product;
import com.neuro.response.dto.ProductDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		configProperty(modelMapper);
		return modelMapper;
	}

	public void configProperty(ModelMapper modelMapper) {
		productToProductDTO(modelMapper);
		productDTOToProduct(modelMapper);
	}

	public void productDTOToProduct(ModelMapper modelMapper) {
		TypeMap<ProductDTO, Product> propertyMapper = modelMapper.createTypeMap(ProductDTO.class, Product.class);
		propertyMapper.addMappings(mapper -> {
			mapper.map(source -> source.getId(), Product::setId);
			mapper.map(source -> source.getName(), Product::setName);
			mapper.map(source -> source.getProductType(), Product::setProductType);
			mapper.map(source -> source.getDescription(), Product::setDescription);
		});
		log.info("Convert -> ProductDTO To Product");
	}

	public void productToProductDTO(ModelMapper modelMapper) {
		TypeMap<Product, ProductDTO> propertyMapper = modelMapper.createTypeMap(Product.class, ProductDTO.class);
		propertyMapper.addMappings(mapper -> {
			mapper.map(source -> source.getId(), ProductDTO::setId);
			mapper.map(source -> source.getName(), ProductDTO::setName);
			mapper.map(source -> source.getProductType(), ProductDTO::setProductType);
			mapper.map(source -> source.getDescription(), ProductDTO::setDescription);
		});
		log.info("Convert -> Product To ProductDTO");
	}

}
