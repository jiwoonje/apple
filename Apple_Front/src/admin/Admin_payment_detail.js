import { Link, useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext } from "react";
import { AuthContext } from "../context/AuthProvider";

import Button from "../common/Button";
import './Admin.css';

function Admin_payment() {

    const { auth, setAuth } = useContext(AuthContext);

    const navigate = useNavigate();

    const [member, setMember] = useState({});
    const [info, setInfo] = useState([]);
    const [address, setAddress] = useState([]);
    const [payment, setPayment] = useState([]);
    const [paymentProduct, setPaymentProduct] = useState([]);
    const [product, setProduct] = useState([]);
    const [card, setCard] = useState([]);
    const { memId } = useParams();

    /* 회원 1개 조회 */
    const findByIdMember = async () => {
        await axios
            .get(`http://localhost:3000/user/${`himedia`}`, {params: { memId: auth ? auth : "" }})
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
    
	/* payment 1개 조회 */
	const findByIdPayment = async () => {

		await axios.get(`http://localhost:3000/payment/getOnePayment/${1}`, {params : {memId : auth ? auth : ""}})
			.then((resp) => {
				console.log("[Admin_payment_detail.js] findByIdPayment() success :D");
                console.log(resp.data);
                setPayment(resp.data)

			}).catch((err) => {	
				console.log("[Admin_payment_detail.js] findByIdPayment() error :<");
				console.log(err);
			});
	}

    /* product 1개 불러오기 */
    const findByIdProduct = async () => {

		await axios.get(`http://localhost:3000/admin/product/getOne/${`i15b256`}`)
		.then((resp) => {
			console.log("[Admin_product_detail.js] findByIdProduct() success :D");
			console.log(resp.data);
            setProduct(resp.data);

		})
		.catch((err) => {
			console.log("[Admin_product_detail.js] findByIdProduct() error :<");
			console.log(err);
		});
	}

	/* paymentProduct 1개 조회 */
	const findByIdPaymentProduct = async () => {

		await axios.get(`http://localhost:3000/payment/product/${1}`, {params : {memId : auth ? auth : ""}})
			.then((resp) => {
				console.log("[Admin_payment_detail.js] findByIdPaymentProduct() success :D");
                console.log(resp.data);
                setPaymentProduct(resp.data)

			}).catch((err) => {	
				console.log("[Admin_payment_detail.js] findByIdPaymentProduct() error :<");
				console.log(err);
			});
	}

    useEffect(() => {
        findByIdMember();
        findByIdInfo();
		findByIdAddress();
		findByIdCard();
        findByIdPayment();
        findByIdProduct();
        findByIdPaymentProduct();
    }, []);

    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">결제 내역</h1>                    
                    </div>
                    <div className="admin_payment_part">
                        <div className="admin_payment_part1">
                            <div>
                                <h1 className="admin_member_title">회원 정보</h1>  
                            </div>
                            <div>
                                <table className="payment_detail_table">
                                    <tr>
                                        <th className="payment_detail_th">회원 ID</th>
                                        <td className="payment_detail_td">
                                        <span className="mypage_view">{member.memId}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="payment_detail_th">이름</th>
                                        <td className="payment_detail_td">
                                            <span className="mypage_view">{info.infoName}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="payment_detail_th">연락처</th>
                                        <td className="payment_detail_td">
                                            <span className="mypage_view">{info.infoPhone}</span>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>

                        <div className="admin_payment_part1">
                            <div>
                                <h1 className="admin_member_title">배송지 정보</h1>  
                            </div>
                            <div>
                                <table className="payment_detail_table">
                                    <tr>
                                        <th className="payment_detail_th">이름</th>
                                        <td className="payment_detail_td">
                                            <span className="mypage_view">{info.infoName}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="payment_detail_th">연락처</th>
                                        <td className="payment_detail_td">
                                            <span className="mypage_view">{info.infoPhone}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="payment_detail_th">우편번호</th>
                                        <td className="payment_detail_td">
                                            <span className="mypage_view">{address.addrZip}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="payment_detail_th">주소</th>
                                        <td className="payment_detail_td">
                                            <span className="mypage_view">{address.addrDetail}</span>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        
                        <div className="admin_payment_part1">
                            <div>
                                <h1 className="admin_member_title">상품 정보</h1>  
                            </div>
                            <div>
                                <table className="payment_detail_table">
                                    <tr>
                                        <th className="payment_detail_th">결제번호</th>
                                        <td className="payment_detail_td">
                                            <span className="mypage_view">{payment.paySeq}</span>
                                        </td>
                                   </tr>
                                   <tr>
                                        <th className="payment_detail_th">기종</th>
                                        <td className="payment_detail_td">
                                            <span className="mypage_view">{product.prodSeq}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="payment_detail_th">HDD</th>
                                        <td className="payment_detail_td">
                                            <span className="mypage_view">{product.hddSeq}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="payment_detail_th">색상</th>
                                        <td className="payment_detail_td">
                                            <span className="mypage_view">{product.colorSeq}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="payment_detail_th">가격</th>
                                        <td className="payment_detail_td">
                                            <span className="mypage_view">{product.prodPrice}</span>
                                        </td>
                                    </tr>
                                    
                                </table>
                            </div>
                        </div>

                        <div className="admin_payment_part2">
                            <div>
                                <h1 className="admin_member_title">결제 정보</h1> 
                            </div>
                            <div>
                                <table className="payment_detail_table">
                                    <tr>
                                        <th className="payment_detail_th">결제번호</th>
                                        <td className="payment_detail_td">
                                            <span className="mypage_view">{payment.paySeq}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="payment_detail_th">이름</th>
                                        <td className="payment_detail_td">
                                            <span className="mypage_view">{info.infoName}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="payment_detail_th">카드사</th>
                                        <td className="payment_detail_td">
                                            <span className="mypage_view">{card.cardComp}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="payment_detail_th">카드번호</th>
                                        <td className="payment_detail_td">
                                            <span className="mypage_view">{card.cardNum}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th className="payment_detail_th">결제일</th>
                                        <td className="payment_detail_td">
                                            <span className="mypage_view">{payment.payDate}</span>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div className="d-flex justify-content-center">
                        <Button size={"default"} color={"none"} text={"뒤로가기"}
                            onClick={() => {navigate(-1)}}></Button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Admin_payment;