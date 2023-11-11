<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Get file names from the form
    $firstFileName = $_POST["firstFile"];
    $secondFileName = $_POST["secondFile"];

    // Check if the files exist
    if (file_exists($firstFileName) && file_exists($secondFileName)) {
        // Read content from the first file
        $contentFirstFile = file_get_contents($firstFileName);

        // Append content to the second file
        file_put_contents($secondFileName, $contentFirstFile, FILE_APPEND);

        echo "Content from '$firstFileName' has been appended to '$secondFileName'.";
    } else {
        echo "One or both of the files do not exist.";
    }
}
?>
