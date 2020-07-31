package com.zqp.controller;


import com.zqp.domain.Role;
import com.zqp.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAllRoles")
    public ModelAndView findAllRoles(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> allRoles = roleService.findAllRoles();
        modelAndView.addObject("roleList",allRoles);
        modelAndView.setViewName("role-list");

        return modelAndView;
    }

    @RequestMapping("/saveRole")
    public String saveRole(Role role){
        ModelAndView modelAndView = new ModelAndView();
        roleService.saveRole(role);



        return "redirect:/role/findAllRoles";
    }


    @RequestMapping("/gotoAdd")
    public ModelAndView gotoAdd(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("role-add");

        return modelAndView;
    }


    @RequestMapping("/findRoleById")
    public ModelAndView findRoleByRoleId(@RequestParam("id") int id){

        ModelAndView modelAndView = new ModelAndView();
        Role role = roleService.findRoleByRoleId(id);
        modelAndView.addObject("role", role);
        modelAndView.setViewName("role-show");

        return modelAndView;


    }


    @RequestMapping("/deleteRoleById")
    public String deleteRoleByRoleId(@RequestParam("id") int id){

        roleService.deleteRoleById(id);

        return "redirect:/role/findAllRoles";

    }

}
