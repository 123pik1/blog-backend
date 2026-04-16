package com.pik.database.repository;

import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pik.database.entities.Photo;
import com.pik.database.repository.core.GenericRepository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

}
