import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class Annotationcontent
{
	JFrame acFrame;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30,b31,b32,b33,b34,b35,b36;
	JPanel panel;
	JButton next;
	Notepad note;
	static JComboBox list;
	public Annotationcontent(Notepad notepad)
	{
		note = notepad;
		acFrame = new JFrame("Annotation Content");
		panel = new JPanel();
		
          
        //create list 
        list= new JComboBox();
        
		 
		next = new JButton("Next");
		next.setActionCommand("next");
		next.addActionListener(note);
		next.setToolTipText("Click for next Annotation");

		b1 = new JButton("CC");
		b1.setActionCommand("CC");
		b1.addActionListener(note);
		b1.setToolTipText("coordin,conjunction");

		b2 = new JButton("CD");
		b2.setActionCommand("CD");
		b2.addActionListener(note);
		b2.setToolTipText("cardinal,number");

		b3 = new JButton("DT");
		b3.setActionCommand("DT");
		b3.addActionListener(note);
		b3.setToolTipText("determiner");

		b4 = new JButton("EX");
		b4.setActionCommand("EX");
		b4.addActionListener(note);
		b4.setToolTipText("existential 'there'");

		b5 = new JButton("FW");
		b5.setActionCommand("FW");
		b5.addActionListener(note);
		b5.setToolTipText("foreign word");

		b6 = new JButton("IN");
		b6.setActionCommand("IN");
		b6.addActionListener(note);
		b6.setToolTipText("preposition,sub-conj");

		b7 = new JButton("JJ");
		b7.setActionCommand("JJ");
		b7.addActionListener(note);
		b7.setToolTipText("adjective");

		b8 = new JButton("JJR");
		b8.setActionCommand("JJR");
		b8.addActionListener(note);
		b8.setToolTipText("adj...,comparative");

		b9 = new JButton("JJS");
		b9.setActionCommand("JJS");
		b9.addActionListener(note);
		b9.setToolTipText("adj...,sprelative");

		b10 = new JButton("LS");
		b10.setActionCommand("LS");
		b10.addActionListener(note);
		b10.setToolTipText("List item Marker");

		b11 = new JButton("MD");
		b11.setActionCommand("MD");
		b11.addActionListener(note);
		b11.setToolTipText("model");

		b12 = new JButton("NN");
		b12.setActionCommand("NN");
		b12.addActionListener(note);
		b12.setToolTipText("noun,sing,or mass");

		b13 = new JButton("NNS");
		b13.setActionCommand("NNS");
		b13.addActionListener(note);
		b13.setToolTipText("noun,plural");

		b14 = new JButton("NNP");
		b14.setActionCommand("NNP");
		b14.addActionListener(note);
		b14.setToolTipText("proper noun,singular");

		b15 = new JButton("NNPS");
		b15.setActionCommand("NNPS");
		b15.addActionListener(note);
		b15.setToolTipText("proper noun,plural");

		b16 = new JButton("PDT");
		b16.setActionCommand("PDT");
		b16.addActionListener(note);
		b16.setToolTipText("predeterminer");

		b17 = new JButton("POS");
		b17.setActionCommand("POS");
		b17.addActionListener(note);
		b17.setToolTipText("possessive ending");

		b18 = new JButton("PRP");
		b18.setActionCommand("PRP");
		b18.addActionListener(note);
		b18.setToolTipText("personal pronoun");

		b19 = new JButton("RB");
		b19.setActionCommand("RB");
		b19.addActionListener(note);
		b19.setToolTipText("adverb");

		b20 = new JButton("RBR");
		b20.setActionCommand("RBR");
		b20.addActionListener(note);
		b20.setToolTipText("adverb,comparative");

		b21 = new JButton("RBS");
		b21.setActionCommand("RBS");
		b21.addActionListener(note);
		b21.setToolTipText("adverb,superlative");

		b22 = new JButton("RP");
		b22.setActionCommand("RP");
		b22.addActionListener(note);
		b22.setToolTipText("particle");

		b23 = new JButton("SYM");
		b23.setActionCommand("SYM");
		b23.addActionListener(note);
		b23.setToolTipText("symbol");

		b24 = new JButton("TO");
		b24.setActionCommand("TO");
		b24.addActionListener(note);
		b24.setToolTipText("to");

		b25 = new JButton("UH");
		b25.setActionCommand("UH");
		b25.addActionListener(note);
		b25.setToolTipText("interjective");

		b26 = new JButton("VB");
		b26.setActionCommand("VB");
		b26.addActionListener(note);
		b26.setToolTipText("verb,base form");

		b27 = new JButton("VBD");
		b27.setActionCommand("VBD");
		b27.addActionListener(note);
		b27.setToolTipText("verb,past tense");

		b28 = new JButton("VBG");
		b28.setActionCommand("VBG");
		b28.addActionListener(note);
		b28.setToolTipText("verb gerund");

		b29 = new JButton("VBN");
		b29.setActionCommand("VBN");
		b29.addActionListener(note);
		b29.setToolTipText("verb,past participle");

		b30 = new JButton("VBP");
		b30.setActionCommand("VBP");
		b30.addActionListener(note);
		b30.setToolTipText("verb,non-3sg pres");

		b31 = new JButton("VBZ");
		b31.setActionCommand("VBZ");
		b31.addActionListener(note);
		b31.setToolTipText("verb,3sg pres");

		b32 = new JButton("WDT");
		b32.setActionCommand("WDT");
		b32.addActionListener(note);
		b32.setToolTipText("wh-determiner");

		b33 = new JButton("WP");
		b33.setActionCommand("WP");
		b33.addActionListener(note);
		b33.setToolTipText("wh-pronoun");

		b34 = new JButton("WP$");
		b34.setActionCommand("WP$");
		b34.addActionListener(note);
		b34.setToolTipText("possessive wh-");

		b35 = new JButton("WRB");
		b35.setActionCommand("WRB");
		b35.addActionListener(note);
		b35.setToolTipText("wh-adverb");

		b36 = new JButton("PRP$");
		b36.setActionCommand("PRP$");
		b36.addActionListener(note);
		b1.setToolTipText("");

		acinitComponent();
		acFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		acFrame.setBounds(330,250,320,440);
		acFrame.setVisible(true);
	}

	void acinitComponent()
	{
		GroupLayout framelayout = new GroupLayout(acFrame.getContentPane());
		acFrame.getContentPane().setLayout(framelayout);
		panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Annotation content"));

		GroupLayout panelbutton = new GroupLayout(panel);
		panel.setLayout(panelbutton);

		panelbutton.setHorizontalGroup(
			panelbutton.createParallelGroup()
				.addGroup(panelbutton.createSequentialGroup()
					.addComponent(b1,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b2,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b3,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b4,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
				)
				.addGroup(panelbutton.createSequentialGroup()
					.addComponent(b5,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b6,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b7,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b8,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
				)
				.addGroup(panelbutton.createSequentialGroup()
					.addComponent(b9,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b10,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b11,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b12,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
				)
				.addGroup(panelbutton.createSequentialGroup()
					.addComponent(b13,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b14,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b15,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b16,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
				)
				.addGroup(panelbutton.createSequentialGroup()
					.addComponent(b17,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b18,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b19,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b20,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
				)
				.addGroup(panelbutton.createSequentialGroup()
					.addComponent(b21,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b22,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b23,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b24,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
				)
				.addGroup(panelbutton.createSequentialGroup()
					.addComponent(b25,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b26,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b27,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b28,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
				)
				.addGroup(panelbutton.createSequentialGroup()
					.addComponent(b29,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b30,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b31,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b32,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
				)
				.addGroup(panelbutton.createSequentialGroup()
					.addComponent(b33,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b34,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b35,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(10,10,10)
					.addComponent(b36,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
				)
				.addGroup(panelbutton.createSequentialGroup()
					.addComponent(next,javax.swing.GroupLayout.PREFERRED_SIZE,70,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(list,javax.swing.GroupLayout.PREFERRED_SIZE,120,javax.swing.GroupLayout.PREFERRED_SIZE)
					)
			);

		panelbutton.setVerticalGroup(
			panelbutton.createParallelGroup()
				.addGroup(panelbutton.createSequentialGroup()
					
					.addGroup(panelbutton.createParallelGroup()
						.addComponent(b1,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b2,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b3,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b4,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
					)
					.addGap(10,10,10)
					.addGroup(panelbutton.createParallelGroup()
						.addComponent(b5,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b6,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b7,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b8,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						)
					.addGap(10,10,10)
					.addGroup(panelbutton.createParallelGroup()
						.addComponent(b9,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b10,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b11,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b12,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
					)
					.addGap(10,10,10)
					.addGroup(panelbutton.createParallelGroup()
						.addComponent(b13,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b14,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b15,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b16,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						)
					.addGap(10,10,10)
					.addGroup(panelbutton.createParallelGroup()
						.addComponent(b17,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b18,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b19,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b20,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
					)
					.addGap(10,10,10)
					.addGroup(panelbutton.createParallelGroup()
						.addComponent(b21,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b22,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b23,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b24,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						)
					.addGap(10,10,10)
					.addGroup(panelbutton.createParallelGroup()
						.addComponent(b25,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b26,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b27,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b28,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
					)
					.addGap(10,10,10)
					.addGroup(panelbutton.createParallelGroup()
						.addComponent(b29,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b30,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b31,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b32,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						)
					.addGap(10,10,10)
					.addGroup(panelbutton.createParallelGroup()
						.addComponent(b33,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b34,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b35,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(b36,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						)
					.addGap(10,10,10)
					.addGroup(panelbutton.createParallelGroup()
						.addComponent(next,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(list,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
						)
					
					)
				
			);

		framelayout.setHorizontalGroup(
			framelayout.createParallelGroup()
				.addGroup(framelayout.createSequentialGroup()
					.addComponent(panel,javax.swing.GroupLayout.PREFERRED_SIZE,320,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGroup(framelayout.createParallelGroup()

						)
					
					
				)
			);

		framelayout.setVerticalGroup(
			framelayout.createParallelGroup()
				.addGroup(framelayout.createSequentialGroup()
					.addComponent(panel,javax.swing.GroupLayout.PREFERRED_SIZE,420,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGroup(framelayout.createParallelGroup()
							
						)
					
					)
				
			);
		acFrame.pack();
	}

}