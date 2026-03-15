FROM golang:1.21-alpine

WORKDIR /app

COPY main.go .

RUN go mod init app
RUN go build -o app

EXPOSE 8080

CMD ["./app"]