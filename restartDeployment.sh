#!/bin/bash -xe

#kubectl delete  the old deployment
kubectl delete deployment icecap-api --ignore-not-found
kubectl delete  service icecap-api-service --ignore-not-found
kubectl delete service mysql-service --ignore-not-found
kubectl delete deployment mysql --ignore-not-found
kubectl delete volume mysql-pv-volume --ignore-not-found

#kubectl build  the old deployment
kubectl apply -f deployment.yml
kubectl apply -f services.yml
kubectl apply -f mysql-deployment.yml
kubectl apply -f mysql-service.yml
kubectl apply -f mysql-volume.yml
#check new pods
kubectl get pods