package com.fedorowiat.dbservice;

import com.fedorowiat.exception.UserNotFoundException;
import com.fedorowiat.user.User;

import java.sql.SQLException;
import java.util.List;

public interface DataBase {
  boolean checkEmailIsExist(String email);
  void saveUser(User user);
  String getAccessLevel(String login, String password) throws UserNotFoundException;
}
