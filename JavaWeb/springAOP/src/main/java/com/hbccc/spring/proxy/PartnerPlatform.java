package com.hbccc.spring.proxy;

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
        Partner  partner = partners.remove(0);
        return (Partner) Proxy.newProxyInstance(partner.getClass().getClassLoader(), partner.getClass().getInterfaces(), new InvocationHandler() {
            private  int budget = money;
            private boolean status = false;
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("receiveMoney")){
                    int money = (int) args[0];
                    args[0] = money / 2;
                    this.status = money >= budget;
                }
                if(status)
                        return method.invoke(partner, args);
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
