package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Repository
public class StudentDAOImplement implements StudentDAO {

    // define field for entity manager

    private EntityManager entityManager;


    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImplement(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method

    @Override
    @Transactional
    public void save(Student theStudent) {

        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer Id) {
        return entityManager.find(Student.class,Id);
    }

    @Override
    public List<Student> findAll() {

        // create the query for getting all the Students
        //TypedQuery<Student> theQuery=entityManager.createQuery("from Student", Student.class);

        // create the query for getting all the Students based on their last name
        TypedQuery<Student> theQuery=entityManager.createQuery("from Student order by lastName asc", Student.class);

        // return query results
        return theQuery.getResultList();
    }
}





