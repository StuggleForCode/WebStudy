package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@WebFilter("/*")
public class EncodingFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //处理请求乱码
        System.out.println(req.getParameter("category"));
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletRequest myRequest = new MyRequest(httpServletRequest);
//        System.out.println(myRequest.getParameter("category"));
        //处理响应乱码
//        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8"); //设置浏览器和响应的时候乱码
        chain.doFilter(myRequest, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }
}

//自定义request对象
class MyRequest extends HttpServletRequestWrapper{
    private HttpServletRequest request;
    private boolean hasEncode;
    public MyRequest(HttpServletRequest request){
        super(request);//super必须写
        this.request = request;
    }
    //对需要增强方法进行覆盖
    public Map getParameterMap() {
        //先获得请求方式
        String method = request.getMethod();
        if(method.equalsIgnoreCase("post")){
//            System.out.println("hhhh");
            //post请求
            try {
                //处理post乱码
                request.setCharacterEncoding("utf-8");
                return request.getParameterMap();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else if(method.equalsIgnoreCase("get")){
            System.out.println("zzzz");
            //get请求
            Map<String, String[]> parameterMap = request.getParameterMap();
            if(!hasEncode){
                //确保get手动编码逻辑只运行一次
                for(String parameterName : parameterMap.keySet()){
                    String[] values = parameterMap.get(parameterName);
                    if(values != null){
                        for(int i = 0; i < values.length; i++){
                            try {
                                System.out.println(values[i]);
                                values[i] = new String(values[i].getBytes("ISO-8859-1"),"utf-8");
                                System.out.println(values[i]);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                hasEncode = true;
            }
            return parameterMap;
        }
        return super.getParameterMap();
    }

    public String getParameter(String name){
        Map<String, String[]> parameterMap = getParameterMap();
        String[] values = parameterMap.get(name);
        if(values == null){
            return null;
        }
        return values[0];
    }

    public String[] getParameterValues(String name){
        Map<String, String[]> parameterMap = getParameterMap();
        String[] values = parameterMap.get(name);
        return values;
    }
}