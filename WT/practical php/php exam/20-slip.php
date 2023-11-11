<!DOCTYPE html>
<html>
<head>
    <title>Associative Array Operations</title>
</head>
<body>
    <h1>Associative Array Operations</h1>
    <form method="post">
        <p>
            <input type="radio" name="operation" value="split" /> Split the array into chunks
            <input type="radio" name="operation" value="sort" /> Sort the array by values
            <input type="radio" name="operation" value="filter" /> Filter even elements
        </p>
        <p>
            <input type="submit" value="Submit" />
        </p>
    </form>

    <?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $assocArray = [
            "a" => 5,
            "b" => 2,
            "c" => 8,
            "d" => 3,
            "e" => 10
        ];

        $operation = $_POST["operation"];

        if ($operation === "split") {
            // Split the array into chunks
            $chunkedArray = array_chunk($assocArray, 2);
            echo "<h2>Chunked Array:</h2>";
            print_r($chunkedArray);
        } elseif ($operation === "sort") {
            // Sort the array by values without changing keys
            asort($assocArray);
            echo "<h2>Sorted Array by Values:</h2>";
            print_r($assocArray);
        } elseif ($operation === "filter") {
            // Filter even elements from the array
            $filteredArray = array_filter($assocArray, function ($value) {
                return $value % 2 == 0;
            });
            echo "<h2>Even Elements:</h2>";
            print_r($filteredArray);
        }
    }
    ?>

</body>
</html>
