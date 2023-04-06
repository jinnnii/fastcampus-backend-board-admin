-- todo: 테스트용이지만 비밀번호 노출 관련 개선할 필요가 있다.

insert into user_account(user_id, user_pw, role_types, nickname, email, memo, created_at, created_id, modified_at, modified_id) values
    ('user1', '{noop}1234', 'ADMIN', '1', 'e1@mail.com', 'This is memo', now(), 'user1', now(), 'user1'),
    ('user2', '{noop}1234', 'MANAGER', '2', 'e2@mail.com', 'This is memo', now(), 'user1', now(), 'user1'),
    ('user3', '{noop}1234', 'MANAGER,DEVELOPER', '3', 'e3@mail.com', 'This is memo', now(), 'user1', now(), 'user1'),
    ('user4', '{noop}1234', 'USER', '4', 'e4@mail.com', 'This is memo', now(), 'user1', now(), 'user1')
;
