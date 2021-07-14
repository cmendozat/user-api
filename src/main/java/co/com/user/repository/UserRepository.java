package co.com.user.repository;

import co.com.user.model.User;

public interface UserRepository {
    User getUserByEmail(String email);
}
