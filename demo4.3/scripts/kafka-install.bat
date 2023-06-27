<# :
@powershell "icm ([scriptblock]::Create((gc '%~f0' -Raw -Encoding UTF8)))"
exit
#>

docker-compose -f kafka.yaml build --no-cache
docker-compose -f kafka.yaml up -d
docker ps -a