package com.javasampleapproach.jqueryajax;


import com.javasampleapproach.jqueryajax.controller.ORMController;
import com.javasampleapproach.jqueryajax.repository.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration

public class MyRepositoryTest {

    @Autowired
    ContactRepository contactRepository;

    @Test
    public void myTest() throws Exception {
        contactRepository.findAll();
    }
}
