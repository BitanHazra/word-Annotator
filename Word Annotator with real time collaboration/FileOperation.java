import javax.swing.JOptionPane;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.JFileChooser;

public class FileOperation
{
	Notepad note;

	boolean saved;
	boolean newFileFlag;
	String fileName;
	String appname;
	File file;
	JFileChooser filechooser;
	
	

	public FileOperation(Notepad notepara)
	{
		note = notepara;
		
		saved = true;
		newFileFlag = true;
		fileName = new String("Word Annotator");
		file = new File(fileName);
		filechooser = new JFileChooser();
		note.f.setTitle("Word Annotator");

	}
	void save(File filesave)
	{
		try{
		FileWriter filewriter = new FileWriter(filesave);
		filewriter.write(note.ta.getText());
		
			filewriter.close();
		}catch(IOException exe){}
		
	}
	void saveThis()
	{
		try{
		FileWriter filewriter = new FileWriter(file);
		filewriter.write(note.ta.getText());
		
			filewriter.close();
		}catch(IOException exe){}
	}
	void saveAs()
	{
		File filesave;
		filechooser.setDialogTitle("Save As..");
		filechooser.setApproveButtonText("Save As");
		filechooser.setApproveButtonMnemonic(83);
		filechooser.setApproveButtonToolTipText("Click me to Save the File");
		for(;;)	
		{	if(filechooser.showSaveDialog(note.f)!=0)
				return;
			filesave = filechooser.getSelectedFile();
			if(filesave.exists()){
				if (JOptionPane.showConfirmDialog(note.f, "<html>" + filesave.getPath() + " already exists.<br>Do you want to replace it?<html>", "Save As", 0) == 0) 
	          		break;
			}
		}
		save(filesave);
	}

	void openFile() throws IOException
	{
		if(!confirmSave())
		{
			return;
		}
		
		filechooser.setDialogTitle("File chooser...");
		filechooser.setApproveButtonText("Open");
		filechooser.setApproveButtonMnemonic(79);
		filechooser.setApproveButtonToolTipText("Click me to open the selected File");
		filechooser.addChoosableFileFilter(new FileNameExtensionFilter("Text File Document(*.txt)","txt"));
		filechooser.setAcceptAllFileFilterUsed(true);

		File locateFile = null;
			if(filechooser.showOpenDialog(note.f)!=0)
				return;
			locateFile = filechooser.getSelectedFile();
			file = locateFile;
			String filepath = locateFile.getPath();
				try{
				BufferedReader br = new BufferedReader(new FileReader(filepath));
        		String s1 = " ";
        		String s2 = " ";
          		while((s1 = br.readLine())!= null)
          		{
            		s2 += s1 +"\n";
          		}
          		note.ta.setText(s2);
          		String fileName = locateFile.getName();
          		note.tp.setTitleAt(0,fileName);
          		br.close();
          	}catch(FileNotFoundException e){}

	}

	void copenFile(String str,Comparedemo comparedemo) throws IOException
	{
		
		filechooser.setDialogTitle("File chooser...");
		filechooser.setApproveButtonText("Open");
		filechooser.setApproveButtonMnemonic(79);
		filechooser.setApproveButtonToolTipText("Click me to open the selected File");
		filechooser.addChoosableFileFilter(new FileNameExtensionFilter("Text File Document(*.txt)","txt"));
		filechooser.setAcceptAllFileFilterUsed(true);
		
		File locateFile = null;
			if(filechooser.showOpenDialog(note.f)!=0)
				return;
			locateFile = filechooser.getSelectedFile();
			file = locateFile;
			String filepath = locateFile.getPath();
				try{
				BufferedReader br = new BufferedReader(new FileReader(filepath));
        		String s1 = " ";
        		String s2 = " ";
          		while((s1 = br.readLine())!= null)
          		{
            		s2 += s1 +"\n";
          		}
          		//note.ta.setText(s2);
          		String fileName = locateFile.getName();
          		if(str.equals("browsetext1"))
          			{
          				
          				comparedemo.browsetext1.setText(fileName);
          				comparedemo.textarea1.setText(s2);

          			}
          		
          		br.close();
          	}catch(FileNotFoundException e){}

	}

	boolean confirmSave()
	{
		String str = "<html>The Text in the "+fileName+"is changed<br>"+"do you want to save the change?<html>";

		if(!saved)
		{
			int i = JOptionPane.showConfirmDialog(note.f,str,"Word Annotator",1);
			if(i == 2)
				return false;
			if(i == 0)
				return false;
		}
		return true;
	}

	public void newFile()
	{
		if(!confirmSave())
		{return;}
		note.ta.setText("");
		fileName = "Untitled";
		saved = true;
		newFileFlag = true;
		note.f.setTitle("Word Annotator");
	}
}
