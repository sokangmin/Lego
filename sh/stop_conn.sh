# ! /bin/sh
grepMain=`jps | grep DaeguConnMain | wc | awk '{print$1}'`
#echo $grepMain
if [ $grepMain -ge 1 ]
then
	echo "DaeguConn program stop now."
	ps -eaf | grep DaeguConnMain | grep -v grep | awk '{print "kill -TERM "$2}' | sh -x
	ps -eaf | grep restart_conn.sh | grep -v grep | awk '{print "kill -TERM "$2}' | sh -x
else
	echo "DaeguConn program isn't working yet."
fi