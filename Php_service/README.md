# PhpService – Microservice PHP avec Docker

---

## Lancer le service en local

### 1. Construire l’image Docker

Se placer dans le dossier `Php_service` (contenant le `Dockerfile`) et exécute la commande suivante :

```bash
docker build -t phpservice .
```

---

### 2. Lancer le conteneur Docker

Démarre le conteneur en exposant le port 80 du conteneur sur le port 8081 de la machine hôte :

```bash
docker run -p 8081:80 phpservice
```

---

### 3. Tester le service

Ouvre un navigateur web et accède à l’URL suivante :

```
http://localhost:8081
```

 Le prénom est affiché en réponse à la requête HTTP GET.

---

##  Publication sur Docker Hub

### 1. Connexion à Docker Hub

```bash
docker login
```

---

### 2. Taguer l’image

Remplace `<ton-username-dockerhub>` par ton identifiant Docker Hub :

```bash
docker tag phpservice <ton-username-dockerhub>/phpservice:latest
```

---

### 3. Publier l’image

```bash
docker push <ton-username-dockerhub>/phpservice:latest
```

---

### 4. Vérification

#### Depuis Docker Hub
Accède à l’image publiée via :
```
https://hub.docker.com/r/<ton-username-dockerhub>/phpservice
```

#### En local
Télécharge et lance l’image depuis Docker Hub :

```bash
docker pull <ton-username-dockerhub>/phpservice:latest
docker run -p 8081:80 <ton-username-dockerhub>/phpservice:latest
```
