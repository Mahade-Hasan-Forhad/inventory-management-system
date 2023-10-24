package com.forhad.ims.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.forhad.ims.entities.Sale;
import com.forhad.ims.service.SaleService;

@Controller
public class SaleController {

	// sale service repo

	@Autowired
	SaleService saleservice;

	// view all record
	@RequestMapping("/viewsale")
	public String viewsale(ModelMap modelMap) {
		if (UserController.isvalidate) {
			List<Sale> sales = saleservice.getAllSales();
			modelMap.addAttribute("sales", sales);
			return "viewsale.html";
		} else

		{
			return "login-register.html";
		}
	}
	/*
	 * // save records
	 * 
	 * @RequestMapping("/addsales") public String viewSales(@ModelAttribute("sale")
	 * Sale sale) {
	 * 
	 * return "addsales.html"; }
	 * 
	 * @RequestMapping("/saveSales") public String savesales(@ModelAttribute("sale")
	 * Sale sale, ModelMap modelMap) { saleservice.saveSale(sale); return
	 * "addsales.html"; }
	 */
}
