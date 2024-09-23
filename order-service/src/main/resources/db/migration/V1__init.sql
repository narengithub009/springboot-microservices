CREATE TABLE `t_orders` (
    `id` BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    `order_number` VARCHAR(255) DEFAULT NULL,
    `sku_code` VARCHAR(255),
    `price` DECIMAL(15, 2),
    `quantity` INT(11)
);