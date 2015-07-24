package com.microframework.solrcloud.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolrDB {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public static int getDataCount(){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/kaifn","root","mazip");
		
			String sql = "select count(1) as ct from tbl_fang_copy1";

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		
			while (rs.next()) {
				count = rs.getInt("ct");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (!rs.isClosed()) {
					rs.close();
				}
				if (!ps.isClosed()) {
					ps.close();
				}
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return count;

		
	}
	
	
	public static List<FangData> getdata(int page) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FangData> fangs = new ArrayList<FangData>();
		try {
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/kaifn","root","mazip");
			String sql = "select * from tbl_fang_copy1 limit ?,?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, page * 100000);
			ps.setInt(2, (page + 1) * 100000);

			rs = ps.executeQuery();

			while (rs.next()) {
				FangData fd = new FangData();

				fd.setName(rs.getString("Name"));
				fd.setCardNo(rs.getString("CardNo"));
				fd.setDescriot(rs.getString("Descriot"));
				fd.setCtftp(rs.getString("ctftp"));
				fd.setCtfid(rs.getString("ctfid"));
				fd.setGender(rs.getString("gender"));
				fd.setBirthday(rs.getString("birthday"));
				fd.setAddress(rs.getString("address"));
				fd.setZip(rs.getString("zip"));
				fd.setDirty(rs.getString("dirty"));
				fd.setDistrict1(rs.getString("district1"));
				fd.setDistrict2(rs.getString("district2"));
				fd.setDistrict3(rs.getString("district3"));
				fd.setDistrict4(rs.getString("district4"));
				fd.setDistrict5(rs.getString("district5"));
				fd.setDistrict6(rs.getString("district6"));
				fd.setFirstnm(rs.getString("firstnm"));
				fd.setLastnm(rs.getString("lastnm"));
				fd.setDuty(rs.getString("duty"));
				fd.setMobile(rs.getString("mobile"));
				fd.setTel(rs.getString("tel"));
				fd.setFax(rs.getString("fax"));
				fd.setEmail(rs.getString("email"));
				fd.setNation(rs.getString("nation"));
				fd.setTeste(rs.getString("teste"));
				fd.setEducation(rs.getString("education"));
				fd.setCompany(rs.getString("company"));
				fd.setCtel(rs.getString("ctel"));
				fd.setCaddress(rs.getString("caddress"));
				fd.setCzip(rs.getString("czip"));
				fd.setFamily(rs.getString("family"));
				fd.setVersion(rs.getString("version"));
				fd.setId(rs.getString("id"));

				fangs.add(fd);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (!rs.isClosed()) {
					rs.close();
				}
				if (!ps.isClosed()) {
					ps.close();
				}
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return fangs;

	}

}
