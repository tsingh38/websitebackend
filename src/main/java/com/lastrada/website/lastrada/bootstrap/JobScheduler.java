package com.lastrada.website.lastrada.bootstrap;



import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lastrada.website.lastrada.services.ShopService;



@Component
public class JobScheduler {
	
	private static final Logger log = LoggerFactory.getLogger(JobScheduler.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	private ShopService shopService;

	@Scheduled(fixedRateString ="${app.deletejob.timePeriod}", initialDelay=1000)
	public void processOldOrderDeletion() {
		shopService.deleteOlderCustOrders();
	}
}
