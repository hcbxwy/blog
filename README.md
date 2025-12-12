# Blog

> 一个轻量级、全栈技术博客系统，用于展示 Java 后端架构能力与 Vue3 前端实践。项目从 0 到 1 独立开发，支持 Markdown 写作、JWT
> 认证、本地缓存优化，并可在 **2核2G 低配云服务器**上稳定运行。

[![License](https://img.shields.io/badge/license-Apache_2.0-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://openjdk.org/)
[![Vue](https://img.shields.io/badge/Vue-3-4FC08D.svg)](https://vuejs.org/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5-6DB33F.svg)](https://spring.io/projects/spring-boot)

## ✨ 项目目标

- ✅ **练手核心技能**：巩固 Spring Boot3、Vue3 等主流技术栈
- ✅ **展示架构能力**：分层设计、缓存优化、安全控制、Docker 部署
- ✅ **适配低配环境**：在2C2G的云服务器上高效运行

---

## 🛠 技术栈

### 后端（Spring Boot 3）

- Spring Boot 3.5.8
- MyBatis-Plus 3.5.14
- MySQL 8.0

### 前端（Vue3）

- nuxt：^3.20.2
- vue：^3.5.25
- vue-router：^4.6.3

### 运维 & 部署

- **服务器**：2核2G
- **Web 服务器**：Nginx（托管前端静态资源 + 反向代理 API）
- **监控**：`htop` + `docker stats`（手动观察资源使用）

---

## 🗂 项目结构

```bash
blog/
├── backend/
│   ├── blog-admin/                   # 后台管理模块
│   ├── blog-common/                  # 公共模块
│   ├── blog-core/                    # 核心模块
│   ├── blog-generator/               # 代码生成模块
│   ├── blog-portal/                  # 门户模块
│   ├── blog-start/                   # 启动模块
├── frontend/                         # 前端项目目录
├── scripts/                          # 脚本文件
├── doc/                              # 文档目录
├── README.md                         # 项目说明文档
```

## 🚀 快速启动（本地开发）

### 后端

```bash
cd backend
mvn clean package -DskipTests
java -jar blog-start/target/*.jar
```

### 前端

```bash
cd frontend
npm install
npm run dev  # 访问 http://localhost:5173
```

### 生产部署

```bash
# 构建前端
cd frontend && npm run build

# 启动服务（自动拉起 MySQL + Java + Nginx）
docker-compose up -d
```

## 📅 版本规划

| 版本   | 状态     | 功能描述       |
|------|--------|------------|
| v0.1 | ✅ 已完成  | 后端项目骨架工程搭建 |
| v0.2 | 🚧 计划中 | 前端项目骨架工程搭建 |
| v0.3 | ⏳ 计划中  | 登录注册功能     |
| v0.4 | ⏳ 计划中  | 文章发布与浏览    |
| v1.0 | ⏳ 计划中  | v1.0版本上线   |

## 📜 License

Apache License 2.0 — 免费用于学习、商用、二次开发。

> 作者：Leo
> Github：https://github.com/hcbxwy/blog
> 部署示例：www.hcbxwy.com
