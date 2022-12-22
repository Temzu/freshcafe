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
       ('Роллы', './images/categories/photo650.jpg'),
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

       ('Филе форели на гриле с булгуром', 380, 3, './images/products/2750092_original.jpg', '186гр'),
       ('Пельмени ручной лепки со шпинатом и томатами', 220, 3, './images/products/50.jpg', '220'),
       ('Котлеты из мраморной говядины с картофелем ', 320, 3, './images/products/p_O (123).jpg', '280гр'),
       ('Драники картофельные с семгой', 220, 3, './images/products/shutterstock_618093359-800x533.jpg', '240гр'),
       ('Куриные котлеты с пюре', 290, 3, './images/products/af4bd2e49498bf29cf153ffc7373a43d.jpg', '240гр'),
       ('Запеченный картофель с грибами', 240, 3, './images/products/zapiechiennyi-kartofiel-s-liesnymi-ghribami-основное-фото-рецепта.jpg', '210гр'),
       ('Вегетарианская лазанья с творогом', 280, 3, './images/products/00021647.jpg', '285гр, Тесто для лазаньи, баклажаны, томаты, творог, сыр «Пармезан», масло растительное, базилик, специи'),
       ('Баклажаны с чечевицей', 200, 3, './images/products/lentilTomato4.jpg', '190гр, Чечевица зеленая, баклажаны, зелень, болгарский перец, сливки, сыр «Чеддер», масло растительное, специи, кабачок'),

       ('«Цезарь» с курицей', 190, 4, './images/products/salat-cezar-s-syrom-pomidorami-kuricei-i-suxarikami_1617622037_14_max.jpg', '200гр'),
       ('«Цезарь» с креветками', 210, 4, './images/products/salat-cezar-s-krevetkami-klassicheskii_1612773942_19_max.jpg', '190гр'),
       ('Салат с запеченными овощами', 160, 4, 'https://www.gastronom.ru/binfiles/images/00000234/00080185.jpg', '190гр'),
       ('Салат с авокадо с рукколой', 250, 4, 'https://www.maggi.ru/data/images/recept/img640x500/recept_539_lsut.jpg', '205гр, Авокадо, руккола, сыр "Моцарелла", томаты "Черри", листья салата, базиликовый соус'),
       ('Горячий салат со шпинатом', 180, 4, 'https://grandkulinar.ru/uploads/posts/2018-12/1544194086_tyoplyj-salat-iz-shpinata.jpg', '195гр, Шпинат, вяленые томаты, грецкие орехи, лук, чеснок, масло грецкого ореха'),

       ('Ролл цезарь', 300, 5, 'https://storage.delikateska.ru/cache/e/d/salat-roll-cezar.jpg/w480.jpg', '290гр'),
       ('Ролл с фалафелем', 290, 5, 'https://dn.makelovepizza.ru/img/x/6new7ZXZBUdY.jpg', '275гр'),

       ('Картофель пюре', 90, 6, 'https://static.1000.menu/img/content/23212/kartofelnoe-pure-s-yaicom-i-molokom_1508924263_1_max.jpg', '150гр'),
       ('Овощи-гриль', 120, 6, 'https://www.gastronom.ru/binfiles/images/20180425/b7d6c53f.jpg', '200гр'),
       ('Рис отварной', 90, 6, 'https://vilkin.pro/wp-content/uploads/2018/09/ris-otvarnoi-rassypchatyi-770x513.jpg', '170гр'),
       ('Булгур отварной', 100, 6, 'https://static.1000.menu/img/content-v2/d7/04/29189/kak-varit-bulgur-na-vkusnyi-garnir_1635007514_0_max.jpg', '165гр'),

       ('Меренговый рулет', 90, 7, 'https://cdn.lifehacker.ru/wp-content/uploads/2019/11/Kak-prigotovit-voskhititelnyj-merengovyj-rulet_1574716230.jpg', '119гр'),
       ('Красный бархат', 140, 7, 'https://s1.eda.ru/StaticContent/Photos/120922220520/151102134726/p_O.jpg', '85гр'),
       ('Пирожное картошка', 60, 7, 'https://cdn.lifehacker.ru/wp-content/uploads/2019/06/shutterstock_1469365640_1608978931-scaled-e1608978983722-630x315.jpg', '50гр'),
       ('Миндальный торт', 150, 7, 'https://static.1000.menu/img/content/36446/shvedskii-mindalnyi-tort_1562680410_1_max.jpg', '80гр'),
       ('Морковный торт', 130, 7, 'https://www.vkusnyblog.ru/wp-content/uploads/2013/01/morkovny-tort-new.jpg', '130гр'),
       ('Торт «Прага»', 130, 7, 'https://i.ytimg.com/vi/nLJzByGd9pg/maxresdefault.jpg', '130гр'),
       ('Печенье с темным шоколадом', 90, 7, 'https://e3.edimdoma.ru/data/recipes/0006/9899/69899-ed4_wide.jpg?1628808213', '82гр'),

       ('Эспрессо', 90, 8, 'https://galaktika29.ru/upload/iblock/db6/k0ta8ki954k0l5qrh3rt4214nfa40rep.jpg', '40мл'),
       ('https://kofella.net/images/stories/vseokofe/kofe-doppio-dvoynoy-espresso.jpg', 150, 8, './images/products/5d880b.jpg', '80мл'),
       ('Американо', 100, 8, 'https://coffe-spb.ru/img/cms/americano.jpg', '120мл'),
       ('Кофе Гляссе', 140, 8, 'https://xcoffee.ru/wp-content/uploads/2015/01/sweetmir.jpg', '150мл'),
       ('Флэт Уайт', 200, 8, 'http://coffeepedia.ru/wp-content/uploads/2015/04/flw.png', '200мл'),
       ('Капучино 200мл', 175, 8, 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Classic_Cappuccino.jpg/640px-Classic_Cappuccino.jpg', '200мл'),
       ('Капучино 400мл', 260, 8, 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Classic_Cappuccino.jpg/640px-Classic_Cappuccino.jpg', '400мл'),
       ('Латте 200мл', 180, 8, 'https://upload.wikimedia.org/wikipedia/commons/c/c6/Latte_art_3.jpg', '200мл'),
       ('Латте 400мл', 270, 8, 'https://upload.wikimedia.org/wikipedia/commons/c/c6/Latte_art_3.jpg', '400мл'),
       ('Раф', 200, 8, 'https://edaprof.ru/image/catalog/napitki/raf-kofe-1-min.jpg', '220мл'),
       ('Бамбл-кофе', 195, 8, 'https://www.dolce-gusto.ru/media/wysiwyg/mygento/recipes/main-bumble-coffee.jpg', 'можно приготовить холодным, кофе, апельсиновый сок, сироп «Карамель»'),
       ('Фраппе', 195, 8, 'https://cdn.lifehacker.ru/wp-content/uploads/2020/05/shutterstock_778250395-1_1589908954.jpg', '250мл, холодный кофе, Каремель/Мокко'),

       ('Иван-чай 350мл', 100, 9, 'https://cdnn21.img.ria.ru/images/07e5/03/03/1599798800_0:95:3072:1823_1920x0_80_0_0_4ae9f8f8f42e9798201ec86aae4b0fda.jpg', '350мл, Обладает терпким вкусом с душистым цветочно-травяным ароматом'),
       ('Иван-чай 700мл', 150, 9, 'https://cdnn21.img.ria.ru/images/07e5/03/03/1599798800_0:95:3072:1823_1920x0_80_0_0_4ae9f8f8f42e9798201ec86aae4b0fda.jpg', '700мл, Обладает терпким вкусом с душистым цветочно-травяным ароматом'),
       ('Фруктовый 350мл', 120, 9, 'https://img-global.cpcdn.com/recipes/ec9c497c004ca46f/400x400cq70/photo.jpg', '350мл, Яблоко, изюм, шиповник, каркаде, цукаты, лепестки календулы и василька'),
       ('Фруктовый 700мл', 160, 9, 'https://img-global.cpcdn.com/recipes/ec9c497c004ca46f/400x400cq70/photo.jpg', '700мл, Яблоко, изюм, шиповник, каркаде, цукаты, лепестки календулы и василька'),
       ('Имбирный чай 350мл', 100, 9, 'https://cdn.lifehacker.ru/wp-content/uploads/2019/11/N-receptov-imbirnogo-chaya-kotoryj-sogreet-v-holodnuyu-pogodu_1576015504.jpg', '350мл, Корень имбиря, лимон, мед'),
       ('Имбирный чай 700мл', 160, 9, 'https://cdn.lifehacker.ru/wp-content/uploads/2019/11/N-receptov-imbirnogo-chaya-kotoryj-sogreet-v-holodnuyu-pogodu_1576015504.jpg', '700мл, Корень имбиря, лимон, мед'),
       ('Гречишный чай 700мл', 220, 9, 'https://mvfood.ru/wp-content/uploads/2020/02/grechishnyj-chaj-1.jpg', '350мл, Чай в чайнике. Богат железом, магнием, калием, фосфором, медью, а также витаминами группы В, РР, Р (Рутин)'),
       ('Ройбуш 350мл', 150, 9, 'https://tea.ru/upload/medialibrary/ff0/ff0b347c0069950d7dbce2e4179d201d.jpg', '350мл, Полезный, ароматный и вкусный напиток. В состав входят антиоксиданты и целый ряд витаминов (С, Е, Р, А)'),
       ('Ройбуш 700мл', 220, 9, 'https://tea.ru/upload/medialibrary/ff0/ff0b347c0069950d7dbce2e4179d201d.jpg', '700мл, Полезный, ароматный и вкусный напиток. В состав входят антиоксиданты и целый ряд витаминов (С, Е, Р, А)'),
       ('Эрл грей 350мл', 100, 9, 'https://samovartime.ru/image/catalog/blog_images/chernyi-chai-erl-grey/chai-erl-grei-istoki-polza.jpg', '350мл'),
       ('Эрл грей 700мл', 150, 9, 'https://samovartime.ru/image/catalog/blog_images/chernyi-chai-erl-grey/chai-erl-grei-istoki-polza.jpg', '700мл'),

       ('Газированная / негазированная 350мл', 60, 10, 'https://www.c-e.ru/cat/p/500px/777635.jpg', '350мл'),
       ('Клюквенный морс 300мл', 70, 10, 'https://www.gastronom.ru/binfiles/images/20151028/b5c24679.jpg', '300мл'),
       ('Черносмородиновый морс 300мл', 70, 10, 'https://cdn.azbyka.ru/recept/wp-content/uploads/2020/09/bowl-with-black-currant-berries-and-fresh-compote-of-ripe-black-currant-in-a-glass-on-a-wooden-table.jpg', '300мл'),

       ('Ежевичный 400мл', 180, 11, 'https://cdn.segodnya.ua/i/original/media/image/5f3/694/801/5f3694801d5bd.jpg', '400мл'),
       ('Ежевичный 1000мл', 300, 11, 'https://cdn.segodnya.ua/i/original/media/image/5f3/694/801/5f3694801d5bd.jpg', '1000мл'),
       ('Черничный 400мл', 180, 11, 'https://s1.eda.ru/StaticContent/Photos/110801145258/120214124812/p_O.jpg', '400мл'),
       ('Черничный 1000мл', 300, 11, 'https://s1.eda.ru/StaticContent/Photos/110801145258/120214124812/p_O.jpg', '1000мл'),
       ('Клубничный 400мл', 180, 11, 'https://n1s1.hsmedia.ru/3f/c2/f0/3fc2f0cd339cad67b5f3e36bd5dd9f03/728x546_1_1f43f4ef57fb3400128c2b2cc1ca2520@1706x1280_0xac120003_16059982531655077987.jpeg', '400мл'),
       ('Клубничный 1000мл', 300, 11, 'https://n1s1.hsmedia.ru/3f/c2/f0/3fc2f0cd339cad67b5f3e36bd5dd9f03/728x546_1_1f43f4ef57fb3400128c2b2cc1ca2520@1706x1280_0xac120003_16059982531655077987.jpeg', '1000мл'),
       ('Тропический 400мл', 180, 11, 'https://www.gastronom.ru/binfiles/images/20171121/b3dbcf37.jpg', '400мл'),
       ('Тропический 1000мл', 300, 11, 'https://www.gastronom.ru/binfiles/images/20171121/b3dbcf37.jpg', '1000мл'),
       ('Цитрусовый 400мл', 180, 11, 'https://zira.uz/wp-content/uploads/2019/05/citrusoviy-limonad-2.jpg', '400мл'),
       ('Цитрусовый 1000мл', 300, 11, 'https://zira.uz/wp-content/uploads/2019/05/citrusoviy-limonad-2.jpg', '1000мл'),

       ('Банан-апельсин 300мл', 200, 12, 'https://img.7dach.ru/image/600/17/79/12/2020/10/08/c464a5.jpg', '300мл, Вода, банан, корица, апельсин'),
       ('Ягодный микс 300мл', 270, 12, 'https://aif-s3.aif.ru/images/006/711/caeb097bd38349267fb0a816bc3a775f.jpg', '300мл, Клубника, малина, банан, клюква, яблоко'),
       ('Черника-банан 300мл', 200, 12, 'https://foodistika.ru/wp-content/uploads/2020/04/Smuzi-s-chernikoj-bananom-i-avokado-1.jpg', '300мл, Вода, банан, черника'),
       ('Микс с имбирем 300мл', 250, 12, 'https://www.patee.ru/r/x6/01/44/a3/960m.jpg', '300мл, Вода, банан, груша, яблоко, киви, корень имбиря, мята, шпинат'),

       ('Морковный 300мл', 140, 13, 'https://volshebnaya-eda.ru/wp-content/uploads/2014/01/morkovny-sok1.jpg', '300мл'),
       ('Яблочный 300мл', 140, 13, 'https://markov-dvor.ru/tmp/images/products/156/d621832e9d12a3f50bd7_800x800.jpg', '300мл'),
       ('Апельсиновый 300мл', 200, 13, 'https://halal-spb.ru/sites/default/files/products/sok_apels.jpg', '300мл'),
       ('Грейпфрутовый 300мл', 200, 13, 'https://www.gastronom.ru/binfiles/images/20150306/b6bb9eb2.jpg', '300мл'),
       ('Грушевый 250мл', 170, 13, 'https://www.patee.ru/r/x6/04/52/1c/960m.jpg', '250мл'),
       ('Яблоко-сельдерей 300мл', 170, 13, 'https://suseky.com/wp-content/uploads/2017/10/celery_juice_01-kopiya-700x474.jpg', '300мл'),
       ('Яблоко-морковь 300мл', 170, 13, 'https://gastronomglobus.ru/assets/images/products/16264/big/yablok.jpg', '300мл');




