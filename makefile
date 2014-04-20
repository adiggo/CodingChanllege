all:JumpGame.class JumpGameTest.class
JumpGame.class: JumpGame.java
	javac JumpGame.java
JumpGameTest.class: JumpGameTest.java
	javac JumpGameTest.java
clean:
	rm *.class
