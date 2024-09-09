create table if not exists cryptodb.report_history
(
    report_history_id int auto_increment
    primary key,
    market            varchar(45) not null,
    price             varchar(45) not null,
    reported_at       datetime    not null
);