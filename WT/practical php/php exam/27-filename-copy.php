<?php
if ($_SERVER["REQUEST_METHOD"] === "POST") {
    // Get the source and destination file names from the form
    $sourceFileName = $_POST["sourceFile"];
    $destinationFileName = $_POST["destinationFile"];

    // Check if the source file exists
    if (file_exists($sourceFileName)) {
        // Read the content of the source file
        $fileContent = file_get_contents($sourceFileName);

        // Write the content to the destination file
        file_put_contents($destinationFileName, $fileContent);

        echo "File copied successfully.\n";
    } else {
        echo "Source file does not exist.\n";
    }
}
?>
