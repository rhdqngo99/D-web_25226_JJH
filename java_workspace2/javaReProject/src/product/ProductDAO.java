package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements ProductDAOInterface{
	// DAO <-> DBconnect
	
	//DB 연결 객체
	private Connection conn;
	// sql 쿼리 저장 스트링
	private String query="";
	// sql 구문을 실행시키는 기능을 하는 객체
	private PreparedStatement pst;
	
	public ProductDAO() {
		// DBconnect class 생성 (싱글톤)
		DatabaseConnect dbc = DatabaseConnect.getInstance();
		conn = dbc.geConnection();
	}

	@Override
	public int insert(Product p) {
		// product 객체 DB에 등록
		query = "insert into product(pname, price, madeby) values (?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			// insert, update, delete => executeUpdate() return (처리된 개수)
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("insert 구문 에러");
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public List<Product> getList() {
		
		query = "select * from product order by pno desc";
		List<Product> list = new ArrayList<>();
		
		try {
			pst = conn.prepareStatement(query);
			// select 구문은 리턴되는 리스트가 있음.
			// select => executeQuery() => return ResultSet
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				list.add(new Product(
						rs.getInt("pno"),
						rs.getString("pname"),
						rs.getInt("price"),
						rs.getString("regdate"),
						rs.getString("madeby")));
				}
			return list;
			
		}catch (SQLException e) {
				// TODO: handle exception
			System.out.println("selet 구문 에러");
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Override
	public Product getDetail(int pno) {
		
		query = "select * from product where pno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return new Product(
						rs.getInt("pno"),
						rs.getString("pname"),
						rs.getInt("price"),
						rs.getString("regdate"),
						rs.getString("madeby"));
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("detail 구문 에러");
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int modify(Product p) {

		query = "update product set pname=?, price=?,"
				+ "madeby=?, regdate=now() where pno=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			pst.setInt(4, p.getPno());
			
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("update 구문 에러");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public int remove(int pno) {
		
		query = "delete from product where pno = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("delete 구문 에러");
			e.printStackTrace();
		}
		return 0;
	}
	
}
