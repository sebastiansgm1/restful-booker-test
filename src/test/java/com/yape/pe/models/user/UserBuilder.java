package com.yape.pe.models.user;

public final class UserBuilder {

  private String username;
  private String password;

  private UserBuilder() {
  }

  public static UserBuilder anUser() {
    return new UserBuilder();
  }

  public UserBuilder withUsername(String username) {
    this.username = username;
    return this;
  }

  public UserBuilder withPassword(String password) {
    this.password = password;
    return this;
  }

  public User build() {
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    return user;
  }
}
