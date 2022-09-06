-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema citasMedicas
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema citasMedicas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `citasMedicas` DEFAULT CHARACTER SET utf8 ;
USE `citasMedicas` ;

-- -----------------------------------------------------
-- Table `citasMedicas`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `citasMedicas`.`user` (
  `username` VARCHAR(40) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userLastName` VARCHAR(45) NOT NULL,
  `userNum` VARCHAR(45) NOT NULL,
  `userId` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`userId`));


-- -----------------------------------------------------
-- Table `citasMedicas`.`workers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `citasMedicas`.`workers` (
  `idworkers` INT NOT NULL AUTO_INCREMENT,
  `workerName` VARCHAR(45) NOT NULL,
  `workerLastName` VARCHAR(45) NOT NULL,
  `workerEmployment` VARCHAR(45) NOT NULL,
  `workerSalary` DOUBLE NOT NULL,
  `workerTel` VARCHAR(45) NOT NULL,
  `typeContract` VARCHAR(45) NOT NULL,
  `workerPassword` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idworkers`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `citasMedicas`.`doctors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `citasMedicas`.`doctors` (
  `idDoctor` INT NOT NULL AUTO_INCREMENT,
  `area` VARCHAR(45) NOT NULL,
  `id_workers` INT NOT NULL,
  PRIMARY KEY (`idDoctor`),
  INDEX `fk_doctors_workers1_idx` (`id_workers` ASC) VISIBLE,
  CONSTRAINT `fk_doctors_workers1`
    FOREIGN KEY (`id_workers`)
    REFERENCES `citasMedicas`.`workers` (`idworkers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `citasMedicas`.`user_has_doctors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `citasMedicas`.`user_has_doctors` (
  `user_userId` INT NOT NULL,
  `doctors_idDoctor` INT NOT NULL,
  `id_usersDoctors` INT NOT NULL AUTO_INCREMENT,
  INDEX `fk_user_has_doctors_doctors1_idx` (`doctors_idDoctor` ASC) VISIBLE,
  INDEX `fk_user_has_doctors_user_idx` (`user_userId` ASC) VISIBLE,
  PRIMARY KEY (`id_usersDoctors`),
  CONSTRAINT `fk_user_has_doctors_user`
    FOREIGN KEY (`user_userId`)
    REFERENCES `citasMedicas`.`user` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_doctors_doctors1`
    FOREIGN KEY (`doctors_idDoctor`)
    REFERENCES `citasMedicas`.`doctors` (`idDoctor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `citasMedicas`.`medicine`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `citasMedicas`.`medicine` (
  `idmedicine` INT NOT NULL AUTO_INCREMENT,
  `medicine_name` VARCHAR(45) NOT NULL,
  `medicine_amount` INT NOT NULL,
  `medicine_dose` INT NOT NULL,
  PRIMARY KEY (`idmedicine`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `citasMedicas`.`medicalFormula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `citasMedicas`.`medicalFormula` (
  `idmedicalFormula` INT NOT NULL AUTO_INCREMENT,
  `medical_formula_date` DATE NOT NULL,
  `doctors_idDoctor` INT NOT NULL,
  `user_userId` INT NOT NULL,
  `medicine_idmedicine` INT NOT NULL,
  PRIMARY KEY (`idmedicalFormula`),
  INDEX `fk_medicalFormula_doctors1_idx` (`doctors_idDoctor` ASC) VISIBLE,
  INDEX `fk_medicalFormula_user1_idx` (`user_userId` ASC) VISIBLE,
  INDEX `fk_medicalFormula_medicine1_idx` (`medicine_idmedicine` ASC) VISIBLE,
  CONSTRAINT `fk_medicalFormula_doctors1`
    FOREIGN KEY (`doctors_idDoctor`)
    REFERENCES `citasMedicas`.`doctors` (`idDoctor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_medicalFormula_user1`
    FOREIGN KEY (`user_userId`)
    REFERENCES `citasMedicas`.`user` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_medicalFormula_medicine1`
    FOREIGN KEY (`medicine_idmedicine`)
    REFERENCES `citasMedicas`.`medicine` (`idmedicine`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `citasMedicas`.`medical_appointment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `citasMedicas`.`medical_appointment` (
  `idmedical_appointment` INT NOT NULL AUTO_INCREMENT,
  `user_userId` INT NOT NULL,
  `doctors_idDoctor` INT NOT NULL,
  `medicalFormula_idmedicalFormula` INT NOT NULL,
  `observations` TEXT NOT NULL,
  PRIMARY KEY (`idmedical_appointment`),
  INDEX `fk_medical_appointment_user1_idx` (`user_userId` ASC) VISIBLE,
  INDEX `fk_medical_appointment_doctors1_idx` (`doctors_idDoctor` ASC) VISIBLE,
  INDEX `fk_medical_appointment_medicalFormula1_idx` (`medicalFormula_idmedicalFormula` ASC) VISIBLE,
  CONSTRAINT `fk_medical_appointment_user1`
    FOREIGN KEY (`user_userId`)
    REFERENCES `citasMedicas`.`user` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_medical_appointment_doctors1`
    FOREIGN KEY (`doctors_idDoctor`)
    REFERENCES `citasMedicas`.`doctors` (`idDoctor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_medical_appointment_medicalFormula1`
    FOREIGN KEY (`medicalFormula_idmedicalFormula`)
    REFERENCES `citasMedicas`.`medicalFormula` (`idmedicalFormula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
