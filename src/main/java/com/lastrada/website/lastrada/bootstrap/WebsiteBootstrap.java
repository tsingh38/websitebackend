package com.lastrada.website.lastrada.bootstrap;



import java.math.BigDecimal;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.lastrada.website.lastrada.model.Product;
import com.lastrada.website.lastrada.model.ProductAddition;
import com.lastrada.website.lastrada.model.ProductCategory;
import com.lastrada.website.lastrada.model.ProductOption;
import com.lastrada.website.lastrada.repository.ProductAdditionRepository;
import com.lastrada.website.lastrada.repository.ProductCategoryRepository;
import com.lastrada.website.lastrada.repository.ProductOptionRepository;
import com.lastrada.website.lastrada.repository.ProductRepository;

@Component
public class WebsiteBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	
	private ProductRepository productRepository;
	private ProductAdditionRepository productAdditionRepository;
	private ProductOptionRepository productOptionRepository;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		//initProductCategoryData();
		//initProductAdditionData();
		//initProductOptionsData();
		//initProductData();
		
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
	}
	private void initProductOptionsData() {
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
		ProductOption productOpton15=new ProductOption("klein:7,50 €", new BigDecimal(7.50), null, null, null, null);
		ProductOption productOpton16=new ProductOption("Groß:9,00 €", new BigDecimal(9.00), null, null, null, null);
		ProductOption productOpton17=new ProductOption("klein, Ø26cm:", null, null, null, null, null);
		ProductOption productOpton18=new ProductOption("Groß, Ø30cm:", null, null, null, null, null);
		ProductOption productOpton19=new ProductOption("Familie,46cm x 33cm:", null, null, null, null, null);
		ProductOption productOpton20=new ProductOption("Party,60cm x 40cm:", null, null, null, null, null);
	}
	
	private void initProductAdditionData() {
		
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
	

		
	}
	
	
	private void initProductCategoryData() {
		
	}
//	private void initData() {
//		ProductOption productOption1 = new ProductOption("Pizza klein 26 ", null, new BigDecimal(12), null, null, null);
//		ProductOption productOption2 = new ProductOption("Pizza normal 28 ", null, null, new BigDecimal(12), null, null);
//		ProductOption productOption3 = new ProductOption("Pizza family 32 ", null, null, null, new BigDecimal(12), null);
//		ProductOption productOption4 = new ProductOption("Pizza party 38 ", null, null, null, null, new BigDecimal(12));
//		ProductOption productOption5 = new ProductOption("Salsa Sauce ", new BigDecimal(1.5), null, null, null, null);
//		ProductOption productOption6 = new ProductOption("Noodle Pesto ", new BigDecimal(2), null, null, null, null);
//		
//		this.productOptionRepository.save(productOption1);
//		this.productOptionRepository.save(productOption2);
//		this.productOptionRepository.save(productOption3);
//		this.productOptionRepository.save(productOption4);
//		this.productOptionRepository.save(productOption5);
//		this.productOptionRepository.save(productOption6);
//		
//		ProductAddition productAddition1 = new ProductAddition("mit fladenbrot",new BigDecimal(2),null,null,null,null);
//		ProductAddition productAddition2 = new ProductAddition("mit brocolli",null,new BigDecimal(2),new BigDecimal(2.5),new BigDecimal(3),new BigDecimal(4));
//
//		ProductAddition productAddition3 = new ProductAddition("mit käse",null,new BigDecimal(2),new BigDecimal(2.5),new BigDecimal(3),new BigDecimal(4));
//
//		ProductAddition productAddition4 = new ProductAddition("mit oliven",new BigDecimal(1),new BigDecimal(2),new BigDecimal(2.5),new BigDecimal(3),new BigDecimal(4));
//
//		this.productAdditionRepository.save(productAddition1);
//		this.productAdditionRepository.save(productAddition2);
//		this.productAdditionRepository.save(productAddition3);
//		this.productAdditionRepository.save(productAddition4);
//		
//		
//		Product productPizzaMargheritta= new Product("Margherita","Pizza", "Große wahl",new BigDecimal(6.9));
//		productPizzaMargheritta.getProductAdditions().add(productAddition2);
//		productPizzaMargheritta.getProductAdditions().add(productAddition4);
//		productPizzaMargheritta.getProductOptions().add(productOption1);
//		productPizzaMargheritta.getProductOptions().add(productOption2);
//		productPizzaMargheritta.getProductOptions().add(productOption3);
//		productPizzaMargheritta.getProductOptions().add(productOption4);
//		this.productRepository.save(productPizzaMargheritta);
//		Product productBhartha= new Product("Bhartha","Indisch","bio zutaten",new BigDecimal(10.00));
//		productBhartha.getProductAdditions().add(productAddition1);
//		productBhartha.getProductOptions().add(productOption5);
//		productBhartha.getProductOptions().add(productOption6);
//		this.productRepository.save(productBhartha);
//	}

}
