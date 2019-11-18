package com.bishe.main.util;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author Kirito
 * @Date 2019/7/19 11:11
 * DTO与entity实体类之间的反射映射
 */
public class AutoMapperUtil {
    /**
     * 单类反射映射
     *
     * @param source
     * @param destination
     * @param <TSource>
     * @param <TDestination>
     */
    public static <TSource, TDestination> void mapping(TSource source, TDestination destination) throws IllegalArgumentException {
        Method[] srcMethods = source.getClass().getMethods();   //获取原有类的方法
        Method[] destMethods = destination.getClass().getMethods(); //获取目标类的方法
        for (Method m : srcMethods) {
            String srcMethodName = m.getName();
            if (srcMethodName.startsWith("get")) {   //调用get方法
                try {
                    Object getValue = m.invoke(source);    //获取当前方法返回值
                    for (Method dm : destMethods) {
                        String destMethodName = dm.getName();   //目标方法
                        //当目标方法为set且目标方法字段与原方法字段相同时
                        if (destMethodName.startsWith("set") && destMethodName.substring(3, destMethodName.length()).equals(srcMethodName.substring(3, srcMethodName.length()))) {
                            dm.invoke(destination, getValue);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    /**
     * 列表反射映射
     *
     * @param src
     * @param target
     * @param targetClass
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> List<T> mappingList(List<S> src, List<T> target, Class<?> targetClass) {
        for (int i = 0; i < src.size(); i++) {
            try {
                Object object = targetClass.newInstance();
                target.add((T) object);
                mapping(src.get(i), object);
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }
        }
        return target;
    }

}
