/*
 * Copyright 2014-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example.springdata.multistore;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import example.springdata.multistore.context.ApplicationConfiguration;
import example.springdata.multistore.customer.Customer;
import example.springdata.multistore.customer.CustomerRepository;
import example.springdata.multistore.shop.Order;
import example.springdata.multistore.shop.OrderRepository;

/**
 * Integration test to check repository interfaces are assigned to the correct store modules.
 * 
 * @author Oliver Gierke
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ApplicationConfiguration.class)
public class ApplicationConfigurationTest {

//	@Autowired ApplicationContext context;
	
	@Autowired CustomerRepository customerRepository;
	
	@Autowired OrderRepository orderRepository;

//	@Test
//	public void repositoriesAreAssignedToAppropriateStores() {
//
//		Repositories repositories = new Repositories(context);
//
//		assertThat(repositories.getEntityInformationFor(Customer.class), is(instanceOf(JpaEntityInformation.class)));
//		assertThat(repositories.getEntityInformationFor(Order.class), is(instanceOf(MongoEntityInformation.class)));
//	}
	
	@Test
	public void repositoriesInit() {
		assertNotNull(customerRepository);
		assertNotNull(orderRepository);
		
		Order order = new Order("123", new Date());
		orderRepository.save(order);
		
		Customer customer = new Customer("Judith", "Zhu");
		customerRepository.save(customer);
	}
}
