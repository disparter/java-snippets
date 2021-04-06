for dir in ./src/com.disparter.* 
do
    javac -d $(echo "mods/$dir" | cut -c 3- ) $(find $dir -name "*.java")	
done
