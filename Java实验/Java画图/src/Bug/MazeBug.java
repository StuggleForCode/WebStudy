package Bug;

import gridworld.actor.Actor;
import gridworld.actor.Bug;
import gridworld.actor.Flower;
import gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

import javax.swing.JOptionPane;

/*
 * Low:   534 1175 350 973 1052
 * Smart: 552 761 330 175 420
 */

/*
 * 节点：存储方向和该方向所走的次数
 * 往一个方向前进则加1，后退则减1
 */
class Node {
	private int dir;   // 方向，角度值
	private int ct;    // 该方向所走次数

	public Node(int initdir, int initct) {
		dir = initdir;
		ct = initct;
	}

	public int getDir() {
		return dir;
	}

	public int getCt() {
		return ct;
	}

	public void setCt(int deta) {
		ct += deta;
	}
}

// 深度优先算法解迷宫，并且以小甲虫的形式呈现
public class MazeBug extends Bug {
	private Location next;             // 下一步要走的格子
	private Integer stepCount = 0;     // 所走的步数
	private boolean isEnd = false;     // 是否到达迷宫出口
	private boolean hasShown = false;  // 是否显示了结束信息
	private Stack<Location> path = new Stack<>(); // 存储走过的路径
	private ArrayList<Node> arr = new ArrayList<>();

	public MazeBug() {
		setColor(Color.GREEN);
		arr.add(new Node(0, 0));
		arr.add(new Node(90, 0));
		arr.add(new Node(270, 0));
		arr.add(new Node(180, 0));
	}

	// 周期性执行
	public void act() {
		boolean willMove = canMove();   // 是否还能继续移动

		if (isEnd) {  // 是否结束
			if (!hasShown) { // 是否显示结束消息
				String msg = stepCount.toString() + " steps";
				JOptionPane.showMessageDialog(null, msg);
				hasShown = true;
			}
			return;
		} else if (willMove) { // 向前移动一个，步数加1
			move();
			++stepCount;
		} else { // 不能移动，后退一步，将该方向的计数器减1
			Grid<Actor> grid = getGrid();
			Location loc = this.getLocation();
			Location top = path.pop();
			++stepCount;
			grid.remove(top);
			this.setDirection(loc.getDirectionToward(top));
			this.moveTo(top);
      // 在走过的死路留下一朵白花
			Flower flower = new Flower(Color.WHITE);
			flower.putSelfInGrid(getGrid(), loc);

			// 方向计数器减1
			int dir = 180 + ((getDirection() / 90) % 2) * 180 - getDirection();
			for (Node node : arr)
				if (node.getDir() == dir) {
					node.setCt(-1);
					return;
				}
		}
	}

	// 找出和当前位置相邻的、合法的并且从未走过的格子
	public Location getValid(Location loc) {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return null;

		// 将每个方向走过的次数从大到小排序，下一步优先选次数多的方向走
		Location adjLocation;
		arr.sort(new Comparator<Node>() {
			@Override
			public int compare(Node a, Node b) {
				return (a.getCt() < b.getCt()) ? 1 : -1;
			}
		});

		for (Node node : arr) {
			adjLocation = this.getLocation().getAdjacentLocation(node.getDir());
			if (gr.isValid(adjLocation)
					&& (gr.get(adjLocation) == null || gr.get(adjLocation).getColor().equals(Color.RED))) {
				node.setCt(1);
				return adjLocation;
			}
		}
		return null;
	}

	// 判断当前位置是否可以继续移动
	public boolean canMove() {
		Grid<Actor> gr = getGrid();
		Actor adj;
		Location loc = this.getValid(this.getLocation());
		if (loc != null) {
			adj = gr.get(loc);
			next = loc;
			isEnd = adj != null && adj.getColor().equals(Color.RED);
			return true;
		}
		return false;
	}

	// 将甲虫的方向转向下一格，往前移动一步，将原来的位置压栈，并放置一朵绿花，表示走过的路径
	public void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		Location loc = this.getLocation();
		path.push(loc);
		this.setDirection(loc.getDirectionToward(next));
		this.moveTo(next);
		Flower flower = new Flower(this.getColor());
		flower.putSelfInGrid(gr, loc);
	}
}
