package com.xjc.code.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/api")
public class UserController {
    @GetMapping("hello")
    public String hello() {
        return "hello, user";
    }
    /*@Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<SysUser> list = userService.findAll();
        model.addAttribute("list", list);
        return "user-list";
    }

    @RequestMapping("/save")
    public String save(SysUser user){
        userService.save(user);
        return "redirect:findAll";
    }

    @RequestMapping("/toAddRolePage")
    public String toAddRolePage(Model model, Integer id, boolean success){
        Map<String, Object> map = userService.toAddRolePage(id);
        model.addAttribute("uid", id);
        model.addAttribute("allRoles", map.get("allRoles"));
        model.addAttribute("myRoles", map.get("myRoles"));
        if(success){
            model.addAttribute("success", "修改成功");
        }
        return "user-role-add";
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(Integer[] ids, Integer userId){
        userService.addRoleToUser(userId, ids);
        return "redirect:toAddRolePage?success="+true+"&id="+userId;
    }
*/

}
