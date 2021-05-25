DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`userId` VARCHAR(30) NOT NULL,
	`userPw` VARCHAR(30) NOT NULL,
	`userNo` INT NOT NULL AUTO_INCREMENT,
	`userNickname` VARCHAR(50) NOT NULL,
	`userGender` VARCHAR(2) NOT NULL,
	`userAge` INT NOT NULL,
	`userMail` VARCHAR(40) NOT NULL,
	`regDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`userNo`, `userId`),
	UNIQUE INDEX `userId` (`userId`)
);

/* INSERT DUMMY DATA */
INSERT INTO member (userId, userPw, userNickname, userGender, userAge, userMail) 
VALUES ('member1', '1234', '멤버1', '남', 20, 'member1@abcd.com');