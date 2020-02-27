package com.lastrada.website.lastrada.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
	
	public List<Product> fetchAllItems() {
	return (List<Product>) productRepository.findAll();
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
		}
		catch(ParseException exception) {
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
		this.productRepository.save(product);
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
	
				 this.orderStatusRepository.save(order);
				
	}
	

	
	
}

enum CustOrderTimePeriod{
	TODAY(1),WEEK(7),MONTH(30);
	
	private Integer days;
	CustOrderTimePeriod(Integer days) {
		this.days=days;
	}
}
