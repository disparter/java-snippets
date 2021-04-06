for dir in ./src/*/
do
  module=$(echo "$dir" | cut -c 7-)
  cmd="jar --create --file=${module%?}@1.0.jar --module-version=1.0 -C mods/$module ."
  echo $cmd
  $cmd
done
