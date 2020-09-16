配置文件访问地址：
http://localhost:8888/config-server/dev/schema


#创建镜像
docker build -t lhz-config-server:1.0.0 .


#允许容器
docker-compose up -d
