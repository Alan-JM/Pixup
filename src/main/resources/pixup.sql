-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pixup
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `pixup` ;

-- -----------------------------------------------------
-- Schema pixup
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pixup` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `pixup` ;

-- -----------------------------------------------------
-- Table `pixup`.`TBL_ESTADO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`TBL_ESTADO` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`TBL_ESTADO` (
  `idTBL_ESTADO` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`idTBL_ESTADO`))
ENGINE = InnoDB;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
