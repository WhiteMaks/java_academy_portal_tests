package academy.portal.service.db.steps;

import academy.portal.service.db.AcademyPortalServiceDatabase;
import academy.portal.service.db.dao.UserDao;
import academy.portal.service.db.models.User;
import academy.portal.service.db.models.enums.Role;
import common.configs.Config;
import io.qameta.allure.Step;

public class AcademyPortalServiceDbSteps {
	private final AcademyPortalServiceDatabase db;

	public AcademyPortalServiceDbSteps() {
		db = new AcademyPortalServiceDatabase(Config.DATABASE.getAcademyPortalService());
	}

	@Step("Поиск пользователя по id [{id}] в бд")
	public User findUserById(long id) {
		return db.getJdbi().withExtension(UserDao.class, dao -> dao.findById(id));
	}

	@Step("Поиск пользователя по username [{username}] в бд")
	public User findUserByUsername(String username) {
		return db.getJdbi().withExtension(UserDao.class, dao -> dao.findByUsername(username));
	}

	@Step("удаление пользователей по role [{role}] в бд")
	public void deleteUserByRole(Role role) {
		db.getJdbi().useExtension(UserDao.class, dao -> dao.deleteByRole(role));
	}
}
