<?php

//echo "[{\"id\":\"1\",\"title\":\"\u06af\u0648\u0634\u06cc \u0633\u0627\u0645\u0633\u0648\u0646\u06af \u0645\u062f\u0644 Galaxy Note 5\",\"price\":\"2,500,000 \u062a\u0648\u0645\u0627\u0646\",\"pprice\":\"2,200,000 \u062a\u0648\u0645\u0627\u0646\",\"image\":\"https:\/\/dkstatics-public.digikala.com\/digikala-products\/5489218.jpg?x-oss-process=image\/resize,m_lfit,h_500,w_500\/quality,q_80\"},{\"id\":\"2\",\"title\":\" \u062a\u0644\u0648\u06cc\u0632\u06cc\u0648\u0646LG \u0645\u062f\u0644 24MT45000\",\"price\":\"12,000,000 \u062a\u0648\u0645\u0627\u0646\",\"pprice\":\"11,300,000 \u062a\u0648\u0645\u0627\u0646\",\"image\":\"https:\/\/dkstatics-public.digikala.com\/digikala-products\/3743099.jpg?x-oss-process=image\/resize,m_lfit,h_500,w_500\/quality,q_80\"},{\"id\":\"3\",\"title\":\" \u062a\u0628\u0644\u062a \u0645\u0627\u06cc\u06a9\u0631\u0648\u0633\u0627\u0641\u062a Surface 3\",\"price\":\"3,600,000 \u062a\u0648\u0645\u0627\u0646\",\"pprice\":\"3,450,000 \u062a\u0648\u0645\u0627\u0646\",\"image\":\"https:\/\/dkstatics-public.digikala.com\/digikala-products\/5177864.jpg?x-oss-process=image\/resize,m_lfit,h_500,w_500\/quality,q_80\"},{\"id\":\"4\",\"title\":\"\u062a\u0628\u0644\u062a \u0622\u0645\u0627\u0632\u0648\u0646 Fire HD 10 \",\"price\":\"5,600,000 \u062a\u0648\u0645\u0627\u0646\",\"pprice\":\"4,550,000 \u062a\u0648\u0645\u0627\u0646\",\"image\":\"https:\/\/dkstatics-public.digikala.com\/digikala-products\/79966.jpg?x-oss-process=image\/resize,m_lfit,h_500,w_500\/quality,q_80\"},{\"id\":\"5\",\"title\":\"\u0645\u0627\u0646\u06cc\u062a\u0648\u0631 \u0648 TV LG 22MA530D\",\"price\":\"8,230,000 \u062a\u0648\u0645\u0627\u0646\",\"pprice\":\"7,730,000 \u062a\u0648\u0645\u0627\u0646\",\"image\":\"https:\/\/dkstatics-public.digikala.com\/digikala-products\/3613398.jpg?x-oss-process=image\/resize,m_lfit,h_500,w_500\/quality,q_80\"}]"
//echo $date = date('Y-m-d');

/*date_default_timezone_set('Iran');
echo $Today=date('Y-m-d--H:i:s')."</br>";

// add 3 days to date
echo $NewDate=Date('Y-m-d', strtotime('7 days'))."</br>";

if($NewDate>$Today){
    echo "time is future";
}else{
    echo "time past";
}*/

function enToFa($string)
{
    return strtr($string, array('0' => '۰', '1' => '۱', '2' => '۲', '3' => '۳', '4' => '۴', '5' => '۵', '6' => '۶', '7' => '۷', '8' => '۸', '9' => '۹'));
}

function trans($num)
{
    $persian_num_array = [
        '0'=>'۰',
        '1'=>'۱',
        '2'=>'۲',
        '3'=>'۳',
        '4'=>'۴',
        '5'=>'۵',
        '6'=>'۶',
        '7'=>'۷',
        '8'=>'۸',
        '9'=>'۹',
    ];

    $num = (float) $num;
    return strtr(number_format($num), $persian_num_array);
}

echo trans(1125120124);

//echo enToFa(12, 000, 000)

?>