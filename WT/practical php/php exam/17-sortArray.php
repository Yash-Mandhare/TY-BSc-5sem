<!-- Write a PHP script to sort the following associative array :
array(“Sagar"=>"31","Vicky"=>"41","Leena"=>"39","Ramesh"=>"40") in
a) ascending order sort by Value
b) ascending order sort by Key
c) descending order sorting by Value
d) descending order sorting by Key -->

<?php
$originalArray = array(
    "Sagar" => "31",
    "Vicky" => "41",
    "Leena" => "39",
    "Ramesh" => "40"
);

$sortedArray = $originalArray; // Create a copy for sorting

if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['sort_option'])) {
    $sortOption = $_POST['sort_option'];

    switch ($sortOption) {
        case 'value_asc':
            asort($sortedArray);
            break;
        case 'key_asc':
            ksort($sortedArray);
            break;
        case 'value_desc':
            arsort($sortedArray);
            break;
        case 'key_desc':
            krsort($sortedArray);
            break;
        default:
            // Default to no sorting
            break;
    }
}
?>

<form method="post">
    <input type="radio" name="sort_option" value="value_asc"> Ascending Order by Value<br>
    <input type="radio" name="sort_option" value="key_asc"> Ascending Order by Key<br>
    <input type="radio" name="sort_option" value="value_desc"> Descending Order by Value<br>
    <input type="radio" name="sort_option" value="key_desc"> Descending Order by Key<br>
    <input type="submit" value="Sort">
</form>

<h2>Original Array</h2>
<?php
echo "<pre>";
print_r($originalArray);
echo "</pre>";
?>

<h2>Sorted Array</h2>
<?php
if (!empty($sortedArray)) {
    echo "<pre>";
    print_r($sortedArray);
    echo "</pre>";
}
?>
