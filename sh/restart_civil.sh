#!/bin/sh
# Daegu Civil program restart script. this script is within run_civil.sh
while :
do
        grepCivil=`ps -ef | grep DaeguCivilMain | grep -v 'grep' | awk '{print$1}'`
        if [ -z "$grepCivil" ]; then
                echo "Civil  program isn't working. program is starting now."
                `./run_civil.sh`
        else
                echo "DeaguCivil program run already."
        fi
        sleep 10
done