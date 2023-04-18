# 石家庄学院20软件工程第10小组springboot期末考核
## 前台管理模块
### 文章分页展示（4）——秦兴旺
* 数据访问层实现
编写了Article Statistic实体类
编写了ArticleMapper 和StatisticMapper接口的全部功能
处理了MyUtils工具类
* 业务处理层实现
编写了IArticleService中的分页查询文章列表方法selectArticleWithPage和热度排名方法getHeatArticle();
实现类实现了这些方法
* 请求处理层实现
编写了IndexController中的index方法
* 实现前端页面的功能
* 实现了自定义Interceptor拦截器
* 查看效果
### 文章详情查看（5）——任智超
* 数据访问层实现  
编写Comment实体类  
处理Commons工具类
编写CommentMapper类里面的selectCommentWithPage、selectNewComment、pushComment、countComment、deleteCommentWithId
* 业务处理层实现  
编写ICommentService和ISiteService  
在ArticleServiceImpl里面写了selectArticleWithId方法  
在CommentServiceImpl里面写了getComments方法  
在SiteServiceImpl里面写了recentComments、recentArticles、getStatistics、updateStatistics
* 请求处理层实现  
编写IndexController里面的getArticleById和getArticleComments
* 实现前端页面的功能  
articleDetails.html
* Redis服务启动与配置  
编写RedisConfig类实现Redis缓存管理
* 查看效果
### 文章评论管理（3）——郭子昀
* 业务处理层实现
  在ICommentService里面编写pushComment方法 
  在CommentServiceImpl中实现新增的pushComment方法
* 请求处理层实现
  在web.client下创建CommentController,并编写相应的请求控制方法
* 实现前端页面功能
  comments.html
* 查看效果
## 后台管理模块
### 数据展示（2）——任智超
* 请求处理层实现  
编写AdminController里面的index方法向request域中添加属性（最新博客，评论以及统计数据）。
* 实现后台前端页面功能
* 查看效果
### 文章发布（3）——秦兴旺
* 业务处理层实现
在IArticleService中编写了Publish方法
在ArticleService中实现了Publsh()方法
* 请求处理层实现
在AdminConller中添加了页面跳转请求的方法，包括跳转到文章发布页面的请求方法、发布文章请求的方法、以及发布成功后跳转到文章管理页面的请求方法。
* 实现前端页面功能
* 查看效果
### 文章修改（2）——任智超
* 业务处理层实现  
在IArticleService中添加updateArticleWithId方法  
在ArticleServiceImpl中添加updateArticleWithId的实现方法
* 请求处理层实现  
在AdminController类中添加editArticle以及modifyArticle
* 查看效果
### 文章删除（3）——秦兴旺
* 业务处理层实现
在IArticleService中添加删除方法deleteArticleWithId
在ArticleServiceImpl中实现deleteArticleWithI方法
* 请求处理层实现
在AdminCntroller中添加文章删除方法delete
* 实现前端页面功能
* 查看效果
### 用户登录控制（3）——郭子昀
* 请求处理层实现
  在web.client下创建LoginController,并编写向自定义页面登录的请求控制方法
* 实现前端页面功能
  login.html
* 编写Security认证授权配置类
  在web.client下创建用于整合Security进行安全控制的配置类SecurityConfig
* 查看效果
### 定时邮件发送（3）——郭子昀
* 邮件发送工具类实现
  在utils下创建用于邮件发送服务的工具类MailUtils,并编写一个发送简单邮件的方法sendSimpleEmail()
* 邮件定时发送调度实现
  在web.scheduletask包下创建定时任务管理类Scheduletask,并编写一个方法sendEmail()调用邮件工具类来实现定时邮件发送任务
* 开启基于注解的定时任务
  项目启动类上添加@EnableScheduling注解开启基于注解的定时任务支持
* 查看效果
