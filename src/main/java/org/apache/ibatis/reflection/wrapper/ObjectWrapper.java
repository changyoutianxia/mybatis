/**
 * Copyright 2009-2019 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ibatis.reflection.wrapper;

import java.util.List;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.property.PropertyTokenizer;

/**
 * @author Clinton Begin
 */
public interface ObjectWrapper {
    //如果封装的 是普通Bean调用get,如果是集合调用下标或者key
    Object get(PropertyTokenizer prop);

    //普通调用set集合调用下标或者key
    void set(PropertyTokenizer prop, Object value);

    //查找属性表达式指定的属性，第二个参数表示是否忽略表达式中的下划线
    String findProperty(String name, boolean useCamelCaseMapping);

    String[] getGetterNames();

    String[] getSetterNames();
    //获取set参数类型
    Class<?> getSetterType(String name);
    //获取get参数类型
    Class<?> getGetterType(String name);
    //是否有get set 方法
    boolean hasSetter(String name);

    boolean hasGetter(String name);
    //为属性表达式制定的属性创建相应的MetaObject对象
    MetaObject instantiatePropertyValue(String name, PropertyTokenizer prop, ObjectFactory objectFactory);
    //是否是collection对象
    boolean isCollection();
    //调用Collection的add
    void add(Object element);
    //调用Collection的addAll
    <E> void addAll(List<E> element);

}
