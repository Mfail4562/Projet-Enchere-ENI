ALTER TABLE `encheres`.`utilisateurs` 
ADD UNIQUE INDEX `no_utilisateur_UNIQUE` (`no_utilisateur` ASC) VISIBLE,
ADD UNIQUE INDEX `pseudo_UNIQUE` (`pseudo` ASC) VISIBLE,
ADD UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE;
;