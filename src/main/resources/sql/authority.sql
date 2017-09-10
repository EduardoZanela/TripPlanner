create table authority(
	id integer primary key,
	name varchar(254)
);


create table user_profile_authority(
	user_id integer,
	authority_id integer,
	PRIMARY KEY (user_id, authority_id)
);