package cn.itcast.itcaststore.web.servlet.client;

import com.sun.deploy.net.MessageHeader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Input {
    public static void main(String[] args) {
        List<String> words = new ArrayList<String>();
       String path = "itcaststore/web/WEB-INF/new_words.txt";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
            String line;
            while ((line = reader.readLine())!=null){
                words.add(line);
            }
            reader.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < words.size(); i++){
            System.out.println(words.get(i));
        }
    }
}
