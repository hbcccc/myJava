package org.example.withdao.controller;

import org.example.withdao.entity.User;
import org.example.withdao.entity.UserVO;
import org.example.withdao.service.DepartmentService;
import org.example.withdao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/list")
    public ModelAndView list(ModelAndView mav){
        mav.addObject("userList", userService.findAllUsers());
        mav.setViewName("user/userList");
        return  mav;
    }

    @GetMapping("/edit")
    public String edit(HttpServletRequest request, String id) {
        request.setAttribute("user", userService.findById(id));
        // 注意这个地方还要选择部门，要把所有的部门查出来
        request.setAttribute("deptList", departmentService.findDepartments(null));
        return "user/userInfo";
    }


    @PostMapping("/save")
    public String save(@Validated  User user, BindingResult bindingResult, @RequestParam("photo") MultipartFile photoFile) throws IOException {
//        if(bindingResult.hasErrors()){
//            bindingResult.getAllErrors().forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
//            throw new RuntimeException("用户数据格式不正确");
//        }
        if(StringUtils.isEmpty(user.getName()))
            throw new IllegalArgumentException("User的name为空");
        if(bindingResult.hasErrors()){
            throw new RuntimeException("数据格式不正确");
        }
        System.out.println("photos name:"+photoFile.getOriginalFilename());
        user.setPhoto(photoFile.getBytes());
        userService.update(user);
//        System.out.println(user);
        System.out.println(photoFile);
        return  "redirect:/user/list";
    }

    @GetMapping("/getPhoto")
    public ResponseEntity<byte[]> getPhoto(String id) throws UnsupportedEncodingException {
        User user = userService.findById(id);
        byte[] photo = user.getPhoto();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", URLEncoder.encode(user.getUsername() + ".jpg", "utf-8"));
        return new ResponseEntity<>(photo, headers, HttpStatus.CREATED);
    }

    @PostMapping("/batchDelete")
    @ResponseBody
    public String batchDelete(@RequestParam("ids[]") String[] ids){
        System.out.println(Arrays.toString(ids));
        return "success";
    }

    @PostMapping("/batchUpdate")
    public String batchUpdate(UserVO users){
        users.getUsers().forEach(System.out::println);
        return "redirect:/user/list";
    }
}
