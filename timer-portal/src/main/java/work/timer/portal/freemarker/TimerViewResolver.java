package work.timer.portal.freemarker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author DaiMao
 * 个人qq: 12636993
 * @Date 2020/3/16 0016 22:32
 * TODO: (添加绝对路径)
 */
@Slf4j
public class TimerViewResolver extends FreeMarkerView {
    private static final String ADMIN_PATH = "/admin/timer/";
    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        log.info(requestURI);
        log.info(contextPath);
        log.info(servletPath);
        model.put("basePath",contextPath);
        if (requestURI.contains(ADMIN_PATH)){
            model.put("adminPath",contextPath+servletPath);
        }
    }
}
