-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.19 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for j2ee_erp
CREATE DATABASE IF NOT EXISTS `j2ee_erp` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `j2ee_erp`;


-- Dumping structure for table j2ee_erp.product
CREATE TABLE IF NOT EXISTS `product` (
  `ProductID` int(11) DEFAULT NULL,
  `ProductName` varchar(100) DEFAULT NULL,
  `TypeID` varchar(100) DEFAULT NULL,
  `ProviderID` int(11) DEFAULT NULL,
  `ManufacturerID` int(11) DEFAULT NULL,
  `UnitID` int(11) DEFAULT NULL,
  `SalePrice` int(11) DEFAULT NULL,
  `OrgPrice` int(11) DEFAULT NULL,
  `Description` int(11) DEFAULT NULL,
  `MinStock` int(11) DEFAULT NULL,
  `MacStock` int(11) DEFAULT NULL,
  `Photo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.product: ~0 rows (approximately)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.product_group
CREATE TABLE IF NOT EXISTS `product_group` (
  `GroupID` int(11) DEFAULT NULL,
  `GroupName` int(11) DEFAULT NULL,
  `Description` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.product_group: ~0 rows (approximately)
/*!40000 ALTER TABLE `product_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_group` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.product_type
CREATE TABLE IF NOT EXISTS `product_type` (
  `TypeID` int(11) DEFAULT NULL,
  `TypeName` int(11) DEFAULT NULL,
  `GroupID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.product_type: ~0 rows (approximately)
/*!40000 ALTER TABLE `product_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_type` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.product_unit
CREATE TABLE IF NOT EXISTS `product_unit` (
  `UnitID` int(11) DEFAULT NULL,
  `UnitName` varchar(50) DEFAULT NULL,
  `Description` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.product_unit: ~0 rows (approximately)
/*!40000 ALTER TABLE `product_unit` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_unit` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.provider
CREATE TABLE IF NOT EXISTS `provider` (
  `ProviderID` int(11) DEFAULT NULL,
  `ProviderName` varchar(100) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Tel` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Website` varchar(50) DEFAULT NULL,
  `Description` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.provider: ~0 rows (approximately)
/*!40000 ALTER TABLE `provider` DISABLE KEYS */;
/*!40000 ALTER TABLE `provider` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.regulation
CREATE TABLE IF NOT EXISTS `regulation` (
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.regulation: ~0 rows (approximately)
/*!40000 ALTER TABLE `regulation` DISABLE KEYS */;
/*!40000 ALTER TABLE `regulation` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.report_inventory
CREATE TABLE IF NOT EXISTS `report_inventory` (
  `product_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.report_inventory: ~0 rows (approximately)
/*!40000 ALTER TABLE `report_inventory` DISABLE KEYS */;
/*!40000 ALTER TABLE `report_inventory` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.staff
CREATE TABLE IF NOT EXISTS `staff` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `identify_number` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.staff: ~0 rows (approximately)
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.stock_build
CREATE TABLE IF NOT EXISTS `stock_build` (
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.stock_build: ~0 rows (approximately)
/*!40000 ALTER TABLE `stock_build` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_build` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.stock_inward
CREATE TABLE IF NOT EXISTS `stock_inward` (
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.stock_inward: ~0 rows (approximately)
/*!40000 ALTER TABLE `stock_inward` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_inward` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.stock_outward
CREATE TABLE IF NOT EXISTS `stock_outward` (
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.stock_outward: ~0 rows (approximately)
/*!40000 ALTER TABLE `stock_outward` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_outward` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.stock_report
CREATE TABLE IF NOT EXISTS `stock_report` (
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.stock_report: ~0 rows (approximately)
/*!40000 ALTER TABLE `stock_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_report` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.stock_transfer
CREATE TABLE IF NOT EXISTS `stock_transfer` (
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.stock_transfer: ~0 rows (approximately)
/*!40000 ALTER TABLE `stock_transfer` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_transfer` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.ware_house
CREATE TABLE IF NOT EXISTS `ware_house` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.ware_house: ~0 rows (approximately)
/*!40000 ALTER TABLE `ware_house` DISABLE KEYS */;
/*!40000 ALTER TABLE `ware_house` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
