javac -sourcepath ./src -d build/classes -cp ./libs/commons-lang3-3.12.0.jar ./src/ua/com/alevel/Hi.java
java -cp build/classes/:./libs/commons-lang3-3.12.0.jar ua.com.alevel.Hi