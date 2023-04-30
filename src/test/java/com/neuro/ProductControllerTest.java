package com.neuro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.neuro.constants.ApplicationConstants;
import com.neuro.request.dto.RequestDTO;
import com.neuro.response.dto.ProductDTO;

public class ProductControllerTest extends NeuroApplicationTests {

	private String serviceEndPoint = ApplicationConstants.SERVICE_ENDPOINT_API_PRODUCT;

	@Override
	@BeforeAll
	public void setUp() {
		super.setUp();
	}

	@Test
	public void createProduct() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setName("Test");
		productDTO.setDescription("Test Desc");
		productDTO.setProductType("Mobile");
		productDTO.setId(1L);
		String inputJson = super.mapToJson(productDTO);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(serviceEndPoint)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Product is created successfully");
	}

	@Test
	public void updateProduct() throws Exception {
		String uri = serviceEndPoint + "/2";
		RequestDTO requestDTO = new RequestDTO();
		requestDTO.setName("Test");
		requestDTO.setProductType("Mobile");
		requestDTO.setDescription("Test Desc");
		requestDTO.setId(2L);
		String inputJson = super.mapToJson(requestDTO);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Product is updated successsfully");
	}

	@Test
	public void deleteProduct() throws Exception {
		String uri = serviceEndPoint + "/2";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Product is deleted successsfully");
	}

	@Test
	public void getProductsList() throws Exception {
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(serviceEndPoint).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		ProductDTO[] productlist = super.mapFromJson(content, ProductDTO[].class);
		assertTrue(productlist.length > 0);
	}
}
