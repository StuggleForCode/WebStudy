package GUI;

import java.util.ArrayList;
import java.util.Random;

public class MazeMode1 {
	private int width = 0;
    private int height = 0;
    private Random rnd = new Random();
 
    public void MazeModel() {
        this.width = 50; //√‘π¨øÌ∂» 
        this.height = 50; //√‘π¨∏ﬂ∂» 
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void MazeModel(int width, int height) {
      //  super();
        this.width = width;
        this.height = height;
    }
    public ArrayList < MazePoint > getMaze() {
        ArrayList < MazePoint > maze = new ArrayList < MazePoint > ();
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                MazePoint point = new MazePoint(w, h);
                maze.add(point);
            }
        }
        return CreateMaze(maze);
    }
    private ArrayList < MazePoint > CreateMaze(ArrayList < MazePoint > maze) {
        int top = 0;
        int x = 0;
        int y = 0;
        ArrayList < MazePoint > team = new ArrayList < MazePoint > ();
        team.add(maze.get(x + y * width));
        while (top >= 0) {
            int[] val = new int[] {
                -1, -1, -1, -1
            };
            int times = 0;
            boolean flag = false;
            MazePoint pt = (MazePoint) team.get(top);
            x = pt.getX();
            y = pt.getY();
            pt.visted = true;
 
            ro1: while (times < 4) {
                int dir = rnd.nextInt(4);
                if (val[dir] == dir)
                    continue;
                else
                    val[dir] = dir;
 
 
 
 
                switch (dir) {
                case 0: // ◊Û±ﬂ 
                    if ((x - 1) >= 0 && maze.get(x - 1 + y * width).visted == false) {
                        maze.get(x + y * width).setLeft();
                        maze.get(x - 1 + y * width).setRight();
                        team.add(maze.get(x - 1 + y * width));
                        top++;
                        flag = true;
                        break ro1;
 
                    }
                    break;
                case 1: // ”“±ﬂ 
                    if ((x + 1) < width && maze.get(x + 1 + y * width).visted == false) {
 
                        maze.get(x + y * width).setRight();
                        maze.get(x + 1 + y * width).setLeft();
                        team.add(maze.get(x + 1 + y * width));
                        top++;
                        flag = true;
                        break ro1;
                    }
                    break;
                case 2: // …œ±ﬂ 
                    if ((y - 1) >= 0 && maze.get(x + (y - 1) * width).visted == false) {
                        maze.get(x + y * width).setUp();
                        maze.get(x + (y - 1) * width).setDown();
                        team.add(maze.get(x + (y - 1) * width));
                        top++;
                        flag = true;
                        break ro1;
                    }
                    break;
                case 3: // œ¬±ﬂ 
                    if ((y + 1) < height && maze.get(x + (y + 1) * width).visted == false) {
                        maze.get(x + y * width).setDown();
                        maze.get(x + (y + 1) * width).setUp();
                        team.add(maze.get(x + (y + 1) * width));
                        top++;
                        flag = true;
                        break ro1;
                    }
                    break;
                }
                times += 1;
            }
            if (!flag) {
                team.remove(top);
                top -= 1;
            }
 
        }
 
        return maze;
    }

}


