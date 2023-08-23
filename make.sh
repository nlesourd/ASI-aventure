javac -classpath ./classes -sourcepath src -d ./classes $(find src -name *.java)




javac -sourcepath ./srctest:./src -classpath ./classes:./classestest:/usr/share/java/junit4.jar:/usr/share/java/hamcrest-library.jar -d ./classestest $(find srctest -name *.java)

