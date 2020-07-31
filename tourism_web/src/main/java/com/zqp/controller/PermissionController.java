package com.zqp.controller;


import com.zqp.domain.Permission;
import com.zqp.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/findAllPermissions")
    public ModelAndView findAllPermissions(){
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> allPermissions = permissionService.findAllPermissions();
        modelAndView.addObject("permissionList",allPermissions);
        modelAndView.setViewName("permission-list");

        return modelAndView;
    }


    @RequestMapping("gotoAdd")
    public ModelAndView gotoAdd(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("permission-add");
        return modelAndView;

    }

    @RequestMapping("savePermission")
    public String savePermission(Permission permission){

        ModelAndView modelAndView = new ModelAndView();
        permissionService.savePermission(permission);

        return "redirect:/permission/findAllPermissions";

    }

    /*@RequestMapping("/findPermissionById")
    public ModelAndView findPermissionById(@RequestParam("id") int id){

        ModelAndView modelAndView = new ModelAndView();
        permissionService.findPermissionById(id);

        return


    }*/
}
