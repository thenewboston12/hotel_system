--
-- PostgreSQL database dump
--

-- Dumped from database version 14.0
-- Dumped by pg_dump version 14.0

-- Started on 2021-12-05 20:22:03

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 220 (class 1259 OID 32846)
-- Name: bills; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bills (
    guest_id integer NOT NULL,
    res_id integer NOT NULL,
    hotel_id character varying(10) NOT NULL,
    service_type character varying(30),
    total_price money,
    "time" date
);


ALTER TABLE public.bills OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 24845)
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee (
    employee_id integer NOT NULL,
    name character varying(30),
    sname character varying(40),
    mobile_n character varying(20),
    salary integer,
    e_category character varying(30),
    hotel_id character varying(10),
    emp_email character varying(40)
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 24756)
-- Name: guest; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.guest (
    guest_id integer NOT NULL,
    id_type character varying(20),
    id_number bigint,
    g_address character varying(50),
    mobile_n character varying(20),
    home_n character varying(20),
    g_category character varying(20),
    g_name character varying(30),
    g_surname character varying(40),
    g_email character varying(40)
);


ALTER TABLE public.guest OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 24662)
-- Name: hotel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hotel (
    hotel_id character varying(10) NOT NULL,
    h_name character varying(30),
    h_address character varying(50)
);


ALTER TABLE public.hotel OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 24907)
-- Name: hotelphone; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hotelphone (
    hotel_id character varying(10) NOT NULL,
    h_phone character varying(20) NOT NULL
);


ALTER TABLE public.hotelphone OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 24885)
-- Name: hotelroomtype; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hotelroomtype (
    hotel_id character varying(10) NOT NULL,
    r_type character varying(20) NOT NULL,
    size double precision,
    capacity integer
);


ALTER TABLE public.hotelroomtype OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 24850)
-- Name: manager; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.manager (
    employee_id integer NOT NULL,
    hotel_id character varying(10) NOT NULL
);


ALTER TABLE public.manager OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 32834)
-- Name: reservations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reservations (
    res_id integer NOT NULL,
    guest_id integer NOT NULL,
    hotel_id character varying(10),
    r_number integer,
    check_in date,
    check_out date
);


ALTER TABLE public.reservations OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 32833)
-- Name: reservations_res_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.reservations ALTER COLUMN res_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.reservations_res_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 210 (class 1259 OID 24741)
-- Name: room; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.room (
    r_number integer NOT NULL,
    hotel_id character varying(10) NOT NULL,
    r_type character varying(20) NOT NULL,
    r_floor integer,
    price_id integer,
    "isClean" boolean,
    "isOccupied" boolean
);


ALTER TABLE public.room OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 24798)
-- Name: roomprice; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roomprice (
    price_id integer NOT NULL,
    dow character varying(10),
    price money
);


ALTER TABLE public.roomprice OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 24808)
-- Name: services; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.services (
    service_type character varying(30) NOT NULL,
    hotel_id character varying(10) NOT NULL,
    s_price money
);


ALTER TABLE public.services OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 32878)
-- Name: task; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.task (
    task_id integer NOT NULL,
    employee_id integer NOT NULL,
    r_number integer NOT NULL,
    task_description character varying(200),
    task_status boolean
);


ALTER TABLE public.task OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 32877)
-- Name: task_task_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.task ALTER COLUMN task_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.task_task_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3399 (class 0 OID 32846)
-- Dependencies: 220
-- Data for Name: bills; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.bills (guest_id, res_id, hotel_id, service_type, total_price, "time") FROM stdin;
4	3	Hilton_Ast	Breakfast	\N	2021-12-02
\.


--
-- TOC entry 3393 (class 0 OID 24845)
-- Dependencies: 214
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee (employee_id, name, sname, mobile_n, salary, e_category, hotel_id, emp_email) FROM stdin;
1	Kairat	Nurtas	8(707) 576 1124	100000	Manager	Hilton_Ast	Kairat@gmail.com
2	Aset	Tashenov	8(776) 865 7777	50000	cleaning staff	Hilton_Ast	Aset@mail.com
3	Aidana	Askarovna	8(771) 010 9291	50000	maid	Hilton_Ast	Aidana@gmail.com
\.


--
-- TOC entry 3390 (class 0 OID 24756)
-- Dependencies: 211
-- Data for Name: guest; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.guest (guest_id, id_type, id_number, g_address, mobile_n, home_n, g_category, g_name, g_surname, g_email) FROM stdin;
2	National ID	2312203	Abai St18,Almaty,Kazakhstan	8(771)589 8712	\N	Ordinary	Ainur	Nurbek	\N
3	Birth Certificate	3123123	Abai St18,Almaty,Kazakhstan	\N	\N	Ordinary	Berik	Nurbek	\N
1	National ID	101089	Abai St18,Almaty,Kazakhstan	8(771)589 2371	\N	Ordinary	Azamat	Nurbek	azamat.nurbek@gmail.com
4	Passport	2011233	Lenina19,Moscow,Russia	7 (277)001 1111	\N	VIP	Stas	Komisarenko	stas.komisarenko@gmail.com
\.


