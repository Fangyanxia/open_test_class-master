package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.CourseType;

/**
 * CourseTypeService
 *
 * @author fyx
 * @date 2020/7/27
 *
 */
public interface CourseTypeService extends IService<CourseType> {

    /**
     * 根据课程类型删除对应的课程
     * @param typeId
     */
    void deleteCourseType(Integer typeId);

}
