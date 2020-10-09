-- Empresas

INSERT INTO `cucoex`.`company`
(
`days_to_climb_alerts_to_administrator`,
`days_to_climb_alerts_to_supervisor`,
`days_to_default`,
`alert_message`,
`are_alerts_enabled`,
`are_alerts_enabled_to_administrators`,
`are_alerts_enabled_to_supervisors`,
`are_alerts_enabled_to_users`,
`company_address`,
`company_email`,
`company_id`,
`company_name`,
`company_phone`,
`company_web`,
`frequency_to_run_monitor`,
`is_enabled`
)
VALUES
(
10,
5,
20,
"Este es un mensaje de alerta",
1,
1,
1,
1,
"Calle 2A num 1050",
"jealdana@gmail.com",
"AASJ6404027A6",
"DiMeMex, S.A.",
"8114703908",
"www.dimemex.site",
1,
1);

INSERT INTO `cucoex`.`company`
(
`days_to_climb_alerts_to_administrator`,
`days_to_climb_alerts_to_supervisor`,
`days_to_default`,
`alert_message`,
`are_alerts_enabled`,
`are_alerts_enabled_to_administrators`,
`are_alerts_enabled_to_supervisors`,
`are_alerts_enabled_to_users`,
`company_address`,
`company_email`,
`company_id`,
`company_name`,
`company_phone`,
`company_web`,
`frequency_to_run_monitor`,
`is_enabled`
)
VALUES
(
3,
2,
5,
"Este es un mensaje de alerta",
1,
1,
1,
1,
"Calle San angel",
"enriquealdana@icloud.com",
"ICO920810FAT",
"Ingenieria en Computo",
"8261104382",
"www.ingecompu.mx",
1,
1);




-- Usuarios
INSERT INTO `user` (`email`, `first_name`, `last_name`, `password`, `username`) VALUES ('super.admin@admin.com', 'Super admin', 'Super admin', '1234', 'Superadmin');
INSERT INTO `user` (`email`, `first_name`, `last_name`, `password`, `username`) VALUES ('admin@admin.com', 'admin', 'admin', '1234', 'admin');

-- Roles
INSERT INTO `role` (`description`, `name`) VALUES ('ROLE_SUPERADMIN', 'SUPERADMIN');
INSERT INTO `role` (`description`, `name`) VALUES ('ROLE_ADMIN', 'ADMIN');
INSERT INTO `role` (`description`, `name`) VALUES ('ROLE_USER', 'USER');
INSERT INTO `role` (`description`, `name`) VALUES ('ROLE_SUPERVISOR', 'SUPERVISOR');

-- Usuario y Rol
INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES ('2', '2');


-- Usuarios Y Empresa

INSERT INTO `cucoex`.`users_companies`
(`user_id`,
`company_id`)
VALUES
('1',
'1');

INSERT INTO `cucoex`.`users_companies`
(`user_id`,
`company_id`)
VALUES
('1',
'2');



INSERT INTO `cucoex`.`users_companies`
(`user_id`,
`company_id`)
VALUES
('2',
'2');


		-- Imp Exp Type
		
		INSERT INTO `cucoex`.`imp_exp_type`
		(`imp_exp_type_description`,
		`imp_exp_type_name`)
		VALUES
		(
		'Importacion General',
		'GENERAL');
		
		INSERT INTO `cucoex`.`imp_exp_type`
		(`imp_exp_type_description`,
		`imp_exp_type_name`)
		VALUES
		(
		'Autos Usados',
		'AUTOSUSADOS');

		-- Relacion EMpresa y Tipo de Imprt	
		
		INSERT INTO `cucoex`.`companies_impexptypes`
		(`company_id`,
		`impexptype_id`)
		VALUES
		('1',
		'1');
		
		INSERT INTO `cucoex`.`companies_impexptypes`
		(`company_id`,
		`impexptype_id`)
		VALUES
		('1',
		'2');
	
		INSERT INTO `cucoex`.`companies_impexptypes`
			(`company_id`,
			`impexptype_id`)
			VALUES
			('2',
			'2');


-- Estatus
INSERT INTO `status` (`status_key`, `status_name`,`status_description`) VALUES ('CUMP', 'CUMPLIDO','Cumplido');
INSERT INTO `status` (`status_key`, `status_name`,`status_description`) VALUES ('XINCUM', 'XINCUMPLIR','X Cumplir');
INSERT INTO `status` (`status_key`, `status_name`,`status_description`) VALUES ('INCUM', 'INCUMPLIDO','Incumplido');

-- Causales
INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('1','Verificar que la e.firma se encuentre vigente.','No cuenten con la e.firma vigente.','G','I','SC','1');
  

INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('2','Verificar que se encuentre registrado en el SAT el correo para efectos del buzón tributario.','No tengan registrado el correo electrónico para efectos del Buzón Tributario.','G','III','SC','2');

INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('1','Verificar las obligaciones y que éstas estén cumplidas.','No hubieren presentado las declaraciones de los impuestos federales o cumplido con alguna otra obligación fiscal.','G','II','SC','3');



-- Relacion ImpExpType y Causales

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'1');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'2');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'3');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'1');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'2');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'3');
 
 -- Insrucciones e.firma
  INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('A','Ingresar en la siguiente liga: https://www.sat.gob.mx/tramites/operación/19941/valida-la-vigencia-de-tu-e.firma-(antes-firma-electronica) ');
  INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('B','Capturar los datos del formulario: contraseña de clave privada; archivo .key; archivo .cer; texto de imagen captcha; dar click en Enviar.');
  INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('C','En la parte de abajo del formulario aparecerá el estado del certificado: Activo o Inactivo, y vigente desde (fecha), hasta (fecha) ');
  INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('D','En la casilla "Estado del certificado", dar click en Activo o Inactivo. ');
  INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('E','En la casilla "Vigente hasta" capturar la fecha de final de vigencia. ');
  
 -- Instrucciones No tenga registrado el email
  INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('A','Ingresar en la siguiente liga: https://www.sat.gob.mx ');
   INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('B','En el menú superior a la derecha, dar click en el botón "Buzón Tributario". ');
   INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('C','Ingresar con E.firma o Contraseña.  ');
   INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('D','En el menú superior central, dar click en Configuración.  ');
   INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('E','Capturar el correo, confirmar y dar click en continuar.  ');
   INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('F','Una vez que la página confirme que se actualizó el medio de contacto, cerrar cesión.  ');
   INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('G','En la casilla "Correo-Buzón Tributario", capturar el correo. ');
  
-- Instrucciones No hubieren presentado las declaraciones
 INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('A','Ingresar en la siguiente liga: https://www.sat.gob.mx/aplicacion/login/43824/reimprime-tus-acuses-del-rfc.  ');
 INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('B','Hacer copia y pega de las obligaciones y fechas de cumplimiento. ');  
 INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('C','Subir la declaración correspondiente. ');
 

  
  -- Causal e Instrucciones
  
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('1', '1');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('1', '2');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('1', '3');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('1', '4');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('1', '5');
  
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('2', '6');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('2', '7');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('2', '8');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('2', '9');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('2', '10');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('2', '11');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('2', '12');
  
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('3', '13');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('3', '14');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('3', '15');
  
  