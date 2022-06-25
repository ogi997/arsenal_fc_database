-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db_arsenal
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_arsenal
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_arsenal` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `db_arsenal` ;

-- -----------------------------------------------------
-- Table `db_arsenal`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`stadium`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`stadium` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `capacity` INT NOT NULL,
  `date_built` DATE NOT NULL,
  `length` INT NULL,
  `width` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`country` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `country_id_for_city` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `country_id_for_city` (`country_id_for_city` ASC) VISIBLE,
  CONSTRAINT `country_id_for_city`
    FOREIGN KEY (`country_id_for_city`)
    REFERENCES `db_arsenal`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`rival`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`rival` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `stadium_id_for_rival` INT NOT NULL,
  `city_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idSTADIUM_idx` (`stadium_id_for_rival` ASC) VISIBLE,
  INDEX `city_id_idx` (`city_id` ASC) VISIBLE,
  CONSTRAINT `stadium_id_for_rival`
    FOREIGN KEY (`stadium_id_for_rival`)
    REFERENCES `db_arsenal`.`stadium` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `city_id`
    FOREIGN KEY (`city_id`)
    REFERENCES `db_arsenal`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`derby_level`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`derby_level` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `level` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`derby`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`derby` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rival_id` INT NOT NULL,
  `derby_level_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idFOOTBALL_CLUB_idx` (`rival_id` ASC) VISIBLE,
  INDEX `idDERBY_LEVEL_idx` (`derby_level_id` ASC) VISIBLE,
  CONSTRAINT `rival_id`
    FOREIGN KEY (`rival_id`)
    REFERENCES `db_arsenal`.`rival` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `derby_level_id`
    FOREIGN KEY (`derby_level_id`)
    REFERENCES `db_arsenal`.`derby_level` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`person` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) NOT NULL,
  `date_birth` DATE NOT NULL,
  `country_id_person` INT NOT NULL,
  `best_team` TINYINT(1) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `country_id_for_person` (`country_id_person` ASC) VISIBLE,
  CONSTRAINT `country_id`
    FOREIGN KEY (`country_id_person`)
    REFERENCES `db_arsenal`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`manager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`manager` (
  `person_id` INT NOT NULL AUTO_INCREMENT,
  `league_wins` INT NOT NULL,
  `cup_wins` INT NOT NULL,
  `games_won` INT NOT NULL,
  `games_draw` INT NOT NULL,
  `games_lost` INT NOT NULL,
  PRIMARY KEY (`person_id`),
  CONSTRAINT `person_id`
    FOREIGN KEY (`person_id`)
    REFERENCES `db_arsenal`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`player_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`player_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`foot`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`foot` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`position`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`position` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`player` (
  `person_id` INT NOT NULL AUTO_INCREMENT,
  `number` INT NOT NULL,
  `foot_id` INT NOT NULL,
  `position_id` INT NOT NULL,
  `player_role_id` INT NOT NULL,
  PRIMARY KEY (`person_id`),
  INDEX `idPLAYER_ROLE_idx` (`player_role_id` ASC) VISIBLE,
  INDEX `foot_id_idx` (`foot_id` ASC) VISIBLE,
  INDEX `position_id_idx` (`position_id` ASC) VISIBLE,
  CONSTRAINT `id`
    FOREIGN KEY (`person_id`)
    REFERENCES `db_arsenal`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `player_role_id`
    FOREIGN KEY (`player_role_id`)
    REFERENCES `db_arsenal`.`player_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `foot_id`
    FOREIGN KEY (`foot_id`)
    REFERENCES `db_arsenal`.`foot` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `position_id`
    FOREIGN KEY (`position_id`)
    REFERENCES `db_arsenal`.`position` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`famous_level`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`famous_level` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `level` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`famous`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`famous` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `famous_level_id` INT NOT NULL,
  `person_id_for_famous` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idFAMOUS_LEVEL_idx` (`famous_level_id` ASC) VISIBLE,
  INDEX `person_id_idx` (`person_id_for_famous` ASC) VISIBLE,
  CONSTRAINT `famous_level_id`
    FOREIGN KEY (`famous_level_id`)
    REFERENCES `db_arsenal`.`famous_level` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `person_id_for_famous`
    FOREIGN KEY (`person_id_for_famous`)
    REFERENCES `db_arsenal`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`seasone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`seasone` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `year` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`transfer_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`transfer_status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`transfer_club`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`transfer_club` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `club_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`transfer_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`transfer_history` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `player_id` INT NOT NULL,
  `transfer_status_id` INT NOT NULL,
  `price` DECIMAL(12,2) NOT NULL,
  `seasone_id` INT NOT NULL,
  `transfer_club_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idSEASONE_idx` (`seasone_id` ASC) VISIBLE,
  INDEX `idPLAYER_idx` (`player_id` ASC) VISIBLE,
  INDEX `transfer_status_id_idx` (`transfer_status_id` ASC) VISIBLE,
  INDEX `transfer_club_id_idx` (`transfer_club_id` ASC) VISIBLE,
  CONSTRAINT `seasone_id`
    FOREIGN KEY (`seasone_id`)
    REFERENCES `db_arsenal`.`seasone` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `player_id`
    FOREIGN KEY (`player_id`)
    REFERENCES `db_arsenal`.`player` (`person_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `transfer_status_id`
    FOREIGN KEY (`transfer_status_id`)
    REFERENCES `db_arsenal`.`transfer_status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `transfer_club_id`
    FOREIGN KEY (`transfer_club_id`)
    REFERENCES `db_arsenal`.`transfer_club` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`compatition`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`compatition` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`trophy_collection`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`trophy_collection` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `seasone_id_for_trophy` INT NOT NULL,
  `compatition_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idSEASONE_idx` (`seasone_id_for_trophy` ASC) VISIBLE,
  INDEX `compatition_id_idx` (`compatition_id` ASC) VISIBLE,
  CONSTRAINT `seasone_id_for_trophy`
    FOREIGN KEY (`seasone_id_for_trophy`)
    REFERENCES `db_arsenal`.`seasone` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `compatition_id`
    FOREIGN KEY (`compatition_id`)
    REFERENCES `db_arsenal`.`compatition` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`match`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`match` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rival_id` INT NOT NULL,
  `goals_scored` INT NOT NULL,
  `goals_received` INT NOT NULL,
  `seasone_id_for_match` INT NOT NULL,
  `game_id` INT NOT NULL,
  `date` DATE NOT NULL,
  `home` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idSEASONE_idx` (`seasone_id_for_match` ASC) VISIBLE,
  INDEX `idGAME_idx` (`game_id` ASC) VISIBLE,
  INDEX `rivals_id_idx` (`rival_id` ASC) VISIBLE,
  CONSTRAINT `seasone_id_for_match`
    FOREIGN KEY (`seasone_id_for_match`)
    REFERENCES `db_arsenal`.`seasone` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `game_id`
    FOREIGN KEY (`game_id`)
    REFERENCES `db_arsenal`.`compatition` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `rivals_id`
    FOREIGN KEY (`rival_id`)
    REFERENCES `db_arsenal`.`rival` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`contract`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`contract` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `signed` DATE NOT NULL,
  `expired` DATE NOT NULL,
  `market_value` DECIMAL(12,2) NOT NULL,
  `salary_week` DECIMAL(12,2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`contract_player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`contract_player` (
  `player_id_for_contract` INT NOT NULL AUTO_INCREMENT,
  `contract_id` INT NOT NULL,
  PRIMARY KEY (`player_id_for_contract`, `contract_id`),
  INDEX `idCONTRACT_idx` (`contract_id` ASC) VISIBLE,
  CONSTRAINT `player_id_for_contract`
    FOREIGN KEY (`player_id_for_contract`)
    REFERENCES `db_arsenal`.`player` (`person_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `contract_id`
    FOREIGN KEY (`contract_id`)
    REFERENCES `db_arsenal`.`contract` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`contract_manager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`contract_manager` (
  `manager_id` INT NOT NULL AUTO_INCREMENT,
  `contract_id_for_manager` INT NOT NULL,
  PRIMARY KEY (`manager_id`, `contract_id_for_manager`),
  INDEX `idCONTRACT_idx` (`contract_id_for_manager` ASC) VISIBLE,
  CONSTRAINT `manager_id`
    FOREIGN KEY (`manager_id`)
    REFERENCES `db_arsenal`.`manager` (`person_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `contract_id_for_manager`
    FOREIGN KEY (`contract_id_for_manager`)
    REFERENCES `db_arsenal`.`contract` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`football_club`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`football_club` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `stadium_id_for_fc` INT NOT NULL,
  `address` VARCHAR(150) NOT NULL,
  `contact` VARCHAR(150) NOT NULL,
  `founded` DATE NOT NULL,
  `owner` VARCHAR(150) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `nick_name` VARCHAR(45) NOT NULL,
  `city_id_for_fc` INT NOT NULL,
  `value` DECIMAL(12,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `stadium_id_idx` (`stadium_id_for_fc` ASC) VISIBLE,
  INDEX `city_id_idx` (`city_id_for_fc` ASC) VISIBLE,
  CONSTRAINT `stadium_id_for_fc`
    FOREIGN KEY (`stadium_id_for_fc`)
    REFERENCES `db_arsenal`.`stadium` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `city_id_for_fc`
    FOREIGN KEY (`city_id_for_fc`)
    REFERENCES `db_arsenal`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arsenal`.`first_team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arsenal`.`first_team` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `match_id` INT NOT NULL,
  `player_id_for_ft` INT NULL,
  `manager_id_for_ft` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `match_id_idx` (`match_id` ASC) VISIBLE,
  INDEX `player_id_idx` (`player_id_for_ft` ASC) VISIBLE,
  INDEX `manager_id_for_ft_idx` (`manager_id_for_ft` ASC) VISIBLE,
  CONSTRAINT `match_id`
    FOREIGN KEY (`match_id`)
    REFERENCES `db_arsenal`.`match` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `player_id_for_ft`
    FOREIGN KEY (`player_id_for_ft`)
    REFERENCES `db_arsenal`.`player` (`person_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `manager_id_for_ft`
    FOREIGN KEY (`manager_id_for_ft`)
    REFERENCES `db_arsenal`.`manager` (`person_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
