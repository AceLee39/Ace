package com.ace.capitalflows.ui.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.ace.capitalflows.entity.User;
import com.ace.capitalflows.entity.UserControl;
import com.ace.capitalflows.ui.component.BackgroundPanel;


public class LoginFrame extends JFrame {
    private static final long serialVersionUID = -3694752991113680433L;

    private JTextField username;
    private JLabel usernameMsg;
    private JPasswordField password;
    private JLabel passwordMsg;


    public LoginFrame() {
        init();
    }

    private void init() {
        this.setTitle("登录");
        this.setSize(400, 200);
        this.setLocation(400, 200);
        this.setContentPane(createPane());
        this.setVisible(false);
        this.setIconImage(new ImageIcon("image/icon.jpg").getImage());
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private Container createPane() {
        final Image img = new ImageIcon("image/bg_login.jpg").getImage();
        final JPanel panel = new BackgroundPanel(img);
        panel.setLayout(new BorderLayout());
        final JLabel title = new JLabel("中国资本流动测算系统需求分析",JLabel.CENTER);
        title.setForeground(Color.orange);
        title.setPreferredSize(new Dimension(100, 50));
        panel.add(title, BorderLayout.NORTH);
        panel.add(createCenter(), BorderLayout.CENTER);
        panel.add(createSouth(),BorderLayout.SOUTH);
        return panel;
    }

    private Component createSouth() {
        final JPanel panel = new JPanel();
        panel.setOpaque(false);
        final JButton login = new JButton("登录");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent paramActionEvent) {
                final User u = new User();
                u.setUsername(username.getText());
                u.setPassword(String.valueOf(password.getPassword()));
                final UserControl uc = new UserControl();
                final String s = uc.login(u);
                if("成功".equals(s)) {
                    LoginFrame.this.setVisible(false);
                    MainFrame.getInstance().getUpdate().doClick();
                }else if("用户名不存在".equals(s)) {
                    usernameMsg.setText(s);
                }else {
                    passwordMsg.setText(s);
                }
            }
        });
        panel.add(login);

        final JButton register = new JButton("注册");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent paramActionEvent) {
                LoginFrame.this.setVisible(false);
                final RegisterFrame registerFrame = new RegisterFrame();
                registerFrame.setVisible(true);
            }
        });
        panel.add(register);
        return panel;
    }

    private Component createCenter() {
        final JPanel panel = new JPanel(new GridLayout(2,3));
        panel.setOpaque(false);
        final JLabel lblUserName = new JLabel("用户名：",JLabel.CENTER);
        lblUserName.setForeground(Color.orange);
        panel.add(lblUserName);
        username = new JTextField();
        panel.add(username);
        usernameMsg = new JLabel();
        usernameMsg.setForeground(Color.red);
        panel.add(usernameMsg);

        final JLabel lblPassword = new JLabel("密码：",JLabel.CENTER);
        lblPassword.setForeground(Color.orange);
        panel.add(lblPassword);
        password = new JPasswordField();
        panel.add(password);
        passwordMsg = new JLabel();
        passwordMsg.setForeground(Color.red);
        panel.add(passwordMsg);

        username.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(final FocusEvent paramFocusEvent) {
            }

            @Override
            public void focusGained(final FocusEvent paramFocusEvent) {
                usernameMsg.setText("");
            }
        });

        password.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(final FocusEvent paramFocusEvent) {
            }

            @Override
            public void focusGained(final FocusEvent paramFocusEvent) {
                passwordMsg.setText("");
            }
        });

        return panel;
    }

}








