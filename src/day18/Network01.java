package day18;

import java.net.InetAddress;
import java.net.URL;

public class Network01 {

	public static void main(String[] args) {
		/* 인터넷 주소의 정보를 확인하는 방법
		 * 
		 * */
		InetAddress ip = null;
		try {
			
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("HostAddress > "+ip.getHostAddress());
			System.out.println("HostNames > "+ip.getHostName());
			
			URL url = new URL("https://n.news.naver.com/mnews/article/001/0015283675?rc=N&ntype=RANKING");
			System.out.println(url.getContent());
			System.out.println(url.getAuthority());
			System.out.println(url.getDefaultPort());
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getQuery()); // ? 정보
			System.out.println(url.getPath()); // /경로
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}