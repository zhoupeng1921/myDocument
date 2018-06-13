package com.xhx.springcloud.filter;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * xuhaixing
 * 2018/6/12 22:29
 */
@Component
public class AccessFilter extends ZuulFilter {
    /**
     *     pre：可以在请求被路由之前调用
     *     route：在路由请求时候被调用
     *     post：在route和error过滤器之后被调用
     *     error：处理请求时发生错误时被调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";  //请求前被调用
    }

    @Override
    public int filterOrder() {
        return 0; //越小越先执行
    }

    /**
     * 是否执行过滤器，过滤器是否执行的开关
     * 如果有多个过滤器时，上一个过滤器返回为true,下一个过滤器需要执行，如果为false就没必要执行了
     *
     */
    @Override
    public boolean shouldFilter() {
        return true; //此过滤器始终执行
       // return (boolean)RequestContext.getCurrentContext().get("isSuccess");

    }

    /**
     * 具体执行的逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest(); //获取request

        System.out.println(String.format("%s AccessPasswordFilter request to %s", request.getMethod(), request.getRequestURL().toString()));
        String author = request.getHeader("author");

        if(StringUtils.isNotEmpty(author)){
            requestContext.setSendZuulResponse(true);  //对该请求进行路由
            requestContext.setResponseStatusCode(HttpStatus.OK.value());
            requestContext.set("isSuccess",true); //设置一个状态
            return null;
        }else {
            requestContext.setSendZuulResponse(false); //过滤该请求，不进行路由
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            JSONObject json = new JSONObject();
            json.put("msg","用户令牌错误");
            requestContext.setResponseBody(json.toJSONString());  //返回前端内容
            HttpServletResponse response = requestContext.getResponse();
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            requestContext.set("isSuccess",false);
            return null;
        }
    }
}
