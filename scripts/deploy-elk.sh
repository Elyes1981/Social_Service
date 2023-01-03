#!/bin/bash

kubectl create configmap kibana-yml --from-file=../k8s/config/kibana/kibana.yml

kubectl apply -f ../k8s/elk/elasticsearch-deployment.yaml
kubectl apply -f ../k8s/elk/elasticsearch-service.yaml

kubectl apply -f ../k8s/elk/kibana-deployment.yaml
kubectl apply -f ../k8s/elk/kibana-service.yaml