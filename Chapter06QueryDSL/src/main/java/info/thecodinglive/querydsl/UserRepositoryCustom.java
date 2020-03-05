package info.thecodinglive.querydsl;

import java.util.List;

public interface UserRepositoryCustom {
	List findAllLike(String keyword);
}
