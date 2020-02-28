package com.blog.liang.notes.dao;

import com.blog.liang.notes.entity.Picture;

import java.util.List;

public interface UploadDao {
    List<Picture> getAllPicture();

    String addPicName(String finalName);
}
