--
-- Table structure for table `config_control`
--

CREATE TABLE `config_control` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reference` varchar(250) DEFAULT NULL,
  `config_value` varchar(250) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table `user`
--

CREATE TABLE `user_data` (
  `id` int(11) NOT NULL,
  `password` varchar(90) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `is_active` BIT NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


--
-- Table structure for table `config_auth`
--

CREATE TABLE `config_auth` (
  `id_user` int(11) NOT NULL,
  `token` varchar(255) NOT NULL,
  `date_login` datetime NOT NULL,
  `date_refresh` datetime NOT NULL,
  PRIMARY KEY (`id_user`),
  CONSTRAINT `fk_config_auth_id_user` FOREIGN KEY (`id_user`) REFERENCES `user_data` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table `nutrition_goals`
--

CREATE TABLE `nutrition_goals` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `calories` NUMERIC(15,4) NOT NULL,
  `proteins` NUMERIC(15,4) NOT NULL,
  `carbohydrates` NUMERIC(15,4) NOT NULL,
  `fat` NUMERIC(15,4) NOT NULL,
  `fat_mono` NUMERIC(15,4) DEFAULT NULL,
  `fat_poli` NUMERIC(15,4) DEFAULT NULL,
  `fat_sat` NUMERIC(15,4) DEFAULT NULL,
  `fat_trans` NUMERIC(15,4) DEFAULT NULL,
  `carb_sugar` NUMERIC(15,4) DEFAULT NULL,
  `carb_sugar_added` NUMERIC(15,4) DEFAULT NULL,
  `fiber` NUMERIC(15,4) DEFAULT NULL,
  `cholesterol` NUMERIC(15,4) DEFAULT NULL,
  `sodium` NUMERIC(15,4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Table structure for table `recipe`
--

CREATE TABLE `recipe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `instructions` mediumtext NOT NULL,
  `title` mediumtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table `diet`
--

CREATE TABLE `diet` (
  `id_recipe` int(11) NOT NULL,
  `total_quantity_grams` NUMERIC(15,4) NOT NULL,
  `total_calories` NUMERIC(15,4) NOT NULL,
  `total_carbohydrates` NUMERIC(15,4) NOT NULL,
  `total_proteins` NUMERIC(15,4) NOT NULL,
  `total_fat` NUMERIC(15,4) NOT NULL,
  `total_fat_mono` NUMERIC(15,4) DEFAULT NULL,
  `total_fat_poli` NUMERIC(15,4) DEFAULT NULL,
  `total_fat_sat` NUMERIC(15,4) DEFAULT NULL,
  `total_fat_trans` NUMERIC(15,4) DEFAULT NULL,
  `total_carb_sugar` NUMERIC(15,4) DEFAULT NULL,
  `total_carb_sugar_added` NUMERIC(15,4) DEFAULT NULL,
  `total_fiber` NUMERIC(15,4) DEFAULT NULL,
  `total_cholesterol` NUMERIC(15,4) DEFAULT NULL,
  `total_sodium` NUMERIC(15,4) DEFAULT NULL,
  `is_base` BIT NOT NULL,
  PRIMARY KEY (`id_recipe`),
  KEY `FK_diet_recipe_idx` (`id_recipe`),
  CONSTRAINT `FK_diet_recipe` FOREIGN KEY (`id_recipe`) REFERENCES `recipe` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table `food`
--

CREATE TABLE `food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `quantity_grams` NUMERIC(15,4) NOT NULL,
  `calories` NUMERIC(15,4) NOT NULL,
  `carbohydrates` NUMERIC(15,4) NOT NULL,
  `proteins` NUMERIC(15,4) NOT NULL,
  `fat` NUMERIC(15,4) NOT NULL,
  `price` NUMERIC(15,4) NOT NULL,
  `cost_calorie` NUMERIC(15,4) NOT NULL,
  `cost_protein` NUMERIC(15,4) NOT NULL,
  `unity_grams` NUMERIC(15,4) NOT NULL,
  `fat_mono` NUMERIC(15,4) DEFAULT NULL,
  `fat_poli` NUMERIC(15,4) DEFAULT NULL,
  `fat_sat` NUMERIC(15,4) DEFAULT NULL,
  `fat_trans` NUMERIC(15,4) DEFAULT NULL,
  `carb_sugar` NUMERIC(15,4) DEFAULT NULL,
  `carb_sugar_added` NUMERIC(15,4) DEFAULT NULL,
  `fiber` NUMERIC(15,4) DEFAULT NULL,
  `cholesterol` NUMERIC(15,4) DEFAULT NULL,
  `sodium` NUMERIC(15,4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table `diet_food`
--

CREATE TABLE `diet_food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_diet` int(11) NOT NULL,
  `id_food` int(11) NOT NULL,
  `portions` NUMERIC(15,4) NOT NULL,
  `unities` NUMERIC(15,4) NOT NULL,
  `total_quantity_grams` NUMERIC(15,4) NOT NULL,
  `total_calories` NUMERIC(15,4) NOT NULL,
  `total_carbohydrates` NUMERIC(15,4) NOT NULL,
  `total_proteins` NUMERIC(15,4) NOT NULL,
  `total_fat` NUMERIC(15,4) NOT NULL,
  `total_fat_mono` NUMERIC(15,4) DEFAULT NULL,
  `total_fat_poli` NUMERIC(15,4) DEFAULT NULL,
  `total_fat_sat` NUMERIC(15,4) DEFAULT NULL,
  `total_fat_trans` NUMERIC(15,4) DEFAULT NULL,
  `total_carb_sugar` NUMERIC(15,4) DEFAULT NULL,
  `total_carb_sugar_added` NUMERIC(15,4) DEFAULT NULL,
  `total_fiber` NUMERIC(15,4) DEFAULT NULL,
  `total_cholesterol` NUMERIC(15,4) DEFAULT NULL,
  `total_sodium` NUMERIC(15,4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_diet_food_food` (`id_food`),
  KEY `FK_diet_food_recipe_build` (`id_diet`),
  CONSTRAINT `FK_diet_food_food` FOREIGN KEY (`id_food`) REFERENCES `food` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_diet_food_recipe_build` FOREIGN KEY (`id_diet`) REFERENCES `diet` (`id_recipe`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=916 DEFAULT CHARSET=utf8mb4;