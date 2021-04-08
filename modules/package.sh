mkdir -p ./modules/out
version=$(grep version package.json | awk -F \" '{print $4}')
cd modules
for dir in ./src/*/
do
  module=$(echo "$dir" | cut -c 7-)
  cmd="jar --create --file=out/${module%?}@$version.jar --main-class=${module%?}.Main --module-version=$version -C mods/$module ."
  echo $cmd
  $cmd
done
