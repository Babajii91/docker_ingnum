# TP2  PhpService – Microservice PHP et Java avec Docker

---

## Captures d’écran du microservice

---

### 1. Test du service PHP dans le navigateur
Affichage de la réponse à `http://localhost:8081`.

![Test du service PHP](../images/Php_service.png)

---

### 2. Test du service PHP pour la route adresse dans le navigateur
Affichage de la réponse à `http://localhost:8081/customers/Johary/adress`.

![Test du service PHP pour la route adresse](../images/Php_service_customer_adresse.png)

---

### 3. Test du service Java dans le navigateur
Affichage de la réponse à `http://localhost:8080`.

![Test du service Java](../images/RentalService.png)

---

### 4. Test du service Java pour la route Bonjour dans le navigateur
Affichage de la réponse à `http://localhost:8080/bonjour`.

![Test du service Java pour la route Bonjour](../images/RentalService_Bonjour.png)

---

### 5. Test du service Java pour la route adresse dans le navigateur
Affichage de la réponse à `http://localhost:8080/customer/Johary`.

![Test du service Java pour l'adresse](../images/RentalService_adresse.png)

---

# TP3 Déploiement d’un microservice PHP dans Kubernetes (Minikube)

# Partie 1 : Créer un déploiement Kubernetes à partir d'une image Docker

# Après installation de minikube lancer minikube

```bash
minikube start
```

# Vérification des pods

```bash
kubectl get pods

```
![Vérification des pods](../images/kubernetes_get_pods.png)


# Description du pods

```bash
kubectl describe pods
```

![Description du pods](../images/kubernetes_describe_pods.png)


# Entrer dans le conteneur

```bash
kubectl exec -it phpservice-xxxxx -- /bin/bash
ls
exit
```
![Entrer dans le conteneur](../images/kubernetes_exec.png)


# Exposition du service

```bash
kubectl expose deployment phpservice --type=NodePort --port=80
```
![Exposition du service](../images/kubernetes_deploiement.png)


# Exposition du service

```bash
minikube service phpservice --url
```
![Exposition du service](../images/kubernetes_url.png)


# TEST du service

```bash
http://127.0.0.1:xxxxx
```

```bash
http://127.0.0.1:xxxxx/customers/Johary/address
```
![TEST du service Php](../images/kubernetes_url_php.png)

![TEST du service Php adresse](../images/kubernetes_url_php_customer.png)


# Partie 2 : Scaling 

![Scaling](../images/kubernetes_scaling.png)

![Scaling](../images/kubernetes_get_services.png)



# Partie 3 : Création d'un service de type LoadBalancer

# creation du service LoadBalncer

![service LoadBalncer](../images/kubernetes_balancer.png)

# Récupérer l’URL Minikube

```bash
minikube service phpservice --url
```
![l’URL Minikube](../images/kubernetes_url2.png)

![l’URL Minikube](../images/kubernetes_url_adrese_2.png)



# Partie 4 : Rolling Updates

## modification du code dans index.php

```bash
echo "Service PHP opérationnel — VERSION 2";
```

# Rebuild l’image version 2

```bash
docker build -t johary94/phpservice:2 .
```
![Rebuild l’image version 2](../images/kubernetes_img2.png)

# Push sur Docker Hub

```bash
docker push johary94/phpservice:2
```
![Push sur Docker Hub](../images/kubernetes_img2_push.png)

# Rolling update dans Kubernetes

```bash
kubectl set image deployment/phpservice phpservice=johary94/phpservice:2
kubectl rollout status deployment/phpservice
```

![Rolling update](../images/kubernetes_rolling_deploiment.png)

# TEST dans le navigateur 

```bash
minikube service phpservice --url
```
![TEST](../images/kubernetes_phpservice_version2.png)

# Partie 5 : Création un déploiement et un service à l'aide d'un fichier YAML


## création des trois fichiers yml

phpservice-deployment.yml

phpservice-loadbalancing-service.yml

phpservice-service.yml

## Application du déploiement

```bash
kubectl apply -f phpservice-deployment.yml
```

![déploiement service](../images/kubernetes_apply.png)


### vérification :

```bash
kubectl get deployments
```

```bash
kubectl get pods
```
![vérification](../images/kubernetes_verification.png)


## Application du service NodePort

```bash
kubectl apply -f phpservice-service.yml
```

![service NodePort](../images/kubernetes_nodeport.png)


## Application du LoadBalancer

```bash
kubectl apply -f phpservice-loadbalancing-service.yml
```

![LoadBalancer](../images/kubernetes_load.png)


# TEST dans le navigateur 

![TEST](../images/test.png)


![TEST](../images/test2.png)


![TEST](../images/test3.png)


Mon GITHUB : https://github.com/Babajii91/docker_ingnum