CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(16) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `version` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnerDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;