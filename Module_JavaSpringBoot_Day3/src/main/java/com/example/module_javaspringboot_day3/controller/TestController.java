package com.example.module_javaspringboot_day3.controller;

import com.example.module_javaspringboot_day3.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.time.Instant;
import java.util.Arrays;

@Controller
public class TestController {
    @Autowired
    TestRepository testRepository;

    @Value("${config.upload_folder}")
    String UPLOAD_FOLDER;

    @GetMapping("/set-cookie")
    public String setCookie(HttpServletResponse response, HttpSession session){
//        Cookie cookie = new Cookie("key","Valuecookie01");
//        response.addCookie(new Cookie("key1","value1"));
//        response.addCookie(new Cookie("key2","value2"));
//        response.addCookie(new Cookie("key3","value3"));
//        response.addCookie(cookie);
        session.setAttribute("keysession2","HaiPhong2");
        session.setMaxInactiveInterval(50);

        return "index";
    }
    @GetMapping("/get-cookie")
    public String getCookie(@CookieValue(value = "key") String valueCookie, HttpServletRequest request,HttpSession session){
//        Cookie[] cookies = request.getCookies();
//        System.out.println(valueCookie);
//        Arrays.stream(cookies).forEach(c -> System.out.println(c.getName()));
//        System.out.println(session.getAttribute("keysession"));

        session.getAttribute("keysession2");
        session.getLastAccessedTime();
        return "index";
    }
    @PostMapping("/uploadfile")
    public String upload(@RequestParam("fileImage") MultipartFile file){
        String filePath = null;
        File checkDir = new File(UPLOAD_FOLDER);
        Path uploadFilePath = Paths.get("./images/");
//        System.out.println(uploadFilePath);
        if (!checkDir.exists() || checkDir.isFile()){
            checkDir.mkdir();
        }
        filePath = Instant.now().getEpochSecond() + file.getOriginalFilename();
        System.out.println(filePath);
        try {
            Files.write(Paths.get(UPLOAD_FOLDER + filePath), file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }





}
