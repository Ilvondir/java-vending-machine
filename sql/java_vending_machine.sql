-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 11 Gru 2022, 13:21
-- Wersja serwera: 10.4.25-MariaDB
-- Wersja PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `java_vending_machine`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `stuff`
--

CREATE DATABASE java_vending_machine;

USE java_vending_machine;

CREATE TABLE `stuff` (
  `ID` int(11) NOT NULL,
  `Producer` varchar(50) DEFAULT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Volume` decimal(3,2) DEFAULT NULL,
  `Number` varchar(2) DEFAULT NULL,
  `Price` decimal(3,2) DEFAULT NULL,
  `Remaining` int(1) DEFAULT NULL,
  `Type_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `stuff`
--

INSERT INTO `stuff` (`ID`, `Producer`, `Name`, `Volume`, `Number`, `Price`, `Remaining`, `Type_ID`) VALUES
(1, '7Days', 'Croissant', NULL, '11', '5.00', 3, 1),
(2, 'Maretti', 'Bruschette Chips', NULL, '12', '5.00', 2, 1),
(3, 'Lays', 'Chips', NULL, '13', '4.00', 4, 1),
(4, 'Lajkonik', 'Paluszki', NULL, '14', '3.50', 6, 1),
(5, 'SaesamiSport', 'Sezamki', NULL, '21', '2.50', 5, 1),
(6, 'Milka', 'Baton Oreo', NULL, '22', '2.50', 3, 1),
(7, 'Sante', 'Ciasteczka owsiane', NULL, '23', '3.00', 7, 1),
(8, 'OSHEE', 'Baton musli', NULL, '24', '2.50', 4, 1),
(9, 'ENERGIA', 'Baton kokosowy', NULL, '25', '2.50', 8, 1),
(10, 'Nestle', 'KitKat', NULL, '26', '2.50', 1, 1),
(11, 'Mondelez', '3Bit', NULL, '27', '2.50', 2, 1),
(12, 'Nestle', 'Czekolada KitKat', NULL, '28', '4.00', 4, 1),
(13, 'OLZA', 'Prince Polo XXL', NULL, '31', '3.50', 3, 1),
(14, 'OLZA', 'Prince Polo', NULL, '32', '2.50', 2, 1),
(15, 'Lusette', 'Baton czekoladowy', NULL, '33', '2.50', 4, 1),
(16, 'Mars', 'Twix Xtra', NULL, '34', '3.50', 4, 1),
(17, 'Mars', 'Twix', NULL, '35', '2.50', 5, 1),
(18, 'Mars', 'Bounty', NULL, '36', '2.50', 6, 1),
(19, 'Mars', 'Snickers', NULL, '37', '2.50', 2, 1),
(20, 'Kinder', 'Bueno', NULL, '38', '3.00', 1, 1),
(21, 'Cisowianka', 'Woda niegazowana', '0.50', '41', '2.50', 7, 2),
(22, 'Muszynianka', 'Woda gazowana', '0.50', '42', '3.00', 6, 2),
(23, 'FoodCare', 'Frugo zielone', '0.50', '43', '4.50', 4, 2),
(24, 'FoodCare', 'Frugo czarne', '0.50', '44', '4.50', 3, 2),
(25, 'FoodCare', 'Frugo niebieskie', '0.50', '45', '4.50', 4, 2),
(26, 'FoodCare', 'Frugo czerwone', '0.50', '46', '4.50', 4, 2),
(27, 'PepsiCo', 'Mountain Dew', '0.50', '47', '4.50', 8, 2),
(28, 'PepsiCo', 'Mirinda', '0.50', '48', '4.50', 5, 2),
(29, 'PepsiCo', 'Pepsi', '0.25', '51', '2.50', 8, 2),
(30, 'PepsiCo', 'Pepsi', '0.33', '52', '3.00', 7, 2),
(31, 'PepsiCo', 'Mirinda', '0.33', '53', '3.00', 4, 2),
(32, 'PepsiCo', 'Mountain Dew', '0.33', '54', '3.00', 3, 2),
(33, 'The Coca-Cola Company', 'Fanta', '0.33', '55', '3.00', 5, 2),
(34, 'The Coca-Cola Company', 'Coca-Cola', '0.25', '56', '2.50', 4, 2),
(35, 'The Coca-Cola Company', 'Coca-Cola', '0.33', '57', '3.00', 5, 2),
(36, 'Tymbark', 'Sok arbuzowy', '0.33', '58', '3.00', 6, 2),
(37, 'Tarczyn', 'Sok jabłkowy', '0.30', '61', '3.00', 5, 2),
(38, 'Tarczyn', 'Sok kiwi', '0.30', '62', '3.00', 5, 2),
(39, 'Tarczyn', 'Sok pomarańczowy', '0.30', '63', '3.00', 6, 2),
(40, 'Fortuna', 'Sok pomarańczony', '0.30', '64', '3.00', 2, 2),
(41, 'OSHEE', 'Napój izotoniczny', '0.25', '65', '3.50', 7, 2),
(42, 'Tiger', 'Napój energetyczny', '0.25', '66', '4.00', 2, 2),
(43, 'Black', 'Napój energetyczny', '0.25', '67', '4.00', 5, 2),
(44, 'Black', 'Napój energetyczny', '0.33', '68', '5.00', 6, 2);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `stuff`
--
ALTER TABLE `stuff`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `stuff`
--
ALTER TABLE `stuff`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
