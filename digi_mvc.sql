-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 21, 2021 at 12:22 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `digi_mvc`
--

-- --------------------------------------------------------

--
-- Table structure for table `app_basket`
--

CREATE TABLE `app_basket` (
  `basket_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `user_email` varchar(200) COLLATE utf8_persian_ci NOT NULL,
  `count` int(11) NOT NULL,
  `pay` int(11) NOT NULL,
  `order_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `app_basket`
--

INSERT INTO `app_basket` (`basket_id`, `product_id`, `user_id`, `user_email`, `count`, `pay`, `order_id`) VALUES
(2, 2, 1, 'info@clicksite.ir', 1, 1, 2147483647),
(3, 3, 1, 'info@clicksite.ir', 3, 1, 2147483647),
(7, 1, 1, 'info@clicksite.ir', 1, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `app_order`
--

CREATE TABLE `app_order` (
  `id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `user_email` varchar(200) COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `date` varchar(50) COLLATE utf8_persian_ci NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`id`, `product_id`, `date`, `price`) VALUES
(1, 1, '1397/2/12', 1980000),
(2, 1, '1397/5/12', 2050000),
(3, 1, '1397/12/12', 2300000),
(4, 1, '1398/2/12', 2500000),
(5, 1, '1399/2/11', 2000000),
(6, 1, '1399/6/8', 3300000);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_attr`
--

CREATE TABLE `tbl_attr` (
  `id` int(255) NOT NULL,
  `title` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `idcategory` int(255) NOT NULL,
  `parent` int(255) NOT NULL,
  `filter` int(1) NOT NULL,
  `filter_right` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_attr`
--

INSERT INTO `tbl_attr` (`id`, `title`, `idcategory`, `parent`, `filter`, `filter_right`) VALUES
(1, 'مشخصات فیزیکی', 1, 0, 0, 0),
(2, 'ابعاد', 1, 1, 1, 0),
(3, 'پردازنده', 1, 0, 0, 0),
(4, 'قدرت پردازنده', 1, 3, 1, 0),
(5, 'مشخصات کلی', 1, 0, 0, 0),
(11, 'قدرت باتری', 1, 5, 1, 0),
(12, 'سیستم عامل', 1, 5, 0, 1),
(15, 'سازنده', 1, 5, 0, 1),
(17, 'تعداد سیم کارت', 4, 16, 0, 0),
(18, 'ابعاد', 4, 16, 0, 0),
(19, 'وزن', 4, 16, 0, 0),
(20, 'ساختار', 4, 16, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_attr_val`
--

CREATE TABLE `tbl_attr_val` (
  `id` int(255) NOT NULL,
  `idattr` int(255) NOT NULL,
  `val` varchar(255) COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_attr_val`
--

INSERT INTO `tbl_attr_val` (`id`, `idattr`, `val`) VALUES
(1, 4, 'یک'),
(8, 4, 'دو'),
(9, 4, 'سه '),
(10, 4, 'چهار'),
(11, 4, 'پنج'),
(12, 2, '2 میلی متر در 2 میلی متر'),
(13, 2, '3 میلی متر در 4 میلی متر'),
(14, 2, '5*5'),
(15, 11, 'معمولی'),
(16, 11, 'قوی'),
(17, 11, 'خیلی قوی'),
(18, 2, '6*6'),
(19, 15, 'سامسونگ'),
(20, 15, 'نوکیا'),
(21, 12, 'اندروید'),
(22, 12, 'ios'),
(23, 20, 'فلز'),
(24, 20, 'شیشه'),
(25, 19, '10 گرم'),
(26, 19, '20 گرم'),
(27, 18, '7.6 × 76.1 × 153.2 میلی‌متر'),
(28, 17, '1'),
(29, 17, '2');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_banner`
--

CREATE TABLE `tbl_banner` (
  `id` int(11) NOT NULL,
  `name` text COLLATE utf8_persian_ci NOT NULL,
  `inner_banner` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_banner`
--

INSERT INTO `tbl_banner` (`id`, `name`, `inner_banner`) VALUES
(1, 'https://dkstatics-public.digikala.com/digikala-adservice-banners/8476be3b5b4ca98e093cad50a3259a9ccc07ae79_1614627881.jpg?x-oss-process=image/quality,q_80', 0),
(2, 'https://dkstatics-public.digikala.com/digikala-adservice-banners/4a6b6f4c780d3e937979aa4f58b8a174deafdb6f_1614628131.jpg?x-oss-process=image/quality,q_80', 0),
(7, 'https://dkstatics-public.digikala.com/digikala-adservice-banners/cab347374d7d1bad7e3e4e08baeec5b53e7fd5cd_1614628366.jpg?x-oss-process=image/quality,q_80', 1),
(8, 'https://dkstatics-public.digikala.com/digikala-adservice-banners/04830cecc061bb767955aff2b9cab9b67b3402b1_1614619799.jpg?x-oss-process=image/quality,q_80', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_basket`
--

CREATE TABLE `tbl_basket` (
  `id` int(255) NOT NULL,
  `cookie` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `idproduct` int(255) NOT NULL,
  `tedad` int(255) NOT NULL,
  `color` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `garantee` varchar(255) COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_basket`
--

INSERT INTO `tbl_basket` (`id`, `cookie`, `idproduct`, `tedad`, `color`, `garantee`) VALUES
(21, '1470834342', 16, 2, '3', '1'),
(22, '1470834342', 16, 9, '2', '1'),
(23, '1471615102', 16, 6, '0', '0'),
(24, '1472645832', 1, 6, '0', '0'),
(25, 'info@clicksite.ir', 1, 1, 'قرمز', 'گارانتی شماره 2');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_category`
--

CREATE TABLE `tbl_category` (
  `id` int(255) NOT NULL,
  `title` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `parent` int(255) NOT NULL,
  `picurl` varchar(200) COLLATE utf8_persian_ci NOT NULL,
  `position` text COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_category`
--

INSERT INTO `tbl_category` (`id`, `title`, `parent`, `picurl`, `position`) VALUES
(1, 'کالای دیجیتال', 0, 'digital.png', 'https://cdn0.iconfinder.com/data/icons/apple-iphone-x-1/128/iphone-iphone_x-_iphonex-mobile-apple-device-2-256.png'),
(2, 'موبایل', 1, 'mobile.jpg', '0'),
(3, 'تبلت', 1, 'tablet.jpg', '0'),
(4, 'گوشی موبایل', 2, 'mobile.jpg', '0'),
(5, 'هدست', 2, 'reddigi.jpg', '0'),
(6, 'samsung', 4, 'reddigi.jpg', '0'),
(7, 'apple', 4, 'reddigi.jpg', '0'),
(8, 'مارک hitech', 5, 'reddigi.jpg', '0'),
(11, 'بر اساس سازنده', 3, 'reddigi.jpg', '0'),
(12, 'Lenevo', 11, 'reddigi.jpg', '0'),
(14, 'Microsoft', 11, 'reddigi.jpg', '0'),
(15, 'لوازم خانگی', 0, 'lavazem.jpg', 'https://cdn3.iconfinder.com/data/icons/home-appliances-58/110/260-256.png'),
(16, 'لوازم صوتی تصویری', 15, 'sutitasviri.jpg', '0'),
(17, 'لوازم برقی', 15, 'barghi.jpg', '0'),
(18, 'آشپزخانه', 15, 'ashpazkhane.jpg', '0'),
(19, 'تلویزیون', 16, 'tv.JPG', '0'),
(20, 'کمتر از 32 اینچ', 19, 'reddigi.jpg', '0'),
(21, 'بین 32 تا 42 اینچ', 19, 'reddigi.jpg', '0'),
(22, 'زیبایی و سلامت', 0, 'reddigi.jpg', 'https://cdn0.iconfinder.com/data/icons/beauty-cosmetics-set/128/Full_Beauty_Cosmetics_Line_Icons_Live-51-256.png'),
(23, 'فرهنگ و هنر', 0, 'reddigi.jpg', 'https://cdn3.iconfinder.com/data/icons/business-327/100/business-go-01-256.png'),
(24, 'ورزش و سرگرمی', 0, 'reddigi.jpg', 'https://cdn0.iconfinder.com/data/icons/fitness-gym-6/56/20_running_shoes-256.png'),
(25, 'مادر و کودک', 0, 'reddigi.jpg', 'https://cdn1.iconfinder.com/data/icons/baby-children-3/24/baby_children_child-256.png');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_cat_param`
--

CREATE TABLE `tbl_cat_param` (
  `id` int(11) NOT NULL,
  `title` varchar(100) COLLATE utf8_persian_ci NOT NULL,
  `cat` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_cat_param`
--

INSERT INTO `tbl_cat_param` (`id`, `title`, `cat`) VALUES
(2, 'رنگ', 4),
(3, 'قیمت', 4);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_code`
--

CREATE TABLE `tbl_code` (
  `id` int(255) NOT NULL,
  `code` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `used` int(1) NOT NULL,
  `darsad` int(10) NOT NULL,
  `userId` int(255) NOT NULL,
  `tarikh_sabt` varchar(30) COLLATE utf8_persian_ci NOT NULL,
  `tarikh_end` varchar(30) COLLATE utf8_persian_ci NOT NULL,
  `max` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_code`
--

INSERT INTO `tbl_code` (`id`, `code`, `used`, `darsad`, `userId`, `tarikh_sabt`, `tarikh_end`, `max`) VALUES
(1, 'clicksite', 0, 20, 1, '1395/6/3', '1395/6/5', 3),
(2, 'clicksite2', 0, 30, 1, '1395/6/4', '1395/6/24', 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_color`
--

CREATE TABLE `tbl_color` (
  `id` int(255) NOT NULL,
  `title` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `hex` varchar(255) COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_color`
--

INSERT INTO `tbl_color` (`id`, `title`, `hex`) VALUES
(1, 'سفید', '#fff'),
(2, 'مشکی', '#000'),
(3, 'قرمز', '#f00');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_comment`
--

CREATE TABLE `tbl_comment` (
  `id` int(255) NOT NULL,
  `title` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `matn` text COLLATE utf8_persian_ci NOT NULL,
  `tarikh` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `posotive` text COLLATE utf8_persian_ci NOT NULL,
  `negative` text COLLATE utf8_persian_ci NOT NULL,
  `likecount` int(255) NOT NULL,
  `dislikecount` int(255) NOT NULL,
  `idproduct` int(255) NOT NULL,
  `param` text COLLATE utf8_persian_ci NOT NULL,
  `user` varchar(100) COLLATE utf8_persian_ci DEFAULT NULL,
  `suggest` int(11) NOT NULL,
  `confirm` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_comment`
--

INSERT INTO `tbl_comment` (`id`, `title`, `matn`, `tarikh`, `posotive`, `negative`, `likecount`, `dislikecount`, `idproduct`, `param`, `user`, `suggest`, `confirm`) VALUES
(1, 'گوشی خوبیه', 'گوشی خوبیه و فقط در زمان استفاده زیاد یه کم داغ میکنه', '', 'قوت', 'باتری نسبتا ضعیف', 0, 0, 16, '[{\"title\": \"کیفیت و طراحی\",\"value\":\"3.5\"},{\"title\":\"ارزش خرید\",\"value\":\"4.2\"},{\"title\":\"خلاقیت و نو آوری\",\"value\":\"3.9\"},{\"title\":\"راحتی در استفاده\",\"value\":\"3.5\"}]', 'سعید محمدی', 0, 1),
(7, 'گوشی خوبیه', 'نظر اول', '', 'قوت', 'باتری ضعیف', 0, 0, 16, '[{\"title\": \"کیفیت و طراحی\",\"value\":\"3.5\"},{\"title\":\"ارزش خرید\",\"value\":\"4.2\"},{\"title\":\"خلاقیت و نو آوری\",\"value\":\"3.9\"},{\"title\":\"راحتی در استفاده\",\"value\":\"3.5\"}]', 'محسن ادیب', 0, 1),
(8, 'عالیه', 'گوشی خوبیه و فقط در زمان استفاده زیاد یه کم داغ میکنه', '', 'باتری قوی', 'رنگ بندی کم', 16, 11, 1, '[{\"title\": \"کیفیت و طراحی\",\"value\":\"3.5\"},{\"title\":\"ارزش خرید\",\"value\":\"4.2\"},{\"title\":\"خلاقیت و نو آوری\",\"value\":\"3.9\"},{\"title\":\"راحتی در استفاده\",\"value\":\"3.5\"}]', 'لاله مروتی', 1, 1),
(11, 'عاشقشم', 'بی نظیره این گوشی', '', 'سرعت خوب', 'رنگش', 16, 17, 1, '[{\"title\": \"کیفیت و طراحی\",\"value\":\"3.5\"},{\"title\":\"ارزش خرید\",\"value\":\"4.2\"},{\"title\":\"خلاقیت و نو آوری\",\"value\":\"3.9\"},{\"title\":\"راحتی در استفاده\",\"value\":\"3.5\"}]', 'بهنام حسینی', 0, 1),
(12, 'حتما بخونید', 'خیلی دوستش داشتم تو این 6 ماهی که دارمش واقعا خوب بوده', '', 'صفحه نمایش', 'باتری', 9, 7, 1, '[{\"title\": \"کیفیت و طراحی\",\"value\":\"3.5\"},{\"title\":\"ارزش خرید\",\"value\":\"4.2\"},{\"title\":\"خلاقیت و نو آوری\",\"value\":\"3.9\"},{\"title\":\"راحتی در استفاده\",\"value\":\"3.5\"}]', 'ناهید اقایی', 0, 1),
(16, 'انقدر که تعریف میکنن خوب نیست', 'انقدر که تعریف میکنن خوب نیست', '', '', 'باتری', 2, 0, 1, '[{\"title\": \"کیفیت و طراحی\",\"value\":\"3.5\"},{\"title\":\"ارزش خرید\",\"value\":\"4.2\"},{\"title\":\"خلاقیت و نو آوری\",\"value\":\"3.9\"},{\"title\":\"راحتی در استفاده\",\"value\":\"3.5\"}]', 'زهرا شریفی', 1, 1),
(17, '', '', '', '', '', 0, 0, 0, '[{\"title\":\"کیفیت و طراحی\",\"value\":\"5.0\"},{\"title\":\"ارزش خرید\",\"value\":\"5.0\"},{\"title\":\"خلاقیت و نو آوری\",\"value\":\"5.0\"},{\"title\":\"راحتی در استفاده\",\"value\":\"5.0\"}]', 'root', 0, 0),
(18, 'عالی', 'تتتت', '', 'حرف نداذه', 'هیچی', 0, 0, 0, '', 'info@clicksite.ir', 0, 0),
(19, '', '', '', '', '', 0, 0, 0, '[{\"title\":\"کیفیت و طراحی\",\"value\":\"5.0\"},{\"title\":\"ارزش خرید\",\"value\":\"2.0\"},{\"title\":\"خلاقیت و نو آوری\",\"value\":\"5.0\"},{\"title\":\"راحتی در استفاده\",\"value\":\"1.0\"}]', 'root', 0, 0),
(20, 'عالی', 'عالی', '', 'باتری', 'ندارد', 0, 0, 0, '', 'info@clicksite.ir', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_comment_param`
--

CREATE TABLE `tbl_comment_param` (
  `id` int(255) NOT NULL,
  `title` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `idcategory` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_comment_param`
--

INSERT INTO `tbl_comment_param` (`id`, `title`, `idcategory`) VALUES
(1, 'نوآوری', 4),
(2, 'ارزش خرید به نسبت قیمت', 4),
(3, 'کیفیت ساخت', 4),
(4, 'پارامتر تست', 4),
(5, 'پارامتر تست جدید', 4),
(6, 'نوآوری', 19),
(8, 'روشنایی تصویر', 19),
(9, 'کیفیت', 19);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_favorit`
--

CREATE TABLE `tbl_favorit` (
  `fav_id` int(255) NOT NULL,
  `idproduct` int(255) NOT NULL,
  `userId` int(255) NOT NULL,
  `parent` int(255) NOT NULL,
  `title` varchar(255) COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_favorit`
--

INSERT INTO `tbl_favorit` (`fav_id`, `idproduct`, `userId`, `parent`, `title`) VALUES
(7, 2, 11, 1, 'تلوزیون'),
(16, 1, 1, 0, '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_gallery`
--

CREATE TABLE `tbl_gallery` (
  `id` int(255) NOT NULL,
  `img` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `idproduct` int(255) NOT NULL,
  `threed` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_gallery`
--

INSERT INTO `tbl_gallery` (`id`, `img`, `idproduct`, `threed`) VALUES
(9, 'https://dkstatics-public.digikala.com/digikala-products/1979239.jpg?x-oss-process=image/resize,m_lfit,h_350,w_350/quality,q_60', 1, 1),
(10, 'https://dkstatics-public.digikala.com/digikala-products/2453476.jpg?x-oss-process=image/resize,m_lfit,h_350,w_350/quality,q_60', 1, 0),
(12, 'https://dkstatics-public.digikala.com/digikala-products/2816330.jpg?x-oss-process=image/resize,m_lfit,h_500,w_500/quality,q_80', 2, 0),
(13, 'https://dkstatics-public.digikala.com/digikala-products/3695323.jpg?x-oss-process=image/resize,m_lfit,h_500,w_500/quality,q_80', 2, 0),
(14, 'https://dkstatics-public.digikala.com/digikala-products/111096.jpg?x-oss-process=image/resize,m_lfit,h_500,w_500/quality,q_80', 3, 0),
(15, 'https://dkstatics-public.digikala.com/digikala-products/1955752.jpg?x-oss-process=image/resize,m_lfit,h_500,w_500/quality,q_80', 3, 0),
(16, 'https://dkstatics-public.digikala.com/digikala-products/3963510.jpg?x-oss-process=image/resize,m_lfit,h_500,w_500/quality,q_80', 4, 0),
(17, 'https://dkstatics-public.digikala.com/digikala-products/1121799.jpg?x-oss-process=image/resize,m_lfit,h_500,w_500/quality,q_80', 4, 0),
(18, 'https://dkstatics-public.digikala.com/digikala-products/474328.jpg?x-oss-process=image/resize,m_lfit,h_500,w_500/quality,q_80', 5, 0),
(19, 'https://dkstatics-public.digikala.com/digikala-products/327776.jpg?x-oss-process=image/resize,m_lfit,h_500,w_500/quality,q_80', 5, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_garantee`
--

CREATE TABLE `tbl_garantee` (
  `id` int(255) NOT NULL,
  `title` varchar(255) COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_garantee`
--

INSERT INTO `tbl_garantee` (`id`, `title`) VALUES
(1, 'گارانتی شماره 1'),
(2, 'گارانتی شماره 2');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_message`
--

CREATE TABLE `tbl_message` (
  `id` int(255) NOT NULL,
  `title` text COLLATE utf8_persian_ci NOT NULL,
  `matn` text COLLATE utf8_persian_ci NOT NULL,
  `userId` int(255) NOT NULL,
  `status` int(1) NOT NULL,
  `date` varchar(30) COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_message`
--

INSERT INTO `tbl_message` (`id`, `title`, `matn`, `userId`, `status`, `date`) VALUES
(1, 'آماده سازی سفارش', 'سفارش با شماره فاکتور 12334 به قسمت ارسال تحویل داده شد', 1, 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_naghd`
--

CREATE TABLE `tbl_naghd` (
  `id` int(255) NOT NULL,
  `title` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `description` text COLLATE utf8_persian_ci NOT NULL,
  `idproduct` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_naghd`
--

INSERT INTO `tbl_naghd` (`id`, `title`, `description`, `idproduct`) VALUES
(1, 'طراحی و ساخت', '<p>موفقیت استفاده از شیشه و فلز در طراحی گلکسی S6، سامسونگ را به فکر استفاده از آن&zwnj;ها در طراحی نوت جدید انداخت. ظاهر چشم&zwnj;نواز و براق، از نخستین ویژگی&zwnj;های گوشی پنجم سری نوت سامسونگ است. برخلاف نوت قبلی که قاب پشتی&zwnj;اش از پلاستیک بود و قابلیت بازشدن داشت، قاب پشتی نوت جدید بازشدنی نیست. سامسونگ امکان تعویض باتری را قربانی طراحی یکپارچه کرده است. قاب پشتی با ارگونومیک بیشتری طراحی شده تا دردست&zwnj;گرفتن نوت 5 با توجه به ابعاد بزرگش راحت&zwnj;تر شود. یکی از مواردی که در معرفی نوت 5 به آن اشاره شد، داشتن نمایشگر بزرگ&zwnj;تر در مقایسه با آیفون 6 پلاس با توجه به ابعاد یکسان طول و عرضی&zwnj;اش بود که با 154 میلی&zwnj;متر طول و عرض 76 میلی&zwnj;متری، صفحه&zwnj;نمایش 5.7 اینچی را در خود جا داده&zwnj; است؛ البته این بدنه&zwnj;ی تمام&zwnj;فلزی کمی سنگین است و وزنی نزدیک به 171 گرم دارد. سامسونگ با کم&zwnj;کردن فاصله&zwnj;ی نمایشگر از لبه&zwnj;های چپ و راست گوشی، نه&zwnj;تنها دردست&zwnj;گرفتن آن را ساده&zwnj;تر کرده؛ بلکه از ابعاد گوشی هم تا حد توجه&zwnj;برانگیزی کاسته است. در این طراحی، آینه&zwnj;ای&zwnj;بودن قاب پشتی و جلویی گوشی خیلی آزاردهنده است. اگر می&zwnj;خواهید گوشی&zwnj;تان همیشه تمیز باشد، باید پارچه&zwnj;ای از جنس ماکروفایبر داشته باشید و هرچند دقیقه یک&zwnj;بار گوشی&zwnj;تان را تمیز کنید. بدنه&zwnj;ی نوت 5، استعداد بالایی در جذب اثرانگشت، چربی و عرق دارد؛ اما در مقابل جلوه&zwnj;ای لوکس به نوت جدید بخشیده است.</p>\n', 1),
(2, 'صفحه نمایش', '<div class=\"style4 clearfix v1\">\r\n<div class=\"content\">\r\n<p>اوج پیشرفت سامسونگ در نوت 5 را می&zwnj;توان صفحه&zwnj;نمایش این محصول دانست. این نمایشگر در ابعاد، رزولوشن و نوع هیچ تفاوتی با نوت قبلی ندارد. نمایشگری 5.7 اینچی از نوع اولد و فناوری سوپر امولد با رزولوشن 2560 در 1440 و تراکم 518 پیکسل بر هر اینچ برای نوت 5 در نظر گرفته شده است. از نظر اعداد و ارقام، عملا با نمایشگری تکراری در مقایسه با نوت &zwnj;3 طرف هستیم؛ اما سامسونگ با استفاده از چینش &laquo;دیاموند پنتایل&raquo; و روشنایی بیشتر، این نمایشگر را به بهترین نمایشگر گوشی&zwnj;های همراه تاکنون تبدیل کرده است. نقص روشنایی از عیوبی است که نمایشگرهای امولد دارند؛ اما سامسونگ با بالابردن روشنایی این نمایشگر تا 620 نیت توانسته این مشکل را تاحدچشمگیری حل کند. مورد دیگری که می&zwnj;تواند در نمایشگر&zwnj;های امولد آزاردهنده باشد، غیرواقعی&zwnj;بودن رنگ&zwnj;ها در این نمایشگر است و اینکه رنگ&zwnj;ها در مقایسه بارنگ&zwnj;های طبیعی، با اشباع بیشتری به نمایش درمی&zwnj;آیند.</p>\r\n</div>\r\n</div>\r\n\r\n<div class=\"style3 clearfix v1\"><img src=\"http://file.digikala.com/Digikala/Image/Webstore/Product/P_92909/Reviews/7584578c-12ba-4d1d-a9b6-c2502a9dde31.jpg\" style=\"height:auto; width:auto\" /></div>\r\n', 1),
(3, 'سخت افزار و کارایی', '<div class=\"style1 v3 clearfix\">\r\n<div class=\"thumb\"><img src=\"http://file.digikala.com/Digikala/Image/Webstore/Product/P_92909/Reviews/b03521d3-26a6-4a1c-8989-69a8b4742c5a.jpg\" style=\"height:auto; width:auto\" /></div>\r\n\r\n<div class=\"content\">\r\n<p>&nbsp;</p>\r\n\r\n<p>برای نوت 5، اندروید لالی&zwnj;پاپ 64 بیتی نسخه&zwnj;ی 5.1.1 در نظر گرفته شده&zwnj; به همراه &laquo;تاچ&zwnj;ویزی&raquo; (TouchWiz) که ظاهر تکراری&zwnj;اش برای کاربران گوشی&zwnj;های سامسونگ عادی شده است. افزوده&zwnj;شدن چند امکان امنیتی جدید به &laquo;تاچ&zwnj;ویز&raquo; (TouchWiz) در مقایسه با نسخه&zwnj;های قبلی&zwnj;اش، یک اتفاق خوب برای نوت 5 به&zwnj;حساب می&zwnj;آید. گزینه&zwnj;ی&zwnj; &laquo;حالت شخصی&raquo; (Private Mode) به شما امکان می&zwnj;دهد تا مدیای شخصی خود را از دید دیگران پنهان کنید. با استفاده از گزینه&zwnj;ی &laquo;ارسال پیام اضطراری&raquo; (Send SOS Massage) می&zwnj;توانید با سه بار فشردن کلید پاور، پیامی را در قالب MMS (شامل تصویر&zwnj;های ثبت&zwnj;شده از دو دوربین گوشی به همراه صدای ضبط&zwnj;شده) به شماره یا شماره&zwnj;های دلخواه ارسال کنید؛ همچنین اضافه&zwnj;شدن گزینه&zwnj;ی &laquo;گوشی مرا بیاب&raquo; (Find My Phone) موردی شبیه &laquo;Find My iPhone&raquo; را در اختیار کاربران سامسونگ قرار می&zwnj;دهد. اگر گوشی&zwnj;تان را گم کنید یا به سرقت برده شود، با این گزینه و از طریق اکانت سامسونگ&zwnj; خود می&zwnj;توانید گوشی را روی نقشه ردیابی کنید.</p>\r\n</div>\r\n</div>\r\n', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_option`
--

CREATE TABLE `tbl_option` (
  `id` int(255) NOT NULL,
  `setting` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `value` varchar(255) COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_option`
--

INSERT INTO `tbl_option` (`id`, `setting`, `value`) VALUES
(1, 'special_time', '172800'),
(2, 'limit_slider', '10'),
(3, 'tel', '021-999999 - 09396562210'),
(4, 'email', 'clicksite.ir@gmail.com'),
(5, 'mohlatPay', '48'),
(6, 'root', 'http://127.0.0.1/digikalamvc/'),
(7, 'zarinpalMID', 'f0a107a8-eb7c-11e5-8af1-005056a205be'),
(8, 'body_color', 'D7D7D7'),
(9, 'menu_color', 'F1FFEE');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_order`
--

CREATE TABLE `tbl_order` (
  `id` int(255) NOT NULL,
  `beforepay` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `afterpay` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `amount` int(255) NOT NULL,
  `family` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `reverse` int(255) NOT NULL,
  `ostan` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `city` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `code_posti` varchar(10) COLLATE utf8_persian_ci NOT NULL,
  `mobile` varchar(15) COLLATE utf8_persian_ci NOT NULL,
  `tel` varchar(20) COLLATE utf8_persian_ci NOT NULL,
  `post_type` int(1) NOT NULL,
  `basket` text COLLATE utf8_persian_ci NOT NULL,
  `address` text COLLATE utf8_persian_ci NOT NULL,
  `post_price` int(255) NOT NULL,
  `userId` int(255) NOT NULL,
  `status` int(1) NOT NULL,
  `pay` int(1) NOT NULL,
  `pay_type` int(1) NOT NULL,
  `pay_day` int(10) NOT NULL,
  `pay_month` int(10) NOT NULL,
  `pay_year` int(10) NOT NULL,
  `pay_card` varchar(20) COLLATE utf8_persian_ci NOT NULL,
  `pay_bank_name` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `pay_hour` int(10) NOT NULL,
  `pay_minute` int(10) NOT NULL,
  `time_sabt` int(255) NOT NULL,
  `date` varchar(30) COLLATE utf8_persian_ci NOT NULL,
  `barcode` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `code` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `tarikh` varchar(50) COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_order`
--

INSERT INTO `tbl_order` (`id`, `beforepay`, `afterpay`, `amount`, `family`, `reverse`, `ostan`, `city`, `code_posti`, `mobile`, `tel`, `post_type`, `basket`, `address`, `post_price`, `userId`, `status`, `pay`, `pay_type`, `pay_day`, `pay_month`, `pay_year`, `pay_card`, `pay_bank_name`, `pay_hour`, `pay_minute`, `time_sabt`, `date`, `barcode`, `code`, `tarikh`) VALUES
(5, '', '', 15569, 'محمد امینی', 0, 'خراسان جنوبي', 'بیرجند', '2128719271', '09396562210', '021666335', 0, 'a:1:{i:0;a:20:{s:5:\"tedad\";s:1:\"6\";s:9:\"basketRow\";s:2:\"23\";s:2:\"id\";s:2:\"16\";s:5:\"title\";s:33:\"گوشی سامسونگ مدل 34\";s:5:\"price\";s:4:\"2000\";s:3:\"cat\";s:1:\"1\";s:12:\"introduction\";s:23:\"<p>توضیحات</p>\r\n\";s:12:\"tedad_mojood\";s:2:\"10\";s:8:\"discount\";s:2:\"20\";s:7:\"special\";s:1:\"0\";s:12:\"time_special\";s:1:\"0\";s:13:\"onlyclicksite\";s:1:\"0\";s:5:\"viewd\";s:1:\"0\";s:6:\"colors\";s:3:\"2,3\";s:8:\"garantee\";s:1:\"1\";s:10:\"idcategory\";s:1:\"0\";s:6:\"weight\";s:2:\"40\";s:10:\"colorTitle\";N;s:13:\"garanteeTitle\";N;s:13:\"discountTotal\";i:2400;}}', 'خیابان 2 پلا 10', 0, 0, 0, 0, 0, 0, 0, 0, '', '', 0, 0, 0, '', '', '', '1395/6/5'),
(6, '', '', 13169, 'محمد امینی', 0, 'خراسان جنوبي', 'بیرجند', '2128719271', '09396562210', '021666335', 0, 'a:1:{i:0;a:20:{s:5:\"tedad\";s:1:\"6\";s:9:\"basketRow\";s:2:\"23\";s:2:\"id\";s:2:\"16\";s:5:\"title\";s:33:\"گوشی سامسونگ مدل 34\";s:5:\"price\";s:4:\"2000\";s:3:\"cat\";s:1:\"1\";s:12:\"introduction\";s:23:\"<p>توضیحات</p>\r\n\";s:12:\"tedad_mojood\";s:2:\"10\";s:8:\"discount\";s:2:\"20\";s:7:\"special\";s:1:\"0\";s:12:\"time_special\";s:1:\"0\";s:13:\"onlyclicksite\";s:1:\"0\";s:5:\"viewd\";s:1:\"0\";s:6:\"colors\";s:3:\"2,3\";s:8:\"garantee\";s:1:\"1\";s:10:\"idcategory\";s:1:\"0\";s:6:\"weight\";s:2:\"40\";s:10:\"colorTitle\";N;s:13:\"garanteeTitle\";N;s:13:\"discountTotal\";i:2400;}}', 'خیابان 2 پلا 10', 0, 0, 0, 0, 0, 0, 0, 0, '', '', 0, 0, 0, '', '', '', '1395/6/5'),
(7, '12345', '', 13169, 'محمد امینی', 0, 'خراسان جنوبي', 'بیرجند', '2128719271', '09396562210', '021666335', 1, 'a:1:{i:0;a:20:{s:5:\"tedad\";s:1:\"6\";s:9:\"basketRow\";s:2:\"23\";s:2:\"id\";s:2:\"16\";s:5:\"title\";s:33:\"گوشی سامسونگ مدل 34\";s:5:\"price\";s:4:\"2000\";s:3:\"cat\";s:1:\"1\";s:12:\"introduction\";s:23:\"<p>توضیحات</p>\r\n\";s:12:\"tedad_mojood\";s:2:\"10\";s:8:\"discount\";s:2:\"20\";s:7:\"special\";s:1:\"0\";s:12:\"time_special\";s:1:\"0\";s:13:\"onlyclicksite\";s:1:\"0\";s:5:\"viewd\";s:1:\"0\";s:6:\"colors\";s:3:\"2,3\";s:8:\"garantee\";s:1:\"1\";s:10:\"idcategory\";s:1:\"0\";s:6:\"weight\";s:2:\"40\";s:10:\"colorTitle\";N;s:13:\"garanteeTitle\";N;s:13:\"discountTotal\";i:2400;}}', 'خیابان 2 پلا 10', 5969, 1, 0, 0, 0, 0, 0, 0, '', '', 0, 0, 0, '', '', '', '1395/6/5'),
(8, '', '', 15569, 'محمد امینی', 0, 'خراسان جنوبي', 'بیرجند', '2128719271', '09396562210', '021666335', 1, 'a:1:{i:0;a:20:{s:5:\"tedad\";s:1:\"6\";s:9:\"basketRow\";s:2:\"23\";s:2:\"id\";s:2:\"16\";s:5:\"title\";s:33:\"گوشی سامسونگ مدل 34\";s:5:\"price\";s:4:\"2000\";s:3:\"cat\";s:1:\"1\";s:12:\"introduction\";s:23:\"<p>توضیحات</p>\r\n\";s:12:\"tedad_mojood\";s:2:\"10\";s:8:\"discount\";s:2:\"20\";s:7:\"special\";s:1:\"0\";s:12:\"time_special\";s:1:\"0\";s:13:\"onlyclicksite\";s:1:\"0\";s:5:\"viewd\";s:1:\"0\";s:6:\"colors\";s:3:\"2,3\";s:8:\"garantee\";s:1:\"1\";s:10:\"idcategory\";s:1:\"0\";s:6:\"weight\";s:2:\"40\";s:10:\"colorTitle\";N;s:13:\"garanteeTitle\";N;s:13:\"discountTotal\";i:2400;}}', 'خیابان 2 پلا 10', 5969, 1, 1, 0, 0, 0, 0, 0, '', '', 0, 0, 0, '', '', '', '1395/6/5'),
(9, '', '', 15569, 'محمد امینی', 0, 'خراسان جنوبي', 'بیرجند', '2128719271', '09396562210', '021666335', 1, 'a:1:{i:0;a:20:{s:5:\"tedad\";s:1:\"6\";s:9:\"basketRow\";s:2:\"23\";s:2:\"id\";s:2:\"16\";s:5:\"title\";s:33:\"گوشی سامسونگ مدل 34\";s:5:\"price\";s:4:\"2000\";s:3:\"cat\";s:1:\"1\";s:12:\"introduction\";s:23:\"<p>توضیحات</p>\r\n\";s:12:\"tedad_mojood\";s:2:\"10\";s:8:\"discount\";s:2:\"20\";s:7:\"special\";s:1:\"0\";s:12:\"time_special\";s:1:\"0\";s:13:\"onlyclicksite\";s:1:\"0\";s:5:\"viewd\";s:1:\"0\";s:6:\"colors\";s:3:\"2,3\";s:8:\"garantee\";s:1:\"1\";s:10:\"idcategory\";s:1:\"0\";s:6:\"weight\";s:2:\"40\";s:10:\"colorTitle\";N;s:13:\"garanteeTitle\";N;s:13:\"discountTotal\";i:2400;}}', 'خیابان 2 پلا 10', 5969, 1, 1, 0, 4, 1, 1, 1400, '610433796', 'ملت', 9, 1, 0, '', '', '', '1395/6/6'),
(10, '', '', 15569, 'محمد امینی', 0, 'خراسان جنوبي', 'بیرجند', '111111111', '09396562210', '021666335', 1, 'a:1:{i:0;a:20:{s:5:\"tedad\";s:1:\"6\";s:9:\"basketRow\";s:2:\"23\";s:2:\"id\";s:2:\"16\";s:5:\"title\";s:33:\"گوشی سامسونگ مدل 34\";s:5:\"price\";s:4:\"2000\";s:3:\"cat\";s:1:\"1\";s:12:\"introduction\";s:23:\"<p>توضیحات</p>\r\n\";s:12:\"tedad_mojood\";s:2:\"10\";s:8:\"discount\";s:2:\"20\";s:7:\"special\";s:1:\"0\";s:12:\"time_special\";s:1:\"0\";s:13:\"onlyclicksite\";s:1:\"0\";s:5:\"viewd\";s:1:\"0\";s:6:\"colors\";s:3:\"2,3\";s:8:\"garantee\";s:1:\"1\";s:10:\"idcategory\";s:1:\"0\";s:6:\"weight\";s:2:\"40\";s:10:\"colorTitle\";N;s:13:\"garanteeTitle\";N;s:13:\"discountTotal\";i:2400;}}', 'خیابان 2 پلاک 10', 5969, 1, 5, 1, 4, 25, 6, 1395, '6104336372632678', 'صادرات', 10, 32, 1471949702, '', '', 'clicksite', '1395/6/7'),
(11, '', '', 10751, 'محمد امینی', 0, 'خراسان جنوبي', 'بیرجند', '2128719271', '09396562210', '021666335', 1, 'a:1:{i:0;a:20:{s:5:\"tedad\";s:1:\"6\";s:9:\"basketRow\";s:2:\"24\";s:2:\"id\";s:1:\"1\";s:5:\"title\";s:44:\"گوشی سامسونگ مدل Galaxy Note 5\";s:5:\"price\";s:4:\"1000\";s:3:\"cat\";s:1:\"4\";s:12:\"introduction\";s:2114:\"<p>امکان&zwnj; یادداشت&zwnj;برداری با قلم، صفحه&zwnj;نمایش بزرگ و سخت&zwnj;افزار قدرتمند از ویژگی&zwnj;های گوشی&zwnj;های سری نوت سامسونگ هستند. بعد از تولید چهار نسل موفق از این گوشی، نسل پنجم با تغییراتی کم&zwnj;وبیش بزرگ طراحی و ساخته شد. شماری از این تغییرات، کم&zwnj;وکاستی&zwnj;های سری&zwnj;های قبل را پوشش داده&zwnj;اند؛ البته تغییراتی هم باعث حذف قابلیت&zwnj;های محبوب و کاربردی گوشی&zwnj;های قبلی این سری شده&zwnj;اند. گوشی &laquo;سامسونگ گلکسی نوت 5&raquo; (Samsung galaxy Note5) برخلاف گوشی&zwnj;های قبلی سامسونگ در همین سری، بدنه&zwnj;ای از جنس فلز و شیشه دارد. این بدنه&zwnj;ی فلزی باعث شده تا وزن نوت پنجم 171 گرم شود که در مقایسه با وزن نوت 4، چند گرمی سبک&zwnj;تر شده است. با درنظرگرفتن جای قلم در بدنه&zwnj;ی&zwnj; نوت5، این گوشی نزدیک به 7.6 میلی&zwnj;متر ضخامت دارد که در مقایسه با نسل قبلی&zwnj;اش باریک&zwnj;تر هم شده است. در کنار طراحی عالی و چشم&zwnj;نواز نوت5، برای این گوشی نمایشگری از نوع اولد با فناوری سوپر امولد با رزولوشن 2560 در 1440 و تراکم 518 پیکسل بر هر اینچ در نظر گرفته شده است. سامسونگ برای محافظت از این نمایشگر 5.7 اینچی که از نظر اندازه با نسل قبلی&zwnj;اش متفاوت نیست، از محافظ&zwnj;های گوریلاگلس نسخه&zwnj;ی چهارم بهره برده است. تراشه&zwnj;ی نوت5 همان تراشه&zwnj;ی اختصاصی سامسونگ اگزینوس 7420 است که پیش&zwnj;تر در گلکسی S6 هم استفاده شده بود.</p>\r\n\";s:12:\"tedad_mojood\";s:2:\"10\";s:8:\"discount\";s:2:\"20\";s:7:\"special\";s:1:\"1\";s:12:\"time_special\";s:10:\"1472645521\";s:13:\"onlyclicksite\";s:1:\"1\";s:5:\"viewd\";s:1:\"0\";s:6:\"colors\";s:3:\"2,3\";s:8:\"garantee\";s:3:\"1,2\";s:10:\"idcategory\";s:1:\"0\";s:6:\"weight\";s:2:\"10\";s:10:\"colorTitle\";N;s:13:\"garanteeTitle\";N;s:13:\"discountTotal\";i:1200;}}', 'خیابان 2 پلا 10', 5951, 1, 1, 0, 4, 0, 0, 0, '', '', 0, 0, 1472650820, '', '', '', '1395/6/7'),
(12, '', '', 10751, 'محمد امینی', 0, 'خراسان جنوبي', 'بیرجند', '2128719271', '09396562210', '021666335', 1, 'a:1:{i:0;a:20:{s:5:\"tedad\";s:1:\"6\";s:9:\"basketRow\";s:2:\"24\";s:2:\"id\";s:1:\"1\";s:5:\"title\";s:44:\"گوشی سامسونگ مدل Galaxy Note 5\";s:5:\"price\";s:4:\"1000\";s:3:\"cat\";s:1:\"4\";s:12:\"introduction\";s:2114:\"<p>امکان&zwnj; یادداشت&zwnj;برداری با قلم، صفحه&zwnj;نمایش بزرگ و سخت&zwnj;افزار قدرتمند از ویژگی&zwnj;های گوشی&zwnj;های سری نوت سامسونگ هستند. بعد از تولید چهار نسل موفق از این گوشی، نسل پنجم با تغییراتی کم&zwnj;وبیش بزرگ طراحی و ساخته شد. شماری از این تغییرات، کم&zwnj;وکاستی&zwnj;های سری&zwnj;های قبل را پوشش داده&zwnj;اند؛ البته تغییراتی هم باعث حذف قابلیت&zwnj;های محبوب و کاربردی گوشی&zwnj;های قبلی این سری شده&zwnj;اند. گوشی &laquo;سامسونگ گلکسی نوت 5&raquo; (Samsung galaxy Note5) برخلاف گوشی&zwnj;های قبلی سامسونگ در همین سری، بدنه&zwnj;ای از جنس فلز و شیشه دارد. این بدنه&zwnj;ی فلزی باعث شده تا وزن نوت پنجم 171 گرم شود که در مقایسه با وزن نوت 4، چند گرمی سبک&zwnj;تر شده است. با درنظرگرفتن جای قلم در بدنه&zwnj;ی&zwnj; نوت5، این گوشی نزدیک به 7.6 میلی&zwnj;متر ضخامت دارد که در مقایسه با نسل قبلی&zwnj;اش باریک&zwnj;تر هم شده است. در کنار طراحی عالی و چشم&zwnj;نواز نوت5، برای این گوشی نمایشگری از نوع اولد با فناوری سوپر امولد با رزولوشن 2560 در 1440 و تراکم 518 پیکسل بر هر اینچ در نظر گرفته شده است. سامسونگ برای محافظت از این نمایشگر 5.7 اینچی که از نظر اندازه با نسل قبلی&zwnj;اش متفاوت نیست، از محافظ&zwnj;های گوریلاگلس نسخه&zwnj;ی چهارم بهره برده است. تراشه&zwnj;ی نوت5 همان تراشه&zwnj;ی اختصاصی سامسونگ اگزینوس 7420 است که پیش&zwnj;تر در گلکسی S6 هم استفاده شده بود.</p>\r\n\";s:12:\"tedad_mojood\";s:2:\"10\";s:8:\"discount\";s:2:\"20\";s:7:\"special\";s:1:\"1\";s:12:\"time_special\";s:10:\"1472645521\";s:13:\"onlyclicksite\";s:1:\"1\";s:5:\"viewd\";s:1:\"0\";s:6:\"colors\";s:3:\"2,3\";s:8:\"garantee\";s:3:\"1,2\";s:10:\"idcategory\";s:1:\"0\";s:6:\"weight\";s:2:\"10\";s:10:\"colorTitle\";N;s:13:\"garanteeTitle\";N;s:13:\"discountTotal\";i:1200;}}', 'خیابان 2 پلا 10', 5951, 1, 1, 0, 4, 0, 0, 0, '', '', 0, 0, 1472663909, '', '', '', '1395/6/7');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_order_status`
--

CREATE TABLE `tbl_order_status` (
  `id` int(255) NOT NULL,
  `title` varchar(255) COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_order_status`
--

INSERT INTO `tbl_order_status` (`id`, `title`) VALUES
(1, 'در انتظار تایید'),
(2, 'تایید شده'),
(3, 'در انتظار پرداخت'),
(4, 'پرداخت شده'),
(5, 'در حال پردازش انبار'),
(6, 'آماده ارسال'),
(7, 'ارسال شده');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_pay_type`
--

CREATE TABLE `tbl_pay_type` (
  `id` int(255) NOT NULL,
  `title` varchar(255) COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_pay_type`
--

INSERT INTO `tbl_pay_type` (`id`, `title`) VALUES
(1, 'زرین پال'),
(2, 'ملت'),
(3, 'سامان'),
(4, 'کارت به کارت');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_post_type`
--

CREATE TABLE `tbl_post_type` (
  `id` int(255) NOT NULL,
  `title` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `description` text COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_post_type`
--

INSERT INTO `tbl_post_type` (`id`, `title`, `description`) VALUES
(1, 'پست پیشتاز - 24 ساعته', 'زمان ارسال بین 24 تا حداکثر الی 72 ساعت'),
(2, 'پست سفارشی', 'زمان ارسال بین 72 ساعت الی یک هفته');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_product`
--

CREATE TABLE `tbl_product` (
  `id` int(255) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL,
  `price` int(10) NOT NULL,
  `cat` varchar(255) COLLATE utf32_persian_ci NOT NULL,
  `introduction` text COLLATE utf32_persian_ci NOT NULL,
  `tedad_mojood` int(255) NOT NULL,
  `discount` int(11) NOT NULL,
  `special` int(11) NOT NULL,
  `prevprice` int(11) DEFAULT NULL,
  `time_special` int(255) NOT NULL,
  `onlyclicksite` int(1) NOT NULL,
  `viewd` int(255) NOT NULL,
  `time` int(11) NOT NULL,
  `sell` int(11) NOT NULL,
  `colors` varchar(255) COLLATE utf32_persian_ci NOT NULL,
  `garantee` varchar(255) COLLATE utf32_persian_ci NOT NULL,
  `idcategory` int(255) NOT NULL,
  `weight` int(255) NOT NULL,
  `image` text COLLATE utf32_persian_ci NOT NULL,
  `rating_item` text COLLATE utf32_persian_ci NOT NULL,
  `rating` varchar(5) COLLATE utf32_persian_ci NOT NULL,
  `properties` text COLLATE utf32_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_persian_ci;

--
-- Dumping data for table `tbl_product`
--

INSERT INTO `tbl_product` (`id`, `title`, `price`, `cat`, `introduction`, `tedad_mojood`, `discount`, `special`, `prevprice`, `time_special`, `onlyclicksite`, `viewd`, `time`, `sell`, `colors`, `garantee`, `idcategory`, `weight`, `image`, `rating_item`, `rating`, `properties`) VALUES
(1, 'گوشی سامسونگ مدل Galaxy Note 5', 2500000, 'کالای دیجیتال', '<p>امکان&zwnj; یادداشت&zwnj;برداری با قلم، صفحه&zwnj;نمایش بزرگ و سخت&zwnj;افزار قدرتمند از ویژگی&zwnj;های گوشی&zwnj;های سری نوت سامسونگ هستند. بعد از تولید چهار نسل موفق از این گوشی، نسل پنجم با تغییراتی کم&zwnj;وبیش بزرگ طراحی و ساخته شد. شماری از این تغییرات، کم&zwnj;وکاستی&zwnj;های سری&zwnj;های قبل را پوشش داده&zwnj;اند؛ البته تغییراتی هم باعث حذف قابلیت&zwnj;های محبوب و کاربردی گوشی&zwnj;های قبلی این سری شده&zwnj;اند. گوشی &laquo;سامسونگ گلکسی نوت 5&raquo; (Samsung galaxy Note5) برخلاف گوشی&zwnj;های قبلی سامسونگ در همین سری، بدنه&zwnj;ای از جنس فلز و شیشه دارد. این بدنه&zwnj;ی فلزی باعث شده تا وزن نوت پنجم 171 گرم شود که در مقایسه با وزن نوت 4، چند گرمی سبک&zwnj;تر شده است. با درنظرگرفتن جای قلم در بدنه&zwnj;ی&zwnj; نوت5، این گوشی نزدیک به 7.6 میلی&zwnj;متر ضخامت دارد که در مقایسه با نسل قبلی&zwnj;اش باریک&zwnj;تر هم شده است. در کنار طراحی عالی و چشم&zwnj;نواز نوت5، برای این گوشی نمایشگری از نوع اولد با فناوری سوپر امولد با رزولوشن 2560 در 1440 و تراکم 518 پیکسل بر هر اینچ در نظر گرفته شده است. سامسونگ برای محافظت از این نمایشگر 5.7 اینچی که از نظر اندازه با نسل قبلی&zwnj;اش متفاوت نیست، از محافظ&zwnj;های گوریلاگلس نسخه&zwnj;ی چهارم بهره برده است. تراشه&zwnj;ی نوت5 همان تراشه&zwnj;ی اختصاصی سامسونگ اگزینوس 7420 است که پیش&zwnj;تر در گلکسی S6 هم استفاده شده بود.</p>\n', 10, 300000, 1, 12000, 1472645521, 1, 1325, 125469576, 1200, 'سفید', 'گارانتی یک ساله آوا', 0, 10, 'https://dkstatics-public.digikala.com/digikala-products/5489218.jpg?x-oss-process=image/resize,m_lfit,h_500,w_500/quality,q_80', '[{\r\n  \"title\": \"کیفیت و طراحی\",\r\n  \"value\": \"3.5\"\r\n},{\r\n  \"title\": \"ارزش خرید \",\r\n  \"value\": \"4.2\"\r\n},{\r\n  \"title\": \"خلاقیت و نو آوری\",\r\n  \"value\": \"3.9\"\r\n},{\r\n  \"title\": \"راحتی در استفاده\",\r\n  \"value\": \"3.5\"\r\n}]', '3.5', '[{   \"ابعاد\": \"128.9*76.5*8.1\"},   {\"وزن\": \"168 گرم\"},   {\"ویژگی\": \"مجهز به حسگر اثر انگشت\"},   {\"تعداد\": \"دو سیم کارت\"},   {\"تراشه\": \"اسنپدراگون\"},   {\"حافظه\": \"32 گیگا بایت\"},   {\"مقدار\": \"3 گیگا بایت\"},   {\"دوربین\": \"32 مگاپیکسل\"},   {\"بلندگو\": \"دارد\"},   {\"هندزفری\": \"دارد\" }]'),
(2, ' تلویزیونLG مدل 24MT45000', 12000000, 'لوازم خانگی', '<p>این روزها در عمق شکل&zwnj;گیری محصولات چندمنظوره به سر می&zwnj;بریم. گوشی موبایل هوشمندی که قادر است دستور روشن&zwnj;شدن (Start Engine) خودروی هشت&zwnj;سیلندر شما را بدهد یا بعد از یک شام لذت&zwnj;بخش، نقش درگاه مطمئنی را برای پرداخت از کارت نقدی شما بازی کند. در ازدحام چندکاره&zwnj;شدن محصولاتی که پیرامون ما هستند، چندان عجیب نیست اگر یک تلویزیون 24 اینچی، نقش مانیتور را بازی کند یا بالعکس. محصول نه&zwnj;&lrm;چندان جدید ال&zwnj;جی یک تلویزیون &ndash; مانیتور مبتنی بر LED است که در بدنه&zwnj;ای یکپارچه سیاه، نقش&zwnj;آفرینی می&zwnj;کند. دو اسپیکر 5 واتی دارد که برای برنامه&zwnj;های مختلفی که روی شبکه&zwnj;&lrm;های نمایش سراسری پخش می&zwnj;شوند، صدای قابل&zwnj;توجهی تولید می&zwnj;کنند. شما می&zwnj;توانید به جای استفاده از اسپیکر روی کامپیوتر شخصی خود از همین اسپیکرها استفاده کنید. در پشت این قاب، تنوع مناسبی از درگاه&zwnj;های مختلف را خواهید یافت که مشتمل بر ورودی HDMI، کامپوزیت، کامپوننت و یا VGA است. در کنار آن ورودی صدا و درگاه USB را خواهید داشت. این تلویزیون &ndash; مانیتور خوش&zwnj;ساخت که وزن کمی دارد، انتخابی هوشمندانه خواهد بود برای کسانی که می&zwnj;خواهند روی میز کار خود تلویزیون کشورمان را هم تماشا کنند یا پا را فراتر گذاشته و بخواهند کنسول بازی، کامپیوتر و تلویزیون را هم&zwnj;زمان به یک نمایشگر متصل کنند و با هزینه&zwnj;ای معقول، لحظاتی متفاوت داشته باشند.</p>\r\n', 20, 700000, 1, 22100, 1472645521, 1, 918, 256428652, 203, 'مشکی', 'گارانتی دو ساله LG', 0, 30, 'https://dkstatics-public.digikala.com/digikala-products/3743099.jpg?x-oss-process=image/resize,m_lfit,h_500,w_500/quality,q_80', '[{\r\n  \"title\": \"شفافیت و وضوح\",\r\n  \"value\": \"4.5\"\r\n},{\r\n  \"title\": \"ارزش خرید\",\r\n  \"value\": \"3.2\"\r\n},{\r\n  \"title\": \"کارایی و کیفیت\",\r\n  \"value\": \"4.5\"\r\n}]', '4.2', ''),
(3, ' تبلت مایکروسافت Surface 3', 3600000, 'کالای دیجیتال', '<p>تبلت سرفیس پرو 3 از دید مجله تایم به عنوان یکی از 25 نوآوری سال 2014 معرفی شد؛ از این رو، معرفی مدلی جدید و گسترش فروش تبلت&zwnj;های سرفیس از سوی مایکروسافت چندان عجیب نیست. سرفیس 3 دارای صفحه نمایشی 10.8 اینچی با رزولوشن 1280 &times; 1920 پیکسل و نسبت صفحه نمایش 3:2 است. لازم به ذکر است که صفحه نمایش نسخه پرو (Pro) هم همین نسبت تصویر 3:2 را دارد.<br />\r\nمایکروسافت یک پردازنده اینتل اتم x7 چهار هسته&zwnj;ای را برای تبلت جدیدش برگزیده است. از دیگر ویژگی&zwnj;های این تبلت می&zwnj;توان به دوربین پشتی 8 مگاپیکسلی، دوربین جلوی 3.5 مگاپیکسلی، باتری با شارژ 10 ساعت، درگاه Full USB و micorSD اشاره کرد. قلم نوری مشهور مایکروسافت هم در کنار سرفیس 3 حضور دارد.<br />\r\nبر روی این تبلت ویندوز 10 اجرا می&zwnj;شود. همچنین مجموعه کامل آفیس، یک سال سرویس اشتراک آفیس 365 و یک ترابایت حافظه ابری One Drive هم از سرویس&zwnj;های هستند که با خرید این تبلت در اختیارتان قرار می&zwnj;گیرد.<br />\r\nسرفیس 3 در دو کانفیگ اصلی با حافظه&zwnj;های داخلی 64 گیگابایت و 128 گیگابایت به بازار راه پیدا می&zwnj;کند. مدل 64 گیگابایتی 2 گیگابایت رم و مدل 128 گیگابایتی 4 گیگابایت رم دارد. در ضمن این تبلت در مدل LTE هم به بازار راه پیدا می&zwnj;کند. لوازم جانبی مانند Type Cover محبوب مایکروسافت هم برای تبدیل تبلت به لپ&zwnj;تاپ ارایه شده است.</p>\r\n', 10, 150000, 1, 11000, 1472645521, 1, 440, 256001247, 879, 'مشکی', 'گارانتی یک ساله آوا', 0, 50, 'https://dkstatics-public.digikala.com/digikala-products/5177864.jpg?x-oss-process=image/resize,m_lfit,h_500,w_500/quality,q_80', '[{\r\n  \"title\": \"کیفیت و طراحی\",\r\n  \"value\": \"3.5\"\r\n},{\r\n  \"title\": \"ارزش خرید \",\r\n  \"value\": \"4.2\"\r\n},{\r\n  \"title\": \"خلاقیت و نو آوری\",\r\n  \"value\": \"3.9\"\r\n},{\r\n  \"title\": \"راحتی در استفاده\",\r\n  \"value\": \"3.5\"\r\n}]', '3.8', '[{   \"ابعاد\": \"128.9*76.5*8.1\"},   {\"وزن\": \"168 گرم\"},   {\"ویژگی\": \"مجهز به حسگر اثر انگشت\"},   {\"تعداد\": \"دو سیم کارت\"},   {\"تراشه\": \"اسنپدراگون\"},   {\"حافظه\": \"32 گیگا بایت\"},   {\"مقدار\": \"3 گیگا بایت\"},   {\"دوربین\": \"32 مگاپیکسل\"},   {\"بلندگو\": \"دارد\"},   {\"هندزفری\": \"دارد\" }]'),
(4, 'تبلت آمازون Fire HD 10 ', 5600000, 'کالای دیجیتال', '<p>اگر به دنبال بزرگ&zwnj;ترین و مقرون&zwnj;به&zwnj;صرفه&zwnj;ترین تبلت شرکت آمازون هستید که از قدرت پردازشی قابل قبولی برخوردار باشد، مطمئنا &laquo;آمازون فایر اچ&zwnj;دی 10&quot; اولین و تنها انتخاب شما خواهد بود. به&zwnj;طور خلاصه برجسته&zwnj;ترین ویژگی این محصول را می&zwnj;توان در نمایشگر بزرگ، اسپیکرهای باکیفیت و قیمت مناسب آن دانست. بنابراین می&zwnj;توان این دستگاه را مناسب برای کاربرانی دانست که به دنبال تجربه&zwnj;ی بی&zwnj;نظیری از تماشای ویدئو در تبلتی بزرگ هستند.<br />\r\nهمان&zwnj;طور که از نام این محصول پیداست، فایر اچ&zwnj;دی 10 به یک نمایشگر بزرگ 10 اینچی با فناوری IPS مجهز شده و از زوایای دید مطلوبی برخوردار است. آمازون از رزولوشن یکسانی برای دو نسخه&zwnj;ی 8 و 10 اینچی این تبلت در نظر گرفته است. اما به دلیل نمایشگر بزرگ&zwnj;تر نسخه&zwnj;ی 10 اینچی، دقت تصویر 800 &times; 1280 پیکسلی آن تراکم پیکسلی پایین&zwnj; 149 پیکسل بر اینچ را به همراه دارد. تراشه&zwnj;ی مدیاتک نسخه&zwnj;ی MT8135 به همراه دو پردازنده&zwnj;ی دو هسته&zwnj;ای با سرعت&zwnj;های 1.2 و 1.5 گیگاهرتز، مسئولیت اجرای سیستم&zwnj;عامل Fire OS نسخه&zwnj;ی 5 و برنامه&zwnj;های آن را دارند. البته استفاده از رم یک گیگابایتی در این محصول می&zwnj;تواند محدودیت&zwnj;های را برای کاربران این تبلت داشته باشد. از ویژگی&zwnj;های مهم این تبلت می&zwnj;توان به وجود اسپیکرهای استریو به فناوری دالبی و دوربین&zwnj;های 5 و 1 مگاپیکسلی اشاره کرد. همچنین آمازون از یک باتری لیتیوم پلیمری برای این محصول در نظر گرفته که می&zwnj;تواند در کاربری&zwnj;های ترکیبی و مداوم تا بیش از 8 ساعت شارژ نگاه دارد.</p>\r\n', 50, 1050000, 1, 15000, 1472645521, 1, 222, 330215899, 42252, 'مشکی', 'گارانتی دو ساله آوا', 0, 2000, 'https://dkstatics-public.digikala.com/digikala-products/79966.jpg?x-oss-process=image/resize,m_lfit,h_500,w_500/quality,q_80', '[{\r\n  \"title\": \"کیفیت و طراحی\",\r\n  \"value\": \"3.5\"\r\n},{\r\n  \"title\": \"ارزش خرید \",\r\n  \"value\": \"4.2\"\r\n},{\r\n  \"title\": \"خلاقیت و نو آوری\",\r\n  \"value\": \"3.9\"\r\n},{\r\n  \"title\": \"راحتی در استفاده\",\r\n  \"value\": \"3.5\"\r\n}]', '4.8', '[{   \"ابعاد\": \"128.9*76.5*8.1\"},   {\"وزن\": \"168 گرم\"},   {\"ویژگی\": \"مجهز به حسگر اثر انگشت\"},   {\"تعداد\": \"دو سیم کارت\"},   {\"تراشه\": \"اسنپدراگون\"},   {\"حافظه\": \"32 گیگا بایت\"},   {\"مقدار\": \"3 گیگا بایت\"},   {\"دوربین\": \"32 مگاپیکسل\"},   {\"بلندگو\": \"دارد\"},   {\"هندزفری\": \"دارد\" }]'),
(5, 'مانیتور و TV LG 22MA530D', 8230000, 'لوازم خانگی', '<p>&bull; 22MA530D یکی از جدیدترین محصولات ال جی است که در اوایل سال 2014 میلادی به بازار آمده است. این محصول دو کاربرد دارد یعنی هم مانیتور است و هم تلویزیون همچنین قادر است سرگرمی&zwnj;های صوتی و تصویری متنوعی از قبیل برنامه&zwnj;های HD, DVD گردش در اینترنت، بازی&zwnj; و مشاهده ویدیو و عکس&zwnj; را به شما ارایه دهد. پنل این نمایشگر از تکنولوژی IPS بهره می&zwnj;برد که باعث ثبات شدت رنگ و کاهش تغییرات آن می&zwnj;شود بنابراین می&zwnj;توان گفت این قابلیت، رنگ را نزدیک به تصویر اصلی به شما ارایه می&zwnj;دهد. صفحه نمایش IPS این محصول به شما امکان بهره&zwnj;مندی از کیفیت تصویر واقعی بدون تغییر رنگ در حالت ایستاده یا خوابیده را ارایه می&zwnj;کند همچنین تصاویری شفاف با تغییرات نرم و تدریجی رنگ را برای شما به ارمغان می&zwnj;آورد. این نمایشگر شما را از هر محتوایی را از قبیل فیلم، گشت و گذار در اینترنت و انجام بازی&zwnj;های RPG برای مدت زمان طولانی و در عین حال راحت ...</p>\n', 100, 500000, 1, 14250, 1472645521, 1, 1188, 744594322, 706, 'مشکی', 'گارنتی 36 ماهه آوا', 0, 0, 'https://dkstatics-public.digikala.com/digikala-products/3613398.jpg?x-oss-process=image/resize,m_lfit,h_500,w_500/quality,q_80', '[{\r\n  \"title\": \"شفافیت و وضوح\",\r\n  \"value\": \"4.5\"\r\n},{\r\n  \"title\": \"ارزش خرید\",\r\n  \"value\": \"3.2\"\r\n},{\r\n  \"title\": \"کارایی و کیفیت\",\r\n  \"value\": \"4.5\"\r\n}]', '4.5', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_product_attr`
--

CREATE TABLE `tbl_product_attr` (
  `id` int(255) NOT NULL,
  `idproduct` int(255) NOT NULL,
  `idattr` int(255) NOT NULL,
  `idval` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_product_attr`
--

INSERT INTO `tbl_product_attr` (`id`, `idproduct`, `idattr`, `idval`) VALUES
(13, 17, 2, 14),
(14, 17, 4, 10),
(15, 17, 11, 17),
(16, 17, 12, 21),
(17, 17, 15, 20),
(18, 16, 2, 13),
(19, 16, 4, 8),
(20, 16, 11, 17),
(21, 16, 12, 22),
(22, 16, 15, 19),
(23, 1, 17, 29),
(24, 1, 18, 27),
(25, 1, 19, 25),
(26, 1, 20, 23);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_question`
--

CREATE TABLE `tbl_question` (
  `id` int(255) NOT NULL,
  `matn` text COLLATE utf8_persian_ci NOT NULL,
  `tarikh` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `userid` int(255) NOT NULL,
  `parent` int(255) NOT NULL,
  `idproduct` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_question`
--

INSERT INTO `tbl_question` (`id`, `matn`, `tarikh`, `userid`, `parent`, `idproduct`) VALUES
(1, 'سوال اول در مورد کیفیت دوربین است', '20/13000', 1, 0, 8),
(2, 'پاسخ سوال اول این است که کیفیت دوربین....', '21/1300', 0, 1, 8);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_slider1`
--

CREATE TABLE `tbl_slider1` (
  `id` int(255) NOT NULL,
  `img` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `link` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `title` varchar(255) COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_slider1`
--

INSERT INTO `tbl_slider1` (`id`, `img`, `link`, `title`) VALUES
(1, 'public/images/slider1.jpg', 'http://clicksite.ir', 'لوازم بهداشتی'),
(5, 'public/images/slider5.jpg', 'http://clicksite.ir', 'اسباب بازی'),
(6, 'public/images/slider/1472643205.jpg', 'http://clicksite.ir', 'لوازم خانگی'),
(7, 'public/images/slider/1472643237.jpg', 'http://clicksite.ir', 'انواع گوشی همراه'),
(8, 'public/images/slider/1472643259.jpg', 'http://clicksite.ir', 'انواع کفش');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id` int(255) NOT NULL,
  `email` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_persian_ci NOT NULL,
  `family` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `code_meli` varchar(10) COLLATE utf8_persian_ci NOT NULL,
  `tel` varchar(20) COLLATE utf8_persian_ci NOT NULL,
  `mobile` varchar(15) COLLATE utf8_persian_ci NOT NULL,
  `tavalod` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `address` text COLLATE utf8_persian_ci NOT NULL,
  `jensiat` int(1) NOT NULL,
  `khabarname` int(1) NOT NULL,
  `level` int(1) NOT NULL,
  `tarikh` varchar(30) COLLATE utf8_persian_ci NOT NULL,
  `token` text COLLATE utf8_persian_ci NOT NULL,
  `refresh_token` text COLLATE utf8_persian_ci NOT NULL,
  `expire` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`id`, `email`, `password`, `name`, `family`, `code_meli`, `tel`, `mobile`, `tavalod`, `address`, `jensiat`, `khabarname`, `level`, `tarikh`, `token`, `refresh_token`, `expire`) VALUES
(1, 'info@clicksite.ir', '1234', 'مجتبی', 'نکویی ', '111111111', '021665656', '09396562210', '1360/12/15', 'آدرس سکونت', 1, 0, 1, '', 'da39a3ee5e6b4b0d3255bfef95601890afd80709c1852c809ddfd5916d762c7c7463bc88dcd55efc', '54a5d31ed2912197e88ddbdc5e6b0c7d81d548074855c995cbbc407cea809ecc5f1601d9', '2021-05-29'),
(11, 'test@clicksite.ir', '1234', 'mojtaba', 'nekooei', '444444444', '333333333', '09363333333', '6/شهریور/1386', '', 1, 1, 0, '', 'da39a3ee5e6b4b0d3255bfef95601890afd807096178b2d9bf777bf426ccb159041f14274306128e', '0d13bfc972f30c95e9e201c590d93824e2e2452ac023a89bfa99cc12ccea9d6b5d6251cd', '2021-04-07'),
(37, 'newemail@gmail.com', '123456', '', '', '', '', '', '', '', 0, 0, 0, '', '84b53f0700645fef7de6258b793535eee7d5c2ed4a797110747e5f255777403e975687d9488dd2125930d5faebf0a423cc17d8c55d043d24', '0261bf6bbf19c6205da64c2fe4ed6e9af9ee9bcb4492d2b080bfa65cf03b240aa2adf1b1', '2021-04-07'),
(38, 'email@gmail.com', '123456', '', '', '', '', '', '', '', 0, 0, 0, '', 'c4d7c9391408759bcc3eaf7c75e252cf91003d2b1c4d581728f2e2ed3490e4a4f7231d3df61f20b9623739ca3bf4fe9274544708283c6af2', '1fe427cce7e911b81e532261d71f4ebb9d4f8cedfd4d4508dbef18837e7c096f809efaf0', '2021-04-07');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user_address`
--

CREATE TABLE `tbl_user_address` (
  `id` int(255) NOT NULL,
  `userid` int(255) NOT NULL,
  `family` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `mobile` varchar(20) COLLATE utf8_persian_ci NOT NULL,
  `tel` varchar(30) COLLATE utf8_persian_ci NOT NULL,
  `ostan` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `city` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `mahale` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `address` text COLLATE utf8_persian_ci NOT NULL,
  `codeposti` varchar(30) COLLATE utf8_persian_ci NOT NULL,
  `ostan_name` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `city_name` varchar(255) COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_user_address`
--

INSERT INTO `tbl_user_address` (`id`, `userid`, `family`, `mobile`, `tel`, `ostan`, `city`, `mahale`, `address`, `codeposti`, `ostan_name`, `city_name`) VALUES
(3, 1, 'محمد امینی', '09396562210', '021666335', '30', '971', '', 'خیابان 2 پلا 10', '21287192718', 'خراسان جنوبي', 'بیرجند'),
(4, 1, 'محمد امینی', '09396562210', '021666335', '1', '1', '', 'خیابان 2 پلا 10', '21287192718', 'تهران', 'تهران');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user_level`
--

CREATE TABLE `tbl_user_level` (
  `id` int(255) NOT NULL,
  `title` varchar(255) COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tbl_user_level`
--

INSERT INTO `tbl_user_level` (`id`, `title`) VALUES
(1, 'مدیر اصلی'),
(2, 'کارمند'),
(3, 'کاربر عادی');

-- --------------------------------------------------------

--
-- Table structure for table `timer`
--

CREATE TABLE `timer` (
  `id` int(11) NOT NULL,
  `hour` int(11) NOT NULL,
  `min` int(11) NOT NULL,
  `sec` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `timer`
--

INSERT INTO `timer` (`id`, `hour`, `min`, `sec`) VALUES
(1102, 12, 13, 29),
(1103, 12, 13, 28),
(1104, 12, 13, 27),
(1105, 12, 13, 26),
(1106, 12, 13, 25);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `app_basket`
--
ALTER TABLE `app_basket`
  ADD PRIMARY KEY (`basket_id`);

--
-- Indexes for table `app_order`
--
ALTER TABLE `app_order`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_attr`
--
ALTER TABLE `tbl_attr`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_attr_val`
--
ALTER TABLE `tbl_attr_val`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_banner`
--
ALTER TABLE `tbl_banner`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_basket`
--
ALTER TABLE `tbl_basket`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_category`
--
ALTER TABLE `tbl_category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_cat_param`
--
ALTER TABLE `tbl_cat_param`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_code`
--
ALTER TABLE `tbl_code`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_color`
--
ALTER TABLE `tbl_color`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_comment`
--
ALTER TABLE `tbl_comment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_comment_param`
--
ALTER TABLE `tbl_comment_param`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_favorit`
--
ALTER TABLE `tbl_favorit`
  ADD PRIMARY KEY (`fav_id`);

--
-- Indexes for table `tbl_gallery`
--
ALTER TABLE `tbl_gallery`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_garantee`
--
ALTER TABLE `tbl_garantee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_message`
--
ALTER TABLE `tbl_message`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_naghd`
--
ALTER TABLE `tbl_naghd`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_option`
--
ALTER TABLE `tbl_option`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_order`
--
ALTER TABLE `tbl_order`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_order_status`
--
ALTER TABLE `tbl_order_status`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_pay_type`
--
ALTER TABLE `tbl_pay_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_post_type`
--
ALTER TABLE `tbl_post_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_product`
--
ALTER TABLE `tbl_product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_product_attr`
--
ALTER TABLE `tbl_product_attr`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_question`
--
ALTER TABLE `tbl_question`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_slider1`
--
ALTER TABLE `tbl_slider1`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_user_address`
--
ALTER TABLE `tbl_user_address`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_user_level`
--
ALTER TABLE `tbl_user_level`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `timer`
--
ALTER TABLE `timer`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `app_basket`
--
ALTER TABLE `app_basket`
  MODIFY `basket_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `app_order`
--
ALTER TABLE `app_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbl_attr`
--
ALTER TABLE `tbl_attr`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `tbl_attr_val`
--
ALTER TABLE `tbl_attr_val`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `tbl_banner`
--
ALTER TABLE `tbl_banner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tbl_basket`
--
ALTER TABLE `tbl_basket`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `tbl_category`
--
ALTER TABLE `tbl_category`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `tbl_cat_param`
--
ALTER TABLE `tbl_cat_param`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_code`
--
ALTER TABLE `tbl_code`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_color`
--
ALTER TABLE `tbl_color`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_comment`
--
ALTER TABLE `tbl_comment`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `tbl_comment_param`
--
ALTER TABLE `tbl_comment_param`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tbl_favorit`
--
ALTER TABLE `tbl_favorit`
  MODIFY `fav_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `tbl_gallery`
--
ALTER TABLE `tbl_gallery`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `tbl_garantee`
--
ALTER TABLE `tbl_garantee`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_message`
--
ALTER TABLE `tbl_message`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_naghd`
--
ALTER TABLE `tbl_naghd`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_option`
--
ALTER TABLE `tbl_option`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tbl_order`
--
ALTER TABLE `tbl_order`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `tbl_order_status`
--
ALTER TABLE `tbl_order_status`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbl_pay_type`
--
ALTER TABLE `tbl_pay_type`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_post_type`
--
ALTER TABLE `tbl_post_type`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_product`
--
ALTER TABLE `tbl_product`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_product_attr`
--
ALTER TABLE `tbl_product_attr`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `tbl_question`
--
ALTER TABLE `tbl_question`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_slider1`
--
ALTER TABLE `tbl_slider1`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `tbl_user_address`
--
ALTER TABLE `tbl_user_address`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_user_level`
--
ALTER TABLE `tbl_user_level`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `timer`
--
ALTER TABLE `timer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1107;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
