package com.company;

import java.util.List;

public interface CourseDao {

    public void store(Course course);
    public void delete(Integer courseId);
    public Course findById(Integer courseId);
    public List<Course> findAll();

}
