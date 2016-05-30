#!/bin/sh
# Daegu Conn program restart script. this script is within run_conn.sh
while :
do
        grepConn=`ps -ef | grep DaeguConnMain | grep -v 'grep' | awk '{print$1}'`
        if [ -z "$grepConn" ]; then
                echo "Conn  program isn't working. program is starting now."
                `./run_conn.sh`
        else
                echo "DeaguConn program run already."
        fi
        sleep 10
done