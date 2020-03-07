package com.lastrada.website.lastrada.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lastrada.website.lastrada.model.Credentials;
import com.lastrada.website.lastrada.model.CredentialsHolder;
import com.lastrada.website.lastrada.model.CustOrder;
import com.lastrada.website.lastrada.model.OrderItem;
import com.lastrada.website.lastrada.model.OrderStatus;
import com.lastrada.website.lastrada.model.OrderStatusEnum;
import com.lastrada.website.lastrada.model.Product;
import com.lastrada.website.lastrada.model.ProductAddition;
import com.lastrada.website.lastrada.model.ProductCategory;
import com.lastrada.website.lastrada.model.ProductOption;
import com.lastrada.website.lastrada.model.WebsiteStatus;
import com.lastrada.website.lastrada.pojo.ProductPOJO;
import com.lastrada.website.lastrada.repository.CredentialsRepository;
import com.lastrada.website.lastrada.repository.CustOrderRepository;
import com.lastrada.website.lastrada.repository.OrderItemRepository;
import com.lastrada.website.lastrada.repository.OrderStatusRepository;
import com.lastrada.website.lastrada.repository.ProductAdditionRepository;
import com.lastrada.website.lastrada.repository.ProductOptionRepository;
import com.lastrada.website.lastrada.repository.ProductRepository;
import com.lastrada.website.lastrada.repository.WebsiteStatusRepository;

@Service
public class ShopService {
	
	Logger logger = LoggerFactory.getLogger(ShopService.class);
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductOptionRepository productOptionRepository;
	
	@Autowired
	private WebsiteStatusRepository websiteStatusRepository;
	
	@Autowired
	private ProductAdditionRepository productAdditionRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private CustOrderRepository customerOrderRepository;
	
	@Autowired
	private OrderStatusRepository orderStatusRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CredentialsRepository credentialsRepository;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private EmailService emailService;
	
	public List<Product> fetchAllItems() {
		List<Product> allProduct=(List<Product>) productRepository.findAll();
		List<Product> returnProductsList=new ArrayList<>();
		for(Product currentProduct :allProduct) {
			if(currentProduct.isStatus()) {
			returnProductsList.add(currentProduct);
			};
		}
	return returnProductsList;
	}
	

	
	public Iterable<OrderStatus> fetchOrders(String custOrderFetchMode){
		try {
		switch(custOrderFetchMode) {
		case "Bearbeitet":return this.orderStatusRepository.findAllProcessedOrders();
		case "Unbearbeitet":return this.orderStatusRepository.findAllNotProcessedOrders();
		case "Von Heute": return fetchCustOrderWithGiveTimePeriod(this.orderStatusRepository.findAll(),CustOrderTimePeriod.TODAY);
		case "Von dieser Woche":return fetchCustOrderWithGiveTimePeriod(this.orderStatusRepository.findAll(),CustOrderTimePeriod.WEEK);
		case "Von diesen Monat":return fetchCustOrderWithGiveTimePeriod(this.orderStatusRepository.findAll(),CustOrderTimePeriod.MONTH);	
		case "Alle":
		default:return this.orderStatusRepository.findAll();
		}
		} catch(Exception exception) {
			logger.info(exception.getMessage());
		}
		return null;
		
		
		
	}
	
		public void updateWebsiteStatus(WebsiteStatus websiteStatus) {
			this.websiteStatusRepository.deleteAll();
			this.websiteStatusRepository.save(websiteStatus);
		}

	private Iterable<OrderStatus> fetchCustOrderWithGiveTimePeriod(Iterable<OrderStatus> allOrders, CustOrderTimePeriod period) throws ParseException {
		List<OrderStatus> ordersFromToday=new ArrayList<OrderStatus>();
		for(OrderStatus currentOrder:allOrders) {
			if(custOrderFallsInBetween(currentOrder,period)) {
				ordersFromToday.add(currentOrder);
			}
		}
		Collections.sort(ordersFromToday, new Comparator<OrderStatus>() {

			@Override
			public int compare(OrderStatus o1, OrderStatus o2) {
				if(o1.getId() > o2.getId())
				return 1;
				return 0;
			}
		});
		return ordersFromToday;
	}
	