--
-- TOC entry 3388 (class 0 OID 24662)
-- Dependencies: 209
-- Data for Name: hotel; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hotel (hotel_id, h_name, h_address) FROM stdin;
Hilton_Ast	Hilton Astana	Sauran St 46,Nur-Sultan,Kazakhstan
Hilton_Alm	DoubleTree by Hilton	Dosmukhamedov St 115, Almaty,Kazakhstan
Hilton_Mos	Hilton Moscow Leningradskaya	Kalanchevskaya Ulitsa, 21/40, Moscow,Russia
Hilton_NY	Hilton Garden Inn New York	136 W 42nd St, New York, United States
Hilton_Bev	Waldorf Astoria Beverly Hills	9850 Wilshire Blvd, Beverly Hills,United States
\.


--
-- TOC entry 3396 (class 0 OID 24907)
-- Dependencies: 217
-- Data for Name: hotelphone; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hotelphone (hotel_id, h_phone) FROM stdin;
Hilton_Ast	8 (7172) 64 99 00
Hilton_Ast	8 (7172) 64 99 42
Hilton_Alm	8 (727) 320 4200
Hilton_Alm	8 (727) 320 4221
\.


--
-- TOC entry 3395 (class 0 OID 24885)
-- Dependencies: 216
-- Data for Name: hotelroomtype; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hotelroomtype (hotel_id, r_type, size, capacity) FROM stdin;
Hilton_Ast	single-bedroom	\N	\N
Hilton_Ast	suite	\N	\N
Hilton_Ast	penthouse	\N	\N
Hilton_Ast	double-bedroom	\N	\N
\.


--
-- TOC entry 3394 (class 0 OID 24850)
-- Dependencies: 215
-- Data for Name: manager; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.manager (employee_id, hotel_id) FROM stdin;
1	Hilton_Ast
\.


--
-- TOC entry 3398 (class 0 OID 32834)
-- Dependencies: 219
-- Data for Name: reservations; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reservations (res_id, guest_id, hotel_id, r_number, check_in, check_out) FROM stdin;
1	1	Hilton_Ast	202	2021-11-20	2021-12-10
2	1	Hilton_Ast	203	2021-11-20	2021-12-10
3	4	Hilton_Ast	305	2021-11-29	2021-12-02
\.


--
-- TOC entry 3389 (class 0 OID 24741)
-- Dependencies: 210
-- Data for Name: room; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.room (r_number, hotel_id, r_type, r_floor, price_id, "isClean", "isOccupied") FROM stdin;
201	Hilton_Ast	single-bedroom	2	1	t	\N
202	Hilton_Ast	single-bedroom	2	1	f	\N
203	Hilton_Ast	single-bedroom	2	1	f	\N
305	Hilton_Ast	suite	3	6	f	\N
501	Hilton_Ast	penthouse	5	7	t	\N
\.


--
-- TOC entry 3391 (class 0 OID 24798)
-- Dependencies: 212
-- Data for Name: roomprice; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roomprice (price_id, dow, price) FROM stdin;
1	week	70000,00₸
2	weekend	100000,00 ₸
3	week	100000,00₸
4	weekend	150000,00₸
5	week	150000,00₸
6	weekend	200000,00₸
7	week	500000,00₸
8	weekend	1000000,00₸
\.


--
-- TOC entry 3392 (class 0 OID 24808)
-- Dependencies: 213
-- Data for Name: services; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.services (service_type, hotel_id, s_price) FROM stdin;
Pool	Hilton_Ast	12000,00₸
SPA	Hilton_Ast	20000,00₸
Conference facilities	Hilton_Ast	50000,00₸
Breakfast	Hilton_Ast	10000,00₸
Cinema	Hilton_Ast	5000,00₸
Restaurant	Hilton_Ast	30000,00₸
Snacks_in_the_room	Hilton_Ast	5000,00₸
Clean_room	Hilton_Ast	0,00₸
\.


--
-- TOC entry 3401 (class 0 OID 32878)
-- Dependencies: 222
-- Data for Name: task; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.task (task_id, employee_id, r_number, task_description, task_status) FROM stdin;
1	2	202	clean room	f
2	3	305	bring breakfast	\N
\.


--
-- TOC entry 3407 (class 0 OID 0)
-- Dependencies: 218
-- Name: reservations_res_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reservations_res_id_seq', 3, true);


--
-- TOC entry 3408 (class 0 OID 0)
-- Dependencies: 221
-- Name: task_task_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.task_task_id_seq', 2, true);


