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

    // �γ̱��
    @TableId(value = "course_no", type = IdType.UUID)
    private String courseNo;

    // �γ�����
    @TableField("course_name")
    private String courseName;
 
    // �γ�����Id
    private Integer typeId;

    // ��ע˵��
    private String courseMemo;
    /**
     * ��һ��ϵ
     */
    @TableField(exist = false)
    private CourseType courseType;

}
