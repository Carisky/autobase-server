-- Add user_id column to driver table
ALTER TABLE driver
    ADD COLUMN user_id INTEGER;

-- Add foreign key constraint to user_id column
ALTER TABLE driver
    ADD CONSTRAINT fk_driver_user
        FOREIGN KEY (user_id)
            REFERENCES app_user(user_id)
            ON DELETE CASCADE;
