#!/bin/bash

# 定义版本号
VERSION=1.0.0
# 镜像仓库地址
REGISTRY_URL=10.13.14.230:5000

# 构建 Docker 镜像
docker build -t server:$VERSION -f ./server.Dockerfile .

# 为私有 Registry 标记镜像，包括版本号
docker tag server:$VERSION $REGISTRY_URL/server:$VERSION

# 推送镜像到私有 Registry，包括版本号
docker push $REGISTRY_URL/server:$VERSION

curl -X GET http://$REGISTRY_URL/v2/server/tags/list