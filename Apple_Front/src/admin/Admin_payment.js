import axios from "axios";
import React, { useState, useContext, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import Button from '../common/Button';
import './Admin.css';

function Admin_payment() {

    const [paymentList, setPaymentList] = useState([]);

    const navigate = useNavigate();

    /* payment 전체 조회 */
	const getAllProduct = async () => {

		await axios.get("http://localhost:3000/payment/getAll")
			.then((resp) => {											// 회원가입 성공 시 출력
				console.log("[Mypage_payment.js] findAllPayment() success :D");
				
                console.log(resp.data);
                setPaymentList(resp.data);

			}).catch((err) => {											// 회원가입 실패 시 출력
				console.log("[Mypage_payment.js] findAllPayment() error :<");
				console.log(err);
			});
	}

    useEffect(() => {
        getAllProduct();
	}, []);

    return (
        <div>
            <div className="container">
                <div className="mypage_container">
                    <div>
                        <h1 className="mypage_title">결제 내역</h1>                    
                    </div>
                    <div>
                        <table className="mypage_payment_table">
                            <thead>
                                <th className="mypage_payment_th col-2">결제 번호</th>
                                <th className="mypage_payment_th col-2">결제자</th>
                                <th className="mypage_payment_th col-2">결제일</th>
                                <th className="mypage_payment_th col-2">결제 상태</th>
                            </thead>
                            <tbody>
                                {
                                    paymentList.map (function(payment, idx) {
                                        return(
                                            <TableRow_payment obj={payment} key={idx} cnt={idx+1} />
                                        )
                                    })
                                }
                            </tbody>
                        </table>
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

function TableRow_payment(props) {

    const payment = props.obj;

    return (
        <tr>
            {
            <>
                <td className="product_td">
                    <Link to={{ pathname: `/payment/${payment.paySeq}`}}>
                        <span className="">{payment.paySeq}</span>
                    </Link>
                </td>
                <td className="product_td">{payment.memSeq}</td>
                <td className="product_td">{payment.payDate}</td>
                <td className="product_td">{payment.payStatus}</td>
            </>
            }
        </tr>
    )
}

export default Admin_payment;