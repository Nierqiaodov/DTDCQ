package gg.nierqiaodov.main;

import gg.nierqiaodov.util.GetAccess;
import gg.nierqiaodov.util.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.Random;

public class Frame {
    public static void frameA() throws FileNotFoundException {
        // 创建一个名为 "桌面倒计时" 的JFrame对象
        JFrame jFrame = new JFrame("桌面倒计时");
        // 设置窗口始终在其他窗口的上面
        jFrame.setAlwaysOnTop(true);
        // 设置窗口没有边框和标题栏
        jFrame.setUndecorated(true);
        // 设置窗口可见
        jFrame.setVisible(true);
        // 设置窗口的位置和大小
        jFrame.setBounds(1, 0, 1920, 230);
        // 设置窗口的布局管理器为GridBagLayout
        jFrame.setLayout(new GridBagLayout());
        // 设置窗口的背景颜色为透明
        jFrame.setBackground(new Color(0, 0, 0, 0));

        // 创建一个GridBagConstraints对象，用于控制组件在网格布局中的位置和大小
        GridBagConstraints gbc = new GridBagConstraints();
        // 设置组件在网格单元格中填满整个空间
        gbc.fill = GridBagConstraints.BOTH;
        // 设置组件在水平方向上的权重为1.0
        gbc.weightx = 1.0;


        // 设置组件在网格布局中的垂直位置为0
        gbc.gridy = 0;
        // 设置组件在垂直方向上的权重为5.0
        gbc.weighty = 5.0;

        // 创建一个字体对象，字体名称为 "NONE"，样式为普通，大小为58
        Font font1 = new Font("NONE", Font.BOLD, 58);

        // 创建一个JLabel对象
        JLabel jLabel1 = new JLabel();
        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        // 设置标签的文本颜色为红色
        jLabel1.setForeground(Color.RED);
        // 设置标签的预先设定大小
        jLabel1.setPreferredSize(new Dimension(1920, 50));
        // 设置标签的字体为之前创建的字体
        jLabel1.setFont(font1);

        // 创建一个JPanel对象
        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.X_AXIS));// 使用BoxLayout确保组件顺序正确
        jPanel1.setOpaque(false);
        // 将标签添加到面板中
        jPanel1.add(jLabel1);
        // 将面板添加到窗口中，并使用GridBagConstraints对象设置其位置和大小
        jFrame.add(jPanel1, gbc);


        // 设置组件在网格布局中的垂直位置为1
        gbc.gridy = 1;
        // 设置组件在垂直方向上的权重为2.0
        gbc.weighty = 2.0;

        // 创建一个字体对象，字体名称为 "NONE"，样式为普通，大小为34
        Font font2 = new Font("NONE", Font.BOLD, 34);

        // 创建一个JLabel对象
        JLabel jLabel2 = new JLabel();
        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        // 设置标签的文本颜色为红色
        jLabel2.setForeground(Color.RED);
        // 设置标签的预先设定大小
        jLabel2.setPreferredSize(new Dimension(1920, 30));
        // 设置标签的字体为之前创建的字体
        jLabel2.setFont(font2);
        // 设置标签的文本为随机名言
        jLabel2.setText(SayingShower.randomSaying());

        // 创建一个JPanel对象
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.X_AXIS));// 使用BoxLayout确保组件顺序正确
        jPanel2.setOpaque(false);
        // 将标签添加到面板中
        jPanel2.add(jLabel2);
        // 将面板添加到窗口中，并使用GridBagConstraints对象设置其位置和大小
        jFrame.add(jPanel2, gbc);


        // 设置组件在网格布局中的垂直位置为2
        gbc.gridy = 2;
        // 设置组件在垂直方向上的权重为2.0
        gbc.weighty = 2.0;

        // 创建一个JButton对象，文本为 "退出计时"
        JButton exitButton = new JButton("退出");
        // 创建一个字体对象，字体名称为 "NONE"，样式为普通，大小为35
        Font newFont = new Font("NONE", Font.PLAIN, 33);
        // 设置按钮的字体为新创建的字体
        exitButton.setFont(newFont);
        // 为按钮添加一个动作监听器，当按钮被点击时，退出程序
        exitButton.addActionListener(e -> System.exit(0));


        // 创建InputMap和ActionMap来处理F5按键
        InputMap inputMap = jPanel2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = jPanel2.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "f5Action");

        actionMap.put("f5Action", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabel2.setText(SayingShower.randomSaying());
                jPanel2.revalidate();
                jPanel2.repaint();
                Logger.logOut("名人名言已手动更改");
            }
        });


        // 创建一个JButton对象，文本为 "刷新名言"
        JButton refreshButton = new JButton("刷新");
        // 设置按钮的字体为新创建的字体
        refreshButton.setFont(newFont);
        // 为按钮添加一个动作监听器，当按钮被点击时，更新名言
        refreshButton.addActionListener(actionEvent -> {
            jLabel2.setText(SayingShower.randomSaying());
            jPanel2.revalidate();
            jPanel2.repaint();
            Logger.logOut("名人名言已手动更改");
        });


        // 创建一个JPanel对象
        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new BoxLayout(jPanel3, BoxLayout.X_AXIS));// 使用BoxLayout确保组件顺序正确
        jPanel3.setOpaque(false);
        // 将退出按钮和刷新按钮添加到面板中
        jPanel3.add(exitButton);
        jPanel3.add(refreshButton);
        // 将面板添加到窗口中，并使用GridBagConstraints对象设置其位置和大小
        jFrame.add(jPanel3, gbc);


        // 设置组件在网格布局中的垂直位置为3
        gbc.gridy = 3;
        // 设置组件在垂直方向上的权重为1.0
        gbc.weighty = 1.0;

        // 创建一个JLabel对象，文本为 "DTDCQ倒计时庆云安制作copyright©"
        JLabel jLabel3 = new JLabel();
        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel3.setText("DTDCQ倒计时庆云安制作copyright©");

        // 创建一个JPanel对象
        JPanel jPanel4 = new JPanel();
        jPanel4.setLayout(new BoxLayout(jPanel4, BoxLayout.X_AXIS));// 使用BoxLayout确保组件顺序正确
        jPanel4.setOpaque(false);
        // 将标签添加到面板中
        jPanel4.add(jLabel3);


        // 将面板添加到窗口中，并使用GridBagConstraints对象设置其位置和大小
        jFrame.add(jPanel4, gbc);


        // 初始化计数器i为0
        int i = 0;

        // 创建一个Random对象r，用于生成随机数
        Random r = new Random();
        // 生成一个30到90之间的随机整数n
        int n = r.nextInt(30, 90);
        // 记录日志，输出当前随机更新刻
        Logger.logOut("当前随机更新刻为" + n);


        // 进入一个无限循环，添加延迟以避免过度占用CPU资源
        while (true) {
            jLabel1.setText("距离" + GetAccess.getE() + "仅剩" + Counter.setTime() + "!");
            i++;
            if (i > n) {
                jLabel2.setText(SayingShower.randomSaying());
                Logger.logOut("名人名言已更改");
                n = r.nextInt(30, 90);
                Logger.logOut("当前随机更新刻为" + n);
                i = 0;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}