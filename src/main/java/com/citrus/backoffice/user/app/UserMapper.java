package com.citrus.backoffice.user.app;

import java.util.List;


import com.citrus.backoffice.shared.domain.User;
import com.citrus.backoffice.shared.ports.APIPort;

public interface UserMapper {

	List<User> getUsers(APIPort port);
	User getUser(APIPort port, long id);

}
