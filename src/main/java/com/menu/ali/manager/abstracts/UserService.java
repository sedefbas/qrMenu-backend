package com.menu.ali.manager.abstracts;

import com.menu.ali.Model.User;
import com.menu.ali.core.results.Result;

public interface UserService extends BaseEntityService<User> {
 Result updateNewPassword(int userId,String newPassword);
}
