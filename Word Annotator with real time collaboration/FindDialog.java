import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FindDialog
{
	JFrame fframe;
	JButton fclose;
	JButton ffind;
	JButton fnext;
	JTextArea ftext;
	JLabel flabel;

	public FindDialog(JTextArea noteta)
	{
	
		flabel = new JLabel("Enter Text:");
		fframe = new JFrame("Find");
		ffind = new JButton("Find");
		fnext = new JButton("Find Next");
		fclose = new JButton("Close");
		ftext = new JTextArea(10,10);

		flabel.setBounds(10,5,100,30);
		ffind.setBounds(360,5,100,30);
		fnext.setBounds(360,45,100,30);
		fclose.setBounds(360,85,100,30);
		ftext.setBounds(140,10,200,25);

		fframe.add(flabel);
		fframe.add(ffind);
		fframe.add(fnext);
		fframe.add(fclose);
		fframe.add(ftext);

		fframe.setLayout(null);
		fframe.setSize(500,150);
		fframe.setDefaultCloseOperation(fframe.EXIT_ON_CLOSE);
		fframe.setVisible(true);
	}
}