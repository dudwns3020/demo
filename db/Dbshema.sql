DROP DATABASE IF EXISTS test;
CREATE DATABASE test;
USE test;

CREATE TABLE article(
id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
regDate DATETIME NOT NULL,
updateDate DATETIME NOT NULL,
memberId INT(10) UNSIGNED NOT NULL,
title CHAR(100) NOT NULL,
`body` TEXT NOT NULL
);

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
memberId = 1,
title = 'title1',
`body` = 'body1';

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
memberId = 2,
title = 'title2',
`body` = 'body2';

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
memberId = 3,
title = 'title3',
`body` = 'body3';

CREATE TABLE `member` (
id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
regDate DATETIME NOT NULL,
updateDate DATETIME NOT NULL,
loginId CHAR(20) NOT NULL,
loginPw CHAR(60) NOT NULL,
`name` CHAR(20) NOT NULL
);

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'user1',
loginPw = 'user1',
`name` = 'user1';

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'user2',
loginPw = 'user2',
`name` = 'user2';

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'user3',
loginPw = 'user3',
`name` = 'user3';

CREATE TABLE board (
id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
regDate DATETIME NOT NULL,
updateDate DATETIME NOT NULL,
`code` CHAR(20) NOT NULL UNIQUE,
`name` CHAR(20) NOT NULL UNIQUE
);

INSERT INTO board
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'notice',
`name` = '공지사항';

INSERT INTO board
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'free1',
`name` = '자유게시판';

ALTER TABLE article ADD COLUMN boardId INT(10) UNSIGNED NOT NULL AFTER `updateDate`;

UPDATE article
SET boardId = 1
WHERE id = 1;

UPDATE article
SET boardId = 2
WHERE id = 2;

UPDATE article
SET boardId = 3
WHERE id = 3;