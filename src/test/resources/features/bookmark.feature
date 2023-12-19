# language: ru
# encoding: utf-8
@bookmark
Функция: Добавление и удаление фильма из закладок

	@success
	Сценарий: Добавление фильма в закладки
		Дано Пользователь находится на странице с фильмом
		Когда Пользователь добавляет фильм <title> в закладки
		Тогда Фильм <title> добавляется в закладках в профиле пользователя
		Примеры:
		|title|
		|"Coraline"|

	@success  
	Сценарий: Удаление фильма из закладок
		Дано пользователь находится на странице с фильмом
		Когда Пользователь удаляет фильм <title> из закладок
		Тогда Фильм <title> отсутствует в закладках в профиле пользователя
		Примеры:
		|title|
		|"Coraline"|