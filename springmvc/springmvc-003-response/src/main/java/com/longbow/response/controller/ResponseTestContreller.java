package com.longbow.response.controller;

import com.longbow.response.beans.Address;
import com.longbow.response.beans.Person;
import com.longbow.response.beans.Person2;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.URLEncoder;

@RestController
public class ResponseTestContreller {

    @RequestMapping("/resp01")
    public Person2 resp01() {
        Person2 person2 = new Person2();
        person2.setUsername("zhangsan");
        person2.setSex("男");
        person2.setAgreement(true);
        person2.setCellphone("123321545");
        person2.setGrade("二年级");
        person2.setHobby(new String[] {"篮球", "足球"});
        person2.setPassword("123456");
        return person2;
    }

    @RequestMapping("/download")
    public ResponseEntity<InputStreamResource> resp02() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\图片\\素材\\控笔训练练习\\控笔训练练习\\控笔练习2.jpg");

        byte[] bytes = fileInputStream.readAllBytes();

        //文件名为中文会乱码
        String encode = URLEncoder.encode("哈哈美女.jpg", "UTF-8");
        //文件太大会oom（内存溢出）
        InputStreamResource inputStreamResource = new InputStreamResource(fileInputStream);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(fileInputStream.available())
                .header("Content-Disposition", "attachment;filename="+encode)
                .body(inputStreamResource);
    }
}
