import { Link, useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext } from "react";
import { AuthContext } from "../context/AuthProvider";

import Button from "../common/Button";
import "./Admin.css";

function Admin_member_detail() {
    const { auth, setAuth } = useContext(AuthContext);
    const [member, setMember] = useState({});
    const [info, setInfo] = useState([]);
    const [address, setAddress] = useState([]);
    const [card, setCard] = useState([]);
    const { memId } = useParams();

    const navigate = useNavigate();

    /* 회원 1개 조회 */
    const findByIdMember = async () => {
        await axios
            .get(`http://localhost:3000/user/${memId}`, {
                params: { memId: auth ? auth : "" },
            })
            .then((resp) => {
                console.log("[Admin_member_detail.js] findByIdMember() success :D");
                console.log(resp.data);
                setMember(resp.data);
            })
            .catch((err) => {
                console.log("[Admin_member_detail.js] findByIdMember() error :<");
                console.log(err);
            });
    };

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

	/* Card 1개 조회 */
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
        mem_seq: member.memSeq,
        mem_id: member.memId,
        mem_pw: member.memPw,
    };

    const moveUpdate = (event) => {
        navigate(`/admin/member/${memId}`, {
            state: { data: member },
        });
    };

    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">회원 관리</h1>
                    </div>

                    <div className="d-flex justify-content-between">
                        <div className="admin_member_part1 col-6">
                            <div>
                                <h1 className="admin_member_title">계정</h1>
                            </div>
                            <div>
                                <table className="admin_member_table">
                                    <tr>
                                        <th className="admin_member_th">
                                            회원 번호
                                        </th>
                                        <td className="admin_member_td">
                                            <span>{member.memSeq}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">
                                            회원 ID
                                        </th>
                                        <td className="admin_member_td">
                                            <span>{member.memId}</span>
                                        </td>
                                    </tr>
                                    {/* <tr>
                                        <th className="admin_member_th">
                                            비밀번호
                                        </th>
                                        <td className="admin_member_td">
                                            <span>{member.memPw}</span>
                                        </td>
                                    </tr> */}
                                </table>
                            </div>
                        </div>

                        <div className="admin_member_part2 col-6">
                            <div>
                                <h1 className="admin_member_title">
                                    회원 정보
                                </h1>
                            </div>
                            <div>
                                <table className="admin_member_table">
                                    <tr>
                                        <th className="admin_member_th">
                                            이름
                                        </th>
                                        <td className="admin_member_td">
                                            <span className="mypage_view">{info.infoName}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">
                                            생년월일
                                        </th>
                                        <td className="admin_member_td">
                                            <span className="mypage_view">{info.infoBirth}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">
                                            성별
                                        </th>
                                        <td className="admin_member_td">
                                            <span className="mypage_view">{info.infoGender}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">
                                            연락처
                                        </th>
                                        <td className="admin_member_td">
                                            <span className="mypage_view">{info.infoPhone}</span>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div className="d-flex justify-content-between">
                        <div className="admin_member_part3 col-6">
                            <div>
                                <h1 className="admin_member_title">
                                    배송지 관리
                                </h1>
                            </div>
                            <div>
                                <table className="admin_member_table">
                                    <tr>
                                        <th className="admin_member_th">
                                            이름
                                        </th>
                                        <td className="admin_member_td">
                                            <span className="mypage_view">{info.infoName}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">
                                            연락처
                                        </th>
                                        <td className="admin_member_td">
                                            <span className="mypage_view">{info.infoPhone}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">
                                            우편번호
                                        </th>
                                        <td className="admin_member_td">
                                            <span className="mypage_view">{address.addrZip}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">
                                            주소
                                        </th>
                                        <td className="admin_member_td">
                                            <span className="mypage_view">{address.addrDetail}</span>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>

                        <div className="admin_member_part4 col-6">
                            <div>
                                <h1 className="admin_member_title">
                                    결제 관리
                                </h1>
                            </div>
                            <div>
                                <table className="member_table">
                                    <tr>
                                        <th className="admin_member_th">
                                            이름
                                        </th>
                                        <td className="admin_member_td">
                                            <span className="mypage_view">{info.infoName}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">
                                            카드사
                                        </th>
                                        <td className="admin_member_td">
                                            <span className="mypage_view">{card.cardComp}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">
                                            카드 번호
                                        </th>
                                        <td className="admin_member_td">
                                            <span className="mypage_view">{card.cardNum}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">
                                            카드 유효 기간
                                        </th>
                                        <td className="admin_member_td">
                                            <span className="mypage_view">{card.cardDate}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="admin_member_th">
                                            CVC 번호
                                        </th>
                                        <td className="admin_member_td">
                                            <span className="mypage_view">{card.cardCvc}</span>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div className="d-flex justify-content-center">
                        <Button
                            size={"default"}
                            color={"none"}
                            text={"뒤로가기"}
                            onClick={() => {
                                navigate(-1);
                            }}
                        ></Button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Admin_member_detail;
