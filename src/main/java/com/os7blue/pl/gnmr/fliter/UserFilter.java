package com.os7blue.pl.gnmr.fliter;

import com.os7blue.pl.gnmr.utils.UserState;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* @Description:    Check user state.
* @Author:         os7blue
* @CreateDate:     Create by 18-8-13 下午3:18
* @UpdateUser:     os7blue
* @UpdateDate:     Update by 18-8-13 下午3:18
* @UpdateRemark:   修改内容:无
* @Version:        1.0
*/
@WebFilter(urlPatterns = "/business/*",filterName = "userFilter")
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (UserState.checkState(request)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            response.sendRedirect("/noLogin");
        }
    }

    @Override
    public void destroy() {

    }
}
