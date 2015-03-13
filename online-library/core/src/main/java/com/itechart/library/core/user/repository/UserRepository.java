package com.itechart.library.core.user.repository;

import com.itechart.library.core.entity.repository.EntityRepository;
import com.itechart.library.core.user.QUser;
import com.itechart.library.core.user.User;
import com.itechart.library.core.user.UserFilter;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.path.StringPath;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends EntityRepository<User>,UserRepositoryCustom {
    User findFirstByLogin(String login);

    public static class Predicates {
        public static BooleanBuilder byFilter(UserFilter filter) {
            QUser user = QUser.user;
            BooleanBuilder builder = new BooleanBuilder();

            addIfNotEmpty(builder, user.login, filter.getLogin());
            addIfNotEmpty(builder, user.lastName, filter.getLastName());
            addIfNotEmpty(builder, user.firstName, filter.getFirstName());

            return builder;
        }

        private static void addIfNotEmpty(BooleanBuilder builder, StringPath path, String value) {
            if (!StringUtils.isBlank(value)) {
                builder.and(value.contains("*") ? path.like(value.replaceAll("\\*", "%")) : path.equalsIgnoreCase(value));
            }
        }
    }

}
