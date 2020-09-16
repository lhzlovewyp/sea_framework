#创建镜像
docker build -t lhz-eureka-server:1.0.0 .


#允许容器
docker-compose up -d
