package cn.itcast.itcaststore.web.servlet.manager;

import cn.itcast.itcaststore.domain.Product;
import cn.itcast.itcaststore.service.ProductService;
import cn.itcast.itcaststore.utils.FileUploadUtils;
import cn.itcast.itcaststore.utils.IdUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/editProductServlet")
public class EditProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建javabean, 将编辑商品上传的数据封装
        Product p = new Product();
        Map<String, String> map = new HashMap<String ,String>();
        //设置临时文件存储位置
        DiskFileItemFactory dfif = new DiskFileItemFactory();
        dfif.setRepository(new File(this.getServletContext().getRealPath("/temp")));
        //设置文件缓存大小为10M
        dfif.setSizeThreshold(1024*1024*10);
        //创建上传组件
        ServletFileUpload upload = new ServletFileUpload(dfif);
        //处理上传的乱码
        upload.setHeaderEncoding("utf-8");
        try {
            //解析request得到所有FileItem
            List<FileItem> items = upload.parseRequest(request);
            for(FileItem item:items){
                if(item.isFormField()){
                    //不是上传组件
                    String fileName = item.getFieldName();
                    String value = item.getString("utf-8");//防止乱码
                    map.put(fileName,value);
                }else{//是上传组件
                    String fileName = item.getName();
                    fileName = FileUploadUtils.subFileName(fileName);//得到文件名
                    String randomName = FileUploadUtils.generateRandomFileName(fileName);//得到随机文件名
                    String randomDir = FileUploadUtils.generateRandomDir(randomName);//得到随机目录
                    //图片存储父目录
                    String imgurl_parent = "/productImg" + randomDir;
                    File parentDir = new File(this.getServletContext().getRealPath(imgurl_parent));
                    //验证这个目录是否存在，不存在则需要创建目录
                    if(!parentDir.exists()){
                        parentDir.mkdirs();
                    }
                    String imgurl = imgurl_parent + "/" + randomName;
                    map.put("imgurl", imgurl);
                    IOUtils.copy(item.getInputStream(), new FileOutputStream(new File(parentDir, randomName)));
                    item.delete();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        //将数据封装到javabean
        try {
            BeanUtils.populate(p, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service完成商品添加操作
        ProductService service = new ProductService();
        service.editProduct(p);
        //跳转到列表
        response.sendRedirect(request.getContextPath() + "/listProductServlet");
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
