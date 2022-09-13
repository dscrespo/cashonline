package com.example.cashonline.persistence.store;

import com.example.cashonline.persistence.entity.User;
import com.example.cashonline.persistence.repository.UserRepository;
import com.example.cashonline.pojo.api.user.UserTO;
import org.junit.jupiter.api.Disabled;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.transaction.Transactional;

import static org.testng.Assert.assertNotNull;
@Transactional
@DataJpaTest
@Disabled
public class UserStoreTest  extends AbstractTestNGSpringContextTests {

    @Autowired private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    @InjectMocks
    private UserStore target;

    @Test
    public void getUser() {
        final User user = new User();
        user.setFirstName("pepe");
        user.setFirstName("argento");
        entityManager.persist(user);
        final Long personId = Long.valueOf(String.valueOf(entityManager.getId(user)));
        user.setId(personId);
        entityManager.flush();

        final UserTO response = target.findById(personId);

        assertNotNull(response);
    }
}
