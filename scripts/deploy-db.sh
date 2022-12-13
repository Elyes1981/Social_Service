#!/bin/bash

#set -x
kubectl create serviceaccount api-service-account
kubectl apply  -f ../rbac-cluster-role.yaml
kubectl create clusterrolebinding service-pod-reader-default --clusterrole=microservices-kubernetes-namespace-reader --serviceaccount=default:api-service-account

kubectl apply -f ../k8s/postgresK8S/database-operation-sercret.yaml
kubectl apply -f ../k8s/postgresK8S/database-operation-storage.yaml
kubectl apply -f ../k8s/postgresK8S/database-operation-deployment.yaml
kubectl apply -f ../k8s/postgresK8S/database-operation-service.yaml
