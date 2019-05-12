#!/bin/bash
./stop.sh
sleep 2
docker run -p 11080:8080 --name=matrix -d leapmindteam/matrix
sleep 4
docker logs -f $(docker ps -aqf "name=matrix")