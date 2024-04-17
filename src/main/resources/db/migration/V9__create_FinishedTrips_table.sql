CREATE TABLE finished_trips AS
SELECT *
FROM trip
WHERE status = false;