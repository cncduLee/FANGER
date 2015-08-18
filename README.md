FANGER（乐享）
======

项目简介：
---
FANGER（乐享）是一款基于信息分享的微型生活感悟平台。
帮助用户“乐分享，爱生活”是本应用的一个宗旨。
注：请使用Googel浏览器或者firfox体验本项目。

关于本项目技术：
---
    1.MVC Framework：Spring MVC
    2.ORM Framework：Spring-Data-JPA、Hibernate。
    3.Bean Validation：Hibernate Validation
    4.Database: MySql
    5.Automatically build：maven
    6.Unit testing：Junit（4.0）
    7.Commons：Apache Commons
    8.JavaScript/CSS组合（compistor）：Twitter推出的bootStrap工具包
    9.Map: GMap3。 

REST接口：
---
    1.获取Spot
    currentPapge:   requred=false    当前页
    pageSize:       requred=false    页片大小
    type:           requred=false    类型
    URL:http://fanger.cloudfoundry.com/rest/spot/list?currentPage=0&pageSize=10&type={type}
    
    2.用户登陆(@Deprecated)
    参数：无
    URL:http://fanger.cloudfoundry.com/rest/AnrUser/list
    
    3.用户列表(@Deprecated)
    参数：LinkedMultiValueMap<String, String> map
    
    URL:http://fanger.cloudfoundry.com/rest/AnrUser/login
    
关于项目：
---
本项目旨在学习交流，是本人初次独自完成的开源项目。望多多指教！    

部分功能展示：
---
> 登陆页面

![DataV logo](https://raw.github.com/cncduLee/FANGER/master/src/main/resources/assets/signIn.png)


> 地图视图

![DataV logo](https://raw.github.com/cncduLee/FANGER/master/src/main/resources/assets/mapView.png)

> 评论视图

![DataV logo](https://raw.github.com/cncduLee/FANGER/master/src/main/resources/assets/comment.png)

> 上传文件视图

![DataV logo](https://raw.github.com/cncduLee/FANGER/master/src/main/resources/assets/importImage.png)

> 定位视图

![DataV logo](https://raw.github.com/cncduLee/FANGER/master/src/main/resources/assets/localtion.png)


> 后台管理视图

![DataV logo](https://raw.github.com/cncduLee/FANGER/master/src/main/resources/assets/admin.png)

> 注册视图

![DataV logo](https://raw.github.com/cncduLee/FANGER/master/src/main/resources/assets/signUp.png)

说明：
----
访问[本项目](http://fanger.cloudfoundry.com/)时，请使用Googel浏览器或者firfox。
