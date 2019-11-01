set title 'Test'
set xlabel 'time'
set ylabel 'volume'
set grid
set xrange [-pi:pi]
set yrange [-1:1]
set style line 1 lc rgb '#0060ad' pt 7 ps 0.5 lt 1 lw 2
f(x) = cos(x)
plot f(x) title 'cos(x)', '/home/ronaldo/Documentos/Plot/cosx.txt' w p ls 1 title 'points'