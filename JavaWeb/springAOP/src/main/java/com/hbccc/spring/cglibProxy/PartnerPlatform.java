package com.hbccc.spring.cglibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class PartnerPlatform {

    private static List<IndividualPartner> partners = new ArrayList<>();

    static {
        partners.add(new IndividualPartner("肖洁洁"));
        partners.add(new IndividualPartner("田苟"));
        partners.add(new IndividualPartner("高总裁"));
    }

    public static Partner getPartner(int money) {
        Partner partner = partners.remove(0);

        return (Partner) Enhancer.create(partner.getClass(), new MethodInterceptor() {
            private  int budget = money;
            private boolean status = false;
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if(method.getName().equals("receiveMoney")){
                    int money = (int) objects[0];
                    this.status = money > budget;
                    objects[0] = money / 2;
                }
                if(status)
                    return method.invoke(partner, objects);
                return  null;
            }
        });
    }

    public static void main(String[] args) {
        Player player = new Player("昊吾辽");
        Partner partner = PartnerPlatform.getPartner(300);
        partner.receiveMoney(400);
        partner.playeWith(player);
    }
}
