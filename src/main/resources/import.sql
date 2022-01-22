INSERT INTO persona(id, altura, apellido, contador, edad, fecha_nacimiento, genero, nombre, peso) VALUES (null, 1.80, 'Rojas', 0, 20, '2020-01-03', 'Hombre', 'Anderson', 65);
INSERT INTO persona(id, altura, apellido, contador, edad, fecha_nacimiento, genero, nombre, peso) VALUES (null, 1.80, 'Rojas', 0, 20, '2020-01-03', 'Hombre', '1Anderson', 65);
INSERT INTO persona(id, altura, apellido, contador, edad, fecha_nacimiento, genero, nombre, peso) VALUES (null, 1.80, 'Rojas', 0, 20, '2020-01-03', 'Hombre', '2Anderson', 65);
INSERT INTO persona(id, altura, apellido, contador, edad, fecha_nacimiento, genero, nombre, peso) VALUES (null, 1.80, 'Rojas', 0, 20, '2020-01-03', 'Hombre', '3Anderson', 65);
INSERT INTO persona(id, altura, apellido, contador, edad, fecha_nacimiento, genero, nombre, peso) VALUES (null, 1.80, 'Rojas', 0, 20, '2020-01-03', 'Hombre', '4Anderson', 65);

INSERT INTO planeta (id, cantidad_habitantes, clima, contador, diametro, nombre, periodo_de_rotacion, terreno, url_img) VALUES (null, 1, 'nublado', 0, 180, 'Tierra', '2000-03-02', 'rocoso', 'https://ichef.bbci.co.uk/news/640/cpsprodpb/192F/production/_111874460_gettyimages-1162834347-1.jpg');
INSERT INTO planeta (id, cantidad_habitantes, clima, contador, diametro, nombre, periodo_de_rotacion, terreno, url_img) VALUES (null, 1, 'nublado', 0, 180, 'Jupiter', '2000-03-02', 'rocoso', 'https://upload.wikimedia.org/wikipedia/commons/e/e2/Jupiter.jpg');
INSERT INTO planeta (id, cantidad_habitantes, clima, contador, diametro, nombre, periodo_de_rotacion, terreno, url_img) VALUES (null, 1, 'nublado', 0, 180, 'Saturno', '2000-03-02', 'rocoso', 'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/stsci-h-p2043a-f-1592x1137-1595858283.png?crop=0.716xw:1.00xh;0.112xw,0&resize=640:*');
INSERT INTO planeta (id, cantidad_habitantes, clima, contador, diametro, nombre, periodo_de_rotacion, terreno, url_img) VALUES (null, 1, 'nublado', 0, 180, 'Venus', '2000-03-02', 'rocoso', 'https://static01.nyt.com/images/2020/09/14/science/15venus-es-00/14SCI-VENUS1-alt-superJumbo.jpg');
INSERT INTO planeta (id, cantidad_habitantes, clima, contador, diametro, nombre, periodo_de_rotacion, terreno, url_img) VALUES (null, 1, 'nublado', 0, 180, 'Mercurio', '2000-03-02', 'rocoso', 'https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/gallery/61b754fa5cafe8e24d86f312/mercurio0.jpg');

INSERT INTO persona_has_planeta (id, persona_id, planeta_id) VALUES (null, 1, 1);
INSERT INTO persona_has_planeta (id, persona_id, planeta_id) VALUES (null, 2, 2);
INSERT INTO persona_has_planeta (id, persona_id, planeta_id) VALUES (null, 3, 3);
INSERT INTO persona_has_planeta (id, persona_id, planeta_id) VALUES (null, 4, 4);
INSERT INTO persona_has_planeta (id, persona_id, planeta_id) VALUES (null, 5, 5);
