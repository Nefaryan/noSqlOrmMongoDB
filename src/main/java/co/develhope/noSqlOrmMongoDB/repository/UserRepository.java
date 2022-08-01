package co.develhope.noSqlOrmMongoDB.repository;

import co.develhope.noSqlOrmMongoDB.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
