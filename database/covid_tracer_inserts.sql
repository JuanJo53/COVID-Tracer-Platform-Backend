/*Role inserts*/
insert into role values (null, "ROLE_ADMIN", 1, 0, "127.0.0.1", 0, "2021-06-04");
insert into role values (null, "ROLE_USER", 1, 0, "127.0.0.1", 0, "2021-06-04");

/*Person inserts*/
insert into person values(null, "Juan", "Rocha", "Cruz", 1, 0, "127.0.0.1", 0, "2021-06-04");

/*User inserts password=abc12345*/
insert into user values(null, 1, "juanrocha@gmail.com", "juanrocha", "$2a$10$bCwH7ZxnvItj5AjIYtbHAuFiEC0vp8yB0HpAjLoJzWWmK.1YJcM2G", 1, 0, "127.0.0.1", 0, "2021-06-04");

/*User_Role inserts*/
insert into user_role values(null, 1, 1, 1, 0, "127.0.0.1", 0, "2021-06-04");

/*Country inserts*/
INSERT INTO `country` VALUES (null,'AFG', 'Afganistán', 33.93911, 67.709953,1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null, 'ALB','Albania',41.153332, 20.168331,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'DEU', 'Alemania',51.165691, 10.451526, 1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'AND', 'Andorra',42.546245, 1.601554, 1,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'AGO', 'Angola',-11.202692, 17.873887 , 1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'AIA',  'Anguilla',18.220554, -63.068615 ,1,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'ATG', 'Antigua y Barbuda',17.060816, -61.796428 ,1   ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null, 'SAU','Arabia Saudí',23.885942, 45.079162,  1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'DZA', 'Argelia',28.033886, 1.659626,  1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'ARG', 'Argentina',-38.416097, -63.616672, 1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'ARM', 'Armenia',40.069099, 45.038189, 1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null, 'AUS','Australia',-25.274398, 133.775136,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null, 'AUT', 'Austria',47.516231, 14.550072,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null, 'AZE','Azerbaiyán',40.143105, 47.576927,1   ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null, 'BHS','Bahamas',25.03428, -77.39628, 1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'BHR', 'Bahréin',25.930414, 50.637772,1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'BGD', 'Bangladesh',23.684994, 90.356331,1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'BRB', 'Barbados',13.193887, -59.543198, 1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'BLR', 'Bielorrusia',53.709807, 27.953389,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'BEL', 'Bélgica',50.503887, 4.469936, 1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'BLZ', 'Belice',17.189877, -88.49765, 1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'BEN', 'Benin',9.30769, 2.315834, 1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'BMU',  'Bermudas',32.321384, -64.75737,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'BTN', 'Bután',27.514162, 90.433601,  1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'BOL', 'Bolivia',-16.290154, -63.588653,1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'BIH', 'Bosnia y Herzegovina',43.915886, 17.679076 ,1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'BWA', 'Botsuana',-22.328474, 24.684866,  1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'BRA', 'Brasil',-14.235004, -51.92528, 1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'BRN', 'Brunéi',4.535277, 114.727669, 1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'BGR', 'Bulgaria',42.733883, 25.48583, 1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'BFA','Burkina Faso',12.238333, -1.561593,1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'BDI','Burundi',-3.373056, 29.918886, 1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'CPV','Cabo Verde',16.002082, -24.013197,1 ,0,"127.0.0.1",0,NOW() );
INSERT INTO `country` VALUES (null,'CYM' ,'Islas Caimán',19.513469, -80.566956,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'KHM', 'Camboya',12.565679, 104.990963,  1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'CMR', 'Camerún',7.369722, 12.354722, 1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'CAN',  'Canadá',56.130366, -106.346771, 1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'CAF','República Centroafricana',6.611111, 20.939444,1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'TCD', 'Chad',15.454166, 18.732207,1   ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'CZE', 'República Checa',49.817492, 15.472962,1   ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'CHL', 'Chile',-35.675147, -71.542969, 1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'CHN', 'China',35.86166, 104.195397, 1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'CYP', 'Chipre',35.126413, 33.429859,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'VAT', 'Ciudad del Vaticano',41.902916, 12.453389 , 1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'COL', 'Colombia',4.570868, -74.297333,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'COM', 'Comoras',-11.875001, 43.872219, 1 ,0,"127.0.0.1",0,NOW() );
INSERT INTO `country` VALUES (null,'COD',  'República Democrática del Congo',-4.038333, 21.758664,1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'COG', 'Congo',-0.228021, 15.827659,1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'KOR', 'Corea del Sur',35.907757, 127.766922,1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'CIV', 'Costa de Marfil',7.539989, -5.54708,1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'CRI', 'Costa Rica',9.748917, -83.753428,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'HRV', 'Croacia',45.1, 15.2,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'CUB', 'Cuba',21.521757, -77.781167,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'DNK', 'Dinamarca',56.26392, 9.501785,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'DMA', 'Dominica',15.414999, -61.370976,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'DOM', 'República Dominicana',18.735693, -70.162651,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'ECU', 'Ecuador',-1.831239, -78.183406,1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'EGY', 'Egipto',26.820553, 30.802498, 1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'SLV',  'El Salvador',13.794185, -88.89653,1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'ARE', 'Emiratos Árabes Unidos',23.424076, 53.847818,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'ERI', 'Eritrea',15.179384, 39.782334,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'SVK', 'Eslovaquia',48.669026, 19.699024,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'SVN', 'Eslovenia',46.151241, 14.995463, 1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'ESP', 'España',40.463667, -3.74922,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'USA',  'Estados Unidos',37.09024, -95.712891,1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'EST', 'Estonia',58.595272, 25.013607,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'ETH', 'Etiopía',9.145, 40.489673,1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'FRO', 'Islas Feroe',61.892635, -6.911806, 1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'PHL', 'Filipinas',12.879721, 121.774017,1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'FIN', 'Finlandia',61.92411, 25.748151, 1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'FJI', 'Fiyi',-16.578193, 179.414413,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'FRA', 'Francia',46.227638, 2.213749,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'GAB', 'Gabón',-0.803689, 11.609444,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'GMB',  'Gambia',13.443182, -15.310139,1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'GEO', 'Georgia',42.315407, 43.356892, 1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'GHA', 'Ghana',7.946527, -1.023194, 1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'GIB', 'Gibraltar',36.137741, -5.345374,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'GRD', 'Granada',12.262776, -61.604171,1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'GRC', 'Grecia',39.074208, 21.824312, 1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'GRL', 'Groenlandia',71.706936, -42.604303,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'GTM', 'Guatemala',15.783471, -90.230759,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'GIN', 'Guinea',9.945587, -9.696645,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'GNQ', 'Guinea Ecuatorial',1.650801, 10.267895,1  ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'GNB', 'Guinea-Bissau',11.803749, -15.180413, 1 ,0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'GUY', 'Guyana',4.860416, -58.93018,1 ,0,"127.0.0.1",0,NOW() );
INSERT INTO `country` VALUES (null,'HTI', 'Haití',18.971187, -72.285215,1,0,"127.0.0.1",0,now());
INSERT INTO `country` VALUES (null,'HND', 'Honduras',15.199999, -86.241905, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'HKG',  'Hong Kong',22.396428, 114.109497,1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'HUN', 'Hungría',47.162494, 19.503304, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'IND', 'India',20.593684, 78.96288,1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'IDN',  'Indonesia',-0.789275, 113.921327,1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'IRN', 'Irán',32.427908, 53.688046,1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'IRQ',  'Iraq',33.223191, 43.679291, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'IRL',  'Irlanda',53.41291, -8.24389, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'ISL',  'Islandia',64.963051, -19.020835,1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'ISR', 'Israel',31.046051, 34.851612,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'ITA', 'Italia',41.87194, 12.56738,1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'JAM',  'Jamaica',18.109581, -77.297508,1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'JPN', 'Japón',36.204824, 138.252924, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'JOR', 'Jordania',30.585164, 36.238414,1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'KAZ', 'Kazajstán',48.019573, 66.923684, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'KEN',  'Kenia',-0.023559, 37.906193,1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'KGZ', 'Kirguistán',41.20438, 74.766098, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null, 'KWT', 'Kuwait',29.31166, 47.481766, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'LAO', 'Laos',19.85627, 102.495496,1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'LSO', 'Lesotho',-29.609988, 28.233608,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'LVA', 'Letonia',56.879635, 24.603189, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'LBN',  'Líbano',33.854721, 35.862285, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'LBR', 'Liberia',6.428055, -9.429499,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'LBY', 'Libia',26.3351, 17.228331,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'LIE', 'Liechtenstein',47.166, 9.555373, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'LTU', 'Lituania',55.169438, 23.881275,1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'LUX', 'Luxemburgo',49.815273, 6.129583,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'MAC', 'Macao',22.198745, 113.543873, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'MKD', 'ARY Macedonia',41.608635, 21.745275, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'MDG', 'Madagascar',-18.766947, 46.869107, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null, 'MYS','Malasia',4.210484, 101.975766, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'MWI', 'Malaui',-13.254308, 34.301525, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'MDV', 'Maldivas',3.202778, 73.22068, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'MLI', 'Malí',17.570692, -3.996166, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'MLT', 'Malta',35.937496, 14.375416, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'MAR', 'Marruecos',31.791702, -7.09262, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null, 'MHL','Islas Marshall',7.131474, 171.184478, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'MUS', 'Mauricio',-20.348404, 57.552152, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'MRT', 'Mauritania',21.00789, -10.940835, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'MEX', 'México',23.634501, -102.552784, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'FSM', 'Micronesia',7.425554, 150.550812, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'MDA', 'Moldavia',47.411631, 28.369885, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'MCO', 'Mónaco',43.750298, 7.412841, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'MNG', 'Mongolia',46.862496, 103.846656, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'MSR', 'Montserrat',16.742498, -62.187366, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'MOZ', 'Mozambique',-18.665695, 35.529562, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'MMR',  'Myanmar',21.913965, 95.956223,1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'NAM', 'Namibia',-22.95764, 18.49041, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'NPL', 'Nepal',28.394857, 84.124008, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'NIC', 'Nicaragua',12.865416, -85.207229, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'NER', 'Níger',17.607789, 8.081666, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'NGA', 'Nigeria',9.081999, 8.675277,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'NOR', 'Noruega',60.472024, 8.468946, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'NZL', 'Nueva Zelanda',-40.900557, 174.885971, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'OMN', 'Omán',21.512583, 55.923255, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'NLD', 'Países Bajos',52.132633, 5.291266, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'PAK', 'Pakistán',30.375321, 69.345116, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'PSE', 'Palestina',31.952162, 35.233154, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'PAN', 'Panamá',8.537981, -80.782127,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'PNG',  'Papúa Nueva Guinea',-6.314993, 143.95555,1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null, 'PRY', 'Paraguay',-23.442503, -58.443832, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null, 'PER', 'Perú',-9.189967, -75.015152, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'POL', 'Polonia',51.919438, 19.145136,1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'PRT', 'Portugal',39.399872, -8.224454,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'QAT',  'Qatar',25.354826, 51.183884, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'GBR', 'Reino Unido',55.378051, -3.435973,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'RWA', 'Ruanda',-1.940278, 29.873888, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'ROU', 'Rumania',45.943161, 24.96676, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'RUS', 'Rusia',61.52401, 105.318756, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'SLB', 'Islas Salomón',-9.64571, 160.156194,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'WSM', 'Samoa',-13.759029, -172.104629,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'KNA', 'San Cristóbal y Nieves',17.357822, -62.782998,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'SMR', 'San Marino',43.94236, 12.457777, 1, 0,"127.0.0.1",0,NOW() );
INSERT INTO `country` VALUES (null,'VCT', 'San Vicente y las Granadinas',12.984305, -61.287228,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'SHN', 'Santa Elena',-24.143474, -10.030696,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'LCA', 'Santa Lucía',13.909444, -60.978893,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'STP', 'Santo Tomé y Príncipe',0.18636, 6.613081,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'SEN', 'Senegal',14.497401, -14.452362, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'SRB', 'Serbia',44.016521, 21.005859,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'SYC', 'Seychelles',-4.679574, 55.491977,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'SLE', 'Sierra Leona',8.460555, -11.779889,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'SGP', 'Singapur',1.352083, 103.819836,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'SYR', 'Siria',34.802075, 38.996815,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'SOM', 'Somalia',5.152149, 46.199616,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'LKA', 'Sri Lanka',7.873054, 80.771797,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'SWZ', 'Suazilandia',-26.522503, 31.465866,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'ZAF', 'Sudáfrica',-30.559482, 22.937506,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'SDN', 'Sudán',12.862807, 30.217636,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'SWE', 'Suecia',60.128161, 18.643501,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'CHE', 'Suiza', 46.818188, 8.227512,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'SUR', 'Surinam',3.919305, -56.027783, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null, 'THA', 'Tailandia',15.870032, 100.992541,1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'TWN', 'Taiwán',23.69781, 120.960515, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'TZA', 'Tanzania',-6.369028, 34.888822, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'TJK', 'Tayikistán',38.861034, 71.276093,1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'TLS', 'Timor Oriental',-8.874217, 125.727539,1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'TGO', 'Togo',8.619543, 0.824782,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'TTO', 'Trinidad y Tobago', 10.691803, -61.222503, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'TUN',  'Túnez', 33.886917, 9.537499,1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'TCA', 'Islas Turcas y Caicos',21.694025, -71.797928,1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null, 'TUR','Turkmenistán',38.969719, 59.556278,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'UKR', 'Ucrania',48.379433, 31.16558,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'UGA', 'Uganda',1.373333, 32.290275,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'URY', 'Uruguay',-32.522779, -55.765835, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'UZB', 'Uzbekistán',41.377491, 64.585262,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'VUT',  'Vanuatu',-15.376706, 166.959158, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'VEN',  'Venezuela',6.42375, -66.58973, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'VNM', 'Vietnam',14.058324, 108.277199, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'YEM', 'Yemen',15.552727, 48.516388,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'DJI', 'Yibuti',11.825138, 42.590275, 1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'ZMB', 'Zambia',-13.133897, 27.849332,  1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'ZWE', 'Zimbawe', -19.015438, 29.154857,1, 0,"127.0.0.1",0,NOW());

