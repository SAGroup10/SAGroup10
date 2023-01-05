-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1:3307
-- 產生時間： 2023-01-05 14:38:23
-- 伺服器版本： 10.4.14-MariaDB
-- PHP 版本： 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `missa`
--

-- --------------------------------------------------------

--
-- 資料表結構 `tbl_administrator`
--

CREATE TABLE `tbl_administrator` (
  `administrator_id` int(10) UNSIGNED NOT NULL,
  `name` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `pwd` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 傾印資料表的資料 `tbl_administrator`
--

INSERT INTO `tbl_administrator` (`administrator_id`, `name`, `email`, `pwd`) VALUES
(1, '陳小姍', 'aaaa1111@gmail.com', 'aaaa1111'),
(2, '何小瑄', 'bbbb2222@gmail.com', 'bbbb2222'),
(3, '盧小澐', 'cccc3333@gmail.com', 'cccc3333'),
(4, '林小慧', 'dddd4444@gmail.com', 'dddd4444'),
(5, '徐小睿', 'eeee5555@gmail.com', 'eeee5555'),
(6, '吳小廷', 'ffff6666@gmail.com', 'ffff6666'),
(7, '劉小怡', 'gggg7777@gmail.com', 'gggg7777');

-- --------------------------------------------------------

--
-- 資料表結構 `tbl_adoption_request`
--

CREATE TABLE `tbl_adoption_request` (
  `adoption_request_id` int(10) UNSIGNED NOT NULL,
  `for_adoption_id` int(10) UNSIGNED NOT NULL,
  `member_id` int(10) UNSIGNED NOT NULL,
  `real_name` varchar(45) NOT NULL,
  `address` varchar(60) NOT NULL,
  `email` varchar(100) NOT NULL,
  `status` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 傾印資料表的資料 `tbl_adoption_request`
--

INSERT INTO `tbl_adoption_request` (`adoption_request_id`, `for_adoption_id`, `member_id`, `real_name`, `address`, `email`, `status`) VALUES
(1, 1, 2, '劉小二', '台南市佳里區信義二街3號', '2222bbbb@gmail.com', '已通過'),
(2, 2, 4, '江小四', '桃園市平鎮區湧峯路33號', '4444dddd@gmail.com', '已通過'),
(3, 6, 1, '張小一', '高雄市鳳山區福誠三街9號', '1111aaaa@gmail.com', '未通過'),
(4, 6, 5, '許小五', '高雄市旗山區福安路3號', '5555eeee@gmail.com', '已通過'),
(5, 3, 7, '陳小七', '新北市中和區壽德街1號', '7777gggg@gmail.com', '未通過'),
(6, 7, 8, '李小八', '台中市大里區翠堤路9號', '8888hhhh@gmail.com', '已通過'),
(7, 9, 3, '吳小三', '新北市土城區自由街29號', '3333cccc@gmail.com', '未通過'),
(8, 8, 6, '曾小六', '台北市士林區通河東街8號', '6666ffff@gmail.com', '已通過'),
(9, 9, 6, '曾小六', '台北市士林區通河東街8號', '6666ffff@gmail.com', '已通過'),
(10, 10, 10, '王小十', '新北市淡水區新生街23號', '1010jjjj@gmail.com', '申請中'),
(11, 4, 6, '曾小六', '台北市士林區通河東街8號', '6666ffff@gmail.com', '申請中'),
(16, 2, 1, '楊大名', '台中市南屯區東興路二段171號', 'abc@gmail.com', '申請中');

-- --------------------------------------------------------

--
-- 資料表結構 `tbl_favorite_list`
--

CREATE TABLE `tbl_favorite_list` (
  `favorite_list_id` int(10) UNSIGNED NOT NULL,
  `member_id` int(10) UNSIGNED NOT NULL,
  `for_adoption_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 傾印資料表的資料 `tbl_favorite_list`
--

INSERT INTO `tbl_favorite_list` (`favorite_list_id`, `member_id`, `for_adoption_id`) VALUES
(1, 4, 2),
(2, 1, 6),
(3, 9, 7),
(4, 6, 8),
(5, 6, 9),
(6, 3, 8),
(7, 3, 9),
(8, 10, 10),
(9, 8, 4),
(10, 8, 9);

-- --------------------------------------------------------

--
-- 資料表結構 `tbl_for_adoption`
--

CREATE TABLE `tbl_for_adoption` (
  `for_adoption_id` int(10) UNSIGNED NOT NULL,
  `name` varchar(45) NOT NULL,
  `species` varchar(2) NOT NULL,
  `breed` varchar(30) DEFAULT NULL,
  `age` int(10) UNSIGNED DEFAULT NULL,
  `gender` varchar(2) NOT NULL,
  `size` varchar(1) NOT NULL,
  `exterior` varchar(30) DEFAULT NULL,
  `ligation` varchar(3) NOT NULL,
  `area` varchar(30) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `img_path` varchar(200) NOT NULL,
  `status` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 傾印資料表的資料 `tbl_for_adoption`
--

INSERT INTO `tbl_for_adoption` (`for_adoption_id`, `name`, `species`, `breed`, `age`, `gender`, `size`, `exterior`, `ligation`, `area`, `description`, `img_path`, `status`) VALUES
(1, '淑芬', '鳥', '和尚鸚鵡', 2, '雌', '小', '背部藍色、腹部灰色、眼睛周圍一圈白色', '無', '台南市', '朋友寄養在我家，但她跑路了...牠很聰明也很乖，希望有人能給她幸福的後半生', '1.jpg', '已領養'),
(2, '家豪', '其他', '歐洲刺蝟', 1, '雄', '小', '巧克力色', '有', '桃園市', '個性膽小不親人，願意領養的話會把旭要的東西一並給出', '2.jpg', '已領養'),
(3, '胖胖', '貓', '米克斯', 3, '雄', '中', '橘色、胖', '有', '新北市', '在我家中途的貓咪，很親人、不親貓，有零食你就是老大，這麼讚的貓不養嗎？(但不要給牠吃太多喔！', '3.jpg', '未領養'),
(4, '憨吉', '狗', '米克斯', 0, '雄', '大', '橘色、垂耳', '不曉得', '台北市', '牠是浪浪，常常在我家旁邊的公園出沒，牠很聰明、很親人，希望有人能領養牠，讓牠有個溫暖的家', '4.jpg', '未領養'),
(5, '土豆', '鼠', '黃金鼠', 1, '雌', '小', '橘黃色', '有', '高雄市', '因為室友過敏，又無法帶回家飼養，故希望找個可以飼養的人領養', '5.jpg', '未領養'),
(6, '饅頭', '貓', '俄羅斯藍貓', 7, '雌', '中', '胖胖的', '有', '高雄市', '因為家裡誕生新生命，婆家堅持不讓養，只能把養了7年的貓送養了...希望有有能力的人可以領養，讓牠下半輩子無憂無慮', '6.jpg', '已領養'),
(7, '貢丸', '其他', '球蟒', 7, '雄', '小', '白色、側面有淡黃色的線', '無', '台中市', '因家中變故，希望有人能領養，有飼養上的問題也會盡力協助', '7.jpg', '已領養'),
(8, '滷蛋', '狗', '拉不拉多', 6, '雄', '大', '', '有', '台北市', '因為工作的緣故需要送養家裡的狗狗，牠和肉鬆是好朋友，希望能夠一起領養', '8.jpg', '已領養'),
(9, '肉鬆', '狗', '黃金獵犬', 3, '雌', '大', '', '有', '台北市', '因為工作的緣故需要送養家裡的狗狗，牠和滷蛋是好朋友，希望能夠一起領養', '9.jpg', '已領養'),
(10, '花花', '龜', '豹紋陸龜', 23, '雌', '中', '背上有斑紋', '無', '新北市', '因為全家要移民不能再飼養，希望能有好心人接手。', '10.jpg', '未領養');

-- --------------------------------------------------------

--
-- 資料表結構 `tbl_for_adoption_management`
--

CREATE TABLE `tbl_for_adoption_management` (
  `for_adoption_management_id` int(10) UNSIGNED NOT NULL,
  `administrator_id` int(10) UNSIGNED NOT NULL,
  `for_adoption_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 傾印資料表的資料 `tbl_for_adoption_management`
--

INSERT INTO `tbl_for_adoption_management` (`for_adoption_management_id`, `administrator_id`, `for_adoption_id`) VALUES
(1, 1, 1),
(2, 7, 1),
(3, 4, 2),
(4, 2, 3),
(5, 5, 2),
(6, 1, 4),
(7, 6, 5),
(8, 3, 6),
(9, 3, 7),
(10, 2, 6),
(11, 7, 8),
(12, 7, 9),
(13, 5, 7),
(14, 6, 8),
(15, 6, 9),
(16, 4, 10);

-- --------------------------------------------------------

--
-- 資料表結構 `tbl_member`
--

CREATE TABLE `tbl_member` (
  `member_id` int(10) UNSIGNED NOT NULL,
  `name` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `pwd` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 傾印資料表的資料 `tbl_member`
--

INSERT INTO `tbl_member` (`member_id`, `name`, `email`, `pwd`) VALUES
(1, '阿一', '1111aaaa@gmail.com', '1111aaaa'),
(2, '阿二', '2222bbbb@gmail.com', '2222bbbb'),
(3, '阿三', '3333cccc@gmail.com', '3333cccc'),
(4, '阿四', '4444dddd@gmail.com', '4444dddd'),
(5, '阿五', '5555eeee@gmail.com', '5555eeee'),
(6, '阿六', '6666ffff@gmail.com', '6666ffff'),
(7, '阿七', '7777gggg@gmail.com', '7777gggg'),
(8, '阿八', '8888hhhh@gmail.com', '8888hhhh'),
(9, '阿九', '9999iiii@gmail.com', '9999iiii'),
(10, '阿十', '1010jjjj@gmail.com', '1010jjjj');

-- --------------------------------------------------------

--
-- 資料表結構 `tbl_member_management`
--

CREATE TABLE `tbl_member_management` (
  `member_management_id` int(10) UNSIGNED NOT NULL,
  `administrator_id` int(10) UNSIGNED NOT NULL,
  `member_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `tbl_administrator`
--
ALTER TABLE `tbl_administrator`
  ADD PRIMARY KEY (`administrator_id`),
  ADD UNIQUE KEY `id_UNIQUE` (`administrator_id`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`);

--
-- 資料表索引 `tbl_adoption_request`
--
ALTER TABLE `tbl_adoption_request`
  ADD PRIMARY KEY (`adoption_request_id`,`for_adoption_id`,`member_id`),
  ADD UNIQUE KEY `adoption_request_id_UNIQUE` (`adoption_request_id`),
  ADD KEY `tbl_member-member_id_idx` (`member_id`),
  ADD KEY `tbl_for_adoption-for_adoption_id_idx` (`for_adoption_id`);

--
-- 資料表索引 `tbl_favorite_list`
--
ALTER TABLE `tbl_favorite_list`
  ADD PRIMARY KEY (`favorite_list_id`,`member_id`,`for_adoption_id`),
  ADD KEY `tbl_member-member_id_idx` (`member_id`),
  ADD KEY `tbl_for_adoption-for_adoption_id_idx` (`for_adoption_id`);

--
-- 資料表索引 `tbl_for_adoption`
--
ALTER TABLE `tbl_for_adoption`
  ADD PRIMARY KEY (`for_adoption_id`),
  ADD UNIQUE KEY `id_UNIQUE` (`for_adoption_id`);

--
-- 資料表索引 `tbl_for_adoption_management`
--
ALTER TABLE `tbl_for_adoption_management`
  ADD PRIMARY KEY (`for_adoption_management_id`,`administrator_id`,`for_adoption_id`),
  ADD UNIQUE KEY `for_adoption_management_id_UNIQUE` (`for_adoption_management_id`),
  ADD KEY `tbl_administrator-administrator_id_idx` (`administrator_id`),
  ADD KEY `tbl_for_adoption-for_adoption_id_idx` (`for_adoption_id`);

--
-- 資料表索引 `tbl_member`
--
ALTER TABLE `tbl_member`
  ADD PRIMARY KEY (`member_id`),
  ADD UNIQUE KEY `id_UNIQUE` (`member_id`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`);

--
-- 資料表索引 `tbl_member_management`
--
ALTER TABLE `tbl_member_management`
  ADD PRIMARY KEY (`member_management_id`,`administrator_id`,`member_id`),
  ADD UNIQUE KEY `member_management_id_UNIQUE` (`member_management_id`),
  ADD KEY `tbl_administrator_administrator_id_idx` (`administrator_id`),
  ADD KEY `tbl_member-member_id_idx` (`member_id`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `tbl_administrator`
--
ALTER TABLE `tbl_administrator`
  MODIFY `administrator_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `tbl_adoption_request`
--
ALTER TABLE `tbl_adoption_request`
  MODIFY `adoption_request_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `tbl_favorite_list`
--
ALTER TABLE `tbl_favorite_list`
  MODIFY `favorite_list_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `tbl_for_adoption`
--
ALTER TABLE `tbl_for_adoption`
  MODIFY `for_adoption_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `tbl_for_adoption_management`
--
ALTER TABLE `tbl_for_adoption_management`
  MODIFY `for_adoption_management_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `tbl_member`
--
ALTER TABLE `tbl_member`
  MODIFY `member_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `tbl_member_management`
--
ALTER TABLE `tbl_member_management`
  MODIFY `member_management_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- 已傾印資料表的限制式
--

--
-- 資料表的限制式 `tbl_adoption_request`
--
ALTER TABLE `tbl_adoption_request`
  ADD CONSTRAINT `tbl_for_adoption-for_adoption_id2` FOREIGN KEY (`for_adoption_id`) REFERENCES `tbl_for_adoption` (`for_adoption_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tbl_member-member_id2` FOREIGN KEY (`member_id`) REFERENCES `tbl_member` (`member_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- 資料表的限制式 `tbl_favorite_list`
--
ALTER TABLE `tbl_favorite_list`
  ADD CONSTRAINT `tbl_for_adoption-for_adoption_id1` FOREIGN KEY (`for_adoption_id`) REFERENCES `tbl_for_adoption` (`for_adoption_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tbl_member-member_id1` FOREIGN KEY (`member_id`) REFERENCES `tbl_member` (`member_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- 資料表的限制式 `tbl_for_adoption_management`
--
ALTER TABLE `tbl_for_adoption_management`
  ADD CONSTRAINT `tbl_administrator-administrator_id` FOREIGN KEY (`administrator_id`) REFERENCES `tbl_administrator` (`administrator_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tbl_for_adoption-for_adoption_id` FOREIGN KEY (`for_adoption_id`) REFERENCES `tbl_for_adoption` (`for_adoption_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- 資料表的限制式 `tbl_member_management`
--
ALTER TABLE `tbl_member_management`
  ADD CONSTRAINT `tbl_administrator_administrator_id1` FOREIGN KEY (`administrator_id`) REFERENCES `tbl_administrator` (`administrator_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tbl_member-member_id` FOREIGN KEY (`member_id`) REFERENCES `tbl_member` (`member_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
