USE [master]
GO
/****** Object:  Database [RED_SOCIAL_FR]    Script Date: 07/11/2020 20:16:15 ******/
CREATE DATABASE [RED_SOCIAL_FR]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'RED_SOCIAL_FR', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\RED_SOCIAL_FR.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'RED_SOCIAL_FR_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\RED_SOCIAL_FR_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [RED_SOCIAL_FR] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [RED_SOCIAL_FR].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [RED_SOCIAL_FR] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET ARITHABORT OFF 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET  DISABLE_BROKER 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET  MULTI_USER 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [RED_SOCIAL_FR] SET DB_CHAINING OFF 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [RED_SOCIAL_FR] SET QUERY_STORE = OFF
GO
USE [RED_SOCIAL_FR]
GO
/****** Object:  Table [dbo].[ARTICULOS]    Script Date: 07/11/2020 20:16:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ARTICULOS](
	[codigo_articulo] [int] IDENTITY(1,1) NOT NULL,
	[nombre_articulo] [varchar](50) NOT NULL,
	[precio_articulo] [real] NOT NULL,
	[stock_articulo] [int] NOT NULL,
 CONSTRAINT [PK_ARTICULOS] PRIMARY KEY CLUSTERED 
(
	[codigo_articulo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[COMENTARIOS_COMERCIOS]    Script Date: 07/11/2020 20:16:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[COMENTARIOS_COMERCIOS](
	[id_comentario] [int] IDENTITY(1,1) NOT NULL,
	[id_comercio] [int] NOT NULL,
	[vecino_comentario] [varchar](10) NOT NULL,
	[descripcion_comentario] [varchar](100) NOT NULL,
	[valoracion_comercio_comentario] [int] NOT NULL,
	[respuesta_comercio_comentario] [varchar](100) NULL,
 CONSTRAINT [PK_COMENTARIOS_COMERCIOS] PRIMARY KEY CLUSTERED 
(
	[id_comentario] ASC,
	[id_comercio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[COMERCIOS]    Script Date: 07/11/2020 20:16:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[COMERCIOS](
	[id_comercio] [int] IDENTITY(1,1) NOT NULL,
	[nombre_comercio] [varchar](50) NOT NULL,
	[telefono_comercio] [varchar](50) NOT NULL,
	[direccion_comercio] [varchar](50) NOT NULL,
	[email_comercio] [varchar](50) NOT NULL,
	[id_rubro] [int] NOT NULL,
	[vigente_comercio] [bit] NOT NULL,
 CONSTRAINT [PK_COMERCIOS] PRIMARY KEY CLUSTERED 
(
	[id_comercio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CONSULTAS_OFERTAS]    Script Date: 07/11/2020 20:16:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CONSULTAS_OFERTAS](
	[id_oferta] [int] NOT NULL,
	[id_consulta_oferta] [int] IDENTITY(1,1) NOT NULL,
	[vecino_comentario] [varchar](100) NULL,
	[descripcion_consulta_oferta] [varchar](100) NOT NULL,
	[aprobada_consulta_oferta] [bit] NOT NULL,
	[respuesta_consulta_vecino] [varchar](100) NULL,
 CONSTRAINT [PK_CONSULTAS_OFERTAS_1] PRIMARY KEY CLUSTERED 
(
	[id_consulta_oferta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OFERTAS]    Script Date: 07/11/2020 20:16:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OFERTAS](
	[id_oferta] [int] IDENTITY(1,1) NOT NULL,
	[id_comercio] [int] NOT NULL,
	[codigo_articulo] [int] NOT NULL,
	[fecha_inicio_oferta] [varchar](10) NOT NULL,
	[fecha_finalizacion_oferta] [varchar](10) NOT NULL,
	[descripcion_oferta] [varchar](50) NOT NULL,
	[precio_oferta] [real] NOT NULL,
	[vigente_oferta] [bit] NOT NULL,
 CONSTRAINT [PK_OFERTAS_1] PRIMARY KEY CLUSTERED 
(
	[id_oferta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RUBROS]    Script Date: 07/11/2020 20:16:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RUBROS](
	[id_rubro] [int] IDENTITY(1,1) NOT NULL,
	[descripcion_rubro] [varchar](50) NOT NULL,
	[vigente_rubro] [bit] NOT NULL,
 CONSTRAINT [PK_RUBROS] PRIMARY KEY CLUSTERED 
(
	[id_rubro] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ARTICULOS] ON 

INSERT [dbo].[ARTICULOS] ([codigo_articulo], [nombre_articulo], [precio_articulo], [stock_articulo]) VALUES (1, N'Pelota de futbol', 200, 50)
INSERT [dbo].[ARTICULOS] ([codigo_articulo], [nombre_articulo], [precio_articulo], [stock_articulo]) VALUES (2, N'Raqueta de tenis', 500, 25)
INSERT [dbo].[ARTICULOS] ([codigo_articulo], [nombre_articulo], [precio_articulo], [stock_articulo]) VALUES (3, N'Raqueta de paddle', 450, 15)
INSERT [dbo].[ARTICULOS] ([codigo_articulo], [nombre_articulo], [precio_articulo], [stock_articulo]) VALUES (4, N'Botines adidas', 1500, 12)
INSERT [dbo].[ARTICULOS] ([codigo_articulo], [nombre_articulo], [precio_articulo], [stock_articulo]) VALUES (5, N'Aceite de girasol', 50, 10)
INSERT [dbo].[ARTICULOS] ([codigo_articulo], [nombre_articulo], [precio_articulo], [stock_articulo]) VALUES (6, N'Arroz fino', 65, 22)
INSERT [dbo].[ARTICULOS] ([codigo_articulo], [nombre_articulo], [precio_articulo], [stock_articulo]) VALUES (7, N'Yerba 1kg', 125, 11)
INSERT [dbo].[ARTICULOS] ([codigo_articulo], [nombre_articulo], [precio_articulo], [stock_articulo]) VALUES (8, N'Azucar 1kg', 100, 22)
INSERT [dbo].[ARTICULOS] ([codigo_articulo], [nombre_articulo], [precio_articulo], [stock_articulo]) VALUES (9, N'Corte de Pelo', 400, 15)
INSERT [dbo].[ARTICULOS] ([codigo_articulo], [nombre_articulo], [precio_articulo], [stock_articulo]) VALUES (10, N'Uñas', 200, 22)
INSERT [dbo].[ARTICULOS] ([codigo_articulo], [nombre_articulo], [precio_articulo], [stock_articulo]) VALUES (11, N'Lavado de cabello', 50, 11)
INSERT [dbo].[ARTICULOS] ([codigo_articulo], [nombre_articulo], [precio_articulo], [stock_articulo]) VALUES (12, N'Tintura de cabello', 1200, 22)
INSERT [dbo].[ARTICULOS] ([codigo_articulo], [nombre_articulo], [precio_articulo], [stock_articulo]) VALUES (13, N'Lapicera Bic', 15, 99)
INSERT [dbo].[ARTICULOS] ([codigo_articulo], [nombre_articulo], [precio_articulo], [stock_articulo]) VALUES (14, N'Regla 30CM', 35, 150)
INSERT [dbo].[ARTICULOS] ([codigo_articulo], [nombre_articulo], [precio_articulo], [stock_articulo]) VALUES (15, N'Goma', 15, 200)
INSERT [dbo].[ARTICULOS] ([codigo_articulo], [nombre_articulo], [precio_articulo], [stock_articulo]) VALUES (16, N'Cuaderno 48hojas rayas', 49, 250)
INSERT [dbo].[ARTICULOS] ([codigo_articulo], [nombre_articulo], [precio_articulo], [stock_articulo]) VALUES (17, N'Autito de carreras', 990, 2)
SET IDENTITY_INSERT [dbo].[ARTICULOS] OFF
GO
SET IDENTITY_INSERT [dbo].[COMENTARIOS_COMERCIOS] ON 

INSERT [dbo].[COMENTARIOS_COMERCIOS] ([id_comentario], [id_comercio], [vecino_comentario], [descripcion_comentario], [valoracion_comercio_comentario], [respuesta_comercio_comentario]) VALUES (2, 1, N'Pepe', N'Muy buen comercio', 5, N'Gracias por tu comentario')
INSERT [dbo].[COMENTARIOS_COMERCIOS] ([id_comentario], [id_comercio], [vecino_comentario], [descripcion_comentario], [valoracion_comercio_comentario], [respuesta_comercio_comentario]) VALUES (3, 2, N'Jose', N'Regular', 2, NULL)
INSERT [dbo].[COMENTARIOS_COMERCIOS] ([id_comentario], [id_comercio], [vecino_comentario], [descripcion_comentario], [valoracion_comercio_comentario], [respuesta_comercio_comentario]) VALUES (4, 3, N'Tito', N'Buena atencion', 5, NULL)
INSERT [dbo].[COMENTARIOS_COMERCIOS] ([id_comentario], [id_comercio], [vecino_comentario], [descripcion_comentario], [valoracion_comercio_comentario], [respuesta_comercio_comentario]) VALUES (5, 4, N'Rocio', N'Gracias por su atencion', 4, NULL)
INSERT [dbo].[COMENTARIOS_COMERCIOS] ([id_comentario], [id_comercio], [vecino_comentario], [descripcion_comentario], [valoracion_comercio_comentario], [respuesta_comercio_comentario]) VALUES (6, 5, N'Maria', N'Un groso Adrian', 5, NULL)
INSERT [dbo].[COMENTARIOS_COMERCIOS] ([id_comentario], [id_comercio], [vecino_comentario], [descripcion_comentario], [valoracion_comercio_comentario], [respuesta_comercio_comentario]) VALUES (7, 6, N'Mario', N'Se encontraba un poco sucio el local', 2, NULL)
INSERT [dbo].[COMENTARIOS_COMERCIOS] ([id_comentario], [id_comercio], [vecino_comentario], [descripcion_comentario], [valoracion_comercio_comentario], [respuesta_comercio_comentario]) VALUES (8, 7, N'Ruben', N'Buenas Ofertas!', 4, NULL)
INSERT [dbo].[COMENTARIOS_COMERCIOS] ([id_comentario], [id_comercio], [vecino_comentario], [descripcion_comentario], [valoracion_comercio_comentario], [respuesta_comercio_comentario]) VALUES (9, 8, N'Adrian', N'Gracias totales por su ayuda!', 4, NULL)
INSERT [dbo].[COMENTARIOS_COMERCIOS] ([id_comentario], [id_comercio], [vecino_comentario], [descripcion_comentario], [valoracion_comercio_comentario], [respuesta_comercio_comentario]) VALUES (10, 9, N'Marta', N'Quizas podrian mejorar en la atencion', 1, NULL)
INSERT [dbo].[COMENTARIOS_COMERCIOS] ([id_comentario], [id_comercio], [vecino_comentario], [descripcion_comentario], [valoracion_comercio_comentario], [respuesta_comercio_comentario]) VALUES (11, 1, N'Anibal', N'Estoy a la espera de mi consulta, demoran en responder', 2, NULL)
SET IDENTITY_INSERT [dbo].[COMENTARIOS_COMERCIOS] OFF
GO
SET IDENTITY_INSERT [dbo].[COMERCIOS] ON 

INSERT [dbo].[COMERCIOS] ([id_comercio], [nombre_comercio], [telefono_comercio], [direccion_comercio], [email_comercio], [id_rubro], [vigente_comercio]) VALUES (1, N'Rosetti Sports', N'3512052899', N'Lavalle 422', N'rosetti@gmail.com', 1, 1)
INSERT [dbo].[COMERCIOS] ([id_comercio], [nombre_comercio], [telefono_comercio], [direccion_comercio], [email_comercio], [id_rubro], [vigente_comercio]) VALUES (2, N'Armando Sports', N'3512202456', N'Pedernera 123', N'Armando@gmail.com', 1, 1)
INSERT [dbo].[COMERCIOS] ([id_comercio], [nombre_comercio], [telefono_comercio], [direccion_comercio], [email_comercio], [id_rubro], [vigente_comercio]) VALUES (3, N'Nueva Imagen', N'3512255443', N'Caseros 200', N'NuevaImagen@gmail.com', 4, 1)
INSERT [dbo].[COMERCIOS] ([id_comercio], [nombre_comercio], [telefono_comercio], [direccion_comercio], [email_comercio], [id_rubro], [vigente_comercio]) VALUES (4, N'Corte rustico', N'3519755511', N'Belgrano 210', N'Corterustico@gmail.com', 4, 1)
INSERT [dbo].[COMERCIOS] ([id_comercio], [nombre_comercio], [telefono_comercio], [direccion_comercio], [email_comercio], [id_rubro], [vigente_comercio]) VALUES (5, N'Carmen y Adrian', N'3514216032', N'Europa 1223', N'CarmenyAdrian@gmail.com', 2, 1)
INSERT [dbo].[COMERCIOS] ([id_comercio], [nombre_comercio], [telefono_comercio], [direccion_comercio], [email_comercio], [id_rubro], [vigente_comercio]) VALUES (6, N'Sol de mayo', N'3512299445', N'Velez 22', N'Soldemayo@hotmail.com', 2, 1)
INSERT [dbo].[COMERCIOS] ([id_comercio], [nombre_comercio], [telefono_comercio], [direccion_comercio], [email_comercio], [id_rubro], [vigente_comercio]) VALUES (7, N'Jugueteria El mono', N'3514224994', N'Jujuy 584', N'ugueteriaElmono@hotmail.com', 5, 1)
INSERT [dbo].[COMERCIOS] ([id_comercio], [nombre_comercio], [telefono_comercio], [direccion_comercio], [email_comercio], [id_rubro], [vigente_comercio]) VALUES (8, N'El estudiante', N'3514210000', N'Avellaneda 22', N'elestudiante@hotmail.com', 3, 1)
INSERT [dbo].[COMERCIOS] ([id_comercio], [nombre_comercio], [telefono_comercio], [direccion_comercio], [email_comercio], [id_rubro], [vigente_comercio]) VALUES (9, N'Librematica', N'3514324291', N'Ituzaingo 19', N'librematica@hotmail.com', 3, 1)
INSERT [dbo].[COMERCIOS] ([id_comercio], [nombre_comercio], [telefono_comercio], [direccion_comercio], [email_comercio], [id_rubro], [vigente_comercio]) VALUES (10, N'Todo x 100 pesos', N'3514314321', N'Av. Maipu 100', N'todopor10@tienda.com', 6, 0)
INSERT [dbo].[COMERCIOS] ([id_comercio], [nombre_comercio], [telefono_comercio], [direccion_comercio], [email_comercio], [id_rubro], [vigente_comercio]) VALUES (11, N'Jose y sus 6 hermanos', N'3514894111', N'Urquiza 126', N'jose6hnos@gmail.com', 7, 1)
SET IDENTITY_INSERT [dbo].[COMERCIOS] OFF
GO
SET IDENTITY_INSERT [dbo].[CONSULTAS_OFERTAS] ON 

INSERT [dbo].[CONSULTAS_OFERTAS] ([id_oferta], [id_consulta_oferta], [vecino_comentario], [descripcion_consulta_oferta], [aprobada_consulta_oferta], [respuesta_consulta_vecino]) VALUES (1, 1, N'Pepe', N'Hasta cuando esta vigente?', 1, N'Aun esta en oferta')
INSERT [dbo].[CONSULTAS_OFERTAS] ([id_oferta], [id_consulta_oferta], [vecino_comentario], [descripcion_consulta_oferta], [aprobada_consulta_oferta], [respuesta_consulta_vecino]) VALUES (2, 2, N'Tito', N'Las pelotas son negras?', 1, N'Si                                  ')
INSERT [dbo].[CONSULTAS_OFERTAS] ([id_oferta], [id_consulta_oferta], [vecino_comentario], [descripcion_consulta_oferta], [aprobada_consulta_oferta], [respuesta_consulta_vecino]) VALUES (4, 3, N'Mario', N'Solo el lavado es gratis?', 1, N'Si, por el momento solo lavado.')
INSERT [dbo].[CONSULTAS_OFERTAS] ([id_oferta], [id_consulta_oferta], [vecino_comentario], [descripcion_consulta_oferta], [aprobada_consulta_oferta], [respuesta_consulta_vecino]) VALUES (5, 4, N'Maria', N'Queda muy oscuro?', 0, NULL)
INSERT [dbo].[CONSULTAS_OFERTAS] ([id_oferta], [id_consulta_oferta], [vecino_comentario], [descripcion_consulta_oferta], [aprobada_consulta_oferta], [respuesta_consulta_vecino]) VALUES (6, 5, N'Alan', N'Si llevo 3 ofertas hay algun otro descuento?', 1, NULL)
INSERT [dbo].[CONSULTAS_OFERTAS] ([id_oferta], [id_consulta_oferta], [vecino_comentario], [descripcion_consulta_oferta], [aprobada_consulta_oferta], [respuesta_consulta_vecino]) VALUES (7, 6, N'Martin', N'Es arroz sin TACC?', 1, NULL)
INSERT [dbo].[CONSULTAS_OFERTAS] ([id_oferta], [id_consulta_oferta], [vecino_comentario], [descripcion_consulta_oferta], [aprobada_consulta_oferta], [respuesta_consulta_vecino]) VALUES (8, 7, N'Abril', N'Tienen stock?', 1, NULL)
INSERT [dbo].[CONSULTAS_OFERTAS] ([id_oferta], [id_consulta_oferta], [vecino_comentario], [descripcion_consulta_oferta], [aprobada_consulta_oferta], [respuesta_consulta_vecino]) VALUES (9, 9, N'Lucas', N'Borra tinta?', 1, NULL)
INSERT [dbo].[CONSULTAS_OFERTAS] ([id_oferta], [id_consulta_oferta], [vecino_comentario], [descripcion_consulta_oferta], [aprobada_consulta_oferta], [respuesta_consulta_vecino]) VALUES (10, 10, N'Susana', N'Hasta que edad es al autito?', 1, NULL)
INSERT [dbo].[CONSULTAS_OFERTAS] ([id_oferta], [id_consulta_oferta], [vecino_comentario], [descripcion_consulta_oferta], [aprobada_consulta_oferta], [respuesta_consulta_vecino]) VALUES (1, 11, N'Anibal', N'Cuanto tiempo de garantia tienen?', 1, N'Tienen 90 dias!')
SET IDENTITY_INSERT [dbo].[CONSULTAS_OFERTAS] OFF
GO
SET IDENTITY_INSERT [dbo].[OFERTAS] ON 

INSERT [dbo].[OFERTAS] ([id_oferta], [id_comercio], [codigo_articulo], [fecha_inicio_oferta], [fecha_finalizacion_oferta], [descripcion_oferta], [precio_oferta], [vigente_oferta]) VALUES (1, 1, 1, N'01/11/2020', N'01/12/2020', N'2x1 en pelotas Nike', 100, 1)
INSERT [dbo].[OFERTAS] ([id_oferta], [id_comercio], [codigo_articulo], [fecha_inicio_oferta], [fecha_finalizacion_oferta], [descripcion_oferta], [precio_oferta], [vigente_oferta]) VALUES (2, 2, 1, N'01/11/2020', N'01/12/2020', N'3x1 en pelotas Adidas', 125, 1)
INSERT [dbo].[OFERTAS] ([id_oferta], [id_comercio], [codigo_articulo], [fecha_inicio_oferta], [fecha_finalizacion_oferta], [descripcion_oferta], [precio_oferta], [vigente_oferta]) VALUES (4, 3, 11, N'02/11/2020', N'30/11/2020', N'Lavado gratis', 0, 1)
INSERT [dbo].[OFERTAS] ([id_oferta], [id_comercio], [codigo_articulo], [fecha_inicio_oferta], [fecha_finalizacion_oferta], [descripcion_oferta], [precio_oferta], [vigente_oferta]) VALUES (5, 4, 12, N'02/11/2020', N'30/11/2020', N'Tintura Azul', 900, 1)
INSERT [dbo].[OFERTAS] ([id_oferta], [id_comercio], [codigo_articulo], [fecha_inicio_oferta], [fecha_finalizacion_oferta], [descripcion_oferta], [precio_oferta], [vigente_oferta]) VALUES (6, 5, 5, N'07/11/2020', N'25/11/2020', N'3x2 en Aceites Mario', 120, 1)
INSERT [dbo].[OFERTAS] ([id_oferta], [id_comercio], [codigo_articulo], [fecha_inicio_oferta], [fecha_finalizacion_oferta], [descripcion_oferta], [precio_oferta], [vigente_oferta]) VALUES (7, 6, 6, N'07/11/2020', N'25/11/2020', N'Arroz buena vida', 55, 1)
INSERT [dbo].[OFERTAS] ([id_oferta], [id_comercio], [codigo_articulo], [fecha_inicio_oferta], [fecha_finalizacion_oferta], [descripcion_oferta], [precio_oferta], [vigente_oferta]) VALUES (8, 8, 14, N'05/11/2020', N'22/11/2020', N'Regla Maped', 22, 1)
INSERT [dbo].[OFERTAS] ([id_oferta], [id_comercio], [codigo_articulo], [fecha_inicio_oferta], [fecha_finalizacion_oferta], [descripcion_oferta], [precio_oferta], [vigente_oferta]) VALUES (9, 9, 15, N'05/11/2020', N'22/11/2020', N'Goma BorraBorra', 10, 1)
INSERT [dbo].[OFERTAS] ([id_oferta], [id_comercio], [codigo_articulo], [fecha_inicio_oferta], [fecha_finalizacion_oferta], [descripcion_oferta], [precio_oferta], [vigente_oferta]) VALUES (10, 7, 17, N'08/11/2020', N'10/11/2020', N'Autito Maxteel', 800, 1)
INSERT [dbo].[OFERTAS] ([id_oferta], [id_comercio], [codigo_articulo], [fecha_inicio_oferta], [fecha_finalizacion_oferta], [descripcion_oferta], [precio_oferta], [vigente_oferta]) VALUES (11, 10, 16, N'09/11/2020', N'15/11/2020', N'Cuaderno tapa de Boca', 18, 0)
INSERT [dbo].[OFERTAS] ([id_oferta], [id_comercio], [codigo_articulo], [fecha_inicio_oferta], [fecha_finalizacion_oferta], [descripcion_oferta], [precio_oferta], [vigente_oferta]) VALUES (12, 11, 6, N'07/11/2020', N'08/11/2020', N'Arroz integral para llevar con sus verduras', 25, 1)
SET IDENTITY_INSERT [dbo].[OFERTAS] OFF
GO
SET IDENTITY_INSERT [dbo].[RUBROS] ON 

INSERT [dbo].[RUBROS] ([id_rubro], [descripcion_rubro], [vigente_rubro]) VALUES (1, N'Deportes', 1)
INSERT [dbo].[RUBROS] ([id_rubro], [descripcion_rubro], [vigente_rubro]) VALUES (2, N'Almacen', 1)
INSERT [dbo].[RUBROS] ([id_rubro], [descripcion_rubro], [vigente_rubro]) VALUES (3, N'Libreria', 1)
INSERT [dbo].[RUBROS] ([id_rubro], [descripcion_rubro], [vigente_rubro]) VALUES (4, N'Peluqueria', 1)
INSERT [dbo].[RUBROS] ([id_rubro], [descripcion_rubro], [vigente_rubro]) VALUES (5, N'Jugueteria', 1)
INSERT [dbo].[RUBROS] ([id_rubro], [descripcion_rubro], [vigente_rubro]) VALUES (6, N'Regaleria', 0)
INSERT [dbo].[RUBROS] ([id_rubro], [descripcion_rubro], [vigente_rubro]) VALUES (7, N'Verduleria', 1)
SET IDENTITY_INSERT [dbo].[RUBROS] OFF
GO
ALTER TABLE [dbo].[COMENTARIOS_COMERCIOS]  WITH CHECK ADD  CONSTRAINT [FK_COMENTARIOS_COMERCIOS_COMERCIOS] FOREIGN KEY([id_comercio])
REFERENCES [dbo].[COMERCIOS] ([id_comercio])
GO
ALTER TABLE [dbo].[COMENTARIOS_COMERCIOS] CHECK CONSTRAINT [FK_COMENTARIOS_COMERCIOS_COMERCIOS]
GO
ALTER TABLE [dbo].[COMERCIOS]  WITH CHECK ADD  CONSTRAINT [FK_COMERCIOS_RUBROS] FOREIGN KEY([id_rubro])
REFERENCES [dbo].[RUBROS] ([id_rubro])
GO
ALTER TABLE [dbo].[COMERCIOS] CHECK CONSTRAINT [FK_COMERCIOS_RUBROS]
GO
ALTER TABLE [dbo].[OFERTAS]  WITH CHECK ADD  CONSTRAINT [FK_OFERTAS_ARTICULOS1] FOREIGN KEY([codigo_articulo])
REFERENCES [dbo].[ARTICULOS] ([codigo_articulo])
GO
ALTER TABLE [dbo].[OFERTAS] CHECK CONSTRAINT [FK_OFERTAS_ARTICULOS1]
GO
ALTER TABLE [dbo].[OFERTAS]  WITH CHECK ADD  CONSTRAINT [FK_OFERTAS_COMERCIOS] FOREIGN KEY([id_comercio])
REFERENCES [dbo].[COMERCIOS] ([id_comercio])
GO
ALTER TABLE [dbo].[OFERTAS] CHECK CONSTRAINT [FK_OFERTAS_COMERCIOS]
GO
USE [master]
GO
ALTER DATABASE [RED_SOCIAL_FR] SET  READ_WRITE 
GO