	private boolean custOrderFallsInBetween(OrderStatus order,CustOrderTimePeriod custOrderTimePeriod) throws ParseException {
		  SimpleDateFormat sdformat = new SimpleDateFormat("dd-MM-yyy");
	      Date orderDate = sdformat.parse(order.getOrderDate());
	      LocalDate orderLocalDate=convertToLocalDateViaInstant(orderDate);
	      LocalDate todaylocalDate= LocalDate.now();
	      LocalDate oneweekBefore = todaylocalDate.minus(1, ChronoUnit.WEEKS);
	      LocalDate oneMonthBefore = todaylocalDate.minus(1, ChronoUnit.MONTHS);
		  switch(custOrderTimePeriod) {
		  case TODAY: return orderLocalDate.isEqual(todaylocalDate);
		  case WEEK: return  orderLocalDate.isEqual(oneweekBefore) || orderLocalDate.isAfter(oneweekBefore);
		  case MONTH: return orderLocalDate.isEqual(oneMonthBefore) || orderLocalDate.isAfter(oneMonthBefore);
		  }
		
		return false;
	}

	public void saveProduct(Product product) {
		
		// saving Pizza
		if(ProductCategory.Pizza.toString().equals(product.getProductCategory()) || ProductCategory.Vegatarische_Pizza.toString() .equals(product.getProductCategory())) {
			Product onePizzaProduct =  this.productRepository.findOnePizza();
			Set<ProductAddition> existingProductAdditions= onePizzaProduct.getProductAdditions();
			Set<ProductAddition> newProductAdditions=new HashSet<ProductAddition>();
			for( ProductAddition currentProductAddition:existingProductAdditions) {
				newProductAdditions.add(currentProductAddition);
			}
			product.setProductAdditions(newProductAdditions);
			product.setStatus(true);
			this.productOptionRepository.saveAll(product.getProductOptions());
			this.productRepository.save(product);
		}else {
			product.setStatus(true);
			if(product.getProductOptions().size() > 0) {
			this.productOptionRepository.saveAll(product.getProductOptions());
			}
			if(product.getProductAdditions().size() > 0) {
				this.productAdditionRepository.saveAll(product.getProductAdditions());
			}
			this.productRepository.save(product);
		}
	}
	
	public void deleteProduct(Product product) {
		Product foundProduct=this.productRepository.findById(product.getId()).get();
		foundProduct.setStatus(false);
		this.productRepository.save(foundProduct);
	}
	
	public void editProduct(Product newProduct) {
		Product foundOldProduct=this.productRepository.findById(newProduct.getId()).get();
		Set<ProductAddition> oldProductAdditions= foundOldProduct.getProductAdditions();
		Set<ProductOption> oldProductOptions=foundOldProduct.getProductOptions();
		Set<ProductAddition> newProductAdditions= newProduct.getProductAdditions();
		Set<ProductOption> newProductOptions=newProduct.getProductOptions();
		
		if(oldProductOptions.size() > 0 && newProductOptions.size() > 0 ) {
			for(ProductOption currentProductOption :newProductOptions) {
				for(ProductOption oldCurrentProductOption :oldProductOptions) {
					if(currentProductOption.getId().equals(oldCurrentProductOption.getId())) {
						oldCurrentProductOption.setOptionPrice(currentProductOption.getOptionPrice());
						oldCurrentProductOption.setDefault(currentProductOption.isDefault());
						oldCurrentProductOption.setOptionPriceForFamily(currentProductOption.getOptionPriceForFamily());
						oldCurrentProductOption.setOptionPriceForNormal(currentProductOption.getOptionPriceForNormal());
						oldCurrentProductOption.setOptionPriceForParty(currentProductOption.getOptionPriceForParty());
						oldCurrentProductOption.setOptionPriceForSmall(currentProductOption.getOptionPriceForSmall());
						oldCurrentProductOption.setOptionPrice(currentProductOption.getOptionPrice());
						oldCurrentProductOption.setProductOptionDescription(currentProductOption.getProductOptionDescription());
						this.productOptionRepository.save(oldCurrentProductOption);
						break;
					}
				}
			}
		}
		if(oldProductAdditions.size() > 0 && newProductAdditions.size() > 0 ) {
			for(ProductAddition currentProductAddition :newProductAdditions) {
				for(ProductAddition oldCurrentProductAddition :oldProductAdditions) {
					if(currentProductAddition.getId().equals(oldCurrentProductAddition.getId())) {
						oldCurrentProductAddition.setAdditionDescription(currentProductAddition.getAdditionDescription());
						oldCurrentProductAddition.setAdditionPrice(currentProductAddition.getAdditionPrice());
						oldCurrentProductAddition.setAdditionsPriceForFamily(currentProductAddition.getAdditionsPriceForFamily());
						oldCurrentProductAddition.setAdditionsPriceForNormal(currentProductAddition.getAdditionsPriceForNormal());
						oldCurrentProductAddition.setAdditionsPriceForParty(currentProductAddition.getAdditionsPriceForParty());
						oldCurrentProductAddition.setAdditionsPriceForSmall(currentProductAddition.getAdditionsPriceForSmall());
						this.productAdditionRepository.save(oldCurrentProductAddition);
						break;
					}
				}
			}
		}
		
		foundOldProduct.setDescription(newProduct.getDescription());
		foundOldProduct.setOptionDescription(newProduct.getOptionDescription());
		foundOldProduct.setProductBasePrice(newProduct.getProductBasePrice());
		this.productRepository.save(foundOldProduct);
	}
	
	
	public WebsiteStatus getWebsiteStatus() {
		ArrayList<WebsiteStatus> webSiteStatus = (ArrayList<WebsiteStatus>) this.websiteStatusRepository.findAll();
		return webSiteStatus.get(0);
	}
	
