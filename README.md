# Spring boot with redis publisher

## 실행환경
1. Java 17
2. spring boot 3.4.4
3. Redis Server 

Produce event to redis 
```
curl --location --request POST 'http://localhost:8080/api/send' \
--header 'Content-Type: application/json' \
--data-raw '{
    "type" : "CHAT",
    "data" : "테스트 입니다."
}'
```
