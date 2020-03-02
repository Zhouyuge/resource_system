package com.bishe.main.jsoup;

import cn.hutool.core.lang.UUID;
import com.bishe.main.dao.HotTopicMapper;
import com.bishe.main.dao.InvitationMapper;
import com.bishe.main.dao.UserMapper;
import com.bishe.main.entity.HotTopic;
import com.bishe.main.entity.Invitation;
import com.bishe.main.entity.User;
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

import java.util.Date;
import java.util.Random;

/**
 * @author Kirito
 * @Date 2020/2/23 16:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.bishe.main.dao")
public class JsoupInvication {

    @Autowired
    private HotTopicMapper hotTopicMapper;

    @Test
    public void test() throws Exception{
        Document doc = Jsoup.connect("https://www.nowcoder.com/discuss").maxBodySize(0).get();
        Elements lis = doc.select("ul[class='list-module side-topic-list']").select("li");
        for (Element li : lis) {
            String hotName = li.select("a[class='list-name']").text();
            String viewNum = li.select("div[class='list-legend']").select("span").get(0).text();
            String userNum = li.select("div[class='list-legend']").select("span").get(1).text();
            HotTopic hotTopic = new HotTopic();
            hotTopic.setCreateTime(new Date());
            hotTopic.setUserNum(Integer.valueOf(userNum.split("\\D")[0]));
            hotTopic.setViewNum(Integer.valueOf(viewNum.split("\\D")[0]));
            hotTopic.setHotName(hotName);
            hotTopicMapper.insertSelective(hotTopic);
        }
    }

    @Autowired
    private InvitationMapper invitationMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test2() throws Exception {
        Document doc = Jsoup.connect("https://www.nowcoder.com/discuss?type=12&order=0").maxBodySize(0).get();
        Elements lis = doc.select("div[class='module-body']").select("ul[class='common-list']").select("li");
        int i = 240;
        for(Element li : lis) {
            i ++;
            Invitation invitation = new Invitation();
            String url = li.select("a").get(1).attr("abs:href");
            doc = Jsoup.connect(url).maxBodySize(0).get();
            Elements headBody = doc.select("div[class='discuss-topic-head']");
            String inviName = headBody.select("h1[class='discuss-title']").select("span[class='js-post-title']").text();
            String label = headBody.select("a").select("span").text();
            Integer agreeNum = Integer.valueOf(headBody.select("div[class='feed-legend']").select("span[class='js-post-like nc-req-auth']").text().split(" ")[1]);
            Integer commentNum = Integer.valueOf(headBody.select("div[class='feed-legend']").select("span[class='feed-legend-num']").get(0).text());
            Integer viewNum = Integer.valueOf(headBody.select("div[class='feed-legend']").select("span[class='feed-legend-num']").get(1).text());
            String content = doc.select("div[class='post-topic-main']").select("div[class='post-topic-des nc-post-content']").toString();
            invitation.setAgreeNum(agreeNum);
            invitation.setCommentNum(commentNum);
            invitation.setCreateTime(new Date());
            invitation.setInvitationContent(content);
            invitation.setInvitationLabel(label);
            invitation.setInvitationType(11);
            invitation.setInvitationName(inviName);
            invitation.setViewNum(viewNum);

            User user = new User();
            user.setUserId(UUID.randomUUID().toString());
            String email = new Random().nextInt(1000000000) + "@qq.com";
            String password = "473f1ed9d91e47786469fd6296ae5e9f";
            String userVisualName = headBody.select("div[class='post-detail']").select("span").select("a").text();
            String picUrl = headBody.select("div[class='discuss-author clearfix']").select("img").attr("abs:src");
            String userImg = "http://localhost:10086/img/h_img/" + PicUtil.downImages2("D://niuke/h_img", picUrl, i);
            user.setUserEmal(email);
            user.setUserPassword(password);
            user.setUserSex(true);
            user.setUserHeadPic(userImg);
            user.setUserVisualName(userVisualName);
            user.setUserName(email);
            userMapper.insertSelective(user);
            invitation.setUserId(user.getUserId());
            invitationMapper.insertSelective(invitation);
        }
    }
}
