package io.springbootquickstart.course;

import io.springbootquickstart.data.Course;
import io.springbootquickstart.data.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course getCourse(String id) {
        Optional<Course> courseById = courseRepository.findById(id);
        return courseById.orElse(null);
    }

    public List<Course> getAllCourses(String topicId) {
        return new ArrayList<>(courseRepository.findByTopicId(topicId));
    }

    public void upsertCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
