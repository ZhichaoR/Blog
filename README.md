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
* 请求处理层实现
* 实现前端页面功能
* 查看效果
## 后台管理模块
### 数据展示（2）——任智超
* 请求处理层实现
* 实现后台前端页面功能
* 查看效果
### 文章发布（3）——秦兴旺
* 业务处理层实现
* 请求处理层实现
* 实现前端页面功能
* 查看效果
### 文章修改（2）——任智超
* 业务处理层实现
* 请求处理层实现
* 查看效果
### 文章删除（3）——秦兴旺
* 业务处理层实现
* 请求处理层实现
* 实现前端页面功能
* 查看效果
### 用户登录控制（3）——郭子昀
* 请求处理层实现
* 实现前端页面功能
* 编写Security认证授权配置类
* 查看效果
### 定时邮件发送（3）——郭子昀
* 邮件发送工具类实现
* 邮件定时发送调度实现
* 开启基于注解的定时任务
* 查看效果
