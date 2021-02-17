# 安卓二维码工具-原生写法
## 功能：
1. 输入字符生成二维码
2. 扫码,展示条码中的信息

## 特色:
原生java写法


###致谢:
[https://github.com/yipianfengye/android-zxingLibrary](https://github.com/yipianfengye/android-zxingLibrary)



google 迁移AndroidX
AndroidX是什么?


按照官方文档说明 AndroidX 是对 android.support.xxx 包的整理后产物。由于之前的 support 包过于混乱，所以，Google 推出了AndroidX。

由于在后续版本中，会逐步放弃对 support 的升级和维护，所以，我们必须迁移到 AndroidX .对此，官方描述如下：

https://developer.android.google.cn/jetpack/androidx/



gradle本地化构建技巧

定义gradle配置文件

仓库配置:
项目配置:




即时通讯与音视频


Bmob 后台云

Android
H5 app
Native+H5
React Native
ionic




我先介绍下需求以及如何入门开发,

上下文:
安卓系统下,换新手机或者手机系统重置时候,最放心不下通讯录里的电话
因为国内环境限制无法直接使用谷歌原生同步功能,加上第三方同步软件又又各种限制,要么接受,要么拒绝,本着自己动手丰衣足食的原则,于是可以自(瞎)制(琢磨)app

需求:
第一版本:
1. 读取手机联系人
2. 将数据上传server存入db
3. 从server恢复联系人到本地


技术:
1. 安卓API学习&调用,实现联系人的CRUD (原生Java开发)
2. 安卓与server网络交互
3. 安卓app简单布局
4. 安卓app签名打包发布
5. 后端server设计,与其他支持


支持:
1. 开发者文档 https://developer.android.google.cn/training/basics/firstapp
2. 哔哩哔哩

Shutdown -s -t 360




总结:
1 app开发是一个系统性的事情,app开发的契机可以了解安卓开发基本要求,熟悉后端设计,熟悉部署学写脚本等
2 端上开发调试,对于代码效率有了新的考虑,端上效率,网络消耗,等待卡顿等
3 思考:如果资源有限,后端设计思想应该是怎样才合理?

(我遇到的问题:同名联系人现实情况中会有多个手机号\电话\邮箱, 我原始设计db中采用主表+子表来设计,在联系人同步中时update操作变得异常复杂.改进做法使用单一表用一个列来存储多个手机号,
结论:下层需要足够简约灵活以应付频繁变更,等待业务模型摸索ok后,再次迭代可以重构到理想的结构化数据.)




建议总资源投入比如下:
后端开发占30%精力,基础设施环境打包发布20%,客户端50%
隐含意思你的db需要设计的足够简单节省时间,推荐使用非结构化存储,或者冗余设计的结构化存储,持久层最好选用自动化高的技术栈,
(实践下来使用MySQL /或者 mongodb  + spring data JPA)
因为新手对于Android上手可能边做边学理解上有偏差,可能造成底层数据结构频繁修正,



第二版本:
照片\音乐\app 备份





git@github.com:lamymay/zero.git

第一部分入门篇 ：Android视图入门
https://www.bilibili.com/video/BV1e4411b7u9?from=search&seid=6452059367987966238

一课掌握Kotlin 突破开发语言瓶颈
https://www.bilibili.com/video/BV1Vv41147iU?from=search&seid=1535520070319287948

src/main/java/com/arc/zero/init/SystemInitializationStartup.java:87







