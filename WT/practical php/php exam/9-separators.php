<?php
	$l=$_GET['str'];
	$s=$_GET['sep'];
	$sl1=$_GET['s1'];
	$ch=$_GET['r'];

	if($ch==1)
	{
		$arr=explode($s,$l);
		foreach ($arr as $key => $value) {
			echo "Array([" . $key . "] => " . $value . ") ";
		}
	}

	if($ch==2)
	{
		$t=str_replace($s,$sl1,$l);
		echo "Replaced string:".$t;
	}

	if($ch==3)
	{
		$last=strrchr($l," ");
		echo "<br> Last word of string:".$last;
	}
?>
