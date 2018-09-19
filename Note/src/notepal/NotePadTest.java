package notepal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
 
public class NotePadTest extends JFrame {
 
    private static final long serialVersionUID = 7733222986650734523L;
    JMenuBar jmb = new JMenuBar();
    // 创建子菜单
    JMenu jm1 = new JMenu("文件");
    JMenu jm2 = new JMenu("编辑");
   
    // 创建菜单项(文件)
    JMenuItem jme1 = new JMenuItem("新建");
    JMenuItem jme2 = new JMenuItem("打开");
    JMenuItem jme3 = new JMenuItem("保存");
    JMenuItem jme4 = new JMenuItem("另存为...");
    JMenuItem jme5 = new JMenuItem("退出");
    // 创建菜单项(编辑)
    JMenuItem jme6 = new JMenuItem("全选");
    JMenuItem jme7 = new JMenuItem("剪切");
    JMenuItem jme8 = new JMenuItem("复制");
    JMenuItem jme9 = new JMenuItem("粘贴");
    JMenuItem jme10 = new JMenuItem("删除");
    // 实例化文本域
    JTextArea jtext = new JTextArea();
    JTextPane pane = new JTextPane();// 文本窗格
    JScrollPane jscroll = new JScrollPane(jtext);
    JTextPane jtshow = new JTextPane();
   //  ActionListener act=new ActionListener();
    public NotePadTest() {
        setTitle("记事本");
        setSize(1000, 800);
        setLocationRelativeTo(null);
        pane.setLayout(new BorderLayout());
        // 添加菜单项到子菜单（文件）
        jm1.add(jme1);
        jm1.addSeparator();
        jm1.add(jme2);
        jm1.addSeparator();
        jm1.add(jme3);
        jm1.addSeparator();
        jm1.add(jme4);
        jm1.addSeparator();
        jm1.add(jme5);
        jmb.add(jm1);
        // 添加菜单项到子菜单（编辑）
        jm2.add(jme6);
        jm2.addSeparator();
        jm2.add(jme7);
        jm2.addSeparator();
        jm2.add(jme8);
        jm2.addSeparator();
        jm2.add(jme9);
        jm2.addSeparator();
        jm2.add(jme10);
        jmb.add(jm2);
      
        // 将菜单栏添加到窗体顶部
        setJMenuBar(jmb);
        // container.add(jmb,BorderLayout.NORTH);
        // 添加文本域
        pane.add(jscroll, BorderLayout.CENTER);
        add(pane);
        // 添加事件监听器(退出部分)
       
        jme5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtext.getText().equals("")) {
                    NotePadTest.this.dispose();
                } else {
                    int result = JOptionPane.showConfirmDialog(NotePadTest.this, "是否将更改保存到无标题？", "记事本",
                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (result == 0) {
                        if (jtext.getText() != null && !jtext.getText().equals("")) {
                            save();
                        }
                    } else if (result == 1) {
                        NotePadTest.this.dispose();
                    }
                }
            }
        });
        
        // 设置窗体关闭
        if (jtext.getText().equals("")) {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 
        } else if (jtext.getText() != null) {
            int result = JOptionPane.showConfirmDialog(NotePadTest.this, "是否将更改保存到无标题？", "记事本",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == 0) {
            } else if (result == 1) {
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        }
        // 设置窗体是否可见
        setVisible(true);
    }
    
    public void save() {
        JFileChooser choose = new JFileChooser();
        int result = choose.showSaveDialog(NotePadTest.this);// NotePad.this父容器
        if (result == JFileChooser.APPROVE_OPTION) {
            File file;
            try {
                file = choose.getSelectedFile();
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write(jtext.getText());
                bw.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        
    }
 public void strat() {
	 NotePadTest com =new Compile();
     NotePadTest file=new NewFile();
     NotePadTest save =new SaveAs ();
 }
    public static void main(String[] args) {
    	NotePadTest note= new NotePadTest();
        note.strat();
        
       
    }
}

