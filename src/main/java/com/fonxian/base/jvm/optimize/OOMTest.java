package com.fonxian.base.jvm.optimize;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Michael Fang
 * @since 2020-03-26
 */
class User{

    private String id;
    private Test test;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(String id,Test test) {
        this.id = id;
        this.test = test;
    }
}

class Test{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Test(int id) {
        this.id = id;
    }
}
public class OOMTest {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        for(;;){
            userList.add(new User(UUID.randomUUID().toString(),new Test(1)));
        }
    }

}
