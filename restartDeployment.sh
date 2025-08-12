#!/bin/bash -xe

#kubectl delete  the old deployment
kubectl delete deployment icecap-api --ignore-not-found
kubectl delete  service icecap-api-service --ignore-not-found
#kubectl build  the old deployment
kubectl apply -f deployment.yml
kubectl apply -f services.yml
#check new pods
kubectl get pods