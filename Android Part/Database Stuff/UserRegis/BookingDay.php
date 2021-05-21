<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['Age']) && isset($_POST['Address']) && isset($_POST['Weight']) && isset($_POST['BookingDay']) && isset($_POST['Symptoms'])) {
    if ($db->dbConnect()) {
        if ($db->BookingDay("patients", $_POST['Age'], $_POST['Address'], $_POST['Weight'], $_POST['BookingDay'], $_POST['Symptoms'])) {
            echo "Booking Success";
        } else echo "Booking Failed";
    } else echo "Error: Database connection";
} else echo "All fields are very required";
?>
