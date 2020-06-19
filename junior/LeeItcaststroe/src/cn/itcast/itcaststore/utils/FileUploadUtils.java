package cn.itcast.itcaststore.utils;

import java.util.UUID;

/**
 * 图片文件上传
 */

public class FileUploadUtils {
    //1.截取真实文件名
    public static String subFileName(String fileName){
        //查找最后一个\出现的位置
        int index = fileName.lastIndexOf("\\");
        if(index == -1){
            return fileName;
        }
        return  fileName.substring(index + 1);
    }

    //2.获得随机的UUID文件名
    public static String generateRandomFileName(String fileName){
        //获得文件的扩展名
        int index = fileName.lastIndexOf(".");
        if(index != -1){
            String ext = fileName.substring(index);
            return UUID.randomUUID().toString()+ext;
        }
        return UUID.randomUUID().toString();
    }

    //3.获得hashcode生成二级目录，每级目录是16个，最多是256个目录
    public static String generateRandomDir(String uuidFileName){
        int hasCode = uuidFileName.hashCode();
        //一级目录
        int d1 = hasCode & 0xf;
        //二级目录
        int d2 = (hasCode >> 4) & 0xf;
        return "/"+d1+"/"+d2;
    }

    public static void main(String[] args) {
//        System.out.println( FileUploadUtils.subFileName("c:a\\b\\c\\imag\\logo.png"));
//        System.out.println( FileUploadUtils.generateRandomFileName("c:a\\b\\c\\imag\\logo.png"));
        System.out.println(FileUploadUtils.generateRandomDir("1088c09b-8c91-4658-a7f1-6e07b3c5cb18"));
    }
}
