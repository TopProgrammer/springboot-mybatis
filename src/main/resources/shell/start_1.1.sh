#!/bin/bash
BUILD_ID=DONTKILLME
echo "清除target下编译的文件"
mvn clean
echo "重新编译，打包"
mvn package
FOLDER="/root/server/bak/"
JAR_PATH=`pwd`
FILE=$JAR_PATH/target/*.jar
echo "关掉上次启动的项目"
ID=`netstat -nlp|grep -w 8088 | sed -r 's#.* (.*)/.*#\1#'`
if [ "$ID" = "" ]
then
  echo "当前端口未被占用!"
else
  echo "8088端口已被占用，正在杀掉线程$ID"
  kill -9 $ID
fi
nohup /usr/lib/jdk8/jdk1.8.0_111/bin/java -jar /root/.jenkins/workspace/jenkins_for_github/target/springboot-0.0.1-SNAPSHOT.jar > /root/.jenkins/workspace/jenkins_for_github/nohup.out 2>&1 &
echo "start success!"
exit 0