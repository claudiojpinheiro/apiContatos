CREATE TABLE contato (
    id          		SERIAL 						PRIMARY KEY,
    nome        	VARCHAR(50)				 NOT NULL,
    email      		 VARCHAR(50)				 NOT NULL,
    telefone  		  VARCHAR(30) 			NOT NULL
);
