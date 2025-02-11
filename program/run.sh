export CLASSPATH=$CLASSPATH:./core.jar
if ( javac *.java ); then
    java App
fi
