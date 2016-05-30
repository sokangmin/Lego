# ! /bin/sh

LCP=../lib
for file in `find ../lib -name "*.jar"`;do
	LCP=$LCP:$file
done

nohup /usr/bin/java -cp ../bin:../conf:$LCP DaeguConnMain 1> /dev/null 2>&1 & 
#nohup /usr/bin/java -cp ../bin:../conf:$LCP DaeguConnMain &
sleep 1
grepRestart=`ps -ef | grep restart_conn.sh | grep -v 'grep' | awk '{print$1}'`
if [ -z "$grepRestart" ]; then
        #nohup ./restart_conn.sh &
        nohup ./restart_conn.sh 1> /dev/null 2>&1 &
fi