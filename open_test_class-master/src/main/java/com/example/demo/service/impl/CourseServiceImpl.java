package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Course;
import com.example.demo.mapper.CourseTypeMapper;
import com.example.demo.service.CourseService;
import com.example.demo.vo.CourseQueryHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.mapper.CourseMapper;
import java.util.List;

/**
 * CourseServiceImpl
 *
 * @author fyx
 * @date 2020/7/27
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    CourseTypeMapper courseTypeMapper;

    @Override
    public byte[] getTextbookPic(String courseNo) {

        Course course = baseMapper.selectById(courseNo);

        if(course.getCourseTextbookPic() != null){
            return course.getCourseTextbookPic();
        }

        return null;

    }

    @Override
    public Page<Course> getCoursePage(CourseQueryHelper helper, Integer pageNo, Integer pageSize) {

        Page<Course> page = new Page<>(pageNo,pageSize);
        QueryWrapper<Course> courseWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(helper.getQryCourseName())){
            courseWrapper.like("course_name", helper.getQryCourseName());
        }
        if(helper.getQryStartPoint()!=null){
            courseWrapper.lambda().ge(Course::getCoursePoint, helper.getQryStartPoint());
        }

        if(helper.getQryEndPoint()!=null){
            courseWrapper.lambda().le(Course::getCoursePoint, helper.getQryEndPoint());
        }

        if(StringUtils.isNotEmpty(helper.getQryCourseType())){
            courseWrapper.like("type_id", Integer.parseInt(helper.getQryCourseType()));
        }

        List<Course> courseList = baseMapper.getCourseList(page, courseWrapper);

        courseList.forEach(course ->
                course.setCourseType(courseTypeMapper.selectById(course.getTypeId()))
        );

        if(CollectionUtils.isNotEmpty(courseList)){
            page.setRecords(courseList);
            return page;
        }

        return new Page<>();
    }

}
