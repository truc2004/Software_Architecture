const express = require('express');
const { Pool } = require('pg');

const app = express();
const port = 5001;

const pool = new Pool({
  user: 'postgres',
  host: 'postgres',
  database: 'votes',
  password: 'postgres',
  port: 5432
});

app.get('/', async (req, res) => {
  const result = await pool.query('SELECT choice, COUNT(*) FROM votes GROUP BY choice');
  res.json(result.rows);
});

app.listen(port, () => console.log(`Result service on port ${port}`));