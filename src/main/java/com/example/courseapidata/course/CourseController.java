package com.example.courseapidata.course;

import com.example.courseapidata.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    // delcare this variable need dependency injection
    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllTopics(@PathVariable String topicId){
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping("/topics/{topicId}/curses/{id}")
    public Course getTopic(@PathVariable String id){
        return courseService.getCourse(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/topics/{topicId}/courses")
    public void addTopic(@PathVariable String topicId, @RequestBody Course course){
        course.setTopic(new Topic(topicId, "", ""));
        System.out.println(topicId);
        courseService.addCourse(course);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
    public void updateTopic(@PathVariable String topicId, @RequestBody Course course, @PathVariable String id){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(id, course);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
    public void deleteTopic(@PathVariable String id){
        courseService.deleteCourse(id);
    }

}
