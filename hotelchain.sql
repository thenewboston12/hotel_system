--
-- PostgreSQL database dump
--

-- Dumped from database version 12.9 (Ubuntu 12.9-1.pgdg18.04+1)
-- Dumped by pg_dump version 14.1 (Ubuntu 14.1-1.pgdg18.04+1)

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
-- Name: role; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE public.role AS ENUM (
    'Guest',
    'Staff',
    'Clerk',
    'Manager'
);


ALTER TYPE public.role OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: bills; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bills (
    res_id integer NOT NULL,
    hotel_id character varying(10) NOT NULL,
    service_type character varying(30),
    total_price real NOT NULL,
    "time" timestamp without time zone NOT NULL,
    bill_id integer NOT NULL
);


ALTER TABLE public.bills OWNER TO postgres;

--
-- Name: bills_bill_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.bills ALTER COLUMN bill_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.bills_bill_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee (
    employee_id integer NOT NULL,
    name character varying(30),
    sname character varying(40),
    mobile_n character varying(20),
    salary real,
    hotel_id character varying(10) NOT NULL,
    emp_email character varying(40) NOT NULL,
    m_w_hours integer
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- Name: employee_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.employee ALTER COLUMN employee_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: guest; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.guest (
    guest_id integer NOT NULL,
    id_type character varying(30) NOT NULL,
    g_address character varying(50),
    mobile_n character varying(20),
    home_n character varying(20),
    g_category character varying(20) NOT NULL,
    g_name character varying(30),
    g_surname character varying(40),
    g_email character varying(40) NOT NULL,
    id_number character varying(30) NOT NULL
);


ALTER TABLE public.guest OWNER TO postgres;

--
-- Name: guest_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.guest ALTER COLUMN guest_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.guest_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- Name: hotel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hotel (
    hotel_id character varying(10) NOT NULL,
    h_name character varying(30),
    h_address character varying(50),
    h_city character varying(20) NOT NULL,
    h_country character varying(30)
);


ALTER TABLE public.hotel OWNER TO postgres;

--
-- Name: hotelphone; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hotelphone (
    hotel_id character varying(10) NOT NULL,
    h_phone character varying(20) NOT NULL
);


ALTER TABLE public.hotelphone OWNER TO postgres;

--
-- Name: hotelroomtype; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hotelroomtype (
    hotel_id character varying(10) NOT NULL,
    r_type character varying(20) NOT NULL,
    size double precision NOT NULL,
    capacity integer NOT NULL,
    monday real NOT NULL,
    tuesday real NOT NULL,
    wednesday real NOT NULL,
    thursday real NOT NULL,
    saturday real NOT NULL,
    sunday real NOT NULL,
    friday real
);


ALTER TABLE public.hotelroomtype OWNER TO postgres;

--
-- Name: reservations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reservations (
    res_id integer NOT NULL,
    guest_id integer NOT NULL,
    hotel_id character varying(10) NOT NULL,
    r_number integer NOT NULL,
    check_in date NOT NULL,
    check_out date NOT NULL
);


ALTER TABLE public.reservations OWNER TO postgres;

--
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
-- Name: room; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.room (
    r_number integer NOT NULL,
    hotel_id character varying(10) NOT NULL,
    r_type character varying(20) NOT NULL,
    r_floor integer,
    is_clean boolean,
    is_occupied boolean
);


ALTER TABLE public.room OWNER TO postgres;

--
-- Name: schedule; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.schedule (
    employee_id integer NOT NULL,
    r_number integer NOT NULL,
    start_time timestamp without time zone,
    end_time timestamp without time zone,
    hotel_id character varying NOT NULL
);


ALTER TABLE public.schedule OWNER TO postgres;

--
-- Name: services; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.services (
    service_type character varying(30) NOT NULL,
    hotel_id character varying(10) NOT NULL,
    s_price real
);


ALTER TABLE public.services OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    email character varying NOT NULL,
    password character varying NOT NULL,
    role character varying(16),
    id integer NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.users ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: bills; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.bills (res_id, hotel_id, service_type, total_price, "time", bill_id) FROM stdin;
3	Hilton_Ast	Breakfast	10000	2021-12-25 10:23:54	1
2	Hilton_Ast	SPA	20000	2021-12-07 23:32:30	3
2	Hilton_Ast	Breakfast	10000	2021-12-08 20:42:30	4
2	Hilton_Ast	Breakfast	10000	2021-12-08 20:42:30	5
1	Hilton_Ast	Breakfast	10000	2021-12-08 18:31:05.562	6
1	Hilton_Ast	SPA	20000	2021-12-08 18:47:40.669	7
2	Hilton_Ast	Check_out	200	2021-12-08 21:16:29.728	9
\.


--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee (employee_id, name, sname, mobile_n, salary, hotel_id, emp_email, m_w_hours) FROM stdin;
2	Aset	Tashenov	8(776) 865 7777	50000	Hilton_Ast	Aset@mail.com	2
3	Aidana	Askarovna	8(771) 010 9291	50000	Hilton_Ast	Aidana@gmail.com	12
1	Kairat	Nurtas	8(707) 576 1124	100000	Hilton_Ast	Kairat@gmail.com	5
\.


--
-- Data for Name: guest; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.guest (guest_id, id_type, g_address, mobile_n, home_n, g_category, g_name, g_surname, g_email, id_number) FROM stdin;
2	National ID	Abai St18,Almaty,Kazakhstan	8(771)589 8712	526810	Ordinary	Ainur	Nurbek	ainur.nurbek.@gmail.com	011203510714
3	Birth Certificate	Abai St18,Almaty,Kazakhstan	8(708)3119043	531026	Ordinary	Berik	Nurbek	berik.nurbek@gmail.com	035048165912
1	National ID	Abai St18,Almaty,Kazakhstan	8(771)589 2371	495206	Ordinary	Azamat	Nurbek	azamat.nurbek@gmail.com	026398162517
4	Passport	Lenina19,Moscow,Russia	7 (277)001 1111	524810	VIP	Stas	Komisarenko	stas.komisarenko@gmail.com	081521182513
\.


--
-- Data for Name: hotel; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hotel (hotel_id, h_name, h_address, h_city, h_country) FROM stdin;
Hilton_Ast	Hilton Astana	Sauran St 46,Nur-Sultan,Kazakhstan	Astana	Kazakhstan
Hilton_Alm	DoubleTree by Hilton	Dosmukhamedov St 115, Almaty,Kazakhstan	Almaty	Kazakhstan
Hilton_Mos	Hilton Moscow Leningradskaya	Kalanchevskaya Ulitsa, 21/40, Moscow,Russia	Moscow	Russia
Hilton_NY	Hilton Garden Inn New York	136 W 42nd St, New York, United States	New York	USA
Hilton_Bev	Waldorf Astoria Beverly Hills	9850 Wilshire Blvd, Beverly Hills,United States	Beverli Hills	USA
Prime_Ast	Prime Hotel Astana	Kabanbay batyr, Nur-Sultan, 53	Astana	Kazkahstan
\.


--
-- Data for Name: hotelphone; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hotelphone (hotel_id, h_phone) FROM stdin;
Hilton_Ast	8 (7172) 64 99 00
Hilton_Ast	8 (7172) 64 99 42
Hilton_Alm	8 (727) 320 4200
Hilton_Alm	8 (727) 320 4221
\.


--
-- Data for Name: hotelroomtype; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hotelroomtype (hotel_id, r_type, size, capacity, monday, tuesday, wednesday, thursday, saturday, sunday, friday) FROM stdin;
Hilton_Ast	suite	100	2	100	100	100	100	100	160	100
Hilton_Ast	penthouse	260	12	200	200	200	200	200	200	200
Prime_Ast	suite	75	2	75	75	75	80	80	100	80
Prime_Ast	penthouse	150	8	150	150	250	360	300	300	360
Hilton_Ast	single	50	1	50	50	50	50	75	150	50
Hilton_Ast	double	75	2	75	75	80	52	75	190	52
Prime_Ast	single	30	1	30	30	30	30	30	30	30
Prime_Ast	double	50	2	50	70	60	60	60	60	60
\.


--
-- Data for Name: reservations; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reservations (res_id, guest_id, hotel_id, r_number, check_in, check_out) FROM stdin;
1	1	Hilton_Ast	202	2021-12-25	2021-12-29
2	1	Hilton_Ast	203	2021-12-15	2021-12-19
3	4	Hilton_Ast	305	2021-12-29	2021-12-31
4	2	Prime_Ast	212	2021-12-27	2021-12-31
5	3	Prime_Ast	312	2021-12-25	2021-12-29
6	1	Hilton_Ast	501	2021-12-20	2021-12-27
\.


--
-- Data for Name: room; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.room (r_number, hotel_id, r_type, r_floor, is_clean, is_occupied) FROM stdin;
305	Hilton_Ast	suite	3	f	f
501	Hilton_Ast	penthouse	5	t	f
201	Hilton_Ast	single	2	t	f
202	Hilton_Ast	single	2	f	f
203	Hilton_Ast	single	2	f	f
212	Prime_Ast	single	2	f	f
312	Prime_Ast	single	3	f	t
512	Prime_Ast	double	5	t	t
\.


--
-- Data for Name: schedule; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.schedule (employee_id, r_number, start_time, end_time, hotel_id) FROM stdin;
\.


--
-- Data for Name: services; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.services (service_type, hotel_id, s_price) FROM stdin;
Pool	Hilton_Ast	12000
SPA	Hilton_Ast	20000
Conference facilities	Hilton_Ast	50000
Breakfast	Hilton_Ast	10000
Cinema	Hilton_Ast	5000
Restaurant	Hilton_Ast	30000
Snacks_in_the_room	Hilton_Ast	5000
Clean_room	Hilton_Ast	0
Check_out	Hilton_Ast	0
Check_out	Hilton_Alm	0
Check_out	Hilton_NY	0
Check_out	Hilton_Mos	0
Check_out	Hilton_Bev	0
Check_out	Prime_Ast	0
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (email, password, role, id) FROM stdin;
ainur.nurbek.@gmail.com	1234	Guest	1
berik.nurbek@gmail.com	1234	Guest	2
azamat.nurbek@gmail.com	1234	Guest	3
stas.komisarenko@gmail.com	1234	Guest	4
Kairat@gmail.com	1234	Staff	5
Aset@mail.com	1234	Clerk	6
Aidana@gmail.com	1234	Manager	7
\.


--
-- Name: bills_bill_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.bills_bill_id_seq', 9, true);


--
-- Name: employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employee_id_seq', 1, false);


--
-- Name: guest_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.guest_id_seq', 1, false);


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, true);


