-- MySQL Script generated by MySQL Workbench
-- Fri Oct 16 23:32:05 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sem_aglomerar
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sem_aglomerar
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sem_aglomerar` DEFAULT CHARACTER SET utf8 ;
USE `sem_aglomerar` ;

-- -----------------------------------------------------
-- Table `sem_aglomerar`.`Login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sem_aglomerar`.`Login` (
  `login_id` INT NOT NULL AUTO_INCREMENT,
  `login_usuario` VARCHAR(45) NOT NULL,
  `login_senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`login_id`),
  UNIQUE INDEX `login_usuario_UNIQUE` (`login_usuario` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sem_aglomerar`.`Responsavel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sem_aglomerar`.`Responsavel` (
  `resp_id` INT NOT NULL AUTO_INCREMENT,
  `resp_nome` VARCHAR(45) NOT NULL,
  `resp_cpf` VARCHAR(11) NOT NULL,
  `resp_email` VARCHAR(45) NOT NULL,
  `resp_telefone` VARCHAR(45) NULL,
  PRIMARY KEY (`resp_id`),
  UNIQUE INDEX `resp_rg_UNIQUE` (`resp_cpf` ASC),
  UNIQUE INDEX `resp_email_UNIQUE` (`resp_email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sem_aglomerar`.`Shopping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sem_aglomerar`.`Shopping` (
  `shop_id` INT NOT NULL AUTO_INCREMENT,
  `shop_nome` VARCHAR(45) NOT NULL,
  `shop_cnpj` VARCHAR(14) NOT NULL,
  `shop_login_id` INT NOT NULL,
  `shop_resp_id` INT NOT NULL,
  PRIMARY KEY (`shop_id`),
  UNIQUE INDEX `shop_cnpj_UNIQUE` (`shop_cnpj` ASC),
  INDEX `fk_Shopping_Login_idx` (`shop_login_id` ASC),
  INDEX `fk_Shopping_Responsavel_idx` (`shop_resp_id` ASC),
  CONSTRAINT `fk_Shopping_Login`
    FOREIGN KEY (`shop_login_id`)
    REFERENCES `sem_aglomerar`.`Login` (`login_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Shopping_Responsavel`
    FOREIGN KEY (`shop_resp_id`)
    REFERENCES `sem_aglomerar`.`Responsavel` (`resp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sem_aglomerar`.`Loja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sem_aglomerar`.`Loja` (
  `loja_id` INT NOT NULL AUTO_INCREMENT,
  `loja_nome` VARCHAR(45) NOT NULL,
  `loja_cnpj` VARCHAR(45) NOT NULL,
  `loja_shop_id` INT NOT NULL,
  `loja_login_id` INT NOT NULL,
  `loja_resp_id` INT NOT NULL,
  PRIMARY KEY (`loja_id`),
  UNIQUE INDEX `loja_cnpj_UNIQUE` (`loja_cnpj` ASC),
  INDEX `fk_Loja_Shopping_idx` (`loja_shop_id` ASC),
  INDEX `fk_Loja_Login_idx` (`loja_login_id` ASC),
  INDEX `fk_Loja_Responsavel_idx` (`loja_resp_id` ASC),
  CONSTRAINT `fk_Loja_Shopping`
    FOREIGN KEY (`loja_shop_id`)
    REFERENCES `sem_aglomerar`.`Shopping` (`shop_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Loja_Login`
    FOREIGN KEY (`loja_login_id`)
    REFERENCES `sem_aglomerar`.`Login` (`login_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Loja_Responsavel`
    FOREIGN KEY (`loja_resp_id`)
    REFERENCES `sem_aglomerar`.`Responsavel` (`resp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sem_aglomerar`.`Relatorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sem_aglomerar`.`Relatorio` (
  `relat_id` INT NOT NULL AUTO_INCREMENT,
  `relat_quant_cliente` INT NOT NULL,
  `relat_hora` TIME NOT NULL,
  `relat_data` DATE NOT NULL,
  `relat_id_loja` INT NOT NULL,
  PRIMARY KEY (`relat_id`),
  INDEX `fk_loja_relatorio_idx` (`relat_id_loja` ASC),
  CONSTRAINT `fk_loja_relatorio`
    FOREIGN KEY (`relat_id_loja`)
    REFERENCES `sem_aglomerar`.`Loja` (`loja_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
