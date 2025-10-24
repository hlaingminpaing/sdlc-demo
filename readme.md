Perfect 👍 — here’s a **complete and beginner-friendly `README.md`** for your `sdlc-demo` repo that explains **how to deploy and run Node.js, PHP, and Java (Spring Boot)** locally on **Ubuntu 24.04** without Docker.

You can copy this directly to the root of your repo (`README.md`).

---

# 🧩 SDLC Demo — Node.js + PHP + Java (Spring Boot) with MySQL

This repository contains **three small web apps** — Node.js, PHP, and Java — each connected to its own MySQL database.
You can run and test all of them locally on **Ubuntu 24.04**.

---

## 🏗️ Project Structure

```
sdlc-demo/
│
├── node-app/
│   ├── app.js
│   ├── package.json
│   └── .env
│
├── php-app/
│   ├── index.php
│   └── config.php
│
├── java-app/
│   ├── pom.xml
│   └── src/main/java/com/example/demo/DemoApplication.java
│
└── README.md
```

---

## ⚙️ 1. Prerequisites

Make sure the following are installed:

```bash
sudo apt update
sudo apt install -y nodejs npm php php-mysqli openjdk-17-jdk maven mysql-server
```

Verify:

```bash
node -v
npm -v
php -v
java -version
mvn -v
mysql --version
```

---

## 🗄️ 2. MySQL Setup

1. Start MySQL:

   ```bash
   sudo systemctl enable mysql
   sudo systemctl start mysql
   ```

2. Login:

   ```bash
   sudo mysql -u root -p
   ```

3. Create databases and users for each app:

   ```sql
   CREATE DATABASE node_db;
   CREATE DATABASE php_db;
   CREATE DATABASE java_db;

   CREATE USER 'node_user'@'localhost' IDENTIFIED BY 'NodePass123!';
   CREATE USER 'php_user'@'localhost' IDENTIFIED BY 'PhpPass123!';
   CREATE USER 'java_user'@'localhost' IDENTIFIED BY 'JavaPass123!';

   GRANT ALL PRIVILEGES ON node_db.* TO 'node_user'@'localhost';
   GRANT ALL PRIVILEGES ON php_db.* TO 'php_user'@'localhost';
   GRANT ALL PRIVILEGES ON java_db.* TO 'java_user'@'localhost';
   FLUSH PRIVILEGES;
   EXIT;
   ```

---

## 🟢 3. Node.js App

### 📍Location

`node-app/app.js`

### 📄 .env

Create `node-app/.env`:

```env
DB_HOST=localhost
DB_USER=node_user
DB_PASS=NodePass123!
DB_NAME=node_db
PORT=3000
```

### ▶️ Run

```bash
cd node-app
npm install
npm start
```

Open browser → [http://localhost:3000](http://localhost:3000)

Check DB connection → [http://localhost:3000/db](http://localhost:3000/db)

---

## 🔵 4. PHP App

### 📍Location

`php-app/index.php`

### 📄 config.php

Create `php-app/config.php`:

```php
<?php
return [
  'DB_HOST' => 'localhost',
  'DB_USER' => 'php_user',
  'DB_PASS' => 'PhpPass123!',
  'DB_NAME' => 'php_db'
];
```

### ▶️ Run (built-in PHP server)

```bash
cd php-app
php -S localhost:8081
```

Open browser → [http://localhost:8081](http://localhost:8081)

---

## 🟣 5. Java App (Spring Boot)

### 📍Location

`java-app/src/main/java/com/example/demo/DemoApplication.java`

### 📄 `application.properties`

Create `java-app/src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/java_db
spring.datasource.username=java_user
spring.datasource.password=JavaPass123!
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

server.port=8082
```

### ▶️ Build and Run

```bash
cd java-app
mvn clean package -DskipTests
java -jar target/*.jar
```

Open browser → [http://localhost:8082](http://localhost:8082)

---

## 🌐 6. App Summary

| App     | Language             | Port | DB Name | User      |
| ------- | -------------------- | ---- | ------- | --------- |
| Node.js | Node 20              | 3000 | node_db | node_user |
| PHP     | PHP 8                | 8081 | php_db  | php_user  |
| Java    | Spring Boot (JDK 17) | 8082 | java_db | java_user |

---

## 🧹 7. Troubleshooting

| Problem                    | Solution                                                               |
| -------------------------- | ---------------------------------------------------------------------- |
| `ER_ACCESS_DENIED_ERROR`   | Check MySQL user/password match `.env` or `config.php`.                |
| Port already in use        | Change `PORT` or `server.port` value.                                  |
| Java build fails           | Verify `pom.xml` starts with `<project>` and you have Maven installed. |
| Node app can’t find mysql2 | Run `npm install mysql2`.                                              |

---

## 💡 Optional: Run All at Once

Open **three terminals**:

```bash
# Terminal 1
cd node-app && npm start

# Terminal 2
cd php-app && php -S localhost:8081

# Terminal 3
cd java-app && java -jar target/*.jar
```

Then test all:

* Node.js → [http://localhost:3000](http://localhost:3000)
* PHP → [http://localhost:8081](http://localhost:8081)
* Java → [http://localhost:8082](http://localhost:8082)

---

## 🧾 License

Free to use for learning and POC purposes.
Author: *Hlaing Min Paing*

---

Would you like me to also generate a matching **`docker-compose.yml`** + short section at the bottom of this README so you can run all 3 apps + MySQL together with one command (`docker compose up`)?

