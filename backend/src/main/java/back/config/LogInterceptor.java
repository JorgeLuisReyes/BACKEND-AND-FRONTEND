package back.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

@Component
public class LogInterceptor implements HandlerInterceptor {

    private Long startTime;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3)
            throws Exception {
        LogService.logger.info("Termino Enpoint (" + request.getRequestURI()+ ") " + "[" + Long.valueOf(Calendar.getInstance().getTimeInMillis() - getStartTime()).toString() + "]");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView model)
            throws Exception {
// LogService.logger.info("postHandle ");
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        LogService.logger.info("Inicio Enpoint (" + request.getRequestURI() +") ");
        this.setStartTime(Calendar.getInstance().getTimeInMillis());
        return true;
    }


    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

}
