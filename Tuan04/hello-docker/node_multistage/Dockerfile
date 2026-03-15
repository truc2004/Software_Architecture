# Stage 1: Build
FROM node:18 AS builder

WORKDIR /app

COPY package.json .

RUN npm install

COPY app.js .


# Stage 2: Runtime
FROM node:18-alpine

WORKDIR /app

COPY --from=builder /app .

EXPOSE 3000

CMD ["node", "app.js"]