package pk.minesweeper;

import javax.swing.*;                                                                                                                                                                                                                               
import java.awt.Dimension;                                                                                                
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;                                                                                                                                                                                                                          
import java.awt.GridLayout;                                                                                               
import java.awt.Image;                                                                                                    
import java.awt.Window;                                                                                                   
import java.awt.event.ActionEvent;                                                                                        
import java.awt.event.ActionListener;                                                                                                                                                                                                               
import javax.swing.JOptionPane;                                                                                           
                                                                                                                          
                                                                                                                          
                                                                                                                          
public class jp extends JPanel {                                                                                          
	private static final long serialVersionUID = -1512397389518141644L;                                                   
	private Grid newG= new Grid();                                                                                        
 	private   int restartGame;                                                                                            
	private square[][] sqs ;                                                                                              
	private square[] zeroSqs ;                                                                                            
	private int zeroSqsNum =0;                                                                                            
	private int numSqs=0;                                                                                                 
	private newGame ggz;                                                                                                  
	private ImageIcon bombIcon;                                                                                           
	private ImageIcon trophy;                                                                                             
	private ImageIcon bombLoss;                                                                                           
	private ImageIcon trophyIcon;                                                                                         
	private ImageIcon bombScaled;                                                                                         
                                                                                                                          
	                                                                                                                      
	                                                                                                                      
	                                                                                                                      
	 	public jp() {                                                                                                     
		this.setLayout( new GridLayout(10,10,1,1));                                                                       
		newG = new Grid();                                                                                                
		sqs = new square[newG.getNumRows()][newG.getNumColumns()];                                                        
		for(int i =0; i< newG.getNumRows() ;++i) {                                                                        
			for(int j =0 ; j<newG.getNumColumns();++j) {                                                                  
				square sq= new square(i,j);                                                                               
			add(sq);                                                                                                      
			sqs[i] [j]=sq;                                                                                                
			setVisible(true);                                                                                             
			}                                                                                                             
		}                                                                                                                 
	                                                                                                                      
		printGrids();                                                                                                     
		zeroSqs =new square[newG.getNumRows()*newG.getNumColumns()];                                                      
		java.net.URL bombURL = jp.class.getResource("Images/bomb.jpg");                                               
		 bombIcon = null;                                                                                                     
	java.net.URL trophyURL = jp.class.getResource("Images/trophy.jpg");                                                   
	  trophy = null;                                                                                                      
                                                                                                                          
		if(bombURL !=null){                                                                                           
	  bombIcon = new ImageIcon(bombURL);                                                                                  
		}                                                                                                                     
	 	if(trophyURL !=null){                                                                                                
		 trophy = new ImageIcon(trophyURL);                                                                               
	 	}                                                                                                                    
	 bombScaled = new ImageIcon(bombIcon.getImage().getScaledInstance(35,35,Image.SCALE_FAST));                           
	  bombLoss = new ImageIcon(bombIcon.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));                        
	  trophyIcon = new ImageIcon(trophy.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));                        
	}                                                                                                                     
	    



	public jp(int r, int c, int numBombs) {                                                                               
		this.setLayout( new GridLayout(r,c,1,1));                                                                         
		newG  = new Grid(r,c,numBombs);                                                                                   
		sqs = new square[newG.getNumRows()][newG.getNumColumns()];                                                        
		for(int i =0; i< newG.getNumRows() ;++i) {                                                                        
			for(int j =0 ; j<newG.getNumColumns();++j) {                                                                  
				square sq= new square(i,j);                                                                               
			add(sq);                                                                                                      
			sqs[i][j] =sq;                                                                                                
			setVisible(true);                                                                                             
			}                                                                                                             
		}                                                                                                                 
		printGrids();                                                                                                     
		zeroSqs =new square[newG.getNumRows()*newG.getNumColumns()];                                                      
			java.net.URL bombURL = jp.class.getResource("Images/bomb.jpg");                                               
	    bombIcon = null;                                                                                                     
		java.net.URL trophyURL = jp.class.getResource("Images/trophy.jpg");                                                   
	 	 trophy = null;                                                                                                      
                                                                                                                          
		if(bombURL !=null){                                                                                           
	  bombIcon = new ImageIcon(bombURL);                                                                                  
		}                                                                                                                     
	   if(trophyURL !=null){                                                                                                
		 trophy = new ImageIcon(trophyURL);                                                                               
		 }                                                                                                                    
	 bombScaled = new ImageIcon(bombIcon.getImage().getScaledInstance(35,35,Image.SCALE_FAST));                           
	  bombLoss = new ImageIcon(bombIcon.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));                        
	 trophyIcon = new ImageIcon(trophy.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));                         
	}                                                                                                                     
	   




	public void printGrids() {                                                                                            
	         	FileOutputStream outs = null;
		PrintWriter pw = null;
		try{
			outs = new FileOutputStream("cheatsheet.txt");
			pw  = new PrintWriter(outs);
			String s ="";
		for(int i =0; i< newG.getNumRows(); ++i){    
			s+="---------------------------------------------------------------------- \n";
		for(int j =0 ; j < newG.getNumColumns(); j++){  
		s+= String.format("|%6s",newG.getBombGrid()[i][j]); 
		} 
		s+="\n";
		}
		s+="----------------------------------------------------------------------\n";

		s+="\n";
		s+="\n";
		s+="\n";
		s+="\n";	
		s+="\n";

		

		for(int i= 0 ;i<newG.getNumRows();++i){
			s+="------------------------------\n";

			for(int j=0; j< newG.getNumColumns();j++ ) {
			 s+= String.format("|%2s",newG.getCountGrid()[i][j]); 
				
			}
				s+="\n";

		}
		s+="------------------------------\n";
		 pw.write(s);
		 pw.flush();
		 outs.close();
		
		} 
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		catch(Exception e ) {
			System.out.println(e.getMessage());
		}                                                                                  
	}                                                                                                                     
	                                                                                                                      
	                                                                                                                      
	public void disAllSqs() {                                                                                             
		for(int i =0; i< newG.getNumRows() ;++i) {                                                                        
			for(int j =0; j< newG.getNumColumns(); ++j) {                                                                 
				                                                                                                          
				sqs[i][j].dis();                                                                                          
			}                                                                                                             
			                                                                                                              
		                                                                                                                  
			}                                                                                                             
		                                                                                                                  
	}                                                                                                                     
	                                                                                                                      
	public void setAllSqs() {                                                                                             
		for(int i = 0 ;i< newG.getNumRows(); i++) {                                                                       
			for(int j =0; j< newG.getNumColumns();j++) {                                                                  
				if(newG.isBombAtLocation(i,j)) {                                                                          
					sqs[i][j].setIcon(bombScaled);                                                                        
				}                                                                                                         
				else {                                                                                                    
					sqs[i][j].setSq(i,j);                                                                                 
				}                                                                                                         
			}                                                                                                             
		}                                                                                                                 
	}                                                                                                                     
	                                                                                                                      
                                                                                                                   
	public void displayZero(int r,int c) {                                                                             
		if((r==0 && c==0) ||(r==0 && c ==newG.getNumColumns() -1) ||(r == newG.getNumRows()-1 && c ==0) || (r== newG.getNumRows()-1 && c== newG.getNumColumns()-1) ) {
		edgeCaseDisplay(r,c);                                                                                      
		return;                                                                                                    
		}                                                                                                              
		if((r==0 ) || (r == newG.getNumRows() -1 ) ||(c==0)||(c == newG.getNumColumns()-1) ){                          
		borderCaseDisplay(r,c);                                                                                    
		return;                                                                                                    
		}                                                                                                              
		adjacentCellDisplay(r,c);                                                                                      
		return;                                                                                                            
	                                                                                                               
	                                                                                                               
	                                                                                                               
}                                                                                                                  
                                                                                                                 
   	                                                                                                                 
		                                                                                                                  
		                                                                                                              
	public void processSquare(int a , int b) {                                                                            
		                                                                                                                  
		sqs[a][b].setSq(a,b);                                                                                             
		                                                                                                                  
		sqs[a][b].dis();                                                                                                  
		if(newG.getCountAtLocation(a, b)==0 &&( !sqs[a][b].isMined)) {                                                    
			zeroSqs[zeroSqsNum++] =sqs[a][b];                                                                             
		}                                                                                                                 
		if(!sqs[a][b].isMined) {                                                                                          
			numSqs++;                                                                                                     
			sqs[a][b].isMined = true;                                                                                     
		}                                                                                                                 
		                                                                                                                  
	}                                                                                                                     
	                                                                                                                      
	public void processFirstSq(int a , int b) {                                                                           
		sqs[a][b].setSq(a,b);                                                                                             
		sqs[a][b].dis();                                                                                                  
		if(!sqs[a][b].isMined) {                                                                                          
			numSqs++;                                                                                                     
			sqs[a][b].isMined = true;                                                                                     
		}                                                                                                                 
	}                                                                                                                     
	                                                                                                                      
	                                                                                                                      
	public void edgeCaseDisplay(int r, int c) {                                                                           
		                                                                                                                  
		                                                                                                                  
		if(r==0 && c==0) {                                                                                                
			if((!newG.isBombAtLocation(r,c))) {                                                                           
				processFirstSq(r,c);	                                                                                  
			}                                                                                                             
			                                                                                                              
			if((!newG.isBombAtLocation(r,c+1))) {                                                                         
				processSquare(r,c+1);                                                                                     
				                                                                                                          
			}                                                                                                             
			                                                                                                              
			if((!newG.isBombAtLocation(r+1,c))) {                                                                         
			processSquare(r+1,c);                                                                                         
			}                                                                                                             
			                                                                                                              
			if((!newG.isBombAtLocation(r+1,c+1))) {                                                                       
				processSquare(r+1,c+1);                                                                                   
			}                                                                                                             
			return;                                                                                                       
		                                                                                                                  
		}                                                                                                                 
		if(r==0 && c == newG.getNumColumns() -1){                                                                         
			if((!newG.isBombAtLocation(r,c))) {                                                                           
				processFirstSq(r,c);	                                                                                  
                                                                                                                          
				                                                                                                          
			}                                                                                                             
			if((!newG.isBombAtLocation(r,c-1))) {                                                                         
				processSquare(r,c-1);                                                                                     
			}                                                                                                             
			                                                                                                              
			if((!newG.isBombAtLocation(r+1,c))) {                                                                         
				processSquare(r+1,c);                                                                                     
				                                                                                                          
			}                                                                                                             
			                                                                                                              
			if((!newG.isBombAtLocation(r+1,c-1))) {                                                                       
				processSquare(r+1,c-1);                                                                                   
			}                                                                                                             
			                                                                                                              
			return;                                                                                                       
			                                                                                                              
		}                                                                                                                 
		                                                                                                                  
		if(r == newG.getNumRows()-1 && c ==0) {                                                                           
			if((!newG.isBombAtLocation(r,c))) {                                                                           
				processFirstSq(r,c);	                                                                                  
                                                                                                                          
			}                                                                                                             
			                                                                                                              
			if((!newG.isBombAtLocation(r-1,c))) {                                                                         
			processSquare(r-1,c);                                                                                         
			}                                                                                                             
			                                                                                                              
			if((!newG.isBombAtLocation(r,c+1))) {                                                                         
			processSquare(r,c+1);                                                                                         
			}                                                                                                             
			                                                                                                              
			if((!newG.isBombAtLocation(r-1,c+1))) {                                                                       
				processSquare(r-1,c+1);                                                                                   
			}                                                                                                             
			                                                                                                              
			return;                                                                                                       
		}                                                                                                                 
		                                                                                                                  
		if(r== newG.getNumRows() -1  && c == newG.getNumColumns() -1) {                                                   
			if((!newG.isBombAtLocation(r,c))) {                                                                           
				processFirstSq(r,c);	                                                                                  
			}                                                                                                             
			                                                                                                              
			if((!newG.isBombAtLocation(r,c-1))) {                                                                         
				processSquare(r,c-1);                                                                                     
			}                                                                                                             
			                                                                                                              
			if((!newG.isBombAtLocation(r-1,c))) {                                                                         
				processSquare(r-1,c);                                                                                     
			}                                                                                                             
			if((!newG.isBombAtLocation(r-1,c-1))) {                                                                       
				processSquare(r-1,c-1);                                                                                   
			}                                                                                                             
			                                                                                                              
			return;                                                                                                       
		}                                                                                                                 
		                                                                                                                  
	}                                                                                                                     
	                                                                                                                      
	                                                                                                                      
	public void borderCaseDisplay(int r, int c) {                                                                         
		                                                                                                                  
		if(c==0) {                                                                                                        
			if((!newG.isBombAtLocation(r,c))) {                                                                           
			processFirstSq(r,c);                                                                                          
				                                                                                                          
			}                                                                                                             
			if((!newG.isBombAtLocation(r,c+1))) {                                                                         
				processSquare(r,c+1);                                                                                     
			}                                                                                                             
			if((!newG.isBombAtLocation(r+1,c))) {                                                                         
				processSquare(r+1,c);                                                                                     
			}                                                                                                             
			if((!newG.isBombAtLocation(r-1,c))) {                                                                         
				processSquare(r-1,c);                                                                                     
			}                                                                                                             
			if((!newG.isBombAtLocation(r+1,c+1))) {                                                                       
				processSquare(r+1,c+1);                                                                                   
			}                                                                                                             
			if((!newG.isBombAtLocation(r-1,c+1))) {                                                                       
				processSquare(r-1,c+1);                                                                                   
			}                                                                                                             
			return;                                                                                                       
		}                                                                                                                 
		                                                                                                                  
		if(r==0) {                                                                                                        
			if((!newG.isBombAtLocation(r,c))) {                                                                           
				processFirstSq(r,c);                                                                                      
				                                                                                                          
			}                                                                                                             
			if((!newG.isBombAtLocation(r,c-1))) {                                                                         
				processSquare(r,c-1);                                                                                     
			}                                                                                                             
			if((!newG.isBombAtLocation(r,c+1))) {                                                                         
				processSquare(r,c+1);                                                                                     
			}                                                                                                             
			if((!newG.isBombAtLocation(r+1,c))) {                                                                         
				processSquare(r+1,c);                                                                                     
			}                                                                                                             
			if((!newG.isBombAtLocation(r+1,c-1))) {                                                                       
				processSquare(r+1,c-1);                                                                                   
			}                                                                                                             
			if((!newG.isBombAtLocation(r+1,c+1))) {	                                                                      
				processSquare(r+1,c+1);                                                                                   
			}                                                                                                             
			return;                                                                                                       
		}                                                                                                                 
		                                                                                                                  
		if(r== newG.getNumRows() -1) {                                                                                    
			if((!newG.isBombAtLocation(r,c))) {                                                                           
			processFirstSq(r,c);                                                                                          
			}                                                                                                             
			if((!newG.isBombAtLocation(r,c+1))) {                                                                         
				processSquare(r,c+1);                                                                                     
			}                                                                                                             
			if((!newG.isBombAtLocation(r,c-1))) {                                                                         
				processSquare(r,c-1);                                                                                     
			}                                                                                                             
			if((!newG.isBombAtLocation(r-1,c))) {                                                                         
				processSquare(r-1,c);                                                                                     
			}                                                                                                             
			if((!newG.isBombAtLocation(r-1,c-1))) {                                                                       
				processSquare(r-1,c-1);                                                                                   
			}                                                                                                             
			if((!newG.isBombAtLocation(r-1,c+1))) {                                                                       
				processSquare(r-1,c+1);                                                                                   
			}                                                                                                             
			return;                                                                                                       
		}                                                                                                                 
		                                                                                                                  
		                                                                                                                  
		if(c== newG.getNumColumns()-1) {                                                                                  
			if((!newG.isBombAtLocation(r,c))) {                                                                           
				processFirstSq(r,c);                                                                                      
			}                                                                                                             
			if((!newG.isBombAtLocation(r+1,c))) {                                                                         
				processSquare(r+1,c);                                                                                     
				                                                                                                          
			}                                                                                                             
			if((!newG.isBombAtLocation(r-1,c))) {                                                                         
				processSquare(r-1,c);                                                                                     
			}                                                                                                             
			if((!newG.isBombAtLocation(r,c-1))) {                                                                         
				processSquare(r,c-1);                                                                                     
			}                                                                                                             
			if((!newG.isBombAtLocation(r-1,c-1))) {                                                                       
				processSquare(r-1,c-1);                                                                                   
			}                                                                                                             
			if((!newG.isBombAtLocation(r+1,c-1))) {                                                                       
				processSquare(r+1,c-1);                                                                                   
			}                                                                                                             
			return;                                                                                                       
		}                                                                                                                 
		                                                                                                                  
		                                                                                                                  
		                                                                                                                  
	}                                                                                                                     
	                                                                                                                      
	                                                                                                                      
	public void adjacentCellDisplay(int r, int c) {                                                                       
		if((!newG.isBombAtLocation(r,c))) {                                                                               
			processFirstSq(r,c);                                                                                          
			                                                                                                              
		}                                                                                                                 
		if((!newG.isBombAtLocation(r,c+1))) {                                                                             
			processSquare(r,c+1);                                                                                         
		}                                                                                                                 
		if((!newG.isBombAtLocation(r,c-1))) {                                                                             
			processSquare(r,c-1);                                                                                         
		}                                                                                                                 
		if((!newG.isBombAtLocation(r-1,c))) {                                                                             
			processSquare(r-1,c);                                                                                         
		}                                                                                                                 
		if((!newG.isBombAtLocation(r-1,c-1))) {                                                                           
			processSquare(r-1,c-1);                                                                                       
		}                                                                                                                 
		if((!newG.isBombAtLocation(r-1,c+1))) {                                                                           
			processSquare(r-1,c+1);                                                                                       
		}                                                                                                                 
		if((!newG.isBombAtLocation(r+1,c))) {                                                                             
			processSquare(r+1,c);                                                                                         
		}                                                                                                                 
		if((!newG.isBombAtLocation(r+1,c-1))) {                                                                           
			processSquare(r+1,c-1);                                                                                       
		}                                                                                                                 
		if((!newG.isBombAtLocation(r+1,c+1))) {                                                                           
			processSquare(r+1,c+1);                                                                                       
		}                                                                                                                 
		return;                                                                                                           
	}                                                                                                                     
	                                                                                                                      
	 class square extends JButton implements ActionListener{                                                              
		private static final long serialVersionUID = -4834167464535321295L;                                               
		private int x ;                                                                                                   
		 private int y;                                                                                                   
		 private boolean isMined;                                                                                         
		                                                                                                                  
		                                                                                                                  
		                                                                                                                  
		public square(int i, int j) {                                                                                     
			super();                                                                                                      
			this.x =i;                                                                                                    
			this.y =j;                                                                                                    
		                                                                                                                  
			this.setPreferredSize(new Dimension(50,50));                                                                  
			addActionListener(this);                                                                                      
			isMined = false;                                                                                              
			                                                                                                              
		}                                                                                                                 
		                                                                                                                  
		public int getR() {                                                                                               
			return this.x;                                                                                                
		}                                                                                                                 
		                                                                                                                  
		public int getC() {                                                                                               
			return this.y;                                                                                                
		}                                                                                                                 
                                                                                                                          
		@Override                                                                                                         
		public void actionPerformed(ActionEvent e) {                                                                      
			                                                                                                              
                                                                                                                          
                                                                                                                          
			square clickedSquare = (square) e.getSource();                                                                
			if(this.equals(clickedSquare)) {                                                                              
				int cSqX = clickedSquare.getR();                                                                          
				int cSqY = clickedSquare.getC();                                                                          
				                                                                                                          
					if(newG.isBombAtLocation(cSqX,cSqY)) {                                                                
						clickedSquare.setIcon(bombIcon);                                                                  
						clickedSquare.isMined =true;                                                                      
						setAllSqs();                                                                                      
						String s = "You mined a bomb!! \n Do you want to play again ?";                                       
						restartGame = JOptionPane.showOptionDialog(null,s, "GAME OVER", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,bombLoss,null,null);
							if(restartGame == JOptionPane.YES_OPTION) {                                                           
						JComponent comp = (JComponent) e.getSource();                                                     
						  Window win = SwingUtilities.getWindowAncestor(comp);                                            
						  win.dispose();                                                                                  
						ggz = new newGame();                                                                              
							}                                                                                                     
							else {                                                                                                
						JComponent comp = (JComponent) e.getSource();                                                     
						  Window win = SwingUtilities.getWindowAncestor(comp);                                            
						  win.dispose();                                                                                  
						  System.exit(0);                                                                                 
                                                                                                                          
							}                                                                                                     
						                                                                                                  
					}                                                                                                     
				  	else {                                                                                                
						                                                                                                  
						if(newG.getCountAtLocation(cSqX, cSqY)==0) {                                                      
							clickedSquare.isMined =true;                                                                  
							numSqs++;                                                                                     
							displayZero(cSqX, cSqY);                                                                      
						}                                                                                                 
						                                                                                                  
						else {                                                                                            
						setSq(cSqX,cSqY);                                                                                 
						dis();                                                                                            
						clickedSquare.isMined =true;                                                                      
						numSqs++;                                                                                         
						}                                                                                                 
						                                                                                                  
					}                                                                                                     
					int count =1;                                                                                         
					for(int c = 0; c< zeroSqs.length;c++) {                                                               
						if(zeroSqs[c]!=null) {                                                                            
							displayZero(zeroSqs[c].getR(),zeroSqs[c].getC());                                             
							System.out.println(count+" extra zeros displayed");                                           
							count++;                                                                                      
						}                                                                                                 
						else {                                                                                            
							break;                                                                                        
						}                                                                                                 
					}                                                                                                     
					int sqsRemaining = (newG.getNumColumns() * newG.getNumRows()) -numSqs;                                
					                                                                                                      
					if(sqsRemaining ==newG.getNumBombs()) {                                                               
						String w ="YOU WON!! \n Do you want to play again?";                                              
						int gameWon = JOptionPane.showOptionDialog(null,w, "GAME WON", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,trophyIcon,null,null);
                                                                                                                          
						if(gameWon == JOptionPane.YES_OPTION) {                                                           
							JComponent comp = (JComponent) e.getSource();                                                 
							  Window win = SwingUtilities.getWindowAncestor(comp);                                        
							  win.dispose();                                                                              
							ggz = new newGame();                                                                          
						}                                                                                                 
						else {                                                                                            
							JComponent comp = (JComponent) e.getSource();                                                 
							  Window win = SwingUtilities.getWindowAncestor(comp);                                        
							  win.dispose();                                                                              
							  System.exit(0);                                                                             
						}                                                                                                 
					}                                                                                                     
							                                                                                              
					System.out.println(count);                                                                            
					System.out.println("num of squares mined " +numSqs);                                                  
					System.out.println("end of click action exec");                                                       
					                                                                                                      
			}                                                                                                             
			                                                                                                              
		}                                                                                                                 
		public void dis() {                                                                                               
			setEnabled(false);                                                                                            
		}                                                                                                                 
		                                                                                                                  
		public void setBomb() {                                                                                           
			setText("bomb");                                                                                              
		}                                                                                                                 
		public void setSq(int r, int c) {                                                                                 
			                                                                                                              
				setText(Integer.toString(newG.getCountAtLocation(r, c)));                                                 
			                                                                                                              
			}                                                                                                             
		                                                                                                                  
	 }                                                                                                                    
		                                                                                                                  
                                                                                                                      
	                                                                                                                      
}                                                                                                                         
                                                                                                                          
                                                                                                                          

