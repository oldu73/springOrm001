package com.company;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CourseDao courseDao = new HibernateCourseDao();
        Course course = new Course();
        course.setTitle("Les fondamentaux de Spring");

        Calendar cal = Calendar.getInstance();

        Date dateUtil = cal.getTime();
        java.sql.Date dateSql = dateUtilToDateSql(dateUtil);

        course.setBeginDate(dateSql);

        cal.add(Calendar.MONTH, 3);

        dateUtil = cal.getTime();
        dateSql = dateUtilToDateSql(dateUtil);

        course.setEndDate(dateSql);

        course.setFee(1000);
        courseDao.store(course);

        List<Course> courses = courseDao.findAll();
        Integer courseId = courses.get(0).getId();

        course = courseDao.findById(courseId);

        System.out.println("Nom formation: " + course.getTitle());
        System.out.println("Début: " + course.getBeginDate());
        System.out.println("Fin: " + course.getEndDate());
        System.out.println("Prix: " + course.getFee());

        courseDao.delete(courseId);
    }

    private static java.sql.Date dateUtilToDateSql(Date date) {
        // SRC: https://examples.javacodegeeks.com/core-java/util/date/java-util-date-to-java-sql-date/
        return new java.sql.Date(date.getTime());
    }

}
