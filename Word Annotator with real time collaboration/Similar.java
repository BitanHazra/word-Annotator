import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*; 
import java.util.*; 
import java.net.*; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Similar implements ActionListener
{
	static JTextArea text1;
	JPanel connectionPanel;
	JFrame frm;
	JPanel content;
	JScrollPane scroll;
	JButton submit;

	public Similar()
	{
		
		text1 = new JTextArea();
		text1.setLineWrap(true);
		scroll = new JScrollPane();
		scroll.setViewportView(text1);
		submit = new JButton("Add to File");
		submit.setActionCommand("addtofile");
		submit.addActionListener(this);
		
		content = new JPanel();
		frm = new JFrame();
		initComponent();
		frm.setVisible(true);
	}
	
	public void initComponent()
	{
		GroupLayout grpl = new GroupLayout(frm.getContentPane());
		frm.getContentPane().setLayout(grpl);
		content.setBorder(javax.swing.BorderFactory.createTitledBorder("TEXT SIMILARITY"));

		//Content
		GroupLayout panelContent = new GroupLayout(content);
		content.setLayout(panelContent);

		panelContent.setHorizontalGroup(
			panelContent.createParallelGroup()
				.addGroup(panelContent.createParallelGroup()
						.addComponent(scroll,javax.swing.GroupLayout.PREFERRED_SIZE,400,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(submit,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
						
					)
			);
		panelContent.setVerticalGroup(
			panelContent.createParallelGroup()
				.addGroup(panelContent.createSequentialGroup()
						.addComponent(scroll,javax.swing.GroupLayout.PREFERRED_SIZE,600,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(submit,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						)
			);
		//Create Frame
		grpl.setHorizontalGroup(
			grpl.createParallelGroup()
			.addGroup(grpl.createParallelGroup()
						.addComponent(content,javax.swing.GroupLayout.PREFERRED_SIZE,500,javax.swing.GroupLayout.PREFERRED_SIZE)
						
					)
			);
		grpl.setVerticalGroup(
			grpl.createParallelGroup()
				.addGroup(grpl.createSequentialGroup()
						.addComponent(content,javax.swing.GroupLayout.PREFERRED_SIZE,800,javax.swing.GroupLayout.PREFERRED_SIZE)
						
					)
			);
frm.pack();

}
public void actionPerformed(ActionEvent e)
	{
		String val = e.getActionCommand();
		if(val.equals("addtofile"))
		{
			try
			{
			FileWriter fw = new FileWriter("noted", true);
            BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pr = new PrintWriter(bw);
        	pr.println(text1.getText());
        	JOptionPane.showMessageDialog(frm,"File Sucessfully Added");  
        	pr.close();
        	bw.close();
        	fw.close();
        	}catch(Exception ee){JOptionPane.showMessageDialog(frm,"File Not Added");  }
		}
	}
}
