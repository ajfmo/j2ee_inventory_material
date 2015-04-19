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


-- Dumping structure for table j2ee_erp.manufacture
CREATE TABLE IF NOT EXISTS `manufacture` (
  `ManufactureID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL DEFAULT '0',
  `Address` varchar(100) NOT NULL DEFAULT '0',
  `Tel` varchar(50) NOT NULL DEFAULT '0',
  `Description` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ManufactureID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.manufacture: ~0 rows (approximately)
/*!40000 ALTER TABLE `manufacture` DISABLE KEYS */;
/*!40000 ALTER TABLE `manufacture` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.product
CREATE TABLE IF NOT EXISTS `product` (
  `ProductID` int(11) NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(100) DEFAULT NULL,
  `TypeID` int(11) DEFAULT NULL,
  `ProviderID` int(11) DEFAULT NULL,
  `ManufacturerID` int(11) DEFAULT NULL,
  `UnitID` int(11) DEFAULT NULL,
  `SalePrice` decimal(10,0) DEFAULT NULL,
  `OrgPrice` decimal(10,0) DEFAULT NULL,
  `Description` varchar(100) DEFAULT NULL,
  `MinStock` int(11) DEFAULT NULL,
  `MacStock` int(11) DEFAULT NULL,
  `Photo` binary(255) DEFAULT NULL,
  PRIMARY KEY (`ProductID`),
  KEY `FK_TYPE` (`TypeID`),
  KEY `FK_PROVIDER` (`ProviderID`),
  KEY `FK_MANUFACTURE` (`ManufacturerID`),
  KEY `FK_UNIT` (`UnitID`),
  CONSTRAINT `FK_UNIT` FOREIGN KEY (`UnitID`) REFERENCES `product_unit` (`UnitID`),
  CONSTRAINT `FK_MANUFACTURE` FOREIGN KEY (`ManufacturerID`) REFERENCES `manufacture` (`ManufactureID`),
  CONSTRAINT `FK_PROVIDER` FOREIGN KEY (`ProviderID`) REFERENCES `provider` (`ProviderID`),
  CONSTRAINT `FK_TYPE` FOREIGN KEY (`TypeID`) REFERENCES `product_type` (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.product: ~0 rows (approximately)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.product_group
CREATE TABLE IF NOT EXISTS `product_group` (
  `GroupID` int(11) NOT NULL AUTO_INCREMENT,
  `GroupName` int(11) DEFAULT NULL,
  `Description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`GroupID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.product_group: ~0 rows (approximately)
/*!40000 ALTER TABLE `product_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_group` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.product_type
CREATE TABLE IF NOT EXISTS `product_type` (
  `TypeID` int(11) NOT NULL AUTO_INCREMENT,
  `TypeName` int(11) DEFAULT NULL,
  `GroupID` int(11) DEFAULT NULL,
  PRIMARY KEY (`TypeID`),
  KEY `FK_GROUP` (`GroupID`),
  CONSTRAINT `FK_GROUP` FOREIGN KEY (`GroupID`) REFERENCES `product_group` (`GroupID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.product_type: ~0 rows (approximately)
/*!40000 ALTER TABLE `product_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_type` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.product_unit
CREATE TABLE IF NOT EXISTS `product_unit` (
  `UnitID` int(11) NOT NULL AUTO_INCREMENT,
  `UnitName` varchar(50) DEFAULT NULL,
  `Description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`UnitID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.product_unit: ~0 rows (approximately)
/*!40000 ALTER TABLE `product_unit` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_unit` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.provider
CREATE TABLE IF NOT EXISTS `provider` (
  `ProviderID` int(11) NOT NULL AUTO_INCREMENT,
  `ProviderName` varchar(100) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Tel` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Website` varchar(50) DEFAULT NULL,
  `Description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ProviderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.provider: ~0 rows (approximately)
/*!40000 ALTER TABLE `provider` DISABLE KEYS */;
/*!40000 ALTER TABLE `provider` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.regulation
CREATE TABLE IF NOT EXISTS `regulation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Key` varchar(50) NOT NULL DEFAULT '0',
  `Value` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
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
  `StaffID` int(11) NOT NULL AUTO_INCREMENT,
  `StaffName` varchar(50) DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `IndentifyNum` int(11) DEFAULT NULL,
  `Tel` varchar(50) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`StaffID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.staff: ~0 rows (approximately)
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.stock
CREATE TABLE IF NOT EXISTS `stock` (
  `StockID` int(11) NOT NULL AUTO_INCREMENT,
  `StockName` varchar(100) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Size` int(11) DEFAULT NULL,
  `ManagerID` int(11) DEFAULT NULL,
  `IsActive` bit(1) DEFAULT NULL,
  `Desciption` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`StockID`),
  KEY `FK_MANAGER` (`ManagerID`),
  CONSTRAINT `FK_MANAGER` FOREIGN KEY (`ManagerID`) REFERENCES `staff` (`StaffID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.stock: ~0 rows (approximately)
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.stock_build
CREATE TABLE IF NOT EXISTS `stock_build` (
  `BuildID` int(11) NOT NULL AUTO_INCREMENT,
  `Content` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`BuildID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.stock_build: ~0 rows (approximately)
/*!40000 ALTER TABLE `stock_build` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_build` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.stock_inventory
CREATE TABLE IF NOT EXISTS `stock_inventory` (
  `InventoryID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.stock_inventory: ~0 rows (approximately)
/*!40000 ALTER TABLE `stock_inventory` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_inventory` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.stock_inward
CREATE TABLE IF NOT EXISTS `stock_inward` (
  `InwardID` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date DEFAULT NULL,
  `Reason` varchar(100) DEFAULT NULL,
  `StockID` int(11) DEFAULT NULL,
  `SumAmount` decimal(10,0) DEFAULT NULL,
  `TotalNumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`InwardID`),
  KEY `FK_STOCK` (`StockID`),
  CONSTRAINT `FK_STOCK` FOREIGN KEY (`StockID`) REFERENCES `stock` (`StockID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.stock_inward: ~0 rows (approximately)
/*!40000 ALTER TABLE `stock_inward` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_inward` ENABLE KEYS */;


-- Dumping structure for table j2ee_erp.stock_inward_detail
CREATE TABLE IF NOT EXISTS `stock_inward_detail` (
  `InwardDetailID` int(11) NOT NULL AUTO_INCREMENT,
  `InwardID` int(11) DEFAULT NULL,
  `ProductID` int(11) DEFAULT NULL,
  `Number` int(11) DEFAULT NULL,
  `Price` decimal(10,0) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`InwardDetailID`),
  KEY `FK_INWARD` (`InwardID`),
  KEY `FK_PRODUCT` (`ProductID`),
  CONSTRAINT `FK_INWARD` FOREIGN KEY (`InwardID`) REFERENCES `stock_inward` (`InwardID`),
  CONSTRAINT `FK_PRODUCT` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.stock_inward_detail: ~0 rows (approximately)
/*!40000 ALTER TABLE `stock_inward_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_inward_detail` ENABLE KEYS */;


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
  `TransferID` int(11) NOT NULL AUTO_INCREMENT,
  `StockFrom` int(11) DEFAULT NULL,
  `StockTo` int(11) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `IsTransfered` bit(1) DEFAULT NULL,
  `SenderID` int(11) DEFAULT NULL,
  `RecieverID` int(11) DEFAULT NULL,
  PRIMARY KEY (`TransferID`),
  KEY `FK_STOCK_FROM` (`StockFrom`),
  KEY `FK_STOCK_TO` (`StockTo`),
  KEY `FK_SENDER` (`SenderID`),
  KEY `FK_RECIEVER` (`RecieverID`),
  CONSTRAINT `FK_RECIEVER` FOREIGN KEY (`RecieverID`) REFERENCES `staff` (`StaffID`),
  CONSTRAINT `FK_SENDER` FOREIGN KEY (`SenderID`) REFERENCES `staff` (`StaffID`),
  CONSTRAINT `FK_STOCK_FROM` FOREIGN KEY (`StockFrom`) REFERENCES `stock` (`StockID`),
  CONSTRAINT `FK_STOCK_TO` FOREIGN KEY (`StockTo`) REFERENCES `stock` (`StockID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table j2ee_erp.stock_transfer: ~0 rows (approximately)
/*!40000 ALTER TABLE `stock_transfer` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_transfer` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
