package pk.minesweeper;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class newGame {

	public newGame() {
		int sesh =  JOptionPane.showOptionDialog(null,"Do you want to run a default Minesweeper game session?","Minesweeper",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
		
		
		JFrame newF = new JFrame("Minesweeper");
		if(sesh == JOptionPane.YES_OPTION) {
			jp pane = new jp();
			
			newF.add(pane);
			
			newF.pack();
			newF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			newF.setVisible(true);

		}
		
		if(sesh == JOptionPane.NO_OPTION) {
			inputFrame question = new inputFrame();
			
			question.pack();
			
			question.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			question.setVisible(true);
		
		}
	}
	
	
	
}