--
-- TOC entry 3236 (class 2606 OID 32850)
-- Name: bills bills_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bills
    ADD CONSTRAINT bills_pkey PRIMARY KEY (guest_id, res_id, hotel_id);


--
-- TOC entry 3224 (class 2606 OID 24849)
-- Name: employee employee_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_id PRIMARY KEY (employee_id);


--
-- TOC entry 3216 (class 2606 OID 24929)
-- Name: guest guest_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.guest
    ADD CONSTRAINT guest_pkey PRIMARY KEY (guest_id);


--
-- TOC entry 3210 (class 2606 OID 24666)
-- Name: hotel hotel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotel
    ADD CONSTRAINT hotel_pkey PRIMARY KEY (hotel_id);


--
-- TOC entry 3230 (class 2606 OID 24911)
-- Name: hotelphone hotelphone_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotelphone
    ADD CONSTRAINT hotelphone_pkey PRIMARY KEY (hotel_id, h_phone);


--
-- TOC entry 3228 (class 2606 OID 24889)
-- Name: hotelroomtype hotelroomtype_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotelroomtype
    ADD CONSTRAINT hotelroomtype_pkey PRIMARY KEY (hotel_id, r_type);


--
-- TOC entry 3226 (class 2606 OID 24854)
-- Name: manager manager_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.manager
    ADD CONSTRAINT manager_pkey PRIMARY KEY (employee_id, hotel_id);


--
-- TOC entry 3218 (class 2606 OID 24802)
-- Name: roomprice price_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roomprice
    ADD CONSTRAINT price_id PRIMARY KEY (price_id);


--
-- TOC entry 3212 (class 2606 OID 24777)
-- Name: room r_number; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room
    ADD CONSTRAINT r_number UNIQUE (r_number);


--
-- TOC entry 3232 (class 2606 OID 32845)
-- Name: reservations res_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservations
    ADD CONSTRAINT res_id UNIQUE (res_id);


--
-- TOC entry 3234 (class 2606 OID 32838)
-- Name: reservations reservations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservations
    ADD CONSTRAINT reservations_pkey PRIMARY KEY (res_id, guest_id);


--
-- TOC entry 3214 (class 2606 OID 24745)
-- Name: room room_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_pkey PRIMARY KEY (r_number, hotel_id);


--
-- TOC entry 3220 (class 2606 OID 24819)
-- Name: services service_type; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.services
    ADD CONSTRAINT service_type UNIQUE (service_type);


--
-- TOC entry 3222 (class 2606 OID 24812)
-- Name: services services_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.services
    ADD CONSTRAINT services_pkey PRIMARY KEY (service_type, hotel_id);


--
-- TOC entry 3238 (class 2606 OID 32882)
-- Name: task task_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.task
    ADD CONSTRAINT task_pkey PRIMARY KEY (task_id, employee_id, r_number);


--
-- TOC entry 3243 (class 2606 OID 24855)
-- Name: manager employee_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.manager
    ADD CONSTRAINT employee_id FOREIGN KEY (employee_id) REFERENCES public.employee(employee_id);


--
-- TOC entry 3248 (class 2606 OID 32861)
-- Name: bills guest_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bills
    ADD CONSTRAINT guest_id FOREIGN KEY (guest_id) REFERENCES public.guest(guest_id);


--
-- TOC entry 3239 (class 2606 OID 24746)
-- Name: room hotel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room
    ADD CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES public.hotel(hotel_id) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 3241 (class 2606 OID 24813)
-- Name: services hotel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.services
    ADD CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES public.hotel(hotel_id);


--
-- TOC entry 3244 (class 2606 OID 24860)
-- Name: manager hotel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.manager
    ADD CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES public.hotel(hotel_id);


--
-- TOC entry 3242 (class 2606 OID 24962)
-- Name: employee hotel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES public.hotel(hotel_id) NOT VALID;


--
-- TOC entry 3247 (class 2606 OID 32856)
-- Name: bills hotel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bills
    ADD CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES public.hotel(hotel_id);


--
-- TOC entry 3245 (class 2606 OID 32883)
-- Name: hotelphone hotel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotelphone
    ADD CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES public.hotel(hotel_id) NOT VALID;


--
-- TOC entry 3240 (class 2606 OID 24803)
-- Name: room price_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room
    ADD CONSTRAINT price_id FOREIGN KEY (price_id) REFERENCES public.roomprice(price_id) NOT VALID;


--
-- TOC entry 3246 (class 2606 OID 32851)
-- Name: bills res_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bills
    ADD CONSTRAINT res_id FOREIGN KEY (res_id) REFERENCES public.reservations(res_id);


-- Completed on 2021-12-05 20:22:03

--
-- PostgreSQL database dump complete
--

