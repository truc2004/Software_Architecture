const express = require('express');
const { MongoClient } = require('mongodb');

const app = express();
const port = 3000;

app.use(express.json());

const mongoUrl = 'mongodb://mongo:27017';
const dbName = 'mydb';
let db;

async function connectWithRetry() {
  try {
    const client = await MongoClient.connect(mongoUrl, { useUnifiedTopology: true });
    db = client.db(dbName);
    console.log('Connected to MongoDB');
  } catch (err) {
    console.error('MongoDB connection failed, retrying in 5s...', err);
    setTimeout(connectWithRetry, 5000);
  }
}

connectWithRetry();

app.get('/', (req, res) => {
  res.send('Hello Node.js + MongoDB!');
});

app.post('/add', async (req, res) => {
  const collection = db.collection('items');
  const result = await collection.insertOne(req.body);
  res.send(result);
});

app.get('/items', async (req, res) => {
  const collection = db.collection('items');
  const items = await collection.find({}).toArray();
  res.send(items);
});

app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});