#!/bin/sh
grepMain=`jps | grep DaeguConnMain | wc | awk '{print$1}'`
grepCivil=`jps | grep DaeguCivilMain | wc | awk '{print$1}'`
#echo $grepMain
if [ $grepMain -ge 1 ]
#result more than 1
then
        #echo "daegu conn program stop now."
        ./stop_conn.sh
else
        echo "daegu conn program isn't workingi yet."
fi
if [ $grepCivil -ge 1 ]
#result more than 1
then
        #echo "daegu civil program stop now."
        ./stop_civil.sh
else
        echo "daegu civil program isn't working yet."
fi