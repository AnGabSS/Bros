CREATE TABLE IF NOT EXISTS public."users"
(
    organization_group integer NOT NULL,
    company integer NOT NULL,
    branch integer NOT NULL,
    unit integer NOT NULL,
    id uuid NOT NULL,
    name character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    created_at timestamp with time zone NOT NULL,
    cpf_cnpj character varying(255) NOT NULL,
    nickname character varying(255) NOT NULL,
    is_active boolean NOT NULL DEFAULT TRUE,
    PRIMARY KEY (organization_group, company, branch, unit, id),
    CONSTRAINT email_must_to_be_unique UNIQUE (email),
    CONSTRAINT nickname_must_to_unique UNIQUE (nickname)
);