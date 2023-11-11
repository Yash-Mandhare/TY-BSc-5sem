<!DOCTYPE html>
<html>
<head>
    <title>Search Array</title>
</head>
<body>
    <h1>Search in Array</h1>
    <form method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>">
        <label for="searchValue">Enter a value to search for: </label>
        <input type="text" name="searchValue" id="searchValue">
        <input type="submit" value="Search">
    </form>

    <?php
    // Sample array
    $fruits = array("apple", "banana", "cherry", "date", "elderberry");
    echo "Array :";
    foreach ($fruits as $x) {
        echo " $x ";
    }

    // Check if 'searchValue' exists in the $_POST array
    if (isset($_POST['searchValue'])) {
        // Get the value to search for from the user
        $searchValue = $_POST['searchValue'];

        // Search for the value in the array
        $key = array_search($searchValue, $fruits);

        if ($key !== false) {
            echo "<br>$searchValue found at index $key in the array.";
        } else {
            echo "<br>$searchValue not found in the array.";
        }
    }
    ?>

</body>
</html>
