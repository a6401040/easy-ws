### 📋 项目概述
- 项目名称 : easy-ws
- 项目描述 : "easy xml for webService"
- 技术栈 : Java, Spring Framework, JAXB, JSON
### 🏗️ 项目结构
```
easy-ws/
├── src/                 # 主要源代码
│   └── org/easyws/
│       ├── endpoint/    # WebService端点
│       ├── exception/   # 异常处理
│       ├── jaxb/        # JAXB数据绑定
│       ├── stardand/    # 标准接口定义
│       ├── util/        # 工具类
│       └── work/        # 工作核心类
├── test/                # 测试代码
│   └── org/easyws/
│       ├── jaxb/standard/ # 标准测试实现
│       └── test/        # 测试类
├── resources/           # 配置文件
├── lib/                 # 依赖库
├── bin/                 # 编译后的类文件
├── .classpath           # Eclipse类路径配置
├── .project            # Eclipse项目配置
└── README.md           # 项目说明
```
### 🎯 核心功能
1. WebService客户端-服务端架构
   
   - 服务端: Server 接口及实现 ServerImpl
   - 客户端: Client 接口及实现 ClientImpl
2. 示例：实体类
   - Student : 学生实体 (id, name, sex)
   - Teacher : 教师实体 (name, lesson)
3. 示例：服务接口
   - getStudentName(String id) : 根据ID获取学生姓名
   - getTeacher(Student student) : 根据学生获取教师信息
### 🔧 技术配置
- Spring版本 : 3.1.1.RELEASE
- Java版本 : JDK 1.6.0_43
- 主要依赖 :
  - Spring Context, Core, Beans
  - FastJSON 1.1.26
  - Apache Commons BeanUtils
  - AspectJ Weaver
### ⚙️ 配置详情
从 resources/easy.xml 可以看到：

- 服务端配置 :
  - IP: 127.0.0.1
  - 端口: 9088
  - 服务名: zql/easyWs
- 客户端配置 :
  - 连接超时: 60秒
  - 读取超时: 180秒
### 🧪 测试示例
- TestClient : 客户端测试，演示如何调用WebService
- TestService : 服务端测试，演示如何启动WebService
### 📦 构建输出
项目编译后的类文件位于 bin/ 目录下，包含了所有核心类的编译版本。

这个项目是一个简单的WebService框架实现，提供了基于XML配置的客户端-服务端通信能力，使用Spring进行依赖注入，支持JAXB数据绑定。
