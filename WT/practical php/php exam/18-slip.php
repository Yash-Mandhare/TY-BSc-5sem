<?php
// Sample associative array
$associativeArray = array(
    "1" => "red",
    "2" => "yellow",
    "3" => "orange",
    "4" => "purple"
);

function reverseKeyValue($array) {
    $reversedArray = array();
    foreach ($array as $key => $value) {
        $reversedArray[$value] = $key;
    }
    return $reversedArray;
}

function traverseRandomOrder($array) {
    $keys = array_keys($array);
    shuffle($keys);
    $randomArray = array();
    foreach ($keys as $key) {
        $randomArray[$key] = $array[$key];
    }
    return $randomArray;
}

function convertToVariables($array) {
    foreach ($array as $key => $value) {
        ${$key} = $value;
    }
}

function displayWithKey($array) {
    foreach ($array as $key => $value) {
        echo "Key: $key, Value: $value <br>";
    }
}

if (isset($_POST['submit'])) {
    $operation = $_POST['operation'];
    switch ($operation) {
        case 'reverse':
            $result = reverseKeyValue($associativeArray);
            break;
        case 'traverse':
            $result = traverseRandomOrder($associativeArray);
            break;
        case 'convert':
            convertToVariables($associativeArray);
            $result = "Array elements converted to variables";
            break;
        case 'display':
            $result = displayWithKey($associativeArray);
            break;
        default:
            $result = "Please select an operation.";
            break;
    }
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Array Operations</title>
</head>
<body>
    <h2>Associative Array Operations</h2>
    <form method="post">
        <input type="radio" name="operation" value="reverse"> Reverse Key-Value Pairs<br>
        <input type="radio" name="operation" value="traverse"> Traverse in Random Order<br>
        <input type="radio" name="operation" value="convert"> Convert to Variables<br>
        <input type="radio" name="operation" value="display"> Display with Key<br>
        <br>
        <input type="submit" name="submit" value="Perform Operation">
    </form>
    <br>
    <?php
    if (isset($result)) {
        if (is_array($result)) {
            echo "Result: <pre>" . print_r($result, true) . "</pre>";
        } else {
            echo "Result: " . $result;
        }
    }
    ?>
</body>
</html>
