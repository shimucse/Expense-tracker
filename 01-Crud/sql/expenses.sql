-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS `expense_tracker`;
USE `expense_tracker`;

-- Drop table if it exists
DROP TABLE IF EXISTS `expenses`;

-- Create table
CREATE TABLE `expenses` (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    amount DOUBLE NOT NULL,
    category VARCHAR(100),
    expense_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert sample data
INSERT INTO `expenses` (title, amount, category, expense_date) VALUES
    ('Lunch', 12.50, 'Food', '2026-04-09'),
    ('Uber Ride', 25.00, 'Transport', '2026-04-08'),
    ('Groceries', 55.75, 'Food', '2026-04-07'),
    ('Movie Ticket', 10.00, 'Entertainment', '2026-04-06'),
    ('Gym Membership', 30.00, 'Health', '2026-04-01');
    
    