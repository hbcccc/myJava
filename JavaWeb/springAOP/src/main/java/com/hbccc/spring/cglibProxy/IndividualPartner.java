package com.hbccc.spring.cglibProxy;

public class IndividualPartner extends Partner {

    private String name;
    public IndividualPartner(){

    }

    public IndividualPartner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 收钱
     *
     * @param money
     */
    public void receiveMoney(int money){
        System.out.println("receive: $"+money);
    }
    /**
     * 陪玩
     * @param player
     */
    public void playeWith(Player player){
        System.out.println(name + "play with "+ player.getName());
    }

}
