-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.19-log - MySQL Community Server (GPL)
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


-- Dumping structure for table j2ee_erp.adjustment
CREATE TABLE IF NOT EXISTS `adjustment` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `AdjustID` varchar(50) NOT NULL DEFAULT '0',
  `RefType` int(11) NOT NULL DEFAULT '0',
  `StockID` int(11) NOT NULL DEFAULT '0',
  `TotalDiffAmount` decimal(10,0) NOT NULL DEFAULT '0',
  `StaffID` int(11) NOT NULL DEFAULT '0',
  `Accept` bit(1) NOT NULL DEFAULT b'0',
  `Active` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`ID`),
  KEY `FK_adjustment_stock` (`StockID`),
  KEY `FK_adjustment_staff` (`StaffID`),
  CONSTRAINT `FK_adjustment_staff` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`),
  CONSTRAINT `FK_adjustment_stock` FOREIGN KEY (`StockID`) REFERENCES `stock` (`StockID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Kiểm kê hàng hóa';

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.asset
CREATE TABLE IF NOT EXISTS `asset` (
  `AssetID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL DEFAULT '0',
  `OrgPrice` decimal(10,0) NOT NULL DEFAULT '0',
  `Number` int(11) DEFAULT NULL,
  PRIMARY KEY (`AssetID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tài sản cố định';

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.asset_adjustment
CREATE TABLE IF NOT EXISTS `asset_adjustment` (
  `AssetAdjustID` int(11) NOT NULL AUTO_INCREMENT,
  `AssetNumber` int(11) NOT NULL DEFAULT '0',
  `AssetID` int(11) NOT NULL DEFAULT '0',
  `State` varchar(50) NOT NULL DEFAULT '0',
  `Date` date NOT NULL,
  `IsValid` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`AssetAdjustID`),
  KEY `FK_asset_adjustment_asset` (`AssetID`),
  CONSTRAINT `FK_asset_adjustment_asset` FOREIGN KEY (`AssetID`) REFERENCES `asset` (`AssetID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Kiem ke tai san co dinh';

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.asset_liquidation
CREATE TABLE IF NOT EXISTS `asset_liquidation` (
  `LiquidID` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `StaffID` int(11) NOT NULL DEFAULT '0',
  `TotalNumber` int(11) NOT NULL DEFAULT '0',
  `TotalAmount` decimal(10,0) NOT NULL DEFAULT '0',
  `Reason` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`LiquidID`),
  KEY `FK_asset_liquidation_staff` (`StaffID`),
  CONSTRAINT `FK_asset_liquidation_staff` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Thanh lý tài sản cố định';

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.asset_liquidation_detail
CREATE TABLE IF NOT EXISTS `asset_liquidation_detail` (
  `LiDetailID` int(11) NOT NULL AUTO_INCREMENT,
  `LiquidID` int(11) NOT NULL DEFAULT '0',
  `AssetID` int(11) NOT NULL DEFAULT '0',
  `Number` int(11) NOT NULL DEFAULT '0',
  `Price` decimal(10,0) NOT NULL DEFAULT '0',
  `Amount` decimal(10,0) NOT NULL DEFAULT '0',
  `Customer` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`LiDetailID`),
  KEY `FK__asset_liquidation` (`LiquidID`),
  KEY `FK__asset` (`AssetID`),
  CONSTRAINT `FK__asset_liquidation` FOREIGN KEY (`LiquidID`) REFERENCES `asset_liquidation` (`LiquidID`),
  CONSTRAINT `FK__asset` FOREIGN KEY (`AssetID`) REFERENCES `asset` (`AssetID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.asset_report
CREATE TABLE IF NOT EXISTS `asset_report` (
  `AssetReportID` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date DEFAULT NULL,
  `StaffID` int(11) DEFAULT NULL,
  `Reason` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`AssetReportID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.asset_report_detail
CREATE TABLE IF NOT EXISTS `asset_report_detail` (
  `AssetReportDetailID` int(11) DEFAULT NULL,
  `AssetReportID` int(11) DEFAULT NULL,
  `AssetID` int(11) DEFAULT NULL,
  `Number` int(11) DEFAULT NULL,
  `UseState` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.contract
CREATE TABLE IF NOT EXISTS `contract` (
  `ContractID` int(11) NOT NULL AUTO_INCREMENT,
  `Customer` varchar(50) NOT NULL DEFAULT '0',
  `StaffID` int(11) NOT NULL DEFAULT '0',
  `Date` date NOT NULL,
  `ContractNumber` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ContractID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='hợp đồng';

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.inventory_report
CREATE TABLE IF NOT EXISTS `inventory_report` (
  `ReportID` int(11) NOT NULL AUTO_INCREMENT,
  `StaffID` int(11) DEFAULT '0',
  `Date` date DEFAULT NULL,
  `Reason` varchar(255) DEFAULT '0',
  PRIMARY KEY (`ReportID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.inventory_report_detail
CREATE TABLE IF NOT EXISTS `inventory_report_detail` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `ProductID` int(11) NOT NULL,
  `Number` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.manufacture
CREATE TABLE IF NOT EXISTS `manufacture` (
  `ManufactureID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL DEFAULT '0',
  `Address` varchar(100) NOT NULL DEFAULT '0',
  `Tel` varchar(50) NOT NULL DEFAULT '0',
  `Description` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ManufactureID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


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
  `MaxStock` int(11) DEFAULT NULL,
  `Photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ProductID`),
  KEY `FK_TYPE` (`TypeID`),
  KEY `FK_PROVIDER` (`ProviderID`),
  KEY `FK_MANUFACTURE` (`ManufacturerID`),
  KEY `FK_UNIT` (`UnitID`),
  CONSTRAINT `FK_MANUFACTURE` FOREIGN KEY (`ManufacturerID`) REFERENCES `manufacture` (`ManufactureID`),
  CONSTRAINT `FK_PROVIDER` FOREIGN KEY (`ProviderID`) REFERENCES `provider` (`ProviderID`),
  CONSTRAINT `FK_TYPE` FOREIGN KEY (`TypeID`) REFERENCES `product_type` (`TypeID`),
  CONSTRAINT `FK_UNIT` FOREIGN KEY (`UnitID`) REFERENCES `product_unit` (`UnitID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.product_component
CREATE TABLE IF NOT EXISTS `product_component` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ComponentID` int(11) NOT NULL,
  `ProductID` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Price` decimal(10,0) NOT NULL,
  `Amount` decimal(10,0) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_product_component_product` (`ComponentID`),
  KEY `FK_product_component_product_2` (`ProductID`),
  CONSTRAINT `FK_product_component_product` FOREIGN KEY (`ComponentID`) REFERENCES `product` (`ProductID`),
  CONSTRAINT `FK_product_component_product_2` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Lưu cấu tạo của một thành phẩm.\r\nComponentID là mã các sản phẩm là nguyên liệu của thành phẩm ProductID';

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.product_group
CREATE TABLE IF NOT EXISTS `product_group` (
  `GroupID` int(11) NOT NULL AUTO_INCREMENT,
  `GroupName` varchar(50) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`GroupID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.product_type
CREATE TABLE IF NOT EXISTS `product_type` (
  `TypeID` int(11) NOT NULL AUTO_INCREMENT,
  `TypeName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Lưu loại sản phẩm là thành phẩm hay nguyên liệu';

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.product_unit
CREATE TABLE IF NOT EXISTS `product_unit` (
  `UnitID` int(11) NOT NULL AUTO_INCREMENT,
  `UnitName` varchar(50) DEFAULT NULL,
  `Description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`UnitID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


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

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.reference_type
CREATE TABLE IF NOT EXISTS `reference_type` (
  `RefTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`RefTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='lưu loại tháo dỡ/ đóng gói';

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.regulation
CREATE TABLE IF NOT EXISTS `regulation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Key` varchar(50) NOT NULL DEFAULT '0',
  `Value` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.report_inventory
CREATE TABLE IF NOT EXISTS `report_inventory` (
  `product_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


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

-- Data exporting was unselected.


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

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.stock_build
CREATE TABLE IF NOT EXISTS `stock_build` (
  `BuildID` int(11) NOT NULL AUTO_INCREMENT,
  `ProductID` int(11) NOT NULL DEFAULT '0',
  `RefTypeID` int(11) NOT NULL DEFAULT '0',
  `StaffID` int(11) NOT NULL DEFAULT '0',
  `TotalAmount` decimal(10,0) NOT NULL DEFAULT '0',
  `TotalQuantity` int(11) NOT NULL DEFAULT '0',
  `Reason` varchar(50) NOT NULL DEFAULT '0',
  `BuildDate` date NOT NULL,
  PRIMARY KEY (`BuildID`),
  KEY `FK_stock_build_product` (`ProductID`),
  KEY `FK_stock_build_reference_type` (`RefTypeID`),
  KEY `FK_stock_build_staff` (`StaffID`),
  CONSTRAINT `FK_stock_build_product` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`),
  CONSTRAINT `FK_stock_build_reference_type` FOREIGN KEY (`RefTypeID`) REFERENCES `reference_type` (`RefTypeID`),
  CONSTRAINT `FK_stock_build_staff` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.stock_build_detail
CREATE TABLE IF NOT EXISTS `stock_build_detail` (
  `BuildDetailID` int(11) NOT NULL AUTO_INCREMENT,
  `BuildID` int(11) DEFAULT NULL,
  `ComponentID` int(11) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Price` decimal(10,0) DEFAULT NULL,
  `Amount` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`BuildDetailID`),
  KEY `FK_stock_build_detail_stock_build` (`BuildID`),
  CONSTRAINT `FK_stock_build_detail_stock_build` FOREIGN KEY (`BuildID`) REFERENCES `stock_build` (`BuildID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.stock_inventory
CREATE TABLE IF NOT EXISTS `stock_inventory` (
  `InventoryID` int(11) NOT NULL AUTO_INCREMENT,
  `RefID` int(11) NOT NULL DEFAULT '0',
  `Date` date NOT NULL,
  `ProductID` int(11) NOT NULL DEFAULT '0',
  `StockID` int(11) NOT NULL DEFAULT '0',
  `Quantity` int(11) NOT NULL DEFAULT '0',
  `Price` decimal(10,0) NOT NULL DEFAULT '0',
  `Amount` decimal(10,0) NOT NULL DEFAULT '0',
  PRIMARY KEY (`InventoryID`),
  KEY `FK_stock_inventory_reference_type` (`RefID`),
  KEY `FK_stock_inventory_product` (`ProductID`),
  KEY `FK_stock_inventory_stock` (`StockID`),
  CONSTRAINT `FK_stock_inventory_product` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`),
  CONSTRAINT `FK_stock_inventory_reference_type` FOREIGN KEY (`RefID`) REFERENCES `reference_type` (`RefTypeID`),
  CONSTRAINT `FK_stock_inventory_stock` FOREIGN KEY (`StockID`) REFERENCES `stock` (`StockID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.stock_inward
CREATE TABLE IF NOT EXISTS `stock_inward` (
  `InwardID` int(11) NOT NULL AUTO_INCREMENT,
  `ProviderID` int(11) NOT NULL DEFAULT '0',
  `StaffID` int(11) NOT NULL DEFAULT '0',
  `Date` date DEFAULT NULL,
  `Reason` varchar(100) DEFAULT NULL,
  `TotalAmount` decimal(10,0) DEFAULT NULL,
  `TotalNumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`InwardID`),
  KEY `FK_stock_inward_staff` (`StaffID`),
  KEY `FK_stock_inward_provider` (`ProviderID`),
  CONSTRAINT `FK_stock_inward_provider` FOREIGN KEY (`ProviderID`) REFERENCES `provider` (`ProviderID`),
  CONSTRAINT `FK_stock_inward_staff` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.stock_inward_detail
CREATE TABLE IF NOT EXISTS `stock_inward_detail` (
  `InwardDetailID` int(11) NOT NULL AUTO_INCREMENT,
  `InwardID` int(11) DEFAULT NULL,
  `ProductID` int(11) DEFAULT NULL,
  `StockID` int(11) DEFAULT NULL,
  `Number` int(11) DEFAULT NULL,
  `Price` decimal(10,0) DEFAULT NULL,
  `Amount` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`InwardDetailID`),
  KEY `FK_INWARD` (`InwardID`),
  KEY `FK_PRODUCT` (`ProductID`),
  KEY `FK_stock_inward_detail_stock` (`StockID`),
  CONSTRAINT `FK_INWARD` FOREIGN KEY (`InwardID`) REFERENCES `stock_inward` (`InwardID`),
  CONSTRAINT `FK_PRODUCT` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`),
  CONSTRAINT `FK_stock_inward_detail_stock` FOREIGN KEY (`StockID`) REFERENCES `stock` (`StockID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.stock_outward
CREATE TABLE IF NOT EXISTS `stock_outward` (
  `OutwardID` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `Reason` varchar(50) NOT NULL DEFAULT '0',
  `CustomerID` int(11) NOT NULL DEFAULT '0',
  `StaffID` int(11) NOT NULL DEFAULT '0',
  `TotalQuantity` int(11) NOT NULL DEFAULT '0',
  `TotalAmount` decimal(10,0) NOT NULL DEFAULT '0',
  PRIMARY KEY (`OutwardID`),
  KEY `FK_stock_outward_staff` (`StaffID`),
  CONSTRAINT `FK_stock_outward_staff` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.stock_outward_detail
CREATE TABLE IF NOT EXISTS `stock_outward_detail` (
  `OutwardDetailID` int(11) DEFAULT NULL,
  `OutwardID` int(11) DEFAULT NULL,
  `StockID` int(11) DEFAULT NULL,
  `ProductID` int(11) DEFAULT NULL,
  `Number` int(11) DEFAULT NULL,
  `Price` decimal(10,0) DEFAULT NULL,
  `Amount` decimal(10,0) DEFAULT NULL,
  KEY `FK_stock_outward_detail_stock` (`StockID`),
  KEY `FK_stock_outward_detail_product` (`ProductID`),
  KEY `FK_stock_outward_detail_stock_outward` (`OutwardID`),
  CONSTRAINT `FK_stock_outward_detail_product` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`),
  CONSTRAINT `FK_stock_outward_detail_stock` FOREIGN KEY (`StockID`) REFERENCES `stock` (`StockID`),
  CONSTRAINT `FK_stock_outward_detail_stock_outward` FOREIGN KEY (`OutwardID`) REFERENCES `stock_outward` (`OutwardID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.stock_report
CREATE TABLE IF NOT EXISTS `stock_report` (
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.stock_transfer
CREATE TABLE IF NOT EXISTS `stock_transfer` (
  `TransferID` int(11) NOT NULL AUTO_INCREMENT,
  `StaffID` int(11) NOT NULL DEFAULT '0',
  `Date` date DEFAULT NULL,
  `IsTransfered` bit(1) DEFAULT NULL,
  `TotalNumber` int(11) DEFAULT NULL,
  `TotalAmount` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`TransferID`),
  KEY `FK_stock_transfer_staff` (`StaffID`),
  CONSTRAINT `FK_stock_transfer_staff` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table j2ee_erp.stock_transfer_detail
CREATE TABLE IF NOT EXISTS `stock_transfer_detail` (
  `StockTrDetailID` int(11) NOT NULL AUTO_INCREMENT,
  `ProductID` int(11) NOT NULL DEFAULT '0',
  `FromStock` int(11) NOT NULL DEFAULT '0',
  `ToStock` int(11) NOT NULL DEFAULT '0',
  `Number` int(11) NOT NULL DEFAULT '0',
  `Price` decimal(10,0) NOT NULL DEFAULT '0',
  `Amount` decimal(10,0) NOT NULL DEFAULT '0',
  PRIMARY KEY (`StockTrDetailID`),
  KEY `FK_stock_transfer_detail_stock` (`FromStock`),
  KEY `FK_stock_transfer_detail_stock_2` (`ToStock`),
  CONSTRAINT `FK_stock_transfer_detail_stock` FOREIGN KEY (`FromStock`) REFERENCES `stock` (`StockID`),
  CONSTRAINT `FK_stock_transfer_detail_stock_2` FOREIGN KEY (`ToStock`) REFERENCES `stock` (`StockID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
