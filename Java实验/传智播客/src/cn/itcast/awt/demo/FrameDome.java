package cn.itcast.awt.demo;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameDome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1.创建窗体 Frame
		Frame f = new Frame("myFrame");
		//2. 对窗体进行基本设置
		f.setSize(500, 400);
		f.setLocation(400, 400);
		
		//设置布局
		f.setLayout(new FlowLayout());
		
		// 给窗体添加组件
		Button but = new Button("My button");
		
		//加入文本框组件
		TextField tf = new TextField(40);
		
		
		
		//将组件添加到窗体中
		f.add(but);
		f.add(tf);
		//3.让窗体显示
		
		
		/*
		 * 需求： 文本框中只能输入数字
		 * 事件源：文本框
		 * 文本框注册键盘监听
		 * 事件处理
		 */
		
		tf.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//1. 如何获取录入的内容， 通过键盘事件对象获取
//				char key = e.getKeyChar();
//				int code = e.getKeyCode();
//				System.out.println(key + "....." + KeyEvent.getKeyText(code));
				
				
//				int code = e.getKeyCode();
//				if(!(code >= KeyEvent.VK_0 && code <= KeyEvent.VK_9)) {
//					System.out.println("必须是0-9的数");
//					e.consume();
//				}
				
				if(e.isControlDown() &&e.getKeyCode() ==  KeyEvent.VK_ENTER) {
					System.out.println("ctrl + enter run");
				}
				
			}
			
		});
		
		
		
		/*
		 * 需求： 想要点击按钮有效果， 比如打印一句话。
		 * 思路：
		 * 1.确定事件源，按钮
		 * 2.确定监听器。按钮添加监听器，按钮对象最清楚。到按钮对象中查找
		 * 3.定义处理方式。
		 * 
		 * 定义的规范： xxxxxxxLinstender:xxx监听器
		 * 
		 */
		//1. 在按钮上添加所需的监听器
		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("按钮被触发了。。。" + e);
				//System.exit(0);
				
			}
		});
		
		
		/*
		 * 需求：想要实现点击窗体的x就可以实现窗体的关闭
		 * 思路：
		 * 1.事件源：窗体
		 * 2.监听器：通过窗口对象去查
		 * 3.事件处理
		 * 
		 * 到底哪些监听接口又适配器类？
		 * 只要监听接口的中的方法在2个以内，都没有适配器类。适配器的出现只为方便创建监听对象
		 * 但是一般监听接口都有适配器
		 */
		
		f.addWindowListener(new WindowAdapter() {
			
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("window closing");
				System.exit(0);
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				//super.windowOpened(e);
				System.out.println("kong que kai ping ");
			}
			
			
		});
		
		

		/*
		 * 演示鼠标监听
		 * 
		 * 按钮事件源
		 * 鼠标监听器注册到按钮上。
		 * 
		 * 组件.addXXXListener(new XXXAdapter()
		 * {
		 * 		public void methodName(XXXEvent e){}
		 * });
		 * 
		 */
		
		
		
		but.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				/*
				 * 
				 * 想要对鼠标双击进行处理， 应该找鼠标事件对象。 因为事件对象一产生，内部必然封装事件源以及事件相关内容
				 * 要查MouseEvent对象
				 */
				
				if(arg0.getClickCount() == 2) {
					System.out.println("mouse Click");
				}
				
			}
			
		});
		
		
		
		f.setVisible(true);
		System.out.println("over");
	}

}
