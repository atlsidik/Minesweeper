package pk.minesweeper;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class inputFrame extends JFrame implements ActionListener{
	private int customRow ;
	private int customCol;
	private  int customBombs;
	private JTextField colText;
	protected JTextField rowText;
	private JTextField bombText;
	private JButton btn;
	private boolean doneWithInput ;
	private jp pp ;
	
	
 
	public inputFrame() {
	    super("Create Session");
	    
	    //create row label and Textfield
		JLabel rows = new JLabel("Enter Rows: ");
		 rowText = new JTextField(15);
		 rowText.setText("0");		
		rowText.setEditable(true);
		
		
		//create column label and text
		JLabel columns = new JLabel("Enter Columns: ");
		 colText = new JTextField(15);
		colText.setEditable(true);
		colText.setText("0");
		
		
		//create start button 
		 btn = new JButton("START");
		 
		 
		 //create bomb label and field
		JLabel bombs = new JLabel("Enter bombs: ");
		bombText = new JTextField(15);
		bombText.setText("25");
		
		
		//set LayoutManager
		setLayout(new GridBagLayout());
		setMaximumSize(new Dimension(500,500));
		this.setAlwaysOnTop(true);
		setAutoRequestFocus(true);
		this.toFront();
	
		
		GridBagConstraints cns = null;
		
		//add Row Label
		cns = new GridBagConstraints();
		cns.gridx =0;
		cns.gridy=0;
		 cns.weightx = 0.1;
	        cns.weighty = 0.1;
	        cns.anchor = GridBagConstraints.LINE_START;
	       // cns.fill = GridBagConstraints.NONE;
		cns.insets =new Insets(10,10,10,10);
		add(rows,cns);
		
		//add Row Textfield
		cns.gridx =1;
		cns.gridy=0;
		cns.insets =new Insets(10,10,10,10);
		cns.anchor = GridBagConstraints.LINE_START;
		add(rowText,cns);
		
		
	//add column label
		cns.gridx =0;
		cns.gridy=1;
		cns.anchor = GridBagConstraints.LINE_START;
		cns.insets =new Insets(10,10,10,10);
		add(columns,cns);
		
	//add numColumns TextField
		cns.gridx =1;
		cns.gridy=1;
		cns.insets =new Insets(10,10,10,10);
		cns.anchor = GridBagConstraints.LINE_START;
		add(colText,cns);
		
	//add bomb label
		cns.gridx =0;
		cns.gridy=2;
		cns.anchor = GridBagConstraints.LINE_START;
		cns.insets =new Insets(10,10,10,10);
		add(bombs,cns);
		
		//add bomb textField
		cns.gridx = 1;
		cns.gridy = 2;
		cns.anchor =  GridBagConstraints.LINE_START;
		cns.insets =new Insets(10,10,10,10);
		add(bombText,cns);
		
		
		//add start button
		cns.gridx =0;
		cns.gridy=3;
		cns.insets =new Insets(10,10,10,10);
		cns.anchor = GridBagConstraints.LINE_START;
		btn.addActionListener(this);
		add(btn,cns);
		

	
	}
	
	public boolean getdDoneWithInput() {
		return doneWithInput;
	}
	public int getCustomRow() {
		
		return customRow;
	}
	public int getCustomCol() {
		
		return customCol;
	}


public int getCustomBomb() {
	
	return customBombs;
}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn) {
		String userRow, userCol, userBomb;
		
		userRow = rowText.getText();
		userCol = colText.getText();
		userBomb = bombText.getText();
		
		customRow =Integer.parseInt(userRow);
		customCol =Integer.parseInt(userCol);
		customBombs = Integer.parseInt(userBomb);
		
		System.out.println(customRow);
		System.out.println(customCol);
		System.out.println(customBombs);
		
		this.doneWithInput =true;
		System.out.println(this.doneWithInput);
		gameTime();
		
		this.dispose();
		}
		else {
			
			rowText.requestFocusInWindow();
			rowText.grabFocus();
		}
	}
	
	
		public void gameTime() {
			JFrame pFrame = new JFrame();
			
		 pp = new jp(customRow,customCol,customBombs);
			//pp.getRestartVal();
			pFrame.add(pp);
			pFrame.pack();
			pFrame.setVisible(doneWithInput);
		//System.out.println(customRow);
			//System.out.println(customCol);
			pFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
		}
		public int shouldRestart() {
			return pp.getRestartVal();
		}
		
	}
	
	

