#!/bin/sh
for FILE in *; do 
  touch "$FILE" -d "`git log -1 --date=local "$FILE"|grep Date|awk -FDate: '{print $2}'`"
done
