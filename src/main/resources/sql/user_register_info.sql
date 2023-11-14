CREATE TABLE `user_register_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `process_instance_id` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  `apply_time` varchar(45) DEFAULT NULL,
  `manager_check_time` varchar(45) DEFAULT NULL,
  `superManager_check_time` varchar(45) DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

CREATE TABLE `user_photo_info` (
  `id` int(11) NOT NULL ,
  `photo` varchar(45) DEFAULT NULL,
  `IDCardphoto` varchar(45) DEFAULT NULL,
  `Passportphoto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_company_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `process_instance_id` varchar(20) DEFAULT NULL,
  `company_name` varchar(20) DEFAULT NULL,
  `bank_name` varchar(20) DEFAULT NULL,
  `account` varchar(45) DEFAULT NULL,
  `account_number` varchar(45) DEFAULT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  `apply_time` varchar(45) DEFAULT NULL,
  `manager_check_time` varchar(45) DEFAULT NULL,
  `superManager_check_time` varchar(45) DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;