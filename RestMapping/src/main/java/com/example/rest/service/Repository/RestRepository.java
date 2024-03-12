package com.example.rest.service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.ctrl.entity.Book;

@Repository
public interface RestRepository extends JpaRepository<Book, Long>{
	


}
