# ! /bin/sh
grepMain=`jps | grep DaeguCivilMain | wc | awk '{print$1}'`
#echo $grepMain
if [ $grepMain -ge 1 ]
then
	echo "DaeguCivil program stop now."
	ps -eaf | grep DaeguCivilMain | grep -v grep | awk '{print "kill -TERM "$2}' | sh -x
	ps -eaf | grep restart_civil.sh | grep -v grep | awk '{print "kill -TERM "$2}' | sh -x
else
	echo "DaeguCivil program isn't working yet."
fi