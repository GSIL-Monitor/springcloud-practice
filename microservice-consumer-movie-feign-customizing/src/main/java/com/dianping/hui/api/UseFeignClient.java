package com.dianping.hui.api;

import com.dianping.hui.entity.User;
import com.dianping.noautoconfig.FeignConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author: lanxinyu@meituan.com  2018-11-12 下午4:58
 * @Description:
 */

/**
 * FeignClient 注释中的 "provider-user" 是一个任意的客户端名称，用于创建Ribbon负载均衡器
 *
 * 在本例中由于使用的Eurake，所以Ribbon会把 "provider-user" 解析成Eurake Server 服务注册表中的服务。 当然如果不想使用Eurake，
 * 可使用service.ribbon.listOfServices属性配置服务器列表，详见 Part5.4
 */
@FeignClient(name="provider-user", configuration = FeignConfiguration.class)
public interface UseFeignClient {

    @RequestLine("GET /user/{id}")
    User findById(@Param("id") Long id);
}
