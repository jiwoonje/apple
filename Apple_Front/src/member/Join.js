/* 회원가입 컴포넌트 */

import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router";
import Button from '../common/Button';
import './Member.css';

function Join() {

	const [memId, setMemId] = useState("");
	const [memPw, setMemPw] = useState("");
	const [checkMemPw, setCheckMemPw] = useState("");	// 각 변수들을 선언만 하고 초기값은 없는 상태

	const navigate = useNavigate();			// useNavigate를 사용하기 위해 선언 -> 페이지 이동할 때, 사용

	const changeId = (event) => {			// Client에서 id입력하면, 입력한 값 저장
		setMemId(event.target.value);
	}

	const changePwd = (event) => {			// Client에서 pwd입력하면, 입력한 값 저장
		setMemPw(event.target.value);
	}

	const changeCheckPwd = (event) => {		// Client에서 checkpwd입력하면, 입력한 값 저장
		setCheckMemPw(event.target.value);
	}


	// /* 아이디 중복 체크 */
	const checkIdDuplicate = async () => {

		await axios.get("http://localhost:3000/user", { params: { id: memId } })	// axios를 이용해 server로부터 id값 가지고 와서 중복된 id인지 확인
			.then((resp) => {
				console.log("[Join.js] checkIdDuplicate() success :D");
				console.log(resp.data);

				if (resp.status == 200) {								// 중복 ID아니면 출력
					alert("사용 가능한 아이디입니다.");
				}
				
			})
			.catch((err) => {											// 중복 ID일 경우 출력
				console.log("[Join.js] checkIdDuplicate() error :<");
				console.log(err);

				const resp = err.response;
				if (resp.status == 400) {
					alert(resp.data);
				}
			});

	}

	/* 회원가입 */
	const join = async () => {

		const req = {													// req라는 이름의 변수를 객체 형식으로 사용
			memId: memId,
			memPw: memPw,
			checkMemPw: checkMemPw
		}

		await axios.post("http://localhost:3000/user/join", req)		// req라는 객체를 서버에 전달해서 회원가입 진행
			.then((resp) => {											// 회원가입 성공 시 출력
				console.log("[Join.js] join() success :D");
				console.log(resp.data);

				alert(resp.data.memId + "님 회원가입을 축하드립니다 🎊");
				navigate("/login");

			}).catch((err) => {											// 회원가입 실패 시 출력
				console.log("[Join.js] join() error :<");
				console.log(err);

				// alert(err.response.data);

				const resp = err.response;
				if (resp.status == 400) {
					alert(resp.data);
				}
			});
	}


	return (
		<div>
			<div className="container">
				<div className="member_container">
					<div>
					<h1 className="member_title">회원가입</h1>
					</div>
					<div className="d-flex justify-content-center">
						<table className="join_table">
	
							<tr>
								<th className="join_th">아이디</th>
								<td className="join_td">
									<input type="text" className="join_form" onChange={changeId}/>
								</td>
								<td className="join_td2">
									<Button size={"xsmall"} color={"red"} text={"중복확인"} onClick={checkIdDuplicate}></Button>			{/* id 값을 넣고, changeId라는 Event를 발생시킨다. -> 아이디 값이 입력한 것에 따라 바뀐다. */}
								</td>
							</tr>
							<tr>
								<th className="join_th">비밀번호</th>
								<td className="join_td">
									<input type="password" className="join_form" onChange={changePwd} />									{/* pwd값을 넣고, changePwd라는 Event를 발생시킨다. */}
								</td>
							</tr>
							<tr>
								<th className="join_th">비밀번호 확인</th>
								<td className="join_td">
									<input type="password" className="join_form" onChange={changeCheckPwd} />						{/* checkPwd값을 넣고, changeCheckPwd라는 Event를 발생시킨다. */}
								</td>
							</tr>

						</table><br />
					</div>
					<div className="d-flex justify-content-center">
					    <Button size={"default"} color={"none"} text={"뒤로가기"}
							onClick={() => {navigate(-1)}}></Button>
						<Button size={"default"} color={"blue"} text={"가입하기"} onClick={join}></Button>		{/* 값을 전부 입력하고 버튼을 누르면, join이라는 함수를 실행한다. */}
					</div>
				</div>

			</div>

		</div>
	);
}

export default Join;	// Join component를 외부의 다른 component가 사용할 수 있도록 설정