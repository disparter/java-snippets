version=$(grep version package.json | awk -F \" '{print $4}')
cd modules
errors=()
for dir in ./src/*/
do
  module=$(echo "$dir" | cut -c 7-)
  cmd="java -jar out/${module%?}@$version.jar"
  echo $cmd 
  $cmd
  status=$?
  if [ $((status)) != 0 ]; then 
    echo "UNITs FAILED: $status"
    errors+=($status)
  fi
done
if [ ${#errors[@]} != 0 ]; then
  echo MODULES TESTS HAVE FAILED. PLEASE FIX THE PROBLEMS AND TRY AGAIN.
  exit 1
fi
