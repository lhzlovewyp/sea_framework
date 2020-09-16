
#启动命令
ip=$(ipconfig getifaddr en0) docker-compose up -d


#查看配置是否已经配好

docker ps 找到 redis_redis-node1对应的容器id

#进入容器
docker exec -it 76c830b7e026 /bin/bash

#进入容器后，连接redis
redis-cli -h 127.0.0.1 -p 7000 -a pass.123

#查看cluster nodes
cluster nodes

#查看集群信息
cluster info
