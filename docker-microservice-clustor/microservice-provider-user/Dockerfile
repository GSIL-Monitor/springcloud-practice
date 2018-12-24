#基于哪个镜像
FROM java:8

#将本地文件夹挂在到当前镜像
VOLUME /tmp

#复制文件到容器，也可以直接携程ADD microservice-provider-user-1.0.0-SNAPSHOT.jar /app.jar
ADD microservice-provider-user-1.0.0-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'

#声明需要暴露的端口
EXPOSE 8000

#配置容器启动后执行的命令
ENTRYPOINT ["java","-Djava.security.edg=file:/dev/./urandom","-jar","/app.jar"]