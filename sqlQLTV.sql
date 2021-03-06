USE [QLTV]
GO
/****** Object:  Table [dbo].[ChiTietPhieuDat]    Script Date: 4/5/2021 11:10:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuDat](
	[MaPD] [nvarchar](50) NOT NULL,
	[MaNXB] [nvarchar](50) NOT NULL,
	[TenSach] [nvarchar](50) NOT NULL,
	[Soluong] [int] NOT NULL,
	[DonGia] [float] NULL,
	[maCTPD] [nchar](10) NOT NULL,
 CONSTRAINT [PK_ChiTietPhieuDat_1] PRIMARY KEY CLUSTERED 
(
	[maCTPD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ChiTietPhieuMuon]    Script Date: 4/5/2021 11:10:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuMuon](
	[MaPM] [nvarchar](50) NOT NULL,
	[MaSach] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_ChiTietPhieuMuon] PRIMARY KEY CLUSTERED 
(
	[MaPM] ASC,
	[MaSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ChiTietPhieuThanhLy]    Script Date: 4/5/2021 11:10:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuThanhLy](
	[MaPTL] [nvarchar](50) NOT NULL,
	[MaSach] [nvarchar](50) NOT NULL,
	[DonGia] [float] NULL,
	[MaCTPTL] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_ChiTietPhieuThanhLy_1] PRIMARY KEY CLUSTERED 
(
	[MaCTPTL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DocGia]    Script Date: 4/5/2021 11:10:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DocGia](
	[MaSV] [nvarchar](50) NOT NULL,
	[HoTen] [nvarchar](50) NOT NULL,
	[NamSinh] [date] NULL,
	[CMND] [nvarchar](50) NULL,
	[SoDienThoai] [nvarchar](50) NULL,
 CONSTRAINT [PK_DocGia] PRIMARY KEY CLUSTERED 
(
	[MaSV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 4/5/2021 11:10:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [nvarchar](50) NOT NULL,
	[TenNV] [nvarchar](50) NOT NULL,
	[SoDienThoai] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhaXuatBan]    Script Date: 4/5/2021 11:10:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaXuatBan](
	[MaNXB] [nvarchar](50) NOT NULL,
	[TenNXB] [nvarchar](50) NOT NULL,
	[DiaChi] [nvarchar](100) NULL,
 CONSTRAINT [PK_NhaXuatBan] PRIMARY KEY CLUSTERED 
(
	[MaNXB] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PhieuDat]    Script Date: 4/5/2021 11:10:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuDat](
	[MaPD] [nvarchar](50) NOT NULL,
	[MaNV] [nvarchar](50) NOT NULL,
	[NgayNhap] [date] NULL,
 CONSTRAINT [PK_PhieuDat] PRIMARY KEY CLUSTERED 
(
	[MaPD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PhieuMuon]    Script Date: 4/5/2021 11:10:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuMuon](
	[MaPM] [nvarchar](50) NOT NULL,
	[Madocgia] [nvarchar](50) NOT NULL,
	[Ngaymuon] [date] NOT NULL,
	[Ngaytra] [date] NOT NULL,
	[MaNV] [nvarchar](50) NOT NULL,
	[Giahan] [nvarchar](50) NULL,
 CONSTRAINT [PK_PhieuMuon_1] PRIMARY KEY CLUSTERED 
(
	[MaPM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PhieuThanhLy]    Script Date: 4/5/2021 11:10:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuThanhLy](
	[MaPTL] [nvarchar](50) NOT NULL,
	[MaNV] [nvarchar](50) NOT NULL,
	[NgayThanhLy] [date] NOT NULL,
 CONSTRAINT [PK_PhieuThanhLy] PRIMARY KEY CLUSTERED 
(
	[MaPTL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Sach]    Script Date: 4/5/2021 11:10:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sach](
	[MaSach] [nvarchar](50) NOT NULL,
	[TenSach] [nvarchar](50) NOT NULL,
	[TheLoai] [nvarchar](50) NOT NULL,
	[NamXB] [nvarchar](50) NULL,
	[MaNXB] [nvarchar](50) NULL,
	[Tinhtrangsach] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Sach] PRIMARY KEY CLUSTERED 
(
	[MaSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[ChiTietPhieuDat] ([MaPD], [MaNXB], [TenSach], [Soluong], [DonGia], [maCTPD]) VALUES (N'PD_2', N'NXB1', N'Sach1', 10, 10000, N'maCTPD_2  ')
INSERT [dbo].[ChiTietPhieuDat] ([MaPD], [MaNXB], [TenSach], [Soluong], [DonGia], [maCTPD]) VALUES (N'PD_2', N'NXB1', N'Sach1', 10, 10000, N'maCTPD_3  ')
INSERT [dbo].[ChiTietPhieuMuon] ([MaPM], [MaSach]) VALUES (N'PM_2', N'SS_1')
INSERT [dbo].[ChiTietPhieuMuon] ([MaPM], [MaSach]) VALUES (N'PM_2', N'SS_2')
INSERT [dbo].[ChiTietPhieuMuon] ([MaPM], [MaSach]) VALUES (N'PM_2', N'SS_3')
INSERT [dbo].[ChiTietPhieuThanhLy] ([MaPTL], [MaSach], [DonGia], [MaCTPTL]) VALUES (N'PTL_1', N'SS_1', 12, N'maCTPTL_2')
INSERT [dbo].[ChiTietPhieuThanhLy] ([MaPTL], [MaSach], [DonGia], [MaCTPTL]) VALUES (N'PTL_2', N'SS_2', 12, N'maCTPTL_3')
INSERT [dbo].[DocGia] ([MaSV], [HoTen], [NamSinh], [CMND], [SoDienThoai]) VALUES (N'maDG_2', N'khach4', CAST(0xBB070B00 AS Date), N'12', N'12')
INSERT [dbo].[DocGia] ([MaSV], [HoTen], [NamSinh], [CMND], [SoDienThoai]) VALUES (N'maDG_3', N'khach21', CAST(0xA62A0B00 AS Date), N'1231233', N'0912312312')
INSERT [dbo].[DocGia] ([MaSV], [HoTen], [NamSinh], [CMND], [SoDienThoai]) VALUES (N'maDG_4', N'a', CAST(0xD0250B00 AS Date), N'12312', N'12321')
INSERT [dbo].[DocGia] ([MaSV], [HoTen], [NamSinh], [CMND], [SoDienThoai]) VALUES (N'maDG_5', N'as', CAST(0x7E070B00 AS Date), N'222', N'2222')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [SoDienThoai], [DiaChi]) VALUES (N'NV1', N'Nguyễn Văn A', N'456789123', N'ffffff12')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [SoDienThoai], [DiaChi]) VALUES (N'NV2', N'Trần Thị B', NULL, N'ddddddd2')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [SoDienThoai], [DiaChi]) VALUES (N'NV3', N'Phạm Thị C', N'425566689', N'')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'NXB1', N'Tuổi Trẻ', N'27/1D - Tây Nam - Gia Kiệm')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'NXB2', N'Ánh Hồng', N'237 An Dương Vương - Phường 1 - Quận 5 - TPHCM')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'NXB3', N'Thanh Xuân', N'244/11 Nguyễn Thiện Thuật - Phường 5 - Quận 3')
INSERT [dbo].[PhieuDat] ([MaPD], [MaNV], [NgayNhap]) VALUES (N'PD_2', N'NV1', CAST(0x233F0B00 AS Date))
INSERT [dbo].[PhieuMuon] ([MaPM], [Madocgia], [Ngaymuon], [Ngaytra], [MaNV], [Giahan]) VALUES (N'PM_2', N'maDG_3', CAST(0x5C420B00 AS Date), CAST(0x66420B00 AS Date), N'NV1', N'daGH')
INSERT [dbo].[PhieuMuon] ([MaPM], [Madocgia], [Ngaymuon], [Ngaytra], [MaNV], [Giahan]) VALUES (N'PM_3', N'maDG_4', CAST(0x5C420B00 AS Date), CAST(0x63420B00 AS Date), N'NV1', NULL)
INSERT [dbo].[PhieuMuon] ([MaPM], [Madocgia], [Ngaymuon], [Ngaytra], [MaNV], [Giahan]) VALUES (N'PM_4', N'maDG_2', CAST(0x5C420B00 AS Date), CAST(0x63420B00 AS Date), N'NV1', NULL)
INSERT [dbo].[PhieuThanhLy] ([MaPTL], [MaNV], [NgayThanhLy]) VALUES (N'PTL_1', N'NV1', CAST(0x8B430B00 AS Date))
INSERT [dbo].[PhieuThanhLy] ([MaPTL], [MaNV], [NgayThanhLy]) VALUES (N'PTL_2', N'NV1', CAST(0x233F0B00 AS Date))
INSERT [dbo].[PhieuThanhLy] ([MaPTL], [MaNV], [NgayThanhLy]) VALUES (N'PTL_3', N'NV1', CAST(0x233F0B00 AS Date))
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TheLoai], [NamXB], [MaNXB], [Tinhtrangsach]) VALUES (N'SS_1', N'sach 12', N'The loai 12', N'1949', N'NXB3', N'moi2')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TheLoai], [NamXB], [MaNXB], [Tinhtrangsach]) VALUES (N'SS_2', N'sach 2', N'the loai 2', N'1930', N'NXB2', N'cu')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TheLoai], [NamXB], [MaNXB], [Tinhtrangsach]) VALUES (N'SS_3', N'sach 3', N'the loai 3', N'1931', N'NXB3', N'vua uv')
ALTER TABLE [dbo].[ChiTietPhieuDat]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuDat_NhaXuatBan] FOREIGN KEY([MaNXB])
REFERENCES [dbo].[NhaXuatBan] ([MaNXB])
GO
ALTER TABLE [dbo].[ChiTietPhieuDat] CHECK CONSTRAINT [FK_ChiTietPhieuDat_NhaXuatBan]
GO
ALTER TABLE [dbo].[ChiTietPhieuDat]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuDat_PhieuDat] FOREIGN KEY([MaPD])
REFERENCES [dbo].[PhieuDat] ([MaPD])
GO
ALTER TABLE [dbo].[ChiTietPhieuDat] CHECK CONSTRAINT [FK_ChiTietPhieuDat_PhieuDat]
GO
ALTER TABLE [dbo].[ChiTietPhieuMuon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuMuon_PhieuMuon] FOREIGN KEY([MaPM])
REFERENCES [dbo].[PhieuMuon] ([MaPM])
GO
ALTER TABLE [dbo].[ChiTietPhieuMuon] CHECK CONSTRAINT [FK_ChiTietPhieuMuon_PhieuMuon]
GO
ALTER TABLE [dbo].[ChiTietPhieuMuon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuMuon_Sach] FOREIGN KEY([MaSach])
REFERENCES [dbo].[Sach] ([MaSach])
GO
ALTER TABLE [dbo].[ChiTietPhieuMuon] CHECK CONSTRAINT [FK_ChiTietPhieuMuon_Sach]
GO
ALTER TABLE [dbo].[ChiTietPhieuThanhLy]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuThanhLy_PhieuThanhLy] FOREIGN KEY([MaPTL])
REFERENCES [dbo].[PhieuThanhLy] ([MaPTL])
GO
ALTER TABLE [dbo].[ChiTietPhieuThanhLy] CHECK CONSTRAINT [FK_ChiTietPhieuThanhLy_PhieuThanhLy]
GO
ALTER TABLE [dbo].[ChiTietPhieuThanhLy]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuThanhLy_Sach] FOREIGN KEY([MaSach])
REFERENCES [dbo].[Sach] ([MaSach])
GO
ALTER TABLE [dbo].[ChiTietPhieuThanhLy] CHECK CONSTRAINT [FK_ChiTietPhieuThanhLy_Sach]
GO
ALTER TABLE [dbo].[PhieuDat]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDat_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[PhieuDat] CHECK CONSTRAINT [FK_PhieuDat_NhanVien]
GO
ALTER TABLE [dbo].[PhieuMuon]  WITH CHECK ADD  CONSTRAINT [FK_PhieuMuon_DocGia] FOREIGN KEY([Madocgia])
REFERENCES [dbo].[DocGia] ([MaSV])
GO
ALTER TABLE [dbo].[PhieuMuon] CHECK CONSTRAINT [FK_PhieuMuon_DocGia]
GO
ALTER TABLE [dbo].[PhieuMuon]  WITH CHECK ADD  CONSTRAINT [FK_PhieuMuon_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[PhieuMuon] CHECK CONSTRAINT [FK_PhieuMuon_NhanVien]
GO
ALTER TABLE [dbo].[PhieuThanhLy]  WITH CHECK ADD  CONSTRAINT [FK_PhieuThanhLy_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[PhieuThanhLy] CHECK CONSTRAINT [FK_PhieuThanhLy_NhanVien]
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD  CONSTRAINT [FK_Sach_NhaXuatBan] FOREIGN KEY([MaNXB])
REFERENCES [dbo].[NhaXuatBan] ([MaNXB])
GO
ALTER TABLE [dbo].[Sach] CHECK CONSTRAINT [FK_Sach_NhaXuatBan]
GO
