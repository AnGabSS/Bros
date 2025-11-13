-- V1__create_employee_table.sql
-- Criação da tabela para a entidade EmployeeEntity

CREATE TABLE employees (
    organization_group INT NOT NULL,
    company INT NOT NULL,
    branch INT NOT NULL,
    unit INT NOT NULL,
    id UUID NOT NULL,

    cpf_cnpj VARCHAR(18) NOT NULL,
    type VARCHAR(50) NOT NULL,
    driver_license VARCHAR(255),
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    entrance_at DATE NOT NULL,
    exit_at DATE,

    PRIMARY KEY (organization_group, company, branch, unit, id),

    CONSTRAINT uk_employees_cpf_cnpj UNIQUE (cpf_cnpj),
    CONSTRAINT uk_employees_driver_license UNIQUE (driver_license),
    CONSTRAINT uk_employees_email UNIQUE (email)
);