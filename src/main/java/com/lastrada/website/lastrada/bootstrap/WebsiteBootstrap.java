package com.lastrada.website.lastrada.bootstrap;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.crypto.Data;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.lastrada.website.lastrada.model.Notification;
import com.lastrada.website.lastrada.model.Product;
import com.lastrada.website.lastrada.model.ProductAddition;
import com.lastrada.website.lastrada.model.ProductCategory;
import com.lastrada.website.lastrada.model.ProductOption;
import com.lastrada.website.lastrada.model.WebsiteStatus;
import com.lastrada.website.lastrada.repository.NotificationRepository;
import com.lastrada.website.lastrada.repository.ProductAdditionRepository;

import com.lastrada.website.lastrada.repository.ProductOptionRepository;
import com.lastrada.website.lastrada.repository.ProductRepository;
import com.lastrada.website.lastrada.repository.WebsiteStatusRepository;

@Component
public class WebsiteBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	
	private ProductRepository productRepository;
	private ProductAdditionRepository productAdditionRepository;
	private ProductOptionRepository productOptionRepository;
	@Autowired
	private WebsiteStatusRepository webSiteStatusRepository;
	@Autowired
	private NotificationRepository notificationRepository;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initWebSiteStatus() ;
		initNotificationSounds();
		// Lastrada initial Data
	//	it should run only once to fill the Data. make sure to comment it afterwards.
		ArrayList listOfProducts=(ArrayList) this.productRepository.findAll();
		if(listOfProducts!=null && listOfProducts.size() > 1) {
			// then do nothing, product already exists
		}else {
			initNotificationSounds();
			initWebSiteStatus();
			initProducts();
		}
		
	}
	
	private void initNotificationSounds() {
		 List<Notification> allNotifications=(List<Notification>) this.notificationRepository.findAll();
		 if(allNotifications!=null && allNotifications.size() <=0) {
	Notification notification1= new Notification();
	notification1.setToneOn(true);
	notification1.setToneName("klingel_1.mp3");
	this.notificationRepository.save(notification1);
	Notification notification2= new Notification();
	notification2.setToneOn(false);
	notification2.setToneName("klingel_2.mp3");
	this.notificationRepository.save(notification2);
	Notification notification3= new Notification();
	notification3.setToneOn(false);
	notification3.setToneName("klingel_3.mp3");
	this.notificationRepository.save(notification3);
	Notification notification4= new Notification();
	notification4.setToneOn(false);
	notification4.setToneName("klingel_4.mp3");
	this.notificationRepository.save(notification4);
	Notification notification5= new Notification();
	notification5.setToneOn(false);
	notification5.setToneName("klingel_5.mp3");
	this.notificationRepository.save(notification5);
	Notification notification6= new Notification();
	notification6.setToneOn(false);
	notification6.setToneName("klingel_6.mp3");
	this.notificationRepository.save(notification6);
	Notification notification7= new Notification();
	notification7.setToneOn(false);
	notification7.setToneName("klingel_7.mp3");
	this.notificationRepository.save(notification7);
		 }
	}

	/*
	 * In very beginning Website should be online by default
	 */
	private void initWebSiteStatus() {
		List<WebsiteStatus> allWebStatus =  (List<WebsiteStatus>) this.webSiteStatusRepository.findAll();
		if(allWebStatus==null || allWebStatus.size() < 1) {
			WebsiteStatus defaultWebStatus = new WebsiteStatus();
			defaultWebStatus.setStatus(true);
			defaultWebStatus.setMessage("Website is online");
			this.webSiteStatusRepository.save(defaultWebStatus);
		}
		
	}

	public WebsiteBootstrap( ProductRepository productRepository, ProductAdditionRepository productAdditionRepository,
			ProductOptionRepository productOptionRepository) {
		this.productRepository=productRepository;
		this.productAdditionRepository=productAdditionRepository;
		this.productOptionRepository=productOptionRepository;
	}
	
	
	
	private void initProducts() {
		ProductOption productOpton1=new ProductOption("mit Cocktailsauce", new BigDecimal(0), null, null, null, null);
		
		ProductOption productOpton2=new ProductOption("mit Joghurtsauce", new BigDecimal(0), null, null, null, null);
		ProductOption productOpton3=new ProductOption("ohne Sauce", new BigDecimal(0), null, null, null, null);
		ProductOption productOpton4=new ProductOption("mit Pommes frites", new BigDecimal(0), null, null, null, null);
		ProductOption productOpton5=new ProductOption("mit  Spätzle", new BigDecimal(0), null, null, null, null);
		ProductOption productOpton6=new ProductOption("ohne Beilage", new BigDecimal(0), null, null, null, null);
		ProductOption productOpton7=new ProductOption("mit Chilisauce", new BigDecimal(0), null, null, null, null);
		ProductOption productOpton8=new ProductOption("mit  Currysauce", new BigDecimal(0), null, null, null, null);
		ProductOption productOpton9=new ProductOption("ohne Sauce", new BigDecimal(0), null, null, null, null);
		ProductOption productOpton10=new ProductOption("mit  Reis", new BigDecimal(0), null, null, null, null);
		ProductOption productOpton11=new ProductOption("mit  Gnocchi", new BigDecimal(0), null, null, null, null);
		ProductOption productOpton12=new ProductOption("mit  Rigatoni", new BigDecimal(0), null, null, null, null);
		ProductOption productOpton13=new ProductOption("mit  Spaghetti", new BigDecimal(0), null, null, null, null);
		ProductOption productOpton14=new ProductOption("mit  Tortellini", new BigDecimal(0), null, null, null, null);
		ProductOption productOpton17=new ProductOption("klein, Ø26cm:", null, new BigDecimal(8.00), null, null, null);
		ProductOption productOpton18=new ProductOption("Groß, Ø30cm:", null, null, new BigDecimal(9.00), null, null);
		ProductOption productOpton19=new ProductOption("mit Cocktail -Dressing",new BigDecimal(0),null,null,null,null);
		ProductOption productOpton20=new ProductOption("mit Essig und öl",new BigDecimal(0),null,null,null,null);
		ProductOption productOpton21=new ProductOption("mit Joghurtsauce",new BigDecimal(0),null,null,null,null);
		ProductOption productOpton22=new ProductOption("ohne Dressing",new BigDecimal(0),null,null,null,null);
		ProductOption pizza790=new ProductOption("klein, Ø26cm:", null, new BigDecimal(8.00), null, null, null);
		ProductOption pizza900=new ProductOption("Groß, Ø30cm:", null, null, new BigDecimal(9.50), null, null);
		ProductOption pizza1850=new ProductOption("Familie,46cm x 33cm:", null, null, null, new BigDecimal(18.50), null);
		ProductOption pizza2350=new ProductOption("Party,60cm x 40cm:", null, null, null, null, new BigDecimal(23.50));
		
		ProductOption pizza570=new ProductOption("klein, Ø26cm:", null, new BigDecimal(5.70), null, null, null);
		ProductOption pizza670=new ProductOption("Groß, Ø30cm:", null, null, new BigDecimal(6.70), null, null);
		ProductOption pizza1570=new ProductOption("Familie,46cm x 33cm:", null, null, null, new BigDecimal(15.70), null);
		ProductOption pizza1900=new ProductOption("Party,60cm x 40cm:", null, null, null, null, new BigDecimal(19.00));
		
		ProductOption pizza640=new ProductOption("klein, Ø26cm:", null, new BigDecimal(6.50), null, null, null);
		ProductOption pizza790Second=new ProductOption("Groß, Ø30cm:", null, null, new BigDecimal(8.00), null, null);
		ProductOption pizza1600=new ProductOption("Familie,46cm x 33cm:", null, null, null, new BigDecimal(16.50), null);
		ProductOption pizza1990=new ProductOption("Party,60cm x 40cm:", null, null, null, null, new BigDecimal(20.00));
		
		
		ProductOption pizza690=new ProductOption("klein, Ø26cm:", null, new BigDecimal(7.00), null, null, null);
		ProductOption pizza840=new ProductOption("Groß, Ø30cm:", null, null, new BigDecimal(8.50), null, null);
		ProductOption pizza1750=new ProductOption("Familie,46cm x 33cm:", null, null, null, new BigDecimal(17.50), null);
		ProductOption pizza2100=new ProductOption("Party,60cm x 40cm:", null, null, null, null, new BigDecimal(21.50));
		
		
		ProductOption pizza940=new ProductOption("Groß, Ø30cm:", null, null, new BigDecimal(9.40), null, null);
		ProductOption pizza1950=new ProductOption("Familie,46cm x 33cm:", null, null, null, new BigDecimal(19.50), null);
		ProductOption pizza2450=new ProductOption("Party,60cm x 40cm:", null, null, null, null, new BigDecimal(24.50));
		
		
	
		this.productOptionRepository.save(pizza790);
		this.productOptionRepository.save(pizza900);
		this.productOptionRepository.save(pizza1850);
		this.productOptionRepository.save(pizza2350);
		this.productOptionRepository.save(pizza570);
		this.productOptionRepository.save(pizza670);
		this.productOptionRepository.save(pizza1570);
		this.productOptionRepository.save(pizza1900);
		this.productOptionRepository.save(pizza640);
		this.productOptionRepository.save(pizza790Second);
		this.productOptionRepository.save(pizza1600);
		this.productOptionRepository.save(pizza1990);
		this.productOptionRepository.save(pizza690);
		this.productOptionRepository.save(pizza840);
		this.productOptionRepository.save(pizza1750);
		this.productOptionRepository.save(pizza2100);
		this.productOptionRepository.save(pizza940);
		this.productOptionRepository.save(pizza1950);
		this.productOptionRepository.save(pizza2450);
		this.productOptionRepository.save(productOpton1);
		this.productOptionRepository.save(productOpton2);
		this.productOptionRepository.save(productOpton3);
		this.productOptionRepository.save(productOpton4);
		this.productOptionRepository.save(productOpton5);
		this.productOptionRepository.save(productOpton6);
		this.productOptionRepository.save(productOpton7);
		this.productOptionRepository.save(productOpton8);
		this.productOptionRepository.save(productOpton9);
		this.productOptionRepository.save(productOpton10);
		this.productOptionRepository.save(productOpton11);
		this.productOptionRepository.save(productOpton12);
		this.productOptionRepository.save(productOpton13);
		this.productOptionRepository.save(productOpton14);
		this.productOptionRepository.save(productOpton17);
		this.productOptionRepository.save(productOpton18);
		this.productOptionRepository.save(productOpton19);
		this.productOptionRepository.save(productOpton20);
		this.productOptionRepository.save(productOpton21);
		this.productOptionRepository.save(productOpton22);
		
		ProductAddition pa1=new ProductAddition("Sahnesauce", new BigDecimal(1.00), null, null, null, null);
		ProductAddition pa2=new ProductAddition("Fladenbrot", new BigDecimal(2.50), null, null, null, null);
		ProductAddition paa1=new ProductAddition("Käse überbacken Aufpreis", new BigDecimal(1.50), null, null, null, null);

		ProductAddition pa3=new ProductAddition("Ananas", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa4=new ProductAddition("Artischocken", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa5=new ProductAddition("Broccoli",null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa6=new ProductAddition("Champignons", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa7=new ProductAddition("Ei", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa8=new ProductAddition("Gorgonzola", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(3.50), new BigDecimal(5.00));
		ProductAddition pa9=new ProductAddition("Gyrosfleisch", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(2.00), new BigDecimal(2.00));
		ProductAddition pa10=new ProductAddition("Hähnchenfleisch",null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(2.00), new BigDecimal(2.00));
		ProductAddition pa11=new ProductAddition("Käse,extra", null, new BigDecimal(1.00), new BigDecimal(1.00),new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa12=new ProductAddition("knoblauch", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa13=new ProductAddition("krabben", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(3.50), new BigDecimal(5.00));
		ProductAddition pa14=new ProductAddition("Lachs", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50), new BigDecimal(5.00));
		ProductAddition pa15=new ProductAddition("Mais", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa16=new ProductAddition("Meeresfrüchten", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(3.50), new BigDecimal(5.00));
		ProductAddition pa17=new ProductAddition("Mozzarella", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa18=new ProductAddition("Paprika", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa19=new ProductAddition("Peperoni", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa20=new ProductAddition("Salami", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(2.00), new BigDecimal(2.00));
		ProductAddition pa21=new ProductAddition("Sardellen", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(2.00), new BigDecimal(2.00));
		ProductAddition pa22=new ProductAddition("Schafskäse", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa23=new ProductAddition("Schinken", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(2.00), new BigDecimal(2.00));
		ProductAddition pa24=new ProductAddition("Spinat", null, new BigDecimal(1.00), new BigDecimal(1.00),new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa25=new ProductAddition("Thunfisch", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(2.00), new BigDecimal(2.00));
		ProductAddition pa26=new ProductAddition("Tomaten", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa27=new ProductAddition("Tzatziki", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa28=new ProductAddition("Zwiebeln", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa29=new ProductAddition("käse im Rand", null, new BigDecimal(2.00), new BigDecimal(2.50), new BigDecimal(4.50), new BigDecimal(5.00));
		
		//Additions for Rösti 
		ProductAddition pa3Rösti=new ProductAddition("Ananas", new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa4Rösti=new ProductAddition("Artischocken",new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa5Rösti=new ProductAddition("Broccoli",new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa6Rösti=new ProductAddition("Champignons",new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa7Rösti=new ProductAddition("Ei", new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa8Rösti=new ProductAddition("Gorgonzola",new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa9Rösti=new ProductAddition("Gyrosfleisch", new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa10Rösti=new ProductAddition("Hähnchenfleisch",new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa11Rösti=new ProductAddition("Käse,extra",new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa12Rösti=new ProductAddition("knoblauch",new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa13Rösti=new ProductAddition("krabben",new BigDecimal(1.50), null,null,null,null);
		ProductAddition pa14Rösti=new ProductAddition("Lachs",new BigDecimal(1.50), null,null,null,null);
		ProductAddition pa15Rösti=new ProductAddition("Mais", new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa16Rösti=new ProductAddition("Meeresfrüchten", new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa17Rösti=new ProductAddition("Mozzarella", new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa18Rösti=new ProductAddition("Paprika", new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa19Rösti=new ProductAddition("Peperoni", new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa20Rösti=new ProductAddition("Salami", new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa21Rösti=new ProductAddition("Sardellen",new BigDecimal(1.50), null,null,null,null);
		ProductAddition pa22Rösti=new ProductAddition("Schafskäse", new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa23Rösti=new ProductAddition("Schinken", new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa24Rösti=new ProductAddition("Spinat", new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa25Rösti=new ProductAddition("Thunfisch",new BigDecimal(1.50), null,null,null,null);
		ProductAddition pa26Rösti=new ProductAddition("Tomaten",new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa27Rösti=new ProductAddition("Tzatziki", new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa28Rösti=new ProductAddition("Zwiebeln", new BigDecimal(1.00), null,null,null,null);
		ProductAddition pa29Rösti=new ProductAddition("käse im Rand", new BigDecimal(1.00), null,null,null,null);
		
		
		// addition for calzone
		ProductAddition pa3calzone=new ProductAddition("Ananas", null, new BigDecimal(1.00), new BigDecimal(1.50), null, null);
		ProductAddition pa4calzone=new ProductAddition("Artischocken", null, new BigDecimal(1.00), new BigDecimal(1.50), null,null);
		ProductAddition pa5calzone=new ProductAddition("Broccoli",null, new BigDecimal(1.00), new BigDecimal(1.50), null,null);
		ProductAddition pa6calzone=new ProductAddition("Champignons", null, new BigDecimal(1.00), new BigDecimal(1.50), null,null);
		ProductAddition pa7calzone=new ProductAddition("Ei", null, new BigDecimal(1.00), new BigDecimal(1.50), null,null);
		ProductAddition pa8calzone=new ProductAddition("Gorgonzola", null, new BigDecimal(1.00), new BigDecimal(1.50), null,null);
		ProductAddition pa9calzone=new ProductAddition("Gyrosfleisch", null, new BigDecimal(1.00), new BigDecimal(1.50), null,null);
		ProductAddition pa10calzone=new ProductAddition("Hähnchenfleisch",null, new BigDecimal(1.00), new BigDecimal(1.50), null,null);
		ProductAddition pa11calzone=new ProductAddition("Käse,extra", null, new BigDecimal(1.00), new BigDecimal(1.50),null,null);
		ProductAddition pa12calzone=new ProductAddition("knoblauch", null, new BigDecimal(1.00), new BigDecimal(1.50), null,null);
		ProductAddition pa15calzone=new ProductAddition("Mais", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa17calzone=new ProductAddition("Mozzarella", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa18calzone=new ProductAddition("Paprika", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa19calzone=new ProductAddition("Peperoni", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa20calzone=new ProductAddition("Salami", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(2.00), new BigDecimal(2.00));
		ProductAddition pa22calzone=new ProductAddition("Schafskäse", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa23calzone=new ProductAddition("Schinken", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(2.00), new BigDecimal(2.00));
		ProductAddition pa24calzone=new ProductAddition("Spinat", null, new BigDecimal(1.00), new BigDecimal(1.50),new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa26calzone=new ProductAddition("Tomaten", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa27calzone=new ProductAddition("Tzatziki", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa28calzone=new ProductAddition("Zwiebeln", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa29calzone=new ProductAddition("käse im Rand", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(4.50), new BigDecimal(5.00));
		
		
		Set<ProductAddition> calzoneAdditionsOnly = new HashSet<>();
		calzoneAdditionsOnly.add(pa3calzone);
		calzoneAdditionsOnly.add(pa4calzone);
		calzoneAdditionsOnly.add(pa5calzone);
		calzoneAdditionsOnly.add(pa6calzone);
		calzoneAdditionsOnly.add(pa7calzone);
		calzoneAdditionsOnly.add(pa8calzone);
		calzoneAdditionsOnly.add(pa9calzone);
		calzoneAdditionsOnly.add(pa10calzone);
		calzoneAdditionsOnly.add(pa11calzone);
		calzoneAdditionsOnly.add(pa12calzone);
		calzoneAdditionsOnly.add(pa15calzone);
		calzoneAdditionsOnly.add(pa17calzone);
		calzoneAdditionsOnly.add(pa18calzone);
		calzoneAdditionsOnly.add(pa19calzone);
		calzoneAdditionsOnly.add(pa20calzone);
		calzoneAdditionsOnly.add(pa22calzone);
		calzoneAdditionsOnly.add(pa23calzone);
		calzoneAdditionsOnly.add(pa24calzone);
		calzoneAdditionsOnly.add(pa26calzone);
		calzoneAdditionsOnly.add(pa27calzone);
		calzoneAdditionsOnly.add(pa28calzone);
		calzoneAdditionsOnly.add(pa29calzone);
		
		Set<ProductAddition>röstiAdditionsOnly=new HashSet<>();
		röstiAdditionsOnly.add(pa3Rösti);
		röstiAdditionsOnly.add(pa4Rösti);
		röstiAdditionsOnly.add(pa5Rösti);
		röstiAdditionsOnly.add(pa6Rösti);
		röstiAdditionsOnly.add(pa7Rösti);
		röstiAdditionsOnly.add(pa8Rösti);
		röstiAdditionsOnly.add(pa9Rösti);
		röstiAdditionsOnly.add(pa10Rösti);
		röstiAdditionsOnly.add(pa11Rösti);
		röstiAdditionsOnly.add(pa12Rösti);
		röstiAdditionsOnly.add(pa13Rösti);
		röstiAdditionsOnly.add(pa14Rösti);
		röstiAdditionsOnly.add(pa15Rösti);
		röstiAdditionsOnly.add(pa16Rösti);
		röstiAdditionsOnly.add(pa17Rösti);
		röstiAdditionsOnly.add(pa18Rösti);
		röstiAdditionsOnly.add(pa19Rösti);
		röstiAdditionsOnly.add(pa20Rösti);
		röstiAdditionsOnly.add(pa21Rösti);
		röstiAdditionsOnly.add(pa22Rösti);
		röstiAdditionsOnly.add(pa23Rösti);
		röstiAdditionsOnly.add(pa24Rösti);
		röstiAdditionsOnly.add(pa25Rösti);
		röstiAdditionsOnly.add(pa26Rösti);
		röstiAdditionsOnly.add(pa27Rösti);
		röstiAdditionsOnly.add(pa28Rösti);
		röstiAdditionsOnly.add(pa29Rösti);
		
		//Pizza Additions 
		Set<ProductAddition>pizzaAdditionsOnly=new HashSet<>();
		pizzaAdditionsOnly.add(pa3);
		pizzaAdditionsOnly.add(pa4);
		pizzaAdditionsOnly.add(pa5);
		pizzaAdditionsOnly.add(pa6);
		pizzaAdditionsOnly.add(pa7);
		pizzaAdditionsOnly.add(pa8);
		pizzaAdditionsOnly.add(pa9);
		pizzaAdditionsOnly.add(pa10);
		pizzaAdditionsOnly.add(pa11);
		pizzaAdditionsOnly.add(pa12);
		pizzaAdditionsOnly.add(pa13);
		pizzaAdditionsOnly.add(pa14);
		pizzaAdditionsOnly.add(pa15);
		pizzaAdditionsOnly.add(pa16);
		pizzaAdditionsOnly.add(pa17);
		pizzaAdditionsOnly.add(pa18);
		pizzaAdditionsOnly.add(pa19);
		pizzaAdditionsOnly.add(pa20);
		pizzaAdditionsOnly.add(pa21);
		pizzaAdditionsOnly.add(pa22);
		pizzaAdditionsOnly.add(pa23);
		pizzaAdditionsOnly.add(pa24);
		pizzaAdditionsOnly.add(pa25);
		pizzaAdditionsOnly.add(pa26);
		pizzaAdditionsOnly.add(pa27);
		pizzaAdditionsOnly.add(pa28);
		pizzaAdditionsOnly.add(pa29);

this.productAdditionRepository.save(pa1);
this.productAdditionRepository.save(paa1);
this.productAdditionRepository.save(pa2);
this.productAdditionRepository.saveAll(pizzaAdditionsOnly);
this.productAdditionRepository.saveAll(calzoneAdditionsOnly);
this.productAdditionRepository.saveAll(röstiAdditionsOnly);

		
		// Alkohlische Getränke
		Product product16=new Product("204 Beck's Pils 0,5l", ProductCategory.Alkohlische_Getränke, "5,0% volinkl. Pfand (0,08 €)5,08 €/l0,500l", new BigDecimal(2.58));
		Product product15=new Product("208 Farny Kristallweizen 0,5l ", ProductCategory.Alkohlische_Getränke, "38,0% volinkl. Pfand (0,08 €)5,08 €/l0,500l", new BigDecimal(2.58));
		Product product14=new Product("209 Leibinger Export 0,5l", ProductCategory.Alkohlische_Getränke, "9,7% volinkl. Pfand (0,08 €)5,08 €/l0,500l", new BigDecimal(2.58));
		Product product13=new Product("210 Meckatzer 0,5l", ProductCategory.Alkohlische_Getränke, ",7% volinkl. Pfand (0,08 €)5,08 €/l0,500l", new BigDecimal(2.58));
		Product product12=new Product("212 Jim Beam 0,7l", ProductCategory.Alkohlische_Getränke, "27,86 €/l0,700l", new BigDecimal(19.50));
		Product product11=new Product("213 Jack Daniel's 0,7l", ProductCategory.Alkohlische_Getränke, "40,0% vol35,71 €/l0,700l", new BigDecimal(25.00));
		Product product10=new Product("214 Jack Daniels mit Coca Cola 0,33l Dose", ProductCategory.Alkohlische_Getränke, "Enthält Koffein (9,6 mg/100 ml)inkl. Pfand (0,25 €)14,64 €/l0,330l", new BigDecimal(5.00));
		Product product9=new Product("215 Wodka 0,7l", ProductCategory.Alkohlische_Getränke, "35,0% vol21,43 €/l0,700l", new BigDecimal(15.00));
		Product product8=new Product("216 Lambrusco 0,75l", ProductCategory.Alkohlische_Getränke, "9,7% vol 8,67 €/l0,750l", new BigDecimal(6.50));
		Product product7=new Product("217 Chianti 0,75l", ProductCategory.Alkohlische_Getränke, "10,0% vol10,00 €/l0,750l", new BigDecimal(7.50));
		Product product5=new Product("219 Soave 0,75l ", ProductCategory.Alkohlische_Getränke, "9,7% vol10,00 €/l0,750l", new BigDecimal(7.50));
		Product product4=new Product("220 Frascati 0,75l", ProductCategory.Alkohlische_Getränke, "9,7% vol10,00 €/l0,750l", new BigDecimal(7.50));
		Product product3=new Product("218 Württemberger Trollinger-Lemberger 1l", ProductCategory.Alkohlische_Getränke, "5,0% vol9,50 €/l1,000l", new BigDecimal(9.50));
		Product product2=new Product("222 Ficken Schnaps 0,75l", ProductCategory.Alkohlische_Getränke, "15,0% vol21,33 €/l0,750l", new BigDecimal(18.00));
				
		// Alkohalfreie Getränke
		
		Product product17=new Product("223 Coca Cola 1,0l", ProductCategory.Alkohalfrei_Getränke, "Enthält Koffein (10,0 mg/100 ml)inkl. Pfand (0,25 €)3,15 €/l1,000l", new BigDecimal(3.15));
		Product product18=new Product("223 Coca Cola light 1,0l", ProductCategory.Alkohalfrei_Getränke, "Enthält Koffein (12,0 mg/100 ml)inkl. Pfand (0,25 €)3,15 €/l1,000l", new BigDecimal(3.15));
		Product product19=new Product("223 Fanta 1,0l ", ProductCategory.Alkohalfrei_Getränke, "inkl. Pfand (0,25 €)3,15 €/l1,000l", new BigDecimal(3.15));
		Product product20=new Product("223 Sprite 1,0l", ProductCategory.Alkohalfrei_Getränke, "inkl. Pfand (0,25 €)3,15 €/l1,000l", new BigDecimal(3.15));
		Product product21=new Product("223 Mezzo Mix 1,0l", ProductCategory.Alkohalfrei_Getränke, "Enthält Koffein (6,0 mg/100 ml)inkl. Pfand (0,25 €)2,85 €/l1,000l", new BigDecimal(3.15));
		Product product22=new Product("224 Mineralwasser Medium 1,0l ", ProductCategory.Alkohalfrei_Getränke, "inkl. Pfand (0,25 €)2,25 €/l1,000l", new BigDecimal(2.25));
		Product product23=new Product("224 Mineralwasser Still 1,0l ", ProductCategory.Alkohalfrei_Getränke, "inkl. Pfand (0,25 €)2,75 €/l1,000l", new BigDecimal(2.75));
		Product product24=new Product("224A Krumbach Birne-Kräuter 1,0l", ProductCategory.Alkohalfrei_Getränke, "inkl. Pfand (0,25 €)2,75 €/l1,000l", new BigDecimal(2.75));
		Product product25=new Product("225 Orangensaft 1,0l ", ProductCategory.Alkohalfrei_Getränke, "inkl. Pfand (0,25 €)3,25 €/l1,000l", new BigDecimal(3.25));
		Product product26=new Product("225 Apfelsaft 1,0l", ProductCategory.Alkohalfrei_Getränke, "inkl. Pfand (0,25 €)3,25 €/l1,000l", new BigDecimal(3.25));
		Product product27=new Product("226 Eistee 1,5l", ProductCategory.Alkohalfrei_Getränke, "Enthält Koffein (25,0 mg/100 ml)inkl. Pfand (0,25 €)1,92 €/l1,500l", new BigDecimal(2.75));
		Product product28=new Product("227 Red Bull 0,33l", ProductCategory.Alkohalfrei_Getränke, "Enthält Koffein (32,0 mg/100 ml)inkl. Pfand (0,25 €)7,83 €/l0,330l", new BigDecimal(2.75));

	  // Ben & Jerrys
		Product product28Star=new Product("229B Ben & Jerry's Cookie Dough 100ml", ProductCategory.BenAndJerrys, "", new BigDecimal(3.60));
		Product product29=new Product("229C Ben & Jerry's Cookie Dough 500ml ", ProductCategory.BenAndJerrys, "", new BigDecimal(9.50));
			// Dessert
		Product product30 = new Product("228 Spaghetti Eis", ProductCategory.Dessert,"", new BigDecimal(2.50));
		Product product31 = new Product("230 Tiramisu", ProductCategory.Dessert,"", new BigDecimal(3.60));
		Product product32 = new Product("229A Langnese Eis", ProductCategory.Dessert,"", new BigDecimal(2.80));
		Product product159 = new Product("231 Ganze Zitrone gefüllt mit Zitroneneis", ProductCategory.Dessert,"", new BigDecimal(3.50));
		Product product160 = new Product("232 Ganze Orange gefüllt mit Orangeneis", ProductCategory.Dessert,"", new BigDecimal(3.50));
		Product product161 = new Product("233 Halbe kokosnuss gefüllt mit Kokoseis", ProductCategory.Dessert,"", new BigDecimal(4.00));
		Product product162 = new Product("234 Ritter Sport,Milka 100g,(verschiedene  Sorten)", ProductCategory.Dessert,"", new BigDecimal(1.80));
			
		
		
		// Pide
		Product product33 = new Product("515 Pide mit Käse,Ei", ProductCategory.Pide,"", new BigDecimal(5.50));
		Product product34 = new Product("516 Pide mit Hackfleisch,Ei ", ProductCategory.Pide,"", new BigDecimal(6.00));
		Product product35 = new Product("517 Pide mit Sucuk,Knoblauchwurst,Ei", ProductCategory.Pide,"", new BigDecimal(7.00));
		Product product36 = new Product("518 Pide mit Drehhackfleischspieß,Käse", ProductCategory.Pide,"", new BigDecimal(7.00));
		
		
		
		// Vegatarische Döner
		Product product37= new Product("513 Falafel", ProductCategory.Vegatarische_Döner, "Wahl aus: mit Cocktailsauce, mit Joghurtsauce oder ohne Sauce.",  new BigDecimal(5.00));

		product37.getProductOptions().add(productOpton1);
		product37.getProductOptions().add(productOpton2);
		product37.getProductOptions().add(productOpton3);
		Product product38= new Product("514 Falafel Yufka Dürüm", ProductCategory.Vegatarische_Döner, "Wahl aus: mit Cocktailsauce, mit Joghurtsauce oder ohne Sauce.",  new BigDecimal(5.50));
		product38.getProductOptions().add(productOpton1);
		product38.getProductOptions().add(productOpton2);
		product38.getProductOptions().add(productOpton3);
		
		
		//Lahmacun
		
		Product product39= new Product("510 Lahmacun", ProductCategory.Lahmacun, "Wahl aus: mit Cocktailsauce, mit Joghurtsauce oder ohne Sauce.",  new BigDecimal(5.00));
		product39.getProductOptions().add(productOpton1);
		product39.getProductOptions().add(productOpton2);
		product39.getProductOptions().add(productOpton3);
		Product product40= new Product("511 Lahmacun mit Weichkäse", ProductCategory.Lahmacun, "Wahl aus: mit Cocktailsauce, mit Joghurtsauce oder ohne Sauce.",  new BigDecimal(5.50));
		product40.getProductOptions().add(productOpton1);
		product40.getProductOptions().add(productOpton2);
		product40.getProductOptions().add(productOpton3);
		Product product41= new Product("512 Lahmacun mit Kebab", ProductCategory.Lahmacun, "Wahl aus: mit Cocktailsauce, mit Joghurtsauce oder ohne Sauce.",  new BigDecimal(6.00));
		product41.getProductOptions().add(productOpton1);
		product41.getProductOptions().add(productOpton2);
		product41.getProductOptions().add(productOpton3);
		
		
		// Döner kebab
		
		Product product42=new Product("505 Döner Kebab",ProductCategory.Döner_kebab,"Drehhackfleischspieß im Fladenbrot mit Salat und Sauce. \n Wahl aus: mit Cocktailsauce, mit Joghurtsauce oder ohne Sauce.",new BigDecimal(5));
		product42.getProductOptions().add(productOpton1);
		product42.getProductOptions().add(productOpton2);
		product42.getProductOptions().add(productOpton3);
		Product product43=new Product("506 Döner Kebab mit Weichkäse",ProductCategory.Döner_kebab,"Drehhackfleischspieß im Fladenbrot mitWeichkäse, Salat und Sauce. \n Wahl aus: mit Cocktailsauce, mit Joghurtsauce oder ohne Sauce.",new BigDecimal(5.50));
		product43.getProductOptions().add(productOpton1);
		product43.getProductOptions().add(productOpton2);
		product43.getProductOptions().add(productOpton3);
		Product product44=new Product("507 Döner Box mit Pommes",ProductCategory.Döner_kebab,"mit Pommes frites, Drehhackfleischspieß und Sauce. \n Wahl aus: mit Cocktailsauce, mit Joghurtsauce oder ohne Sauce.",new BigDecimal(5.00));
		product44.getProductOptions().add(productOpton1);
		product44.getProductOptions().add(productOpton2);
		product44.getProductOptions().add(productOpton3);
		Product product45=new Product("508 Döner Box mit Salat ",ProductCategory.Döner_kebab,"und Drehhackfleischspieß",new BigDecimal(5.00));
		Product product46=new Product("509 Yufka Dürüm",ProductCategory.Döner_kebab,"mit Drehhackfleischspieß, Salat und Sauce. \n Wahl aus: mit Cocktailsauce, mit Joghurtsauce oder ohne Sauce.",new BigDecimal(5.50));
		product46.getProductOptions().add(productOpton1);
		product46.getProductOptions().add(productOpton2);
		product46.getProductOptions().add(productOpton3);
		
		
		// Rösti
		
		Product product47 = new Product("501 Rösti mit Zwiebeln und Spiegelei,mit Käse überbacken", ProductCategory.Rösti, "", new BigDecimal(8.50));
		product47.getProductAdditions().addAll(röstiAdditionsOnly);
		Product product48 = new Product("502 Rösti mit Schinken und Zwiebeln,mit Käse überbacken", ProductCategory.Rösti, "", new BigDecimal(8.50));
		product48.getProductAdditions().addAll(röstiAdditionsOnly);
		Product product49 = new Product("503 Rösti mit Spinat und Schafskäse,mit Käse überbacken", ProductCategory.Rösti, "", new BigDecimal(8.50));
		product49.getProductAdditions().addAll(röstiAdditionsOnly);
		Product product50 = new Product("504 Rösti mit Schinken und Champignons,mit Käse überbacken", ProductCategory.Rösti, "", new BigDecimal(8.50));
		product50.getProductAdditions().addAll(röstiAdditionsOnly);
		
		
		// Internationalw Gerichte
		Product product51 = new Product("174 Pommes frites",ProductCategory.International_Gerichte,"mit Ketchup",new BigDecimal(3.30));
		Product product52 = new Product("175 Frühlingsrollen (8 Stück)",ProductCategory.International_Gerichte,"mit Chilisauce",new BigDecimal(3.50));
		Product product53 = new Product("176 Chicken Wings ",ProductCategory.International_Gerichte,"mit Pommes frites und einer Sauce nach Wahl. \n Wahl aus: mit Chilisauce, mit Currysauce oder ohne Sauce.",new BigDecimal(6.70));
		product53.getProductOptions().add(productOpton7);
		product53.getProductOptions().add(productOpton8);
		product53.getProductOptions().add(productOpton9);
		Product product54 = new Product("177 Chicken Nuggets ",ProductCategory.International_Gerichte,"mit Pommes frites und einer Sauce nach Wahl. \n Wahl aus: mit Chilisauce, mit Currysauce oder ohne Sauce.",new BigDecimal(5.70 ));
		product54.getProductOptions().add(productOpton7);
		product54.getProductOptions().add(productOpton8);
		product54.getProductOptions().add(productOpton9);
		Product product55 = new Product("178 Wiener Schnitzel ",ProductCategory.International_Gerichte,"mit einer Beilage nach Wahl und Salat. \n Wahl aus: mit Pommes frites, mit Spätzle oder ohne Beilage.",new BigDecimal(9.00));
		product55.getProductOptions().add(productOpton4);
		product55.getProductOptions().add(productOpton5);
		product55.getProductOptions().add(productOpton6);
		Product product56 = new Product("179 Frische Champignons ",ProductCategory.International_Gerichte,"mit Sahnesauce und Käse",new BigDecimal(8.90));
		Product product57 = new Product("180A Kartoffelauflauf mit Tomaten und Käse-Sahnesauce",ProductCategory.International_Gerichte,"",new BigDecimal(8.90));
		Product product58 = new Product("180B Kartoffelauflauf mit Spinat, Mozzarella, Tomatensauce",ProductCategory.International_Gerichte,"und mit Käse überbacken",new BigDecimal(8.90));
		Product product59 = new Product("181 Cevapcici (10 Stück)",ProductCategory.International_Gerichte,"mit Ajvar, Pommes frites und Salat",new BigDecimal(9.90));
		Product product60 = new Product("182 Rahmschnitzel (Hähnchen)",ProductCategory.International_Gerichte,"mit einer Beilage nach Wahl und Salat. \n Wahl aus: mit Pommes frites, mit Spätzle oder ohne Beilage.",new BigDecimal(9.90));
		product60.getProductOptions().add(productOpton4);
		product60.getProductOptions().add(productOpton5);
		product60.getProductOptions().add(productOpton6);
		
		Product product61 = new Product("183 Jägerschnitzel ",ProductCategory.International_Gerichte,"mit einer Beilage nach Wahl und Salat.\n Wahl aus: mit Pommes frites, mit Spätzle oder ohne Beilage.",new BigDecimal(9.90));
		
		product61.getProductOptions().add(productOpton4);
		product61.getProductOptions().add(productOpton5);
		product61.getProductOptions().add(productOpton6);
		Product product62 = new Product("184 Zigeunerschnitzel ",ProductCategory.International_Gerichte,"mit einer Beilage nach Wahl und Salat. \n Wahl aus: mit Pommes frites, mit Spätzle oder ohne Beilage.",new BigDecimal(9.90));
		product62.getProductOptions().add(productOpton4);
		product62.getProductOptions().add(productOpton5);
		product62.getProductOptions().add(productOpton6);
		Product product63 = new Product("Paniertes Seelachsfilet",ProductCategory.International_Gerichte,"mit Pommes frites, Remoulade und Salat",new BigDecimal(9.90));
		Product product64 = new Product("186 Hähnchen Cordon Bleu",ProductCategory.International_Gerichte,"mit einer Beilage nach Wahl und Salat. \n Wahl aus: mit Pommes frites, mit Spätzle oder ohne Beilage.",new BigDecimal(9.90));
		product64.getProductOptions().add(productOpton4);
		product64.getProductOptions().add(productOpton5);
		product64.getProductOptions().add(productOpton6);
		Product product65 = new Product("187 Gebackene Calamaris",ProductCategory.International_Gerichte,"mit Pommes frites, Remoulade und Salat",new BigDecimal(9.90));
		Product product66 = new Product("188B Käsespätzle ",ProductCategory.International_Gerichte,"mit Salat",new BigDecimal(8.50));
		Product product67 = new Product("188C Hawaii-Toast",ProductCategory.International_Gerichte,"mit Schinken, Ananas und mit Käse überbacken",new BigDecimal(4.00));
		Product product68 = new Product("188D American-Toast",ProductCategory.International_Gerichte,"mit Schinken, Salami und mit Käse überbacken",new BigDecimal(4.00));
		Product product69 = new Product("188E La Strada Toast",ProductCategory.International_Gerichte,"mit Salami, Schinken, Käse, Zwiebeln, Salat, Remoulade und mit Käse überbacken",new BigDecimal(5.00));
	
	// Gyros Spezialitäten
		
		Product product70 = new Product("141 La Strada Spezial Gyrosfleisch",ProductCategory.Gyros_Spezialitäten,"Gyrosfleisch mit Kartoffeln, Krabben, Rahmsauce und Kräuterbrot",new BigDecimal(9.50));
		Product product71 = new Product("142 Gyros Teller",ProductCategory.Gyros_Spezialitäten,"mit einer Beilage nach Wahl, Tzatziki und Salat. \n Wahl aus: mit Pommes frites, mit Reis oder ohne Beilage.",new BigDecimal(9.50));
		product71.getProductOptions().add(productOpton4);
		product71.getProductOptions().add(productOpton6);
		product71.getProductOptions().add(productOpton10);
		
		Product product72 = new Product("143 Gyros überbacken mit Pommes frites, Tzatziki und Salat",ProductCategory.Gyros_Spezialitäten,"",new BigDecimal(9.50));
		Product product73 = new Product("144 Gyros überbacken mit Tomaten, Paprika, Zwiebeln",ProductCategory.Gyros_Spezialitäten,"Pommes frites und Salat\n Wahl aus: mit Sahnesauce.",new BigDecimal(9.50));
			
			//Indische Gerichte
			
			Product product74 = new Product("167 Saag Panir ",ProductCategory.Indische_Gerichte,"Spinat mit Käse \n Wahl aus: mit Fladenbrot.",new BigDecimal(10.0));
			product74.getProductAdditions().add(pa2);
			Product product75 = new Product("168 Bharta",ProductCategory.Indische_Gerichte,"mit gegrillten Auberginen, Zwiebeln und Tomaten. \n Wahl aus: mit Fladenbrot.",new BigDecimal(10.0));
			product75.getProductAdditions().add(pa2);
			Product product76 = new Product("169 Murgh-Kari",ProductCategory.Indische_Gerichte,"Hähnchenbrustfilet-Curry nach indischer Art. \n Wahl aus: mit Fladenbrot.",new BigDecimal(10.0));
			product76.getProductAdditions().add(pa2);
			Product product77 = new Product("170 Murgh-Sagwala",ProductCategory.Indische_Gerichte,"Hähnchenbrustfilet mit Spinat nach indischer Art. \n Wahl aus: mit Fladenbrot.",new BigDecimal(10.0));
			product77.getProductAdditions().add(pa2);
			Product product78 = new Product("171 Murgh-Badami ",ProductCategory.Indische_Gerichte,"mit Hähnchenbrustfilet, milder Kormasauce, Mandeln und Sahne. \n Wahl aus: mit Fladenbrot.",new BigDecimal(10.0));
			product78.getProductAdditions().add(pa2);
			Product product79 = new Product("172 Gemüse Biryani",ProductCategory.Indische_Gerichte,"mit verschiedenem Gemüse zubereitet nach indischer Art. \n Wahl aus: mit Fladenbrot.",new BigDecimal(10.0));
			product79.getProductAdditions().add(pa2);
			Product product80 = new Product("173 Chicken Biryani",ProductCategory.Indische_Gerichte,"Reis zubereitet mit Hähnchenfleisch, Rosinen und Mandeln nach indischer Art. \n Wahl aus: mit Fladenbrot.",new BigDecimal(10.0));
			product80.getProductAdditions().add(pa2);
			Product product80A = new Product("173A Dal Makhani Masala",ProductCategory.Indische_Gerichte,"Indisches Linsengereicht mit Reis \n Wahl aus: mit Fladenbrot.",new BigDecimal(10.0));
			product80.getProductAdditions().add(pa2);
			
			
			// Pasta al Forno
			
			Product product81= new Product("161 Rigatoni al Forno (vegetarisch)",ProductCategory.Pasta_al_Forno,"",new BigDecimal(8.50));
			Product product82= new Product("162 Rigatoni al Forno Bolognese",ProductCategory.Pasta_al_Forno,"",new BigDecimal(8.50));
			Product product83= new Product("163 Tortellini al Forno Bolognese",ProductCategory.Pasta_al_Forno,"",new BigDecimal(8.50));
			Product product84= new Product("164 Lasagne Bolognese ",ProductCategory.Pasta_al_Forno,"",new BigDecimal(8.50));
			Product product85= new Product("164 Lasagne (vegetarisch) ",ProductCategory.Pasta_al_Forno,"",new BigDecimal(8.50));
			Product product86= new Product("165 La Strada Nudeln",ProductCategory.Pasta_al_Forno,"mit drei Nudelsorten, Champignons, Schinken, Bolognese und Sahne",new BigDecimal(8.50));
			Product product87= new Product("166 Extra Spezial Nudeln ",ProductCategory.Pasta_al_Forno,"mit Krabben, Schinken, Champignons, Zwiebeln, Sahne und drei Nudelsorten",new BigDecimal(8.50));
	
			// Pasta
			
			Product product88 = new Product("145 Pasta Napoli",ProductCategory.Pasta,"mit Tomatensauce und Parmesan. \n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product88.getProductOptions().add(productOpton11);
			product88.getProductOptions().add(productOpton12);
			product88.getProductOptions().add(productOpton13);
			product88.getProductOptions().add(productOpton14);
			product88.getProductAdditions().add(paa1);
			Product product89 = new Product("146 Pasta Bolognese ",ProductCategory.Pasta,"mit Rindfleisch. \n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product89.getProductOptions().add(productOpton11);
			product89.getProductOptions().add(productOpton12);
			product89.getProductOptions().add(productOpton13);
			product89.getProductOptions().add(productOpton14);
			product89.getProductAdditions().add(paa1);
			Product product90 = new Product("147 Pasta Carbonara",ProductCategory.Pasta,"mit Schinken, Sahne und Ei\n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product90.getProductOptions().add(productOpton11);
			product90.getProductOptions().add(productOpton12);
			product90.getProductOptions().add(productOpton13);
			product90.getProductOptions().add(productOpton14);
			product90.getProductAdditions().add(paa1);
			Product product91 = new Product("148 Pasta Alla Panna",ProductCategory.Pasta,"mit Schinken und Sahne\n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product91.getProductOptions().add(productOpton11);
			product91.getProductOptions().add(productOpton12);
			product91.getProductOptions().add(productOpton13);
			product91.getProductOptions().add(productOpton14);
			product91.getProductAdditions().add(paa1);
			Product product92 = new Product("149 Pasta Aglio e Olio",ProductCategory.Pasta,"mit frischen Tomaten und pikanter Knoblauchsauce\n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product92.getProductOptions().add(productOpton11);
			product92.getProductOptions().add(productOpton12);
			product92.getProductOptions().add(productOpton13);
			product92.getProductOptions().add(productOpton14);
			product92.getProductAdditions().add(paa1);
			Product product93 = new Product("150 Pasta Tonno ",ProductCategory.Pasta,"mit Thunfisch, Knoblauch und Tomatensauce\n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product93.getProductOptions().add(productOpton11);
			product93.getProductOptions().add(productOpton12);
			product93.getProductOptions().add(productOpton13);
			product93.getProductOptions().add(productOpton14);
			product93.getProductAdditions().add(paa1);
			Product product94 = new Product("151 Pasta Spinaci",ProductCategory.Pasta,"mit Spinat und Sahnesauce\n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product94.getProductOptions().add(productOpton11);
			product94.getProductOptions().add(productOpton12);
			product94.getProductOptions().add(productOpton13);
			product94.getProductOptions().add(productOpton14);
			product94.getProductAdditions().add(paa1);
			Product product95 = new Product("153 Pasta Quattro Formaggi ",ProductCategory.Pasta,"mit 4 verschiedenen Käsesorten\n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product95.getProductOptions().add(productOpton11);
			product95.getProductOptions().add(productOpton12);
			product95.getProductOptions().add(productOpton13);
			product95.getProductOptions().add(productOpton14);
			product95.getProductAdditions().add(paa1);
			Product product96 = new Product("154 Pasta Gorgonzola ",ProductCategory.Pasta,"mit Gorgonzola und Sahne.\n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product96.getProductOptions().add(productOpton11);
			product96.getProductOptions().add(productOpton12);
			product96.getProductOptions().add(productOpton13);
			product96.getProductOptions().add(productOpton14);
			product96.getProductAdditions().add(paa1);
			Product product97 = new Product("155 Pasta Frutti di Mare",ProductCategory.Pasta,"mit Meeresfrüchten, Knoblauch und Tomatensauce. \n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product97.getProductOptions().add(productOpton11);
			product97.getProductOptions().add(productOpton12);
			product97.getProductOptions().add(productOpton13);
			product97.getProductOptions().add(productOpton14);
			product97.getProductAdditions().add(paa1);
			Product product98 = new Product("156 Pasta Napoli Plus",ProductCategory.Pasta,"mit Tomatensauce, Sahne und Mozzarella. \n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product98.getProductOptions().add(productOpton11);
			product98.getProductOptions().add(productOpton12);
			product98.getProductOptions().add(productOpton13);
			product98.getProductOptions().add(productOpton14);
			product98.getProductAdditions().add(paa1);
			Product product99 = new Product("157 Pasta Spezial 1",ProductCategory.Pasta,"mit Schinken, Erbsen, Champignons, Käse, Sahne und Tomatensauce. \n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product99.getProductOptions().add(productOpton11);
			product99.getProductOptions().add(productOpton12);
			product99.getProductOptions().add(productOpton13);
			product99.getProductOptions().add(productOpton14);
			product99.getProductAdditions().add(paa1);
			Product product100 = new Product("158 Pasta Vegetarisch",ProductCategory.Pasta,"mit verschiedenem Gemüse, Sahne und Tomatensauce.\n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product100.getProductOptions().add(productOpton11);
			product100.getProductOptions().add(productOpton12);
			product100.getProductOptions().add(productOpton13);
			product100.getProductOptions().add(productOpton14);
			product100.getProductAdditions().add(paa1);
			Product product101= new Product("159 Pasta Spezial 2 ",ProductCategory.Pasta,"mit Rucola, Gorgonzola und Sahnesauce. \n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product101.getProductOptions().add(productOpton11);
			product101.getProductOptions().add(productOpton12);
			product101.getProductOptions().add(productOpton13);
			product101.getProductOptions().add(productOpton14);
			product101.getProductAdditions().add(paa1);
			Product product102 = new Product("160 Pasta Salmone",ProductCategory.Pasta,"mit Lachs und Sahnesauce. \n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product102.getProductOptions().add(productOpton11);
			product102.getProductOptions().add(productOpton12);
			product102.getProductOptions().add(productOpton13);
			product102.getProductOptions().add(productOpton14);
			product102.getProductAdditions().add(paa1);
			
			
			// Pizzabrot
			
			Product product103=new Product("138 Pizzabrot mit Kräutern ",ProductCategory.PizzabrotØ30,"",new BigDecimal(4.00));
			Product product104=new Product("139 Pizzabrot mit Tomatensauce",ProductCategory.PizzabrotØ30,"",new BigDecimal(4.00));
			
			
			// Calzone
			Product product105=new Product("135 Calzone",ProductCategory.Calzone,"mit Putenfleisch, Käse, Paprika und Champignons.\n Wahl aus: Klein oder Groß.",null);
			product105.getProductOptions().add(productOpton17);
			product105.getProductOptions().add(productOpton18);
			product105.getProductAdditions().addAll(calzoneAdditionsOnly);
			Product product106=new Product("136 Calzone Gyros",ProductCategory.Calzone,"mit Gyrosfleisch, Schafskäse, Tomatenscheiben, Zwiebeln und Tzatziki.\n Wahl aus: Klein oder Groß.",null);
			product106.getProductOptions().add(productOpton17);
			product106.getProductOptions().add(productOpton18);
			product106.getProductAdditions().addAll(calzoneAdditionsOnly);
			Product product107=new Product("137 Pizza La Strada Spezial Calzone",ProductCategory.Calzone,"mit Gyrosfleisch, Champignons, Zwiebeln, Hackfleisch, Schinken und Tzatziki.\n Wahl aus: Klein oder Groß.",null);
			product107.getProductOptions().add(productOpton17);
			product107.getProductOptions().add(productOpton18);
			product107.getProductAdditions().addAll(calzoneAdditionsOnly);
			
			
			// Vegetarische Pizza
			
			Product product108= new Product("130 Pizza Tomatenscheiben-Zwiebeln-Champignons-frische Paprika",ProductCategory.Vegatarische_Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product108.setProductAdditions(pizzaAdditionsOnly);
			product108.getProductOptions().add(pizza790);
			product108.getProductOptions().add(pizza900);
			product108.getProductOptions().add(pizza1850);
			product108.getProductOptions().add(pizza2350);
			Product product109= new Product("131 Pizza Artischocken-Paprika-Zwiebeln-Champignons-Oliven-Peperoni ",ProductCategory.Vegatarische_Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product109.setProductAdditions(pizzaAdditionsOnly);
			product109.getProductOptions().add(pizza790);
			product109.getProductOptions().add(pizza900);
			product109.getProductOptions().add(pizza1850);
			product109.getProductOptions().add(pizza2350);
			Product product110= new Product("132 Pizza Mozzarella mit Tomatenscheiben ",ProductCategory.Vegatarische_Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product110.setProductAdditions(pizzaAdditionsOnly);
			product110.getProductOptions().add(pizza790);
			product110.getProductOptions().add(pizza900);
			product110.getProductOptions().add(pizza1850);
			product110.getProductOptions().add(pizza2350);
			Product product111= new Product("133 Pizza Mozzarella mit Spinat ",ProductCategory.Vegatarische_Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product111.getProductOptions().add(pizza790);
			product111.getProductOptions().add(pizza900);
			product111.getProductOptions().add(pizza1850);
			product111.getProductOptions().add(pizza2350);
			product111.setProductAdditions(pizzaAdditionsOnly);
			Product product112= new Product("134 Pizza Artischocken-Ananas-Champignons-Zwiebeln-Peperoni-Paprika ",ProductCategory.Vegatarische_Pizza,"und Knobaluch \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product112.getProductOptions().add(pizza790);
			product112.getProductOptions().add(pizza900);
			product112.getProductOptions().add(pizza1850);
			product112.getProductOptions().add(pizza2350);
			product112.setProductAdditions(pizzaAdditionsOnly);
			
			
			// Pizza
			Product product113= new Product("100 Pizza Margherita",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product113.setProductAdditions(pizzaAdditionsOnly);
			product113.getProductOptions().add(pizza570);
			product113.getProductOptions().add(pizza670);
			product113.getProductOptions().add(pizza1570);
			product113.getProductOptions().add(pizza1900);
						
			Product product114= new Product("101 Pizza Rinder-Salami ",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product114.setProductAdditions(pizzaAdditionsOnly);
			product114.getProductOptions().add(pizza640);
			product114.getProductOptions().add(pizza790Second);
			product114.getProductOptions().add(pizza1600);
			product114.getProductOptions().add(pizza1990);
			
			Product product115= new Product("102 Pizza Geflügelschinken",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product115.setProductAdditions(pizzaAdditionsOnly);
			product115.getProductOptions().add(pizza640);
			product115.getProductOptions().add(pizza790Second);
			product115.getProductOptions().add(pizza1600);
			product115.getProductOptions().add(pizza1990);
			Product product116= new Product("103 Pizza türkische Salami",ProductCategory.Pizza,"mit Sucuk \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product116.setProductAdditions(pizzaAdditionsOnly);
			product116.getProductOptions().add(pizza640);
			product116.getProductOptions().add(pizza790Second);
			product116.getProductOptions().add(pizza1600);
			product116.getProductOptions().add(pizza1990);
			Product product117= new Product("104 Pizza Champignons ",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product117.setProductAdditions(pizzaAdditionsOnly);
			product117.getProductOptions().add(pizza640);
			product117.getProductOptions().add(pizza790Second);
			product117.getProductOptions().add(pizza1600);
			product117.getProductOptions().add(pizza1990);
			Product product118= new Product("105 Pizza Thunfisch-Zwiebeln",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product118.setProductAdditions(pizzaAdditionsOnly);
			product118.getProductOptions().add(pizza690);
			product118.getProductOptions().add(pizza840);
			product118.getProductOptions().add(pizza1750);
			product118.getProductOptions().add(pizza2100);
			Product product119= new Product("106 Pizza Schinken-Salami",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product119.setProductAdditions(pizzaAdditionsOnly);
			product119.getProductOptions().add(pizza690);
			product119.getProductOptions().add(pizza840);
			product119.getProductOptions().add(pizza1750);
			product119.getProductOptions().add(pizza2100);
			Product product120= new Product("107 Pizza Schinken-Champignons ",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product120.setProductAdditions(pizzaAdditionsOnly);
			product120.getProductOptions().add(pizza690);
			product120.getProductOptions().add(pizza840);
			product120.getProductOptions().add(pizza1750);
			product120.getProductOptions().add(pizza2100);
			Product product121= new Product("108 Pizza Hawaii",ProductCategory.Pizza,"mit Schinken und Ananas \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product121.setProductAdditions(pizzaAdditionsOnly);
			product121.getProductOptions().add(pizza690);
			product121.getProductOptions().add(pizza840);
			product121.getProductOptions().add(pizza1750);
			product121.getProductOptions().add(pizza2100);
			Product product122= new Product("109 Pizza Salami-Hackfleisch-Champignons",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product122.setProductAdditions(pizzaAdditionsOnly);
			product122.getProductOptions().add(pizza690);
			product122.getProductOptions().add(pizza840);
			product122.getProductOptions().add(pizza1750);
			product122.getProductOptions().add(pizza2100);
			Product product123= new Product("110 Pizza Salami-Schinken-Artischocken-Zwiebeln ",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product123.setProductAdditions(pizzaAdditionsOnly);
			product123.getProductOptions().add(pizza690);
			product123.getProductOptions().add(pizza840);
			product123.getProductOptions().add(pizza1750);
			product123.getProductOptions().add(pizza2100);
			Product product124= new Product("112 Pizza Salami-Schinken-Champignons ",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product124.setProductAdditions(pizzaAdditionsOnly);
			product124.getProductOptions().add(pizza690);
			product124.getProductOptions().add(pizza840);
			product124.getProductOptions().add(pizza1750);
			product124.getProductOptions().add(pizza2100);
			Product product125= new Product("113 Pizza Schinken-Champignons-Artischocken-Oliven",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product125.setProductAdditions(pizzaAdditionsOnly);
			product125.getProductOptions().add(pizza690);
			product125.getProductOptions().add(pizza840);
			product125.getProductOptions().add(pizza1750);
			product125.getProductOptions().add(pizza2100);
			Product product126= new Product("114 Pizza Creme fraiche ",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product126.setProductAdditions(pizzaAdditionsOnly);
			product126.getProductOptions().add(pizza690);
			product126.getProductOptions().add(pizza840);
			product126.getProductOptions().add(pizza1750);
			product126.getProductOptions().add(pizza2100);
			Product product127= new Product("115 Pizza Diavolo",ProductCategory.Pizza,"mit Salami, Zwiebeln, Peperoni und Chili, scharf \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product127.setProductAdditions(pizzaAdditionsOnly);
			product127.getProductOptions().add(pizza690);
			product127.getProductOptions().add(pizza840);
			product127.getProductOptions().add(pizza1750);
			product127.getProductOptions().add(pizza2100);
			Product product128= new Product("116 Pizza Sardellen-Mozzarella-Basilikum-Tomatenscheiben",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product128.setProductAdditions(pizzaAdditionsOnly);
			product128.getProductOptions().add(pizza790);
			product128.getProductOptions().add(pizza940);
			product128.getProductOptions().add(pizza1950);
			product128.getProductOptions().add(pizza2450);
			Product product129= new Product("117 Pizza Vier Jahreszeiten",ProductCategory.Pizza,"mit Salami, Schinken, Paprika, Champignons und Ei \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product129.setProductAdditions(pizzaAdditionsOnly);
			product129.getProductOptions().add(pizza790);
			product129.getProductOptions().add(pizza940);
			product129.getProductOptions().add(pizza1950);
			product129.getProductOptions().add(pizza2450);
			Product product130= new Product("Pizza Meeresfrüchte ",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product130.setProductAdditions(pizzaAdditionsOnly);
			product130.getProductOptions().add(pizza790);
			product130.getProductOptions().add(pizza940);
			product130.getProductOptions().add(pizza1950);
			product130.getProductOptions().add(pizza2450);
			Product product131= new Product("118 Pizza Bolognese",ProductCategory.Pizza,"mit Zwiebeln, Hackfleisch und scharfer Peperoni \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product131.setProductAdditions(pizzaAdditionsOnly);
			product131.getProductOptions().add(pizza790);
			product131.getProductOptions().add(pizza940);
			product131.getProductOptions().add(pizza1950);
			product131.getProductOptions().add(pizza2450);
			Product product132= new Product("120 Pizza Quattro Formaggi",ProductCategory.Pizza,"mit vier Käsesorten \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product132.setProductAdditions(pizzaAdditionsOnly);
			product132.getProductOptions().add(pizza790);
			product132.getProductOptions().add(pizza940);
			product132.getProductOptions().add(pizza1950);
			product132.getProductOptions().add(pizza2450);
			Product product133= new Product("121 Pizza La Strada ",ProductCategory.Pizza,"mit Schinken, Mais, Paprika, Champignons, Peperoni und Hackfleisch \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product133.setProductAdditions(pizzaAdditionsOnly);
			product133.getProductOptions().add(pizza790);
			product133.getProductOptions().add(pizza940);
			product133.getProductOptions().add(pizza1950);
			product133.getProductOptions().add(pizza2450);
			Product product134= new Product("122 Pizza Salami-Schinken-Champignons-Paprika-Hackfleisch-Zwiebeln-Peperoni",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product134.setProductAdditions(pizzaAdditionsOnly);
			product134.getProductOptions().add(pizza790);
			product134.getProductOptions().add(pizza940);
			product134.getProductOptions().add(pizza1950);
			product134.getProductOptions().add(pizza2450);
			Product product135= new Product("123 Grill Pizza ",ProductCategory.Pizza,"mit gegrilltem Hühnerfleisch, Champignons und Peperoni \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product135.setProductAdditions(pizzaAdditionsOnly);
			product135.getProductOptions().add(pizza790);
			product135.getProductOptions().add(pizza940);
			product135.getProductOptions().add(pizza1950);
			product135.getProductOptions().add(pizza2450);
			Product product136= new Product("124 Pizza Mexicana",ProductCategory.Pizza,"mit Bohnen, Oliven, Hackfleisch, Chili, Zwiebeln und Peperoni \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product136.setProductAdditions(pizzaAdditionsOnly);
			product136.getProductOptions().add(pizza790);
			product136.getProductOptions().add(pizza940);
			product136.getProductOptions().add(pizza1950);
			product136.getProductOptions().add(pizza2450);
			Product product137= new Product("125 Pizza Schinken-Gorgonzola-Rucola ",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product137.setProductAdditions(pizzaAdditionsOnly);
			product137.getProductOptions().add(pizza790);
			product137.getProductOptions().add(pizza940);
			product137.getProductOptions().add(pizza1950);
			product137.getProductOptions().add(pizza2450);
			Product product138= new Product("126 Pizza Spezial",ProductCategory.Pizza,"mit Hühnerfleisch, Champignons, Paprika, Zwiebeln und Curry \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product138.setProductAdditions(pizzaAdditionsOnly);
			product138.getProductOptions().add(pizza790);
			product138.getProductOptions().add(pizza940);
			product138.getProductOptions().add(pizza1950);
			product138.getProductOptions().add(pizza2450);
			Product product139= new Product("127 Pizza Orientale",ProductCategory.Pizza,"mit türkischer Salami, Schafskäse und roten Zwiebeln \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product139.setProductAdditions(pizzaAdditionsOnly);
			product139.getProductOptions().add(pizza790);
			product139.getProductOptions().add(pizza940);
			product139.getProductOptions().add(pizza1950);
			product139.getProductOptions().add(pizza2450);
			Product product140= new Product("128 Pizza Lachs",ProductCategory.Pizza,"mit Spinat, Knoblauch und Mozzarella \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product140.setProductAdditions(pizzaAdditionsOnly);
			product140.getProductOptions().add(pizza790);
			product140.getProductOptions().add(pizza940);
			product140.getProductOptions().add(pizza1950);
			product140.getProductOptions().add(pizza2450);
			Product product141= new Product("129 Pizza Gyros",ProductCategory.Pizza,"mit Mozzarella, Tomaten und Zwiebeln \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product141.setProductAdditions(pizzaAdditionsOnly);
			product141.getProductOptions().add(pizza790);
			product141.getProductOptions().add(pizza940);
			product141.getProductOptions().add(pizza1950);
			product141.getProductOptions().add(pizza2450);	
			// Salat
			
			Product product142= new Product("189 Gemischter Salat (klein)",ProductCategory.Salat,"Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(3.40));
			product142.getProductOptions().add(productOpton19);
			product142.getProductOptions().add(productOpton20);
			product142.getProductOptions().add(productOpton21);
			product142.getProductOptions().add(productOpton22);
			
			Product product143= new Product("190 Rucolasalat (klein)",ProductCategory.Salat,"mit Feta, frischen Tomaten und Olivenöl \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(5.50));
			product143.getProductOptions().add(productOpton19);
			product143.getProductOptions().add(productOpton20);
			product143.getProductOptions().add(productOpton21);
			product143.getProductOptions().add(productOpton22);
			
			Product product144= new Product("192 Tomatensalat (klein)",ProductCategory.Salat,"mit Zwiebeln \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(4.30));
			product144.getProductOptions().add(productOpton19);
			product144.getProductOptions().add(productOpton20);
			product144.getProductOptions().add(productOpton21);
			product144.getProductOptions().add(productOpton22);
			
			Product product145= new Product("193 Krabben-Cocktail Salat (klein)",ProductCategory.Salat,"Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(6.90));
			product145.getProductOptions().add(productOpton19);
			product145.getProductOptions().add(productOpton20);
			product145.getProductOptions().add(productOpton21);
			product145.getProductOptions().add(productOpton22);
			
			Product product146= new Product("194 Mozzarella-Teller (klein)",ProductCategory.Salat,"mit Tomaten und Zwiebeln \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(5.00));
			product146.getProductOptions().add(productOpton19);
			product146.getProductOptions().add(productOpton20);
			product146.getProductOptions().add(productOpton21);
			product146.getProductOptions().add(productOpton22);
			
			Product product147= new Product("195 Gemischter Salat",ProductCategory.Salat,"mit grünem Salat, Gurken, Tomaten, Karotten, Bohnen, Mais und milder Peperoni \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(4.90));
			product147.getProductOptions().add(productOpton19);
			product147.getProductOptions().add(productOpton20);
			product147.getProductOptions().add(productOpton21);
			product147.getProductOptions().add(productOpton22);
			
			Product product148= new Product("196 Salat Nizza",ProductCategory.Salat,"mit grünem Salat, Zwiebeln, Thunfisch, Oliven, Tomaten und Gurken \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(6.50));
			product148.getProductOptions().add(productOpton19);
			product148.getProductOptions().add(productOpton20);
			product148.getProductOptions().add(productOpton21);
			product148.getProductOptions().add(productOpton22);
			
			Product product149= new Product("197 Thunfischsalat",ProductCategory.Salat,"mit grünem Salat, Thunfisch, Oliven, Artischocken, Tomaten und Ei \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(7.50));
			product149.getProductOptions().add(productOpton19);
			product149.getProductOptions().add(productOpton20);
			product149.getProductOptions().add(productOpton21);
			product149.getProductOptions().add(productOpton22);
			
			Product product150= new Product("198 Italienischer Salat",ProductCategory.Salat,"mit grünem Salat, Tomaten, Gurken, Paprika, Schinken, Thunfisch, Käse, Ei und Oliven \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(7.50));
			product150.getProductOptions().add(productOpton19);
			product150.getProductOptions().add(productOpton20);
			product150.getProductOptions().add(productOpton21);
			product150.getProductOptions().add(productOpton22);
			
			Product product151= new Product("199 Mexikanischer Salat ",ProductCategory.Salat,"mit grünem Salat, Pute, Mais, Bohnen, frischer Paprika, Peperoni, Tomaten und Gurken \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(7.50));
			product151.getProductOptions().add(productOpton19);
			product151.getProductOptions().add(productOpton20);
			product151.getProductOptions().add(productOpton21);
			product151.getProductOptions().add(productOpton22);
			
			Product product152= new Product("200 Amerikanischer Salat",ProductCategory.Salat,"mit grünem Salat, gegrilltem Geflügelfleisch,Tomaten, Mais, Paprika, Karotten, Gurken und Ei \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(7.50));
			product152.getProductOptions().add(productOpton19);
			product152.getProductOptions().add(productOpton20);
			product152.getProductOptions().add(productOpton21);
			product152.getProductOptions().add(productOpton22);
			
			Product product153= new Product("201 Rösti Salat ",ProductCategory.Salat,"großer gemischter Salat mit Rösti und gegrilltem Geflügelfleisch \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(7.50));
			product153.getProductOptions().add(productOpton19);
			product153.getProductOptions().add(productOpton20);
			product153.getProductOptions().add(productOpton21);
			product153.getProductOptions().add(productOpton22);
			
			Product product154= new Product("202 Meeresfrüchtesalat",ProductCategory.Salat,"mit grünem Salat, Zitronenscheiben und Oliven \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(7.50));
			product154.getProductOptions().add(productOpton19);
			product154.getProductOptions().add(productOpton20);
			product154.getProductOptions().add(productOpton21);
			product154.getProductOptions().add(productOpton22);
			
			Product product155= new Product("203 La Strada Salat",ProductCategory.Salat,"mit grünem Salat, Schinken, Käse, Bohnen, Mais, Krabben, frischen Tomaten und Ei \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(7.50));
			product155.getProductOptions().add(productOpton19);
			product155.getProductOptions().add(productOpton20);
			product155.getProductOptions().add(productOpton21);
			product155.getProductOptions().add(productOpton22);
			
			
			// Indische Vorspeise
			
			Product product156= new Product("236 Samosa (2 Stück)",ProductCategory.Indische_Vorspeisen," frittierte Teigtaschen mit Kartoffeln und Erbsen\n Wahl aus: mit Fladenbrot.", new BigDecimal(4.50));
			product156.getProductAdditions().add(pa2);
			Product product157= new Product("237 Mix-Gemüse Pakora",ProductCategory.Indische_Vorspeisen," frittiert in Kichererbsenmehlteig\n Wahl aus: mit Fladenbrot.", new BigDecimal(5.00));
			product157.getProductAdditions().add(pa2);
			Product product158= new Product("238 Hähnchenfleisch Pakora",ProductCategory.Indische_Vorspeisen," frittiert in Kichererbsenmehlteig \n Wahl aus: mit Fladenbrot.", new BigDecimal(6.00));
			product158.getProductAdditions().add(pa2);
		
			
			
			this.productRepository.save(product2);
			this.productRepository.save(product3);
			this.productRepository.save(product4);
			this.productRepository.save(product5);
			this.productRepository.save(product7);
			this.productRepository.save(product8);
			this.productRepository.save(product9);
			this.productRepository.save(product10);
				this.productRepository.save(product11);
			this.productRepository.save(product12);
			this.productRepository.save(product13);
			this.productRepository.save(product14);
			this.productRepository.save(product15);
			this.productRepository.save(product16);
			this.productRepository.save(product17);
			this.productRepository.save(product18);
			this.productRepository.save(product19);
			this.productRepository.save(product20);
				this.productRepository.save(product21);
			this.productRepository.save(product22);
			this.productRepository.save(product23);
			this.productRepository.save(product24);
			this.productRepository.save(product25);
			this.productRepository.save(product26);
			this.productRepository.save(product27);
			this.productRepository.save(product28);
			this.productRepository.save(product28Star);
			this.productRepository.save(product29);
			this.productRepository.save(product30);
				this.productRepository.save(product31);
			this.productRepository.save(product159);
			this.productRepository.save(product160);
			this.productRepository.save(product161);
			this.productRepository.save(product162);
			this.productRepository.save(product32);
			
			this.productRepository.save(product33);
			this.productRepository.save(product34);
			this.productRepository.save(product35);
			this.productRepository.save(product36);
			this.productRepository.save(product37);
			this.productRepository.save(product38);
			this.productRepository.save(product39);
			this.productRepository.save(product40);
				this.productRepository.save(product41);
			this.productRepository.save(product42);
			this.productRepository.save(product43);
			this.productRepository.save(product44);
			this.productRepository.save(product45);
			this.productRepository.save(product46);
			this.productRepository.save(product47);
			this.productRepository.save(product48);
			this.productRepository.save(product49);
			this.productRepository.save(product50);
				this.productRepository.save(product51);
			this.productRepository.save(product52);
			this.productRepository.save(product53);
			this.productRepository.save(product54);
			this.productRepository.save(product55);
			this.productRepository.save(product56);
			this.productRepository.save(product57);
			this.productRepository.save(product58);
			this.productRepository.save(product59);
			this.productRepository.save(product60);
				this.productRepository.save(product61);
			this.productRepository.save(product62);
			this.productRepository.save(product63);
			this.productRepository.save(product64);
			this.productRepository.save(product65);
			this.productRepository.save(product66);
			this.productRepository.save(product67);
			this.productRepository.save(product68);
			this.productRepository.save(product69);
			this.productRepository.save(product70);
				this.productRepository.save(product71);
			this.productRepository.save(product72);
			this.productRepository.save(product73);
			this.productRepository.save(product74);
			this.productRepository.save(product75);
			this.productRepository.save(product76);
			this.productRepository.save(product77);
			this.productRepository.save(product78);
			this.productRepository.save(product79);
			this.productRepository.save(product80);
			this.productRepository.save(product80A);
				this.productRepository.save(product81);
			this.productRepository.save(product82);
			this.productRepository.save(product83);
			this.productRepository.save(product84);
			this.productRepository.save(product85);
			this.productRepository.save(product86);
			this.productRepository.save(product87);
			this.productRepository.save(product88);
			this.productRepository.save(product89);
			this.productRepository.save(product90);
				this.productRepository.save(product91);
			this.productRepository.save(product92);
			this.productRepository.save(product93);
			this.productRepository.save(product94);
			this.productRepository.save(product95);
			this.productRepository.save(product96);
			this.productRepository.save(product97);
			this.productRepository.save(product98);
			this.productRepository.save(product99);
			this.productRepository.save(product100);
				this.productRepository.save(product101);
			this.productRepository.save(product102);
			this.productRepository.save(product103);
			this.productRepository.save(product104);
			this.productRepository.save(product105);
			this.productRepository.save(product106);
			this.productRepository.save(product107);
			this.productRepository.save(product108);
			this.productRepository.save(product109);
			this.productRepository.save(product110);
				this.productRepository.save(product111);
			this.productRepository.save(product112);
			this.productRepository.save(product113);
			this.productRepository.save(product114);
			this.productRepository.save(product115);
			this.productRepository.save(product116);
			this.productRepository.save(product117);
			this.productRepository.save(product118);
			this.productRepository.save(product119);
			this.productRepository.save(product120);
				this.productRepository.save(product121);
			this.productRepository.save(product122);
			this.productRepository.save(product123);
			this.productRepository.save(product124);
			this.productRepository.save(product125);
			this.productRepository.save(product126);
			this.productRepository.save(product127);
			this.productRepository.save(product128);
			this.productRepository.save(product129);
			this.productRepository.save(product130);
				this.productRepository.save(product131);
			this.productRepository.save(product132);
			this.productRepository.save(product133);
			this.productRepository.save(product134);
			this.productRepository.save(product135);
			this.productRepository.save(product136);
			this.productRepository.save(product137);
			this.productRepository.save(product138);
			this.productRepository.save(product139);
			this.productRepository.save(product140);
				this.productRepository.save(product141);
			this.productRepository.save(product142);
			this.productRepository.save(product143);
			this.productRepository.save(product144);
			this.productRepository.save(product145);
			this.productRepository.save(product146);
			this.productRepository.save(product147);
			this.productRepository.save(product148);
			this.productRepository.save(product149);
			this.productRepository.save(product150);
				this.productRepository.save(product151);
			this.productRepository.save(product152);
			this.productRepository.save(product153);
			this.productRepository.save(product154);
			this.productRepository.save(product155);
			this.productRepository.save(product156);
			this.productRepository.save(product157);
			this.productRepository.save(product158);
//			
			
			
	}
	
	


}
