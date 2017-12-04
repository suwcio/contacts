insert into person(firstname, lastname, sex) values ('Piotr', 'Kowalski', 'M');
insert into person(firstname, lastname, sex) values ('Ewelina', 'Kowalska', 'K');
insert into person(firstname, lastname, sex) values ('Mateusz', 'Fryc', 'M');
insert into person(firstname, lastname, sex) values ('Aleksandra', 'Fryc', 'K');

insert into phone_number(phone_number, person_id) values ('111222333', 1);
insert into phone_number(phone_number, person_id) values ('444555666', 2);
insert into phone_number(phone_number, person_id) values ('222333444', 3);
insert into phone_number(phone_number, person_id) values ('999888777', 3);

insert into email_address(email_address, person_id) values ('pkowalski@email.pl', 1);
insert into email_address(email_address, person_id) values ('ekowalska@email.pl', 2);
insert into email_address(email_address, person_id) values ('mfryc@email.pl', 3);
insert into email_address(email_address, person_id) values ('mfryc2@email.pl', 3);
insert into email_address(email_address, person_id) values ('mfryc3@email.pl', 3);