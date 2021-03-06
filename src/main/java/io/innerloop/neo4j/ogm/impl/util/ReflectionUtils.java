package io.innerloop.neo4j.ogm.impl.util;

import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by markangrish on 20/02/2015.
 */
public class ReflectionUtils
{

    public static Iterable<Field> getAllFields(Class<?> clazz)
    {

        List<Field> currentClassFields = Lists.newArrayList(clazz.getDeclaredFields());
        Class<?> parentClass = clazz.getSuperclass();

        if (parentClass != null && !(parentClass.equals(Object.class)))
        {
            List<Field> parentClassFields = (List<Field>) getAllFields(parentClass);
            currentClassFields.addAll(parentClassFields);
        }

        return currentClassFields;
    }

    public static Class<?>[] getParameterizedTypes(Field field)
    {
        ParameterizedType t = (ParameterizedType) field.getGenericType();
        Type[] actualTypeArguments = t.getActualTypeArguments();

        Class<?>[] result = new Class<?>[actualTypeArguments.length];
        for (int i = 0; i < actualTypeArguments.length; i++)
        {
            result[i] = (Class<?>) actualTypeArguments[i];
        }
        return result;
    }
}
