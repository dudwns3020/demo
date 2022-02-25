DROP DATABASE IF EXISTS test;
CREATE DATABASE test;
USE test;

CREATE TABLE article(
id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
regDate DATETIME NOT NULL,
updateDate DATETIME NOT NULL,
title CHAR(100) NOT NULL,
`body` TEXT NOT NULL
);

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = 'title1',
`body` = 'body1';

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = 'title2',
`body` = 'body2';

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = 'title3',
`body` = 'body3';

select *
from article