DROP USER IF EXISTS 'jobportal'@'%';

-- now create user with prop privilages --
CREATE USER 'jobportal'@'%' IDENTIFIED BY 'jobportal';

grant all privileges on * . * to 'jobportal'@'%'; 