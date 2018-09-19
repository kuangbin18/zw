package notepal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Compile extends NotePadTest{
	public Compile() {
		//添加事件监听器(全选部分)
        jme6.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                jtext.selectAll();// 全选
            }
        });
        //添加事件监听器(剪切部分)
        jme7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtext.cut();// 剪切
            }
        });
        // 添加事件监听器(复制部分)
        jme8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtext.copy();// 复制
            }
        });
        // 添加事件监听器(粘贴部分)
        jme9.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                jtext.paste();// 粘贴
            }
        });
        //添加事件监听器(删除部分)
        jme10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtext.replaceSelection(null);// 删除
            }
        });
	}
}
