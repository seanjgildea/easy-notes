
INSERT INTO `notes_app`.`platform` (`id`, `name`) VALUES ('19', 'Gamecube');
INSERT INTO `notes_app`.`platform` (`id`, `name`) VALUES ('1', 'PS4');
INSERT INTO `notes_app`.`platform` (`id`, `name`) VALUES ('2', 'XBOX One');
INSERT INTO `notes_app`.`platform` (`id`, `name`) VALUES ('3', 'Switch');
INSERT INTO `notes_app`.`platform` (`id`, `name`) VALUES ('4', 'iTunes');
INSERT INTO `notes_app`.`platform` (`id`, `name`) VALUES ('5', 'Mobile');
INSERT INTO `notes_app`.`platform` (`id`, `name`) VALUES ('6', '3DS');
INSERT INTO `notes_app`.`platform` (`id`, `name`) VALUES ('7', 'PS3');
INSERT INTO `notes_app`.`platform` (`id`, `name`) VALUES ('8', 'WiiU');
INSERT INTO `notes_app`.`platform` (`id`, `name`) VALUES ('9', 'PC');
INSERT INTO `notes_app`.`platform` (`id`, `name`) VALUES ('10', 'Wii');
INSERT INTO `notes_app`.`platform` (`id`, `name`) VALUES ('11', 'NES');
INSERT INTO `notes_app`.`platform` (`id`, `name`) VALUES ('12', 'XBOX');
INSERT INTO `notes_app`.`platform` (`id`, `name`) VALUES ('13', 'N64');
INSERT INTO `notes_app`.`platform` (`id`, `name`) VALUES ('14', 'PS2');
INSERT INTO `notes_app`.`platform` (`id`, `name`) VALUES ('15', 'SNES');
INSERT INTO `notes_app`.`platform` (`id`, `name`) VALUES ('16', 'PS1');
INSERT INTO `notes_app`.`platform` (`id`, `name`) VALUES ('17', 'Genesis');
INSERT INTO `notes_app`.`platform` (`id`, `name`) VALUES ('18', 'Dreamcast');
INSERT INTO `notes_app`.`platform` (`id`, `name`) VALUES ('0', 'Please Select One');

INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('1', 'Apple');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('2', 'Autos');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('3', 'Bags & Luggage');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('4', 'Books & Magazines');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('5', 'Children');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('6', 'Clothing & Accessories');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('7', 'Computers');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('8', 'Education');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('9', 'Entertainment');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('10', 'Finance');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('11', 'Flowers & Gifts');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('12', 'Freebies');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('13', 'Grocery');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('14', 'Health & Beauty');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('15', 'Home & Home Improvement');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('16', 'Movies');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('17', 'Occasions');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('18', 'Office');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('19', 'Other');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('20', 'Pets');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('21', 'Phones');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('22', 'Restaurants');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('23', 'Services');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('24', 'Shoes');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('25', 'Sporting Goods');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('26', 'Tech & Electronics');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('27', 'Travel & Vacations');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('28', 'TV');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('29', 'Video Games');
INSERT INTO `notes_app`.`category` (`id`, `name`) VALUES ('30', 'Classifieds');

INSERT INTO `notes_app`.`login` (`id`, `user_name`, `password`) VALUES ('1', 'user', '$2a$12$/hCwQGwE9OnrDx2zTbBFBO0gAb9j6pmeCrBwfc3DhvPBYR6iPl5i6');

INSERT INTO `notes_app`.`user` (`id`, `email`, `password`, `username`) VALUES ('1','test@test.com', '$2y$12$/hCwQGwE9OnrDx2zTbBFBO0gAb9j6pmeCrBwfc3DhvPBYR6iPl5i6', 'test');
INSERT INTO `notes_app`.`user` (`id`, `email`, `password`, `username`) VALUES ('2','user@aol.com', '$2y$12$/hCwQGwE9OnrDx2zTbBFBO0gAb9j6pmeCrBwfc3DhvPBYR6iPl5i6', 'user');

INSERT INTO `notes_app`.`game` (`id`, `description`, `link`, `price`, `title`, `platform_id`, `user_id`) VALUES ('1', 'at Best Buy', 'http://bestbuy.com', '29.99', 'Spyro Reignited Trilogy', '3', '1');
INSERT INTO `notes_app`.`game` (`id`, `description`, `link`, `price`, `title`, `platform_id`, `user_id`) VALUES ('2', 'at Gamestop', 'http://gamestop.com', '9.97', 'No Mans Sky', '7', '1');
INSERT INTO `notes_app`.`game` (`id`, `description`, `link`, `price`, `title`, `platform_id`, `user_id`) VALUES ('3', 'at Target', 'http://gamestop.com', '49.97', 'Legend of Zelda', '12', '1');
INSERT INTO `notes_app`.`game` (`id`, `description`, `link`, `price`, `title`, `platform_id`, `user_id`) VALUES ('4', 'at Childs World', 'http://gamestop.com', '24.99', 'Clu Clu Land', '13', '2');
INSERT INTO `notes_app`.`game` (`id`, `description`, `link`, `price`, `title`, `platform_id`, `user_id`) VALUES ('5', 'at Walmart', 'http://walmart.com', '19.99', 'Lolos Adventures', '4', '2');
INSERT INTO `notes_app`.`game` (`id`, `description`, `link`, `price`, `title`, `platform_id`, `user_id`) VALUES ('6', 'at GameStop normally $19.99', 'http://Gamestop.com', '9.99', 'Last of Us Special Edition', '1', '2');
INSERT INTO `notes_app`.`game` (`id`, `description`, `link`, `price`, `title`, `platform_id`, `user_id`) VALUES ('7', 'half off at Gamestop', 'http://Gamestop.com', '19.99', 'Tetris Effect', '5', '2');



