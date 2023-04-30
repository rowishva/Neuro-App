package com.neuro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuro.aspect.Audited;
import com.neuro.constants.ApplicationConstants;
import com.neuro.request.dto.RequestDTO;
import com.neuro.response.BaseResponse;
import com.neuro.response.dto.ProductDTO;
import com.neuro.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(ApplicationConstants.SERVICE_ENDPOINT_API_PRODUCT)
public class ProductController {

	@Autowired
	private ProductService productService;

	@Audited
	@PostMapping
	public BaseResponse<ProductDTO> createProduct(@RequestBody RequestDTO requestDTO) {
		log.info("Calling ProductController.createProduct()");
		return productService.createProduct(requestDTO);
	}

	@Audited
	@PutMapping
	public BaseResponse<ProductDTO> updateProduct(@RequestBody RequestDTO requestDTO) {
		log.info("Calling ProductController.updateProduct()");
		return productService.updateProduct(requestDTO);
	}

	@Audited
	@DeleteMapping(value = ApplicationConstants.SERVICE_ENDPOINT_ID)
	public BaseResponse<ProductDTO> deleteProduct(@PathVariable("id") Long id) {
		log.info("Calling ProductController.deleteProduct ()");
		return productService.deleteProduct(id);
	}

	@Audited
	@GetMapping
	public BaseResponse<ProductDTO> getAllProduct() {
		log.info("Calling ProductController.getAllProduct()");
		return productService.getAllProduct();
	}

}
