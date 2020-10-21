package com.kinsha.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.kinsha.db.BookingDb;

public class EmpDao {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public boolean addEmp(EmpDto dto) {
		boolean flag = false;
		try {
			if (conn == null) {
				conn = BookingDb.getBookingDb();
			}
			String sql = "insert into emp (eid, ename, email) values (?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getEid());
			ps.setString(2, dto.getEname());
			ps.setString(3, dto.getEmail());
			if (ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("Exception at addEmp : " + e);
		} finally {
			ps = null;
			conn = null;
			return flag;
		}
	}

	public boolean updateEmp(EmpDto dto, int id) {
		boolean flag = false;
		try {
			if (conn == null) {
				conn = BookingDb.getBookingDb();
			}
			String sql = "update emp set eid = ?,ename=?,email=? where eid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getEid());
			ps.setString(2, dto.getEname());
			ps.setString(3, dto.getEmail());
			ps.setInt(4, id);
			if (ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("Exception at updateEmp :" + e);
		} finally {
			ps = null;
			conn = null;
			return flag;
		}
	}

	public boolean deleteEmp(int eid) {
		boolean flag = false;
		if (conn == null) {
			conn = BookingDb.getBookingDb();
		}
		try {
			String sql = "delete from emp where eid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, eid);
			if (ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("Exception at deleteEmp :" + e);
		} finally {
			ps = null;
			conn = null;
			return flag;
		}
	}

	public ArrayList<EmpDto> getAllEmp() {
		ArrayList<EmpDto> al = new ArrayList<>();
		if (conn == null) {
			conn = BookingDb.getBookingDb();
		}
		try {
			String sql = "select * from emp";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				EmpDto dto = new EmpDto();
				dto.setEid(rs.getInt("eid"));
				dto.setEname(rs.getString("ename"));
				dto.setEmail(rs.getString("email"));
				al.add(dto);
			}
		} catch (Exception e) {
			System.out.println("Exception at getAllEmp :" + e);
		} finally {
			rs = null;
			ps = null;
			conn = null;
			return al;
		}
	}

	public EmpDto getEmp(int eid) {
		EmpDto dto = null;
		if (conn == null) {
			conn = BookingDb.getBookingDb();
		}
		try {
			String sql = "select * from emp where eid =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, eid);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto = new EmpDto();
				dto.setEid(rs.getInt("eid"));
				dto.setEname(rs.getString("ename"));
				dto.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			System.out.println("Exception at getEmp :" + e);
		} finally {
			rs = null;
			ps = null;
			conn = null;
			return dto;
		}
	}

	public EmpDto empLogin(int eid, String pwd) {
		EmpDto dto = null;
		if (conn == null) {
			conn = BookingDb.getBookingDb();
		}
		try {
			String sql = "select * from emp where eid=? and pwd=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, eid);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto = new EmpDto();
				dto.setEid(rs.getInt("eid"));
				dto.setEname(rs.getString("ename"));
				dto.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			System.out.println("Exception at empLogin :" + e);
		} finally {
			rs = null;
			ps = null;
			conn = null;
			return dto;
		}
	}

	

}
