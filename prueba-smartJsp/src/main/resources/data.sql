--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

-- Started on 2020-06-16 14:04:46

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 202 (class 1259 OID 24604)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 204 (class 1259 OID 24645)
-- Name: tbl_nacionalidades; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tbl_nacionalidades (
    id bigint NOT NULL,
    nombre_pais character varying(255)
);


ALTER TABLE public.tbl_nacionalidades OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 24643)
-- Name: tbl_nacionalidades_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tbl_nacionalidades_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tbl_nacionalidades_id_seq OWNER TO postgres;

--
-- TOC entry 2864 (class 0 OID 0)
-- Dependencies: 203
-- Name: tbl_nacionalidades_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tbl_nacionalidades_id_seq OWNED BY public.tbl_nacionalidades.id;


--
-- TOC entry 206 (class 1259 OID 24653)
-- Name: tbl_tipos_documentos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tbl_tipos_documentos (
    id bigint NOT NULL,
    abreviacion character varying(255),
    nombre character varying(255)
);


ALTER TABLE public.tbl_tipos_documentos OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 24651)
-- Name: tbl_tipos_documentos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tbl_tipos_documentos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tbl_tipos_documentos_id_seq OWNER TO postgres;

--
-- TOC entry 2865 (class 0 OID 0)
-- Dependencies: 205
-- Name: tbl_tipos_documentos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tbl_tipos_documentos_id_seq OWNED BY public.tbl_tipos_documentos.id;


--
-- TOC entry 208 (class 1259 OID 24664)
-- Name: tbl_usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tbl_usuarios (
    id bigint NOT NULL,
    apellido character varying(255),
    creat_at timestamp without time zone,
    email character varying(255),
    estado character varying(255),
    identificador bigint,
    nombre character varying(255),
    observaciones character varying(255),
    telefono bigint,
    nacionalidad_id bigint,
    tipo_documento_id bigint
);


ALTER TABLE public.tbl_usuarios OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 24662)
-- Name: tbl_usuarios_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tbl_usuarios_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tbl_usuarios_id_seq OWNER TO postgres;

--
-- TOC entry 2866 (class 0 OID 0)
-- Dependencies: 207
-- Name: tbl_usuarios_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tbl_usuarios_id_seq OWNED BY public.tbl_usuarios.id;


--
-- TOC entry 2703 (class 2604 OID 24648)
-- Name: tbl_nacionalidades id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tbl_nacionalidades ALTER COLUMN id SET DEFAULT nextval('public.tbl_nacionalidades_id_seq'::regclass);


--
-- TOC entry 2704 (class 2604 OID 24656)
-- Name: tbl_tipos_documentos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tbl_tipos_documentos ALTER COLUMN id SET DEFAULT nextval('public.tbl_tipos_documentos_id_seq'::regclass);


--
-- TOC entry 2705 (class 2604 OID 24667)
-- Name: tbl_usuarios id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tbl_usuarios ALTER COLUMN id SET DEFAULT nextval('public.tbl_usuarios_id_seq'::regclass);


--
-- TOC entry 2854 (class 0 OID 24645)
-- Dependencies: 204
-- Data for Name: tbl_nacionalidades; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tbl_nacionalidades (id, nombre_pais) FROM stdin;
1	Colombia
2	Brazil
3	EEUU
\.


--
-- TOC entry 2856 (class 0 OID 24653)
-- Dependencies: 206
-- Data for Name: tbl_tipos_documentos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tbl_tipos_documentos (id, abreviacion, nombre) FROM stdin;
1	C.C.	Cedula
2	T.I.	Tarjeta de identidad
3	C.E.	Cedula extranjera
\.


--
-- TOC entry 2858 (class 0 OID 24664)
-- Dependencies: 208
-- Data for Name: tbl_usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tbl_usuarios (id, apellido, creat_at, email, estado, identificador, nombre, observaciones, telefono, nacionalidad_id, tipo_documento_id) FROM stdin;
\.


--
-- TOC entry 2867 (class 0 OID 0)
-- Dependencies: 202
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 3, true);


