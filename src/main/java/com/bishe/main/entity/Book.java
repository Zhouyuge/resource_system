package com.bishe.main.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Book {
    private Integer bookId;

    private String bookName;

    private String bookAuthor;

    private String bookPrice;

    private String bookCode;

    private String bookPress;

    private Date bookTime;

    private Integer bookRecomendNum;

    private String bookPic;

    private String bookLevel;

    private Date createTime;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor == null ? null : bookAuthor.trim();
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice == null ? null : bookPrice.trim();
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode == null ? null : bookCode.trim();
    }

    public String getBookPress() {
        return bookPress;
    }

    public void setBookPress(String bookPress) {
        this.bookPress = bookPress == null ? null : bookPress.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    public Date getBookTime() {
        return bookTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }

    public Integer getBookRecomendNum() {
        return bookRecomendNum;
    }

    public void setBookRecomendNum(Integer bookRecomendNum) {
        this.bookRecomendNum = bookRecomendNum;
    }

    public String getBookPic() {
        return bookPic;
    }

    public void setBookPic(String bookPic) {
        this.bookPic = bookPic == null ? null : bookPic.trim();
    }

    public String getBookLevel() {
        return bookLevel;
    }

    public void setBookLevel(String bookLevel) {
        this.bookLevel = bookLevel == null ? null : bookLevel.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}