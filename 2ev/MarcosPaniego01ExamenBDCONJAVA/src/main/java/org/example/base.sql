CREATE TABLE CATEGORIAS (
	id_categoria SERIAL PRIMARY KEY,
	nombre_categoria VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE cursos(
	id_curso SERIAL PRIMARY KEY,
	nombre_curso VARCHAR(255) NOT NULL,
	descripcion TEXT,
	id_categoria INT NOT NULL,
	FOREIGN KEY (id_categoria) REFERENCES CATEGORIAS(id_categoria)
);


INSERT INTO CATEGORIAS (nombre_categoria) VALUES
('Progamacion'),
('Ciberseguridad'),
('Redes'),
('Base de datos');


INSERT INTO cursos(nombre_curso, descripcion, id_categoria) VALUES
('Introduccion a python', 'Curso basico en python para principiantes', 1),
('Introduccion a Access', 'Curso basico de access para principiantes', 4),
('Introduccion a Kali Linux', 'Curso basico de hacking etico para principiantes', 2),
('Introduccion a Cisco', 'Curso basico de cisco para principiantes', 3),
('Access XP', 'Curso avanzado de access para principiantes', 4)

SELECT * FROM cursos ORDER BY id_curso ASC;