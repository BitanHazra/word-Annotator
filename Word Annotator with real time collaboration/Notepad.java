import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import javax.swing.JOptionPane;
import java.io.IOException;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Arrays;

public class Notepad implements KeyListener,ActionListener,MouseListener
{
	JFrame f;
	JLabel statusBar;
	JTextArea ta;
	JMenuItem deleteItem;
  	JMenuItem findItem; 
  	JMenuItem findNextItem;
  	JMenuItem replaceItem;
  	JMenuItem gotoItem;
  	JMenuItem selectAllItem;
  	JMenuItem cut;
  	JMenuItem copy;
  	JMenuItem paste;
  	JMenuItem undu;
  	JMenuItem find;
  	JMenuItem findnext;
  	JMenuItem replace;
  	JMenuItem mgoto;
  	JMenuItem selectall;
  	JMenuItem datetime;
  	JMenuItem helptopic;
  	JMenuItem aboutus;
  	JTabbedPane tp;
  	JButton badd,bnew,bcompare,bsave,bclose,bconnect;
  	JPanel bpanel;

  	FileOperation fileoperation;
  	Annotationcontent annotationcontent;
  	Cosineresult cosine;
  	Comparedemo cmp;
  	FindDialog findd;
  	JScrollPane scroll;
  	static Notepad note;
  	String selectedtext;
  	String replacedtext;



	String filename="";
	String applicationname = "NotePad";

