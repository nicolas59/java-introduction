create table if not exists gare(
    id serial primary key,
    uic number not null,
    libelle varchar(100),
    support_fret boolean,
    support_voyageurs boolean,
    code_ligne varchar(100),
    commune varchar(200),
    departement varchar(100)
)