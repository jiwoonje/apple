import { useEffect, useContext } from "react";
import { useNavigate } from "react-router";
import { AuthContext } from "../context/AuthProvider";

function Logout() {

	const { auth, setAuth } = useContext(AuthContext);			// AuthContext라는 값을 초기값으로 가진 useContext 생성

	const navigate = useNavigate();								// useNavigate 선언
	
	const logout = () => {										// logout이라는 함수 실행
		alert(auth + "님, 성공적으로 로그아웃 됐습니다 🔒");
		localStorage.removeItem("apple_access_token");			// localStorage에 있는 bbs_access_token이라는 값 제거
		localStorage.removeItem("mem_id");							// localStorage에 있는 id라는 값 제거

		
		setAuth(null);											// Auth값을 null로 설정 = 인증된 사용자 정보 없음
		
		navigate("/");											// 메인 페이지로 이동
	};

	useEffect(() => {
		// Include logout in the dependency array since it's used inside useEffect
		logout();
	}, [logout]); // Add logout to the dependency array

	// Ensure to return some JSX if needed
	return null;
}

export default Logout;
