USE [master]
GO
/****** Object:  Database [QLHS]    Script Date: 12/5/2021 3:17:03 PM ******/
CREATE DATABASE [QLHS]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLHS', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QLHS.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QLHS_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QLHS_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QLHS] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLHS].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLHS] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLHS] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLHS] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLHS] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLHS] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLHS] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLHS] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLHS] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLHS] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLHS] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLHS] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLHS] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLHS] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLHS] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLHS] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QLHS] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLHS] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLHS] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLHS] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLHS] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLHS] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLHS] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLHS] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QLHS] SET  MULTI_USER 
GO
ALTER DATABASE [QLHS] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLHS] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLHS] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLHS] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QLHS] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QLHS] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QLHS] SET QUERY_STORE = OFF
GO
USE [QLHS]
GO
/****** Object:  Table [dbo].[Student]    Script Date: 12/5/2021 3:17:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student](
	[StudentID] [nvarchar](50) NULL,
	[StudentName] [nvarchar](50) NULL,
	[GPA] [nvarchar](50) NULL,
	[Image] [nvarchar](50) NULL,
	[Address] [nvarchar](50) NULL,
	[Note] [nvarchar](50) NULL
) ON [PRIMARY]
GO
INSERT [dbo].[Student] ([StudentID], [StudentName], [GPA], [Image], [Address], [Note]) VALUES (N'191275555', N'Đặng Tú Thiệu', N'1', N'Điểm', N'282 Lê Thánh Tôn', N'Thiệu Đẹp')
INSERT [dbo].[Student] ([StudentID], [StudentName], [GPA], [Image], [Address], [Note]) VALUES (N'19127523', N'Phạm', N'3', N'321', N'#88', N'Tiến')
INSERT [dbo].[Student] ([StudentID], [StudentName], [GPA], [Image], [Address], [Note]) VALUES (N'19127526', N'Pham Quan', N'4', N'Image', N'338 Lý Thái Tổ', N'tienquan')
GO
USE [master]
GO
ALTER DATABASE [QLHS] SET  READ_WRITE 
GO
