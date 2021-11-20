drop table tb_alimento cascade constraints;
drop table tb_doador cascade constraints;
drop table tb_doador_alimento cascade constraints;
drop table tb_recebedor cascade constraints;

drop sequence sq_tb_alimento;
drop sequence sq_tb_doador;
drop sequence sq_tb_doador_alimento;
drop sequence sq_tb_recebedor;



create sequence sq_tb_alimento start with 1 increment by  1;
create sequence sq_tb_doador start with 1 increment by  1;
create sequence sq_tb_doador_alimento start with 1 increment by  1;
create sequence sq_tb_recebedor start with 1 increment by  1;

create table tb_alimento (
    id_alimento number(19,0) not null, 
    nm_alimento varchar2(255 char), 
    primary key (id_alimento)
);
create table tb_doador (
    id_doador number(19,0) not null, 
    nr_cnpj varchar2(255 char), 
    nr_cpf varchar2(255 char), 
    ds_email varchar2(255 char), 
    nr_cep varchar2(255 char), 
    ds_complemento varchar2(255 char), 
    ds_logradouro varchar2(255 char), 
    nr_lar number(10,0), 
    nm_doador varchar2(255 char), 
    ds_ramo varchar2(255 char), 
    nm_responsavel varchar2(255 char), 
    nr_telefone varchar2(255 char), 
    primary key (id_doador)
);
create table tb_doador_alimento (
    id_doador_alimento number(19,0) not null, 
    qt_alimento number(10,0) not null, 
    id_alimento number(19,0) not null, 
    id_doador number(19,0) not null, 
    id_recebedor number(19,0), 
    primary key (id_doador_alimento)
);
create table tb_recebedor (
    id_recebedor number(19,0) not null, 
    nr_cnpj varchar2(255 char), 
    ds_email varchar2(255 char), 
    nr_cep varchar2(255 char), 
    ds_complemento varchar2(255 char), 
    ds_logradouro varchar2(255 char), 
    nr_lar number(10,0), 
    ds_ramo varchar2(255 char), 
    ds_razao_social varchar2(255 char), 
    nm_responsavel varchar2(255 char), 
    nr_telefone varchar2(255 char), 
    primary key (id_recebedor)
);

alter table tb_doador_alimento add constraint FKq0kk0rdnget33bpc3qrbwj1jq foreign key (id_alimento) references tb_alimento;
alter table tb_doador_alimento add constraint FKocldy8s1gu63aqq5kg9d8imo2 foreign key (id_doador) references tb_doador;
alter table tb_doador_alimento add constraint FK5t0bndiynga1n078rfsmemiwt foreign key (id_recebedor) references tb_recebedor;