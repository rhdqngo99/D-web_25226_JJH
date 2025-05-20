package product;

import java.util.List;

public class ProductService implements ProductServiceInterface{
	//controller <-> service <-> DAO <-> DB
	
	// DAOInterface 연결후 생성자에서 객체 생성
	private ProductDAOInterface dao;
	
	public ProductService() {
		dao = new ProductDAO(); // 구현체
	}
	
	// 컨트롤러에서 오는 처리를 맡아서 함.
	
	@Override
	public int insert(Product p) {
		// 만약 객체의 테이블이 나누어 지면 여기서 분리(각자 DAO에게 요청)
		System.out.println("insert productService in");
		return dao.insert(p);
	}

	@Override
	public List<Product> getList() {
		// TODO Auto-generated method stub
		return dao.getList();
	}

	@Override
	public Product getDetail(int pno) {
		// TODO Auto-generated method stub
		return dao.getDetail(pno);
	}
	
	@Override
	public int modify(Product p) {
		// TODO Auto-generated method stub
		return dao.modify(p);
	}

	@Override
	public int remove(int pno) {
		// TODO Auto-generated method stub
		return dao.remove(pno);
	}
	
}
