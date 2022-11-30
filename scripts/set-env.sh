#!/bin/bash

#set -x
kubectl create serviceaccount api-service-account
kubectl apply  -f ../rbac-cluster-role.yaml
kubectl create clusterrolebinding service-pod-reader-default --clusterrole=microservices-kubernetes-namespace-reader --serviceaccount=default:api-service-account
kubectl apply -f ../k8s/redis/redis-configmap.yml
kubectl apply -f ../k8s/redis/redis-secret.yml

kubectl apply -f ../k8s/customer/customer-configmap.yml
kubectl apply -f ../k8s/customer/customer-secret.yml
kubectl apply -f ../k8s/customer/customer-deployment.yml
kubectl apply -f ../k8s/customer/customer-service.yml

kubectl apply -f ../k8s/operation/operation-configmap.yml
kubectl apply -f ../k8s/operation/operation-secret.yml
kubectl apply -f ../k8s/operation/operation-deployment.yml
kubectl apply -f ../k8s/operation/operation-service.yml

kubectl apply -f ../k8s/payment/payment-configmap.yml
kubectl apply -f ../k8s/payment/payment-secret.yml
kubectl apply -f ../k8s/payment/payment-deployment.yml
kubectl apply -f ../k8s/payment/payment-service.yml

kubectl apply -f ../k8s/search/search-configmap.yml
kubectl apply -f ../k8s/search/search-secret.yml
kubectl apply -f ../k8s/search/search-deployment.yml
kubectl apply -f ../k8s/search/search-service.yml

kubectl apply -f ../k8s/view/view-configmap.yml
kubectl apply -f ../k8s/view/view-secret.yml
kubectl apply -f ../k8s/view/view-deployment.yml
kubectl apply -f ../k8s/view/view-service.yml

kubectl apply -f ../k8s/gateway/gateway-configmap.yml
kubectl apply -f ../k8s/gateway/gateway-deployment.yml
kubectl apply -f ../k8s/gateway/gateway-service.yml