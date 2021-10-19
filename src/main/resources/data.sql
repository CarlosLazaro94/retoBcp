DROP TABLE IF EXISTS ExchangeRate;

CREATE TABLE ExchangeRate (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              originCoin VARCHAR(250) NOT NULL,
                              destinyCoin VARCHAR(250) NOT NULL,
                              value VARCHAR(250) NOT NULL,
                              status VARCHAR(250) DEFAULT NULL
);

insert into ExchangeRate (originCoin,destinyCoin,value,status) VALUES ('PEN','USD','0.25','1');
insert into ExchangeRate (originCoin,destinyCoin,value,status) VALUES ('USD','PEN','3.95','1');
insert into ExchangeRate (originCoin,destinyCoin,value,status) VALUES ('PEN','EUR','0.22','1');
insert into ExchangeRate (originCoin,destinyCoin,value,status) VALUES ('EUR','PEN','4.58','1');
insert into ExchangeRate (originCoin,destinyCoin,value,status) VALUES ('EUR','USD','1.16','1');
insert into ExchangeRate (originCoin,destinyCoin,value,status) VALUES ('USD','EUR','0.86','1');