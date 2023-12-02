package com.hbccc.spring.proxy;
public class Client {
    public static void main(String[] args) {
        Player player = new Player("昊吾辽");
        IndividualPartner partner = new IndividualPartner("修桀桀");
        partner.receiveMoney(300);
        partner.playeWith(player);
    }
}
