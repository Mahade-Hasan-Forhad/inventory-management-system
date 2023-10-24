package com.forhad.ims.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.forhad.ims.entities.Product;
import com.forhad.ims.entities.Sale;
import com.forhad.ims.service.ProductService;
import com.forhad.ims.service.SaleService;

@Controller
public class ProductController {

	// product service repo
	@Autowired
	ProductService service;

	// sale service repo

	@Autowired
	SaleService saleservice;

	// user repo
	/*
	 * @Autowired public UserRepository userRepository;
	 */

	@RequestMapping("/")
	public String loginregister() {
		return "login-register.html";
	}

	/*
	 * // reg-login
	 * 
	 * @RequestMapping(value = "/registerUser", method = RequestMethod.POST) public
	 * String register(@ModelAttribute("user") User user) {
	 * userRepository.save(user); return "login-register.html"; }
	 * 
	 * @RequestMapping(value = "/login", method = RequestMethod.POST) public String
	 * login(@RequestParam("email") String email, @RequestParam("password") String
	 * password, ModelMap modelMap) { User user = userRepository.findByEmail(email);
	 * 
	 * if (user.getPassword().equals(password)) { return "home.html"; } else {
	 * modelMap.addAttribute("msg",
	 * "Invalid user name or password.Please try again."); } return
	 * "login-register.html"; }
	 * 
	 * // logout
	 * 
	 * @RequestMapping("/login-register") public String logout() { return
	 * "login-register.html"; }
	 */

	// view all product
	@RequestMapping("/home")
	public String home(ModelMap modelMap) {
		if (UserController.isvalidate) {
			List<Product> products = service.getAllProducts();
			modelMap.addAttribute("products", products);
			return "home.html";
		} else {
			return "login-register.html";
		}
	}

	// save/add product
	@RequestMapping("/addproduct")
	public String addProduct(@ModelAttribute("product") Product product) {
		// service.saveProduct(product);
		if (UserController.isvalidate) {
			return "addproduct.html";
		} else {
			return "login-register.html";
		}
	}

	@RequestMapping("/saveproduct")
	public String saveProduct(@ModelAttribute("product") Product product) {
		if (UserController.isvalidate) {
			service.saveProduct(product);
			return "addproduct.html";
		} else {
			return "login-register.html";
		}
	}

	// add sales
	@RequestMapping("/addsales")
	public String addsales() {
		if (UserController.isvalidate) {
			return "addsales.html";
		} else {
			return "login-register.html";
		}
	}

	@RequestMapping("/deleteproduct")
	public String deleteProduct(@RequestParam("pId") long pId, ModelMap modelMap, @ModelAttribute("sale") Sale sale) {
		if (UserController.isvalidate) {
			Product product = new Product();
			product.setpId(pId);
			service.deleteProduct(product);

			// Save the remaining information in the sale table

			saleservice.saveSale(sale);

			modelMap.addAttribute("msg1", "Successfully added.");
			return "addsales.html";
		} else

		{
			return "login-register.html";
		}
	}

	// update/edit
	@RequestMapping("/editproduct")
	public String editProduct(@RequestParam("pId") long pId, ModelMap modelMap) {
		if (UserController.isvalidate) {
			Product product = service.getProductById(pId);
			modelMap.addAttribute("product", product);
			return "editproduct.html";
		} else

		{
			return "login-register.html";
		}
	}

	@RequestMapping("/updateProduct")
	public String updateProduct(@ModelAttribute("product") Product updatedProduct, ModelMap modelMap) {
		if (UserController.isvalidate) {
			Product existingProduct = service.getProductById(updatedProduct.getpId());

			// Update the fields that are allowed to be modified
			existingProduct.setpCategory(updatedProduct.getpCategory());
			existingProduct.setpColor(updatedProduct.getpColor());
			existingProduct.setpPrice(updatedProduct.getpPrice());
			existingProduct.setpQuantity(updatedProduct.getpQuantity());
			existingProduct.setpSize(updatedProduct.getpSize());

			service.updateProduct(existingProduct);
			modelMap.addAttribute("msg2", "Successfully Updated.");
			return "editproduct.html";
		} else

		{
			return "login-register.html";
		}
	}

	// search product

//	@RequestMapping("/searchproduct")
//	public String searchProduct(@RequestParam(value = "pId", required = false) Long productId, ModelMap modelMap) {
//		if (UserController.isvalidate) {
//			try {
//				
//				if (productId != null) {
//					Product product = service.getProductById(productId);
//					if (product != null) {
//						List<Product> products = new ArrayList<>();
//						products.add(product);
//						modelMap.addAttribute("products", products);
//						modelMap.addAttribute("product", products.get(0));
//					} else {
////						
////						modelMap.addAttribute("searchWarning", "Product not found.");
////						modelMap.addAttribute("searchedProductId", productId);
//						return "product404";
//					}
//				}
//				
//			}catch (Exception e) {
//				// TODO: handle exception
//			}
//			return "searchproduct";
//		} else {
//			return "login-register.html";
//		}
//	}

	@RequestMapping("/searchproduct")
	public String searchProduct(@RequestParam(value = "pId", required = false) Long productId, ModelMap modelMap) {
	    if (UserController.isvalidate) {
	        try {
	            if (productId != null) {
	                List<Product> allProducts = service.getAllProducts();
	                boolean productFound = false;
	                
	                for (Product sproduct : allProducts) {
	                    if (sproduct.getpId() == productId) {
	                        List<Product> products = new ArrayList<>();
	                        products.add(sproduct);
	                        modelMap.addAttribute("products", products);
	                        productFound = true;
	                        break;
	                    }
	                }
	                
	                if (!productFound) {
	                    return "product404";
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            // Handle exception
	        }
	        return "searchproduct";
	    } else {
	        return "login-register.html";
	    }
	}

	@RequestMapping("/searchproductpg")
	public String searchProduct() {
		if (UserController.isvalidate) {
			return "searchproduct";
		} else {
			return "login-register.html";
		}
	}

//view by catagory
	@RequestMapping("/products")
	public String viewProductsByCategory(@RequestParam("category") String category, Model model) {
		List<Product> products = service.getProductsByCategory(category);
		model.addAttribute("products", products);
		return "products";
	}
}
