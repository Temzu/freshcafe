package com.temzu.freshcafe.dao.impl;

import com.temzu.freshcafe.dao.RoleDao;
import com.temzu.freshcafe.dao.UserDao;
import com.temzu.freshcafe.entities.Role;
import com.temzu.freshcafe.entities.User;
import com.temzu.freshcafe.exceptions.ResourceAlreadyExistsException;
import com.temzu.freshcafe.exceptions.ResourceNotFoundException;
import com.temzu.freshcafe.exceptions.UserLoginOrPasswordException;
import com.temzu.freshcafe.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

  private final UserRepository userRepository;
  private final RoleDao roleDao;
  private final PasswordEncoder passwordEncoder;

  @Override
  public User save(User user) {
    String login = user.getLogin();
    String email = user.getEmail();

    if (userRepository.existsByLogin(login)) {
      throw ResourceAlreadyExistsException.byLogin(login, User.class);
    }

    if (userRepository.existsByEmail(email)) {
      throw ResourceAlreadyExistsException.byEmail(email, User.class);
    }

    Role role = roleDao.findByName("ROLE_USER");
    user.setRoles(List.of(role));
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }

  @Override
  public User findByLogin(String login) {
    return userRepository
        .findByLogin(login)
        .orElseThrow(() -> ResourceNotFoundException.byLogin(login, User.class));
  }

  @Override
  public User findByEmail(String email) {
    return userRepository
        .findByEmail(email)
        .orElseThrow(() -> ResourceNotFoundException.byEmail(email, User.class));
  }

  @Override
  public User findByLoginAndPassword(String login, String password) {
    return Optional.of(findByEmail(login))
        .filter(user -> passwordEncoder.matches(password, user.getPassword()))
        .orElseThrow(UserLoginOrPasswordException::new);
  }

  @Override
  public User update(User user) {
    return userRepository.save(user);
  }

  @Override
  public void updatePass(String newPass, String currentUser) {
    User byLogin = findByLogin(currentUser);
    byLogin.setPassword(passwordEncoder.encode(newPass));
    userRepository.save(byLogin);
  }
}
