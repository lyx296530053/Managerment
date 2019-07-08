package cn.lyx.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse=null;
        try {
             parse= dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }
}
