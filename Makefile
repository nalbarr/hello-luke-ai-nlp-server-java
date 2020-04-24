compile:
	./mvnw compile

run:
	cp en-token.bin src/main/resources
	./mvnw -DskipTests spring-boot:run

deploy:
	cp en-token.bin src/main/resources
	./mvnw -DskipTests package appengine:deploy
