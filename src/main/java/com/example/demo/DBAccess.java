package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface DBAccess extends CrudRepository<Name, String> {

}
