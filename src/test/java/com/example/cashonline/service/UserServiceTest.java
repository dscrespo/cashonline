package com.example.cashonline.service;

import com.example.cashonline.persistence.store.UserStore;
import com.example.cashonline.pojo.api.user.UserTO;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@Test
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserStore userStore;

    @BeforeClass
    public void beforeClass() {

        MockitoAnnotations.openMocks(this);
        reset(userStore);
    }

    @DataProvider
    public Object[][] dataProvider() {
        UserTO userTO = new UserTO();
        userTO.setFirstName("pepe");
        userTO.setLastName("argento");
        return new Object[][]{{userTO}};
    }

    @Test
    public void getUser() {
        userService.findById(1);
        verify(userStore, times(1)).findById(1);
    }

    @Test(dataProvider = "dataProvider")
    public void createUser(final UserTO userTO) {
        userService.createUSer(userTO);
        verify(userStore, times(1)).createUSer(userTO);
    }

    @Test
    public void deleteUser() {
        userService.deleteUserById(1);
        verify(userStore, times(1)).deleteUserById(1);
    }
}
