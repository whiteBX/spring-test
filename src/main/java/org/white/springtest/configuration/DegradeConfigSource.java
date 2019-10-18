package org.white.springtest.configuration;

import com.google.common.collect.Maps;
import com.netflix.config.*;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Iterator;
import java.util.Map;

/**
 * <p></p >
 *
 * @author white
 * @version $Id: DegradeConfigSource.java, v 0.1 2019年10月17日 10:24:00 white Exp$
 */
//@Configuration
//public class DegradeConfigSource implements PolledConfigurationSource {
//    @Override
//    public PollResult poll(boolean initial, Object checkPoint) throws Exception {
//        Map<String, Object> complete = Maps.newHashMap();
//        PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration("D:\\workspace\\My\\spring-test\\src\\main\\resources\\config.properties");
//        for (Iterator<String> it = propertiesConfiguration.getKeys(); it.hasNext(); ) {
//            String key = it.next();
//            complete.put(key, propertiesConfiguration.getProperty(key));
//        }
//        return PollResult.createFull(complete);
//    }
//
//    @Bean
//    public DynamicConfiguration dynamicConfiguration(DegradeConfigSource configource) {
//        DynamicConfiguration configuration = new DynamicConfiguration(configource,
//                new FixedDelayPollingScheduler(30 * 100, 60 * 100, false));
//
//        ConfigurationManager.install(configuration);// 安裝后会启动schedel,定时调用DynamicConfigSource.poll()更新配置
//        return configuration;
//    }
//}