--
-- TOC entry 2868 (class 0 OID 0)
-- Dependencies: 203
-- Name: tbl_nacionalidades_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tbl_nacionalidades_id_seq', 1, false);


--
-- TOC entry 2869 (class 0 OID 0)
-- Dependencies: 205
-- Name: tbl_tipos_documentos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tbl_tipos_documentos_id_seq', 1, false);


--
-- TOC entry 2870 (class 0 OID 0)
-- Dependencies: 207
-- Name: tbl_usuarios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tbl_usuarios_id_seq', 1, false);


--
-- TOC entry 2707 (class 2606 OID 24650)
-- Name: tbl_nacionalidades tbl_nacionalidades_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tbl_nacionalidades
    ADD CONSTRAINT tbl_nacionalidades_pkey PRIMARY KEY (id);


--
-- TOC entry 2711 (class 2606 OID 24661)
-- Name: tbl_tipos_documentos tbl_tipos_documentos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tbl_tipos_documentos
    ADD CONSTRAINT tbl_tipos_documentos_pkey PRIMARY KEY (id);


--
-- TOC entry 2717 (class 2606 OID 24672)
-- Name: tbl_usuarios tbl_usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tbl_usuarios
    ADD CONSTRAINT tbl_usuarios_pkey PRIMARY KEY (id);


--
-- TOC entry 2713 (class 2606 OID 24678)
-- Name: tbl_tipos_documentos uk_10jgcjie50ts9hio99rn4v89c; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tbl_tipos_documentos
    ADD CONSTRAINT uk_10jgcjie50ts9hio99rn4v89c UNIQUE (nombre);


--
-- TOC entry 2719 (class 2606 OID 24684)
-- Name: tbl_usuarios uk_4p6cpok9hxx27mvv2q5wjo62d; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tbl_usuarios
    ADD CONSTRAINT uk_4p6cpok9hxx27mvv2q5wjo62d UNIQUE (telefono);


--
-- TOC entry 2721 (class 2606 OID 24680)
-- Name: tbl_usuarios uk_8qp3fnpuv1qx97rn5ns7qhj8g; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tbl_usuarios
    ADD CONSTRAINT uk_8qp3fnpuv1qx97rn5ns7qhj8g UNIQUE (email);


--
-- TOC entry 2723 (class 2606 OID 24682)
-- Name: tbl_usuarios uk_8vp4vrknd5xnvq9d7x9oosxkg; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tbl_usuarios
    ADD CONSTRAINT uk_8vp4vrknd5xnvq9d7x9oosxkg UNIQUE (identificador);


--
-- TOC entry 2709 (class 2606 OID 24674)
-- Name: tbl_nacionalidades uk_db2uboabfdlf35fsveuyuxa29; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tbl_nacionalidades
    ADD CONSTRAINT uk_db2uboabfdlf35fsveuyuxa29 UNIQUE (nombre_pais);


--
-- TOC entry 2715 (class 2606 OID 24676)
-- Name: tbl_tipos_documentos uk_mxcud6tsth400xi485772dmxd; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tbl_tipos_documentos
    ADD CONSTRAINT uk_mxcud6tsth400xi485772dmxd UNIQUE (abreviacion);


--
-- TOC entry 2725 (class 2606 OID 24690)
-- Name: tbl_usuarios fk63dubtn6miam16guch3uj0luf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tbl_usuarios
    ADD CONSTRAINT fk63dubtn6miam16guch3uj0luf FOREIGN KEY (tipo_documento_id) REFERENCES public.tbl_tipos_documentos(id);


--
-- TOC entry 2724 (class 2606 OID 24685)
-- Name: tbl_usuarios fkc1x1fp1b3j06dq94ujwtnamts; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tbl_usuarios
    ADD CONSTRAINT fkc1x1fp1b3j06dq94ujwtnamts FOREIGN KEY (nacionalidad_id) REFERENCES public.tbl_nacionalidades(id);


-- Completed on 2020-06-16 14:04:46

--
-- PostgreSQL database dump complete
--

