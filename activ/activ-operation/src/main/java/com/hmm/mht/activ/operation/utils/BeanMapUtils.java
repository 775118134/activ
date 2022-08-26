package com.hmm.mht.activ.operation.utils;

import cn.hutool.core.collection.CollectionUtil;
import org.springframework.cglib.beans.BeanMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author hmm
 * @date 2021/6/22 10:42
 * @Description:
 */
public class BeanMapUtils {
    public static <T> T mapToBean(Map map, Class<T> beanClass) {
        T bean = null;
        if (CollectionUtil.isNotEmpty(map)) {
            try {
                bean = beanClass.newInstance();
                BeanMap beanMap = BeanMap.create(bean);
                beanMap.putAll(map);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bean;
    }

    public static Map<String, Object> beanToMap(Object object, boolean retainNull) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (object != null) {
            BeanMap beanMap = BeanMap.create(object);

            Set<Map.Entry<String, Object>> set = beanMap.entrySet();
            if (retainNull) {
                set.stream().forEach((entry) -> {
                    map.put(entry.getKey(), entry.getValue());
                });
            } else {
                set.stream().forEach((entry) -> {
                    if (entry.getValue() != null) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                });
            }

        }
        return map;
    }

    public static Map<String, Object> beanToMap(Object object) {
        return beanToMap(object, true);
    }
}
