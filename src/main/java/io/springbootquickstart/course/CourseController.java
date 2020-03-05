package io.springbootquickstart.course;

import io.springbootquickstart.data.Course;
import io.springbootquickstart.data.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId) {
        return courseService.getAllCourses(topicId);
    }
    @RequestMapping("/courses/{id}")
    public Course getCourse(@PathVariable String id) { return courseService.getCourse(id);}


    @RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.POST)
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.upsertCourse(course);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.PUT)
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id)  {
        course.setTopic(new Topic(topicId, "",""));
        courseService.upsertCourse(course);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }
}
