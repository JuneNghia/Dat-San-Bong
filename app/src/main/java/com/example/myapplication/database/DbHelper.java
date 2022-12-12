package com.example.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.anychart.chart.common.dataentry.ValueDataEntry;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DbHelper extends SQLiteOpenHelper{
    static final String dbName = "QLSB";
    static final int dbVision = 6;
    public DbHelper(@Nullable Context context) {
        super(context, dbName, null, dbVision);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create_CumSan = "CREATE TABLE CumSan"+
                "(maCumSan INTEGER PRIMARY KEY AUTOINCREMENT , " +
                "chuSan TEXT NOT NULL, " +
                "diaChi TEXT NOT NULL, " +
                "tenCumSan TEXT )";

        db.execSQL(create_CumSan);

        String create_User = "CREATE TABLE User" +
                "(taiKhoan TEXT PRIMARY KEY, " +
                "hoTen TEXT NOT NULL," +
                "matKhau TEXT NOT NULL," +
                "phanQuyen TEXT NOT NULL, " +
                "hinh BLOB )";
        db.execSQL(create_User);


        String create_San = "CREATE TABLE San" +
                "(maSan INTEGER PRIMARY KEY AUTOINCREMENT , " +
                "tenSan TEXT NOT NULL, " +
                "giaSan INTEGER NOT NULL, " +
                "loaiSan INTEGER NOT NULL, " +
                "maCumSan INTEGER NOT NULL ," +
                "anhSan BLOB )";
        db.execSQL(create_San);

        String create_PhieuThue = "CREATE TABLE PhieuThue" +
                "(maPT INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "maSan INTEGER NOT NULL, " +
                "nguoiThue TEXT NOT NULL, " +
                "caThue TEXT NOT NULL, " +
                "ngayThue DATE NOT NULL, " +
                "soKM INTEGER NOT NULL, " +
                "tienSan INTEGER NOT NULL, " +
                "danhGia INTEGER, " +//:0-chưa đánh giá; 1-đã đánh giá
                "sao INTEGER, " +
                "phanHoi TEXT)";// 1-5 sao
        db.execSQL(create_PhieuThue);

        String create_KhuyenMai = "CREATE TABLE KHUYENMAI" +
                "(maID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "soKM INTEGER NOT NULL, " +
                "maSan INTEGER NOT NULL, " +
                "caThue TEXT NOT NULL, "+
                "ngayThue DATE NOT NULL)";
        db.execSQL(create_KhuyenMai);

        String INSERT_User = "Insert into User(taiKhoan,hoTen,matKhau,phanQuyen,hinh) values " +
                "('admin','Admin','nghia','AD',null)," +
                "('0777777777','Tô Trung Kiên','123456','NT',null)," +
                "('0777777771','Lư Gia Phú','123456','NT',null)," +
                "('0777777772','Nguyễn Trần Duy Niên','123456','NT',null)," +
                "('0777777773','Bế Nguyễn Đức Long','123456','NT',null)," +
                "('0777777774','Nguyễn Hữu Khánh','123456','NT',null)," +
                "('0777777775','Lê Hoài Như','123456','NT',null)," +
                "('0777777776','Nguyễn Quốc Tuấn','123456','NT',null)," +
                "('0888888888','Lê Quang Lý Anh','123456','CS',null)," +
                "('0333333333','Nguyễn Hoài Trâm','123456','CS',null)," +
                "('0333333331','Nguyễn Đức Lương','123456','CS',null)," +
                "('0333333332','Văn Vinh Nguyễn','123456','CS',null)," +
                "('0333333334','Nguyễn Ngân Phúc','123456','CS',null)," +
                "('0333333335','Nguyễn Tuấn Quốc','123456','CS',null)," +
                "('0333333336','Nguyễn Văn Nam','123456','CS',null)," +
                "('0555555555','Nguyễn Ngọc Anh','123456','CS',null)";
        db.execSQL(INSERT_User);

        String INSERT_San1 = "Insert into San(tenSan,giaSan,loaiSan, maCumSan, anhSan) values " +
                "('Sân 5A','150000',5, 1,null)," +
                "('Sân 7A','200000',7, 1,null)," +
                "('Sân 5B','150000',5, 1,null)," +
                "('Sân 7B','200000',7, 1,null)," +
                "('Sân 5A','150000',5, 2,null)," +
                "('Sân 7A','200000',7, 2,null)," +
                "('Sân 5A','150000',5, 3,null)," +
                "('Sân 7A','200000',7, 3,null)," +
                "('Sân 5A','250000',5, 4,null)," +
                "('Sân 7A','200000',7, 4,null)," +
                "('Sân 5B','150000',5, 4,null)," +
                "('Sân 7A','200000',7, 5,null)," +
                "('Sân 7B','250000',7, 5,null)," +
                "('Sân 7C','250000',7, 5,null)," +
                "('Sân 5A','150000',5, 6,null)," +
                "('Sân 5B','220000',5, 6,null)," +
                "('Sân 5C','220000',5, 6,null)," +
                "('Sân 7A','220000',7, 9,null)," +
                "('Sân 5A','150000',5, 9,null)," +
                "('Sân 7A','220000',7, 7,null)," +
                "('Sân 5A','150000',5, 10,null)," +
                "('Sân 5B','150000',5, 10,null)," +
                "('Sân 7A','220000',7, 13,null)," +
                "('Sân 7B','220000',7, 13,null)," +
                "('Sân 5A','150000',5, 14,null)," +
                "('Sân 5B','150000',5, 14,null)," +
                "('Sân 5A','150000',5, 11,null)," +
                "('Sân 5A','150000',5, 7,null)";
        db.execSQL(INSERT_San1);

        String INSERT_CumSan = "Insert into CumSan(tenCumSan,diaChi,chuSan) values " +
                "('Trung tâm TDTT Thanh Đa','1017 Bình Quới, Phường 28, Bình Thạnh, Thành phố Hồ Chí Minh','0888888888')," +
                "('Sân Bóng Đá HCA','324 Chu Văn An, Phường 12, Bình Thạnh, Thành phố Hồ Chí Minh','0888888888')," +
                "('Sân Bóng Đá Số 8 CVA','29 Đường Số 8, Phường 26, Bình Thạnh, Thành phố Hồ Chí Minh','0888888822')," +
                "('Sân Bóng Đá Nhân Tạo Hợp Thành','213 Bình Quới, Phường 28, Bình Thạnh, Thành phố Hồ Chí Minh','0333333331')," +
                "('Sân Bóng Mini Đào Duy Anh','21 Đào Duy Anh, Phường 9, Quận Phú Nhuận, Thành phố Hồ Chí Minh','0888888883')," +
                "('Sân Bóng Mini Trần Kế Xương','87A Trần Kế Xương, Phường 7, Quận Phú Nhuận, Thành phố Hồ Chí Minh','0333333331')," +
                "('Sân Bóng Đá King Sport','36 Hoa Sữa, Phường 7, Quận Phú Nhuận, Thành phố Hồ Chí Minh','0888888883')," +
                "('Sân bóng Đá Nhân Tạo P9','Sân cỏ nhân tạo Trường THPT Phú Nhuận, Phường 9, Quận Phú Nhuận, Thành phố Hồ Chí Minh','0888888884')," +
                "('Sân Bóng CLB Quang Tuyến 3','73 Phan Huy Ích, Phường 12, Quận Gò Vấp, Thành phố Hồ Chí Minh,','0888888884')," +
                "('Sân bóng Đá Cây Trâm',' 19 Phạm Văn Chiêu, Phường 9, Quận Gò Vấp, Thành phố Hồ Chí Minh','0888888884')," +
                "('Sân bóng Đá An Hội','256 Phan Huy Ích, Phường 12, Quận Gò Vấp, Thành phố Hồ Chí Minh','0333333336')," +
                "('Sân Bóng Mini Quang Trung','379 Quang Trung, Phường 10, Quận Gò Vấp, Thành phố Hồ Chí Minh','0888888885')," +
                "('Sân Bóng Mười Thọ','VRC2+2MP, Phường Linh Trung, Thành phố Thủ Đức','0333333336')," +
                "('Sân Bóng Đá Milano','VQ7C+Q53, Đường số 12, Phường Linh Trung, Thành phố Thủ Đức,','0888888885')," +
                "('Sân bóng Gò Dưa','Hẻm 54 Đường 36, Linh Đông, Thành phố Thủ Đức','0888888588')";
        db.execSQL(INSERT_CumSan);


        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String ngay = simpleDateFormat.format(now);
        String INSERT_PT = "Insert into PhieuThue(maSan,nguoiThue,caThue,ngayThue,soKM,tienSan, danhGia, sao, phanHoi) values " +
                "(1,'0777777777','1','"+ngay+"',0,150000, 1, 5, 'Giá hợp lí, sân ok')," +
                "(1,'0777777773','2','"+ngay+"',0,200000, 1, 2, 'Mặt sân xấu')," +
                "(1,'0777777777','3','"+ngay+"',0,150000, 1, 5, 'Ok')," +
                "(1,'0777777777','5','"+ngay+"',0,150000, 1, 5, 'Giá rẻ, sân đẹp')," +
                "(2,'0777777777','6','"+ngay+"',0,150000, 1, 5, 'Ok')," +
                "(2,'0777777771','9','"+ngay+"',0,200000, 1, 4, 'Ok')," +
                "(2,'0777777771','10','"+ngay+"',0,150000, 1, 5, 'Ok')," +
                "(2,'0777777771','3','"+ngay+"',0,150000, 1, 2, 'Sân đẹp')," +
                "(3,'0777777774','1','"+ngay+"',0,150000, 1, 5, 'Ok')," +
                "(3,'0777777774','3','"+ngay+"',0,200000, 1, 4, 'Ok')," +
                "(3,'0777777775','6','"+ngay+"',0,150000, 1, 5, 'Ok')," +
                "(3,'0777777775','7','"+ngay+"',0,200000, 1, 4, 'Ok')," +
                "(4,'0777777775','1','"+ngay+"',0,200000, 1, 4, 'Ok')," +
                "(4,'0777777775','3','"+ngay+"',0,200000, 1, 4, 'Ok')," +
                "(4,'0777777775','4','"+ngay+"',0,200000, 1, 4, 'Ok')," +
                "(11,'0777777777','1','24-11-2021',0,150000, 1, 3, 'ok')," +
                "(9,'0777777777','3','29-11-2021',0,200000, 1, 2, 'Ok')," +
                "(9,'0777777777','6','05-12-2021',0,150000, 1, 1, 'Ok')," +
                "(4,'0777777775','6','"+ngay+"',0,200000, 1, 4, 'Ok')";
        db.execSQL(INSERT_PT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists User");
        db.execSQL("drop table if exists San");
        db.execSQL("drop table if exists PhieuThue");
        db.execSQL("drop table if exists CumSan");
        db.execSQL("drop table if exists KhuyenMai");
        onCreate(db);
    }
}
