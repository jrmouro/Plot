set title 'Test'
set xlabel 'time'
set ylabel 'volume'
set grid
set xrange [0:100]
set yrange [0:20]
f(x) = (3.14159265359 * log((x - exp(1.0))))
plot f(x) title '(3.14159265359 * log((x - exp(1.0))))'
