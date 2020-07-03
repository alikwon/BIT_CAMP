package util;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieBox {
	// 쿠키목록을 Map에 저장해서 관리
	private Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();

	public CookieBox(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();

		if (cookies != null && cookies.length > 0) {
			// 쿠키 데이터를 Map에 모두 저장
			for (int i = 0; i < cookies.length; i++) {
				// Map 데이터 저장
				cookieMap.put(cookies[i].getName(), cookies[i]);
			}
		}
	}

	// 쿠키 객체 get --> Map을 통해 get
	public Cookie getCookie(String name) {
		return cookieMap.get(name);
	}

	// 쿠키의 value를 get
	public String getValue(String name) {
		String result = null;
		Cookie cookie = getCookie(name);

		if (cookie != null) {
			result = cookie.getValue();
		}

		return result;
	}

	// 쿠키값이 존재하는지 여부를 확인함
	public boolean exist(String name) {
		return cookieMap.get(name) != null;
	}

	// 쿠키객체 생성 메서드
	public static Cookie createCookie(String name, String value) {
		return new Cookie(name, value);
	}

	public static Cookie createCookie(String name, String value, String path, int maxAge) {
		Cookie cookie = new Cookie(name, value);

		// 경로 설정
		cookie.setPath(path);

		// setMaxAge
		cookie.setMaxAge(maxAge);
		return cookie;
	}

	public static Cookie createCookie(String name, String value, String domain, String path, int maxAge) {
		Cookie cookie = new Cookie(name, value);

		// 도메인 설정
		cookie.setDomain(domain);

		// 경로 설정
		cookie.setPath(path);

		// setMaxAge
		cookie.setMaxAge(maxAge);
		return cookie;
	}
}