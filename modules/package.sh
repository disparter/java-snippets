mkdir -p ./modules/out
cd modules
for dir in ./src/*/
do
  module=$(echo "$dir" | cut -c 7-)
  cmd="jar --create --file=out/${module%?}@1.0.jar --main-class=${module%?}.Main --module-version=1.0 -C mods/$module ."
  echo $cmd
  $cmd
done
