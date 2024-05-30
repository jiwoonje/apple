import axios from "axios";
import { Link, useParams, useNavigate, useLocation } from "react-router-dom";
import { useState, useEffect, useContext} from "react";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";
import Button from '../common/Button';
import './Member.css';

function Mypage_update() {

	const { headers, setHeaders } = useContext(HttpHeadersContext);
	const { auth, setAuth } = useContext(AuthContext)
	
	const location = useLocation();
	const navigate = useNavigate();	

	// updateMember 영역	
	const { member } = location.state;
	const [memId, setMemId] = useState(member.memId);
	const [memPw, setMemPw] = useState(member.memPw);
	const [checkMemPw, setCheckMemPw] = useState(member.checkMemPw);
	const changePwd = (event) => {setMemPw(event.target.value);}
	const changeCheckPwd = (event) => {setCheckMemPw(event.target.value);}
	
	// updateInfo 영역
	const { info } = location.state;
	const [infoSeq, setInfoSeq] = useState(info.infoSeq);
	const [infoName, setInfoName] = useState(info.infoName);
	const [infoBirth, setInfoBirth] = useState(info.infoBirth);
	const [infoGender, setInfoGender] = useState(info.infoGender);
	const [infoPhone, setInfoPhone] = useState(info.infoPhone);
	const changeInfoName = (event) => {setInfoName(event.target.value);}
	const changeInfoBirth = (event) => {setInfoBirth(event.target.value);}
	const changeInfoGender = (event) => {setInfoGender(event.target.value);}
	const changeInfoPhone = (event) => {setInfoPhone(event.target.value);}
	
	// updateAddress 영역
	const { address } = location.state;
    const [addrSeq, setAddrSeq] = useState(address.addrSeq);
    const [addrZip, setAddrZip] = useState(address.addrZip);
    const [addrDetail, setAddrDetail] = useState(address.addrDetail);
    const changeAddrZip = (event) => {setAddrZip(event.target.value);};
    const changeAddrDetail = (event) => {setAddrDetail(event.target.value);};

	// updateCard 영역
	const { card } = location.state;
	const [cardSeq, setCardSeq] = useState(card.cardSeq);
    const [cardComp, setCardComp] = useState(card.cardComp);
    const [cardNum, setCardNum] = useState(card.cardNum);
    const [cardDate, setCardDate] = useState(card.cardDate);
    const [cardCvc, setCardCvc] = useState(card.cardCvc);
	const changeCardComp = (event) => {setCardComp(event.target.value);}
	const changeCardNum = (event) => {setCardNum(event.target.value);}
    const changeCardDate = (event) => {setCardDate(event.target.value);}
    const changeCardCvc = (event) => {setCardCvc(event.target.value);}

	const updateMember = async () => {

		const req = {
			memId : memId,
			memPw : memPw, 
			checkMemPw : checkMemPw
		}

		console.log(`Header 값 : ${headers.Authorization}`); 
		console.log(member);
		await axios.patch(`http://localhost:3000/user/${member.memId}`, req, {headers: headers})
		.then((resp) => {
			console.log("[Mypage_update.js] updateMember() success :D");
			console.log(resp.data);

			if (resp.data.updatedRecordCount == 1) {
				alert("회원 정보를 성공적으로 수정했습니다 :D");
				navigate(`/mypage/update/${member.memId}`); // 글 상세로 이동
			}

		})
		.catch((err) => {
			console.log("[Mypage_update.js] updateMember() error :<");
			console.log(err);
		});

	}

	const updateInfo = async () => {

		const req = {
			infoSeq : infoSeq,
			infoName : infoName, 
			infoBirth : infoBirth,
			infoGender : infoGender,
			infoPhone : infoPhone
		}

		console.log(info);

		await axios.patch(`http://localhost:3000/info/${info.infoSeq}`, req)
		.then((resp) => {
			console.log("[Mypage_update.js] updateInfo() success :D");
			console.log(resp.data);

			if (resp.data.updatedRecordCount == 1) {
				alert("회원 개인 정보를 성공적으로 수정했습니다 :D");
				navigate(`/mypage/update/${member.memId}`);
			}

		})
		.catch((err) => {
			console.log("[Mypage_update.js] updateInfo() error :<");
			console.log(err);
		});

	}

	const updateAddress = async () => {
        const req = {
            addrSeq: addrSeq,
            addrZip: addrZip,
            addrDetail: addrDetail,
        };

        console.log(address);
        await axios
            .patch(`http://localhost:3000/address/${address.addrSeq}`, req)
            .then((resp) => {
                console.log("[Mypage_update.js] updateAddress() success :D");
                console.log(resp.data);

                if (resp.data.updatedRecordCount == 1) {
                    alert("주소 정보를 성공적으로 수정했습니다 :D");
                    navigate(`/Mypage_update/${address.addrSeq}`); // 글 상세로 이동
                }
            })
            .catch((err) => {
                console.log("[Mypage_update.js] updateAddress() error :<");
                console.log(err);
            });
    };

	const updateCard = async () => {

		const req = {
			cardSeq : cardSeq,
			cardComp : cardComp, 
			cardNum : cardNum,
            cardDate : cardDate,
            cardCvc : cardCvc
		}

		console.log(card);

		await axios.patch(`http://localhost:3000/card/${card.cardSeq}`, req)
		.then((resp) => {
			console.log("[Mypage_update.js] updateCard() success :D");
			console.log(resp.data);

			if (resp.data.updatedRecordCount == 1) {
				alert("Card 정보를 성공적으로 수정했습니다 :D");
				navigate(`/Mypage_update/${card.cardSeq}`); // 글 상세로 이동
			}

		})
		.catch((err) => {
			console.log("[Mypage_update.js] updateCard() error :<");
			console.log(err);
		});

	}

    return (
		<div>
			<div className="container">
				<div className="mypage_container">
					<div>
						<h1 className="mypage_title">마이페이지 수정</h1>
					</div>
					<div className="d-flex justify-content-between">						
						<div className="mypage_part1 col-6">
							<div>
								<h2 className="mypage_subtitle">계정</h2>
							</div>
							<div className="">
								<table className="mypage_table">
									<tr>
										<th className="mypage_th">회원 ID</th>
										<td className="mypage_td">
											<span className="mypage_view">{memId}</span>
										</td>
									</tr>
								</table>
							</div>
						</div>

						<div className="mypage_part2 col-6">
							<div>
								<h2 className="mypage_subtitle">회원 정보</h2>
							</div>
							<div className="">
								<table className="mypage_table">
									<tr>
										<th className="mypage_th">이름</th>
										<td className="mypage_td">
											<input type="text" className="join_form"
											value={infoName} onChange={changeInfoName} />
										</td>
									</tr>
									<tr>
										<th className="mypage_th">생년월일</th>
										<td className="mypage_td">
											<input type="text" className="join_form"
											value={infoBirth} onChange={changeInfoBirth}/>
										</td>
									</tr>
									<tr>
										<th className="mypage_th">성별</th>
										<td className="mypage_td">
											<input type="text" className="join_form" 
											value={infoGender} onChange={changeInfoGender}/>
										</td>
									</tr>
									<tr>
										<th className="mypage_th">연락처</th>
										<td className="mypage_td">
											<input type="text" className="join_form" 
											value={infoPhone} onChange={changeInfoPhone}/>
										</td>
									</tr>
								</table>
							</div>
							<div className="d-flex justify-content-center">
								<Button size={"default"} color={"blue"} text={"수정하기"}
                            	onClick={updateInfo}></Button>
							</div>
						</div>
					</div>

					<div className="d-flex justify-content-between">
						<div className="mypage_part3 col-6">				
							<div>
								<h2 className="mypage_subtitle">배송지 관리</h2>
							</div>
							<div>
								<table className="mypage_table">
									<tr>
										<th className="mypage_th">이름</th>
										<td className="mypage_td">
											<span className="mypage_view">{info.infoName}</span>
										</td>
									</tr>
									<tr>
										<th className="mypage_th">연락처</th>
										<td className="mypage_td">
											<span className="mypage_view">{info.infoPhone}</span>
										</td>
									</tr>
									<tr>
										<th className="mypage_th">우편번호</th>
										<td className="mypage_td">
											<input type="text" className="join_form" 
											value={addrZip} onChange={changeAddrZip}/>
										</td>
									</tr>
									<tr>
										<th className="mypage_th">주소</th>
										<td className="mypage_td">
											<input type="text" className="join_form" 
											value={addrDetail} onChange={changeAddrDetail}/>
										</td>
									</tr>
								</table>
							</div>
							<div className="d-flex justify-content-center">
								<Button size={"default"} color={"blue"} text={"수정하기"}
                            	onClick={updateAddress}></Button>
							</div>
						</div>

						<div className="mypage_part4 col-6">
							<div>
								<h2 className="mypage_subtitle">결제 관리</h2>
							</div>
							<div>
								<table className="mypage_table">
									<tr>
										<th className="mypage_th">이름</th>
										<td className="mypage_td">
											<span className="mypage_view">{info.infoName}</span>
										</td>
									</tr>
									<tr>
										<th className="mypage_th">카드사</th>									<td className="mypage_td">
											<input type="text" className="join_form" 
											value={cardComp} onChange={changeCardComp}/>
										</td>
									</tr>
									<tr>
										<th className="mypage_th">카드 번호</th>
										<td className="mypage_td">
										<input type="text" className="join_form" 
											value={cardNum} onChange={changeCardNum}/>
										</td>
									</tr>
									<tr>
										<th className="mypage_th">유효 기간</th>
										<td className="mypage_td">
											<input type="text" className="join_form" 
											value={cardDate} onChange={changeCardNum}/>
										</td>
									</tr>
									<tr>
										<th className="mypage_th">CVC 번호</th>
										<td className="mypage_td">
											<input type="text" className="join_form" 
											value={cardCvc} onChange={changeCardCvc}/>
										</td>
									</tr>
								</table>
							</div>
							<div className="d-flex justify-content-center">
								<Button size={"default"} color={"blue"} text={"수정하기"}
                            	onClick={updateCard}></Button>
							</div>
						</div>
					</div>
					<p />
					<div className="d-flex justify-content-center">
					    <Button size={"default"} color={"none"} text={"뒤로가기"} onClick={() => {navigate(-1)}}></Button>
					</div>
				</div>
			</div>
		</div>
	);
    
    }
    
    export default Mypage_update;