package net.slipp.common.util;

import javax.servlet.http.HttpSession;

import net.slipp.member.domain.Member;

public class HttpSessionUtil {
	public static final String USER_SESSION_KEY = "sessionedMember";
	
	public static boolean isLoginMember(HttpSession session) {
		Object sessionedMember = session.getAttribute(USER_SESSION_KEY);
		
		if(sessionedMember == null) {
			return false;
		}
		return true;
	}
	
	public static Member getMemberFromSession(HttpSession session) {
		if(!isLoginMember(session)) {
			return null;
		}
		
		return (Member)session.getAttribute(USER_SESSION_KEY); 
	}
}
