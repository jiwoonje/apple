import axios from "axios";
import { Link, useParams, useNavigate } from "react-router-dom";
import { useState, useEffect, useContext} from "react";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";
import Button from '../common/Button';
import './Member.css';

function Mypage() {
	const { auth, setAuth } = useContext(AuthContext)
    const [member, setMember] = useState([]);
    const [info, setInfo] = useState([]);
    const [address, setAddress] = useState([]);
    const [card, setCard] = useState([]);
    const {memId} = useParams();

	const navigate = useNavigate();	

	/* 회원 1개 조회 */
	const findByIdMember = async () => {

		await axios.get(`http://localhost:3000/user/${memId}`, {params : {memId : auth ? auth : ""}})
			.then((resp) => {
				console.log("[Mypage.js] findByIdMember() success :D");
                console.log(resp.data);
                setMember(resp.data)

			}).catch((err) => {	
				console.log("[Mypage.js] findByIdMember() error :<");
				console.log(err);
			});
	}

	/* Info 1개 조회 */
	const findByIdInfo = async () => {

		await axios.get(`http://localhost:3000/info/${2}`, {params : {memId : auth ? auth : ""}})
			.then((resp) => {
				console.log("[Mypage.js] findByIdInfo() success :D");
                console.log(resp.data);
                setInfo(resp.data)

			}).catch((err) => {	
				console.log("[Mypage.js] findByIdInfo() error :<");
				console.log(err);
			});
	}

	/* Address 1개 조회 */
	const findByIdAddress = async () => {

		await axios.get(`http://localhost:3000/address/${2}`, {params : {memId : auth ? auth : ""}})
			.then((resp) => {
				console.log("[Mypage.js] findByIdAddress() success :D");
                console.log(resp.data);
                setAddress(resp.data)

			}).catch((err) => {	
				console.log("[Mypage.js] findByIdAddress() error :<");
				console.log(err);
			});
	}

	/* Address 1개 조회 */
	const findByIdCard = async () => {

		await axios.get(`http://localhost:3000/card/${2}`, {params : {memId : auth ? auth : ""}})
			.then((resp) => {
				console.log("[Mypage.js] findByIdCard() success :D");
                console.log(resp.data);
                setCard(resp.data)

			}).catch((err) => {	
				console.log("[Mypage.js] findByIdCard() error :<");
				console.log(err);
			});
	}

    useEffect(() => {
		findByIdMember();
		findByIdInfo();
		findByIdAddress();
		findByIdCard();
	}, []);

	const updateMember = {
		memId : member.memId,
		memPw : member.memPw, 
		checkMemPw : member.checkMemPw
	}

	const updateInfo = {
		infoSeq : info.infoSeq,
		infoName : info.infoName, 
		infoBirth : info.infoBirth,
		infoGender : info.infoGender,
		infoPhone : info.infoPhone
	}

	const updateAddress = {
		addrSeq: address.addrSeq,
		addrZip: address.addrZip,
		addrDetail: address.addrDetail,	
	}

	const updateCard = {
		cardSeq : card.cardSeq,
		cardComp : card.cardComp, 
		cardNum : card.cardNum,
		cardDate : card.cardDate,
		cardCvc : card.cardCvc
	}

    return (
		<div>
			<div className="container">
				<div className="mypage_container">
					<div>
						<h1 className="mypage_title">마이페이지</h1>
					</div>
					<div className="d-flex justify-content-between">						
						<div className="col-6">
							<div>
								<h2 className="mypage_subtitle">계정</h2>
							</div>
							<div className="">
								<table className="mypage_table">
									<tr>
										<th className="mypage_th">회원 번호</th>
										<td className="mypage_td">
											<span className="mypage_view">{member.memSeq}</span>
										</td>
									</tr>
									<tr>
										<th className="mypage_th">회원 ID</th>
										<td className="mypage_td">
											<span className="mypage_view">{member.memId}</span>
										</td>
									</tr>
								</table>
							</div>
						</div>

						<div className="col-6 mypage_part2">
							<div>
								<h2 className="mypage_subtitle">회원 정보</h2>
							</div>
							<div className="">
								<table className="mypage_table">
									<tr>
										<th className="mypage_th">이름</th>
										<td className="mypage_td">
											<span className="mypage_view">{info.infoName}</span>
										</td>
									</tr>
									<tr>
										<th className="mypage_th">생년월일</th>
										<td className="mypage_td">
											<span className="mypage_view">{info.infoBirth}</span>
										</td>
									</tr>
									<tr>
										<th className="mypage_th">성별</th>
										<td className="mypage_td">
											<span className="mypage_view">{info.infoGender}</span>
										</td>
									</tr>
									<tr>
										<th className="mypage_th">연락처</th>
										<td className="mypage_td">
											<span className="mypage_view">{info.infoPhone}</span>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</div>

					<div className="d-flex justify-content-between">
						<div className="col-6">				
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
											<span className="mypage_view">{address.addrZip}</span>
										</td>
									</tr>
									<tr>
										<th className="mypage_th">주소</th>
										<td className="mypage_td">
											<span className="mypage_view">{address.addrDetail}</span>
										</td>
									</tr>
								</table>
							</div>
						</div>

						<div className="col-6 mypage_part3">
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
											<span className="mypage_view">{card.cardComp}</span>
										</td>
									</tr>
									<tr>
										<th className="mypage_th">카드 번호</th>
										<td className="mypage_td">
											<span className="mypage_view">{card.cardNum}</span>
										</td>
									</tr>
									<tr>
										<th className="mypage_th">유효 기간</th>
										<td className="mypage_td">
											<span className="mypage_view">{card.cardDate}</span>
										</td>
									</tr>
									<tr>
										<th className="mypage_th">CVC 번호</th>
										<td className="mypage_td">
											<span className="mypage_view">{card.cardCvc}</span>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
					<p />
					<div className="d-flex justify-content-center">
					    <Button size={"default"} color={"none"} text={"뒤로가기"}
							onClick={() => {navigate(-1)}}></Button>
						<Link to="/mypage/update/2"
                            state={{ member: updateMember, info: updateInfo, address: updateAddress, card: updateCard}} >
                            <Button size={"default"} color={"blue"} text={"수정하기"} ></Button>
                        </Link>
					</div>
				</div>
			</div>
		</div>
	);
    
    }
    
    export default Mypage;