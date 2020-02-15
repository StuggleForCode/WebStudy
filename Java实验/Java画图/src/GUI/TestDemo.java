package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class TestDemo {
	
	public final static int maze_x = 180;
	public final static int maze_y = 130;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				MyFrame  frame = new MyFrame();
				frame.setVisible(true);
			}
		});
	}
	
	/*
	 * 窗体
	 */
	public static class MyFrame extends JFrame{
		public static final String TITLE = "JAVA图形绘制";
		
		public static final int WIDTH = 1000;
		public static final int HEIGHT = 1000;
		
		public MyFrame() {
			super();
			initFrame();
		}
		
		public void initFrame() {
			//设置窗口标题 和窗体大小
			setTitle(TITLE);
			setSize(WIDTH, HEIGHT);
			
			//设置窗体关闭按钮的默认操作（点击关闭时退出进程）
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			
			//把窗体位置移到屏幕的中心
			setLocationRelativeTo(null);
			
			//设置窗体的内容面板
			MyPanel panel = new MyPanel(this);
			setContentPane(panel);
		}
		
	}
	
	/*
	 * 内容面板
	 * 
	 */
	
	public static class MyPanel extends JPanel{
		private MyFrame frame;
		public MyPanel(MyFrame myFrame) {
			super();
			this.frame = myFrame;
		}
		
		/*
		 * 绘制面板的内容：创建Jpanel后会调用一次该方法绘制内容
		 * 之后如果输入改变需要重新绘制，可调用updateUI() 方法触发
		 * 系统再次调用改方法绘制更新JPanel 的内容
		 */
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			//drawLine(g);
			//drawRect(g);
			drawImage(g);
		}
		
		
		private void drawLine(Graphics g) {
			//frame.setTitle("1. 线段/折线");
			
			//创建Graphics的副本， 需要改变Graphics的参数
			//这里必须使用副本，避免影响到Graphics原有的设置
			Graphics2D g2d = (Graphics2D)g.create();
			
			//抗锯齿
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			//设置画笔颜色
			g2d.setColor(Color.RED);
			
			//1. 绘制两点线段： 点（20， 50） 点（200， 50）；
			g2d.drawLine(20, 50, 200, 50);
			
			//2.多点绘制折线:点（50， 100） 点（100， 130） （150， 70) (200, 100);
			int[] xPoints = new int[] {50, 100, 150, 200};
			int[] yPoints = new int[] {100, 120, 80, 100};
			int nPoints = 4;
			g2d.drawPolyline(xPoints, yPoints, nPoints);
			

            // 3. 两点绘制线段（设置线宽为5px）: 点(50, 150), 点(200, 150)
            BasicStroke bs1 = new BasicStroke(5);       // 笔画的轮廓（画笔宽度/线宽为5px）
            g2d.setStroke(bs1);
            g2d.drawLine(50, 150, 200, 150);

            // 4. 绘制虚线: 将虚线分为若干段（ 实线段 和 空白段 都认为是一段）, 实线段 和 空白段 交替绘制,
            //             绘制的每一段（包括 实线段 和 空白段）的 长度 从 dash 虚线模式数组中取值（从首
            //             元素开始循环取值）, 下面数组即表示每段长度分别为: 5px, 10px, 5px, 10px, ...
            float[] dash = new float[] { 5, 10 };
            BasicStroke bs2 = new BasicStroke(
                    1,                      // 画笔宽度/线宽
                    BasicStroke.CAP_SQUARE,
                    BasicStroke.JOIN_MITER,
                    10.0f,
                    dash,                   // 虚线模式数组
                    0.0f
            );
            g2d.setStroke(bs2);
            g2d.drawLine(50, 200, 200, 200);

			
			g2d.dispose();
			}
		
		/* 
		 * 矩阵/多边形
		 */
		
		private void drawRect(Graphics g) {
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setColor(Color.black);
			
			//1. 绘制一个矩形： 起点（30， 20）， 宽80 高100
		//	g2d.drawRect(maze_x, maze_y, maze_x + 500, maze_y + 500);
			
			BasicStroke bs1 = new BasicStroke(3);
			g2d.setStroke(bs1);
			
			for (int x = maze_x; x <= maze_x + 500; x += 25)
				g2d.drawLine(x, maze_y, x, maze_y + 500);
			for (int y = maze_y; y <= maze_y + 500; y+= 25)
				g2d.drawLine(maze_x, y, maze_x + 500, y);
			
			
			
			
//			//2.填充一个矩形
//			g2d.fillRect(140, 20, 80, 100);
//			
//			//3.绘制一个圆角矩形: 起点（30， 150） 宽80， 高100， 圆角宽30， 圆角高30
//			g2d.drawRoundRect(30, 150, 80, 100, 30, 30);
//			
//			//4. 绘制一个多边形，（收尾相连）： 点（140， 150） 点180， 250  点 220 200
//			int[] xPoint = new int[] {140, 180, 220};
//			int[] yPoint = new int[] {150, 250, 200};
//			int nPoint = 3;
//			g2d.drawPolygon(xPoint, yPoint, nPoint);
//			
//			g2d.dispose();
			
		}
			
		private void drawImage(Graphics g) {
			Graphics2D g2d = (Graphics2D)g.create();
			
			// 从本地读取一张图片
			String filepath = "Map.jpg";
			Image image = Toolkit.getDefaultToolkit().getImage(filepath);
			
			//绘制图片（如果宽高穿的不是图片原本的宽度， 则图片将会适当缩放绘制
			g2d.drawImage(image, 100, 100, 30, 30,this);
			//g2d.drawImage(image,  500, 500, 30, 30,this);
			
			g2d.dispose();
			}
		}

}

