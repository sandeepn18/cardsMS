CREATE TABLE IF NOT EXISTS `cards` (
                                       `card_id` int NOT NULL AUTO_INCREMENT,
                                       `mobile_number` varchar(15) NOT NULL,
    `card_number` varchar(100) ,
    `card_type` varchar(100),
    `total_limit` int ,
    `amount_used` int ,
    `available_amount` int ,
    `created_at` date ,
    `created_by` varchar(20) ,
    `updated_at` date ,
    `updated_by` varchar(20) ,
    PRIMARY KEY (`card_id`)
    );