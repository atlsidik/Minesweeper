package pk.minesweeper;
import java.util.Random;                                                                 




public  class Grid{                                                             
private boolean[][] bombGrid ;                                              
private int[][] countGrid;                                                  
private int numRows;                                                        
private int numColumns;                                                     
private int numBombs;                                                       

public Grid(){                                                               
numRows = 10;                                                               
numColumns = 10;                                                            
bombGrid = new boolean[numRows][numColumns];                                
countGrid = new int[numRows][numColumns];                                   
numBombs = 25;                                                              
createBombGrid();                                                           
createCountGrid();                                                          
}                                                                            

public Grid(int rows,int columns){                                           
this.numRows = rows;                                                        
this.numColumns = columns;                                                  
bombGrid = new boolean[numRows][numColumns];                                
countGrid = new int[numRows][numColumns];                                   
numBombs = 25;                                                              
createBombGrid();                                                       
createCountGrid();                                                      

}                                                                            

public Grid (int rows, int columns , int bombs){                             
this.numRows =rows;                                                         
this.numColumns = columns;                                                  
this.numBombs = bombs;                                                      
bombGrid = new boolean[numRows][numColumns];                                
countGrid = new int[numRows][numColumns];                                   
createBombGrid();                                                           
createCountGrid();                                                  

}                                                                            

public  int getNumRows(){                                                    
return this.numRows;                                                        
}                                                                            

public int getNumColumns(){                                                  
return this.numColumns;                                                     
}                                                                           

public boolean[][] getBombGrid(){                                            
boolean[][] copyBomb = new boolean[bombGrid.length][];                  
for(int i=0; i< bombGrid.length ;++i){                                  
copyBomb[i] =bombGrid[i].clone();	                                    
}                                                                       

return copyBomb;	                                                    
}                                                                            

public int[][] getCountGrid(){                                              
int[][] copyCount = new int[countGrid.length][];                        
for(int i =0; i<countGrid.length ;++i){                                 
copyCount[i] = countGrid[i].clone();                                    
}                                                                       
return copyCount;                                                       
}                                                                           


private void createBombGrid(){                                              
Random rand = new Random();                                             
int[] randomX = new int[this.numBombs];                                 
int[] randomX2 = new int[this.numBombs];                                
int[] randomY = new int [this.numBombs];                                
int[] randomY2 = new int[this.numBombs];                                
int randomCount = 0;                                                    


for(int i = 0;i< this.numBombs ;++i){                                   

randomX[i] = rand.nextInt(this.numRows );                           
}                                                                       
for(int i =0; i< this.numBombs;++i){                                    
randomY[i] = rand.nextInt(this.numColumns);                         
}                                                                       
for(int i = 0;i< this.numBombs ;++i){                           

randomX2[i] = rand.nextInt(this.numRows );                          
}                                                                       
for(int i = 0;i< this.numBombs ;++i){                           

randomY2[i] = rand.nextInt(this.numRows );                          
}                                                                       





for(int i =0; i < this.numRows ;++i){                                   
for(int j =0 ; j< this.numColumns ;++j){                            
bombGrid[i][j]= false;                                          
}                                                                   
}                                                                       
                                                                      
int currX , currY ;                                                     
for(int i = 0;i< this.numBombs; ++i){                                   
if(i%2==0){                                                         
currX = randomX[randomCount];                                       
currY = randomY[randomCount];                                      
}                                                                   
else{                                                               
currX = randomX2[randomCount];                                     
currY = randomY2[randomCount];                                     

}                                                                   
bombGrid[currX][currY] = true;                                      
//	accBomb                                                             
randomCount++;                                                      
}                                                                       
isEnoughBombs();                                                        
}                                                                           


private void isEnoughBombs(){                                               
boolean[][] copyBomb = new boolean[bombGrid.length][];              
for(int i=0; i< bombGrid.length ;++i){                                  
copyBomb[i] =bombGrid[i].clone();	                                    
}                                                                       
int bombCount =0;                                                       
for(int i =0; i< this.numRows; ++i){                                    
for(int j =0; j< this.numColumns; j++){                             
if(copyBomb[i][j]==true){                                       
bombCount++;                                                
}                                                               
}                                                                   
}                                                                       

if(this.numBombs-bombCount>0){                                          
Random rGen = new Random();                                         
int bombsLeft =this.numBombs - bombCount;                           
int[] newRandX = new int [bombsLeft];                               
int[] newRandY = new int [bombsLeft];                               

for(int i = 0; i< bombsLeft; ++i){                                  
newRandX[i]= rGen.nextInt(this.numRows);                        
newRandY[i] = rGen.nextInt(this.numColumns);                    
}                                                                   
int ranC = 0;                                                       
for(int i = 0; i< bombsLeft ; ++i){                                 
int	currX = newRandX[ranC];                                     
int 	currY =newRandY[ranC];                                      
this.bombGrid[currX][currY]= true;                              
ranC++;                                                         
}                                                                   
isEnoughBombs();                                                    
}                                                                       
else{                                                                   
return;                                                             
}                                                                       


}                                                                           

public void createCountGrid(){                                              

initializeCount();                                                      

for(int i =0 ;i< this.numRows ;i++){                                    
for(int j =0 ; j< this.numColumns ;j++){                            
if(bombGrid[i][j]==true){                                       
if(isEdgeCase(i,j)){                                        
edgeCaseIncrement(i,j);                                 
}                                                           
else if(isBorderCase(i,j)){                                 
borderCaseIncrement(i,j);                               
}                                                           
else{                                                       

adjCellIncrement(i,j);                                   
}                                                           

}                                                               
}                                                                   
}                                                                       


}                                                                           

private void initializeCount(){                                             

for(int i=0 ; i< this.numRows; ++i){                                    
for(int j =0; j <this.numColumns ; ++j ){                           
countGrid[i][j]= 0;                                             
}                                                                   

}                                                                       

}                                                                           

private  boolean isEdgeCase( int r, int c){                                 
if(r==0 && c==0){                                                       
return true;                                                        
}                                                                       
if(r==0 && c == this.numColumns -1){                                    
return true;                                                        
}                                                                       
if(r==this.numRows -1 && c==0){                                         
return true;                                                        
}                                                                       
if(r== this.numRows -1 && c == this.numColumns-1){                      
return true;                                                        
}                                                                       

return false;                                                           


}                                                                           

public void edgeCaseIncrement( int r, int c){                               
if(r==0 && c==0){                                                       
countGrid[r][c]++;                                                  
countGrid[r][c+1]++;                                                
countGrid[r+1][c]++;                                                
countGrid[r+1][c+1]++;                                              
return;                                                             
}                                                                       

if(r==0 && c ==this.numColumns -1){                                     
countGrid[r][c]++;                                                  
countGrid[r][c-1]++;                                                
countGrid[r+1][c]++;                                                
countGrid[r+1][c-1]++;                                              
return;                                                             

}                                                                   

if(r == this.numRows-1 && c ==0){                                       
countGrid[r][c]++;                                                  
countGrid[r-1][c]++;                                                
countGrid[r][c+1]++;                                                
countGrid[r-1][c+1]++;                                              
return;                                                             
}                                                                       


if(r== this.numRows -1  && c == this.numColumns -1){                    
countGrid[r][c]++;                                              
countGrid[r][c-1]++;                                            
countGrid[r-1][c]++;                                            
countGrid[r-1][c-1]++;                                          
return;                                                         
}                                                                       
}                                                                           

private boolean isBorderCase(int r ,int c){                                 
if(r==0  || r == this.numRows -1){                                      
return true;                                                    
}                                                                       
if(c==0 || c == this.numColumns-1  ){                                   
return true ;                                                       
}                                                                       

return false;                                                           

}                                                                           

private void borderCaseIncrement(int r , int c){                            
if(c==0){                                                                   
countGrid[r][c]++;                                                          
countGrid[r][c+1]++;                                                        
countGrid[r+1][c]++;                                                        
countGrid[r-1][c]++;                                                        
countGrid[r+1][c+1]++;                                                      
countGrid[r-1][c+1]++;                                                      
return;                                                                     
}                                                                           

if(r==0){                                                                   
countGrid[r][c]++;                                                      
countGrid[r][c-1]++;                                                    
countGrid[r][c+1]++;                                                    
countGrid[r+1][c]++;                                                    
countGrid[r+1][c-1]++;                                                  
countGrid[r+1][c+1]++;                                                  
return;                                                                 
}                                                                           
if(r==this.numRows -1){                                                     
countGrid[r][c]++;                                                      
countGrid[r][c+1]++;                                                    
countGrid[r][c-1]++;                                                    
countGrid[r-1][c]++;                                                    
countGrid[r-1][c-1]++;                                                  
countGrid[r-1][c+1]++;                                                  
return;                                                                 
}                                                                           
if(c== this.numColumns-1){                                                  

countGrid[r][c]++;                                                          
countGrid[r+1][c]++;                                                        
countGrid[r-1][c]++;                                                        
countGrid[r][c-1]++;                                                        
countGrid[r-1][c-1]++;                                                      
countGrid[r+1][c-1]++;                                                      

}                                                                           
}                                                                           



private void adjCellIncrement(int r , int c){                               
countGrid[r][c]++;                                                  
countGrid[r][c+1]++;                                                
countGrid[r][c-1]++;                                                
countGrid[r-1][c]++;                                                
countGrid[r-1][c-1]++;                                              
countGrid[r-1][c+1]++;                                              
countGrid[r+1][c]++;                                                
countGrid[r+1][c-1]++;                                              
countGrid[r+1][c+1]++;                                              
}                                                                           



public boolean isBombAtLocation(int r , int c){                                 
if(bombGrid[r][c] == true){                                                 
return true;                                                            
}                                                                           

return false;                                                               
}                                                                               
public int getCountAtLocation(int r ,  int c){                                  
if(r<this.numRows && c<this.numColumns){                                    
return countGrid[r][c];                                                 
}                                                                           
return -1;                                                                  
}                                                                               
public int getNumBombs(){                                                       

int bob = 0;                                                                    
for(int i =0; i< this.getNumRows(); ++i){                                       
for(int j =0 ; j < this.getNumColumns(); j++){                                 
if (bombGrid[i][j]==true){                                              
bob++;                                                              
}                                                                   
}                                                                       
}                                                                           
return bob;                                                                     
}                                                                               


}                                                                               

     
       
       
       
       
       
       
       
       
       
       
       

