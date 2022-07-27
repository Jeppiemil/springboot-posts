package com.sparta.homework.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostRequestDto {
    private String author;
    private String title;
    private String content;
    private String password;

    public PostRequestDto(String author, String title, String content, String password){
        this.author = author;
        this.title = title;
        this.content = content;
        this.password = password;
    }
}
