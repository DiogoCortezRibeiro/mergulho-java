CREATE TABLE ocorrencia(
    id bigint not null auto_increment,
    entrega_id bigint not null,
    descricao varchar(200) not null,
    data_registro datetime,
    primary key (id)
);

alter table ocorrencia add constraint fk_ocorrencia_entrega foreign key (entrega_id) references entrega (id);