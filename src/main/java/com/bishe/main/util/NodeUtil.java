package com.bishe.main.util;

import com.bishe.main.entity.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kirito
 * @Date 2020/2/29 10:56
 */
public class NodeUtil {
    public static List<Comment> getConvertNodes(List<Comment> list){
        // 各节点间建立连接关系
        connectNodes(list);
       //  获取所有的根节点
        List<Comment> rootNodes = getRootNodes(list);
        // 建立空链表， 存储排序后的节点
        List<Comment> resultList = new ArrayList<>();
        for (int i = 0; i < rootNodes.size(); i++ ){
            // 递归添加节点
            addNodeToResult(resultList, rootNodes.get(i));
        }
        return rootNodes;
    }

    public static void connectNodes(List<Comment> list) {
        // 各节点间建立连接关系
        for (int i = 0; i < list.size() - 1; i++) {
            Comment nodeLast = list.get(i);
            List<Comment> children = new ArrayList<>();
            for(int j = i + 1; j < list.size(); j++) {
                Comment nodeNext = list.get(j);
                if(nodeNext.getParentId() == nodeLast.getId()) {
                    children.add(nodeNext);
                }
            }
            nodeLast.setChildren(children);
        }
    }

    private static List<Comment> getRootNodes(List<Comment> list){
        // 获取所有的根节点
        List<Comment> rootList = new ArrayList<>();
        int length = list.size();
        for (int i = 0; i < length; i++) {
            if(list.get(i).isRoot()) {
                rootList.add(list.get(i));
            }
        }
        return rootList;
    }

    private static void addNodeToResult(List<Comment> result, Comment comment) {
        // 递归添加节点
        result.add(comment);
        if (comment.isLeaf()) {
            return;
        }
        List<Comment> list = comment.getChildren();
        for(int i = 0; i < list.size(); i ++) {
            addNodeToResult(result, list.get(i));
        }
    }

}
