-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 28, 2022 lúc 03:35 PM
-- Phiên bản máy phục vụ: 10.4.21-MariaDB
-- Phiên bản PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `clothes-sports`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `accounts`
--

CREATE TABLE `accounts` (
  `id` int(11) NOT NULL,
  `username` varchar(250) NOT NULL,
  `passwordHash` text NOT NULL,
  `salt` varchar(150) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `role` int(11) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `accounts`
--

INSERT INTO `accounts` (`id`, `username`, `passwordHash`, `salt`, `email`, `phone`, `role`, `createdAt`, `updatedAt`, `status`) VALUES
(1, 'ngochithanhdat', '4fc3d2b0ed397863d3e0d593d14e6f1415e4b6438a97ee169a770ca91756bcab', 'mQvIts0sLk', 'ngodat02@gmail.com', '0392847328', 2, '2022-05-25 16:10:21', '2022-05-25 16:10:21', 1),
(3, 'admin', '0372eb27c89523ce7891d8bf9db9c041d76acac91631732820b3bda15d1db2f7', 'FFTkL63kQ0', 'admin@gmail.com', '09239478', 1, '2022-05-25 17:12:41', '2022-05-25 17:12:41', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`id`, `name`, `createdAt`, `updatedAt`, `status`) VALUES
(1, 'Adidas', '2022-05-22 09:49:47', '2022-05-22 09:49:47', 1),
(2, 'Jordan', '2022-05-22 09:49:48', '2022-05-22 09:49:48', 1),
(3, 'New Balance', '2022-05-26 19:58:38', '2022-05-26 19:58:38', 1),
(4, 'Gucci', '2022-05-26 19:58:38', '2022-05-26 19:58:38', 1),
(5, 'Puma', '2022-05-26 19:58:55', '2022-05-26 19:58:55', 1),
(6, 'Nike', '2022-05-26 19:58:56', '2022-05-26 19:58:56', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `categoryId` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `detail` text NOT NULL,
  `price` double NOT NULL,
  `image` text NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id`, `categoryId`, `name`, `description`, `detail`, `price`, `image`, `createdAt`, `updatedAt`, `status`) VALUES
(1, 1, 'Adidas Sport', 'Lorem ipsum', '<p>ADIDAS SPORT</p>\r\n', 110.2, 'https://res.cloudinary.com/bac-ninh/image/upload/v1653473818/ttugb31xjgjxjqkgg4wb.png', '2022-05-25 17:15:11', '2022-05-25 17:15:11', 1),
(2, 1, 'Jordan Sport', 'Good Sport', '<p>It&#39;s shoes Jordan</p>\r\n', 210, 'https://res.cloudinary.com/bac-ninh/image/upload/v1653531989/j7xkoq0ymbotp4yq5yar.jpg', '2022-05-26 09:24:18', '2022-05-26 09:24:18', 1),
(3, 2, 'Nike Air Low', 'Good Sport', '<p><strong>It&#39;s is nike Air</strong></p>\r\n', 12.35, 'https://res.cloudinary.com/bac-ninh/image/upload/v1653473904/hszjbjxht1o1vitbggmn.png', '2022-05-25 17:16:23', '2022-05-25 17:16:23', 1),
(5, 1, 'Adidas Original', 'Good Sport', '<p>It&#39;s Adias Orginal</p>\r\n', 12.58, 'https://res.cloudinary.com/bac-ninh/image/upload/v1653473946/h35j3dht1udxbiidd2i8.png', '2022-05-25 17:17:14', '2022-05-25 17:17:14', 1),
(6, 2, 'Jordan Nike High', 'Good Sport', '<p>It&#39;s Jordan</p>\r\n', 125.67, 'https://res.cloudinary.com/bac-ninh/image/upload/v1653476597/fsx4ickt402qk38hwsfc.webp', '2022-05-25 18:01:50', '2022-05-25 18:01:50', 1),
(7, 2, 'Nike Air Pink Low', 'Good', '<p><strong>It&#39;s&nbsp;Nike Air Pink Low</strong></p>\r\n', 156.5, 'https://res.cloudinary.com/bac-ninh/image/upload/v1653473992/q98saurcjcmvlacu2yzr.png', '2022-05-25 17:18:01', '2022-05-25 17:18:01', 1),
(8, 2, 'Shoes Nike', 'Good Shoes Sport', '<p>Shoes Sport very good</p>\r\n', 10.5, 'https://res.cloudinary.com/bac-ninh/image/upload/v1653474033/mjzs6wtxxpsrjhf6ildg.png', '2022-05-25 17:18:43', '2022-05-25 17:18:43', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(255) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `image` text COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `dob` datetime NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `phone`, `address`, `image`, `password`, `dob`, `createdAt`, `updatedAt`, `status`) VALUES
(1, 'Ngo chi thanh dat', 'dat@gmail.com', '097732823', 'Bac ninh', 'dat.jpg', 'ngodat02', '2002-11-22 10:10:00', '2022-05-21 07:46:26', '2022-05-21 07:46:26', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `userUnique` (`username`),
  ADD UNIQUE KEY `emailUnique` (`email`);

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `foreignKeyProduct` (`categoryId`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `foreignKeyProduct` FOREIGN KEY (`categoryId`) REFERENCES `categories` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
