create table categories
(
    id            bigserial primary key,
    title         varchar(255) not null,
    image_name    varchar(255),
    active_status boolean default true,
    created_at    timestamp default current_timestamp,
    updated_at    timestamp default current_timestamp
);

insert into categories (title, image_name)
values ('Завтраки', './images/categories/recepty-dlya-zavtraka-2.jpg'),
       ('Супы', './images/categories/64112040.jpg'),
       ('Горячие блюда', './images/categories/dishes-for-the-new-year-e1545903177674.jpg'),
       ('Салаты', './images/categories/salad-for-ny2-e1545389471379.jpg'),
       ('Роллы', './images/categories/glavnaya-7.jpg'),
       ('Гарниры', './images/categories/garnir.jpg'),
       ('Десерты', './images/categories/1541338458_zamorozhennye-deserty-bolee-60-receptov.jpg'),
       ('Кофе', './images/categories/6579-ed4_wide.jpg'),
       ('Чай', './images/categories/7c664063ba5e6215cb3567de3330c187.jpg'),
       ('Вода', './images/categories/mineralnaya-ili-pitievaya-voda.jpg'),
       ('Лимонады', './images/categories/shutterstock-285268421.jpg'),
       ('Смузи', './images/categories/fruktovyi-smuzi-v-blendere_1629916238_11_max.jpg'),
       ('Свежевыжатые соки', './images/categories/svezhevyzhatyy-sok2.jpg');

create table products
(
    id          bigserial primary key,
    title       varchar(255)  not null,
    price       numeric(8, 2) not null,
    description varchar(255),
    image_name  varchar(255),
    active_status boolean default true,
    category_id bigint references categories (id),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);

insert into products (title, price, category_id, image_name)
values ('Сырники', 220, 1, './images/products/1sirniki.png'),
       ('Блины', 230, 1, './images/products/DSC_0850.jpg'),
       ('Овсянка', 130, 1, './images/products/p_O.jpg'),
       ('Рисовая каша', 190, 1, './images/products/p_O (1).jpg'),
       ('Круассан с копченым тофу', 260, 1, './images/products/__.png'),
       ('Омлет', 110, 1, './images/products/omlet-s-sirom.jpg'),
       ('Яичница', 110, 1, './images/products/2ea2a5739495455ebe732e8c42cbe453.jpg'),
       ('Борщ с говядиной', 230, 2, './images/products/borshch-klassicheskii-s-govyadinoi_1615365982_21_max.jpg'),
       ('Куриный суп', 160, 2, './images/products/kurinii_sup_s_chesnokom-614417.jpg'),
       ('Крем-суп из тыквы', 180, 2, './images/products/sup-pure-iz-tykvy-klassicheskii_1545215004_1_max.jpg'),
       ('Крем-суп грибной', 170, 2, './images/products/5d880b.jpg'),
       ('Уха из семги ', 250, 2, './images/products/maxresdefault.jpg');