export CLASSPATH=$CLASSPATH:./core.jar
if ( javac -d . *.java ); then
    java App
fi
