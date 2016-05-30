find /root/daegu/Daegu_thread/logs -name "*.log*" -mtime +30 -exec rm {} \;
#crontab -e : 00 01 # # # /root/daegu/Daegu_thread/sh/rm_log.sh
#crontab -l : show save crontab list.