const express = require("express");
const mysql = require("mysql2");

const app = express();

let db;

// Hàm connect có retry
function connectWithRetry() {
  db = mysql.createConnection({
    host: process.env.DB_HOST || "localhost",
    user: process.env.DB_USER || "user",
    password: process.env.DB_PASSWORD || "password",
    database: process.env.DB_NAME || "testdb",
  });

  db.connect((err) => {
    if (err) {
      console.log("❌ DB chưa sẵn sàng, retry sau 5s...", err.code);
      setTimeout(connectWithRetry, 5000);
    } else {
      console.log("✅ Đã kết nối MySQL");
    }
  });
}

connectWithRetry();

// API test
app.get("/", (req, res) => {
  if (!db) return res.send("DB chưa kết nối");

  db.query("SELECT NOW() as time", (err, result) => {
    if (err) return res.send(err);
    res.send(result);
  });
});

app.listen(3000, () => {
  console.log("🚀 Server chạy tại port 3000");
});