package com.bishe.main.service.impl;

import com.bishe.main.dao.NoteMapper;
import com.bishe.main.dao.SquareTitleMapper;
import com.bishe.main.entity.Note;
import com.bishe.main.entity.SquareTitle;
import com.bishe.main.service.SquareServer;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author Kirito
 * @Date 2020/4/6 20:02
 */
@Service
public class SquareServerImpl implements SquareServer {

    @Autowired
    private SquareTitleMapper squareTitleMapper;

    private final Integer PAGE_SIZE = 20;

    @Override
    public int getPageNums() {
        Integer count = squareTitleMapper.getCount();
        if (count % PAGE_SIZE == 0) {
            return squareTitleMapper.getCount() / PAGE_SIZE ;
        }else {
            return squareTitleMapper.getCount() / PAGE_SIZE + 1;
        }
    }
    @Override
    public Page<SquareTitle> getSqaureTitles(Integer pageNum) {
        Page<SquareTitle> squareTitles = PageHelper.startPage(pageNum, PAGE_SIZE);
        List<SquareTitle> squareTitleList = squareTitleMapper.selectAll();
        return squareTitles;
    }

    @Override
    public SquareTitle getSquareTitleById(Integer id) {
        SquareTitle squareTitle = squareTitleMapper.selectByPrimaryKey(id);
        if(! "".equals(squareTitle.getTitleContent())) {
            Document document = Jsoup.parse(squareTitle.getTitleContent());
            Elements elements = document.select("li");
            // 表示A,B,C,D的标识
            int i = 0;
            for(Element element : elements){
                i ++;
                element.attr("style", "margin: 20px");
                element.select("pre").prepend("<span>" + (char)(i + 64) + ".</span>");
            }
            squareTitle.setTitleContent(document.toString());
        }
        return squareTitle;
    }

    @Override
    public Integer insertSquare(SquareTitle squareTitle) {
        squareTitle.setTitleHard(new Random().nextInt(5) + 1);
        squareTitle.setTitleLabels("笔试题");
        return squareTitleMapper.insertSelective(squareTitle);
    }

    @Autowired
    private NoteMapper noteMapper;

    @Override
    public int addNote(Note note) {
        return noteMapper.insertSelective(note);
    }

    @Override
    public int deleteNode(Integer id) {
        return noteMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Note getNote(HashMap<String, Object> params) {
        return noteMapper.getNoteByTilteIdAndUserId(params);
    }
}
