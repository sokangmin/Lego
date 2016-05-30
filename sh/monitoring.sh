#!/bin/sh
grepMain=`jps | grep DaeguConnMain | wc | awk '{print$1}'`
grepCivil=`jps | grep DaeguCivilMain | wc | awk '{print$1}'`
#echo $grepMain
if [ $grepMain -ge 1 ]
#result more than 1
then
        echo "daegu conn program is running."
        jps | grep DaeguConnMain
else
        echo "daegu conn program isn't working."
fi
if [ $grepCivil -ge 1 ]
#result more than 1
then
        echo "daegu civil program is running."
        jps | grep DaeguCivilMain
else
        echo "daegu civil program isn't working."
fi
