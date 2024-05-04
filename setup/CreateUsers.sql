create database if not exists `moneytracker`;
show databases;
use `moneytracker`;
show tables;

CREATE TABLE if not exists `users`(
	`uid` INT AUTO_INCREMENT,
    `name`  VARCHAR(20) NOT NULL UNIQUE,
    `email`  VARCHAR(20) NOT NULL UNIQUE,
    `phone`  VARCHAR(20) NOT NULL UNIQUE,
	`password` VARCHAR(20) NOT NULL,
    primary key (`uid`)
);
DESCRIBE `users`;
-- DROP TABLE `users`;

INSERT INTO `users` VALUES(NULL, 'admin', 'admin888@gmail.com', '0988888888', '8888');
INSERT INTO `users` VALUES(NULL, 'test', 'test@gmail.com', 0912345678, '1234');
INSERT INTO `users` VALUES(NULL, 'john', 'jonh0428@gmail.com', '0914856247', '1111');


-- show all users
SELECT * FROM `users`;
SELECT * FROM `users` WHERE `name`='admin' AND `password`='8888';



