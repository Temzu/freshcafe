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

insert into products (title, price, category_id, image_name, description)
values ('Сырники', 220, 1, './images/products/1sirniki.png', '200гр, творог, льняная мука, рисовая мука, изюм, курага, сироп топинамбура'),
       ('Блины', 230, 1, './images/products/DSC_0850.jpg', '220гр, Мука пшеничная, тростниковый сахар, соль, масло растительное'),
       ('Овсянка', 130, 1, './images/products/p_O.jpg', '250гр'),
       ('Рисовая каша', 190, 1, './images/products/p_O (1).jpg', '220гр'),
       ('Круассан с копченым тофу', 260, 1, './images/products/__.png', '180гр, круассан, тофу, томат, листья салата, соус из базилика и авокадо, кинза, чеснок, специи'),
       ('Омлет', 110, 1, './images/products/omlet-s-sirom.jpg', '129гр'),
       ('Яичница', 110, 1, './images/products/2ea2a5739495455ebe732e8c42cbe453.jpg', '152гр'),

       ('Борщ с говядиной', 230, 2, './images/products/borshch-klassicheskii-s-govyadinoi_1615365982_21_max.jpg', '272гр'),
       ('Куриный суп', 160, 2, './images/products/kurinii_sup_s_chesnokom-614417.jpg', '250гр'),
       ('Крем-суп из тыквы', 180, 2, './images/products/sup-pure-iz-tykvy-klassicheskii_1545215004_1_max.jpg', '190гр'),
       ('Крем-суп грибной', 170, 2, './images/products/5d880b.jpg', '190гр'),
       ('Уха из семги ', 250, 2, './images/products/maxresdefault.jpg', '240гр'),

       ('Филе форели на гриле с булгуром', 380, 3, './images/products/5d880b.jpg', '186гр'),
       ('Пельмени ручной лепки со шпинатом и томатами', 220, 3, './images/products/5d880b.jpg', '220'),
       ('Котлеты из мраморной говядины с картофелем ', 320, 3, './images/products/5d880b.jpg', '280гр'),
       ('Драники картофельные с семгой', 220, 3, './images/products/5d880b.jpg', '240гр'),
       ('Куриные котлеты с пюре', 290, 3, './images/products/5d880b.jpg', '240гр'),
       ('Запеченный картофель с грибами', 240, 3, './images/products/5d880b.jpg', '210гр'),
       ('Вегетарианская лазанья с творогом', 280, 3, './images/products/5d880b.jpg', '285гр, Тесто для лазаньи, баклажаны, томаты, творог, сыр «Пармезан», масло растительное, базилик, специи'),
       ('Баклажаны с чечевицей', 200, 3, './images/products/5d880b.jpg', '190гр, Чечевица зеленая, баклажаны, зелень, болгарский перец, сливки, сыр «Чеддер», масло растительное, специи, кабачок'),

       ('«Цезарь» с курицей', 190, 4, './images/products/5d880b.jpg', '200гр'),
       ('«Цезарь» с креветками', 210, 4, './images/products/5d880b.jpg', '190гр'),
       ('Салат с запеченными овощами', 160, 4, './images/products/5d880b.jpg', '190гр'),
       ('Салат с авокадо с рукколой', 250, 4, './images/products/5d880b.jpg', '205гр, Авокадо, руккола, сыр "Моцарелла", томаты "Черри", листья салата, базиликовый соус'),
       ('Горячий салат со шпинатом', 180, 4, './images/products/5d880b.jpg', '195гр, Шпинат, вяленые томаты, грецкие орехи, лук, чеснок, масло грецкого ореха'),

       ('Ролл цезарь', 300, 5, './images/products/5d880b.jpg', '290гр'),
       ('Ролл с фалафелем', 290, 5, './images/products/5d880b.jpg', '275гр'),

       ('Картофель пюре', 90, 6, './images/products/5d880b.jpg', '150гр'),
       ('Овощи-гриль', 120, 6, './images/products/5d880b.jpg', '200гр'),
       ('Рис отварной', 90, 6, './images/products/5d880b.jpg', '170гр'),
       ('Булгур отварной', 100, 6, './images/products/5d880b.jpg', '165гр'),

       ('Меренговый рулет', 90, 7, './images/products/5d880b.jpg', '119гр'),
       ('Красный бархат', 140, 7, './images/products/5d880b.jpg', '85гр'),
       ('Пирожное картошка', 60, 7, './images/products/5d880b.jpg', '50гр'),
       ('Миндальный торт', 150, 7, './images/products/5d880b.jpg', '80гр'),
       ('Морковный торт', 130, 7, './images/products/5d880b.jpg', '130гр'),
       ('Торт «Прага»', 130, 7, './images/products/5d880b.jpg', '130гр'),
       ('Печенье с темным шоколадом', 90, 7, './images/products/5d880b.jpg', '82гр'),

       ('Эспрессо', 90, 8, './images/products/5d880b.jpg', '40мл'),
       ('Двойной эспрессо', 150, 8, './images/products/5d880b.jpg', '80мл'),
       ('Американо', 100, 8, './images/products/5d880b.jpg', '120мл'),
       ('Кофе Гляссе', 140, 8, './images/products/5d880b.jpg', '150мл'),
       ('Флэт Уайт', 200, 8, './images/products/5d880b.jpg', '200мл'),
       ('Капучино 200мл', 175, 8, './images/products/5d880b.jpg', '200мл'),
       ('Капучино 400мл', 260, 8, './images/products/5d880b.jpg', '400мл'),
       ('Латте 200мл', 180, 8, './images/products/5d880b.jpg', '200мл'),
       ('Латте 400мл', 270, 8, './images/products/5d880b.jpg', '400мл'),
       ('Раф', 200, 8, './images/products/5d880b.jpg', '220мл'),
       ('Бамбл-кофе', 195, 8, './images/products/5d880b.jpg', 'можно приготовить холодным, кофе, апельсиновый сок, сироп «Карамель»'),
       ('Фраппе', 195, 8, './images/products/5d880b.jpg', '250мл, холодный кофе, Каремель/Мокко'),

       ('Иван-чай 350мл', 100, 9, './images/products/5d880b.jpg', '350мл, Обладает терпким вкусом с душистым цветочно-травяным ароматом'),
       ('Иван-чай 700мл', 150, 9, './images/products/5d880b.jpg', '700мл, Обладает терпким вкусом с душистым цветочно-травяным ароматом'),
       ('Фруктовый 350мл', 120, 9, './images/products/5d880b.jpg', '350мл, Яблоко, изюм, шиповник, каркаде, цукаты, лепестки календулы и василька'),
       ('Фруктовый 700мл', 160, 9, './images/products/5d880b.jpg', '700мл, Яблоко, изюм, шиповник, каркаде, цукаты, лепестки календулы и василька'),
       ('Имбирный чай 350мл', 100, 9, './images/products/5d880b.jpg', '350мл, Корень имбиря, лимон, мед'),
       ('Имбирный чай 700мл', 160, 9, './images/products/5d880b.jpg', '700мл, Корень имбиря, лимон, мед'),
       ('Гречишный чай 700мл', 220, 9, './images/products/5d880b.jpg', '350мл, Чай в чайнике. Богат железом, магнием, калием, фосфором, медью, а также витаминами группы В, РР, Р (Рутин)'),
       ('Ройбуш 350мл', 150, 9, './images/products/5d880b.jpg', '350мл, Полезный, ароматный и вкусный напиток. В состав входят антиоксиданты и целый ряд витаминов (С, Е, Р, А)'),
       ('Ройбуш 700мл', 220, 9, './images/products/5d880b.jpg', '700мл, Полезный, ароматный и вкусный напиток. В состав входят антиоксиданты и целый ряд витаминов (С, Е, Р, А)'),
       ('Эрл грей 350мл', 100, 9, './images/products/5d880b.jpg', '350мл'),
       ('Эрл грей 700мл', 150, 9, './images/products/5d880b.jpg', '700мл'),

       ('Газированная / негазированная 350мл', 60, 10, './images/products/5d880b.jpg', '350мл'),
       ('Клюквенный морс 300мл', 70, 10, './images/products/5d880b.jpg', '300мл'),
       ('Черносмородиновый морс 300мл', 70, 10, './images/products/5d880b.jpg', '300мл'),

       ('Ежевичный 400мл', 180, 11, './images/products/5d880b.jpg', '400мл'),
       ('Ежевичный 1000мл', 300, 11, './images/products/5d880b.jpg', '1000мл'),
       ('Черничный 400мл', 180, 11, './images/products/5d880b.jpg', '400мл'),
       ('Черничный 1000мл', 300, 11, './images/products/5d880b.jpg', '1000мл'),
       ('Клубничный 400мл', 180, 11, './images/products/5d880b.jpg', '400мл'),
       ('Клубничный 1000мл', 300, 11, './images/products/5d880b.jpg', '1000мл'),
       ('Тропический 400мл', 180, 11, './images/products/5d880b.jpg', '400мл'),
       ('Тропический 1000мл', 300, 11, './images/products/5d880b.jpg', '1000мл'),
       ('Цитрусовый 400мл', 180, 11, './images/products/5d880b.jpg', '400мл'),
       ('Цитрусовый 1000мл', 300, 11, './images/products/5d880b.jpg', '1000мл'),

       ('Банан-апельсин 300мл', 200, 12, './images/products/5d880b.jpg', '300мл, Вода, банан, корица, апельсин'),
       ('Ягодный микс 300мл', 270, 12, './images/products/5d880b.jpg', '300мл, Клубника, малина, банан, клюква, яблоко'),
       ('Черника-банан 300мл', 200, 12, './images/products/5d880b.jpg', '300мл, Вода, банан, черника'),
       ('Микс с имбирем 300мл', 250, 12, './images/products/5d880b.jpg', '300мл, Вода, банан, груша, яблоко, киви, корень имбиря, мята, шпинат'),

       ('Морковный 300мл', 140, 13, './images/products/5d880b.jpg', '300мл'),
       ('Яблочный 300мл', 140, 13, './images/products/5d880b.jpg', '300мл'),
       ('Апельсиновый 300мл', 200, 13, './images/products/5d880b.jpg', '300мл'),
       ('Грейпфрутовый 300мл', 200, 13, './images/products/5d880b.jpg', '300мл'),
       ('Грушевый 250мл', 170, 13, './images/products/5d880b.jpg', '250мл'),
       ('Яблоко-сельдерей 300мл', 170, 13, './images/products/5d880b.jpg', '300мл'),
       ('Яблоко-морковь 300мл', 170, 13, './images/products/5d880b.jpg', '300мл');




