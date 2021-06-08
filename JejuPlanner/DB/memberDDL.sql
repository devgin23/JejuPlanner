DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`userId` VARCHAR(30) NOT NULL,
	`userPw` VARCHAR(60) NOT NULL,
	`userNo` INT NOT NULL AUTO_INCREMENT,
	`userGender` VARCHAR(2) NOT NULL,
	`userAge` INT NOT NULL,
	`userMail` VARCHAR(40) NOT NULL,
	`regDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`userNo`, `userId`),
	UNIQUE INDEX `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/* INSERT DUMMY DATA */
INSERT INTO member (userId, userPw, userGender, userAge, userMail) 
VALUES ('test1', '123', '남', 20, 'test1@abcd.com');