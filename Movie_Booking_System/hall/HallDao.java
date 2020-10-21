package com.kinsha.hall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kinsha.db.BookingDb;

public class HallDao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public Boolean addHall(HallDto dto) {
		boolean flag = false;
		try {
			if (conn == null)
				BookingDb.getBookingDb();
			String sql = "insert into hall (hname, location) values (?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getHname());
			ps.setString(2, dto.getLocation());
			if (ps.executeUpdate() > 0)
				flag = true;
		} catch (Exception e) {
			System.out.println("Exception at addHall : " + e);
		} finally {
			ps = null;
			conn = null;
			return flag;
		}
	}

	public boolean updateHall(HallDto dto, int id) {
		boolean flag = false;
		try {
			if (conn == null) {
				conn = BookingDb.getBookingDb();
			}
			String sql = "update hall set hid=?,hname=?,location=? where hid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getHid());
			ps.setString(2, dto.getHname());
			ps.setString(3, dto.getLocation());
			ps.setInt(4, id);
			if (ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("Exception at updateHall :" + e);
		} finally {
			ps = null;
			conn = null;
			return flag;
		}
	}

	public boolean deleteHid(int hid) {
		boolean flag = false;
		if (conn == null) {
			conn = BookingDb.getBookingDb();
		}
		try {
			String sql = "delete from hall where hid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hid);
			if (ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("Exception at deleteHall :" + e);
		} finally {
			ps = null;
			conn = null;
			return flag;
		}
	}

	public HallDto getHall(int hid) {
		HallDto dto = null;
		if (conn == null) {
			conn = BookingDb.getBookingDb();
		}
		try {
			String sql = "select * from hall where hid =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hid);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto = new HallDto();
				dto.setHid(rs.getInt("hid"));
				dto.setHname(rs.getString("hname"));
				dto.setLocation(rs.getString("location"));
			}
		} catch (Exception e) {
			System.out.println("Exception at getHall :" + e);
		} finally {
			rs = null;
			ps = null;
			conn = null;
			return dto;
		}
	}

	public ArrayList<HallDto> getAllHall() {
		ArrayList<HallDto> al = new ArrayList<>();
		if (conn == null) {
			conn = BookingDb.getBookingDb();
		}
		try {
			String sql = "select * from hall";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				HallDto dto = new HallDto();
				dto.setHid(rs.getInt("hid"));
				dto.setHname(rs.getString("hname"));
				dto.setLocation(rs.getString("location"));
				al.add(dto);
			}
		} catch (Exception e) {
			System.out.println("Exception at getAllHall :" + e);
		} finally {
			rs = null;
			ps = null;
			conn = null;
			return al;
		}
	}

}
