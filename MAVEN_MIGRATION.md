# Maven 迁移指南

## 概述
本项目已从传统的lib依赖方式迁移到Maven依赖管理方式。

## 主要变更

### 1. 新增文件
- `pom.xml`: Maven项目配置文件，包含所有依赖定义
- `MAVEN_MIGRATION.md`: 迁移说明文档

### 2. 依赖管理
原来的lib目录下的jar文件现在由Maven中央仓库管理：

| 原lib文件 | Maven坐标 |
|-----------|-----------|
| aopalliance-1.0.jar | aopalliance:aopalliance:1.0 |
| aspectjweaver-1.6.11.jar | org.aspectj:aspectjweaver:1.6.11 |
| commons-beanutils-1.8.3.jar | commons-beanutils:commons-beanutils:1.8.3 |
| commons-logging-1.1.1.jar | commons-logging:commons-logging:1.1.1 |
| fastjson-1.1.26.jar | com.alibaba:fastjson:1.1.26 |
| spring-*.jar | org.springframework:spring-*:3.1.1.RELEASE |

### 3. 使用方法

#### 3.1 安装Maven
确保系统已安装Maven 3.6+版本。

#### 3.2 清理旧的lib依赖
```bash
# 可以安全删除lib目录（可选）
rm -rf lib/
```

#### 3.3 构建项目
```bash
# 清理并编译
mvn clean compile

# 运行测试
mvn test

# 打包
mvn package

# 运行服务端测试
mvn exec:java -Dexec.mainClass="org.easyws.test.TestService"

# 运行客户端测试
mvn exec:java -Dexec.mainClass="org.easyws.test.TestClient"
```

#### 3.4 IDE集成
- **Eclipse**: 右键项目 -> Configure -> Convert to Maven Project
- **IntelliJ IDEA**: 打开项目时选择pom.xml文件
- **VS Code**: 安装Maven扩展，自动识别pom.xml

### 4. 项目结构
保持原有的目录结构：
- `src/`: 主要源代码
- `test/`: 测试代码
- `resources/`: 配置文件

### 5. 版本信息
- **Java版本**: 1.6 (与原来保持一致)
- **Spring版本**: 3.1.1.RELEASE (与原来保持一致)
- **项目版本**: 1.0.0

### 6. 注意事项
- 所有依赖版本与原来保持一致，确保兼容性
- Maven会自动下载并管理所有依赖，无需手动添加jar文件
- 项目编码设置为UTF-8

## 验证步骤
1. 执行 `mvn clean compile` 确保编译成功
2. 执行 `mvn test` 确保测试通过
3. 执行 `mvn package` 确保打包成功
4. 运行原有的测试类验证功能正常