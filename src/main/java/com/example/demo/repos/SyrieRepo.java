package com.example.demo.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Product;
import com.example.demo.models.Syrie;
public interface SyrieRepo extends JpaRepository <Syrie,Integer>{


	
}
