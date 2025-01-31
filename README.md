# ✨ Pokemon TCG API

Bienvenue dans **Pokemon TCG API**, une API permettant de gérer des dresseurs, leurs cartes Pokemon, les combats et l'authentification via token. Ce projet est développé en **Spring Boot** avec **MySQL** pour la base de données.

---

## 🔧 Installation

### 1. Prérequis

- **Java 17+**
- **Maven**
- **MySQL** (ou PostgreSQL)
- **Postman** (pour tester l'API)

### 2. Configuration

#### 🔧 Modifier `application.properties`

Dans `src/main/resources/application.properties`, configure ta base de données :



Adapte ces valeurs à ta configuration MySQL/PostgreSQL.

### 3. Exécution

Lancer l'application avec Maven :

```sh
mvn spring-boot:run
```

L'API sera disponible à `http://localhost:8080/`

---

## 🌐 Endpoints de l'API





**Ajoute le token dans l'en-tête de chaque requête protégée :**

```
Authorization: Bearer eyJhbGciOiJIUzI1NiIsIn...
```

---

### 👨‍🎓 1. Gestion des Dresseurs

| Méthode  | Endpoint                | Description             |
| -------- | ----------------------- | ----------------------- |
| `GET`    | `/api/dresseurs`        | Voir tous les dresseurs |
| `POST`   | `/api/dresseurs`        | Ajouter un dresseur     |
| `DELETE` | `/api/dresseurs/{uuid}` | Supprimer un dresseur   |

#### 💡 Exemple : Ajouter un dresseur

```json
POST http://localhost:8080/api/dresseurs
{
    "nom": "Sacha",
    "prenom": "Ketchum"
}
```

---

### 💎 2. Gestion des Cartes Pokemon

| Méthode | Endpoint                        | Description                     |
| ------- | ------------------------------- | ------------------------------- |
| `GET`   | `/api/cartes?dresseurId={uuid}` | Voir les cartes d'un dresseur   |
| `POST`  | `/api/cartes/ajouter`           | Ajouter une carte à un dresseur |

#### 💡 Exemple : Ajouter une carte

```json
POST http://localhost:8080/api/cartes/ajouter
{
    "dresseurId": "78086ece-65b4-4b63-ba65-bacfa005b496",
    "pokemonId": "6032fac9-0cb3-470b-8af9-503917d9bf76"
}
```

---

### ⚔️ 3. Combats entre Dresseurs

| Méthode | Endpoint      | Description                           |
| ------- | ------------- | ------------------------------------- |
| `POST`  | `/api/combat` | Lancer un combat entre deux dresseurs |

#### 💡 Exemple : Lancer un combat

```
POST http://localhost:8080/api/combat
```

**Params :**

```json
{
    "dresseur1Id": "78086ece-65b4-4b63-ba65-bacfa005b496",
    "dresseur2Id": "d4b0d260-03cc-4063-b3af-79d06ec98fbd"
}
```


## 🚀 Auteur

Projet développé par **Djibril & loane **. 🌟

