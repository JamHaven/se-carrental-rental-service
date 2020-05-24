# Car Rental Rental Microservice

Car Rental microservice project for Service Engineering

## Build and Run 

1. `mvn package`
2. `docker build -t se-carrental/rental-service .`
3. `docker tag se-carrental/rental-service rabbitcarrental.azurecr.io/se-carrental/rental-service:latest`
4. `docker login rabbitcarrental.azurecr.io`
5. `docker push rabbitcarrental.azurecr.io/se-carrental/rental-service:latest`
6. `docker logout rabbitcarrental.azurecr.io`
7. `docker run -p 5555:5555 se-carrental/rental-service`

