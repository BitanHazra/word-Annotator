import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.awt.Font;
import java.io.*; 
import java.text.*; 
import java.util.*; 
import java.net.*;

public class ConnectW implements ActionListener
{
	JFrame cframe;
	JButton connectButton;
	JLabel address;
	JPanel connectionpanel;
	JLabel port;
	JTextField address1;
	JTextField address2;



	public ConnectW(Notepad note)
	{
		cframe = new JFrame("Stablish Connection");
		address = new JLabel("Enter Host Address:");
		port = new JLabel("Enter Port:");
		connectionpanel = new JPanel();
		
		
		connectButton = new JButton("Connect");
		connectButton.setActionCommand("ConnectS");
		connectButton.addActionListener(this);
		address1 = new JTextField();
		address2 = new JTextField();
		initComponents();
		cframe.setVisible(true);
	}
	public void create_server()throws IOException
	{
		String address = address1.getText();
		int port = Integer.parseInt(address2.getText());
		try{
		InetAddress group = InetAddress.getByName(address);
		MulticastSocket socket = new MulticastSocket(port);
		socket.setTimeToLive(0);
		socket.joinGroup(group);
		Thread t = new Thread(new ReadThread(socket));
		t.start();

	}catch(IOException e){}
	}
	public void initComponents()
	{
		GroupLayout layout = new GroupLayout(cframe.getContentPane());
		cframe.getContentPane().setLayout(layout);
		connectionpanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Connection"));

//SETTING FORMULA PANEL
		GroupLayout panellayout = new GroupLayout(connectionpanel);
		connectionpanel.setLayout(panellayout);
		panellayout.setHorizontalGroup(
			panellayout.createParallelGroup()
				.addGroup(panellayout.createSequentialGroup()
					.addGap(10,10,10)
					.addComponent(address,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(address1,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addContainerGap(100,Short.MAX_VALUE)
					)
				.addGroup(panellayout.createSequentialGroup()
					.addGap(10,10,10)
					.addComponent(port,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(address2,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addContainerGap(100,Short.MAX_VALUE)
					)
				.addGroup(panellayout.createSequentialGroup()
					.addGap(10,10,10)
					.addComponent(connectButton,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
					
					)

			);
		panellayout.setVerticalGroup(
			panellayout.createParallelGroup()
				.addGroup(panellayout.createSequentialGroup()
						.addComponent(address,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(port,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						)
				.addGroup(panellayout.createSequentialGroup()
						.addComponent(address1,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(address2,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(connectButton,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						)

			);

//SETTING FRAME LAYOUT
		layout.setHorizontalGroup(
			layout.createParallelGroup()
			.addGroup(layout.createSequentialGroup()
							.addComponent(connectionpanel,javax.swing.GroupLayout.PREFERRED_SIZE,500,javax.swing.GroupLayout.PREFERRED_SIZE)
								)
			);

		layout.setVerticalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addComponent(connectionpanel,javax.swing.GroupLayout.PREFERRED_SIZE,150,javax.swing.GroupLayout.PREFERRED_SIZE)
					)
			);

		cframe.pack();
	}
	public void actionPerformed(ActionEvent evt){

		String val = evt.getActionCommand();
		if(val.equals("ConnectS"))
		{
			try
			{
			create_server();
			}catch(IOException e){}
		}
	}

}
class ReadThread implements Runnable
{
	private MulticastSocket socket;
	public ReadThread(MulticastSocket s)
	{
		this.socket = s;
	}
	public void run()
	{
		System.out.print("client connected");
	}
}

