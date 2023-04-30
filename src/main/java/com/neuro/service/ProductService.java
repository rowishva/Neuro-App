package com.neuro.service;

import org.springframework.stereotype.Service;

import com.neuro.aspect.Audited;
import com.neuro.request.dto.RequestDTO;
import com.neuro.response.BaseResponse;
import com.neuro.response.dto.ProductDTO;

@Service
public interface ProductService {

	@Audited
	public BaseResponse<ProductDTO> createProduct(RequestDTO requestDTO);

	@Audited
	public BaseResponse<ProductDTO> updateProduct(RequestDTO requestDTO);

	@Audited
	public BaseResponse<ProductDTO> deleteProduct(Long id);

	@Audited
	public BaseResponse<ProductDTO> getAllProduct();

}
