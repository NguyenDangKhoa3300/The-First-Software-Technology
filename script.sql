USE [QLTV]
GO
/****** Object:  Table [dbo].[ChiTietPhieuDat]    Script Date: 3/5/2021 1:46:36 PM ******/
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
 CONSTRAINT [PK_ChiTietPhieuDat] PRIMARY KEY CLUSTERED 
(
	[MaPD] ASC,
	[TenSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ChiTietPhieuMuon]    Script Date: 3/5/2021 1:46:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuMuon](
	[MaPM] [int] NOT NULL,
	[MaSach] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_ChiTietPhieuMuon_1] PRIMARY KEY CLUSTERED 
(
	[MaPM] ASC,
	[MaSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ChiTietPhieuThanhLy]    Script Date: 3/5/2021 1:46:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuThanhLy](
	[MaPTL] [nvarchar](50) NOT NULL,
	[MaSach] [nvarchar](50) NOT NULL,
	[DonGia] [float] NULL,
 CONSTRAINT [PK_ChiTietPhieuThanhLy_1] PRIMARY KEY CLUSTERED 
(
	[MaPTL] ASC,
	[MaSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DocGia]    Script Date: 3/5/2021 1:46:36 PM ******/
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
/****** Object:  Table [dbo].[NhanVien]    Script Date: 3/5/2021 1:46:36 PM ******/
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
/****** Object:  Table [dbo].[NhaXuatBan]    Script Date: 3/5/2021 1:46:36 PM ******/
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
/****** Object:  Table [dbo].[PhieuDat]    Script Date: 3/5/2021 1:46:36 PM ******/
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
/****** Object:  Table [dbo].[PhieuMuon]    Script Date: 3/5/2021 1:46:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuMuon](
	[MaPM] [int] NOT NULL,
	[Madocgia] [nvarchar](50) NOT NULL,
	[Ngaymuon] [datetime] NOT NULL,
	[Ngaytra] [datetime] NOT NULL,
	[Soluong] [int] NOT NULL,
 CONSTRAINT [PK_PhieuMuon_1] PRIMARY KEY CLUSTERED 
(
	[MaPM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PhieuThanhLy]    Script Date: 3/5/2021 1:46:36 PM ******/
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
/****** Object:  Table [dbo].[Sach]    Script Date: 3/5/2021 1:46:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sach](
	[MaSach] [nvarchar](50) NOT NULL,
	[TenSach] [nvarchar](50) NOT NULL,
	[TheLoai] [nvarchar](50) NOT NULL,
	[NamXB] [date] NULL,
	[MaNXB] [nvarchar](50) NULL,
	[Tinhtrangsach] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Sach] PRIMARY KEY CLUSTERED 
(
	[MaSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[ChiTietPhieuDat] ([MaPD], [MaNXB], [TenSach], [Soluong], [DonGia]) VALUES (N'PD1', N'NXB1', N'Cho Tôi Một Vé Về Tuổi Thơ', 3, 120000)
INSERT [dbo].[ChiTietPhieuDat] ([MaPD], [MaNXB], [TenSach], [Soluong], [DonGia]) VALUES (N'PD1', N'NXB2', N'The World''s Worst Children', 5, 200000)
INSERT [dbo].[ChiTietPhieuDat] ([MaPD], [MaNXB], [TenSach], [Soluong], [DonGia]) VALUES (N'PD2', N'NXB1', N'Ứng Dụng Màu Sắc Thay Đổi Cuộc Sống', 2, 150000)
INSERT [dbo].[ChiTietPhieuDat] ([MaPD], [MaNXB], [TenSach], [Soluong], [DonGia]) VALUES (N'PD3', N'NXB3', N'Never Eat Alone', 3, 112000)
INSERT [dbo].[ChiTietPhieuMuon] ([MaPM], [MaSach]) VALUES (1, N'SS1')
INSERT [dbo].[ChiTietPhieuMuon] ([MaPM], [MaSach]) VALUES (1, N'SS2')
INSERT [dbo].[ChiTietPhieuMuon] ([MaPM], [MaSach]) VALUES (2, N'ZZ1')
INSERT [dbo].[ChiTietPhieuMuon] ([MaPM], [MaSach]) VALUES (3, N'CC1')
INSERT [dbo].[ChiTietPhieuMuon] ([MaPM], [MaSach]) VALUES (3, N'CC2')
INSERT [dbo].[ChiTietPhieuMuon] ([MaPM], [MaSach]) VALUES (3, N'CC3')
INSERT [dbo].[ChiTietPhieuThanhLy] ([MaPTL], [MaSach], [DonGia]) VALUES (N'PTL1', N'CC1', 150000)
INSERT [dbo].[ChiTietPhieuThanhLy] ([MaPTL], [MaSach], [DonGia]) VALUES (N'PTL1', N'SS2', 190000)
INSERT [dbo].[ChiTietPhieuThanhLy] ([MaPTL], [MaSach], [DonGia]) VALUES (N'PTL3', N'SS1', 178000)
INSERT [dbo].[ChiTietPhieuThanhLy] ([MaPTL], [MaSach], [DonGia]) VALUES (N'PTL4', N'ZZ1', 165000)
INSERT [dbo].[DocGia] ([MaSV], [HoTen], [NamSinh], [CMND], [SoDienThoai]) VALUES (N'AA1', N'Tran Minh Khoa', CAST(N'2000-08-21' AS Date), N'272814685', N'0375065117')
INSERT [dbo].[DocGia] ([MaSV], [HoTen], [NamSinh], [CMND], [SoDienThoai]) VALUES (N'AA3', N'Le Thi Xuan', CAST(N'1997-01-22' AS Date), N'215866648', N'0909272491')
INSERT [dbo].[DocGia] ([MaSV], [HoTen], [NamSinh], [CMND], [SoDienThoai]) VALUES (N'DC2', N'Tran Van A', CAST(N'2001-06-03' AS Date), N'054622216', N'0333514566')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [SoDienThoai], [DiaChi]) VALUES (N'NV1', N'Nguyễn Văn A', N'456789123', N'ffffff12')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [SoDienThoai], [DiaChi]) VALUES (N'NV2', N'Trần Thị B', NULL, N'ddddddd2')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [SoDienThoai], [DiaChi]) VALUES (N'NV3', N'Phạm Thị C', N'425566689', N'')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'NXB1', N'Tuổi Trẻ', N'27/1D - Tây Nam - Gia Kiệm')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'NXB2', N'Ánh Hồng', N'237 An Dương Vương - Phường 1 - Quận 5 - TPHCM')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'NXB3', N'Thanh Xuân', N'244/11 Nguyễn Thiện Thuật - Phường 5 - Quận 3')
INSERT [dbo].[PhieuDat] ([MaPD], [MaNV], [NgayNhap]) VALUES (N'PD1', N'NV2', CAST(N'1889-02-02' AS Date))
INSERT [dbo].[PhieuDat] ([MaPD], [MaNV], [NgayNhap]) VALUES (N'PD2', N'NV1', CAST(N'1999-05-03' AS Date))
INSERT [dbo].[PhieuDat] ([MaPD], [MaNV], [NgayNhap]) VALUES (N'PD3', N'NV3', CAST(N'1879-09-09' AS Date))
INSERT [dbo].[PhieuDat] ([MaPD], [MaNV], [NgayNhap]) VALUES (N'PD4', N'NV2', CAST(N'1997-04-04' AS Date))
INSERT [dbo].[PhieuMuon] ([MaPM], [Madocgia], [Ngaymuon], [Ngaytra], [Soluong]) VALUES (1, N'AA1', CAST(N'2001-08-21 00:00:00.000' AS DateTime), CAST(N'2001-09-10 00:00:00.000' AS DateTime), 2)
INSERT [dbo].[PhieuMuon] ([MaPM], [Madocgia], [Ngaymuon], [Ngaytra], [Soluong]) VALUES (2, N'DC2', CAST(N'2012-06-23 00:00:00.000' AS DateTime), CAST(N'2012-07-07 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[PhieuMuon] ([MaPM], [Madocgia], [Ngaymuon], [Ngaytra], [Soluong]) VALUES (3, N'AA3', CAST(N'2011-11-11 00:00:00.000' AS DateTime), CAST(N'2012-12-12 00:00:00.000' AS DateTime), 3)
INSERT [dbo].[PhieuThanhLy] ([MaPTL], [MaNV], [NgayThanhLy]) VALUES (N'PTL1', N'NV1', CAST(N'1995-02-02' AS Date))
INSERT [dbo].[PhieuThanhLy] ([MaPTL], [MaNV], [NgayThanhLy]) VALUES (N'PTL2', N'NV1', CAST(N'1989-01-01' AS Date))
INSERT [dbo].[PhieuThanhLy] ([MaPTL], [MaNV], [NgayThanhLy]) VALUES (N'PTL3', N'NV3', CAST(N'1111-03-02' AS Date))
INSERT [dbo].[PhieuThanhLy] ([MaPTL], [MaNV], [NgayThanhLy]) VALUES (N'PTL4', N'NV2', CAST(N'1333-05-05' AS Date))
INSERT [dbo].[PhieuThanhLy] ([MaPTL], [MaNV], [NgayThanhLy]) VALUES (N'PTL5', N'NV3', CAST(N'8856-03-09' AS Date))
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TheLoai], [NamXB], [MaNXB], [Tinhtrangsach]) VALUES (N'CC1', N'Dế Mèn Phiêu Lưu Ký', N'Short story', CAST(N'1994-01-01' AS Date), N'NXB1', N'New')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TheLoai], [NamXB], [MaNXB], [Tinhtrangsach]) VALUES (N'CC2', N'Oliver', N'Novel', CAST(N'1899-12-01' AS Date), N'NXB2', N'Old')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TheLoai], [NamXB], [MaNXB], [Tinhtrangsach]) VALUES (N'CC3', N'You Can Read Anyone', N'Nonfiction', CAST(N'2009-02-01' AS Date), N'NXB2', N'New')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TheLoai], [NamXB], [MaNXB], [Tinhtrangsach]) VALUES (N'SS1', N'The God Father', N'Drama', CAST(N'2000-10-06' AS Date), N'NXB1', N'New')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TheLoai], [NamXB], [MaNXB], [Tinhtrangsach]) VALUES (N'SS2', N'Bay Trên Tổ Chim Cúc Cu', N'Romance', CAST(N'2002-03-22' AS Date), N'NXB1', N'Old')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TheLoai], [NamXB], [MaNXB], [Tinhtrangsach]) VALUES (N'ZZ1', N'Thinking Fast And Slow', N'Nonfiction', CAST(N'1991-03-15' AS Date), N'NXB1', N'Old')
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
