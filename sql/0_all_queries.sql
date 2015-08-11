CREATE DATABASE `ewl` DEFAULT CHARACTER SET utf8;

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

USE `ewl`;
SET NAMES `utf8` COLLATE `utf8_unicode_ci`;
INSERT INTO `dictionary` (`eng`,`ru`,`correct`,`total`) VALUES ('staffworker','сотрудник','0','0');
INSERT INTO `dictionary` (`eng`,`ru`,`correct`,`total`) VALUES ('reliability','надежность','0','0');
INSERT INTO `dictionary` (`eng`,`ru`,`correct`,`total`) VALUES ('recognition','признание','0','0');
INSERT INTO `dictionary` (`eng`,`ru`,`correct`,`total`) VALUES ('worthwhile','стоящий','0','0');
INSERT INTO `dictionary` (`eng`,`ru`,`correct`,`total`) VALUES ('lawn','лужайка','0','0');
INSERT INTO `dictionary` (`eng`,`ru`,`correct`,`total`) VALUES ('slight','легкий','0','0');
INSERT INTO `dictionary` (`eng`,`ru`,`correct`,`total`) VALUES ('standstill','тупик','0','0');
INSERT INTO `dictionary` (`eng`,`ru`,`correct`,`total`) VALUES ('tap','нажать','0','0');
INSERT INTO `dictionary` (`eng`,`ru`,`correct`,`total`) VALUES ('recently','недавно','0','0');
INSERT INTO `dictionary` (`eng`,`ru`,`correct`,`total`) VALUES ('throwback','движение назад','0','0');
INSERT INTO `dictionary` (`eng`,`ru`,`correct`,`total`) VALUES ('valiant','храбрый','0','0');
INSERT INTO `dictionary` (`eng`,`ru`,`correct`,`total`) VALUES ('stick','придерживаться','0','0');
INSERT INTO `dictionary` (`eng`,`ru`,`correct`,`total`) VALUES ('consider','учитывать','0','0');
INSERT INTO `dictionary` (`eng`,`ru`,`correct`,`total`) VALUES ('barely','проживание','0','0');
INSERT INTO `dictionary` (`eng`,`ru`,`correct`,`total`) VALUES ('unexpected','неожиданный','0','0');
INSERT INTO `dictionary` (`eng`,`ru`,`correct`,`total`) VALUES ('dayoff','отгул','0','0');
INSERT INTO `dictionary` (`eng`,`ru`,`correct`,`total`) VALUES ('pour','лить','0','0');
INSERT INTO `dictionary` (`eng`,`ru`,`correct`,`total`) VALUES ('reply','отвечать','0','0');
INSERT INTO `dictionary` (`eng`,`ru`,`correct`,`total`) VALUES ('sigh','вздох','0','0');
INSERT INTO `dictionary` (`eng`,`ru`,`correct`,`total`) VALUES ('mostly','по большей части','0','0');