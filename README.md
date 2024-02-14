# ktor_exposed_database_migration_1

# This project is for Migrating the database in the Ktor project. I used the Flyway migration tool and Postgresql database.

Add these items to build.gradle.kts


plugins {

	..........
	// Flyway gradle plugin
    	id("org.flywaydb.flyway") version "10.7.2"
     
}


buildscript {

    dependencies {
        classpath("org.postgresql:postgresql:42.7.1")
        classpath("org.flywaydb:flyway-database-postgresql:10.7.2")
    }
}

// Deoendencies
dependencies {

	........
    	// Exposed orm dependencies
    	implementation("org.jetbrains.exposed:exposed-core:0.47.0")
    	implementation("org.jetbrains.exposed:exposed-jdbc:0.47.0")


    	// Postgresql dependencies
    	implementation("org.postgresql:postgresql:42.7.1")  
     	.........
}

// Add flyway configuration after adding the Flyway gradle plugin
flyway{

	driver="org.postgresql.Driver"

	// Database name is migration-sample
   	url = "jdbc:postgresql://localhost:5432/migration-sample"

	// Database username is postgres
    	user="postgres"
	// Database password
   	password="9526317685"

    	cleanDisabled=false
}



// Add these to the application.conf
postgres {

   	 driverClassName = "org.postgresql.Driver"

	// Database name is migration-sample
    	jdbcURL = "jdbc:postgresql://localhost:5432/migration-sample"

	// Database username is postgres
    	user = "postgres"
	// Database password
   	 password = "9526317685"
}


// Make a new folder on resources db.migration

// For initial migration

// Make a new  file like V1__initial_migration.sql. Here version name format is like V<version_name>__migration_name.dql. it is very important.

// Then add the following SQL statement to the above file V1__initial_migration.sql

{

	CREATE TABLE IF NOT EXISTS "user"
	(
   	 id     SERIAL PRIMARY KEY,
   	 "name" VARCHAR(128) NOT NULL
	);

}


// For second migration

// Make a new folder like V2__adding_mark_colum.sql

// Then add the following SQL statement
// To add a new column to the user table

{

	ALTER TABLE "user" ADD COLUMN mark FLOAT;

}
