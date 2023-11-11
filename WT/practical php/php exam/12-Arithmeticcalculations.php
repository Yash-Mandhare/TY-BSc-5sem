<!DOCTYPE html>
<html>
<head>
    <title>Arithmetic Calculator</title>
</head>
<body>
    <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
        <label for="num1">Enter the first number:</label>
        <input type="number" name="num1" required><br>

        <label for="num2">Enter the second number:</label>
        <input type="number" name="num2" required><br>

        <label>Choose an operation:</label>
        <input type="radio" name="operation" value="add" checked> Addition
        <input type="radio" name="operation" value="subtract"> Subtraction
        <input type="radio" name="operation" value="multiply"> Multiplication
        <input type="radio" name="operation" value="divide"> Division

        <input type="submit" value="Calculate">
    </form>

    <?php
    function calculate($num1, $num2, $operation = 'add') {
        switch ($operation) {
            case 'add':
                return $num1 + $num2;
            case 'subtract':
                return $num1 - $num2;
            case 'multiply':
                return $num1 * $num2;
            case 'divide':
                if ($num2 == 0) {
                    return "Division by zero is not allowed.";
                }
                return $num1 / $num2;
            default:
                return "Invalid operation";
        }
    }

    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $num1 = isset($_POST["num1"]) ? $_POST["num1"] : 0;
        $num2 = isset($_POST["num2"]) ? $_POST["num2"] : 0;
        $operation = isset($_POST["operation"]) ? $_POST["operation"] : 'add';

        $result = calculate($num1, $num2, $operation);

        echo "<h2>Result:</h2>";
        echo "The result is: " . $result;
    }
    ?>
</body>
</html>
