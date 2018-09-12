package mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import com.mongodb.MongoClient;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

	@Override
	@Bean
	public MongoClient mongoClient() {
		return new MongoClient("localhost");
	}

	@Override
	protected String getDatabaseName() {
		return "weblibmang";
	}

}
