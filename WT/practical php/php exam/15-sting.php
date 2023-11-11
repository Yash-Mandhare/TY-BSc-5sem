<!DOCTYPE html>
<html>
<head>
    <title>String Operations Result</title>
</head>
<body>
    <h1>String Operations Result</h1>
    <?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        // Get the user input
        $input_string = $_POST["input_string"];
        
        // Get the selected operation
        $selected_operation = $_POST["operation"];
        
        // Perform the selected operation
        switch ($selected_operation) {
            case "first_five_words":
                $words = explode(" ", $input_string);
                $first_five_words = implode(" ", array_slice($words, 0, 5));
                $first_five_characters = substr($input_string, 0, 5);
                echo "<p>First 5 words: $first_five_words</p>";
                echo "<p>First 5 characters: $first_five_characters</p>";
                break;
            case "lowercase":
                $lowercase_string = strtolower($input_string);
                echo "<p>Lowercase: $lowercase_string</p>";
                break;
            case "title_case":
                $title_case_string = ucwords($input_string);
                echo "<p>Title case: $title_case_string</p>";
                break;
            case "pad":
                $padded_string = "*" . $input_string . "*";
                echo "<p>Padded with '*': $padded_string</p>";
                break;
            case "remove_whitespace":
                $trimmed_string = str_replace(" ","",$input_string);
                echo "<p>Leading whitespaces removed: $trimmed_string</p>";
                break;
            case "reverse":
                $reversed_string = strrev($input_string);
                echo "<p>Reversed string: $reversed_string</p>";
                break;
        }
    }
    ?>
</body>
</html>
