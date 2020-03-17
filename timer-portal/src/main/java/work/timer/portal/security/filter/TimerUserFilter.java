package work.timer.portal.security.filter;

import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.web.filter.authc.UserFilter;

/**
 * @Author DaiMao
 * 个人qq: 12636993
 * @Date 2020/3/16 0016 11:48
 * TODO: (这里用一句话描述这个类的作用)
 */
@Getter
@Setter
public class TimerUserFilter extends UserFilter {
    private String adminLoginUrl;
    private String adminPrefix;


}
