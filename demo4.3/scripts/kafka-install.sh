docker-compose -f kafka.yaml build --no-cache
docker-compose -f kafka.yaml up -d
docker ps -a