require("dotenv").config();
const express = require("express");
const mysql = require("mysql2");
const app = express();

const PORT = process.env.PORT || 3000;
const DB_HOST = process.env.DB_HOST || "localhost";
const DB_USER = process.env.DB_USER || "node_user";
const DB_PASSWORD = process.env.DB_PASSWORD || "NodePass123!";
const DB_NAME = process.env.DB_NAME || "node_db";

app.get("/", (req, res) => {
  res.send("Hello from Node.js and now you sucessfully connect with mysql database!");
});

app.get("/db", (req, res) => {
  const conn = mysql.createConnection({
    host: DB_HOST,
    user: DB_USER,
    password: DB_PASSWORD,
    database: DB_NAME,
  });

  conn.connect((err) => {
    if (err) res.send("❌ MySQL connection failed: " + err.message);
    else res.send(`✅ Connected to MySQL DB: ${DB_NAME}`);
    conn.end();
  });
});

app.listen(PORT, () => console.log(`🚀 Node app running on port ${PORT}`));

