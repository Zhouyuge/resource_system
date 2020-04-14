package com.bishe.main.service;

import com.bishe.main.entity.Note;
import com.bishe.main.entity.SquareTitle;
import com.github.pagehelper.Page;

import java.util.HashMap;

/**
 * @author Kirito
 * @Date 2020/4/6 20:01
 */
public interface SquareServer {

    int getPageNums();

    Page<SquareTitle> getSqaureTitles(Integer pageNum);

    SquareTitle getSquareTitleById(Integer id);

    Integer insertSquare(SquareTitle squareTitle);

    int addNote(Note note);

    int deleteNode(Integer id);

    Note getNote(HashMap<String, Object> params);
}
