# encoding: iso-8859-1
Feature: como usuario y cliente de Tottus
	quiero realizar la busqueda de recetas en su sitio web
	
Scenario: Como usuario realizo busqueda de Receta de Rollitos de Canela
 Given Ingreso al buscador Google
 And Realizo la busqueda de "Tottus Sucursales"
 And Ingreso al sitio web de la primera sucursal del resultado de busqueda
 When En sitio web Tottus presionar la opcion Recetas
 And Seleccionamos Dificultad Alta
 Then Buscamos la receta para Rollitos de Canela
 And Validamos que contenga "canela en polvo"
 And Validamos que contenga "azúcar rubia"
