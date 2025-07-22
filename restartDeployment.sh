#kubectl delete  the old deployment
kubectl delete deployment icecap-api
kubectl delete  service icecap-api-service
#kubectl build  the old deployment
kubectl apply -f deployment.yml
kubectl apply -f services.yml
#check new pods
kubectl get pods