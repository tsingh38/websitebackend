package com.lastrada.website.lastrada.bootstrap;



import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.lastrada.website.lastrada.model.Product;
import com.lastrada.website.lastrada.model.ProductAddition;
import com.lastrada.website.lastrada.model.ProductCategory;
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
		//initProducts();
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
		ProductOption productOpton17=new ProductOption("klein, Ø26cm:", null, new BigDecimal(7.50), null, null, null);
		ProductOption productOpton18=new ProductOption("Groß, Ø30cm:", null, null, new BigDecimal(9.00), null, null);
		ProductOption productOpton19=new ProductOption("mit Cocktail -Dressing",new BigDecimal(0),null,null,null,null);
		ProductOption productOpton20=new ProductOption("mit Essig und öl",new BigDecimal(0),null,null,null,null);
		ProductOption productOpton21=new ProductOption("mit Joghurtsauce",new BigDecimal(0),null,null,null,null);
		ProductOption productOpton22=new ProductOption("ohne Dressing",new BigDecimal(0),null,null,null,null);
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
		ProductAddition pa3=new ProductAddition("Ananas", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa4=new ProductAddition("Artischocken", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa5=new ProductAddition("Broccoli",null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa6=new ProductAddition("Champignons", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa7=new ProductAddition("Ei", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa8=new ProductAddition("Gorgonzola", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(3.50), new BigDecimal(5.00));
		ProductAddition pa9=new ProductAddition("Gyrosfleisch", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa10=new ProductAddition("Hähnchenfleisch",null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa11=new ProductAddition("Käse,extra", null, new BigDecimal(1.00), new BigDecimal(1.00),new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa12=new ProductAddition("knoblauch", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa13=new ProductAddition("krabben", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(3.50), new BigDecimal(5.00));
		ProductAddition pa14=new ProductAddition("Lachs", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50), new BigDecimal(5.00));
		ProductAddition pa15=new ProductAddition("Mais", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa16=new ProductAddition("Meeresfrüchten", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(3.50), new BigDecimal(5.00));
		ProductAddition pa17=new ProductAddition("Mozzarella", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa18=new ProductAddition("Paprika", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa19=new ProductAddition("Peperoni", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa20=new ProductAddition("Salami", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa21=new ProductAddition("Sardellen", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa22=new ProductAddition("Schafskäse", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa23=new ProductAddition("Schinken", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa24=new ProductAddition("Spinat", null, new BigDecimal(1.00), new BigDecimal(1.00),new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa25=new ProductAddition("Thunfisch", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa26=new ProductAddition("Tomaten", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa27=new ProductAddition("Tzatziki", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa28=new ProductAddition("Zwiebeln", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa29=new ProductAddition("käserand", null, new BigDecimal(2.00), new BigDecimal(2.50), new BigDecimal(1.50), new BigDecimal(1.50));

this.productAdditionRepository.save(pa1);
this.productAdditionRepository.save(pa2);
this.productAdditionRepository.save(pa3);
this.productAdditionRepository.save(pa4);
this.productAdditionRepository.save(pa5);
this.productAdditionRepository.save(pa6);
this.productAdditionRepository.save(pa7);
this.productAdditionRepository.save(pa8);
this.productAdditionRepository.save(pa9);
this.productAdditionRepository.save(pa10);
this.productAdditionRepository.save(pa11);
this.productAdditionRepository.save(pa12);
this.productAdditionRepository.save(pa13);
this.productAdditionRepository.save(pa14);
this.productAdditionRepository.save(pa15);
this.productAdditionRepository.save(pa16);
this.productAdditionRepository.save(pa17);
this.productAdditionRepository.save(pa18);
this.productAdditionRepository.save(pa19);
this.productAdditionRepository.save(pa20);
this.productAdditionRepository.save(pa21);
this.productAdditionRepository.save(pa22);
this.productAdditionRepository.save(pa23);
this.productAdditionRepository.save(pa24);
this.productAdditionRepository.save(pa25);
this.productAdditionRepository.save(pa26);
this.productAdditionRepository.save(pa27);
this.productAdditionRepository.save(pa28);
this.productAdditionRepository.save(pa29);

		
		// Alkohlische Getränke
		Product product16=new Product("Beck's Pils 0,5l", ProductCategory.Alkohlische_Getränke, "5,0% volinkl. Pfand (0,08 €)5,08 €/l0,500l", new BigDecimal(2.58));
		Product product15=new Product("Farny Kristallweizen 0,5l ", ProductCategory.Alkohlische_Getränke, "38,0% volinkl. Pfand (0,08 €)5,08 €/l0,500l", new BigDecimal(2.58));
		Product product14=new Product("Leibinger Export 0,5l", ProductCategory.Alkohlische_Getränke, "9,7% volinkl. Pfand (0,08 €)5,08 €/l0,500l", new BigDecimal(2.58));
		Product product13=new Product("Meckatzer 0,5l", ProductCategory.Alkohlische_Getränke, ",7% volinkl. Pfand (0,08 €)5,08 €/l0,500l", new BigDecimal(2.58));
		Product product12=new Product("Jim Beam 0,7l", ProductCategory.Alkohlische_Getränke, "27,86 €/l0,700l", new BigDecimal(19.50));
		Product product11=new Product("Jack Daniel's 0,7l", ProductCategory.Alkohlische_Getränke, "40,0% vol35,71 €/l0,700l", new BigDecimal(25.00));
		Product product10=new Product("Jack Daniels mit Coca Cola 0,33l ", ProductCategory.Alkohlische_Getränke, "Enthält Koffein (9,6 mg/100 ml)inkl. Pfand (0,25 €)14,64 €/l0,330l", new BigDecimal(5.00));
		Product product9=new Product("Wodka 0,7l", ProductCategory.Alkohlische_Getränke, "35,0% vol21,43 €/l0,700l", new BigDecimal(15.00));
		Product product8=new Product("Lambrusco 0,75l", ProductCategory.Alkohlische_Getränke, "9,7% vol 8,67 €/l0,750l", new BigDecimal(6.50));
		Product product7=new Product("Chianti 0,75l", ProductCategory.Alkohlische_Getränke, "10,0% vol10,00 €/l0,750l", new BigDecimal(7.50));
		Product product6=new Product("Bardolino 0,75l ", ProductCategory.Alkohlische_Getränke, "10,0% vol11,33 €/l0,750l", new BigDecimal(8.50));
		Product product5=new Product("Soave 0,75l ", ProductCategory.Alkohlische_Getränke, "9,7% vol10,00 €/l0,750l", new BigDecimal(7.50));
		Product product4=new Product("Frascati 0,75l", ProductCategory.Alkohlische_Getränke, "9,7% vol10,00 €/l0,750l", new BigDecimal(7.50));
		Product product3=new Product("Asti Cinzano 0,75l ", ProductCategory.Alkohlische_Getränke, "5,0% vol13,33 €/l0,750l", new BigDecimal(10.00));
		Product product2=new Product("Ficken Schnaps 0,75l", ProductCategory.Alkohlische_Getränke, "5,0% vol21,33 €/l0,750l", new BigDecimal(16.00));
		Product product1=new Product("Likör 0,75l", ProductCategory.Alkohlische_Getränke, "8,7% vol21,33 €/l0,750l", new BigDecimal(16.00));
		
		
		// Alkohalfreie Getränke
		
		Product product17=new Product("Coca Cola 1,0l", ProductCategory.Alkohalfrei_Getränke, "Enthält Koffein (10,0 mg/100 ml)inkl. Pfand (0,15 €)2,75 €/l1,000l", new BigDecimal(2.75));
		Product product18=new Product("Coca Cola light 1,0l", ProductCategory.Alkohalfrei_Getränke, "Enthält Koffein (12,0 mg/100 ml)inkl. Pfand (0,15 €)2,75 €/l1,000l", new BigDecimal(2.75));
		Product product19=new Product("Fanta 1,0l ", ProductCategory.Alkohalfrei_Getränke, "inkl. Pfand (0,15 €)2,75 €/l1,000l", new BigDecimal(2.75));
		Product product20=new Product("Sprite 1,0l", ProductCategory.Alkohalfrei_Getränke, "inkl. Pfand (0,15 €)2,75 €/l1,000l", new BigDecimal(2.75));
		Product product21=new Product("Mezzo Mix 1,0l", ProductCategory.Alkohalfrei_Getränke, "Enthält Koffein (6,0 mg/100 ml)inkl. Pfand (0,15 €)2,75 €/l1,000l", new BigDecimal(2.75));
		Product product22=new Product("Mineralwasser Medium 1,0l ", ProductCategory.Alkohalfrei_Getränke, "inkl. Pfand (0,15 €)2,15 €/l1,000l", new BigDecimal(2.15));
		Product product23=new Product("Mineralwasser Still 1,0l ", ProductCategory.Alkohalfrei_Getränke, "inkl. Pfand (0,15 €)2,15 €/l1,000l", new BigDecimal(2.15));
		Product product24=new Product("Krumbach Birne-Kräuter 1,0l", ProductCategory.Alkohalfrei_Getränke, "inkl. Pfand (0,25 €)2,75 €/l1,000l", new BigDecimal(2.75));
		Product product25=new Product("Orangensaft 1,0l ", ProductCategory.Alkohalfrei_Getränke, "inkl. Pfand (0,15 €)3,15 €/l1,000l", new BigDecimal(3.15));
		Product product26=new Product("Apfelsaft 1,0l", ProductCategory.Alkohalfrei_Getränke, "inkl. Pfand (0,15 €)3,15 €/l1,000l", new BigDecimal(3.15));
		Product product27=new Product("Eistee 1,5l", ProductCategory.Alkohalfrei_Getränke, "Enthält Koffein (25,0 mg/100 ml)inkl. Pfand (0,25 €)1,92 €/l1,500l", new BigDecimal(2.75));
		Product product28=new Product("Red Bull 0,33l", ProductCategory.Alkohalfrei_Getränke, "Enthält Koffein (32,0 mg/100 ml)inkl. Pfand (0,25 €)7,83 €/l0,330l", new BigDecimal(2.75));

	  // Ben & Jerrys
		Product product28Star=new Product("Ben & Jerry's Cookie Dough 100ml", ProductCategory.BenAndJerrys, "", new BigDecimal(3.60));
		Product product29=new Product("Ben & Jerry's Cookie Dough 500ml ", ProductCategory.BenAndJerrys, "", new BigDecimal(9.00));
			// Dessert
		Product product30 = new Product("Spaghetti Eis", ProductCategory.Dessert,"", new BigDecimal(2.90));
		Product product31 = new Product("Tiramisu", ProductCategory.Dessert,"", new BigDecimal(3.50));
		Product product32 = new Product("Langnese Eis", ProductCategory.Dessert,"", new BigDecimal(2.90));
		
		
		
		// Pide
		Product product33 = new Product("Pide mit Käse und Ei", ProductCategory.Pide,"", new BigDecimal(5.50));
		Product product34 = new Product("Pide mit Hackfleisch und Ei ", ProductCategory.Pide,"", new BigDecimal(6.00));
		Product product35 = new Product("Pide mit Sucuk und Ei", ProductCategory.Pide,"", new BigDecimal(7.00));
		Product product36 = new Product("Pide mit Drehhackfleischspieß und Käse", ProductCategory.Pide,"", new BigDecimal(7.00));
		
		
		
		// Vegatarische Döner
		Product product37= new Product("Falafel", ProductCategory.Vegatarische_Döner, "Wahl aus: mit Cocktailsauce, mit Joghurtsauce oder ohne Sauce.",  new BigDecimal(5.00));

		product37.getProductOptions().add(productOpton1);
		product37.getProductOptions().add(productOpton2);
		product37.getProductOptions().add(productOpton3);
		Product product38= new Product("Falafel Yufka Dürüm", ProductCategory.Vegatarische_Döner, "Wahl aus: mit Cocktailsauce, mit Joghurtsauce oder ohne Sauce.",  new BigDecimal(5.50));
		product38.getProductOptions().add(productOpton1);
		product38.getProductOptions().add(productOpton2);
		product38.getProductOptions().add(productOpton3);
		
		
		//Lahmacun
		
		Product product39= new Product("Lahmacun", ProductCategory.Lahmacun, "Wahl aus: mit Cocktailsauce, mit Joghurtsauce oder ohne Sauce.",  new BigDecimal(5.00));
		product39.getProductOptions().add(productOpton1);
		product39.getProductOptions().add(productOpton2);
		product39.getProductOptions().add(productOpton3);
		Product product40= new Product("Lahmacun mit Weichkäse", ProductCategory.Lahmacun, "Wahl aus: mit Cocktailsauce, mit Joghurtsauce oder ohne Sauce.",  new BigDecimal(5.00));
		product40.getProductOptions().add(productOpton1);
		product40.getProductOptions().add(productOpton2);
		product40.getProductOptions().add(productOpton3);
		Product product41= new Product("Lahmacun mit Kebab", ProductCategory.Lahmacun, "Wahl aus: mit Cocktailsauce, mit Joghurtsauce oder ohne Sauce.",  new BigDecimal(6.00));
		product41.getProductOptions().add(productOpton1);
		product41.getProductOptions().add(productOpton2);
		product41.getProductOptions().add(productOpton3);
		
		
		// Döner kebab
		
		Product product42=new Product("Döner Kebab",ProductCategory.Döner_kebab,"Drehhackfleischspieß im Fladenbrot mit Salat und Sauce \n Wahl aus: mit Cocktailsauce, mit Joghurtsauce oder ohne Sauce.",new BigDecimal(5));
		product42.getProductOptions().add(productOpton1);
		product42.getProductOptions().add(productOpton2);
		product42.getProductOptions().add(productOpton3);
		Product product43=new Product("Döner Kebab Spezial",ProductCategory.Döner_kebab,"Drehhackfleischspieß im Fladenbrot mitWeichkäse, Salat und Sauce \\n Wahl aus: mit Cocktailsauce, mit Joghurtsauce oder ohne Sauce.",new BigDecimal(5.00));
		product43.getProductOptions().add(productOpton1);
		product43.getProductOptions().add(productOpton2);
		product43.getProductOptions().add(productOpton3);
		Product product44=new Product("Döner Box ",ProductCategory.Döner_kebab,"mit Pommes frites, Drehhackfleischspieß und Sauce \\n Wahl aus: mit Cocktailsauce, mit Joghurtsauce oder ohne Sauce.",new BigDecimal(5.00));
		product44.getProductOptions().add(productOpton1);
		product44.getProductOptions().add(productOpton2);
		product44.getProductOptions().add(productOpton3);
		Product product45=new Product("Döner Box mit Salat ",ProductCategory.Döner_kebab,"und Drehhackfleischspieß",new BigDecimal(5.00));
		Product product46=new Product("Yufka Dürüm",ProductCategory.Döner_kebab,"mit Drehhackfleischspieß, Salat und Sauce \n Wahl aus: mit Cocktailsauce, mit Joghurtsauce oder ohne Sauce.",new BigDecimal(5.50));
		product46.getProductOptions().add(productOpton1);
		product46.getProductOptions().add(productOpton2);
		product46.getProductOptions().add(productOpton3);
		
		
		// Rösti
		
		Product product47 = new Product("Rösti mit Zwiebeln und Spiegelei", ProductCategory.Rösti, "", new BigDecimal(8.50));
		Product product48 = new Product("Rösti mit Schinken und Zwiebeln", ProductCategory.Rösti, "", new BigDecimal(8.50));
		Product product49 = new Product("Rösti mit Spinat und Schafskäse", ProductCategory.Rösti, "", new BigDecimal(8.50));
		Product product50 = new Product("Rösti mit Schinken und Champignons", ProductCategory.Rösti, "", new BigDecimal(8.50));
		
		
		
		// Internationalw Gerichte
		Product product51 = new Product("Pommes frites",ProductCategory.International_Gerichte,"mit Ketchup",new BigDecimal(3.20));
		Product product52 = new Product("Frühlingsrollen (8 Stück)",ProductCategory.International_Gerichte,"mit Chilisauce",new BigDecimal(3.50));
		Product product53 = new Product("Chicken Wings ",ProductCategory.International_Gerichte,"mit Pommes frites und einer Sauce nach Wahl \n Wahl aus: mit Chilisauce, mit Currysauce oder ohne Sauce.",new BigDecimal(6.70));
		product53.getProductOptions().add(productOpton7);
		product53.getProductOptions().add(productOpton8);
		product53.getProductOptions().add(productOpton9);
		Product product54 = new Product("Chicken Nuggets ",ProductCategory.International_Gerichte,"mit Pommes frites und einer Sauce nach Wahl \n Wahl aus: mit Chilisauce, mit Currysauce oder ohne Sauce.",new BigDecimal(5.70 ));
		product54.getProductOptions().add(productOpton7);
		product54.getProductOptions().add(productOpton8);
		product54.getProductOptions().add(productOpton9);
		Product product55 = new Product("Wiener Schnitzel ",ProductCategory.International_Gerichte,"mit einer Beilage nach Wahl und Salat \n Wahl aus: mit Pommes frites, mit Spätzle oder ohne Beilage.",new BigDecimal(8.90));
		product55.getProductOptions().add(productOpton4);
		product55.getProductOptions().add(productOpton5);
		product55.getProductOptions().add(productOpton6);
		Product product56 = new Product("Frische Champignons ",ProductCategory.International_Gerichte,"mit Sahnesauce und Käse",new BigDecimal(8.90));
		Product product57 = new Product("Kartoffelauflauf mit Tomaten und Käse-Sahnesauce",ProductCategory.International_Gerichte,"",new BigDecimal(8.90));
		Product product58 = new Product("Kartoffelauflauf mit Spinat, Mozzarella, Tomatensauce",ProductCategory.International_Gerichte,"und mit Käse überbacken",new BigDecimal(8.90));
		Product product59 = new Product("Cevapcici (10 Stück)",ProductCategory.International_Gerichte,"mit Ajvar, Pommes frites und Salat",new BigDecimal(9.90));
		Product product60 = new Product("Rahmschnitzel (Hähnchen)",ProductCategory.International_Gerichte,"mit einer Beilage nach Wahl und Salat \n Wahl aus: mit Pommes frites, mit Spätzle oder ohne Beilage.",new BigDecimal(9.90));
		product60.getProductOptions().add(productOpton4);
		product60.getProductOptions().add(productOpton5);
		product60.getProductOptions().add(productOpton6);
		
		Product product61 = new Product("Jägerschnitzel ",ProductCategory.International_Gerichte,"mit einer Beilage nach Wahl und Salat \n Wahl aus: mit Pommes frites, mit Spätzle oder ohne Beilage.",new BigDecimal(9.90));
		
		product61.getProductOptions().add(productOpton4);
		product61.getProductOptions().add(productOpton5);
		product61.getProductOptions().add(productOpton6);
		Product product62 = new Product("Zigeunerschnitzel ",ProductCategory.International_Gerichte,"mit einer Beilage nach Wahl und Salat \n Wahl aus: mit Pommes frites, mit Spätzle oder ohne Beilage.",new BigDecimal(9.90));
		product62.getProductOptions().add(productOpton4);
		product62.getProductOptions().add(productOpton5);
		product62.getProductOptions().add(productOpton6);
		Product product63 = new Product("Paniertes Seelachsfilet",ProductCategory.International_Gerichte,"mit Pommes frites, Remoulade und Salat",new BigDecimal(9.90));
		Product product64 = new Product("Hähnchen Cordon Bleu",ProductCategory.International_Gerichte,"mit einer Beilage nach Wahl und Salat \n Wahl aus: mit Pommes frites, mit Spätzle oder ohne Beilage.",new BigDecimal(9.90));
		product64.getProductOptions().add(productOpton4);
		product64.getProductOptions().add(productOpton5);
		product64.getProductOptions().add(productOpton6);
		Product product65 = new Product("Gebackene Calamaris",ProductCategory.International_Gerichte,"mit Pommes frites, Remoulade und Salat",new BigDecimal(9.90));
		Product product66 = new Product("Käsespätzle ",ProductCategory.International_Gerichte,"mit Salat",new BigDecimal(8.50));
		Product product67 = new Product("Hawaii-Toast",ProductCategory.International_Gerichte,"mit Schinken, Ananas und mit Käse überbacken",new BigDecimal(4.00));
		Product product68 = new Product("American-Toast",ProductCategory.International_Gerichte,"mit Schinken, Salami und mit Käse überbacken",new BigDecimal(4.00));
		Product product69 = new Product("La Strada Toast",ProductCategory.International_Gerichte,"mit Salami, Schinken, Käse, Zwiebeln, Salat, Remoulade und mit Käse überbacken",new BigDecimal(5.00));
	
	// Gyros Spezialitäten
		
		Product product70 = new Product("La Strada Spezial Gyrosfleisch",ProductCategory.Gyros_Spezialitäten,"Gyrosfleisch mit Kartoffeln, Krabben, Rahmsauce und Kräuterbrot",new BigDecimal(9.50));
		Product product71 = new Product("Gyros Teller",ProductCategory.Gyros_Spezialitäten,"mit einer Beilage nach Wahl, Tzatziki und Salat \n Wahl aus: mit Pommes frites, mit Reis oder ohne Beilage.",new BigDecimal(9.50));
		product71.getProductOptions().add(productOpton4);
		product71.getProductOptions().add(productOpton6);
		product71.getProductOptions().add(productOpton10);
		
		Product product72 = new Product("Gyros überbacken mit Pommes frites, Tzatziki und Salat",ProductCategory.Gyros_Spezialitäten,"",new BigDecimal(9.50));
		Product product73 = new Product("Gyros überbacken mit Tomaten, Paprika, Zwiebeln",ProductCategory.Gyros_Spezialitäten,"Pommes frites und Salat\n Wahl aus: mit Sahnesauce.",new BigDecimal(9.50));
			product73.getProductAdditions().add(pa1);
			
			
			//Indische Gerichte
			
			Product product74 = new Product("Saag Panir ",ProductCategory.Indische_Gerichte,"Spinat mit Käse \n Wahl aus: mit Fladenbrot.",new BigDecimal(10.0));
			product74.getProductAdditions().add(pa2);
			Product product75 = new Product("Bharta",ProductCategory.Indische_Gerichte,"mit gegrillten Auberginen, Zwiebeln und Tomaten \n Wahl aus: mit Fladenbrot.",new BigDecimal(10.0));
			product75.getProductAdditions().add(pa2);
			Product product76 = new Product("Murgh-Kari",ProductCategory.Indische_Gerichte,"Hähnchenbrustfilet-Curry nach indischer Art \n Wahl aus: mit Fladenbrot.",new BigDecimal(10.0));
			product76.getProductAdditions().add(pa2);
			Product product77 = new Product("Murgh-Sagwala",ProductCategory.Indische_Gerichte,"Hähnchenbrustfilet mit Spinat nach indischer Art \n Wahl aus: mit Fladenbrot.",new BigDecimal(10.0));
			product77.getProductAdditions().add(pa2);
			Product product78 = new Product("Murgh-Badami ",ProductCategory.Indische_Gerichte,"mit Hähnchenbrustfilet, milder Kormasauce, Mandeln und Sahne \n Wahl aus: mit Fladenbrot.",new BigDecimal(10.0));
			product78.getProductAdditions().add(pa2);
			Product product79 = new Product("Gemüse Biryani",ProductCategory.Indische_Gerichte,"mit verschiedenem Gemüse zubereitet nach indischer Art \n Wahl aus: mit Fladenbrot.",new BigDecimal(10.0));
			product79.getProductAdditions().add(pa2);
			Product product80 = new Product("Chicken Biryani",ProductCategory.Indische_Gerichte,"Reis zubereitet mit Hähnchenfleisch, Rosinen und Mandeln nach indischer Art \n Wahl aus: mit Fladenbrot.",new BigDecimal(10.0));
			product80.getProductAdditions().add(pa2);
			
			
			// Pasta al Forno
			
			Product product81= new Product("Rigatoni al Forno (vegetarisch)",ProductCategory.Pasta_al_Forno,"",new BigDecimal(8.50));
			Product product82= new Product("Rigatoni al Forno Bolognese",ProductCategory.Pasta_al_Forno,"",new BigDecimal(8.50));
			Product product83= new Product("Tortellini al Forno Bolognese",ProductCategory.Pasta_al_Forno,"",new BigDecimal(8.50));
			Product product84= new Product("Lasagne Bolognese ",ProductCategory.Pasta_al_Forno,"",new BigDecimal(8.50));
			Product product85= new Product("Lasagne (vegetarisch) ",ProductCategory.Pasta_al_Forno,"",new BigDecimal(8.50));
			Product product86= new Product("La Strada Nudeln",ProductCategory.Pasta_al_Forno,"mit drei Nudelsorten, Champignons, Schinken, Bolognese und Sahne",new BigDecimal(8.50));
			Product product87= new Product("Extra Spezial Nudeln ",ProductCategory.Pasta_al_Forno,"mit Krabben, Schinken, Champignons, Zwiebeln, Sahne und drei Nudelsorten",new BigDecimal(8.50));
	
			// Pasta
			
			Product product88 = new Product("Pasta Napoli",ProductCategory.Pasta,"mit Tomatensauce und Parmesan \n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product88.getProductOptions().add(productOpton11);
			product88.getProductOptions().add(productOpton12);
			product88.getProductOptions().add(productOpton13);
			product88.getProductOptions().add(productOpton14);
			Product product89 = new Product("Pasta Bolognese ",ProductCategory.Pasta,"mit Rindfleisch \n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product89.getProductOptions().add(productOpton11);
			product89.getProductOptions().add(productOpton12);
			product89.getProductOptions().add(productOpton13);
			product89.getProductOptions().add(productOpton14);
			Product product90 = new Product("Pasta Carbonara",ProductCategory.Pasta,"mit Schinken, Sahne und Ei\n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product90.getProductOptions().add(productOpton11);
			product90.getProductOptions().add(productOpton12);
			product90.getProductOptions().add(productOpton13);
			product90.getProductOptions().add(productOpton14);
			Product product91 = new Product("Pasta Alla Panna",ProductCategory.Pasta,"mit Schinken und Sahne\n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product91.getProductOptions().add(productOpton11);
			product91.getProductOptions().add(productOpton12);
			product91.getProductOptions().add(productOpton13);
			product91.getProductOptions().add(productOpton14);
			Product product92 = new Product("Pasta Aglio e Olio",ProductCategory.Pasta,"mit frischen Tomaten und pikanter Knoblauchsauce\n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product92.getProductOptions().add(productOpton11);
			product92.getProductOptions().add(productOpton12);
			product92.getProductOptions().add(productOpton13);
			product92.getProductOptions().add(productOpton14);
			Product product93 = new Product("Pasta Tonno ",ProductCategory.Pasta,"mit Thunfisch, Knoblauch und Tomatensauce\n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product93.getProductOptions().add(productOpton11);
			product93.getProductOptions().add(productOpton12);
			product93.getProductOptions().add(productOpton13);
			product93.getProductOptions().add(productOpton14);
			Product product94 = new Product("Pasta Spinaci",ProductCategory.Pasta,"mit Spinat und Sahnesauce\n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product94.getProductOptions().add(productOpton11);
			product94.getProductOptions().add(productOpton12);
			product94.getProductOptions().add(productOpton13);
			product94.getProductOptions().add(productOpton14);
			Product product95 = new Product("Pasta Quattro Formaggi ",ProductCategory.Pasta,"mit 4 verschiedenen Käsesorten\n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product95.getProductOptions().add(productOpton11);
			product95.getProductOptions().add(productOpton12);
			product95.getProductOptions().add(productOpton13);
			product95.getProductOptions().add(productOpton14);
			Product product96 = new Product("Pasta Gorgonzola ",ProductCategory.Pasta,"mit Gorgonzola und Sahne\n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product96.getProductOptions().add(productOpton11);
			product96.getProductOptions().add(productOpton12);
			product96.getProductOptions().add(productOpton13);
			product96.getProductOptions().add(productOpton14);
			Product product97 = new Product("Pasta Frutti di Mare",ProductCategory.Pasta,"mit Meeresfrüchten, Knoblauch und Tomatensauce \n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product97.getProductOptions().add(productOpton11);
			product97.getProductOptions().add(productOpton12);
			product97.getProductOptions().add(productOpton13);
			product97.getProductOptions().add(productOpton14);
			Product product98 = new Product("Pasta Napoli Plus",ProductCategory.Pasta,"mit Tomatensauce, Sahne und Mozzarella \n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product98.getProductOptions().add(productOpton11);
			product98.getProductOptions().add(productOpton12);
			product98.getProductOptions().add(productOpton13);
			product98.getProductOptions().add(productOpton14);
			Product product99 = new Product("Pasta Spezial 1",ProductCategory.Pasta,"mit Schinken, Erbsen, Champignons, Käse, Sahne und Tomatensauce \n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product99.getProductOptions().add(productOpton11);
			product99.getProductOptions().add(productOpton12);
			product99.getProductOptions().add(productOpton13);
			product99.getProductOptions().add(productOpton14);
			Product product100 = new Product("Pasta Vegetarisch",ProductCategory.Pasta,"mit verschiedenem Gemüse, Sahne und Tomatensauce\n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product100.getProductOptions().add(productOpton11);
			product100.getProductOptions().add(productOpton12);
			product100.getProductOptions().add(productOpton13);
			product100.getProductOptions().add(productOpton14);
			Product product101= new Product("Pasta Spezial 2 ",ProductCategory.Pasta,"mit Rucola, Gorgonzola und Sahnesauce \n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product101.getProductOptions().add(productOpton11);
			product101.getProductOptions().add(productOpton12);
			product101.getProductOptions().add(productOpton13);
			product101.getProductOptions().add(productOpton14);
			Product product102 = new Product("Pasta Salmone",ProductCategory.Pasta,"mit Lachs und Sahnesauce \n Wahl aus: mit Gnocchi, mit Rigatoni, mit Spaghetti oder mit Tortellini.",new BigDecimal(8.00));
			product102.getProductOptions().add(productOpton11);
			product102.getProductOptions().add(productOpton12);
			product102.getProductOptions().add(productOpton13);
			product102.getProductOptions().add(productOpton14);
			
			
			// Pizzabrot
			
			Product product103=new Product("Pizzabrot mit Kräutern ",ProductCategory.PizzabrotØ30,"",new BigDecimal(4.00));
			Product product104=new Product("Pizzabrot mit Tomatensauce",ProductCategory.PizzabrotØ30,"",new BigDecimal(4.00));
			
			
			// Calzone
			Product product105=new Product("Calzone",ProductCategory.Calzone,"mit Putenfleisch, Käse, Paprika und Champignons\n Wahl aus: Klein oder Groß.",null);
			product105.getProductOptions().add(productOpton17);
			product105.getProductOptions().add(productOpton18);
			Product product106=new Product("Calzone Gyros",ProductCategory.Calzone,"mit Gyrosfleisch, Schafskäse, Tomatenscheiben, Zwiebeln und Tzatziki \n Wahl aus: Klein oder Groß.",null);
			product106.getProductOptions().add(productOpton17);
			product106.getProductOptions().add(productOpton18);
			Product product107=new Product("Pizza La Strada Spezial Calzone",ProductCategory.Calzone,"mit Gyrosfleisch, Champignons, Zwiebeln, Hackfleisch, Schinken und Tzatziki\n Wahl aus: Klein oder Groß.",null);
			product107.getProductOptions().add(productOpton17);
			product107.getProductOptions().add(productOpton18);
			
			
			// Vegetarische Pizza
			
			Product product108= new Product("Pizza Tomatenscheiben-Zwiebeln-Champignons-frische Paprika",ProductCategory.Vegatarische_Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product108.setProductAdditions(getAllPizzaAdditions());
			product108.setProductOptions(getAllPizzaOptions(new BigDecimal(7.90), new BigDecimal(9.00), new BigDecimal(18.50), new BigDecimal(23.50)));
			Product product109= new Product("Pizza Artischocken-Paprika-Zwiebeln-Champignons-Oliven-Peperoni ",ProductCategory.Vegatarische_Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product109.setProductAdditions(getAllPizzaAdditions());
			product109.setProductOptions(getAllPizzaOptions(new BigDecimal(7.90), new BigDecimal(9.00), new BigDecimal(18.50), new BigDecimal(23.50)));
			Product product110= new Product("Pizza Mozzarella mit Tomatenscheiben ",ProductCategory.Vegatarische_Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product110.setProductAdditions(getAllPizzaAdditions());
			product110.setProductOptions(getAllPizzaOptions(new BigDecimal(7.90), new BigDecimal(9.00), new BigDecimal(18.50), new BigDecimal(23.50)));
			Product product111= new Product("Pizza Mozzarella mit Spinat ",ProductCategory.Vegatarische_Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product111.setProductOptions(getAllPizzaOptions(new BigDecimal(7.90), new BigDecimal(9.00), new BigDecimal(18.50), new BigDecimal(23.50)));
			product111.setProductAdditions(getAllPizzaAdditions());
			Product product112= new Product("Pizza Artischocken-Ananas-Champignons-Zwiebeln-Peperoni-Paprika ",ProductCategory.Vegatarische_Pizza,"und Knobaluch \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product112.setProductOptions(getAllPizzaOptions(new BigDecimal(7.90), new BigDecimal(9.00), new BigDecimal(18.50), new BigDecimal(23.50)));
			product112.setProductAdditions(getAllPizzaAdditions());
			
			
			// Pizza
			Product product113= new Product("Pizza Margherita",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product113.setProductAdditions(getAllPizzaAdditions());
			product113.setProductOptions(getAllPizzaOptions(new BigDecimal(5.70), new BigDecimal(6.70), new BigDecimal(15.70), new BigDecimal(19.00)));
			
			Product product114= new Product("Pizza Rinder-Salami ",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product114.setProductAdditions(getAllPizzaAdditions());
			product114.setProductOptions(getAllPizzaOptions(new BigDecimal(6.40), new BigDecimal(7.90), new BigDecimal(16.00), new BigDecimal(19.90)));

			Product product115= new Product("Pizza Geflügelschinken",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product115.setProductAdditions(getAllPizzaAdditions());
			product115.setProductOptions(getAllPizzaOptions(new BigDecimal(6.40), new BigDecimal(7.90), new BigDecimal(16.00), new BigDecimal(19.90)));

			Product product116= new Product("Pizza türkische Salami",ProductCategory.Pizza,"mit Sucuk \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product116.setProductAdditions(getAllPizzaAdditions());
			product116.setProductOptions(getAllPizzaOptions(new BigDecimal(6.40), new BigDecimal(7.90), new BigDecimal(16.00), new BigDecimal(19.90)));

			Product product117= new Product("Pizza Champignons ",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product117.setProductAdditions(getAllPizzaAdditions());
			product117.setProductOptions(getAllPizzaOptions(new BigDecimal(6.40), new BigDecimal(7.90), new BigDecimal(16.00), new BigDecimal(19.90)));

			Product product118= new Product("Pizza Thunfisch-Zwiebeln",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product118.setProductAdditions(getAllPizzaAdditions());
			product118.setProductOptions(getAllPizzaOptions(new BigDecimal(6.90), new BigDecimal(8.40), new BigDecimal(17.50), new BigDecimal(21.00)));

			Product product119= new Product("Pizza Schinken-Salami",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product119.setProductAdditions(getAllPizzaAdditions());
			product119.setProductOptions(getAllPizzaOptions(new BigDecimal(6.90), new BigDecimal(8.40), new BigDecimal(17.50), new BigDecimal(21.00)));

			Product product120= new Product("Pizza Schinken-Champignons ",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product120.setProductAdditions(getAllPizzaAdditions());
			product120.setProductOptions(getAllPizzaOptions(new BigDecimal(6.90), new BigDecimal(8.40), new BigDecimal(17.50), new BigDecimal(21.00)));

			Product product121= new Product("Pizza Hawaii",ProductCategory.Pizza,"mit Schinken und Ananas \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product121.setProductAdditions(getAllPizzaAdditions());
			product121.setProductOptions(getAllPizzaOptions(new BigDecimal(6.90), new BigDecimal(8.40), new BigDecimal(17.50), new BigDecimal(21.00)));

			Product product122= new Product("Pizza Salami-Hackfleisch-Champignons",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product122.setProductAdditions(getAllPizzaAdditions());
			product122.setProductOptions(getAllPizzaOptions(new BigDecimal(6.90), new BigDecimal(8.40), new BigDecimal(17.50), new BigDecimal(21.00)));

			Product product123= new Product("Pizza Salami-Schinken-Artischocken-Zwiebeln ",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product123.setProductAdditions(getAllPizzaAdditions());
			product123.setProductOptions(getAllPizzaOptions(new BigDecimal(6.90), new BigDecimal(8.40), new BigDecimal(17.50), new BigDecimal(21.00)));

			Product product124= new Product("Pizza Salami-Schinken-Champignons ",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product124.setProductAdditions(getAllPizzaAdditions());
			product124.setProductOptions(getAllPizzaOptions(new BigDecimal(6.90), new BigDecimal(8.40), new BigDecimal(17.50), new BigDecimal(21.00)));

			Product product125= new Product("Pizza Schinken-Champignons-Artischocken-Oliven",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product125.setProductAdditions(getAllPizzaAdditions());
			product125.setProductOptions(getAllPizzaOptions(new BigDecimal(6.90), new BigDecimal(8.40), new BigDecimal(17.50), new BigDecimal(21.00)));

			Product product126= new Product("Pizza Creme fraiche ",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product126.setProductAdditions(getAllPizzaAdditions());
			product126.setProductOptions(getAllPizzaOptions(new BigDecimal(6.90), new BigDecimal(8.40), new BigDecimal(17.50), new BigDecimal(21.00)));

			Product product127= new Product("Pizza Diavolo",ProductCategory.Pizza,"mit Salami, Zwiebeln, Peperoni und Chili, scharf \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product127.setProductAdditions(getAllPizzaAdditions());
			product127.setProductOptions(getAllPizzaOptions(new BigDecimal(6.90), new BigDecimal(8.40), new BigDecimal(17.50), new BigDecimal(21.00)));

			Product product128= new Product("Pizza Sardellen-Mozzarella-Basilikum-Tomatenscheiben",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product128.setProductAdditions(getAllPizzaAdditions());
			product128.setProductOptions(getAllPizzaOptions(new BigDecimal(7.90), new BigDecimal(9.40), new BigDecimal(19.50), new BigDecimal(24.50)));

			Product product129= new Product("Pizza Vier Jahreszeiten",ProductCategory.Pizza,"mit Salami, Schinken, Paprika, Champignons und Ei \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product129.setProductAdditions(getAllPizzaAdditions());
			product129.setProductOptions(getAllPizzaOptions(new BigDecimal(7.90), new BigDecimal(9.40), new BigDecimal(19.50), new BigDecimal(24.50)));

			Product product130= new Product("Pizza Meeresfrüchte ",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product130.setProductAdditions(getAllPizzaAdditions());
			product130.setProductOptions(getAllPizzaOptions(new BigDecimal(7.90), new BigDecimal(9.40), new BigDecimal(19.50), new BigDecimal(24.50)));

			Product product131= new Product("Pizza Bolognese",ProductCategory.Pizza,"mit Zwiebeln, Hackfleisch und scharfer Peperoni \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product131.setProductAdditions(getAllPizzaAdditions());
			product131.setProductOptions(getAllPizzaOptions(new BigDecimal(7.90), new BigDecimal(9.40), new BigDecimal(19.50), new BigDecimal(24.50)));

			Product product132= new Product("Pizza Quattro Formaggi",ProductCategory.Pizza,"mit vier Käsesorten \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product132.setProductAdditions(getAllPizzaAdditions());
			product132.setProductOptions(getAllPizzaOptions(new BigDecimal(7.90), new BigDecimal(9.40), new BigDecimal(19.50), new BigDecimal(24.50)));

			Product product133= new Product("Pizza La Strada ",ProductCategory.Pizza,"mit Schinken, Mais, Paprika, Champignons, Peperoni und Hackfleisch \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product133.setProductAdditions(getAllPizzaAdditions());
			product133.setProductOptions(getAllPizzaOptions(new BigDecimal(7.90), new BigDecimal(9.40), new BigDecimal(19.50), new BigDecimal(24.50)));

			Product product134= new Product("Pizza Salami-Schinken-Champignons-Paprika-Hackfleisch-Zwiebeln-Peperoni",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product134.setProductAdditions(getAllPizzaAdditions());
			product134.setProductOptions(getAllPizzaOptions(new BigDecimal(7.90), new BigDecimal(9.40), new BigDecimal(19.50), new BigDecimal(24.50)));

			Product product135= new Product("Grill Pizza ",ProductCategory.Pizza,"mit gegrilltem Hühnerfleisch, Champignons und Peperoni \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product135.setProductAdditions(getAllPizzaAdditions());
			product135.setProductOptions(getAllPizzaOptions(new BigDecimal(7.90), new BigDecimal(9.40), new BigDecimal(19.50), new BigDecimal(24.50)));

			Product product136= new Product("Pizza Mexicana",ProductCategory.Pizza,"mit Bohnen, Oliven, Hackfleisch, Chili, Zwiebeln und Peperoni \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product136.setProductAdditions(getAllPizzaAdditions());
			product136.setProductOptions(getAllPizzaOptions(new BigDecimal(7.90), new BigDecimal(9.40), new BigDecimal(19.50), new BigDecimal(24.50)));

			Product product137= new Product("Pizza Schinken-Gorgonzola-Rucola ",ProductCategory.Pizza,"Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product137.setProductAdditions(getAllPizzaAdditions());
			product137.setProductOptions(getAllPizzaOptions(new BigDecimal(7.90), new BigDecimal(9.40), new BigDecimal(19.50), new BigDecimal(24.50)));

			Product product138= new Product("Pizza Spezial",ProductCategory.Pizza,"mit Hühnerfleisch, Champignons, Paprika, Zwiebeln und Curry \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product138.setProductAdditions(getAllPizzaAdditions());
			product138.setProductOptions(getAllPizzaOptions(new BigDecimal(7.90), new BigDecimal(9.40), new BigDecimal(19.50), new BigDecimal(24.50)));

			Product product139= new Product("Pizza Orientale",ProductCategory.Pizza,"mit türkischer Salami, Schafskäse und roten Zwiebeln \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product139.setProductAdditions(getAllPizzaAdditions());
			product139.setProductOptions(getAllPizzaOptions(new BigDecimal(7.90), new BigDecimal(9.40), new BigDecimal(19.50), new BigDecimal(24.50)));

			Product product140= new Product("Pizza Lachs",ProductCategory.Pizza,"mit Spinat, Knoblauch und Mozzarella \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product140.setProductAdditions(getAllPizzaAdditions());
			product140.setProductOptions(getAllPizzaOptions(new BigDecimal(7.90), new BigDecimal(9.40), new BigDecimal(19.50), new BigDecimal(24.50)));

			Product product141= new Product("Pizza Gyros",ProductCategory.Pizza,"mit Mozzarella, Tomaten und Zwiebeln \n Wahl aus: Klein, Ø 26cm, Groß, Ø 30cm, Familie, 46cm x 33cm oder Party, 60cm x 40cm.",null);
			product141.setProductAdditions(getAllPizzaAdditions());
			product141.setProductOptions(getAllPizzaOptions(new BigDecimal(7.90), new BigDecimal(9.40), new BigDecimal(19.50), new BigDecimal(24.50)));
				
			// Salat
			
			Product product142= new Product("Gemischter Salat (klein)",ProductCategory.Salat,"Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(3.40));
			product142.getProductOptions().add(productOpton19);
			product142.getProductOptions().add(productOpton20);
			product142.getProductOptions().add(productOpton21);
			product142.getProductOptions().add(productOpton22);
			
			Product product143= new Product("Rucolasalat (klein)",ProductCategory.Salat,"mit Feta, frischen Tomaten und Olivenöl \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(5.50));
			product143.getProductOptions().add(productOpton19);
			product143.getProductOptions().add(productOpton20);
			product143.getProductOptions().add(productOpton21);
			product143.getProductOptions().add(productOpton22);
			
			Product product144= new Product("Tomatensalat (klein)",ProductCategory.Salat,"mit Zwiebeln \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(4.30));
			product144.getProductOptions().add(productOpton19);
			product144.getProductOptions().add(productOpton20);
			product144.getProductOptions().add(productOpton21);
			product144.getProductOptions().add(productOpton22);
			
			Product product145= new Product("Krabben-Cocktail Salat (klein)",ProductCategory.Salat,"Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(6.90));
			product145.getProductOptions().add(productOpton19);
			product145.getProductOptions().add(productOpton20);
			product145.getProductOptions().add(productOpton21);
			product145.getProductOptions().add(productOpton22);
			
			Product product146= new Product("Mozzarella-Teller (klein)",ProductCategory.Salat,"mit Tomaten und Zwiebeln \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(4.80));
			product146.getProductOptions().add(productOpton19);
			product146.getProductOptions().add(productOpton20);
			product146.getProductOptions().add(productOpton21);
			product146.getProductOptions().add(productOpton22);
			
			Product product147= new Product("Gemischter Salat",ProductCategory.Salat,"mit grünem Salat, Gurken, Tomaten, Karotten, Bohnen, Mais und milder Peperoni \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(4.90));
			product147.getProductOptions().add(productOpton19);
			product147.getProductOptions().add(productOpton20);
			product147.getProductOptions().add(productOpton21);
			product147.getProductOptions().add(productOpton22);
			
			Product product148= new Product("Salat Nizza",ProductCategory.Salat,"mit grünem Salat, Zwiebeln, Thunfisch, Oliven, Tomaten und Gurken \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(6.50));
			product148.getProductOptions().add(productOpton19);
			product148.getProductOptions().add(productOpton20);
			product148.getProductOptions().add(productOpton21);
			product148.getProductOptions().add(productOpton22);
			
			Product product149= new Product("Thunfischsalat",ProductCategory.Salat,"mit grünem Salat, Thunfisch, Oliven, Artischocken, Tomaten und Ei \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(7.50));
			product149.getProductOptions().add(productOpton19);
			product149.getProductOptions().add(productOpton20);
			product149.getProductOptions().add(productOpton21);
			product149.getProductOptions().add(productOpton22);
			
			Product product150= new Product("Italienischer Salat",ProductCategory.Salat,"mit grünem Salat, Tomaten, Gurken, Paprika, Schinken, Thunfisch, Käse, Ei und Oliven \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(7.50));
			product150.getProductOptions().add(productOpton19);
			product150.getProductOptions().add(productOpton20);
			product150.getProductOptions().add(productOpton21);
			product150.getProductOptions().add(productOpton22);
			
			Product product151= new Product("Mexikanischer Salat ",ProductCategory.Salat,"mit grünem Salat, Pute, Mais, Bohnen, frischer Paprika, Peperoni, Tomaten und Gurken \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(7.50));
			product151.getProductOptions().add(productOpton19);
			product151.getProductOptions().add(productOpton20);
			product151.getProductOptions().add(productOpton21);
			product151.getProductOptions().add(productOpton22);
			
			Product product152= new Product("Amerikanischer Salat",ProductCategory.Salat,"mit grünem Salat, gegrilltem Geflügelfleisch,Tomaten, Mais, Paprika, Karotten, Gurken und Ei \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(7.50));
			product152.getProductOptions().add(productOpton19);
			product152.getProductOptions().add(productOpton20);
			product152.getProductOptions().add(productOpton21);
			product152.getProductOptions().add(productOpton22);
			
			Product product153= new Product("Rösti Salat ",ProductCategory.Salat,"großer gemischter Salat mit Rösti und gegrilltem Geflügelfleisch \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(7.50));
			product153.getProductOptions().add(productOpton19);
			product153.getProductOptions().add(productOpton20);
			product153.getProductOptions().add(productOpton21);
			product153.getProductOptions().add(productOpton22);
			
			Product product154= new Product("Meeresfrüchtesalat",ProductCategory.Salat,"mit grünem Salat, Zitronenscheiben und Oliven \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(7.50));
			product154.getProductOptions().add(productOpton19);
			product154.getProductOptions().add(productOpton20);
			product154.getProductOptions().add(productOpton21);
			product154.getProductOptions().add(productOpton22);
			
			Product product155= new Product("La Strada Salat",ProductCategory.Salat,"mit grünem Salat, Schinken, Käse, Bohnen, Mais, Krabben, frischen Tomaten und Ei \n Wahl aus: mit Cocktail-Dressing, mit Essig und Öl, mit Joghurtsauce oder ohne Dressing.",new BigDecimal(7.50));
			product155.getProductOptions().add(productOpton19);
			product155.getProductOptions().add(productOpton20);
			product155.getProductOptions().add(productOpton21);
			product155.getProductOptions().add(productOpton22);
			
			
			// Indische Vorspeise
			
			Product product156= new Product("Samosa (2 Stück)",ProductCategory.Indische_Vorspeisen," frittierte Teigtaschen mit Kartoffeln und Erbsen\n Wahl aus: mit Fladenbrot.", new BigDecimal(4.50));
			product156.getProductAdditions().add(pa2);
			Product product157= new Product("Mix-Gemüse Pakora",ProductCategory.Indische_Vorspeisen," frittiert in Kichererbsenmehlteig\n Wahl aus: mit Fladenbrot.", new BigDecimal(5.00));
			product157.getProductAdditions().add(pa2);
			Product product158= new Product("Hähnchenfleisch Pakora",ProductCategory.Indische_Vorspeisen," frittiert in Kichererbsenmehlteig \n Wahl aus: mit Fladenbrot.", new BigDecimal(6.00));
			product158.getProductAdditions().add(pa2);
		
			
			this.productRepository.save(product1);
			this.productRepository.save(product2);
			this.productRepository.save(product3);
			this.productRepository.save(product4);
			this.productRepository.save(product5);
			this.productRepository.save(product6);
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
			
			
			
	}
	
	private Set<ProductOption> getAllPizzaOptions(BigDecimal small,BigDecimal big,BigDecimal family,BigDecimal party){
		
		Set<ProductOption>pizzaOption=new HashSet<>();	
		ProductOption productOptionSmall=new ProductOption("klein, Ø26cm:", null, small, null, null, null);
		ProductOption productOptionBig=new ProductOption("Groß, Ø30cm:", null, null, big, null, null);
		ProductOption productOptionFamily=new ProductOption("Familie,46cm x 33cm:", null, null, null, family, null);
		ProductOption productOptionParty=new ProductOption("Party,60cm x 40cm:", null, null, null, null, party);
		pizzaOption.add(productOptionSmall);
		pizzaOption.add(productOptionBig);
		pizzaOption.add(productOptionFamily);
		pizzaOption.add(productOptionParty);
		return pizzaOption;
	}
	
	private Set<ProductAddition> getAllPizzaAdditions() {
		Set<ProductAddition>productAdditions=new HashSet<>();
		ProductAddition pa1=new ProductAddition("Sahnesauce", new BigDecimal(1.00), null, null, null, null);
		ProductAddition pa2=new ProductAddition("Fladenbrot", new BigDecimal(2.50), null, null, null, null);
		ProductAddition pa3=new ProductAddition("Ananas", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa4=new ProductAddition("Artischocken", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa5=new ProductAddition("Broccoli",null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa6=new ProductAddition("Champignons", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa7=new ProductAddition("Ei", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa8=new ProductAddition("Gorgonzola", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(3.50), new BigDecimal(5.00));
		ProductAddition pa9=new ProductAddition("Gyrosfleisch", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa10=new ProductAddition("Hähnchenfleisch",null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa11=new ProductAddition("Käse,extra", null, new BigDecimal(1.00), new BigDecimal(1.00),new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa12=new ProductAddition("knoblauch", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa13=new ProductAddition("krabben", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(3.50), new BigDecimal(5.00));
		ProductAddition pa14=new ProductAddition("Lachs", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50), new BigDecimal(5.00));
		ProductAddition pa15=new ProductAddition("Mais", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa16=new ProductAddition("Meeresfrüchten", null, new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(3.50), new BigDecimal(5.00));
		ProductAddition pa17=new ProductAddition("Mozzarella", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa18=new ProductAddition("Paprika", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa19=new ProductAddition("Peperoni", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa20=new ProductAddition("Salami", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa21=new ProductAddition("Sardellen", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa22=new ProductAddition("Schafskäse", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa23=new ProductAddition("Schinken", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa24=new ProductAddition("Spinat", null, new BigDecimal(1.00), new BigDecimal(1.00),new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa25=new ProductAddition("Thunfisch", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa26=new ProductAddition("Tomaten", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa27=new ProductAddition("Tzatziki", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa28=new ProductAddition("Zwiebeln", null, new BigDecimal(1.00), new BigDecimal(1.00), new BigDecimal(1.50), new BigDecimal(1.50));
		ProductAddition pa29=new ProductAddition("käserand", null, new BigDecimal(2.00), new BigDecimal(2.50), new BigDecimal(1.50), new BigDecimal(1.50));
		productAdditions.add(pa1);
		productAdditions.add(pa2);
		productAdditions.add(pa3);
		productAdditions.add(pa4);
		productAdditions.add(pa5);
		productAdditions.add(pa6);
		productAdditions.add(pa7);
		productAdditions.add(pa8);
		productAdditions.add(pa9);
		productAdditions.add(pa10);
		productAdditions.add(pa11);
		productAdditions.add(pa12);
		productAdditions.add(pa13);
		productAdditions.add(pa14);
		productAdditions.add(pa15);
		productAdditions.add(pa16);
		productAdditions.add(pa17);
		productAdditions.add(pa18);
		productAdditions.add(pa19);
		productAdditions.add(pa20);
		productAdditions.add(pa21);
		productAdditions.add(pa22);
		productAdditions.add(pa23);
		productAdditions.add(pa24);
		productAdditions.add(pa25);
		productAdditions.add(pa26);
		productAdditions.add(pa27);
		productAdditions.add(pa28);
		productAdditions.add(pa29);
		return productAdditions;
		
	}
	
	
	


}
