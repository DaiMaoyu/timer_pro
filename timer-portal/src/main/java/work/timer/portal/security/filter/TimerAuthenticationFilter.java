package work.timer.portal.security.filter;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import work.timer.context.foundation.Result;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author DaiMao
 * 个人qq: 12636993
 * @Date 2020/3/16 0016 11:40
 * TODO: (登录请求是否阻拦)
 */
public class TimerAuthenticationFilter extends FormAuthenticationFilter {
    private static final String ADMIN_LOGIN = "/admin/timer/login.do";

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        Thread.sleep(2000);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(Result.success("登录成功")));
        return false;
    }

    @Override
    protected boolean isLoginRequest(ServletRequest request, ServletResponse response) {
        return this.pathsMatch(this.getLoginUrl(), request) ||
                this.pathsMatch(ADMIN_LOGIN, request);

    }
}
