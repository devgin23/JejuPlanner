DROP TABLE IF EXISTS `schedule`;

CREATE TABLE `schedule` (
	`planNo` INT NOT NULL,
	`userId` VARCHAR(50) NOT NULL,
	`descript` VARCHAR(200) NULL DEFAULT NULL,
	`addr` VARCHAR(50) NOT NULL,
	`planDay` VARCHAR(5) NOT NULL,
	`startTime` INT NULL DEFAULT '900',
	`rowNo` INT,
	INDEX `SCHEDULE_FK_SET` (`planNo`, `userId`) USING BTREE,
	CONSTRAINT `SCHEDULE_FK_SET` FOREIGN KEY (`planNo`, `userId`) REFERENCES `project`.`plan` (`planNo`, `userId`) ON UPDATE NO ACTION ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* INSERT DUMMY DATA */
INSERT INTO `schedule` (planNo, userId, descript, addr, planDay) 
VALUES ('2', 'member2', 'asdf', 'asdf', '3');

INSERT INTO `schedule` (planNo, userId, descript, addr, planDay) 
VALUES ('1', 'member1', '등산', '한라산', '3');

INSERT INTO `schedule` (planNo, userId, descript, addr, planDay) 
VALUES ('1', 'member1', 'test', 'test', '3');


INSERT INTO `schedule` (planNo, userId, descript, addr, planDay) 
VALUES ('2', 'member2', '코딩', '제주호텔', '3');

INSERT INTO `schedule` (planNo, userId, descript, addr, planDay) 
VALUES ('2', 'member2', '낮잠', '제주호텔', '3');