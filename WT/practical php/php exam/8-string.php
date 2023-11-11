<?php
$x = $_POST['s1'];
$y = $_POST['s2'];

$ch = $_POST['r'];

echo "Large string is $x";
echo "<br> Small string is $y<br>";

if ($ch == 1) {
    if (preg_match("/^$y/", $x)) {
        echo "'$x' starts with '$y'";
    } else {
        echo "'$x' does not start with '$y'";
    }
} elseif ($ch == 2) {
    $position = strpos($x, $y);
    if ($position !== false) {
        echo "'$y' found at position: $position";
    } else {
        echo "'$y' not found in '$x'";
    }
} elseif ($ch == 3) {
    // Compare the first n characters of both strings without case sensitivity
    $n = $_POST['n']; // You can change n to the desired number of characters to compare.
    $substringX = substr($x, 0, $n);
    $substringY = substr($y, 0, $n);

    if (strcasecmp($substringX, $substringY) == 0) {
        echo "First $n characters of '$x' and '$y' are equal";
    } else {
        echo "First $n characters of '$x' and small string '$y' are unequal";
    }
}
?>
