#!/bin/bash

kubectl apply -f ../k8s/ingress/customer-ingress.yml

kubectl apply -f ../k8s/ingress/kibana-ingress.yml
kubectl apply -f ../k8s/ingress/pgadmin-ingress.yml