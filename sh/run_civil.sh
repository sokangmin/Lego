# ! /bin/sh
cd /root/daegu/Daegu_thread/sh
LCP=../lib
for file in `find ../lib -name "*.jar"`;do
        LCP=$LCP:$file
done

nohup /usr/bin/java -cp ../bin:../conf:$LCP DaeguCivilMain 1> /dev/null 2>&1 &
#nohup /usr/bin/java -cp ../bin:../conf:$LCP DaeguCivilMain &
sleep 1
grepRestart=`ps -ef | grep restart_civil.sh | grep -v 'grep' | awk '{print$1}'`
if [ -z "$grepRestart" ]; then
        nohup ./restart_civil.sh 1> /dev/null 2>&1 &
        #nohup ./restart_civil.sh &
fi