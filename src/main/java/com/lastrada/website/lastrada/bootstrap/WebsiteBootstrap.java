package com.lastrada.website.lastrada.bootstrap;

import java.math.BigDecimal;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.lastrada.website.lastrada.model.Product;
import com.lastrada.website.lastrada.model.ProductAddition;
import com.lastrada.website.lastrada.model.ProductOption;
import com.lastrada.website.lastrada.repository.ProductAdditionRepository;
import com.lastrada.website.lastrada.repository.ProductOptionRepository;
import com.lastrada.website.lastrada.repository.ProductRepository;

@Component
public class WebsiteBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	
	private ProductRepository productRepository;
	private ProductAdditionRepository productAdditionRepository;
	private ProductOptionRepository productOptionRepository;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
		
	}
	
	public WebsiteBootstrap( ProductRepository productRepository, ProductAdditionRepository productAdditionRepository,
			ProductOptionRepository productOptionRepository) {
		this.productRepository=productRepository;
		this.productAdditionRepository=productAdditionRepository;
		this.productOptionRepository=productOptionRepository;
	}
	
	private void initData() {
		ProductOption productOption1 = new ProductOption("Pizza klein 26 ", null, new BigDecimal(12), null, null, null);
		ProductOption productOption2 = new ProductOption("Pizza normal 28 ", null, null, new BigDecimal(12), null, null);
		ProductOption productOption3 = new ProductOption("Pizza family 32 ", null, null, null, new BigDecimal(12), null);
		ProductOption productOption4 = new ProductOption("Pizza party 38 ", null, null, null, null, new BigDecimal(12));
		ProductOption productOption5 = new ProductOption("Salsa Sauce ", new BigDecimal(1.5), null, null, null, null);
		ProductOption productOption6 = new ProductOption("Noodle Pesto ", new BigDecimal(2), null, null, null, null);
		
		this.productOptionRepository.save(productOption1);
		this.productOptionRepository.save(productOption2);
		this.productOptionRepository.save(productOption3);
		this.productOptionRepository.save(productOption4);
		this.productOptionRepository.save(productOption5);
		this.productOptionRepository.save(productOption6);
		
		ProductAddition productAddition1 = new ProductAddition("mit fladenbrot",new BigDecimal(2),null,null,null,null);
		ProductAddition productAddition2 = new ProductAddition("mit brocolli",null,new BigDecimal(2),new BigDecimal(2.5),new BigDecimal(3),new BigDecimal(4));

		ProductAddition productAddition3 = new ProductAddition("mit käse",null,new BigDecimal(2),new BigDecimal(2.5),new BigDecimal(3),new BigDecimal(4));

		ProductAddition productAddition4 = new ProductAddition("mit oliven",new BigDecimal(1),new BigDecimal(2),new BigDecimal(2.5),new BigDecimal(3),new BigDecimal(4));

		this.productAdditionRepository.save(productAddition1);
		this.productAdditionRepository.save(productAddition2);
		this.productAdditionRepository.save(productAddition3);
		this.productAdditionRepository.save(productAddition4);
		
		
		Product productPizzaMargheritta= new Product("Margherita","Große wahl",new BigDecimal(6.9));
		productPizzaMargheritta.getProductAdditions().add(productAddition2);
		productPizzaMargheritta.getProductAdditions().add(productAddition4);
		productPizzaMargheritta.getProductOptions().add(productOption1);
		productPizzaMargheritta.getProductOptions().add(productOption2);
		productPizzaMargheritta.getProductOptions().add(productOption3);
		productPizzaMargheritta.getProductOptions().add(productOption4);
		this.productRepository.save(productPizzaMargheritta);
		Product productBhartha= new Product("Bhartha","bio zutaten",new BigDecimal(10.00));
		productBhartha.getProductAdditions().add(productAddition1);
		productBhartha.getProductOptions().add(productOption5);
		productBhartha.getProductOptions().add(productOption6);
		this.productRepository.save(productBhartha);
	}

}
