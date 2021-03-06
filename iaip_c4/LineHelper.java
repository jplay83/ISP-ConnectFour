import java.util.*;

public class LineHelper {

	public static void insertVertical(ArrayList<Node> vertical,int column, int row, int playerID) {
        Node n = new Node(column,row,playerID);
        boolean inserted = false;

       if ( row == 0 ) {
            vertical.add(n);
            inserted=true;
        } else {
            for (Node node : vertical) {
                Node tempNode = node;
                while (true) {
                    if (tempNode.playerID == playerID && tempNode.x == column && tempNode.y == row-1) {
                        tempNode.setNext(n);     
                        inserted = true;
                        break;               
                    }
                    tempNode = tempNode.getNext();
                    if(tempNode==null) {
                        break;
                    }
                }
            }
            if(inserted==false)
                vertical.add(n);
        }
    }

    public static void insertHorizontal(ArrayList<Node> horizontal,int column,int row, int playerID) {
        Node n = new Node(column,row,playerID);
        boolean inserted = false;

        for (Node node : horizontal) {
            if (node.y == row) {
                Node tempNode = node;
                while (true) {
                    if (tempNode.x == column-1 && tempNode.playerID == playerID) {
                        tempNode.setNext(n); 
                        inserted = true;                  
                        break;
                    }
                    tempNode=tempNode.getNext();
                    if(tempNode==null) {
                        break;
                    }
                }
            }
        }

        if (inserted==false)
            horizontal.add(n);


        Iterator<Node> i = horizontal.iterator();
        

        while (i.hasNext()) {
            Node iNode = i.next();
            if (iNode.y == n.y && iNode.x == n.x+1 && iNode.playerID == playerID) {
                n.setNext(iNode);
                i.remove();
            }
            }
        }

    public static void insertRightDiagonal(ArrayList<Node> rightDiagonal,int column,int row, int playerID) {
        Node n = new Node(column,row,playerID);
        boolean inserted = false;

        for (Node columnNode : rightDiagonal) {

            Node tempNode = columnNode;
            while (true) {
                if (tempNode.y == row-1 && tempNode.x == column-1 && tempNode.playerID == playerID) {
                    tempNode.setNext(n);                        
                    inserted = true;
                    break;
                }
                tempNode=tempNode.getNext();
                if(tempNode==null) {
                    break;
                }
            }

        }

        if(inserted==false)
            rightDiagonal.add(n);
        

        Iterator<Node> i = rightDiagonal.iterator();
        

        while (i.hasNext()) {
            Node iNode = i.next();
            if (iNode.y == n.y+1 && iNode.x == n.x+1 && iNode.playerID == playerID) {
                n.setNext(iNode);
                i.remove();
            }
            }
    }

     public static void insertLeftDiagonal(ArrayList<Node> leftDiagonal,int column,int row, int playerID) {
        Node n = new Node(column,row,playerID);
        boolean inserted = false;

        for (Node columnNode : leftDiagonal) {
            
            Node tempNode = columnNode;
            while (true) {
                if (tempNode.y == row-1 && tempNode.x == column+1 && tempNode.playerID == playerID) {
                    tempNode.setNext(n);                        
                    inserted = true;
                    break;
                }
                tempNode=tempNode.getNext();
                if(tempNode==null)
                    break;
            }

        }

        if(inserted==false)
            leftDiagonal.add(n);
        
        Iterator<Node> i = leftDiagonal.iterator();
        

        while (i.hasNext()) {
            Node iNode = i.next();
            if (iNode.y == n.y+1 && iNode.x == n.x-1 && iNode.playerID == playerID) {
                n.setNext(iNode);
                i.remove();
            }
            }
        
    }

    public static IGameLogic.Winner finalLineExistsIn(ArrayList<Node> list) {
    	for(Node n : list) {
    		int size = 1;
    		Node tempNode = n;
    		while(true) {
    			if(tempNode.getNext() != null) {
    				tempNode = tempNode.getNext();
    				size++;
    				if(size>=4) 
    					{
                            //System.out.println("finalLineExistsIn");
                            if (tempNode.playerID == 1)
                                return IGameLogic.Winner.PLAYER1;
                            else if ( tempNode.playerID ==2) 
                                return IGameLogic.Winner.PLAYER2;
                        };
    			}
    			else break;
    		}
    	}
    	return IGameLogic.Winner.NOT_FINISHED;
    }



}