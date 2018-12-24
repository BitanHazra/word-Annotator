import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;


public class Cosineresult
{
	JFrame cosineframe;
	JTable cosinetable;
	
	JPanel panel;
	JPanel panel3;
	JLabel result;
	JScrollPane jScrollPane1;
	JScrollPane jScrollPane2;
	Cosinesimilarity cosinesim;
	
	
	
	public Cosineresult(Notepad note)
	{
		cosinesim = new Cosinesimilarity(note);
		cosineframe = new JFrame("Cosine Result");
		panel = new JPanel();
		panel3 = new JPanel();
		cosinetable = new JTable();
		result = new JLabel();
		String finalval = Double.toString(cosinesim.result);
		result.setText(finalval);
		
		String[] val1 = new String[cosinesim.listval.length];
		String[] val2 = new String[cosinesim.listval2.length];

		for(int i=0;i<cosinesim.listval.length;i++)
		{
			val1[i] = String.valueOf(cosinesim.listval[i]);
			val2[i] = String.valueOf(cosinesim.listval2[i]);
		}

	DefaultTableModel model = new DefaultTableModel();
	cosinetable = new JTable(model);
	for(int i=0;i<cosinesim.listval.length;i++)
		{
	model.addColumn(cosinesim.listpos[i]);
	}	
	model.insertRow(0,new Object[]{val1[0],val1[1],val1[2],val1[3],val1[4],val1[5],val1[6],val1[7],val1[8],val1[9],val1[10],val1[11],val1[12],val1[13],val1[14],val1[15],val1[16],val1[17],val1[18],val1[19],val1[20],val1[21],val1[22],val1[23],val1[24],val1[25],val1[26],val1[27],val1[28],val1[29],val1[30],val1[31],val1[32],val1[33],val1[34],val1[35]});
	model.insertRow(1,new Object[]{val2[0],val2[1],val2[2],val2[3],val2[4],val2[5],val2[6],val2[7],val2[8],val2[9],val2[10],val2[11],val2[12],val2[13],val2[14],val2[15],val2[16],val2[17],val2[18],val2[19],val2[20],val2[21],val2[22],val2[23],val2[24],val2[25],val2[26],val2[27],val2[28],val2[29],val2[30],val2[31],val2[32],val2[33],val2[34],val2[35]});

	//model.insertRow(0,new Object[]{val1[0]});
	//	cosinetable.setModel(new javax.swing.table.DefaultTableModel(
	//		new Object[][]{
	//						{},
	//						{}
							//{val1[0],val1[1],val1[2],val1[3],val1[4],val1[5],val1[6],val1[7],val1[8],val1[9],val1[10],val1[11],val1[12],val1[13],val1[14],val1[15],val1[16],val1[17],val1[18],val1[19],val1[20],val1[21],val1[22],val1[23],val1[24],val1[25],val1[26],val1[27],val1[28],val1[29],val1[30],val1[31],val1[32],val1[33],val1[34],val1[35],val1[36]},
							//{val2[0],val2[1],val2[2],val2[3],val2[4],val2[5],val2[6],val2[7],val2[8],val2[9],val2[10],val2[11],val2[12],val2[13],val2[14],val2[15],val2[16],val2[17],val2[18],val2[19],val2[20],val2[21],val2[22],val2[23],val2[24],val2[25],val2[26],val2[27],val2[28],val2[29],val2[30],val2[31],val2[32],val2[33],val2[34],val2[35],val2[36]}	
	//						},
	//		new String[] {"Text","CC","CD","DT","EX","FW","IN","JJ","JJR","JJS","LS","MD","NN","NNS","NNP","NNPS","PDT","POS","PRP","PRP$","RB","RBR","RBS","RP","TO","SYM","UH","VB","VBD","VBG","VBN","VBP","VBZ","WDT","WP","WP$","WRB"	}
	//		));
		
		resultinitComponent();
		cosineframe.setVisible(true);
	}

	public void resultinitComponent()
	{
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setViewportView(cosinetable);
		

		panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Frequency Of Occurrence"));
		
		panel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Percentage Similarity Result"));

		GroupLayout framelayout = new GroupLayout(cosineframe.getContentPane());
		cosineframe.getContentPane().setLayout(framelayout);

	//FREQUENCY OF OCCURANCE TABLE DEZINE

		GroupLayout panellayout = new GroupLayout(panel);
		panel.setLayout(panellayout);

		panellayout.setHorizontalGroup(
				panellayout.createParallelGroup()
					.addGroup(panellayout.createSequentialGroup()
						.addComponent(jScrollPane1,javax.swing.GroupLayout.PREFERRED_SIZE,1300,javax.swing.GroupLayout.PREFERRED_SIZE)
						)
			);
		panellayout.setVerticalGroup(
				panellayout.createParallelGroup()
					.addGroup(panellayout.createSequentialGroup()
						.addGap(5,5,5)
						.addComponent(jScrollPane1,javax.swing.GroupLayout.PREFERRED_SIZE,80,javax.swing.GroupLayout.PREFERRED_SIZE)
						)
			);
	//PERCENTAGE SIMILARITY
		GroupLayout panellayout3 = new GroupLayout(panel3);
		panel3.setLayout(panellayout3);

		panellayout3.setHorizontalGroup(
				panellayout3.createParallelGroup()
					.addGroup(panellayout3.createSequentialGroup()
						.addComponent(result,javax.swing.GroupLayout.PREFERRED_SIZE,200,javax.swing.GroupLayout.PREFERRED_SIZE)
						)
			);
		panellayout3.setVerticalGroup(
				panellayout3.createParallelGroup()
					.addGroup(panellayout3.createSequentialGroup()
						.addGap(5,5,5)
						.addComponent(result,javax.swing.GroupLayout.PREFERRED_SIZE,80,javax.swing.GroupLayout.PREFERRED_SIZE)
						)
			);
	//FRAME LAYOUT SETTINGS

		framelayout.setHorizontalGroup(
			framelayout.createParallelGroup()
				.addGroup(framelayout.createSequentialGroup()
					.addGroup(framelayout.createParallelGroup()
						.addGroup(framelayout.createSequentialGroup()
							.addComponent(panel,javax.swing.GroupLayout.PREFERRED_SIZE,1300,javax.swing.GroupLayout.PREFERRED_SIZE)
							)
						.addGroup(framelayout.createSequentialGroup()
							.addGap(500,500,500)
							.addComponent(panel3,javax.swing.GroupLayout.PREFERRED_SIZE,300,javax.swing.GroupLayout.PREFERRED_SIZE)
							)
					)
				)
			);

		framelayout.setVerticalGroup(
			framelayout.createParallelGroup()
				.addGroup(framelayout.createSequentialGroup()
					.addGap(10,10,10)
					.addComponent(panel,javax.swing.GroupLayout.PREFERRED_SIZE,90,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(20,20,20)
					.addComponent(panel3,javax.swing.GroupLayout.PREFERRED_SIZE,90,javax.swing.GroupLayout.PREFERRED_SIZE)
					
				)

			);
		cosineframe.pack();
	}
}