<?php
   // $con = pg_connect("host=linux1 user=tybsc102 dbname=tybsc102");
// SELECT current_user;
// SELECT current_database();
// SHOW listen_addresses;

$con = pg_connect("host=localhost user=postgres dbname=postgres password=6512");
    if($con){
        $event = $_REQUEST['event'];

        echo "<br>Original Tables are: ";
        echo "<br>Event table: ";
        $result = pg_query("select * from event");
        echo "<table border = 2 >";
            echo "<tr>";
                echo "<td>ENO</td>";
                echo "<td>TITLE</td>";
                echo "<td>DATE</td>";
            echo "</tr>";
            while ($row = pg_fetch_array($result)) {
                echo "<tr>";
                    echo "<td>".$row['eno']."</td>";
                    echo "<td>".$row['title']."</td>";
                    echo "<td>".$row['date']."</td>";
                echo "</tr>";
            }
        echo "</table>";
        echo "<br>Committee table: ";
        $result = pg_query("select * from committee");
        echo "<table border = 2 >";
            echo "<tr>";
                echo "<td>CNO</td>";
                echo "<td>NAME</td>";
                echo "<td>HEAD</td>";
                echo "<td>FROM_TIME</td>";
                echo "<td>TO_TIME</td>";
                echo "<td>STATUS</td>";
            echo "</tr>";
            while ($row = pg_fetch_array($result)) {
                echo "<tr>";
                    echo "<td>".$row['cno']."</td>"; 
                    echo "<td>".$row['name']."</td>";
                    echo "<td>".$row['head']."</td>";
                    echo "<td>".$row['from_time']."</td>";
                    echo "<td>".$row['to_time']."</td>";
                    echo "<td>".$row['status']."</td>";
                echo "</tr>";
            }
        echo "</table>";

        $ch = $_REQUEST['choice'];

switch ($ch) {
    case "1":
        pg_query("update committee set status='working' where cno in(select cno from event_committee where eno in(select eno from event where title='$event'))");
        break;
    case "2":
        pg_query("update committee set status='non-working' where cno in(select cno from event_committee where eno in(select eno from event where title='$event'))");
        break;
    }
        

        echo "<br>After status changed Tables are: ";
        echo "<br>Event table: ";
        $result = pg_query("select * from event");
        echo "<table border = 2 >";
            echo "<tr>";
                echo "<td>ENO</td>";
                echo "<td>TITLE</td>";
                echo "<td>DATE</td>";
            echo "</tr>";
            while ($row = pg_fetch_array($result)) {
                echo "<tr>";
                    echo "<td>".$row['eno']."</td>";
                    echo "<td>".$row['title']."</td>";
                    echo "<td>".$row['date']."</td>";
                echo "</tr>";
            }
        echo "</table>";
        echo "<br>Committee table: ";
        $result = pg_query("select * from committee");
        echo "<table border = 2 >";
            echo "<tr>";
                echo "<td>CNO</td>";
                echo "<td>NAME</td>";
                echo "<td>HEAD</td>";
                echo "<td>FROM_TIME</td>";
                echo "<td>TO_TIME</td>";
                echo "<td>STATUS</td>";
            echo "</tr>";
            while ($row = pg_fetch_array($result)) {
                echo "<tr>";
                    echo "<td>".$row['cno']."</td>";
                    echo "<td>".$row['name']."</td>";
                    echo "<td>".$row['head']."</td>";
                    echo "<td>".$row['from_time']."</td>";
                    echo "<td>".$row['to_time']."</td>";
                    echo "<td>".$row['status']."</td>";
                echo "</tr>";
            }
        echo "</table>";
    }
    else{
        echo "<br>Database is NOT connected";
    }
?>
