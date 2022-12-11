create table categories
(
    id         bigserial primary key,
    title      varchar(255) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into categories (title)
values ('Завтраки'),
       ('Супы'),
       ('Горячие блюда'),
       ('Салаты'),
       ('Роллы'),
       ('Гарниры '),
       ('Десерты'),
       ('Напитки');

create table products
(
    id          bigserial primary key,
    title       varchar(255)  not null,
    price       numeric(8, 2) not null,
    description varchar(255),
    image_name  varchar(255),
    category_id bigint references categories (id),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);

insert into products (title, price, category_id, image_name)
values ('Сырники', 220, 1, '1sirniki.png'),
       ('Блины', 230, 1, 'DSC_0850.jpg'),
       ('Овсянка', 130, 1, 'p_O.jpg'),
       ('Рисовая каша', 190, 1, 'p_O (1).jpg'),
       ('Круассан с копченым тофу', 260, 1, '__.png'),
       ('Омлет', 110, 1, 'omlet-s-sirom.jpg'),
       ('Яичница', 110, 1, '2ea2a5739495455ebe732e8c42cbe453.jpg'),
       ('Борщ с говядиной', 230, 2, 'borshch-klassicheskii-s-govyadinoi_1615365982_21_max.jpg'),
       ('Куриный суп', 160, 2, 'kurinii_sup_s_chesnokom-614417.jpg'),
       ('Крем-суп из тыквы', 180, 2, 'sup-pure-iz-tykvy-klassicheskii_1545215004_1_max.jpg'),
       ('Крем-суп грибной', 170, 2, '5d880b.jpg'),
       ('Уха из семги ', 250, 2, 'maxresdefault.jpg');