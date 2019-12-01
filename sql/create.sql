drop table if exists plataforma cascade;
drop table if exists categoria cascade;
drop table if exists plataformacategoria cascade;
drop table if exists articulo cascade;
drop table if exists producto cascade;
drop table if exists articuloproducto cascade;
drop table if exists comprobante cascade;
drop table if exists rol cascade;
drop table if exists usuario cascade;
drop table if exists venta cascade;
drop table if exists ventaproducto cascade;

create table plataforma (
	id bigserial primary key,
	nombre text not null,
	descripcion text not null,
	estado boolean not null,
	fechaactualizacion timestamp not null,
	fechacreacion timestamp not null
);

create table categoria (
	id bigserial primary key,
	nombre text not null,
	descripcion text not null,
	estado boolean not null,
	fechaactualizacion timestamp not null,
	fechacreacion timestamp not null
);

create table plataformacategoria(
	id bigserial primary key,
	idplataforma bigint not null,
	idcategoria bigint not null,
	estado boolean not null,
	fechaactualizacion timestamp not null,
	fechacreacion timestamp not null,
	foreign key (idplataforma) references plataforma (id),
	foreign key (idcategoria) references categoria (id)
);

create table articulo(
	id bigserial primary key,
	idcategoria bigint not null,
	codigo text not null,
	nombre text not null,
	precio bigint not null,
	stock bigint not null,
	descripcion text not null,
	imagen text not null,
	estado boolean not null,
	fechaactualizacion timestamp not null,
	fechacreacion timestamp not null,
	foreign key (idcategoria) references categoria(id)
);

create table producto(
	id bigserial primary key,
	codigo text not null,
	nombre text not null,
	descripcion text not null,
	precio bigint not null,
	estado boolean not null,
	fechaactualizacion timestamp not null,
	fechacreacion timestamp not null
);

create table articuloproducto(
    id bigserial primary key,
    idarticulo bigint not null,
    idproducto bigint not null,
    estado boolean not null,
    fechaactualizacion timestamp not null,
    fechacreacion timestamp not null,
    foreign key (idarticulo) references articulo(id),
    foreign key (idproducto) references producto(id)
);

create table comprobante(
    id bigserial primary key,
    tipo text not null,
    serie text not null,
    numero bigint not null,
    estado boolean not null,
    fechaactualizacion timestamp not null,
    fechacreacion timestamp  not null
);

create table rol(
    id bigserial primary key,
    nombre text not null,
    descripcion text not null,
    estado boolean not null,
    fechaactualizacion timestamp not null,
    fechacreacion timestamp not null
);

create table usuario(
    id bigserial primary key,
    idrol bigint not null,
    tipodocumento text not null,
    numerodocumento text not null,
    nombre text not null,
    apellido text not null,
    direccion text not null,
    telefono text not null,
    email text not null,
    clave text not null,
    estado boolean not null,
    fechacreacion timestamp not null,
    fechaactualizacion timestamp not null,
    foreign key (idrol) references rol(id)
);

create table venta(
    id bigserial primary key,
    idusuario bigint not null,
    idcomprobante bigint not null,
    impuesto bigint not null,
    total bigint not null,
    estado boolean not null,
    fechaactualizacion timestamp not null,
    fechacreacion timestamp not null,
    foreign key (idusuario) references usuario(id),
    foreign key (idcomprobante) references comprobante(id)
);

create table ventaproducto(
    id bigserial primary key,
    idproducto bigint not null,
    idventa bigint not null,
    cantidad bigint not null,
    precio bigint not null,
    descuento bigint not null,
    estado boolean not null,
    fechaactualizacion timestamp not null,
    fechacreacion timestamp not null,
    foreign key (idproducto) references producto(id),
    foreign key (idventa) references venta(id)
);