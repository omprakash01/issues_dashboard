CREATE TABLE GITHUB_PROJECT(
	id identity not null primary key,
	org_name varchar(50) not null,
	repo_name varchar(50) not null unique
);

CREATE INDEX idx_repo_name
 on GITHUB_PROJECT (repo_name);
