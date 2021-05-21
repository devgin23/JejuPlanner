DROP TABLE IF EXISTS `plan`;

CREATE TABLE `plan` (
	`planNo` INT(10) NOT NULL AUTO_INCREMENT,
	`userId` VARCHAR(50) NOT NULL,
	`regDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`planTitle` VARCHAR(200) NOT NULL,
	`startDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`planTotalDay` INT NOT NULL,
	`planHit` INT NOT NULL DEFAULT '0',
	PRIMARY KEY (`planNo`, `userId`) USING BTREE,
	INDEX `PLAN_FK_SET` (`userId`) USING BTREE,
	CONSTRAINT `PLAN_FK_SET` FOREIGN KEY (`userId`) REFERENCES `project`.`member` (`userId`) ON UPDATE NO ACTION ON DELETE CASCADE
);

/* INSERT DUMMY DATA */
INSERT INTO `plan` (userId, planTitle, planTotalDay) 
VALUES ('member1', '제주여행1', '3');

INSERT INTO `plan` (userId, planTitle, planTotalDay) 
VALUES ('member2', '제주여행2', '3');

UPDATE plan 
SET	planTitle = '제주TEST', startDate = '2022-01-01', planTotalDate = '7'
WHERE userId = 'member1' AND planNo = '1';