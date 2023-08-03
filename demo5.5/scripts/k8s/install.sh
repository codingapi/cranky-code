kubectl apply -f server-deployment.yaml
kubectl apply -f server-service.yaml

kubectl apply -f monitor-deployment.yaml
kubectl apply -f monitor-service.yaml

kubectl get pods,services
