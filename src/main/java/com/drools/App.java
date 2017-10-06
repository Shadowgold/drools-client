package com.drools;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.drools.core.event.DebugAgendaEventListener;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.drools.client.DroolsClient;

@SpringBootApplication
public class App implements CommandLineRunner { 
	
	
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	
	@Autowired
	private DroolsClient droolsClient;
	@Override
	public void run(String... arg0) throws Exception {
		droolsClient.getDTOInferirCategoria(1);
		logger.info("Response: {}", droolsClient);
		 KieServices ks = KieServices.Factory.get();
 	    KieContainer kContainer = ks.getKieClasspathContainer();
     	KieSession kSession = kContainer.newKieSession("ksession-rules");
     	kSession.insert(droolsClient.getDTOInferirCategoria(1));
     	kSession.fireAllRules();
	}
}