	public Notepad()
	{
		f = new JFrame("Word Annotator");
		fileoperation = new FileOperation(this);

		statusBar = new JLabel("||			ln 1, Col 1  ",4);
		ta = new JTextArea(30,60);
		ta.addMouseListener(this);
		ta.setLineWrap(true);
		ta.setFont(new Font("Ubuntu",0,16));
		scroll = new JScrollPane();
		scroll.setViewportView(ta);

		
		tp = new JTabbedPane();

		badd = new JButton("Add");
		badd.setActionCommand("Open");
		badd.addActionListener(this);

		bsave = new JButton("Save");
		bsave.setActionCommand("Save");
		bsave.addActionListener(this);
		
		bclose = new JButton("Close");
		bclose.setActionCommand("Exit");
		bclose.addActionListener(this);
		
		bcompare = new JButton("Compare");
		bcompare.setActionCommand("compare");
		bcompare.addActionListener(this);
		
		bconnect = new JButton("Annotate");
		bconnect.setActionCommand("Annotate");
		bconnect.addActionListener(this);

		bnew = new JButton("New");
		bnew.setActionCommand("New");
		bnew.addActionListener(this);
		
		bpanel = new JPanel(new GridLayout(0,1));
		
		
		bpanel.add(bnew);
		bpanel.add(badd);
		bpanel.add(bcompare);
		bpanel.add(bsave);
		bpanel.add(bconnect);
		bpanel.add(bclose);

		f.add(statusBar,"South");
		f.add(bpanel,BorderLayout.EAST);
		f.add(new JLabel(" "),"West");
		tp.add("Untitled",scroll);
		f.add(tp);

		 ta.addCaretListener(new CaretListener()
    	{
    		@Override
    		public void caretUpdate(CaretEvent ce)
    		{
    			int k=0,j=0,i=0;
    			try
    			{
	    			k = ta.getCaretPosition();
	    			i =  ta.getLineOfOffset(k);
	    			j = k - ta.getLineStartOffset(i);
    			}catch(Exception localException){ }

    			if(k == 0 && j == 0 )
    			{
    				i=0;
    				j=0;
    			}
    			statusBar.setText("||       Ln " + (i + 1) + ", Col " + (j + 1));
    		}
		});

		menucreator(f);
		f.setBounds(330,250,600,300);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public JCheckBoxMenuItem createCheckBoxMenuItem(String menuname,int key,JMenu menubar,ActionListener actionlistener)
	{
		JCheckBoxMenuItem check = new JCheckBoxMenuItem(menuname);
		check.setMnemonic(key);
		check.addActionListener(actionlistener);
		check.setEnabled(false);
		menubar.add(check);

		return check;

	}
	public JMenu createmenu(String menuname,int key,JMenuBar menubar)
	{
		JMenu menu = new JMenu(menuname);
		menu.setMnemonic(key);
		menubar.add(menu);
		return menu;
	}
	public JMenuItem createMenuItem(String menuname,int key1,JMenu jmenu,int key2,ActionListener actionlistener)
	{
		JMenuItem menuitem = new JMenuItem(menuname,key1);
		menuitem.addActionListener(actionlistener);
		menuitem.setAccelerator(KeyStroke.getKeyStroke(key2,2));
		jmenu.add(menuitem);

		return menuitem;

	}
		public JMenuItem createMenuItem(String menuname,int key1,JMenu jmenu,ActionListener actionlistener)
	{
		JMenuItem menuitem = new JMenuItem(menuname,key1);
		menuitem.addActionListener(actionlistener);
		jmenu.add(menuitem);

		return menuitem;

	}
	public void menucreator(JFrame frame)
	{
		JMenuBar menubar = new JMenuBar();

		JMenu file =  createmenu("File",70,menubar);
		JMenu edit =  createmenu("Edit",69,menubar);
		JMenu format =  createmenu("Format",79,menubar);
		JMenu view =  createmenu("View",86,menubar);
		JMenu help =  createmenu("Help",72,menubar);

		createMenuItem("New",78,file,78,this);
		createMenuItem("Open",79,file,79,this);
		createMenuItem("Save",83,file,83,this);
		createMenuItem("Save As",65,file,65,this);
		file.addSeparator();
		createMenuItem("Print",80,file,80,this);
		createMenuItem("Exit",88,file,this);

		
		undu = createMenuItem("Undo",85,edit,90,this);
		undu.setEnabled(false);
		edit.addSeparator();
		cut = createMenuItem("Cut",84,edit,88,this);
		cut.setEnabled(false);
		copy = createMenuItem("Copy",67,edit,67,this);
		copy.setEnabled(false);
		paste = createMenuItem("Paste",80,edit,86,this);
		deleteItem = createMenuItem("Delete",76,edit,this);
		deleteItem.setEnabled(false);
		edit.addSeparator();
		find = createMenuItem("Find",70,edit,70,this);
		find.setEnabled(false);
		findnext = createMenuItem("Find Next",78,edit,this);
		findnext.setEnabled(false);
		findnext.setAccelerator(KeyStroke.getKeyStroke(114, 0));
		replace = createMenuItem("Replace",82,edit,72,this);
		replace.setEnabled(false);
		mgoto = createMenuItem("Goto",71,edit,71,this);
		mgoto.setEnabled(false);
		edit.addSeparator();
		selectall = createMenuItem("SelectAll..",65,edit,65,this);
		selectall.setEnabled(false);
		datetime = createMenuItem("Date/Time",68,edit,this);
		datetime.setAccelerator(KeyStroke.getKeyStroke(116, 0));
		edit.addSeparator();

		createCheckBoxMenuItem("Word Wrap", 87, format, this);
    
	    createMenuItem("Font...", 70, format, this);
	    format.addSeparator();
	    createMenuItem("Set Text color...", 84, format, this);
	    createMenuItem("Set Pad color...", 80, format, this);
	    
	    createCheckBoxMenuItem("Status Bar", 83,view, this).setSelected(true);
	    
	   // LookAndFeelMenu.createLookAndFeelMenuItem(localJMenu4, f);
    

		helptopic = createMenuItem("Help topic",72,help,75,this);
		helptopic.setEnabled(false);
		aboutus = createMenuItem("About us",65,help,65,this);

		frame.setJMenuBar(menubar);

		ta.addKeyListener(this);
		
			
	}
	public void actionPerformed(ActionEvent e)
	{
		String str = e.getActionCommand();
		String s1="";
		String s3="";
		
		
		if(str.equals("next"))
		{
			annotationcontent.list.addItem("sads");
			annotationcontent.list.removeAllItems();
			int i = 0;
            int caretPosition = ta.getCaretPosition();
            String currentText = ta.getText();
            String right = currentText.substring(caretPosition, currentText.length());
            while(right.charAt(i) == ' ')
            {
            	i +=1;
            }
           	 
            ta.setCaretPosition(caretPosition+i);
            caretPosition = ta.getCaretPosition();
            currentText = ta.getText();
            right = currentText.substring(caretPosition, currentText.length());
            i=0;
            
            while(right.charAt(i) != ' ')
            {
            	s1 = s1 + right.charAt(i);
            	i +=1;
            }
            s1 = s1.replaceAll("\\s+","");
            ta.setCaretPosition(caretPosition+i);
            int z=0;
            String line = "";
	         	try {
	         		BufferedReader br = new BufferedReader(new FileReader("noted"));
            		while((line = br.readLine()) != null)
            		{
                	try{
                	//System.out.println(line);
                	String[] words = line.split(" ");
                	String[] ss = words[0].split("\t",2);
                	if(ss[0].equals(s1))
                	{
                	annotationcontent.list.addItem(ss[1]);
                	}
                		}catch(ArrayIndexOutOfBoundsException aindex){}
            		}
            	br.close();
        		} catch (IOException xe) {
            // TODO Auto-generated catch block
            							xe.printStackTrace();
        								}
    	}
		         	
		if(str.equals("New"))
		{
			fileoperation.newFile();
			tp.setTitleAt(0,"Untitled");
		}
		if(str.equals("Open")) 
		{
			try{
			fileoperation.openFile();
		}catch(IOException ex){}
		}
		if(str.equals("cOpen")) 
		{
			try{
			fileoperation.copenFile("browsetext1",cmp);
			
		}catch(IOException ex){}
		}
		if(str.equals("cOpen2")) 
		{
			try{
			fileoperation.copenFile("browsetext2",cmp);
		}catch(IOException ex){}
		}
		if(str.equals("Save")) 
		{
			fileoperation.saveThis();
		}
		if(str.equals("Save As")) 
		{
			fileoperation.saveAs();
		}
		if(str.equals("Print"))
		{
			JOptionPane.showMessageDialog(f,"<html>Not Able to Detect printer in your system</html>");
		}
		if(str.equals("Exit"))
		{
			if(fileoperation.confirmSave())
				System.exit(0);
		}

		if (str.equals("Cut")){
			ta.cut();
		}
		if (str.equals("Copy")){
			ta.copy();
		}
		if (str.equals("Paste")){
			ta.paste();
		}
		if (str.equals("Find")){
			ta.paste();
		}
		if (str.equals("Find")){
			findd = new FindDialog(ta);
		}
		if (str.equals("compare")){
				cmp = new Comparedemo(note);
		}
		if (str.equals("cosine")){
			cosine = new Cosineresult(note);
		}
		if(str.equals("Annotate"))
		{
			if((ta.getSelectedText()) != null)
		{
			String selectedtext = ta.getSelectedText();
			int len = selectedtext.length();
			int count = 0;
			for(int i = 0;i<len;i++)
			{
				if(selectedtext.charAt(i) == ' ')
				{
					count += 1;
				}
			}
			if(count == 0)
			{
				if(annotationcontent == null)
				{
					annotationcontent = new Annotationcontent(note);	
				}
				else
				{
				new Annotationcontent(note);
				}
			}
		}

		}

		//Annotation Content Event handling
		if(str.equals("CC"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/CC",ta.getCaretPosition());
		}
		if(str.equals("CD"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/CD",ta.getCaretPosition());
			
		}
		if(str.equals("DT"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/DT",ta.getCaretPosition());
			
		}
		if(str.equals("EX"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/EX",ta.getCaretPosition());
			
		}
		if(str.equals("FW"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/FW",ta.getCaretPosition());
			
		}
		if(str.equals("IN"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/IN",ta.getCaretPosition());
			
		}
		if(str.equals("JJ"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/JJ",ta.getCaretPosition());
			
		}
		if(str.equals("JJR"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/JJR",ta.getCaretPosition());
			
		}
		if(str.equals("JJS"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/JJS",ta.getCaretPosition());
			
		}
		if(str.equals("LS"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/LS",ta.getCaretPosition());
		}
		if(str.equals("MD"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/MD",ta.getCaretPosition());
		}
		if(str.equals("NN"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/NN",ta.getCaretPosition());
		}
		if(str.equals("NNS"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/NNS",ta.getCaretPosition());
		}
		if(str.equals("NNP"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/NNP",ta.getCaretPosition());
		}
		if(str.equals("NNPS"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/NNPS",ta.getCaretPosition());
		}
		if(str.equals("PDT"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/PDT",ta.getCaretPosition());
		}
		if(str.equals("POS"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/POS",ta.getCaretPosition());
		}
		if(str.equals("PRP"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/PRP",ta.getCaretPosition());
		}
		if(str.equals("PRP$"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/PRP$",ta.getCaretPosition());
		}
		if(str.equals("RB"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/RB",ta.getCaretPosition());
		}
		if(str.equals("RBR"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/RBR",ta.getCaretPosition());
		}
		if(str.equals("RBS"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/RBS",ta.getCaretPosition());
		}
		if(str.equals("RP"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/RP",ta.getCaretPosition());
		}
		if(str.equals("TO"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/TO",ta.getCaretPosition());
		}
		if(str.equals("SYM"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/SYM",ta.getCaretPosition());
		}
		if(str.equals("UH"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/UH",ta.getCaretPosition());
		}
		if(str.equals("VB"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/VB",ta.getCaretPosition());
		}
		if(str.equals("VBD"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/VBD",ta.getCaretPosition());
		}
		if(str.equals("VBG"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/VBG",ta.getCaretPosition());
		}
		if(str.equals("VBN"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/VBN",ta.getCaretPosition());
		}
		if(str.equals("VBP"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/VBP",ta.getCaretPosition());
		}
		if(str.equals("VBZ"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/VBZ",ta.getCaretPosition());
		}
		if(str.equals("WDT"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/WDT",ta.getCaretPosition());
		}
		if(str.equals("WP"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/WP",ta.getCaretPosition());
		}
		if(str.equals("WP$"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/WP$",ta.getCaretPosition());
		}
		if(str.equals("WRB"))
		{
			int len = ta.getCaretPosition();
			ta.setCaretPosition(len);
			ta.insert("/WRB",ta.getCaretPosition());
		}

		

	}
	public void keyPressed(KeyEvent keyevent)
	{
		if(ta.getText().length() >0)
			{
				undu.setEnabled(true);
				cut.setEnabled(true);
				copy.setEnabled(true);
				paste.setEnabled(true);
				deleteItem.setEnabled(true);
				find.setEnabled(true);
				findnext.setEnabled(true);
				replace.setEnabled(true);
				mgoto.setEnabled(true);
				selectall.setEnabled(true);
			}
			else{
				undu.setEnabled(false);
				cut.setEnabled(false);
				copy.setEnabled(false);
				paste.setEnabled(false);
				deleteItem.setEnabled(false);
				find.setEnabled(false);
				findnext.setEnabled(false);
				replace.setEnabled(false);
				mgoto.setEnabled(false);
				selectall.setEnabled(false);
			}
		
	}
	public void keyTyped(KeyEvent keyevent){}
	public void keyReleased(KeyEvent keyevent){}
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e)
	{
		
		
	}
	public Comparedemo getInstance()
	{
		if(cmp == null)
		{
			cmp = new Comparedemo(note);
		}

		return cmp;
	}
	
	

	public static void main(String[] args)
	{
		 note = new Notepad();
	}
}
