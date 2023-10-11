package com.udemyspringboot.photoapp.api.users.data;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepo extends CrudRepository<UserEntity, Long>{
    UserEntity findByEmail(String email);
}
