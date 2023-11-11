<?php
$host = "localhost";
$port = "5432"; // The default PostgreSQL port
$dbname = "postgres";
$user = "postgres";
$password = "6512";

// Create a connection
$conn = pg_connect("host=$host port=$port dbname=$dbname user=$user password=$password");

if (!$conn) {
    die("Connection failed: " . pg_last_error());
}

// Accept the hospital name from the user
$hospitalName = $_POST['hospitalName'];

// Query to retrieve the doctors visiting the specified hospital
$query = "SELECT d.dname, d.address, d.city, d.area
          FROM Doctor d
          INNER JOIN Visits v ON d.doc_no = v.doc_no
          INNER JOIN Hospital h ON v.hosp_no = h.hosp_no
          WHERE h.hname = $1";

// Prepare the statement
$stmt = pg_prepare($conn, "getDoctorsByHospital", $query);

if (!$stmt) {
    die("Error preparing statement: " . pg_last_error());
}

// Execute the query with the hospital name as a parameter
$result = pg_execute($conn, "getDoctorsByHospital", array($hospitalName));

if (!$result) {
    die("Error executing query: " . pg_last_error());
}

// Display the results in a tabular format
echo '<table border="1">';
echo "<tr><th>Doctor Name</th><th>Address</th><th>City</th><th>Area</th></tr>";
while ($row = pg_fetch_assoc($result)) {
    echo "<tr>";
    echo "<td>" . $row['dname'] . "</td>";
    echo "<td>" . $row['address'] . "</td>";
    echo "<td>" . $row['city'] . "</td>";
    echo "<td>" . $row['area'] . "</td>";
    echo "</tr>";
}
echo "</table>";

// Close the database connection
pg_close($conn);
?>
