package rjgc.ten.blog.web.scheduletask;

import org.slf4j.impl.StaticMarkerBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import rjgc.ten.blog.dao.StatisticMapper;
import rjgc.ten.blog.model.domain.Statistic;
import rjgc.ten.blog.utils.MailUtils;

//郭子昀
//定时任务管理类
@Component
public class Scheduletask {
    @Autowired
    private StatisticMapper statisticMapper;
    @Autowired
    private MailUtils mailUtils;
    //${spring.mail.username}
    @Value("${spring.mail.username}")
    private String mailto;
    //定时邮件发送任务，通过注解指定每月1日中午12点调用邮件发送任务发送邮件
    @Scheduled(cron="0 */3 * * * ?")
    public void sendEmail(){
        //定制邮件内容
        long totalvisit = statisticMapper.getTotalVisit();
        long totalComment = statisticMapper.getTotalComment();
        StringBuffer content = new StringBuffer();
        content.append("博客系统总访问量未："+totalvisit+"人次").append("\n");
        content.append("博客系统总评论量为："+totalComment+"人次").append("\n");
        mailUtils.sendSimpleEmail(mailto, "个人博客系统流量统计情况",content.toString());
    }
}
