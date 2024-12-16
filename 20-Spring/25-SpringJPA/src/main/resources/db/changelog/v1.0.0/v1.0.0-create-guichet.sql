create table if not exists  guichet(
    id serial primary key,
    libelle varchar(50) not null,
    gare_id number  null,
    heure_ouverture time(7),
    heure_fermeture time(7),
    type varchar(20)
)