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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: bills; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bills (
    guest_id integer NOT NULL,
    res_id integer NOT NULL,
    hotel_id character varying(10) NOT NULL,
    service_type character varying(30),
    total_price float4,
    "time" date
);


ALTER TABLE public.bills OWNER TO postgres;

--
-- Name: clerk; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clerk (
    employee_id integer NOT NULL,
    e_password character varying(30)
);


ALTER TABLE public.clerk OWNER TO postgres;

--
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee (
    employee_id integer NOT NULL,
    name character varying(30),
    sname character varying(40),
    mobile_n character varying(20),
    salary float4,
    e_category character varying(30),
    hotel_id character varying(10),
    emp_email character varying(40),
    m_w_hours integer
);


ALTER TABLE public.employee OWNER TO postgres;

--
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
    g_email character varying(40),
    g_password character varying(30)
);


ALTER TABLE public.guest OWNER TO postgres;

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
    h_city character varying(20),
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
    size double precision,
    capacity integer
);


ALTER TABLE public.hotelroomtype OWNER TO postgres;

--
-- Name: manager; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.manager (
    employee_id integer NOT NULL,
    hotel_id character varying(10) NOT NULL,
    e_password character varying(30)
);


ALTER TABLE public.manager OWNER TO postgres;

--
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
    price_id integer,
    is_clean boolean,
    is_occupied boolean
);


ALTER TABLE public.room OWNER TO postgres;

--
-- Name: roomprice; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roomprice (
    price_id integer NOT NULL,
    dow character varying(10),
    price float4
);


ALTER TABLE public.roomprice OWNER TO postgres;

--
-- Name: services; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.services (
    service_type character varying(30) NOT NULL,
    hotel_id character varying(10) NOT NULL,
    s_price float4
);


ALTER TABLE public.services OWNER TO postgres;

--
-- Data for Name: bills; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.bills (guest_id, res_id, hotel_id, service_type, total_price, "time") FROM stdin;
4	3	Hilton_Ast	Breakfast	\N	2021-12-02
\.


--
-- Data for Name: clerk; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.clerk (employee_id, e_password) FROM stdin;
\.


--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee (employee_id, name, sname, mobile_n, salary, e_category, hotel_id, emp_email, m_w_hours) FROM stdin;
1	Kairat	Nurtas	8(707) 576 1124	 100000.00	Manager	Hilton_Ast	Kairat@gmail.com	\N
2	Aset	Tashenov	8(776) 865 7777	 50000.00	cleaning staff	Hilton_Ast	Aset@mail.com	\N
3	Aidana	Askarovna	8(771) 010 9291	 50000.00	maid	Hilton_Ast	Aidana@gmail.com	\N
\.


--
-- Data for Name: guest; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.guest (guest_id, id_type, id_number, g_address, mobile_n, home_n, g_category, g_name, g_surname, g_email, g_password) FROM stdin;
2	National ID	2312203	Abai St18,Almaty,Kazakhstan	8(771)589 8712	\N	Ordinary	Ainur	Nurbek	\N	\N
3	Birth Certificate	3123123	Abai St18,Almaty,Kazakhstan	\N	\N	Ordinary	Berik	Nurbek	\N	\N
1	National ID	101089	Abai St18,Almaty,Kazakhstan	8(771)589 2371	\N	Ordinary	Azamat	Nurbek	azamat.nurbek@gmail.com	\N
4	Passport	2011233	Lenina19,Moscow,Russia	7 (277)001 1111	\N	VIP	Stas	Komisarenko	stas.komisarenko@gmail.com	\N
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

COPY public.hotelroomtype (hotel_id, r_type, size, capacity) FROM stdin;
Hilton_Ast	single-bedroom	50	1
Hilton_Ast	suite	100	2
Hilton_Ast	penthouse	260	12
Hilton_Ast	double-bedroom	75	2
\.


--
-- Data for Name: manager; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.manager (employee_id, hotel_id, e_password) FROM stdin;
1	Hilton_Ast	\N
\.


--
-- Data for Name: reservations; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reservations (res_id, guest_id, hotel_id, r_number, check_in, check_out) FROM stdin;
1	1	Hilton_Ast	202	2021-11-20	2021-12-10
2	1	Hilton_Ast	203	2021-11-20	2021-12-10
3	4	Hilton_Ast	305	2021-11-29	2021-12-02
\.


