package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoze.course.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * CourseMapper
 *
 * @author fyx
 * @date 2020/7/27
 *
 */
public interface CourseMapper extends BaseMapper<Course> {

    /**
     * ��ȡCourse��ҳ����
     * @param coursePage
     * @param wrapper
     * @return List<Course>
     */
    List<Course> getCourseList(Page<Course> coursePage, @Param("ew") Wrapper<Course> wrapper);

}
