create database if not exists `moneytracker`;
show databases;
use `moneytracker`;
show tables;

CREATE TABLE `records`(
	`record_id` INT AUTO_INCREMENT,
	`user_id` INT NOT NULL,
    `category`  VARCHAR(20) NOT NULL,
    `date` DATE NOT NULL,
    `amount`  INT NOT NULL,
    `type`  VARCHAR(10) NOT NULL,
	`detail` VARCHAR(50) NOT NULL,
    primary key (`record_id`),
    FOREIGN KEY (`user_id`) REFERENCES `users`(`uid`) ON DELETE CASCADE
);
DESCRIBE `records`;
-- DROP TABLE `records`; 

INSERT INTO `records`(`user_id`, `category`, `date`, `amount`, `type`, `detail`) VALUES
    (1, 'Food', '2024-04-01', 49, 'Expense', 'breakfast'),
    (1, 'Food', '2024-04-01', 90, 'Expense', 'lunch'),
     (1, 'Food', '2024-04-02', 100, 'Expense', 'dinner'),
    (1, 'Housing', '2024-04-03', 6000, 'Expense', 'rent'),
    (1, 'Investment', '2024-04-23', 5000, 'Income', 'sell stocks'),
    (1, 'Food', '2024-04-26', 100, 'Expense', 'lunch'),
    (1, 'Clothing', '2024-04-27', 70, 'Expense', 'Uniqlo'),
    (1, 'Recreation', '2024-04-18', 300, 'Expense', 'watch movie'),
    (1, 'Healthcare', '2024-04-01', 150, 'Expense', 'common cold'),
    (1, 'Others', '2024-04-02', 70, 'Expense', 'daily supplies'),
    (1, 'Transport', '2024-04-11', 100, 'Expense', 'refueling a scooter'),
    (1, 'Others', '2024-04-15', 299, 'Expense', 'daily supplies');
    

-- show all records
SELECT * FROM `records`;
-- method 1, show Expense records of 1th user in April
SELECT `record_id`,`category`,`date`,`amount`,`type`,`detail` FROM `records` WHERE `user_id`=1 AND `date` LIKE '2024-04%' AND `type` = 'Expense';
-- method 2, show Expense records of 1th user in April
SELECT `record_id`,`category`,`date`,`amount`,`type`,`detail` FROM `records` WHERE `user_id`=1 AND MONTH(`date`) = 4 AND YEAR(`date`) = 2024 AND `type` = 'Expense';
-- calculate the amount of specific user with specific type and data range
SELECT SUM(`amount`) FROM `records` WHERE `user_id`=1 AND MONTH(`date`) = 4 AND YEAR(`date`) = 2024 AND `type` = 'Expense' AND `category` = 'Food';