package academy.portal.service.db.dao;

import academy.portal.service.db.models.User;
import academy.portal.service.db.models.enums.Role;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface UserDao {

	@SqlQuery("select * from root.users where id = :id")
	User findById(@Bind("id") long id);

	@SqlQuery("select * from root.users where username = :username")
	User findByUsername(@Bind("username") String username);

	@SqlQuery("select * from root.users where role = :role::root.user_role")
	List<User> findByRole(@Bind("role") Role role);

	@SqlUpdate("delete from root.users where role = :role::root.user_role")
	void deleteByRole(@Bind("role") Role role);
}
