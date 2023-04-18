package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Configuration
public class ProxyConfig {
    @Value("${robot.proxy.host}")
    private String host;
    @Value("${robot.proxy.port}")
    private Integer port;
    @Value("${robot.proxy.protocol}")
    private String protocol;

    public Integer getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public Proxy.Type getProtocol() {
        return switch (protocol) {
            case "socks" -> Proxy.Type.SOCKS;
            case "http" -> Proxy.Type.HTTP;
            case "direct" -> Proxy.Type.DIRECT;
            default -> null;
        };
    }

    @Bean(name = "ChatProxy")
    public Proxy getProxy() {
        return new Proxy(getProtocol(), new InetSocketAddress(host, port));
    }
}