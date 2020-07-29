package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Course;
import com.example.demo.vo.CourseQueryHelper;

/**
 * CourseService
 *
 * @author fyx
 * @date 2020/7/27
 *
 */
public interface CourseService extends IService<Course> {

    byte[] getTextbookPic(String courseNo);

      Page<Course> getCoursePage(CourseQueryHelper helper, Integer pageNo, Integer pageSize);

}
