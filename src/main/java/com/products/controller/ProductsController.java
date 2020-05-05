package com.products.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.products.DTO.ResponseDTO;
import com.products.model.Products;
import com.products.service.ProductService;

@RestController
@CrossOrigin
public class ProductsController {

	@Autowired
	ProductService productService;
	private Logger logger = LoggerFactory.getLogger(ProductsController.class);

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<ResponseDTO> addProduct(@RequestBody Products products) {
		logger.debug("ProductController in side addProduct method Request is:" + products);
		ResponseDTO response = new ResponseDTO();
		try {
			boolean result = productService.saveProduct(products);
			if (result) {
				response.setMsg("Product inserted successfully..!");
				response.setStatus("success");

			} else {
				response.setMsg("Product not insert");
				response.setStatus("Fail");

			}
			}catch (Exception e) {
				// TODO: handle exception
				response.setMsg("Something went wrong");
				response.setStatus("Exception");
				return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
			}
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
		}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public Products updateProduct(@RequestBody Products products) {
		Products result = productService.updateProduct(products);
		return result;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@Procedure("application/json")
	public String deleteProduct( Integer prodId) {
		logger.debug("I am inside DeleteEmployee Method");
		String status;
		try {
			productService.deleteProduct(prodId);
			status = "Product deleted successfully!...:" + prodId;
		} catch (Exception e) {
			status = e.getMessage();
		}
		logger.debug("I am exit DeleteEmployee Method");
		return status;
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Products> getAllProducts() {
		List<Products> products = productService.getAllProducts();
		return products;
	}
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Optional<Products> getProduct(@RequestParam int id) {
		return productService.getProduct(id);
	}
}