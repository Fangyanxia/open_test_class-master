package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * course
 *
 * @author fyx
 * @date 2020/07/27
 *
 */
@Data
@TableName("tbl_course")
public class Course implements Serializable{

    private static final long serialVersionUID = 5421990434228550815L;

    // 课程编号
    @TableId(value = "course_no", type = IdType.UUID)
    private String courseNo;

    // 课程名称
    @TableField("course_name")
    private String courseName;
 
    // 课程类型Id
    private Integer typeId;

    // 备注说明
    private String courseMemo;
    /**
     * 对一关系
     */
    @TableField(exist = false)
    private CourseType courseType;

}