--
-- Name: reservations_res_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reservations_res_id_seq', 6, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 1, false);


--
-- Name: bills bills_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bills
    ADD CONSTRAINT bills_pk PRIMARY KEY (bill_id);


--
-- Name: employee employee_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_id PRIMARY KEY (employee_id);


--
-- Name: guest guest_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.guest
    ADD CONSTRAINT guest_pkey PRIMARY KEY (guest_id);


--
-- Name: hotel hotel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotel
    ADD CONSTRAINT hotel_pkey PRIMARY KEY (hotel_id);


--
-- Name: hotelphone hotelphone_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotelphone
    ADD CONSTRAINT hotelphone_pkey PRIMARY KEY (hotel_id, h_phone);


--
-- Name: hotelroomtype hotelroomtype_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotelroomtype
    ADD CONSTRAINT hotelroomtype_pkey PRIMARY KEY (hotel_id, r_type);


--
-- Name: room r_number; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room
    ADD CONSTRAINT r_number UNIQUE (r_number);


--
-- Name: reservations res_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservations
    ADD CONSTRAINT res_id UNIQUE (res_id);


--
-- Name: reservations reservations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservations
    ADD CONSTRAINT reservations_pkey PRIMARY KEY (res_id);


--
-- Name: room room_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_pkey PRIMARY KEY (r_number, hotel_id);


