package com.longbow.springmvc.controller;

import com.longbow.springmvc.beans.Person;
import com.longbow.springmvc.beans.Person2;
import jakarta.servlet.annotation.HandlesTypes;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.midi.Soundbank;
import java.io.InputStream;

@RestController
public class RequestTestController {


    @RequestMapping("handle01")
    public String handle01(String username,
                           String password,
                           String cellphone,
                           boolean agreement) {

        System.out.println(username);
        System.out.println(password);
        System.out.println(cellphone);
        System.out.println(agreement);

        return "ok";
    }

    @RequestMapping("handle02")
    public String handle02(@RequestParam("username") String name,
                           @RequestParam("password") String psw,
                           @RequestParam(value = "cellphone", defaultValue = "123456") String phone,
                           @RequestParam(value = "agreement", required = false) boolean ok) {

        System.out.println("-------------");
        System.out.println(name);
        System.out.println(psw);
        System.out.println(phone);
        System.out.println(ok);

        return "ok";
    }

    @RequestMapping("handle03")
    public String handle03(Person person) {
        System.out.println(person);

        return "ok";
    }

    @RequestMapping("handle04")
    public String handle04(@RequestHeader("host") String host) {
        System.out.println(host);

        return "ok";
    }

    @RequestMapping("handle05")
    public String handle05(@CookieValue("test") String cookie) {
        System.out.println(cookie);

        return "ok" + cookie;
    }

    @RequestMapping("handle06")
    public String handle06(Person2 person2) {
        System.out.println(person2);
        return "ok";
    }

    @RequestMapping("handle07")
    public String handle07(@RequestBody Person2 person2) {
        System.out.println(person2);
        return "ok";
    }

    @RequestMapping("handle08")
    public String handle08(@RequestParam("headerImg") MultipartFile multiHeaderImgFile,
                           @RequestParam("lifeImg") MultipartFile[] multiLifeImgFile) {

        String originalFilename = multiHeaderImgFile.getOriginalFilename();
        System.out.println(originalFilename);
        long size = multiHeaderImgFile.getSize();
        System.out.println(size);

        System.out.println("===================");

        for (MultipartFile multipartFile : multiLifeImgFile) {
            System.out.println(multipartFile.getOriginalFilename());
            System.out.println(multipartFile.getSize());
        }


        return "ok";
    }
}
