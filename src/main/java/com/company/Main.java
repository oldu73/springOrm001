package com.company;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        CourseDao courseDao = new HibernateCourseDao();
        Course course = new Course();
        course.setTitle("Les fondamentaux de Spring");

        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();

        java.sql.Date sqlDate = new java.sql.Date(date);

        
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println("utilDate:" + utilDate);
        System.out.println("sqlDate:" + sqlDate);


        java.sql.Date sqlDate = new java.sql.Date(date);

        Timestamp timestamp = new Timestamp(date.getTime());


        course.setBeginDate(timestamp.getTime());
        cal.add(Calendar.MONTH, 1);
        result = cal.getTime();
        course.setEndDate(java.sql.Date.valueOf(String.valueOf(result)));

        course.setFee(1000);
        courseDao.store(course);
    }
}
