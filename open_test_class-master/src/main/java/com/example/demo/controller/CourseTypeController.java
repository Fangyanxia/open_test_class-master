package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.CourseType;
import com.example.demo.service.CourseTypeService;
import java.util.Map;

/**
 * CourseTypeController
 *
 * @author xiaoze
 * @date 2020/7/27
 *
 */
@Controller
@RequestMapping("/courseType")
public class CourseTypeController {

    @Autowired
    private CourseTypeService courseTypeService ;

    @Autowired
    private CourseService courseService ;

    /**
     * ���ʿγ������������
     */
    @GetMapping("/toInput")
    public String input(Map<String, Object> map) {
        map.put("courseType", new CourseType());

        return "courseType/input_course_type";
    }

    /**
     * �����¿γ�����
     */
    @PostMapping(value="/create")
    public String create(CourseType courseType) {

        courseTypeService.save(courseType);

        return "redirect:/courseType/list";

    }

    @GetMapping("/list")
    public String list(Map<String, Object> map, @RequestParam(value="pageNo", required=false, defaultValue="1") String pageNoStr) {

        int pageNo = 1;

        //�� pageNo ��У��
        pageNo = Integer.parseInt(pageNoStr);
        if(pageNo < 1){
            pageNo = 1;
        }

        /*
         * ��һ���������ڼ�ҳ;
         * �ڶ���������ÿҳ��ȡ������.
         */
        Page<CourseType> page = new Page<>(pageNo,3);
        IPage<CourseType> iPage = courseTypeService.page(page,
                new LambdaQueryWrapper<CourseType>()
                        .orderByAsc(CourseType::getTypeId)
        );

        map.put("page", iPage);

        return "courseType/list_course_type";
    }

    @DeleteMapping(value="/remove/{typeId}")
    public String remove(@PathVariable("typeId") Integer typeId) {

        courseTypeService.deleteCourseType(typeId);

        return "redirect:/courseType/list";
    }

    @GetMapping(value="/preUpdate/{typeId}")
    public String preUpdate(@PathVariable("typeId") Integer typeId, Map<String, Object> map) {

        map.put("courseType", courseTypeService.getById(typeId));

        return "courseType/update_course_type";
    }

    @PutMapping(value="/update")
    public String update(CourseType courseType) {

        courseTypeService.updateById(courseType);

        return "redirect:/courseType/list";
    }

}
