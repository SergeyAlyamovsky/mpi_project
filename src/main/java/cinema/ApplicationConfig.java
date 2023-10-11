package cinema;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cinema.data.JpaFilmRepository;
import cinema.data.JpaUserRepository;
import cinema.entity.Film;

@Configuration
public class ApplicationConfig {
	@Bean
	public CommandLineRunner dataLoader(JpaFilmRepository repoFilm, JpaUserRepository repoUser) {
		return args -> {
			repoUser.deleteAll();
			repoFilm.deleteAll();
			
			repoFilm.save(new Film(1, "Coraline", "Коралина в Стране Кошмаров", 2009, "Мультфильм, Фэнтези",
					"Генри Селик", 100, "6+", "", "/images/Coraline.jpg"));
			repoFilm.save(new Film(2, "Tucker and Dale vs Evil", "Убойные каникулы", 2010, "Черная комедия",
					"Илай Крейг", 89, "18+", "", "/images/TuckerAndDaleVsEvil.jpg"));
			repoFilm.save(new Film(3, "Our Russia: Balls of fate", "Наша Russia: Яйца судьбы", 2010, "Комедия",
					"Глеб Орлов", 85, "18+", "", "/images/OurRussiaBallsOfFate.jpg"));
			repoFilm.save(new Film(4, "The Purge: Anarchy", "Судная ночь 2", 2014, "Боевик, Триллер", 
					"Джеймс Демонако", 103, "18+", "", "/images/ThePurgeAnarchy.jpg"));
			repoFilm.save(new Film(5, "Alita: Battle angel", "Алита: Боевой ангел", 2019, "Боевик, Киберпанк",
					"Роберт Родригес", 122, "16+", "", "/images/AlitaBattleAngel.jpg"));
			repoFilm.save(new Film(6, "The best film", "Самый лучший фильм", 2008, "Комедия",
					"Кирилл Кузин", 105, "18+", "", "/images/TheBestFilm.jpg"));
			repoFilm.save(new Film(7, "Train to Busan", "Поезд в Пусан", 2016, "Боевик, Зомби",
					"Ён Сан Хо", 118, "18+", "", "/images/TrainToBusan.jpg"));
			repoFilm.save(new Film(8, "Noah", "Ной", 2014, "Фэнтези, Драма",
					"Даррен Аронофски", 138, "16+", "", "/images/Noah.jpg"));
			repoFilm.save(new Film(9, "Pulse", "Пульс", 2006, "Ужасы",
					"Джим Сонзеро", 90, "16+", "", "/images/Pulse.jpg"));
			repoFilm.save(new Film(10, "Sin City", "Город грехов", 2005, "Нуар, Триллер",
					"Роберт Родригес, Фрэнк Миллер", 124, "18+", "", "/images/SinCity.jpg"));
			repoFilm.save(new Film(11, "The Book of Eli", "Книга Илая", 2010, "Боевик, Постапокалипсис",
					"Братья Хьюз", 124, "16+", "", "/images/TheBookOfEli.jpg"));
			repoFilm.save(new Film(12, "Sucker Punch", "Запрещенный прием", 2011, "Боевик, Фэнтези",
					"Зак Снайдер", 110, "16+", "", "/images/SuckerPunch.jpg"));
			repoFilm.save(new Film(13, "Mad Max: Fury road", "Безумный Макс: Дорога ярости", 2015, "Боевик, Постапокалипсис",
					"Джордж Миллер", 120, "18+", "", "/images/MadMaxFuryRoad.jpg"));
			repoFilm.save(new Film(14, "The Belko Experiment", "Эксперимент «Офис»", 2016, "Триллер",
					"Грег Маклин", 89, "18+", "", "/images/TheBelkoExperiment.jpg"));
			repoFilm.save(new Film(15, "Face Off", "Без лица", 1997, "Боевик, Триллер",
					"Джон Ву", 139, "16+", "", "/images/FaceOff.jpg"));
			repoFilm.save(new Film(16, "Rush Hour", "Час пик", 1997, "Боевик, Комедия",
					"Бретт Ратнер", 98, "16+", "", "/images/RushHour.jpg"));
		};
	}

}

