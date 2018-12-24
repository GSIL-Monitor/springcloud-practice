package com.dianping.notautoscan.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.ConfigurationBasedServerList;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import com.netflix.loadbalancer.ServerListSubsetFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;

/**
 * @author: lanxinyu@meituan.com  2018-11-11 下午4:22
 * @Description: 有问题
 */
@RibbonClients(defaultConfiguration = RibbonClientsConfig.class)
public class RibbonClientsConfig {
    private static class BazServiceList extends ConfigurationBasedServerList {
        public BazServiceList(IClientConfig config) {
            super.initWithNiwsConfig(config);
        }
    }
    @Bean public IRule ribbonRule() {
        return new BestAvailableRule();
    }
    @Bean public IPing ribbonPing() {
        return new PingUrl();
    }
    @Bean public ServerList<Server> ribbonServerList(@Autowired(required = false) IClientConfig client) {
        return new BazServiceList(client);
    }
    @Bean public ServerListSubsetFilter serverListSubsetFilter() {
        return new ServerListSubsetFilter();
    }
}
