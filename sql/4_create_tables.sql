USE `ewl`;

CREATE TABLE `dictionary` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`eng` VARCHAR(255) NOT NULL UNIQUE,
	`ru` VARCHAR(255) NOT NULL,
	/*
	 * 0 - learning (Status.LEARNING)
	 * 1 - learned (Status.LEARNED)
	 *
	 *`status` TINYINT NOT NULL CHECK (`status` IN (0, 1)),
	*/
	`correct` INTEGER,
	`total` INTEGER,
	PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARACTER SET `utf8`;

