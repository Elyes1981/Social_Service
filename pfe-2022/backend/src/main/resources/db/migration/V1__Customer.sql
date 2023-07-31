-- Table: public.customer

-- DROP TABLE IF EXISTS public.customer;

CREATE TABLE IF NOT EXISTS public.customer
(
    id bigint NOT NULL DEFAULT nextval('customer_id_seq'::regclass),
    birth_date timestamp without time zone NOT NULL,
    coopted_by_id bigint NOT NULL,
    coopted_by_type character varying(255) COLLATE pg_catalog."default" NOT NULL,
    credit_cardcvv2 bigint NOT NULL,
    credit_card_expire_date timestamp without time zone NOT NULL,
    credit_card_number bigint NOT NULL,
    delegation character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email_adress character varying(255) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    gender character varying(255) COLLATE pg_catalog."default" NOT NULL,
    gouvernerat character varying(255) COLLATE pg_catalog."default" NOT NULL,
    home_adress character varying(255) COLLATE pg_catalog."default" NOT NULL,
    home_adress_gps_latt real,
    home_adress_gps_long real,
    image bytea,
    last_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    metrage bigint,
    number_of_person_in_res bigint NOT NULL,
    payment_mean character varying(255) COLLATE pg_catalog."default" NOT NULL,
    phone character varying(255) COLLATE pg_catalog."default" NOT NULL,
    photo character varying(255) COLLATE pg_catalog."default",
    residence_number_ofrooms bigint NOT NULL,
    residence_type character varying(255) COLLATE pg_catalog."default" NOT NULL,
    status_id bigint,
    CONSTRAINT customer_pkey PRIMARY KEY (id),
    CONSTRAINT fkniyp1iwu4ooty4hngldujnlon FOREIGN KEY (status_id)
        REFERENCES public.status (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT customer_number_of_person_in_res_check CHECK (number_of_person_in_res >= 1 AND number_of_person_in_res <= 10),
    CONSTRAINT customer_residence_number_ofrooms_check CHECK (residence_number_ofrooms >= 1 AND residence_number_ofrooms <= 10)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.customer
    OWNER to postgres;