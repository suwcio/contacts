insert into person(firstname, lastname, sex) values ('Piotr', 'Kowalski', 'M');
insert into person(firstname, lastname, sex) values ('Ewelina', 'Kowalska', 'K');

insert into phone_number(phone_number, person_id) values ('111222333', 1);
insert into phone_number(phone_number, person_id) values ('444555666', 2);

insert into email_address(email_address, person_id) values ('pkowalski@email.pl', 1);
insert into email_address(email_address, person_id) values ('ekowalska@email.pl', 2);