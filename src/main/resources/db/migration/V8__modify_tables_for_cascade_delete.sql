-- Изменяем таблицу request для добавления каскадного удаления
ALTER TABLE request
DROP CONSTRAINT IF EXISTS fk_request_destination,
    DROP CONSTRAINT IF EXISTS fk_request_cargo_type,
    ADD CONSTRAINT fk_request_destination
        FOREIGN KEY (destination_id)
        REFERENCES destination(destination_id)
        ON DELETE CASCADE,
    ADD CONSTRAINT fk_request_cargo_type
        FOREIGN KEY (cargo_type_id)
        REFERENCES cargotype(cargo_type_id)
        ON DELETE CASCADE;

-- Изменяем таблицу trip для добавления каскадного удаления
ALTER TABLE trip
DROP CONSTRAINT IF EXISTS fk_trip_driver,
    DROP CONSTRAINT IF EXISTS fk_trip_car,
    DROP CONSTRAINT IF EXISTS fk_trip_request,
    ADD CONSTRAINT fk_trip_driver
        FOREIGN KEY (driver_id)
        REFERENCES driver(driver_id)
        ON DELETE CASCADE,
    ADD CONSTRAINT fk_trip_car
        FOREIGN KEY (car_id)
        REFERENCES car(car_id)
        ON DELETE CASCADE,
    ADD CONSTRAINT fk_trip_request
        FOREIGN KEY (request_id)
        REFERENCES request(request_id)
        ON DELETE CASCADE;