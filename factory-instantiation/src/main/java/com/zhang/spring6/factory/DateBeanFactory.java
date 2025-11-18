package com.zhang.spring6.factory;

import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class DateBeanFactory implements FactoryBean<Date> {

    private String strDate;

//    public DateBeanFactory(String strDate) {
//        this.strDate = strDate;
//    }


    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    @Override
    public Date getObject() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(strDate);

        return date;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
