# a million commits
git config --global user.email "mihailovkonstantin364@gmail.com"

for Y in {2019..2019}
do
  mkdir $Y
  cd $Y
  for M in {01..01}
  do
    mkdir $M
    cd $M
    for D in {17..23}
    do
      mkdir $D
      cd $D
      for i in {01..01}
      do
        echo "$i on $M/$D/$Y" > commit.md
        export GIT_COMMITTER_DATE="$Y-$M-$D 08:$i:00"
        export GIT_AUTHOR_DATE="$Y-$M-$D 08:$i:00"
        git add commit.md -f
        git commit --date="$Y-$M-$D 08:0$i:00" -m "$i on $M $D $Y"
      done
      cd ../
    done
    cd ../
  done
  cd ../
done


for Y in {2019..2019}
do
  mkdir $Y
  cd $Y
  for M in {02..02}
  do
    mkdir $M
    cd $M
    for D in {10..28}
    do
      mkdir $D
      cd $D
      for i in {01..12}
      do
        echo "$i on $M/$D/$Y" > commit.md
        export GIT_COMMITTER_DATE="$Y-$M-$D 08:$i:00"
        export GIT_AUTHOR_DATE="$Y-$M-$D 08:$i:00"
        git add commit.md -f
        git commit --date="$Y-$M-$D 08:0$i:00" -m "$i on $M $D $Y"
      done
      cd ../
    done
    cd ../
  done
  cd ../
done

git rm -rf 20**
git commit -am "cleanup"
git push origin master
