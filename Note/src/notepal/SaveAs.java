package notepal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class SaveAs extends NotePadTest{
	public SaveAs() {
		 // 添加事件监听器(保存部分)
        jme3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtext.getText() != null && !jtext.getText().equals("")) {
                    save();
                }
            }
        });
        // 添加事件监听器(另存为部分)
        jme4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtext.getText() != null && !jtext.getText().equals("")) {
                    save();
                }
            }
        });
	}
}
