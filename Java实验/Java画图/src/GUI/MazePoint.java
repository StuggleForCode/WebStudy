package GUI;

public class MazePoint {
	 private int left = 0;
	    private int right = 0;
	    private int up = 0;
	    private int down = 0;
	    private int x;
	    private int y;
	    public boolean visted;
	    public MazePoint(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	    public int getLeft() {
	        return left;
	    }
	 
	    public void setLeft() {
	        this.left = 1;
	    }
	    public int getRight() {
	        return right;
	    }
	    public void setRight() {
	        this.right = 1;
	    }
	    public int getUp() {
	        return up;
	    }
	 
	    public void setUp() {
	        this.up = 1;
	    }
	    public int getDown() {
	        return down;
	    }
	 
	    public void setDown() {
	        this.down = 1;
	    }
	    public int getX() {
	        return x;
	    }
	    public void setX(int x) {
	        this.x = x;
	    }
	    public int getY() {
	        return y;
	    }
	    public void setY(int y) {
	        this.y = y;
	    }
	 

}
