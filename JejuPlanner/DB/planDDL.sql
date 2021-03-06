DROP TABLE IF EXISTS `plan`;

CREATE TABLE `plan` (
	`planNo` INT(10) NOT NULL AUTO_INCREMENT,
	`userId` VARCHAR(50) NOT NULL,
	`regDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`planTitle` VARCHAR(200) NOT NULL,
	`startDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`planTotalDay` INT NOT NULL,
	PRIMARY KEY (`planNo`, `userId`) USING BTREE,
	INDEX `PLAN_FK_SET` (`userId`) USING BTREE,
	CONSTRAINT `PLAN_FK_SET` FOREIGN KEY (`userId`) REFERENCES `project`.`member` (`userId`) ON UPDATE NO ACTION ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/* INSERT DUMMY DATA */
INSERT INTO `plan` (userId, planTitle, planTotalDay) 
VALUES ('member2', '제주플래너', '5');

INSERT INTO `plan` (userId, planTitle, planTotalDay) 
VALUES ('member2', '제주여행2', '3');
			