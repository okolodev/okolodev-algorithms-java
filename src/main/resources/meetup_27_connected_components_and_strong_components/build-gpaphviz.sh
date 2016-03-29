#!/bin/bash

rm *.{png,svg}

for gvfile in *.gv
do
  basename="${gvfile%.gv}"
  dot -Tpng $gvfile -o $basename.png
  dot -Tsvg $gvfile -o $basename.svg
done
