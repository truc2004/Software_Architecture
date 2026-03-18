const express = require("express");
const mysql = require("mysql2");

const app = express();

function connectDB() {
  const db = mysql.createConnection({
    host: "db", // QUAN TRỌNG
    user: "user",
    password: "pass",
    database: "mydb"
  });

  db.connect(err => {
    if (err) {
      console.log("DB chưa sẵn sàng, retry...");
      setTimeout(connectDB, 3000);
    } else {
      console.log("Kết nối MySQL thành công!");
    }
  });

  return db;
}

const db = connectDB();

app.get("/", (req, res) => {
  db.query("SELECT 1", (err, result) => {
    if (err) return res.send(err);
    res.send("OK " + JSON.stringify(result));
  });
});

app.listen(3000, () => {
  console.log("Server chạy tại http://localhost:3000");
});