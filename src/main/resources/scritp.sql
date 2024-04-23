
DROP TABLE IF EXISTS public.user_app;
DROP SEQUENCE IF EXISTS public.user_seq;
CREATE SEQUENCE IF NOT EXISTS public.user_seq;

CREATE TABLE public.user_app (
    id INTEGER DEFAULT nextval('public.user_seq') PRIMARY key not null,
    name varchar(30) not null,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null
);


INSERT INTO public."user_app"
("name", created_at)
values('kimberly', '2023-05-27 04:34:12');
INSERT INTO public."user_app"
("name", created_at)
VALUES('juan', '2023-04-14 02:40:00');
INSERT INTO public."user_app"
("name", created_at)
VALUES('cat', '2023-09-08 00:47:38');
INSERT INTO public."user_app"
("name", created_at)
VALUES('dog', '2023-06-10 23:37:22');
INSERT INTO public."user_app"
("name")
VALUES('ruben');

commit;

