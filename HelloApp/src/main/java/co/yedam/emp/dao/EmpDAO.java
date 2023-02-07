package co.yedam.emp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.yedam.common.DAO;
import co.yedam.emp.vo.EmpVO;

public class EmpDAO extends DAO {
	// 싱글톤 방식. 생성자:private, 메소드:public getInstance 
	private static EmpDAO instance = new EmpDAO();
	
	private EmpDAO() {		
	}
	
	public static EmpDAO getInstance() {
		return instance;
	}
	
	//삭제하기 0206 3교시
	public int deleteEmp(int emp) {
		connect();
		sql = "delete emp_temp where employee_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp);
			int r = psmt.executeUpdate(); //처리된 건수반환.
			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconn();
		}
		return 0;
	}

	
	//수정처리 0206 2교시
	public int updateEmp(EmpVO emp) {
		System.out.println(emp);
		connect();
		sql = "update emp_temp set first_name=?, last_name=?,"
				+ "email=?, job_id=?, hire_date=? where employee_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,  emp.getFirstName());
			psmt.setString(2, emp.getLastName());
			psmt.setString(3, emp.getEmail());
			psmt.setString(4, emp.getJobId());
			psmt.setString(5, emp.getHireDate());
			psmt.setInt(6, emp.getEmployeeId());
			int r = psmt.executeUpdate(); //처리된 건수반환.
			return r;
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			disconn();
		}
		return 0;
	}
	
	//직무 리스트 0206 1교시
	public Map<String, String> jobList() {
		Map<String, String> jobs = new HashMap<String, String>();
		connect();
		sql = "select job_id, job_title from jobs "
				+ " order by job_id";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				jobs.put(rs.getString("job_id"), rs.getString("job_title"));
							}
		} catch (SQLException e) {		
			e.printStackTrace();
		} finally {
			disconn();
		}
		return jobs;
	}
	
	//한건조회.
	public EmpVO searchEmp(int empId) {
		connect();
		sql = "select * from emp_temp where employee_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			rs= psmt.executeQuery();
			if (rs.next()) {
				EmpVO emp = new EmpVO();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setJobId(rs.getString("job_id"));
				emp.setHireDate(rs.getString("hire_date"));
				
				return emp;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null;
	}
	
	
	//한건입력.
	public int insertEmp(EmpVO emp) {
		connect();
		sql = "insert into emp_temp(employee_id, last_name, email, hire_date, job_id) values(?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,  emp.getEmployeeId());
			psmt.setString(2,  emp.getLastName());
			psmt.setString(3, emp.getEmail());
			psmt.setString(4, emp.getHireDate());
			psmt.setString(5, emp.getJobId());
			
			int r = psmt.executeUpdate(); //에러가 안 나면 1이라는 값이 반환. 에러나면 캐치구문으로
			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconn();
		}
		return 0;	//한 건도 처리 안 됐을 때 0이 뜨게
	}
	
	
	// 목록조회기능.
	public List<EmpVO> empList() {
		List<EmpVO> emps = new ArrayList<>();
		connect();
		sql = "select * from emp_temp order by employee_id";
		// psmt : 쿼리실행 & 실행결과를 반환.
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				EmpVO emp = new EmpVO();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setJobId(rs.getString("job_id"));
				emp.setHireDate(rs.getString("hire_date"));

				emps.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return emps;
	}
}
