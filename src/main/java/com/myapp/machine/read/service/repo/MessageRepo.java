package com.myapp.machine.read.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Messages, Long>  {

}
