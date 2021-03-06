USE [QLTV]
GO
/****** Object:  Table [dbo].[ChiTietPhieuDat]    Script Date: 5/1/2021 11:27:54 AM ******/
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
/****** Object:  Table [dbo].[ChiTietPhieuMuon]    Script Date: 5/1/2021 11:27:54 AM ******/
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
/****** Object:  Table [dbo].[ChiTietPhieuThanhLy]    Script Date: 5/1/2021 11:27:54 AM ******/
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
/****** Object:  Table [dbo].[DocGia]    Script Date: 5/1/2021 11:27:54 AM ******/
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
/****** Object:  Table [dbo].[NhanVien]    Script Date: 5/1/2021 11:27:54 AM ******/
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
/****** Object:  Table [dbo].[NhaXuatBan]    Script Date: 5/1/2021 11:27:54 AM ******/
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
/****** Object:  Table [dbo].[PhieuDat]    Script Date: 5/1/2021 11:27:54 AM ******/
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
/****** Object:  Table [dbo].[PhieuMuon]    Script Date: 5/1/2021 11:27:54 AM ******/
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
/****** Object:  Table [dbo].[PhieuThanhLy]    Script Date: 5/1/2021 11:27:54 AM ******/
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
/****** Object:  Table [dbo].[Sach]    Script Date: 5/1/2021 11:27:54 AM ******/
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
INSERT [dbo].[ChiTietPhieuDat] ([MaPD], [MaNXB], [TenSach], [Soluong], [DonGia], [maCTPD]) VALUES (N'PD_2', N'NXB1', N'Bắt trẻ đồng xanh', 10, 250000, N'maCTPD_2  ')
INSERT [dbo].[ChiTietPhieuDat] ([MaPD], [MaNXB], [TenSach], [Soluong], [DonGia], [maCTPD]) VALUES (N'PD_2', N'NXB6', N'Cứ đi rồi sẽ đến', 10, 500000, N'maCTPD_3  ')
INSERT [dbo].[ChiTietPhieuDat] ([MaPD], [MaNXB], [TenSach], [Soluong], [DonGia], [maCTPD]) VALUES (N'PD_3', N'NXB4', N'7 thói quen để thành đạt', 10, 500000, N'maCTPD_4  ')
INSERT [dbo].[ChiTietPhieuDat] ([MaPD], [MaNXB], [TenSach], [Soluong], [DonGia], [maCTPD]) VALUES (N'PD_3', N'NXB4', N'Thép đã tôi thế đấy', 10, 100000, N'maCTPD_5  ')
INSERT [dbo].[ChiTietPhieuMuon] ([MaPM], [MaSach]) VALUES (N'PM_10', N'SS_9')
INSERT [dbo].[ChiTietPhieuMuon] ([MaPM], [MaSach]) VALUES (N'PM_2', N'SS_1')
INSERT [dbo].[ChiTietPhieuMuon] ([MaPM], [MaSach]) VALUES (N'PM_2', N'SS_10')
INSERT [dbo].[ChiTietPhieuMuon] ([MaPM], [MaSach]) VALUES (N'PM_2', N'SS_11')
INSERT [dbo].[ChiTietPhieuMuon] ([MaPM], [MaSach]) VALUES (N'PM_3', N'SS_2')
INSERT [dbo].[ChiTietPhieuMuon] ([MaPM], [MaSach]) VALUES (N'PM_4', N'SS_3')
INSERT [dbo].[ChiTietPhieuMuon] ([MaPM], [MaSach]) VALUES (N'PM_5', N'SS_4')
INSERT [dbo].[ChiTietPhieuMuon] ([MaPM], [MaSach]) VALUES (N'PM_6', N'SS_5')
INSERT [dbo].[ChiTietPhieuMuon] ([MaPM], [MaSach]) VALUES (N'PM_7', N'SS_6')
INSERT [dbo].[ChiTietPhieuMuon] ([MaPM], [MaSach]) VALUES (N'PM_8', N'SS_7')
INSERT [dbo].[ChiTietPhieuMuon] ([MaPM], [MaSach]) VALUES (N'PM_9', N'SS_8')
INSERT [dbo].[ChiTietPhieuThanhLy] ([MaPTL], [MaSach], [DonGia], [MaCTPTL]) VALUES (N'PTL_1', N'SS_2', 100000, N'maCTPTL_2')
INSERT [dbo].[ChiTietPhieuThanhLy] ([MaPTL], [MaSach], [DonGia], [MaCTPTL]) VALUES (N'PTL_1', N'SS_3', 50000, N'maCTPTL_3')
INSERT [dbo].[ChiTietPhieuThanhLy] ([MaPTL], [MaSach], [DonGia], [MaCTPTL]) VALUES (N'PTL_1', N'SS_4', 50000, N'maCTPTL_4')
INSERT [dbo].[ChiTietPhieuThanhLy] ([MaPTL], [MaSach], [DonGia], [MaCTPTL]) VALUES (N'PTL_1', N'SS_6', 30000, N'maCTPTL_5')
INSERT [dbo].[ChiTietPhieuThanhLy] ([MaPTL], [MaSach], [DonGia], [MaCTPTL]) VALUES (N'PTL_1', N'SS_8', 120000, N'maCTPTL_6')
INSERT [dbo].[ChiTietPhieuThanhLy] ([MaPTL], [MaSach], [DonGia], [MaCTPTL]) VALUES (N'PTL_1', N'SS_9', 90000, N'maCTPTL_7')
INSERT [dbo].[DocGia] ([MaSV], [HoTen], [NamSinh], [CMND], [SoDienThoai]) VALUES (N'maDG_10', N'Nguyễn Bảo Tú', CAST(0xA7210B00 AS Date), N'018364215', N'0912126232')
INSERT [dbo].[DocGia] ([MaSV], [HoTen], [NamSinh], [CMND], [SoDienThoai]) VALUES (N'maDG_11', N'Võ Khôi Nguyên', CAST(0xCD1E0B00 AS Date), N'027736863', N'0914286232')
INSERT [dbo].[DocGia] ([MaSV], [HoTen], [NamSinh], [CMND], [SoDienThoai]) VALUES (N'maDG_12', N'Lâm Lan Vy', CAST(0x5F1D0B00 AS Date), N'027736863', N'0914286232')
INSERT [dbo].[DocGia] ([MaSV], [HoTen], [NamSinh], [CMND], [SoDienThoai]) VALUES (N'maDG_13', N'Võ Minh Duy', CAST(0x3F1D0B00 AS Date), N'027736863', N'0914286232')
INSERT [dbo].[DocGia] ([MaSV], [HoTen], [NamSinh], [CMND], [SoDienThoai]) VALUES (N'maDG_14', N'Vũ Hải', CAST(0x2A2B0B00 AS Date), N'092742345', N'027464538')
INSERT [dbo].[DocGia] ([MaSV], [HoTen], [NamSinh], [CMND], [SoDienThoai]) VALUES (N'maDG_15', N'Nguyễn Thế Bảo', CAST(0x0A240B00 AS Date), N'0258284782', N'0928278212')
INSERT [dbo].[DocGia] ([MaSV], [HoTen], [NamSinh], [CMND], [SoDienThoai]) VALUES (N'maDG_16', N'Nguyễn Thế Anh', CAST(0x0A240B00 AS Date), N'0258284782', N'0928278212')
INSERT [dbo].[DocGia] ([MaSV], [HoTen], [NamSinh], [CMND], [SoDienThoai]) VALUES (N'maDG_2', N'Võ Chí Thanh', CAST(0xA42B0B00 AS Date), N'027018029', N'0913342327')
INSERT [dbo].[DocGia] ([MaSV], [HoTen], [NamSinh], [CMND], [SoDienThoai]) VALUES (N'maDG_3', N'Võ Van Thanh', CAST(0x372A0B00 AS Date), N'027018215', N'0913342432')
INSERT [dbo].[DocGia] ([MaSV], [HoTen], [NamSinh], [CMND], [SoDienThoai]) VALUES (N'maDG_4', N'Võ Trúc Thái', CAST(0xC9280B00 AS Date), N'023218215', N'0914442432')
INSERT [dbo].[DocGia] ([MaSV], [HoTen], [NamSinh], [CMND], [SoDienThoai]) VALUES (N'maDG_5', N'Vũ An Duy', CAST(0x82240B00 AS Date), N'022418215', N'0994742432')
INSERT [dbo].[DocGia] ([MaSV], [HoTen], [NamSinh], [CMND], [SoDienThoai]) VALUES (N'maDG_6', N'Mai Anh Tú', CAST(0x82240B00 AS Date), N'022218215', N'0214742432')
INSERT [dbo].[DocGia] ([MaSV], [HoTen], [NamSinh], [CMND], [SoDienThoai]) VALUES (N'maDG_7', N'Mã Van Tài', CAST(0xA7210B00 AS Date), N'022464215', N'0912742432')
INSERT [dbo].[DocGia] ([MaSV], [HoTen], [NamSinh], [CMND], [SoDienThoai]) VALUES (N'maDG_8', N'Phan Hoài Anh', CAST(0xA7210B00 AS Date), N'092464215', N'0912742432')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [SoDienThoai], [DiaChi]) VALUES (N'NV1', N'Nguyễn Văn A', N'456789123', N'ffffff12')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [SoDienThoai], [DiaChi]) VALUES (N'NV2', N'Trần Thị B', NULL, N'ddddddd2')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [SoDienThoai], [DiaChi]) VALUES (N'NV3', N'Phạm Thị C', N'425566689', N'')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'NXB1', N'Tuổi Trẻ', N'27/1D - Tây Nam - Gia Kiệm')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'NXB10', N'Tài chính', N'25/4')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'NXB11', N'Tri thức', N'25/4')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'NXB2', N'Ánh Hồng', N'237 An Dương Vương - Phường 1 - Quận 5 - TPHCM')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'NXB3', N'Thanh Xuân', N'244/11 Nguyễn Thiện Thuật - Phường 5 - Quận 3')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'NXB4', N'Kim Đồng', N'25/4')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'NXB5', N'Hồng Đức.', N'25/4')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'NXB6', N'Thanh niên', N'25/4')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'NXB7', N'Lao động', N'25/4')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'NXB8', N'Mỹ thuật', N'25/4')
INSERT [dbo].[NhaXuatBan] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'NXB9', N'Sân khấu', N'25/4')
INSERT [dbo].[PhieuDat] ([MaPD], [MaNV], [NgayNhap]) VALUES (N'PD_2', N'NV1', CAST(0x243F0B00 AS Date))
INSERT [dbo].[PhieuDat] ([MaPD], [MaNV], [NgayNhap]) VALUES (N'PD_3', N'NV1', CAST(0x253F0B00 AS Date))
INSERT [dbo].[PhieuMuon] ([MaPM], [Madocgia], [Ngaymuon], [Ngaytra], [MaNV], [Giahan]) VALUES (N'PM_10', N'maDG_7', CAST(0x76420B00 AS Date), CAST(0x7D420B00 AS Date), N'NV1', NULL)
INSERT [dbo].[PhieuMuon] ([MaPM], [Madocgia], [Ngaymuon], [Ngaytra], [MaNV], [Giahan]) VALUES (N'PM_2', N'maDG_10', CAST(0x76420B00 AS Date), CAST(0x7D420B00 AS Date), N'NV1', NULL)
INSERT [dbo].[PhieuMuon] ([MaPM], [Madocgia], [Ngaymuon], [Ngaytra], [MaNV], [Giahan]) VALUES (N'PM_3', N'maDG_11', CAST(0x81420B00 AS Date), CAST(0x80420B00 AS Date), N'NV1', N'daGH')
INSERT [dbo].[PhieuMuon] ([MaPM], [Madocgia], [Ngaymuon], [Ngaytra], [MaNV], [Giahan]) VALUES (N'PM_4', N'maDG_12', CAST(0x76420B00 AS Date), CAST(0x7D420B00 AS Date), N'NV1', NULL)
INSERT [dbo].[PhieuMuon] ([MaPM], [Madocgia], [Ngaymuon], [Ngaytra], [MaNV], [Giahan]) VALUES (N'PM_5', N'maDG_14', CAST(0x7E420B00 AS Date), CAST(0x80420B00 AS Date), N'NV2', N'daGH')
INSERT [dbo].[PhieuMuon] ([MaPM], [Madocgia], [Ngaymuon], [Ngaytra], [MaNV], [Giahan]) VALUES (N'PM_6', N'maDG_15', CAST(0x76420B00 AS Date), CAST(0x80420B00 AS Date), N'NV1', N'daGH')
INSERT [dbo].[PhieuMuon] ([MaPM], [Madocgia], [Ngaymuon], [Ngaytra], [MaNV], [Giahan]) VALUES (N'PM_7', N'maDG_2', CAST(0x76420B00 AS Date), CAST(0x7D420B00 AS Date), N'NV1', NULL)
INSERT [dbo].[PhieuMuon] ([MaPM], [Madocgia], [Ngaymuon], [Ngaytra], [MaNV], [Giahan]) VALUES (N'PM_8', N'maDG_8', CAST(0x76420B00 AS Date), CAST(0x7D420B00 AS Date), N'NV1', NULL)
INSERT [dbo].[PhieuMuon] ([MaPM], [Madocgia], [Ngaymuon], [Ngaytra], [MaNV], [Giahan]) VALUES (N'PM_9', N'maDG_6', CAST(0x7E420B00 AS Date), CAST(0x7D420B00 AS Date), N'NV1', NULL)
INSERT [dbo].[PhieuThanhLy] ([MaPTL], [MaNV], [NgayThanhLy]) VALUES (N'PTL_1', N'NV3', CAST(0x78420B00 AS Date))
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TheLoai], [NamXB], [MaNXB], [Tinhtrangsach]) VALUES (N'SS_1', N'Học tập cũng cần chiến lược', N'Học tập', N'2002', N'NXB2', N'Mới')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TheLoai], [NamXB], [MaNXB], [Tinhtrangsach]) VALUES (N'SS_10', N'Từ Tốt Đến Vĩ Đại', N'Truyện dài', N'2010', N'NXB1', N'Mới')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TheLoai], [NamXB], [MaNXB], [Tinhtrangsach]) VALUES (N'SS_11', N'Điều Kỳ Diệu', N'Truyện dài', N'2011', N'NXB1', N'Mới')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TheLoai], [NamXB], [MaNXB], [Tinhtrangsach]) VALUES (N'SS_12', N'Cuộc đời của Pi', N'Truyện dài', N'1990', N'NXB1', N'Mới')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TheLoai], [NamXB], [MaNXB], [Tinhtrangsach]) VALUES (N'SS_2', N'Sức mạnh của hiện tại', N'Trinh thám', N'2003', N'NXB1', N'Mới')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TheLoai], [NamXB], [MaNXB], [Tinhtrangsach]) VALUES (N'SS_3', N'Con Chim Xanh Biếc', N'Truyện dài', N'2014', N'NXB1', N'Mới')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TheLoai], [NamXB], [MaNXB], [Tinhtrangsach]) VALUES (N'SS_4', N'Đời Ngắn Đừng Ngủ Dài', N'Truyện dài', N'2019', N'NXB1', N'Mới')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TheLoai], [NamXB], [MaNXB], [Tinhtrangsach]) VALUES (N'SS_5', N'Ngày Xưa Có Một Chuyện Tình', N'Truyện dài', N'2019', N'NXB1', N'Mới')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TheLoai], [NamXB], [MaNXB], [Tinhtrangsach]) VALUES (N'SS_6', N'Trên Đường Băng', N'Truyện dài', N'2007', N'NXB1', N'Mới')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TheLoai], [NamXB], [MaNXB], [Tinhtrangsach]) VALUES (N'SS_7', N'Ngày Xưa Có Một Con Bò', N'Truyện dài', N'1994', N'NXB1', N'Mới')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TheLoai], [NamXB], [MaNXB], [Tinhtrangsach]) VALUES (N'SS_8', N'Cô Gái Đến Từ Hôm Qua', N'Truyện dài', N'2006', N'NXB1', N'Mới')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TheLoai], [NamXB], [MaNXB], [Tinhtrangsach]) VALUES (N'SS_9', N'Thế Giới Phẳng', N'Truyện dài', N'2010', N'NXB1', N'Mới')
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
