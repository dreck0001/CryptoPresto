--
-- Create database CryptoPresto
--

CREATE DATABASE IF NOT EXISTS CryptoPresto;
USE CryptoPresto;

--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(15) unsigned zerofill NOT NULL,
  `firstname` varchar(20) NOT NULL default '',
  `lastname` varchar(20) NOT NULL default '',
  `username` varchar(20) NOT NULL default '',
  `password` varchar(20) NOT NULL default '',
  `passwordConf` varchar(20) NOT NULL default '',
  `dateCreated` varchar(40) NOT NULL default '',
  PRIMARY KEY  (`id`)
);

--
-- Definition of table `portfolio`
--

DROP TABLE IF EXISTS `portfolio`;
CREATE TABLE `portfolio` (
  `id` int(15) unsigned zerofill NOT NULL,
  `user_id` int(15) unsigned zerofill NOT NULL,
  `asset_id` int(15) unsigned zerofill NOT NULL,
  `quantity` int(6) unsigned NOT NULL,
  PRIMARY KEY  (`id`)
);

--
-- Definition of table `assets`
--

DROP TABLE IF EXISTS `assets`;
CREATE TABLE `assets` (
  `id` int(15) unsigned zerofill NOT NULL,
  `asset` varchar(20) NOT NULL default '',
  `symbol` varchar(10) NOT NULL default '',
  `available` int(15) unsigned NOT NULL,
  `all_time_high` int(15) unsigned NOT NULL,
  `all_time_low` int(15) unsigned NOT NULL,
  `price` int(15) unsigned NOT NULL,
  
  PRIMARY KEY  (`id`)
);

--
-- Definition of table `bankAccounts`
--

DROP TABLE IF EXISTS `bankAccounts`;
CREATE TABLE `bankAccounts` (
  `id` int(15) unsigned zerofill NOT NULL,
  `userId` int(15) unsigned zerofill NOT NULL,
  `bankName` varchar(40) NOT NULL default '',
  `type` varchar(20) NOT NULL default '',
  `routingNumber` int(15) unsigned NOT NULL,
  `accountNumber` int(15) unsigned NOT NULL,
  
  PRIMARY KEY  (`id`)
);

--
-- Definition of table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
CREATE TABLE `transactions` (
  `id` int(15) unsigned zerofill NOT NULL,
  `user_id` int(15) unsigned zerofill NOT NULL,
  `type` varchar(20) NOT NULL default '',
  `asset_id` int(15) unsigned NOT NULL,
  `to_address` int(15) unsigned zerofill,
  
  PRIMARY KEY  (`id`)
);




-- --) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
-- --
-- --create database booksdb;
-- -- 
-- --use booksdb;
-- --SET GLOBAL time_zone = '+3:00';
-- --
-- --
-- --create table books(
-- --    isbn varchar(12),
-- --    title varchar(60),
-- --    authors varchar(30),
-- --    price double
-- --);
-- --    
-- --insert into books(isbn, title, authors, price)values("isbn1", "title1", "authors1", 1.1);
-- --insert into books(isbn, title, authors, price)values("isbn2", "title2", "authors2", 1.2);
-- --insert into books(isbn, title, authors, price)values("isbn3", "title3", "authors3", 1.3);
-- --insert into books(isbn, title, authors, price)values("isbn4", "title4", "authors4", 1.4);
-- --
-- --
-- --select * from books;
