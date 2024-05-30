import { createContext, useState } from "react";	// React에서 제공하는 기능들 중 useState(Hook)와 createContext를 사용한다는 것을 명시

export const HttpHeadersContext = createContext();	// HttpHeadersContext라는 이름으로 createContext를 사용하겠다고 선언하고, export가능하게 설정한다.

function HttpHeadersProvider({ children })			// HttpHeadersProvider라는 Component가 어떻게 동작할지 명시 - 이 때, children prop을 사용한다.
{

	const [headers, setHeaders] = useState({		// 상수형식으로 headers와 setHeaders함수를 useState를 사용하여 만든다.
		"Authorization":`Bearer ${localStorage.getItem("bbs_access_token")}` // 새로고침하면 App Context 사라지기 때문에, 초기 값은 LocalStorage 값으로 세팅
	});

	const value = {headers, setHeaders};			// value라는 변수에 아까 생성한 headers와 setHeaders를 객체형식으로 저장한다.

	return (										// 실제 화면에 return 시켜주는 영역
		<HttpHeadersContext.Provider value = {value}>	{/*HttpHeadersContext에 value를 이용해 요청한다.*/}
			{children}									{/*여러 가지가 섞인 데이터를 전달*/}
		</HttpHeadersContext.Provider>
	);

}

export default HttpHeadersProvider;	// HttpHeadersProvider Component에서 default 방식으로 값을 내보낸다.