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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.commons.lang.StringUtils;

import com.ace.capitalflows.entity.User;
import com.ace.capitalflows.entity.UserControl;
import com.ace.capitalflows.ui.component.BackgroundPanel;


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
        try {
            init();
        } catch (final IOException e) {
            System.out.println("fail to get image" + e.getMessage());
        }
    }

    public static void main(final String[] args) {
        new RegisterFrame();
    }

    private void init() throws IOException {
        this.setTitle("注册");
        this.setSize(400, 200);
        this.setLocation(400, 200);
        this.setContentPane(createPane());
        final InputStream is = new FileInputStream("image/icon.jpg");
        this.setIconImage(ImageIO.read(is));
        this.setResizable(false);
        this.setVisible(true);
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
        final JButton register = new JButton("注册");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent paramActionEvent) {
                final User u = new User();
                final String userName = username.getText();
                final String passwordVal = String.valueOf(password.getPassword());
                if (StringUtils.isBlank(userName) || StringUtils.isBlank(passwordVal)) {
                    usernameMsg.setText("用户名密码不可以为空");
                    repasswordMsg.setText("用户名密码不可以为空");
                    return;
                }
                u.setUsername(userName);
                u.setPassword(passwordVal);
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
        final JLabel lblConfirmPassword = new JLabel("密码确认：",JLabel.CENTER);
        lblConfirmPassword.setForeground(Color.orange);
        panel.add(lblConfirmPassword);
        repassword = new JPasswordField();
        panel.add(repassword);
        repasswordMsg = new JLabel();
        repasswordMsg.setForeground(Color.red);
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
