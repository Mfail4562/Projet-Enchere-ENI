CREATE SCHEMA `encheres` ;

CREATE TABLE `encheres`.`categories` (
  `no_categorie` INT NOT NULL AUTO_INCREMENT,
  `libelle` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`no_categorie`));

  CREATE TABLE `encheres`.`utilisateurs` (
  `no_utilisateur` INT NOT NULL AUTO_INCREMENT,
  `pseudo` VARCHAR(30) NOT NULL,
  `nom` VARCHAR(30) NOT NULL,
  `prenom` VARCHAR(30) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `telephone` VARCHAR(15) NULL,
  `rue` VARCHAR(30) NOT NULL,
  `code_postal` VARCHAR(10) NOT NULL,
  `ville` VARCHAR(50) NOT NULL,
  `mot_de_passe` VARCHAR(50) NOT NULL,
  `credit` INT NOT NULL,
  `administrateur` BIT NOT NULL DEFAULT 0,
  PRIMARY KEY (`no_utilisateur`));

  CREATE TABLE `encheres`.`articles_vendus` (
  `no_article` INT NOT NULL AUTO_INCREMENT,
  `nom_article` VARCHAR(30) NOT NULL,
  `description` VARCHAR(300) NOT NULL,
  `date_debut_encheres` DATE NOT NULL,
  `date_fin_encheres` DATE NOT NULL,
  `prix_initial` INT NULL,
  `prix_vente` INT NULL,
  `no_utilisateur` INT NOT NULL,
  `no_categorie` INT NOT NULL,
  PRIMARY KEY (`no_article`));

  CREATE TABLE `encheres`.`retraits` (
  `no_article` INT NOT NULL,
  `rue` VARCHAR(30) NOT NULL,
  `code_postal` VARCHAR(15) NOT NULL,
  `ville` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`no_article`),
  CONSTRAINT `retrait_article_fk`
    FOREIGN KEY (`no_article`)
    REFERENCES `encheres`.`articles_vendus` (`no_article`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `encheres`.`encheres` (
  `no_enchere` INT NOT NULL AUTO_INCREMENT,
  `date_enchere` DATETIME NOT NULL,
  `montant_enchere` INT NOT NULL,
  `no_article` INT NOT NULL,
  `no_utilisateur` INT NOT NULL,
  PRIMARY KEY (`no_enchere`),
  INDEX `encheres_utilisateur_fk_idx` (`no_utilisateur` ASC) VISIBLE,
  INDEX `encheres_no_article_fk_idx` (`no_article` ASC) VISIBLE,
  CONSTRAINT `encheres_utilisateur_fk`
    FOREIGN KEY (`no_utilisateur`)
    REFERENCES `encheres`.`utilisateurs` (`no_utilisateur`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `encheres_no_article_fk`
    FOREIGN KEY (`no_article`)
    REFERENCES `encheres`.`articles_vendus` (`no_article`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

    ALTER TABLE `encheres`.`articles_vendus` 
ADD INDEX `articles_vendus_categories_fk_idx` (`no_categorie` ASC) VISIBLE,
ADD INDEX `ventes_utilisateur_fk_idx` (`no_utilisateur` ASC) VISIBLE;
;
ALTER TABLE `encheres`.`articles_vendus` 
ADD CONSTRAINT `articles_vendus_categories_fk`
  FOREIGN KEY (`no_categorie`)
  REFERENCES `encheres`.`categories` (`no_categorie`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `ventes_utilisateur_fk`
  FOREIGN KEY (`no_utilisateur`)
  REFERENCES `encheres`.`utilisateurs` (`no_utilisateur`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;