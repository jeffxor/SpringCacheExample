-- CREATE TABLE fe_size_units (
--   size_unit_id INTEGER NOT NULL IDENTITY,
--   size_unit varchar(45) DEFAULT NULL,
--   ordering INTEGER DEFAULT NULL,
--   type` varchar(45) NOT NULL DEFAULT 'all',
--   date_entered timestamp NULL DEFAULT CURRENT_TIMESTAMP,
--   PRIMARY KEY (size_unit_id)
-- );
--
CREATE TABLE fe_size_units (
  size_unit_id INTEGER,
  size_unit varchar(45),
  ordering INTEGER,
  type varchar(45),
    date_entered timestamp
);