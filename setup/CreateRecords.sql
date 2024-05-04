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
    (1, 'Food', '2023-05-01', 49, 'Expense', '早餐'),
    (1, 'Food', '2023-05-01', 90, 'Expense', '午餐'),
    (1, 'Clothing', '2023-05-02', 1906, 'Expense', 'GU'),
     (1, 'Food', '2023-05-02', 100, 'Expense', '晚餐'),
    (1, 'Housing', '2023-05-03', 6000, 'Expense', '房租'),
	(1, 'Housing', '2023-05-03', 520, 'Expense', '水電費'),
    (1, 'Transport', '2023-05-04', 100, 'Expense', '機車加油'),
    (1, 'Recreation', '2023-05-06', 400, 'Expense', '電影票'),
    (1, 'Healthcare', '2023-05-07', 180, 'Expense', '感冒'),
    (1, 'Others', '2023-05-08', 572, 'Expense', '生活用品'),
    (1, 'Part-Time', '2023-05-10', 500, 'Income', '代寫作業'),
    (1, 'Investment', '2023-05-17', 1482, 'Income', '股息'),
    (1, 'Healthcare', '2023-05-07', 680, 'Expense', '健身房月票'),
    (1, 'Others', '2023-05-13', 200, 'Income', '發票中獎'),
    (1, 'Food', '2023-05-14', 120, 'Expense', '晚餐'),
    (1, 'Clothing', '2023-05-15', 590, 'Expense', 'Uniqlo'),
	(1, 'Food', '2023-05-15', 180, 'Expense', '午餐'),
    (1, 'Transport', '2023-05-12', 290, 'Expense', '回彰化'),
    (1, 'Transport', '2023-05-14', 290, 'Expense', '回台南'),
    (1, 'Education', '2023-05-18', 390, 'Expense', '誠品買書'),
    (1, 'Recreation', '2023-05-19', 120, 'Expense', '遊樂園門票'),
    (1, 'Healthcare', '2023-05-20', 80, 'Expense', '購買藥品'),
    (1, 'Part-Time', '2023-05-22', 200, 'Income', '代寫作業'),
    (1, 'Investment', '2023-05-23', 5000, 'Income', '賣股票'),
    (1, 'Food', '2023-05-26', 100, 'Expense', '午餐'),
    (1, 'Clothing', '2023-05-27', 70, 'Expense', '購物'),
    (1, 'Recreation', '2023-05-31', 150, 'Expense', '休閒娛樂'),
    (1, 'Healthcare', '2023-05-01', 120, 'Expense', '感冒'),
    (1, 'Others', '2023-05-02', 70, 'Expense', '生活用品'),
    (1, 'Investment', '2023-05-05', 500, 'Income', '投資收益'),
    (1, 'Others', '2023-05-07', 500, 'Expense', '刮刮樂'),
    (1, 'Others', '2023-05-07', 700, 'Income', '刮刮樂'),
    (1, 'Food', '2023-05-08', 80, 'Expense', '早餐'),
    (1, 'Clothing', '2023-05-09', 70, 'Expense', '蝦皮'),
    (1, 'Transport', '2023-05-11', 100, 'Expense', '機車加油'),
    (1, 'Recreation', '2023-05-13', 150, 'Expense', '扭蛋'),
    (1, 'Others', '2023-05-15', 299, 'Expense', '生活用品');
    

-- show all records
SELECT * FROM `records`;
-- method 1, show Expense records of 1th user in May
SELECT `record_id`,`category`,`date`,`amount`,`type`,`detail` FROM `records` WHERE `user_id`=1 AND `date` LIKE '2023-05%' AND `type` = 'Expense';
-- method 2, show Expense records of 1th user in May
SELECT `record_id`,`category`,`date`,`amount`,`type`,`detail` FROM `records` WHERE `user_id`=1 AND MONTH(`date`) = 5 AND YEAR(`date`) = 2023 AND `type` = 'Expense';
-- update record
UPDATE `records` SET `category` = 'Food', `date` = ?, `amount` = ?, `type` = 'Expense', `detail` = '晚餐' WHERE `user_id` = 1 AND `record_id` = 1;
-- calculate the amount of specific user with specific type and data range
SELECT SUM(`amount`) FROM `records` WHERE `user_id`=1 AND MONTH(`date`) = 5 AND YEAR(`date`) = 2023 AND `type` = 'Expense' AND `category` = 'Food';