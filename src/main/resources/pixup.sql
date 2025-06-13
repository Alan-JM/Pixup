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
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`TBL_MUNICIPIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`TBL_MUNICIPIO` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`TBL_MUNICIPIO` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  `id_estado` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `id_estado`
    FOREIGN KEY (`id_estado`)
    REFERENCES `pixup`.`TBL_ESTADO` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `id_estado_idx` ON `pixup`.`TBL_MUNICIPIO` (`id_estado` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`TBL_COLONIA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`TBL_COLONIA` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`TBL_COLONIA` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  `cp` VARCHAR(5) NOT NULL,
  `id_municipio` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `id_municipio`
    FOREIGN KEY (`id_municipio`)
    REFERENCES `pixup`.`TBL_MUNICIPIO` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `id_municipio_idx` ON `pixup`.`TBL_COLONIA` (`id_municipio` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`TBL_DISQUERA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`TBL_DISQUERA` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`TBL_DISQUERA` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`TBL_ARTISTA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`TBL_ARTISTA` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`TBL_ARTISTA` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`TBL_GENERO_MUSICAL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`TBL_GENERO_MUSICAL` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`TBL_GENERO_MUSICAL` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`TBL_DISCO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`TBL_DISCO` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`TBL_DISCO` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(200) NOT NULL,
  `precio` FLOAT(2,2) NOT NULL,
  `existencia` INT NOT NULL,
  `descuento` FLOAT(2,2) NOT NULL,
  `fechaLanzamiento` DATE NOT NULL,
  `imagen` VARCHAR(120) NOT NULL,
  `id_disquera` INT NOT NULL,
  `id_artista` INT NOT NULL,
  `id_genero_musical` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `int_disquera`
    FOREIGN KEY (`id_disquera`)
    REFERENCES `pixup`.`TBL_DISQUERA` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `int_artista`
    FOREIGN KEY (`id_artista`)
    REFERENCES `pixup`.`TBL_ARTISTA` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `int_genero_musical`
    FOREIGN KEY (`id_genero_musical`)
    REFERENCES `pixup`.`TBL_GENERO_MUSICAL` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `int_disquera_idx` ON `pixup`.`TBL_DISCO` (`id_disquera` ASC) VISIBLE;

SHOW WARNINGS;
CREATE INDEX `int_artista_idx` ON `pixup`.`TBL_DISCO` (`id_artista` ASC) VISIBLE;

SHOW WARNINGS;
CREATE INDEX `int_genero_musical_idx` ON `pixup`.`TBL_DISCO` (`id_genero_musical` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`TBL_CANCION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`TBL_CANCION` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`TBL_CANCION` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(200) NOT NULL,
  `duracion` TIME NOT NULL,
  `id_disco` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `id_disco`
    FOREIGN KEY (`id_disco`)
    REFERENCES `pixup`.`TBL_DISCO` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `id_disco_idx` ON `pixup`.`TBL_CANCION` (`id_disco` ASC) VISIBLE;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
