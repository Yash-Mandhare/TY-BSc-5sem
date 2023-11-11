<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Document</title>
</head>
<body>

 <center>
<table border =2 >
<?php
$fname = "item.dat";
$fp = fopen($fname, 'r');

$sum = 0;

echo "<br><tr><th>item no</th><th>item name</th><th>unit sold</th><th>rate</th><th>total amt</th></tr>";

while (!feof($fp)) {
    $x = explode(" ", fgets($fp));

    if (isset($x[0]) && isset($x[1]) && isset($x[2]) && isset($x[3])) {
        $t = $x[2] * $x[3];
        $sum += $t;
        echo "<tr><td>$x[0]</td><td>$x[1]</td><td>$x[2]</td><td>$x[3]</td><td>$t</td></tr>";
    } else {
        echo "<tr><td colspan='5'>Invalid data in this row</td></tr>";
    }
}

echo "<tr><td>Total amt: $sum</td></tr>";

fclose($fp);
?>

 </table>
</center>
</body>
</html>
