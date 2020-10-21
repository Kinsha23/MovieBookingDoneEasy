package com.kinsha.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kinsha.db.BookingDb;
import com.kinsha.emp.EmpDto;

public class StaffDao {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public boolean addStaff(StaffDto dto) {
		boolean flag = false;
		try {
			if (conn == null)
				BookingDb.getBookingDb();
			String sql = "insert into staff (sname, email, pwd ) values (?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getSname());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getEmail());
			if (ps.executeUpdate() > 0)
				flag = true;
		} catch (Exception e) {
			System.out.println("Exception at addStaff : " + e);
		} finally {
			ps = null;
			conn = null;
			return flag;
		}

	}

	public boolean updateStaff(StaffDto dto, int id) {
		boolean flag = false;
		try {
			if (conn == null) {
				conn = BookingDb.getBookingDb();
			}
			String sql = "update staff set sid=?,sname=?,email=? where sid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getSid());
			ps.setString(2, dto.getSname());
			ps.setString(3, dto.getEmail());
			ps.setInt(4, id);
			if (ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("Exception at updateStaff :" + e);
		} finally {
			ps = null;
			conn = null;
			return flag;
		}
	}

	public boolean changePwd(String email, String pwd) {
		boolean flag = false;
		try {
			if (conn == null) {
				conn = BookingDb.getBookingDb();
			}
			String sql = "update staff set pwd=? where email=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pwd);
			ps.setString(2, email);

			if (ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("Exception at changePwd :" + e);
		} finally {
			ps = null;
			conn = null;
			return flag;
		}
	}

	public boolean deleteStaff(int sid) {
		boolean flag = false;
		if (conn == null) {
			conn = BookingDb.getBookingDb();
		}
		try {
			String sql = "delete from staff where sid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sid);
			if (ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("Exception at deleteStaff :" + e);
		} finally {
			ps = null;
			conn = null;
			return flag;
		}
	}

	public StaffDto getStaff(int sid) {
		StaffDto dto = null;
		if (conn == null) {
			conn = BookingDb.getBookingDb();
		}
		try {
			String sql = "select * from staff where sid =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sid);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto = new StaffDto();
				dto.setSid(rs.getInt("sid"));
				dto.setSname(rs.getString("sname"));
				dto.setEmail(rs.getString("email"));
				dto.setPwd(rs.getString("pwd"));
			}
		} catch (Exception e) {
			System.out.println("Exception at getStaff :" + e);
		} finally {
			rs = null;
			ps = null;
			conn = null;
			return dto;
		}
	}

	public ArrayList<StaffDto> getAllStaff() {
		ArrayList<StaffDto> al = new ArrayList<>();
		if (conn == null) {
			conn = BookingDb.getBookingDb();
		}
		try {
			String sql = "select * from staff";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				StaffDto dto = new StaffDto();
				dto.setSid(rs.getInt("sid"));
				dto.setSname(rs.getString("sname"));
				dto.setEmail(rs.getString("email"));
				dto.setPwd(rs.getString("pwd"));
				al.add(dto);
			}
		} catch (Exception e) {
			System.out.println("Exception at getAllStaff :" + e);
		} finally {
			rs = null;
			ps = null;
			conn = null;
			return al;
		}
	}

	public StaffDto staffLogin(String email, String pwd) {
		StaffDto dto = null;
		if (conn == null) {
			conn = BookingDb.getBookingDb();
		}
		try {
			String sql = "select * from staff where email =? && pwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto = new StaffDto();
				dto.setSid(rs.getInt("sid"));
				dto.setSname(rs.getString("sname"));
				dto.setEmail(rs.getString("email"));
				dto.setPwd(rs.getString("pwd"));
			}
		} catch (Exception e) {
			System.out.println("Exception at staffLogin :" + e);
		} finally {
			rs = null;
			ps = null;
			conn = null;
			return dto;
		}
	}

}
