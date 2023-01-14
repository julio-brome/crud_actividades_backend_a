USE [crud_actividades]
GO
/****** Object:  Table [dbo].[tblactividades]    Script Date: 14/01/2023 8:45:36 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblactividades](
	[id_actividades] [int] IDENTITY(1,1) NOT NULL,
	[empleado_id] [int] NULL,
	[descripcion] [nvarchar](200) NULL,
	[fecha_registro] [datetime] NULL,
	[fecha_ejecucion] [datetime] NULL,
	[estado] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id_actividades] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblempleado]    Script Date: 14/01/2023 8:45:36 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblempleado](
	[id_empleado] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nvarchar](100) NULL,
	[correo] [nvarchar](100) NULL,
	[estado] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id_empleado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[tblactividades]  WITH CHECK ADD  CONSTRAINT [fk_pk_empleado_actividades] FOREIGN KEY([empleado_id])
REFERENCES [dbo].[tblempleado] ([id_empleado])
GO
ALTER TABLE [dbo].[tblactividades] CHECK CONSTRAINT [fk_pk_empleado_actividades]
GO
