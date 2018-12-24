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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Font;

public class Comparedemo implements ActionListener
{
	JFrame cframe;
	public static JButton cosinebutton,similar,bserver,cserver;
	JButton browse1;
	JLabel label1;
	JPanel formulapanel,browsepanel,text1,text2;
	JLabel header,labeltext1;
	JTextField browsetext1;
	public static JTextArea textarea2;
	public JTextArea textarea1;
	JScrollPane scroll1,scroll2;
	public static String clientname;

	JButton connectButton,clientButton,bstop;
	JLabel address;
	JPanel connectionpanel;
	JLabel port;
	JTextField address1;
	JTextField address2;
	JLabel ccname;
	JTextField ccnamebutton;
	JLabel cresult;

	//socket
	String saddress;
	int sport;
	InetAddress sgroup;
	String smessage;
	static public ServerSocket sersocket=null;
	Socket connectionSocket=null;
	Socket clientSocket=null;
	static Thread serverReceive;
	static Thread B;
	public static ObjectOutputStream ois1 = null;
	public static ObjectOutputStream ois2 = null;
	
	public Comparedemo(Notepad note)
	{
		cframe = new JFrame("Comparision");
		note.menucreator(cframe);

		header = new JLabel("COMPARE");
		label1 = new JLabel("Compare:(Click on Browse Button To Browse the Files)");
		labeltext1 = new JLabel("Text 1:");
		formulapanel = new JPanel();
		browsepanel = new JPanel();
		text1 = new JPanel();
		text2 = new JPanel();

		address = new JLabel("Enter Host Address:");
		port = new JLabel("Enter Port:");
		ccname = new JLabel("Enter Name:");
		cresult = new JLabel("Login as Server or Client");
		connectionpanel = new JPanel();
		
		
		connectButton = new JButton("Create Server");
		connectButton.setActionCommand("ConnectS");
		connectButton.addActionListener(this);
		clientButton = new JButton("Client Connection");
		clientButton.setActionCommand("ConnectC");
		clientButton.addActionListener(this);

		bstop = new JButton("Disconnect");
		bstop.setActionCommand("bstop");
		bstop.addActionListener(this);
		
		address1 = new JTextField("192.168.43.170");
		address2 = new JTextField("6789");
		address2.setEditable(false);
		ccnamebutton = new JTextField("client");

		textarea1 = new JTextArea();
		
		textarea1.setLineWrap(true);
		textarea1.setFont(new Font("Ubuntu",0,16));
		scroll1 = new JScrollPane();
		scroll1.setViewportView(textarea1);

		textarea2 = new JTextArea();
		textarea2.setLineWrap(true);
		textarea2.setFont(new Font("Ubuntu",0,16));
		scroll2 = new JScrollPane();
		scroll2.setViewportView(textarea2);
		

		browse1 = new JButton("Browse");
		browse1.setActionCommand("cOpen");
		browse1.addActionListener(note);
		cosinebutton = new JButton("Cosine Comparison");
		cosinebutton.setActionCommand("cosine");
		cosinebutton.addActionListener(note);
		cosinebutton.setEnabled(true);
		similar = new JButton("Similarity Table");
		similar.setActionCommand("similar");
		similar.addActionListener(this);
		similar.setEnabled(true);
		bserver = new JButton("Send To Client");
		bserver.setActionCommand("bserver");
		bserver.addActionListener(this);
		bserver.setVisible(true);
		cserver = new JButton("Send To Server");
		cserver.setActionCommand("cserver");
		cserver.addActionListener(this);
		cserver.setVisible(true);
		
		
		browsetext1 = new JTextField();
		initComponents();
		cframe.setVisible(true);
	}
	public boolean create_server()throws IOException
	{
		saddress = address1.getText();
		clientname = ccnamebutton.getText();
		sport = Integer.parseInt(address2.getText());
		
		try{
			cresult.setText("Waiting for clients........");
			sersocket = new ServerSocket(sport);
			sersocket.setSoTimeout(10000);
			connectionSocket = sersocket.accept();
			ois1 = new ObjectOutputStream(connectionSocket.getOutputStream());
			serverReceive = new Thread(new ReadThread(connectionSocket));
			serverReceive.start();
			cresult.setText("Connection Stablished with client");
	}catch(IOException e){System.out.print("Connection Failed Retry.");}
	return true;
	}
	public boolean clientConnection()throws IOException
	{
		saddress = address1.getText();
		clientname = ccnamebutton.getText();
		sport = Integer.parseInt(address2.getText());
		
		try{
			clientSocket = new Socket(InetAddress.getByName(saddress),sport);
			ois2 = new ObjectOutputStream(clientSocket.getOutputStream());
			B = new Thread(new ReadThreadClient(clientSocket));
			B.start();
			cresult.setText("Connection Stablished with Server");
	}catch(IOException e){System.out.print("Connection Failed Retry.");}
	return true;
	}
	public void calculate()
	{
		try
		{
        PrintWriter pr = new PrintWriter("text2");
        pr.println(textarea2.getText());
        pr.close();
        PrintWriter pr2 = new PrintWriter("text1");
        pr2.println(textarea1.getText());
        pr2.close();
        BufferedReader reader1 = new BufferedReader(new FileReader("text1"));
    	
        BufferedReader reader2 = new BufferedReader(new FileReader("text2"));
        int r1=0,r2=0;
        String file1String="",file2String="";
        String cfile1String="",cfile2String="";
        char file1char=' ',file2char=' ';
        char nextval1=' ';
        char nextval2=' ';
        int similar=0,total=0;
        boolean val = true;
        new Similar();
        while((r1 = reader1.read()) != -1)
         {
         	r2 = reader2.read();
         	char line1 = (char)r1;
         	if(line1 != '/' && line1 != ' ')
         	{
         		file1String = file1String + line1;
         	}
         	char line2 = (char)r2;
         	if(line2 != '/' && line2 != ' ')
         	{
         		file2String = file2String + line2;
         	}
         			Similar.text1.append(file1String);
		         	if(line1 == '/' || line2 == '/')
		         	{
		         		
		         		if(line1 == '/' && line2 != '/')
		         		{
		         			while(val)
		         		{
		         			if((r1 = reader1.read()) != -1)
		      		 		{
			         			file1char = (char) r1;
			         			if(file1char == ' ')
			         			{
			         				val = false;
			         				
			         			}
		         				cfile1String +=file1char;
		         			}
		         			else
		         			{
		         				val = false;
		         			}
		         		}
		         		while((nextval1 = (char)(r1 = reader1.read())) == ' ')
         				{

         				}
		         		
		         		val = true;
		         		continue;
		         		}

		         		if(line2 == '/' && line1 != '/')
		         		{
		         			while(val)
		         		{
		         			if((r2 = reader2.read()) != -1)
		      				{
		         				file2char = (char) r2;
		         				if(file2char == ' ')
		         				{
		         					val = false;
		         				}
		         				cfile2String += file2char;
		         			}
		         			else
		         			{
		         				val = false;
		         			}
		         	}
		         	while((nextval2 = (char)(r2 = reader2.read())) == ' ')
         				{

         				}
		         	val = true;
		         		continue;
		         		}

		         		while(val)
		         		{
		         			if((r1 = reader1.read()) != -1)
		      		 		{
			         			file1char = (char) r1;
			         			if(file1char == ' ')
			         			{
			         				val = false;
			         				
			         			}
		         				cfile1String +=file1char;
		         			}
		         			else
		         			{
		         				val = false;
		         			}
		         		}
		         		val = true;
		         		while((nextval1 = (char)(r1 = reader1.read())) == ' ')
         				{

         				}
		         		
		   
		         		while(val)
		         		{
		         			if((r2 = reader2.read()) != -1)
		      				{
		         				file2char = (char) r2;
		         				if(file2char == ' ')
		         				{
		         					val = false;
		         				}
		         				cfile2String += file2char;
		         			}
		         			else
		         			{
		         				val = false;
		         			}
		         	}
		         	val = true;
		         	while((nextval2 = (char)(r2 = reader2.read())) == ' ')
         				{

         				}
         				
         				Similar.text1.append("\t");
		         	if(cfile1String.equals(cfile2String))
		         	{
		         		similar += 1;
		         		total += 1;
		         		Similar.text1.append(cfile1String + "\t " + cfile2String +" "+"     Similar");
		         		Similar.text1.append("\n");
		         		Similar.text1.append(""+nextval1);
		         		
		         	}
	         		else
	         		{
	         			total += 1;
	         			Similar.text1.append(cfile1String + "\t " + cfile2String+" "+"     Not Similar");
	         			Similar.text1.append("\n");
	         			Similar.text1.append(""+nextval1);
	         		}
		        }
		         	

		         	
	         	file1String = "";
	         	file2String = "";
	         	cfile1String ="";
	         	cfile2String ="";
        }
        reader1.close();
         
        reader2.close();
    }catch(Exception ex){}
	}
	public void actionPerformed(ActionEvent e)
	{
		String val = e.getActionCommand();
		if(val.equals("similar"))
		{
				calculate();
		}
		if(val.equals("ConnectS"))
		{
			try{

			if(create_server())
			{
				cresult.setText("Connection Stablished.");
				bserver.setVisible(true);
			}
			else
			{
				cresult.setText("Connection Failed Retry.");
			}
		}catch(IOException ex){System.out.print("Connection Failed Retry.");};
		}
		if(val.equals("ConnectC"))
		{
			try{

			if(clientConnection())
			{
				cresult.setText("Connection Stablished.");
				bserver.setVisible(true);
			}
			else
			{
				cresult.setText("Connection Failed Retry.");
			}
		}catch(IOException ex){System.out.print("Connection Failed Retry.");};
		}
		if(val.equals("bserver"))
		{
			try{
			smessage = textarea1.getText();
			ois1.writeObject(smessage);
			}catch(IOException ex){};
		}
		if(val.equals("cserver"))
		{
			try{
			smessage = textarea1.getText();
			ois2.writeObject(smessage);
			}catch(IOException ex){};
		}
		if(val.equals("bstop"))
		{
			String n = ccnamebutton.getText(); 
			try
			{
				if(sersocket != null)
				{
					serverReceive.stop();
					ReadThread.rrclientSocket.close();
					ReadThread.ois11.close();
					connectionSocket.close();
					sersocket.close();
				}
				if(clientSocket != null)
				{
					B.stop();
					ReadThreadClient.crclientSocket.close();
					ReadThreadClient.ois12.close();
					clientSocket.close();
				}
			}catch(Exception eee){}

		}
	}
	public void initComponents()
	{
		GroupLayout layout = new GroupLayout(cframe.getContentPane());
		cframe.getContentPane().setLayout(layout);
		formulapanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Formula"));
		browsepanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Add File to compare"));
		text1.setBorder(javax.swing.BorderFactory.createTitledBorder("File 1"));
		text2.setBorder(javax.swing.BorderFactory.createTitledBorder("File 2"));
		connectionpanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Connection"));

//Stting Connection Panel
		GroupLayout cpanellayout = new GroupLayout(connectionpanel);
		connectionpanel.setLayout(cpanellayout);
		cpanellayout.setHorizontalGroup(
			cpanellayout.createParallelGroup()
				.addGroup(cpanellayout.createSequentialGroup()
					.addGap(10,10,10)
					.addComponent(address,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(address1,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addContainerGap(100,Short.MAX_VALUE)
					)
				.addGroup(cpanellayout.createSequentialGroup()
					.addGap(10,10,10)
					.addComponent(port,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(address2,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addContainerGap(100,Short.MAX_VALUE)
					)
				.addGroup(cpanellayout.createSequentialGroup()
					.addGap(10,10,10)
					.addComponent(ccname,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(ccnamebutton,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addContainerGap(100,Short.MAX_VALUE)
					)
				.addGroup(cpanellayout.createSequentialGroup()
					.addGap(10,10,10)
					.addComponent(cresult,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
					)
				.addGroup(cpanellayout.createSequentialGroup()
					.addGap(10,10,10)
					.addComponent(connectButton,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(clientButton,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(bstop,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
					)

			);
		cpanellayout.setVerticalGroup(
			cpanellayout.createParallelGroup()
				.addGroup(cpanellayout.createSequentialGroup()
						.addComponent(address,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(port,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(ccname,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(cresult,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(connectButton,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						)
				.addGroup(cpanellayout.createSequentialGroup()
						.addComponent(address1,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(address2,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(ccnamebutton,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(30,30,30)
						.addComponent(clientButton,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						)
				.addGroup(cpanellayout.createSequentialGroup()
						.addGap(30,30,30)
						.addGap(30,30,30)
						.addGap(30,30,30)
						.addGap(30,30,30)
						.addComponent(bstop,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						)
			);
//SETTING FORMULA PANEL
		GroupLayout panellayout = new GroupLayout(formulapanel);
		formulapanel.setLayout(panellayout);
		panellayout.setHorizontalGroup(
			panellayout.createParallelGroup()
				.addGroup(panellayout.createSequentialGroup()
					.addGap(10,10,10)
					.addComponent(cosinebutton,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(similar,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(bserver,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(cserver,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addContainerGap(100,Short.MAX_VALUE)
					)
			);
		panellayout.setVerticalGroup(
			panellayout.createParallelGroup()
				.addGroup(panellayout.createSequentialGroup()
					.addGap(8,8,8)
					.addGroup(panellayout.createParallelGroup()
						.addComponent(cosinebutton,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(similar,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(bserver,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(cserver,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						)
					.addContainerGap(100,Short.MAX_VALUE)
					)
			);
//SETTING BROWSER PANEL
		GroupLayout panellayout2 = new GroupLayout(browsepanel);
		browsepanel.setLayout(panellayout2);
		panellayout2.setHorizontalGroup(
			panellayout2.createParallelGroup()
				.addGroup(panellayout2.createSequentialGroup()
					.addContainerGap(100,Short.MAX_VALUE)
					
					.addGroup(panellayout2.createParallelGroup()
						.addGap(10,10,10)
						.addComponent(labeltext1,javax.swing.GroupLayout.PREFERRED_SIZE,100,javax.swing.GroupLayout.PREFERRED_SIZE)
						)
					.addGroup(panellayout2.createParallelGroup()
						.addGap(10,10,10)
						.addComponent(browsetext1,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
						)
					.addGroup(panellayout2.createParallelGroup()
						.addGap(10,10,10)
						.addComponent(browse1,javax.swing.GroupLayout.PREFERRED_SIZE,100,javax.swing.GroupLayout.PREFERRED_SIZE)
						)
					.addGap(30,30,30)
					)
			);
		panellayout2.setVerticalGroup(
			panellayout2.createParallelGroup()
				.addGroup(panellayout2.createSequentialGroup()
					.addGap(8,8,8)
						.addGroup(panellayout2.createParallelGroup()
							.addGroup(panellayout2.createSequentialGroup()
								.addGap(10,10,10)
								.addComponent(labeltext1,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
								)
							.addGroup(panellayout2.createSequentialGroup()
								.addGap(10,10,10)
								.addComponent(browsetext1,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
								)
							.addGroup(panellayout2.createSequentialGroup()
								.addGap(10,10,10)
								.addComponent(browse1,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
								)
						)
					.addContainerGap(30,Short.MAX_VALUE)
					)
			);
//SETTING text1panel LAYOUT
		GroupLayout textlayout1 = new GroupLayout(text1);
		text1.setLayout(textlayout1);

		textlayout1.setHorizontalGroup(
			textlayout1.createParallelGroup()
				.addGroup(textlayout1.createSequentialGroup()
					.addComponent(scroll1,javax.swing.GroupLayout.PREFERRED_SIZE,490,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addContainerGap(100,Short.MAX_VALUE)
					)
			);
		textlayout1.setVerticalGroup(
			textlayout1.createParallelGroup()
				.addGroup(textlayout1.createSequentialGroup()
					.addComponent(scroll1,javax.swing.GroupLayout.PREFERRED_SIZE,290,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30,Short.MAX_VALUE)
					)		
			);
//SETTING text2panel LAYOUT
		GroupLayout textlayout2 = new GroupLayout(text2);
		text2.setLayout(textlayout2);

		textlayout2.setHorizontalGroup(
			textlayout2.createParallelGroup()
				.addGroup(textlayout2.createSequentialGroup()
					.addComponent(scroll2,javax.swing.GroupLayout.PREFERRED_SIZE,490,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addContainerGap(100,Short.MAX_VALUE)
					)
			);
		textlayout2.setVerticalGroup(
			textlayout2.createParallelGroup()
				.addGroup(textlayout2.createSequentialGroup()
					.addComponent(scroll2,javax.swing.GroupLayout.PREFERRED_SIZE,290,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30,Short.MAX_VALUE)
					)		
			);
//SETTING FRAME LAYOUT
		layout.setHorizontalGroup(
			layout.createParallelGroup()
			.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup()
							.addGroup(layout.createSequentialGroup()
							.addComponent(formulapanel,javax.swing.GroupLayout.PREFERRED_SIZE,1000,javax.swing.GroupLayout.PREFERRED_SIZE)
							
							)
							.addComponent(browsepanel,javax.swing.GroupLayout.PREFERRED_SIZE,500,javax.swing.GroupLayout.PREFERRED_SIZE)
							.addComponent(connectionpanel,javax.swing.GroupLayout.PREFERRED_SIZE,700,javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGroup(layout.createSequentialGroup()
								.addComponent(text1,javax.swing.GroupLayout.PREFERRED_SIZE,400,javax.swing.GroupLayout.PREFERRED_SIZE)								
								.addGap(50,50,50)
								.addComponent(text2,javax.swing.GroupLayout.PREFERRED_SIZE,400,javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(200,Short.MAX_VALUE)			
								)
					)		
				)		
			);

		layout.setVerticalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup()
					.addGap(30,30,30)
					.addComponent(formulapanel,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					
					)
					.addGap(30,30,30)
					.addComponent(browsepanel,javax.swing.GroupLayout.PREFERRED_SIZE,120,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(connectionpanel,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(40,40,40)
						.addGroup(layout.createParallelGroup()
							.addComponent(text1,javax.swing.GroupLayout.PREFERRED_SIZE,320,javax.swing.GroupLayout.PREFERRED_SIZE)
							.addComponent(text2,javax.swing.GroupLayout.PREFERRED_SIZE,320,javax.swing.GroupLayout.PREFERRED_SIZE)	
							)
					)
			);

		cframe.pack();
	}
}
class ReadThread extends Thread
{
	public static Socket rrclientSocket;
	boolean exit = false;
	public static ObjectInputStream ois11;
	String fmessage=" ";
	ReadThread(Socket rrclientSocket)
	{
		this.rrclientSocket = rrclientSocket;
	}
	public void run()
	{
		try{
		ois11 = new ObjectInputStream(rrclientSocket.getInputStream());	
	}catch(IOException ex){}
		
		while(!fmessage.equals("over"))
		{
			try{
				fmessage = (String) ois11.readObject();
				Comparedemo.textarea2.setText(fmessage);
				
			}catch(IOException e){}
			catch(Exception ee){}
		}
	}

}
class ReadThreadClient extends Thread
{
	public static Socket crclientSocket;
	public static ObjectInputStream ois12;
	String fmessage=" ";
	ReadThreadClient(Socket crclientSocket)
	{
		this.crclientSocket = crclientSocket;
	}
	public void run()
	{
		try{
		ois12 = new ObjectInputStream(crclientSocket.getInputStream());
		}catch(IOException ex){}
		while(!fmessage.equals("over"))
		{System.out.print("yes2");
			try{ 
				fmessage = (String) ois12.readObject();
				Comparedemo.textarea2.setText(fmessage);

			}catch(IOException e){}
			catch(Exception ee){}
			
		}
	}
}
	


