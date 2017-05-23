package com.Nvr.Frontend.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Nvr.Backend.dao.CategoryDAO;
import com.Nvr.Backend.dao.ProductDAO;
import com.Nvr.Backend.dao.SupplierDAO;
import com.Nvr.Backend.model.Category;
import com.Nvr.Backend.model.Product;
import com.Nvr.Backend.model.Supplier;

@Controller
public class ProductController {
	@Autowired
	ProductDAO productDao;
	@Autowired
	Category category;
	@Autowired
	Supplier supplier;
	@Autowired
	CategoryDAO categoryDao;
	@Autowired
	SupplierDAO supplierDao;
	@RequestMapping("/Product")
	public String productForm(Model m) {
		m.addAttribute("product", new Product());
		m.addAttribute("categorylist", categoryDao.showCategory());
		m.addAttribute("category", new Category());
		m.addAttribute("supplierlist", supplierDao.showSupplier());
		m.addAttribute("supplier", new Supplier());
		//List<Product> list = productDao.showProduct();
		//m.addAttribute("products", list);
		return "ProductForm";
	}

	@RequestMapping(value = "/saveProduct")
	public String saveProduct(@Valid @ModelAttribute("product") Product product,
			@RequestParam("pimage") MultipartFile filedet, Model m,BindingResult result) {

		if(result.hasErrors())
			return "ProductForm";
		
		category=categoryDao.getByName(product.getCategory().getCname());
		System.out.println(category.getCid() + ":" + category.getCname() + ":" + category.getDescription());
		supplier=supplierDao.getByName(product.getSupplier().getSname());
		
		System.out.println(supplier.getSid() + ":" + supplier.getSname() + ":" + supplier.getAddress());
		m.addAttribute("Supplier", supplier);
		m.addAttribute("Category", category);
		m.addAttribute("categorylist", categoryDao.showCategory());
		m.addAttribute("supplierlist", supplierDao.showSupplier());
		
		product.setCatid(category.getCid());
		product.setSuppid(supplier.getSid());

		product.setCategory(category);
		product.setSupplier(supplier);
		productDao.insertProduct(product);
		// Image Uploading Code
		String path ="H:/nvr/Frontend/src/main/webapp/WEB-INF/resources/images/";

		path = path + String.valueOf(product.getPid()) + ".jpg";

		File f = new File(path);

		if (!filedet.isEmpty()) {
			try {
				byte[] bytes = filedet.getBytes();
				FileOutputStream fos = new FileOutputStream(f);
				BufferedOutputStream bs = new BufferedOutputStream(fos);
				bs.write(bytes);
				System.out.println("success");
				bs.close();

			} catch (Exception e) {
				System.out.println("Exception Arised:" + e);
			}

		} else {
			System.out.println("File Uploading Problem");
		}

		// Complete Image Uploading

		
	/*	MultipartFile image=product.getPimage();
		if(image!=null && !image.isEmpty())
		{
		Path path=Paths.get("H:/nvr/Frontend/src/main/webapp/WEB-INF/resources/images/"+product.getPid()+".jpg");
		try {
			image.transferTo(new File(path.toString()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}*/
		List<Product> list = productDao.showProduct();
		m.addAttribute("product", new Product());
		m.addAttribute("products", list);
		return "ProductForm";
	}

	@RequestMapping(value = "/deleteProduct/{pid}")
	public String deletProduct(@PathVariable("pid") int pid, Model m) {
		productDao.deleteProduct(pid);
		List<Product> list = productDao.showProduct();
		m.addAttribute("products", list);
		return "redirect:/Product";
	}

	@RequestMapping(value = "/updateProduct/{pid}")
	public String updateProductForm(@PathVariable("pid") int pid, Model m) {
		Product product = productDao.getProduct(pid);
		m.addAttribute("product", product);
		return "UpdateProductForm";
	}

	@RequestMapping(value = "/updateProduct")
	public String updateProduct(@ModelAttribute("product") Product product, Model m) {
		
		productDao.updateProduct(product);
		
		return "redirect:/Product";
	}
}
