package cn.itcast.itcaststrore.web.servlet.client;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet("/checkImageServlet")
public class CheckImageServlet extends HttpServlet {
    private List<String> words = new ArrayList<String>();
    /**
     * 读new_words.txt，存到List中，后面会随机取出一个成语作为验证码
     */
    public void init(){
        String path = getServletContext().getRealPath("/WEB-INF/new_words.txt");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
            String line;
            while ((line = reader.readLine())!=null){
                words.add(line);
                //System.out.println(line);
            }
            reader.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        for(int i = 0; i < words.size(); i++){
//            System.out.println(words.get(i));
//        }
    }

    /**
     * 输出验证码
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter writer = response.getWriter();
//        writer.write(words.get(0));
        int width = 180;
        int height = 30;
        //1.画一张内存图片
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //2.画背景
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(getRandColor(200,250));//画任何图形之前必须要指定一个颜色
        graphics.fillRect(0, 0, width, height);
        //3.画边框
        graphics.setColor(Color.white);
        graphics.drawRect(0, 0, width -1, height -1);
        //4.求随机数
        Graphics2D graphics2D = (Graphics2D)graphics;
        //5.设置输出字体
        graphics2D.setFont(new Font("宋体",Font.BOLD, 18));
        Random random = new Random();
        int index = random.nextInt(words.size());//生成随机数在646个成语中随机选一个
        String word = words.get(index-1);
//        System.out.println(word);
//        System.out.println(getEncoding(word));
//        byte[] bytes = word.getBytes("GB2312");
//        word = new String(bytes, "UTF-8");
//        System.out.println(word);
//        System.out.println(getEncoding(word));
        //6.画出验证码
        int x = 10;
        for (int i = 0; i < word.length(); i++){
            graphics2D.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            //旋转角度
            int angle = random.nextInt(60) - 30;
            double theta = angle * Math.PI/180;//换算弧度
            char c = word.charAt(i);//获得字符
            graphics2D.rotate(theta,x,20);//旋转
            graphics2D.drawString(String.valueOf(c), x, 20);
            graphics2D.rotate(-theta, x, 20);
            x += 40;
        }
        //验证码保存到Session
        request.getSession().setAttribute("checkCode_Session", word);
        //7.画干扰线
        graphics.setColor(getRandColor(160, 200));
        int x1, x2, y1, y2;
        for(int i = 0; i < 30; i++){
            x1 = random.nextInt(width);
            x2 = random.nextInt(12);
            y1 = random.nextInt(height);
            y2 = random.nextInt(12);
            graphics.drawLine(x1, y1, x1 + x2, y1 + y2);
        }
        //8.图片输出到浏览器
        graphics.dispose();
//        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(response.getOutputStream());
        encoder.encode(bufferedImage);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    /**
     * 取某个范围的Color
     * @return
     */
    private Color getRandColor(int fc, int bc){
        Random random = new Random();
        if(fc > 255){
            fc = 255;
        }
        if(bc > 255){
            bc = 255;
        }
        int r = fc + random.nextInt(bc- fc);
        int g = fc + random.nextInt(bc- fc);
        int b = fc + random.nextInt(bc- fc);
        return new Color(r, g, b);
    }

    public static String getEncoding(String str) {
        String encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {      //判断是不是ISO-8859-1
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }
        encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {      //判断是不是GB2312
                String s = encode;
                return s;      //是的话，返回“GB2312“，以下代码同理
            }
        } catch (Exception exception) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {   //判断是不是UTF-8
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {      //判断是不是GBK
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return "";        //如果都不是，说明输入的内容不属于常见的编码格式。
    }
}
