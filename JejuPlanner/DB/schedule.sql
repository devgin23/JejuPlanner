CREATE TABLE `scheduleTest` (
	`planNo` INT NOT NULL,
	`userId` VARCHAR(50) NOT NULL,
	`descript` VARCHAR(200) NULL DEFAULT NULL,
	`addr` VARCHAR(50) NOT NULL,
	`planDay` VARCHAR(5) NOT NULL,
	`startTime` INT NULL DEFAULT '900',
	`rowNo` INT NOT NULL,
	INDEX `SCHEDULE_FK_SETTest` (`planNo`, `userId`) USING BTREE,
	CONSTRAINT `SCHEDULE_FK_SETTest` FOREIGN KEY (`planNo`, `userId`) REFERENCES `project`.`plan` (`planNo`, `userId`) ON UPDATE NO ACTION ON DELETE CASCADE
)