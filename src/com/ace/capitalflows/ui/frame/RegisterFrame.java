package com.ace.capitalflows.ui.frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.ace.capitalflows.entity.User;
import com.ace.capitalflows.entity.UserControl;


/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class RegisterFrame extends JFrame{
    private JTextField username;
    private JLabel usernameMsg;
    private JPasswordField password;
    private JLabel passwordMsg;
    private JPasswordField repassword;
    private JLabel repasswordMsg;

    public RegisterFrame(){
        init();
    }

    public static void main(final String[] args) {
        new RegisterFrame();
    }

    private void init() {
        this.setTitle("注册");
        this.setSize(400, 200);
        this.setContentPane(createPane());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private Container createPane() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("中国资本流动测算系统需求分析",JLabel.CENTER), BorderLayout.NORTH);
        panel.add(createCenter(), BorderLayout.CENTER);
        panel.add(createSouth(),BorderLayout.SOUTH);
        return panel;
    }

    private Component createSouth() {
        final JPanel panel = new JPanel();
        final JButton register = new JButton("注册");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent paramActionEvent) {
                final User u = new User();
                u.setUsername(username.getText());
                u.setPassword(String.valueOf(password.getPassword()));
                final UserControl uc = new UserControl();
                uc.setRepassword(String.valueOf(repassword.getPassword()));
                final String s = uc.checkUser(u);
                if("ok".equals(s)) {
                    RegisterFrame.this.setVisible(false);
                    final LoginFrame loginFrame = new LoginFrame();
                    loginFrame.setVisible(true);
                }else if("确认密码错误".equals(s)) {
                    repasswordMsg.setText(s);
                }else {
                    usernameMsg.setText(s);
                }
            }
        });
        panel.add(register);

        final JButton login = new JButton("登录");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent paramActionEvent) {
                RegisterFrame.this.setVisible(false);
                final LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });
        panel.add(login);
        return panel;
    }

    private Component createCenter() {
        final JPanel panel = new JPanel(new GridLayout(3,3));
        panel.add(new JLabel("用户名：",JLabel.RIGHT));
        username = new JTextField();

        panel.add(username);
        usernameMsg = new JLabel();
        panel.add(usernameMsg);

        panel.add(new JLabel("密码：",JLabel.RIGHT));
        password = new JPasswordField();
        panel.add(password);
        passwordMsg = new JLabel();
        panel.add(passwordMsg);

        panel.add(new JLabel("密码确认：",JLabel.RIGHT));
        repassword = new JPasswordField();
        panel.add(repassword);
        repasswordMsg = new JLabel();
        panel.add(repasswordMsg);

        username.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(final FocusEvent paramFocusEvent) {
            }

            @Override
            public void focusGained(final FocusEvent paramFocusEvent) {
                usernameMsg.setText("");
            }
        });

        repassword.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(final FocusEvent paramFocusEvent) {
            }

            @Override
            public void focusGained(final FocusEvent paramFocusEvent) {
                repasswordMsg.setText("");
            }
        });

        return panel;
    }
}
