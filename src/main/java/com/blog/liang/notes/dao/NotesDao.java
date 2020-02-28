package com.blog.liang.notes.dao;

import com.blog.liang.notes.entity.Notes;
import com.blog.liang.notes.entity.Tag;

import java.util.List;

public interface NotesDao {
    List<Tag> getAllTags();

    List<Notes> getALLNotes();

    String updateContent(Notes notes);

    String updateKeyword(Notes notes);

    String addNote(Notes notes);

    String addTag(Tag tag);

    List<Notes> searchNotes(String search);

}
