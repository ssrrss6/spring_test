package com.zhang.myspring.myspringframework.core;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.parsers.SAXParser;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext{
    private static final Logger logger = LoggerFactory.getLogger(ClassPathXmlApplicationContext.class);
    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 解析myspring的配置文件，然后初始化所有的Bean对象
     * @param configLocation spring 配置文件的路径。注意ClassPathXmlApplicationContext，配置文件应当放在类路径下。
     */
    public ClassPathXmlApplicationContext(String configLocation) {
        try {
            // 解析myspring.xml文件，然后实例化Bean，将Bean存放到singletonObject集合当中
            SAXReader saxReader = new SAXReader();

            // 获取一个输入流，指向配置文件
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(configLocation);
            Document document = saxReader.read(in);

            // 获取所有bean标签
            List<Node> nodes = document.selectNodes("//bean");
            nodes.forEach(node -> {
                // 向下转型的目的是为了使用Element接口里更加丰富的方法
                Element beanElt = (Element) node;
                // 获取id属性
                String id = beanElt.attributeValue("id");
                // 获取class属性
                String className = beanElt.attributeValue("class");
                logger.info("beanName=" + id);
                logger.info("beanClassName=" + className);

                try {
                    Class<?> clazz = Class.forName(className);
                    Constructor<?> constructor = clazz.getDeclaredConstructor();
                    Object obj = constructor.newInstance();

                    singletonObjects.put(id, obj);

                    logger.info(singletonObjects.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            // 再次遍历集合 给属性赋值
            nodes.forEach(node -> {
                Element beanElt = (Element) node;

                // 获取bean的id
                String id = beanElt.attributeValue("id");
                // 获取property
                List<Element> propertys = beanElt.elements("property");
                // 遍历所有属性
                propertys.forEach(propertyElt -> {
                    try {
                        // 获取属性名
                        String propertyName = propertyElt.attributeValue("name");
                        // 获取属性的类型
                        Class<?> type = singletonObjects.get(id).getClass().getDeclaredField(propertyName).getType();
                        // 获取set方法名
                        String methodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                        // 获取set方法
                        Method method = singletonObjects.get(id).getClass().getDeclaredMethod(methodName, type);

                        // 获取参数
                        String value = propertyElt.attributeValue("value");
                        String ref = propertyElt.attributeValue("ref");
                        Object propertyVal = null;
                        if (value != null) {
                            // 该属性是简单属性
                            String propertyTypeSimpleName = type.getSimpleName();
                            switch (propertyTypeSimpleName) {
                                case "byte": case "Byte":
                                    propertyVal = Byte.valueOf(value);
                                    break;
                                case "short": case "Short":
                                    propertyVal = Short.valueOf(value);
                                    break;
                                case "int": case "Integer":
                                    propertyVal = Integer.valueOf(value);
                                    break;
                                case "long": case "Long":
                                    propertyVal = Long.valueOf(value);
                                    break;
                                case "float": case "Float":
                                    propertyVal = Float.valueOf(value);
                                    break;
                                case "double": case "Double":
                                    propertyVal = Double.valueOf(value);
                                    break;
                                case "boolean": case "Boolean":
                                    propertyVal = Boolean.valueOf(value);
                                    break;
                                case "char": case "Character":
                                    propertyVal = value.charAt(0);
                                    break;
                                case "String":
                                    propertyVal = value;
                                    break;
                            }
                            method.invoke(singletonObjects.get(id), propertyVal);
                        }
                        if (ref != null) {
                            // 调用set方法
                            method.invoke(singletonObjects.get(id), singletonObjects.get(ref));
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                });

            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object getBean(String id) {
        return singletonObjects.get(id);
    }

    public Map<String, Object> getSingletonObjects() {
        return singletonObjects;
    }
}
