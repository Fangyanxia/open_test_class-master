package com.example.demoservice.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Course;
import com.example.demo.entity.CourseType;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.mapper.CourseTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demoservice.CourseTypeService;

import java.util.List;

/**
 * CourseTypeServiceImpl
 *
 * @author fyx
 * @date 2020/7/27
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CourseTypeServiceImpl extends ServiceImpl<CourseTypeMapper, CourseType> implements CourseTypeService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public void deleteCourseType(Integer typeId) {

        courseMapper.delete(
                new LambdaQueryWrapper<Course>()
                        .eq(Course::getTypeId, typeId)
        );
        baseMapper.deleteById(typeId);

    }
}
