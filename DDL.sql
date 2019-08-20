-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.7.21-log - MySQL Community Server (GPL)
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- short 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `short` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `short`;

-- 테이블 short.url_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `url_info` (
  `seq` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '키',
  `origin_url` varchar(255) NOT NULL COMMENT '원본URL',
  `short_url` varchar(7) DEFAULT NULL COMMENT '줄인URL',
  PRIMARY KEY (`seq`),
  KEY `idx_url_short_1` (`origin_url`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- AUTO_INCREMENT 초기화
-- ALTER TABLE url_info AUTO_INCREMENT = 1;