INSERT INTO `country` VALUES (null,'SSD', 'República de Sudán del Sur', 6.876991, 31.306978,1, 0,"127.0.0.1",0,NOW());
INSERT INTO `country` VALUES (null,'MNE', 'Montenegro', 42.708678, 19.37439,1, 0,"127.0.0.1",0,NOW());



/*Department inserts*/
insert into department values(null,25, "BO-H", "Chuquisaca", -19.03332, -65.26274, 1, 0, "127.0.0.1", 0, now());
insert into department values(null,25, "BO-L", "La Paz", -16.5, -68.15, 1, 0, "127.0.0.1", 0, now());
insert into department values(null,25, "BO-C", "Cochabamba", -17.3895, -66.1568, 1, 0, "127.0.0.1", 0, now());
insert into department values(null,25, "BO-S", "Santa Cruz", -17.78629, -63.18117, 1, 0, "127.0.0.1", 0, now());
insert into department values(null,25, "BO-O", "Oruro", -17.98333, -67.15, 1, 0, "127.0.0.1", 0, now());
insert into department values(null,25, "BO-P", "Potosí", -19.58361, -65.75306, 1, 0, "127.0.0.1", 0, now()); 
insert into department values(null,25, "BO-T", "Tarija", -21.53549, -64.72956, 1, 0, "127.0.0.1", 0, now());
insert into department values(null,25, "BO-N", "Pando", -11.02671, -68.76918, 1, 0, "127.0.0.1", 0, now());
insert into department values(null,25, "BO-B", "Beni", -14.83333, -64.9, 1, 0, "127.0.0.1", 0, now());
