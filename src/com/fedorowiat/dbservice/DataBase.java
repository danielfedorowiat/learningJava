package com.fedorowiat.dbservice;

import com.fedorowiat.user.User;

import java.sql.SQLException;
import java.util.List;

public interface DataBase {
  String getEmail(String email);
  void setUser(User user);
}
