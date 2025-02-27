-- Table to store location details
CREATE TABLE locations (
                           id SERIAL PRIMARY KEY,
                           number VARCHAR(10),
                           street VARCHAR(100),
                           city VARCHAR(50),
                           state VARCHAR(50),
                           zip_code VARCHAR(20),
                           country VARCHAR(50)
);

-- Table to store gas station details
CREATE TABLE gas_station (
                             id SERIAL PRIMARY KEY,
                             name VARCHAR(100) NOT NULL,
                             location_id INTEGER REFERENCES locations(id),
                             opening_hours TIME,
                             closing_hours TIME,
                             phone_number VARCHAR(20),
                             email VARCHAR(100),
                             website VARCHAR(100),
                             photo TEXT,
    -- Check that if both opening and closing hours are provided, opening is before closing
                             CONSTRAINT chk_hours CHECK (
                                 (opening_hours IS NULL OR closing_hours IS NULL) OR (opening_hours < closing_hours)
                                 ),
    -- Basic email format check
                             CONSTRAINT chk_email CHECK (
                                 email IS NULL OR email ~* '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$'
),
    -- Basic phone number validation
    CONSTRAINT chk_phone CHECK (
        phone_number IS NULL OR phone_number ~ '^\+?[0-9\-\s\(\)]*$'
    )
);

-- Table to store fuel types and prices for each gas station
CREATE TABLE gas_station_fuel (
                                  gas_station_id INTEGER REFERENCES gas_station(id),
                                  fuel_type VARCHAR(50),
                                  price NUMERIC(8,2),
                                  PRIMARY KEY (gas_station_id, fuel_type),
    -- Ensure the fuel price is not negative
                                  CONSTRAINT chk_price CHECK (price >= 0)
);

-- Table to store user details (using "users" to avoid reserved keyword conflict)
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       phone_number VARCHAR(20),
                       email VARCHAR(100),
    -- Basic email format check
                       CONSTRAINT chk_user_email CHECK (
                           email IS NULL OR email ~* '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$'
),
    -- Basic phone number validation
    CONSTRAINT chk_user_phone CHECK (
        phone_number IS NULL OR phone_number ~ '^\+?[0-9\-\s\(\)]*$'
    )
);

-- Table to store reviews
CREATE TABLE review (
                        id SERIAL PRIMARY KEY,
                        user_id INTEGER REFERENCES users(id),
                        gas_station_id INTEGER REFERENCES gas_station(id),
                        rating SMALLINT,
                        comment TEXT,
                        date DATE DEFAULT CURRENT_DATE,
    -- Ensure ratings are between 0 and 5
                        CONSTRAINT chk_rating CHECK (rating >= 0 AND rating <= 5)
);