--
-- Data for Name: room; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.room (r_number, hotel_id, r_type, r_floor, price_id, is_clean, is_occupied) FROM stdin;
201	Hilton_Ast	single-bedroom	2	1	t	\N
202	Hilton_Ast	single-bedroom	2	1	f	\N
203	Hilton_Ast	single-bedroom	2	1	f	\N
305	Hilton_Ast	suite	3	6	f	\N
501	Hilton_Ast	penthouse	5	7	t	\N
\.


--
-- Data for Name: roomprice; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roomprice (price_id, dow, price) FROM stdin;
1	week	 70000.00
2	weekend	 100000.00
3	week	 100000.00
4	weekend	 150000.00
5	week	 150000.00
6	weekend	 200000.00
7	week	 500000.00
8	weekend	 1000000.00
\.


--
-- Data for Name: services; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.services (service_type, hotel_id, s_price) FROM stdin;
Pool	Hilton_Ast	 12000.00
SPA	Hilton_Ast	 20000.00
Conference facilities	Hilton_Ast	 50000.00
Breakfast	Hilton_Ast	 10000.00
Cinema	Hilton_Ast	 5000.00
Restaurant	Hilton_Ast	 30000.00
Snacks_in_the_room	Hilton_Ast	 5000.00
Clean_room	Hilton_Ast	 0.00
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- Name: reservations_res_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reservations_res_id_seq', 3, true);


--
-- Name: bills bills_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bills
    ADD CONSTRAINT bills_pkey PRIMARY KEY (guest_id, res_id, hotel_id);


--
-- Name: clerk clerk_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clerk
    ADD CONSTRAINT clerk_pkey PRIMARY KEY (employee_id);


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
-- Name: manager manager_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.manager
    ADD CONSTRAINT manager_pkey PRIMARY KEY (employee_id, hotel_id);


--
-- Name: roomprice price_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roomprice
    ADD CONSTRAINT price_id PRIMARY KEY (price_id);


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
    ADD CONSTRAINT reservations_pkey PRIMARY KEY (res_id, guest_id);


--
-- Name: room room_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_pkey PRIMARY KEY (r_number, hotel_id);


--
-- Name: services service_type; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.services
    ADD CONSTRAINT service_type UNIQUE (service_type);


--
-- Name: services services_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.services
    ADD CONSTRAINT services_pkey PRIMARY KEY (service_type, hotel_id);


--
-- Name: manager employee_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.manager
    ADD CONSTRAINT employee_id FOREIGN KEY (employee_id) REFERENCES public.employee(employee_id);


--
-- Name: clerk employee_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clerk
    ADD CONSTRAINT employee_id FOREIGN KEY (employee_id) REFERENCES public.employee(employee_id);


--
-- Name: bills guest_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bills
    ADD CONSTRAINT guest_id FOREIGN KEY (guest_id) REFERENCES public.guest(guest_id);


--
-- Name: reservations guest_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservations
    ADD CONSTRAINT guest_id FOREIGN KEY (guest_id) REFERENCES public.guest(guest_id) NOT VALID;


--
-- Name: services hotel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.services
    ADD CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES public.hotel(hotel_id);


--
-- Name: manager hotel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.manager
    ADD CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES public.hotel(hotel_id);


--
-- Name: employee hotel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES public.hotel(hotel_id) NOT VALID;


--
-- Name: bills hotel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bills
    ADD CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES public.hotel(hotel_id);


--
-- Name: hotelphone hotel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotelphone
    ADD CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES public.hotel(hotel_id) NOT VALID;


--
-- Name: hotelroomtype hotel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotelroomtype
    ADD CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES public.hotel(hotel_id) NOT VALID;


--
-- Name: reservations hotel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservations
    ADD CONSTRAINT hotel_id FOREIGN KEY (hotel_id) REFERENCES public.hotel(hotel_id) NOT VALID;


--
-- Name: room price_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room
    ADD CONSTRAINT price_id FOREIGN KEY (price_id) REFERENCES public.roomprice(price_id) NOT VALID;


--
-- Name: reservations r_number; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservations
    ADD CONSTRAINT r_number FOREIGN KEY (r_number) REFERENCES public.room(r_number) NOT VALID;


--
-- Name: bills res_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bills
    ADD CONSTRAINT res_id FOREIGN KEY (res_id) REFERENCES public.reservations(res_id);


--
-- Name: room room_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_fk FOREIGN KEY (hotel_id, r_type) REFERENCES public.hotelroomtype(hotel_id, r_type) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- PostgreSQL database dump complete
--

