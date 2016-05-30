#!/bin/sh
grepMain=`jps | grep DaeguConnMain | wc | awk '{print$1}'`
grepCivil=`jps | grep DaeguCivilMain | wc | awk '{print$1}'`
#echo $grepMain
if [ $grepMain -ge 1 ]
#result more than 1
then
        echo "daegu conn program was started."
        jps | grep DaeguConnMain
else
        echo "daegu conn program is starting now."
        ./run_conn.sh
fi
if [ $grepCivil -ge 1 ]
#result more than 1
then
        echo "daegu civil program was started."
        jps | grep DaeguCivilMain
else
        echo "daegu civil program is starting now."
        ./run_civil.sh
fi