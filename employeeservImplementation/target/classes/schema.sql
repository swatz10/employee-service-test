CREATE TABLE IF NOT EXISTS `employee`(
   `id` INT(11) unsigned NOT NULL AUTO_INCREMENT,
   `first_name` VARCHAR(255) NOT NULL,
   `last_name` VARCHAR(255) NOT NULL,
   `dob` DATE NOT NULL,
   `address_id` INT(11) unsigned NOT NULL
);

CREATE TABLE IF NOT EXISTS `address`(
   `id` INT(11) unsigned NOT NULL AUTO_INCREMENT,
   `line1` VARCHAR(255) NOT NULL,
   `line2` VARCHAR(255) DEFAULT NULL,
   `city` VARCHAR(255) NOT NULL,
   `state` VARCHAR(255) NOT NULL,
   `country` VARCHAR(255) NOT NULL,
   `zip_code` INT(11) unsigned NOT NULL
);