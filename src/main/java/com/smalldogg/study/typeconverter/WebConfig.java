package com.smalldogg.study.typeconverter;

import com.smalldogg.study.typeconverter.converter.IntegerToStringConverter;
import com.smalldogg.study.typeconverter.converter.IpPortToStringConverter;
import com.smalldogg.study.typeconverter.converter.StringToIpPortConverter;
import com.smalldogg.study.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //우선순위 Converter > Formatter

        //우선순위로 인해 주석처리
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());

        //추가
        registry.addFormatter(new MyNumberFormatter());
    }
}
