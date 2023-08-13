<?php
date_default_timezone_set("Asia/Tehran");
$current_time=explode(":",date("H:i:s")) ;
$hour=23-$current_time[0];
$min=59-$current_time[1];
$sec=59-$current_time[2];

//$timer=$hour.":".$min.":".$sec;
//echo json_encode($timer);

echo '{"hour":'.$hour.',"min":'.$min.',"sec":'.$sec.'}';

?>