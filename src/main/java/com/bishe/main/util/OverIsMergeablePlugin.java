package com.bishe.main.util;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author Kirito
 * @Date 2019/6/1710:19
 */
public class OverIsMergeablePlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> list) {
        return true;
    }
    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile generatedXmlFile, IntrospectedTable introspectedTable){
        try{
            Field field = generatedXmlFile.getClass().getDeclaredField("isMergeable");
            field.setAccessible(true);
            field.setBoolean(generatedXmlFile, false);
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
