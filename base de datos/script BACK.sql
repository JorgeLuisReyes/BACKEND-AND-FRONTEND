CREATE SEQUENCE prueba.curso_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE prueba.curso_seq
    OWNER TO postgres;
	
CREATE SEQUENCE prueba.instructores_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE prueba.instructores_seq
    OWNER TO postgres;
	
CREATE SEQUENCE prueba.detalles_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE prueba.detalles_seq
    OWNER TO postgres;
	
CREATE TABLE prueba.cursos
(
    id bigint NOT NULL DEFAULT nextval('prueba.curso_seq'::regclass),
    nombre character varying(200) COLLATE pg_catalog."default" NOT NULL,
    status boolean,
    CONSTRAINT cursos_pkey PRIMARY KEY (id)
)

WITH (
    autovacuum_enabled = TRUE
)
TABLESPACE pg_default;

ALTER TABLE prueba.cursos
    OWNER to postgres;
	
CREATE TABLE prueba.instructores
(
    id bigint NOT NULL DEFAULT nextval('prueba.instructores_seq'::regclass),
    nombre character varying(200) COLLATE pg_catalog."default" NOT NULL,
    apellido character varying(200) COLLATE pg_catalog."default",
    telefono integer,
    email character varying(200) COLLATE pg_catalog."default",
    status boolean,
    CONSTRAINT instructores_pkey PRIMARY KEY (id)
)

WITH (
    autovacuum_enabled = TRUE
)
TABLESPACE pg_default;

ALTER TABLE prueba.instructores
    OWNER to postgres;

CREATE TABLE prueba.detalles
(
    id bigint NOT NULL DEFAULT nextval('prueba.detalles_seq'::regclass),
    id_curso bigint NOT NULL,
    id_instructores bigint NOT NULL,
    seccion character varying(200) COLLATE pg_catalog."default" NOT NULL,
    dias integer NOT NULL,
    hora_inicio character varying(200) COLLATE pg_catalog."default" NOT NULL,
    hora_fin character varying(200) COLLATE pg_catalog."default" NOT NULL,
    fecha_inicio timestamp without time zone NOT NULL,
    fecha_fin timestamp without time zone NOT NULL,
    status boolean,
    CONSTRAINT detalles_pkey PRIMARY KEY (id)
)

WITH (
    autovacuum_enabled = TRUE
)
TABLESPACE pg_default;

ALTER TABLE prueba.detalles
    OWNER to postgres;