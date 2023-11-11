<html>
<body>
<form action="<?php echo $_SERVER['PHP_SELF'] ?>" method="POST">
    Enter new item: <input type="text" name="item"><br>
    Enter position of new item: <input type="text" name="pos"><br>
    <input type="submit" name="submit" value="Show">
</form>
</body>
</html>

<?php
$original = array('1', '2', '3', '4', '5');
echo 'Original array : ' . "\n";

foreach ($original as $x) {
    echo "$x ";
}

if (isset($_POST['pos']) && isset($_POST['item'])) {
    $inserted = $_POST['item'];
    $pos = (int)$_POST['pos']; // Convert to integer

    array_splice($original, $pos, 0, $inserted);
    echo "<br> After inserting $inserted the array is: ";

    foreach ($original as $x) {
        echo "$x ";
    }
}
?>
