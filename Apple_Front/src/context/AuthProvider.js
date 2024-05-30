import { createContext, useState } from "react"; // React에서 제공하는 기능들 중 useState(Hook)와 createContext를 사용한다는 것을 명시

export const AuthContext = createContext(); // AuthContext라는 이름으로 createContext를 사용하겠다고 선언하고, export가능하게 설정한다.

function AuthProvider({ children }) {	// AuthProvider라는 Component가 어떻게 동작할지 명시 - 이 때, children prop을 사용한다.

	const [auth, setAuth] = useState(localStorage.getItem("memId"));	// localStorage.getItem("id")를 초기값으로 사용하고, 상수형식으로 auth와 setAuth함수를 useState를 사용하여 만든다.

	const value = {auth, setAuth };	// value라는 변수에 아까 생성한 auth와 setAuth를 객체형식으로 저장한다.


	return (	// 실제 화면에 return 시켜주는 영역
		<AuthContext.Provider value = {value}>	{/*AuthContext에 value를 이용해 요청한다.*/}
			{children}							{/*여러 가지가 섞인 데이터를 전달*/}
		</AuthContext.Provider>
	);

}

export default AuthProvider; // AuthProvider Component에서 default 방식으로 값을 내보낸다.