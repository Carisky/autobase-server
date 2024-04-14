-- Создаем таблицу водителей
create table driver
(
    driver_id  serial,
    name       varchar(100),
    experience integer,
    status     boolean,
    earnings   numeric(10, 2),
    primary key (driver_id)
);

-- Создаем таблицу автомобилей
create table car
(
    car_id            serial,
    brand             varchar(100),
    carrying_capacity integer,
    condition         boolean,
    primary key (car_id)
);

-- Создаем таблицу типов грузов
create table cargotype
(
    cargo_type_id serial,
    name          varchar(100),
    primary key (cargo_type_id)
);

-- Создаем таблицу для хранения пунктов назначения
create table destination
(
    destination_id serial,
    name           varchar(100),
    primary key (destination_id)
);

-- Создаем таблицу запросов
create table request
(
    request_id     serial,
    destination_id integer,
    cargo_quantity integer,
    cargo_type_id  integer,
    foreign key (destination_id) references destination(destination_id) on delete cascade,
    foreign key (cargo_type_id) references cargotype(cargo_type_id) on delete cascade,
    primary key (request_id)
);

-- Создаем таблицу поездок
create table trip
(
    trip_id           serial,
    driver_id         integer,
    car_id            integer,
    request_id        integer,
    status            boolean,
    intermediate_cost numeric(10, 2),
    foreign key (driver_id) references driver(driver_id) on delete cascade,
    foreign key (car_id) references car(car_id) on delete cascade,
    foreign key (request_id) references request(request_id) on delete cascade,
    primary key (trip_id)
);
