package work.timer.portal.security.filter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author DaiMao
 * 个人qq: 12636993
 * @Date 2020/3/16 0016 11:40
 * TODO: (这里用一句话描述这个类的作用)
 */
public class TimerAuthenticationFilter extends FormAuthenticationFilter {
    @Override
    protected boolean isLoginRequest(ServletRequest request, ServletResponse response) {
        return this.pathsMatch(this.getLoginUrl(),request) ||
                this.pathsMatch("/admin/timer/login.do",request);
    }
}
