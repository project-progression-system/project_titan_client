"CREATE TABLE IF NOT EXISTS `Assignment` (
`id` 				TEXT NOT NULL, 
`name` 				TEXT NOT NULL, 
`points` 			INTEGER NOT NULL, 
`author` 			TEXT NOT NULL, 
`user_id` 			INTEGER NOT NULL, 
PRIMARY KEY(`id`), 
FOREIGN KEY(`id`) REFERENCES `User`(`user_id`) ON UPDATE NO ACTION ON DELETE CASCADE )",	 
	 
"CREATE TABLE IF NOT EXISTS `User` 
`user_id` 			INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 
`name` 				TEXT, 
`author` 			TEXT, 
`type` 				TEXT, 
`subject` 			TEXT
	 
"CREATE  INDEX `index_User_type` ON `type` 
`type`
