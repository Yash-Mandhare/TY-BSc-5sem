<!DOCTYPE html>
<html>
<head>
    <title>Student Result</title>
</head>
<body>

<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $subject_names = $_POST['subject_name'];
    $marks = $_POST['marks'];
    
    // Calculate total marks and percentage
    $total_marks = array_sum($marks);
    $percentage = ($total_marks / 500) * 100;
    
    // Determine the grade
    if ($percentage >= 90) {
        $grade = 'A+';
    } elseif ($percentage >= 80) {
        $grade = 'A';
    } elseif ($percentage >= 70) {
        $grade = 'B';
    } elseif ($percentage >= 60) {
        $grade = 'C';
    } elseif ($percentage >= 50) {
        $grade = 'D';
    } else {
        $grade = 'F';
    }
    
    // Display the result in a table
    echo '<h2>Student Result</h2>';
    echo '<table border="1">';
    echo '<tr><th>Subject Name</th><th>Marks</th></tr>';
    for ($i = 0; $i < 5; $i++) {
        echo '<tr><td>' . $subject_names[$i] . '</td><td>' . $marks[$i] . '</td></tr>';
    }
    echo '<tr><td>Total</td><td>' . $total_marks . '</td></tr>';
    echo '<tr><td>Percentage</td><td>' . $percentage . '%</td></tr>';
    echo '<tr><td>Grade</td><td>' . $grade . '</td></tr>';
    echo '</table>';
} else {
    // Display the form to enter marks
    echo '<h2>Enter Student Marks</h2>';
    echo '<form method="post" action="' . htmlspecialchars($_SERVER["PHP_SELF"]) . '">';
    for ($i = 0; $i < 5; $i++) {
        echo 'Subject ' . ($i + 1) . ': <input type="text" name="subject_name[]" placeholder="Subject Name"> ';
        echo '<input type="text" name="marks[]" placeholder="Marks out of 100"><br>';
    }
    echo '<input type="submit" value="Submit">';
    echo '</form>';
}
?>

</body>
</html>
