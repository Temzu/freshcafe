package com.temzu.freshcafe.dao;

import com.temzu.freshcafe.entities.Role;

public interface RoleDao {

  Role findByName(String name);
}
