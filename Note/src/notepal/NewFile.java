package notepal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class NewFile extends NotePadTest{
	public NewFile() {
		 // 添加事件监听器(新建部分)
        jme1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtext.getText().equals("")) {
                    jtext.setText("");
                } else {
                    int result = JOptionPane.showConfirmDialog(new NotePadTest(), "是否将更改保存到无标题？", "记事本",
                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (result == 0) {
                        save();
                    }
                }
            }
        });
        //添加事件监听器(打开部分)
        jme2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser choose = new JFileChooser();
                choose.setDialogTitle("打开");
                File file;
                int result = choose.showOpenDialog(new NotePadTest());
                if (result == JFileChooser.APPROVE_OPTION) {
                    try { // 获取当前选择的文件
                            // 创建文件输出流
                        file = choose.getSelectedFile();
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        String str = null;
                        while ((str = br.readLine()) != null) {
                            jtext.append(str + "\r\n");
                        }
                        // 设置记事本标题
                        setTitle(file.getName() + "  记事本");
                        br.close();
                    } catch (Exception ee) {
                        ee.printStackTrace();
                    }
                }
            }
        });
	}
	
	}
	

