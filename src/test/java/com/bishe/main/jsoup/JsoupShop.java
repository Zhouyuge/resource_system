package com.bishe.main.jsoup;

import com.bishe.main.dao.CoinWareMapper;
import com.bishe.main.entity.CoinWare;
import com.bishe.main.util.PicUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author Kirito
 * @Date 2019/11/13 10:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.bishe.main.dao")
public class JsoupShop {
    @Autowired
    private CoinWareMapper coinWareMapper;

    @Test
    public void test() throws IOException {
        String url = "https://www.nowcoder.com/coin/index?affordable=false";
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
        Elements goods = doc.select("dl[class='mall-goods-list']");
        int typeId = 1;
        for (Element good : goods) {
            Elements wares = good.select("dd[class='js-product']");
            for (Element ware : wares) {
                CoinWare coinWare = new CoinWare();
                int price = Integer.parseInt(ware.select("div[class='goods-tag']").text());
                String picUrl = ware.select("div[class='goods-img']").select("img").attr("abs:src");
                String name = ware.select("div[class='goods-name']").text();
                String coinUrl = "http://localhost:10086/img/wareImg/" + PicUtil.downImages("D://niuke//wareImg//", picUrl);
                coinWare.setCoinWareName(name);
                coinWare.setCoinWarePrice(price);
                coinWare.setCoinWareType(typeId);
                coinWare.setCoinWareNum(10);
                coinWare.setCoinWareBigPic(coinUrl);
                coinWareMapper.insertSelective(coinWare);
            }
            typeId++;
        }
    }


    @Test
    public void test1() throws IOException {
        String url = "https://search.jd.com/Search?keyword=手机&enc=utf-8&wq=手机&pvid=d493c4d6c2d14a8f83a8b848cfa1d44d";
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
        Elements lis = doc.select("ul[class='gl-warp clearfix']").select("li[class='gl-Item']");
        System.out.println(lis.size());
        for(Element li : lis){
            System.out.println(li.select("div[class='p-name p-name-type-2']").select("a").select("em").text());
        }
    }
}

