package com.bishe.main.jsoup;

import lombok.Data;

/**
 * @author Kirito
 * @Date 2019/11/18 13:59
 */

public class Item2 extends Item{
    private Item item;
    Item2(Item item){
        this.item = item;
    }
    public Integer getTcount() {
        //item.ss()
        return item.getTcount();
    }

    public Integer getRcount() {
        return item.getRcount();
    }

    public Integer getId() {
        return item.getId();
    }

    public String getTitle() {

        String ss = item.getTitle();
        return ss.toUpperCase();
    }

    public void setTcount(Integer tcount) {
        try{
            item.setTcount(tcount);
        } catch (Exception e) {
            System.out.println(item.getTitle());
            e.printStackTrace();
        }

    }

    public void setRcount(Integer rcount) {
        item.setRcount(rcount);
    }

    public void setId(Integer id) {
        item.setId(id);
    }

    public void setTitle(String title) {
        item.setTitle(title);
    }

    public boolean canEqual(Object other) {
        return item.canEqual(other);
    }
}
