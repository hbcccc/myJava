package org.example.withdao.entity;

import java.util.List;

public class UserVO {
    List<User> users;
    public List<User> getUsers(){
        return  users;
    }

    public void setUsers(List<User> users){
        this.users = users;
    }
}
