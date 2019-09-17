```
$ mvn clean install
$ cd trigger-engine-core
$ mvn spring-boot:run -Dspring-boot.run.profiles=local -s settings.xml
$ mvn spring-boot:run -Dspring-boot.run.profiles=local -s settings.xml # we need to run it twice for issue to occur
```