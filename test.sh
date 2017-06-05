pwd
path=`pwd`
cd ..
SERVICE_DIR=$path
SERVICE_NAME=$path
mvn clean
mvn package 
JAR_NAME=$path/target/*.jar

TEMP_PID=`lsof -i:8088|grep java|awk '{print $2}'`
      if [ "$TEMP_PID" == "" ]; then  echo "#### $SERVICE_NAME process not exists or stop success"
      else echo "#### $SERVICE_NAME process pid is:$TEMP_PID" kill -9 $TEMP_PID
      fi
      ;;
java -jar $JAR_NAME     
#!/bin/sh
## java env
export JAVA_HOME=/usr/lib/jdk8/jdk1.8.0_111
export JRE_HOME=$JAVA_HOME/jre
export JENKINS_HOME=/jenkins/conf
## exec shell name
EXEC_SHELL_NAME=jenkins/.sh
## service name
SERVICE_NAME=jenkins
JAR_NAME=$SERVICE_NAME/.war
PID=pid/$SERVICE_NAME/.pid
#cd $SERVICE_DIR
case "$1" in
  start)
      nohup java -Xms256m -Xmx1024m -XX:MaxPermSize=512m  -jar $JAR_NAME --ajp13Port=-1 --httpPort=8088 > jenkins.out 2>&1 & echo $! > $SERVICE_DIR/$PID
      echo "#### start $SERVICE_NAME"
      ;;
  stop)
      kill `cat $SERVICE_DIR/$PID`
      rm -rf $SERVICE_DIR/$PID
      echo "#### stop $SERVICE_NAME"
      sleep 8
      TEMP_PID=`ps -ef | grep -w "$SERVICE_NAME" | grep  "java" | awk '{print $2}'`
      if [ "$TEMP_PID" == "" ]; then  echo "#### $SERVICE_NAME process not exists or stop success"
      else echo "#### $SERVICE_NAME process pid is:$TEMP_PID" kill -9 $TEMP_PID
      fi
      ;;
  restart)
      $0 stop
      sleep 2
      $0 start
      echo "#### restart $SERVICE_NAME"
      ;;
esac
exit 0