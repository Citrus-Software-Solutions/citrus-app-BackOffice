package com.citrus.backoffice.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.citrus.backoffice.shared.domain.User;
import com.citrus.backoffice.user.app.UserServiceMock;

public class UserListTest {
	UserServiceMock mock1;
	List<User> mock2 = mock1.getUsers();
	
	@Test
	void test() {
		
		for (int i=0;i<=10;i++)
		assertNotNull(mock2.get(i));
	}

	

	
	
}
