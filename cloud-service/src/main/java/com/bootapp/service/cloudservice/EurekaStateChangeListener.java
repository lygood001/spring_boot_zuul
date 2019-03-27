package com.bootapp.service.cloudservice;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class EurekaStateChangeListener {
    @Autowired
    private EmailUtils emailUtils;

        //    EurekaInstanceCanceledEvent 服务下线事件
        //    EurekaInstanceRegisteredEvent 服务注册事件
        //    EurekaInstanceRenewedEvent 服务续约事件
        //    EurekaRegistryAvailableEvent Eureka注册中心启动事件
        //    EurekaServerStartedEvent Eureka Server启动事件

    @EventListener
    public void listenDown(EurekaInstanceCanceledEvent eurekaInstanceCanceledEvent) {
//        System.err.println(eurekaInstanceCanceledEvent.getServerId() + "\t" + eurekaInstanceCanceledEvent.getAppName() + " 服务下线");
//        //服务断线事件
//        String appName = eurekaInstanceCanceledEvent.getAppName();
//        String serverId = eurekaInstanceCanceledEvent.getServerId();
//        System.out.println(appName);
//        System.out.println(serverId);
//        emailUtils.sendMail("wangtianxin11@126.com","服务出现异常邮件","springboot："+appName+"出现异常 请登录服务器查看");
    }


    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
//        InstanceInfo instanceInfo = event.getInstanceInfo();
//        System.out.println(instanceInfo.getStatus());
//        if(instanceInfo.getStatus().toString().equals("DOWN")){
//            emailUtils.sendMail("wangtianxin11@126.com","服务出现异常邮件","springboot："+instanceInfo.getAppName()+"出现异常 请登录服务器查看");
//
//        }
//        System.out.println(instanceInfo);
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
//        event.getAppName();
//        event.getServerId();
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {

    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        //Server启动
    }


}