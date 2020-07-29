package com.xiaoze.course.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * CourseQueryHelper
 *
 * @author fyx
 * @date 2020/7/27
 *
 */
@Data
public class CourseQueryHelper implements Serializable {

    private static final long serialVersionUID = -9215712224557205069L;

    private String qryCourseName;
    private Double qryStartPoint;
    private Double qryEndPoint;
    private String qryCourseType;

}
