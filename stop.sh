#!/bin/bash
docker stop $(docker ps -aqf "name=matrix")
sleep 2
docker rm  $(docker ps -aqf "name=matrix")