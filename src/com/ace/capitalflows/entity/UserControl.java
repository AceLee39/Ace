package com.ace.capitalflows.entity;


public class UserControl {
    private String repassword;

    public String checkUser(final User u){
        String check = "用户名已存在";
        try {
            final User user = UserModle.getUserByUsername(u.getUsername());
            if(null == user) {
                if(repassword.equals(u.getPassword())) {
                    check = "ok";
                    UserModle.saveUser(u);
                }else {
                    check = "确认密码错误";
                }
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public String login(final User u) {
        String login = "成功";
        try {
            final User user = UserModle.getUserByUsername(u.getUsername());
            if(null == user) {
                login = "用户名不存在";
            }else {
                if(!u.getPassword().equals(user.getPassword())) {
                    login = "密码错误";
                }
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return login;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(final String repassword) {
        this.repassword = repassword;
    }


}
