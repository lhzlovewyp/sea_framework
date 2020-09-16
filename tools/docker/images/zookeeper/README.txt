#启动命令

docker-compose up -d

#zk相关命令
#查看配置是否已经配好

docker ps 找到 2181对应的容器id

#进入容器
docker exec -it 87a82819c00d /bin/bash

#查看zk运行状态
echo stat | nc 127.0.0.1 2181
