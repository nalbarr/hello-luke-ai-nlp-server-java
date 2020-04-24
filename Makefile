run:
	./mvnw -DskipTests spring-boot:run

deploy:
	./mvnw -DskipTests package appengine:deploy
