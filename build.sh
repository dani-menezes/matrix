#!/bin/bash
mvn clean package
sleep 2
docker build -t leapmindteam/matrix .
sleep 2
