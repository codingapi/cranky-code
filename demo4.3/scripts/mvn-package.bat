<# :
@powershell "icm ([scriptblock]::Create((gc '%~f0' -Raw -Encoding UTF8)))"
exit
#>


cd ../
mvn clean package -DskipTests
cp ./oa/target/*.jar ./scripts/oa.jar
cp ./fs/target/*.jar ./scripts/fs.jar