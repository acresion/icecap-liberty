#kubectl delete  the old deployment
kubectl delete secret icecap-api-secret
kubectl delete deployment icecap-api
kubectl delete  service icecap-api-service
#kubectl build  the old deployment
kubectl apply -f deployment.yml
kubectl apply -f services.yml
source /icecap-saas/gradle.properties 
kubectl create secret generic icecap-api-secret \
    --from-literal=mysql_user=${mysql_user} \
    --from-literal=mysql_password=${mysql_password}
#check new pods
kubectl get pods