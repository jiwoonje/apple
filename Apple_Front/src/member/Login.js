/* 로그인 컴포넌트 */

import axios from "axios";
import React, { useState, useContext } from "react";
import { useNavigate } from 'react-router-dom';
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";
import Button from '../common/Button';
import './Member.css';

function Login() {

	const { auth, setAuth } = useContext(AuthContext);				// 초기값이 AuthContext(user의 정보가 있는 파일)인 useContext생성
	const { headers, setHeaders } = useContext(HttpHeadersContext);	// 초기값이 HttpHeadersContext(user의 JWT가 있는 파일)인 useContext생성

	const navigate = useNavigate();		// useNavigate를 사용하기 위해 선언 -> 페이지 이동할 때, 사용

	const [memId, setMemId] = useState("");
	const [memPw, setMemPw] = useState("");	// Login에 사용할 변수들 선언

	const changeId = (event) => {		// Client에서 id입력하면, 입력한 값 저장
		setMemId(event.target.value);
	}

	const changePwd = (event) => {		// Client에서 pwd입력하면, 입력한 값 저장
		setMemPw(event.target.value);
	}

	const login = async () => {

		const req = {					// login에 사용할 data들을 하나의 객체로 만든 것
			memId: memId,
			memPw: memPw
		}

		await axios.post("http://localhost:3000/user/login", req)	// Server에 만든 객체를 전달해서 login method 처리
		.then((resp) => {											// Login 성공 시 출력
			console.log("[Login.js] login() success :D");
			console.log(resp.data);

				alert(resp.data.memId + "님, 성공적으로 로그인 되었습니다 🔐");
				console.log(resp.data.memId);

				// JWT 토큰 저장
				localStorage.setItem("apple_access_token", resp.data.jwt);
				localStorage.setItem("mem_id", resp.data.memId);

				setAuth(resp.data.memId); // 사용자 인증 정보(아이디 저장)
				setHeaders({"Authorization": `Bearer ${resp.data.jwt}`}); // 헤더 Authorization 필드 저장

				navigate("/");
			

		}).catch((err) => {											// Login 실패 시 출력
			console.log("[Login.js] login() error :<");
			console.log(err);

			alert("⚠️ " + err.response.data);
		});
	}

	return (
		<div>
			<div className="container">
				<div className="member_container">
					<div>
                        <h1 className="member_title">로그인</h1>
                    </div>
					<div className="d-flex justify-content-center">
						<table className="login_table">
							<tr className="login_tr">
								<th className="login_th">아이디</th>
								<td className="login_td">
									<input type="text" className="login_form" onChange={changeId} />	{/* id 값을 넣고, changeId라는 Event를 발생시킨다. */}
								</td>
							</tr>
							<tr className="login_tr">
								<th className="login_th">비밀번호</th>
								<td className="login_td">
									<input type="password" className="login_form" onChange={changePwd}/>	{/* pwd 값을 넣고, changePwd라는 Event를 발생시킨다. */}
								</td>
							</tr>
							</table>
					</div>
					<div className="d-flex justify-content-center">
						<Button size={"default"} color={"none"} text={"회원가입"}
							onClick={() => {navigate('/join')}}></Button>	
                        <Button size={"default"} color={"blue"} text={"로그인"} onClick={login}></Button>	{/*값을 전부 입력하고 버튼을 누르면, login이라는 함수를 실행한다.*/}
					</div>
				</div>
			</div>
		</div>
	);
}

export default Login;