	public void processCredentialsChange(CredentialsHolder credentials) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					credentials.getUsername(), credentials.getPassword()));
			if(!credentials.getNewPassword().equalsIgnoreCase(credentials.getRepeatNewPassword())) {
				throw new Exception("Old And New Password do not match");
			}
		} catch (Exception exception) {
			throw new Exception("Bad Credentials", exception);
		}
		
		credentialsRepository.deleteAll();
		Credentials newCredentials = new Credentials();
		newCredentials.setUsername(credentials.getUsername());
		String encodedPassword =bCryptPasswordEncoder.encode(credentials.getNewPassword());
		newCredentials.setPassword(encodedPassword);
		credentialsRepository.save(newCredentials);
		
		
	}
	
	private LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	
	public Long saveCustomerOrder(CustOrder customerOrder) {
		for(OrderItem orderItem : customerOrder.getOrder()) {
			
			this.orderItemRepository.save(orderItem);
		}
		CustOrder savedCustOrder= this.customerOrderRepository.save(customerOrder);
		this.orderStatusRepository.save(new OrderStatus(customerOrder, OrderStatusEnum.UNBERABEITET.getValue(),getCurrentDate(),getCurrentTime(),savedCustOrder.getId()));
		return savedCustOrder.getId();
	}
	
	
	private String getCurrentDate() {
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.format(date);
	}
	
	private String getCurrentTime() {
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		return formatter.format(date);
	}

	public void saveProductOption(ProductOption productOption) {
		this.productOptionRepository.save(productOption);
		
	}
	
	public void saveProductAddition(ProductAddition productAddition) {
		this.productAdditionRepository.save(productAddition);
		
	}

	public void updateOrder(OrderStatus order) {
		Boolean sendMail=false;
		Optional<OrderStatus> existingOrder=this.orderStatusRepository.findById(order.getId());
		if(existingOrder!=null && existingOrder.get()!=null) {
			OrderStatus existingOrd=existingOrder.get();
			if(OrderStatusEnum.UNBERABEITET.getValue()==existingOrd.getStatus() && OrderStatusEnum.BEARBEITET.getValue()==order.getStatus()) {
				sendMail=true;
			}
		}
		this.orderStatusRepository.save(order);
		if(sendMail) {
		String emailTo = order.getCustOrder().getEmail();
		//try {
			emailService.sendEmail(emailTo, order.getCustOrder().getCustomerName(),
					"Ihre Lastrada Bestellung Nr." + order.getOrderNumber());
		//}
		}
	}
	

	
	
}

enum CustOrderTimePeriod{
	TODAY(1),WEEK(7),MONTH(30);
	
	private Integer days;
	CustOrderTimePeriod(Integer days) {
		this.days=days;
	}
}
