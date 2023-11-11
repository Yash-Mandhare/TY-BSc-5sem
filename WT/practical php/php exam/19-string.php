<!-- Write a PHP script to accept 2 strings from the user, the first string should be a sentence and
second can be a word.
a. Delete a small part from first string after accepting position and number of characters to
remove.
b. Insert the given small string in the given big string at specified position without removing
any characters from the big string.
c. Replace some characters/ words from given big string with the given small string at
specified position. -->

<!DOCTYPE html>
<html>
<head>
    <title>String Operations</title>
</head>
<body>
    <form method="post" action="">
        <label for="sentence">Enter the first sentence:</label><br>
        <input type="text" id="sentence" name="sentence"><br><br>

        <label for="word">Enter the small word to insert/replace:</label><br>
        <input type="text" id="word" name="word"><br><br>

        <label for="position">Enter the position for insertion/deletion/replacement:</label><br>
        <input type="number" id="position" name="position"><br><br>

        <p>Select operation:</p>
        <input type="radio" id="delete" name="operation" value="delete">
        <label for="delete">Delete</label><br>

        <input type="radio" id="insert" name="operation" value="insert">
        <label for="insert">Insert</label><br>

        <input type="radio" id="replace" name="operation" value="replace">
        <label for="replace">Replace</label><br><br>

        <input type="submit" value="Submit">
    </form>

    <?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $sentence = $_POST["sentence"];
        $word = $_POST["word"];
        $position = $_POST["position"];
        $operation = $_POST["operation"];

        if ($operation === "delete") {
            $result = substr_replace($sentence, '', $position, strlen($word));
        } elseif ($operation === "insert") {
            $result = substr_replace($sentence, $word, $position, 0);
        } elseif ($operation === "replace") {
            $result = substr_replace($sentence, $word, $position, strlen($word));
        }

        echo "Result: $result";
    }
    ?>
</body>
</html>
