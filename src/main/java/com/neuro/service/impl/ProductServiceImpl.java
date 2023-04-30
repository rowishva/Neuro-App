package com.neuro.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.neuro.constants.ApplicationConstants;
import com.neuro.entity.Product;
import com.neuro.exception.ResourceNotFoundException;
import com.neuro.repository.ProductRepository;
import com.neuro.request.dto.RequestDTO;
import com.neuro.response.BaseResponse;
import com.neuro.response.dto.ProductDTO;
import com.neuro.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public BaseResponse<ProductDTO> createProduct(RequestDTO requestDTO) {
		log.info("Calling ProductServiceImpl.createProduct()");
		Product product = modelMapper.map(requestDTO, Product.class);
		product = productRepository.save(product);
		ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
		BaseResponse<ProductDTO> response = BaseResponse.<ProductDTO>builder().status(HttpStatus.OK.value())
				.message(ApplicationConstants.SUCCESS).content(productDTO).build();
		return response;
	}

	@Override
	public BaseResponse<ProductDTO> updateProduct(RequestDTO requestDTO) {

		log.info("Calling ProductServiceImpl.updateProduct()");
		Optional<Product> product = productRepository.findById(requestDTO.getId());
		if (product.isEmpty()) {
			throw new ResourceNotFoundException(ApplicationConstants.ERROR_MSG_PRODUCT_NOT_FOUND + requestDTO.getId());
		}
		Product update = product.get();
		modelMapper.map(requestDTO, update);
		update = productRepository.save(update);
		ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
		BaseResponse<ProductDTO> response = BaseResponse.<ProductDTO>builder().status(HttpStatus.OK.value())
				.message(ApplicationConstants.SUCCESS).content(productDTO).build();
		return response;
	}

	@Override
	public BaseResponse<ProductDTO> deleteProduct(Long id) {
		log.info("Calling ProductServiceImpl.deleteProduct()");
		Optional<Product> product = productRepository.findById(id);
		if (product.isEmpty()) {
			throw new ResourceNotFoundException(ApplicationConstants.ERROR_MSG_PRODUCT_NOT_FOUND + id);
		}
		Product deleteProduct = product.get();
		deleteProduct.setDeleted(true);
		productRepository.save(deleteProduct);
		BaseResponse<ProductDTO> response = BaseResponse.<ProductDTO>builder().status(HttpStatus.NO_CONTENT.value())
				.message(ApplicationConstants.SUCCESS).build();
		return response;
	}

	@Override
	public BaseResponse<ProductDTO> getAllProduct() {
		log.info("Calling ProductServiceImpl.getAllProduct()");
		List<Product> productList = productRepository.findAll();
		List<ProductDTO> productListDTO = new ArrayList<ProductDTO>();
		if (productList != null && productList.size() > 0) {
			productListDTO.addAll(productList.stream().map(product -> modelMapper.map(product, ProductDTO.class))
					.collect(Collectors.toList()));
		}
		BaseResponse<ProductDTO> response = BaseResponse.<ProductDTO>builder().status(HttpStatus.OK.value())
				.message(ApplicationConstants.SUCCESS).contentList(productListDTO).build();
		return response;
	}

}
