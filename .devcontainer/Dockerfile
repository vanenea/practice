# 使用官方 Maven + Java 镜像
FROM maven:3.9.3-eclipse-temurin-17

# 安装必要工具
RUN apt-get update && apt-get install -y \
    curl git unzip bash vim && \
    rm -rf /var/lib/apt/lists/*

# 创建非 root 用户（JetBrains 建议）
RUN useradd -ms /bin/bash devuser
USER devuser
WORKDIR /workspace