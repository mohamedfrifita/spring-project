package com.esprit.spring.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EntrepriseServiceImplTest {

	@Autowired
	IEntrepriseService es;
	private static final Logger L = LogManager.getLogger(EntrepriseServiceImpl.class);
@Test
void ContextLoads() {
}}
