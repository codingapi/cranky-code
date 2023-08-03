kubectl apply -f server-deployment.yaml
kubectl apply -f server-sevice.yaml

kubectl apply -f monitor-deployment.yaml
kubectl apply -f monitor-sevice.yaml

kubectl get pods,services
