package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;

import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{

    //define field for entity manager

    //inject entity manager using constructor injection

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
            this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
            entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
            return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        // retrieve the instructor
        InstructorDetail theInstructor = entityManager.find(InstructorDetail.class, theId);
        //delete the instructor
        entityManager.remove(theInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail theInstructorDetail = entityManager.find(InstructorDetail.class, theId);
        theInstructorDetail.getInstructor().setInstructorDetail(null);  //buradaki kod instructor içindeki instructordetail foreign keyini null yapar ve bi alt satırdakide detail i siler
        entityManager.remove(theInstructorDetail);
    }
}