--
-- Name: schedule schedule_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT schedule_pk PRIMARY KEY (hotel_id, r_number, employee_id);


--
-- Name: services services_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.services
    ADD CONSTRAINT services_pkey PRIMARY KEY (service_type, hotel_id);


--
-- Name: users unique_users_email; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT unique_users_email UNIQUE (email);


--
-- Name: users users_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pk PRIMARY KEY (id);


--
-- Name: bills bills_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bills
    ADD CONSTRAINT bills_fk FOREIGN KEY (res_id) REFERENCES public.reservations(res_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: bills bills_fk_service; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bills
    ADD CONSTRAINT bills_fk_service FOREIGN KEY (service_type, hotel_id) REFERENCES public.services(service_type, hotel_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: employee employee_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_fk FOREIGN KEY (emp_email) REFERENCES public.users(email) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: guest guest_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.guest
    ADD CONSTRAINT guest_fk FOREIGN KEY (g_email) REFERENCES public.users(email) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: reservations guest_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservations
    ADD CONSTRAINT guest_id FOREIGN KEY (guest_id) REFERENCES public.guest(guest_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: employee hotel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES public.hotel(hotel_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: hotelphone hotel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotelphone
    ADD CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES public.hotel(hotel_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: hotelroomtype hotel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotelroomtype
    ADD CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES public.hotel(hotel_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: services hotel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.services
    ADD CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES public.hotel(hotel_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: reservations reservations_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservations
    ADD CONSTRAINT reservations_fk FOREIGN KEY (r_number, hotel_id) REFERENCES public.room(r_number, hotel_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: room room_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_fk FOREIGN KEY (hotel_id, r_type) REFERENCES public.hotelroomtype(hotel_id, r_type) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: schedule schedule_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT schedule_fk FOREIGN KEY (r_number, hotel_id) REFERENCES public.room(r_number, hotel_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: schedule schedule_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT schedule_fk_1 FOREIGN KEY (employee_id) REFERENCES public.employee(employee_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

